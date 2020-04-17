package MachineLearning;

import java.util.ArrayList;
import java.lang.Math;

public class TestAccuracy 
{
	public static ArrayList<PatientInfo> fullList = new ArrayList<PatientInfo>();
	public static ArrayList<PatientInfo> testList = new ArrayList<PatientInfo>();
	
	
		private float Correct;
		
		
		public TestAccuracy() 
		{
			
		}

		
		public void findAccuracy()
		{
			
			setCorrect(0);
			
			FileProcessing findAccuracy = new FileProcessing(Control.getCsvFile());
			
			findAccuracy.openFile();
			
			findAccuracy.readFile();
				 
			fullList = findAccuracy.getSymptomsList();
			
			float size = fullList.size() - Math.round(fullList.size() * .70) ;
			
			
			float size2 = fullList.size() - size;
			
			
			for(int i=(int)size; i<size2; i++)
			{
				
				Probability prob = new Probability(fullList.get(i).getTemperature(), fullList.get(i).getAches(), fullList.get(i).getSoreThroat(), fullList.get((int) i).getCough(), fullList.get(i).getTravelFromDZ());
			
				prob.count();
				
			}
			
			for(int i = 0; i<size; i++)
			{
				testList.add(fullList.get(i));
			}
			
			
			for(int i = 0; i<size; i++)
			{
				
				Probability prob = new Probability(testList.get(i).getTemperature(), testList.get(i).getAches(), testList.get(i).getSoreThroat(), testList.get(i).getCough(), testList.get(i).getTravelFromDZ());
			
				prob.findProb();
			
				if(prob.getAnswer() > 49 & testList.get(i).getHasCOVID19().equals("yes"))
				{
					Correct++;	
				}
				else if(prob.getAnswer() < 49 & testList.get(i).getHasCOVID19().equals("no"))
				{
					Correct++;
				}
			}
			
			Correct = Correct/(float)testList.size()*100;
			
			Correct = Math.round(Correct);
			
			testList.clear();
			fullList.clear();
			
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

		
	
}//End class
