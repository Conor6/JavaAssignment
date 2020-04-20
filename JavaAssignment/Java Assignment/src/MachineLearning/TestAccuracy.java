package MachineLearning;

/* Test Accuracy
 * This class has one method findAccuracy()
 * 
 * This method is used to test the accuracy of the program. This is done by using 70% of the data
 * to test 30% of it. The number of correct predictions are counted in the variable Counter.
 * Counter is then divided by the size of the test data and multiplied by 100, this is to get a percentage
 * 
 * 
 * Author:   Conor Flood
 * 
 * Compiler: Eclipse IDE
 * 
 */


import java.util.ArrayList;
import java.lang.Math;

public class TestAccuracy 
{
	private static ArrayList<PatientInfo> fullList = new ArrayList<PatientInfo>();		//This is the arrayList with all the data from the file
	private static ArrayList<PatientInfo> testList = new ArrayList<PatientInfo>();		//This is the arrayList with 30% of the data
	private float Correct;																//This counts the amout of correct guesses there are
		
	
	
		//Constructor
		public TestAccuracy() 
		{

		}

		
		//Method to calculate the accuracy of the program
		public void findAccuracy()
		{
			
			setCorrect(0); //Resetting correct counter
			
			FileProcessing findAccuracy = new FileProcessing(Control.getCsvFile()); //Creating a new FileProcessing object
			
			findAccuracy.openFile();	//Openeing the file
			
			findAccuracy.readFile();	//Filling the file with data
				 
			fullList = findAccuracy.getSymptomsList();	//Copying the data from Symptom list into full list
			
			float testListSize = fullList.size() - Math.round(fullList.size() * .70) ;	//Calculating what the size of the test list will be
			
			
			float trainingDataSize = fullList.size() - testListSize;	//Calculating the size of the 
			
			
			//Calculate the probability for 30%
			for(int i=(int)testListSize; i<trainingDataSize; i++)
			{
				
				Probability prob = new Probability(fullList.get(i).getTemperature(), fullList.get(i).getAches(), fullList.get(i).getSoreThroat(), fullList.get((int) i).getCough(), fullList.get(i).getTravelFromDZ());
			
				prob.count();
				
			}
			
			//Only adds 30% of the data
			for(int i = 0; i<testListSize; i++)
			{
				testList.add(fullList.get(i));
			}
			
			
			for(int i = 0; i<testListSize; i++)
			{
				
				Probability prob = new Probability(testList.get(i).getTemperature(), testList.get(i).getAches(), testList.get(i).getSoreThroat(), testList.get(i).getCough(), testList.get(i).getTravelFromDZ());
			
				prob.findProb();
			
				if(prob.getAnswer() >= 50 & testList.get(i).getHasCOVID19().equals("yes"))
				{
					Correct++;	
				}
				else if(prob.getAnswer() <= 50 & testList.get(i).getHasCOVID19().equals("no"))
				{
					Correct++;
				}
			}
			
			Correct = Correct/(float)testList.size()*100;
			
			Correct = Math.round(Correct);
			
			testList.clear();	//Empties the arrayList
			fullList.clear();	//Empties the arrayList
			
		}//End findAccuracy()


		//Getters and Setters
		float getCorrect() 
		{
			return Correct;
		}


		void setCorrect(float correct) 
		{
			Correct = correct;
		}


		public static ArrayList<PatientInfo> getFullList() 
		{
			return fullList;
		}


		public static void setFullList(ArrayList<PatientInfo> fullList) 
		{
			TestAccuracy.fullList = fullList;
		}


		public static ArrayList<PatientInfo> getTestList() 
		{
			return testList;
		}


		public static void setTestList(ArrayList<PatientInfo> testList) {
			TestAccuracy.testList = testList;
		}

		
	
}//End class
