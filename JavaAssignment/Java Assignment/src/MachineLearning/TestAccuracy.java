package MachineLearning;

import java.util.ArrayList;
import java.lang.Math;

public class TestAccuracy 
{
	public static ArrayList<PatientInfo> fullList = new ArrayList<PatientInfo>();
	public static ArrayList<PatientInfo> testList = new ArrayList<PatientInfo>();
	
	//Temperature Attributes
		private float tempY = 0;
		private float tempN = 0;
		private float temperatureCool = 0;
		private float temperatureNorm = 0;
		private float temperatureHot = 0;
		private float temperatureCoolCOVID19Y = 0;
		private float temperatureCoolCOVID19N = 0;
		private float temperatureNormCOVID19Y = 0;
		private float temperatureNormCOVID19N = 0;
		private float temperatureHotCOVID19Y = 0;
		private float temperatureHotCOVID19N = 0;

		
		//Aches Attributes
		private float achesY = 0;
		private float achesN = 0;
		private float achesYCOVID19Y = 0;
		private float achesNCOVID19N = 0;
		private float achesNCOVID19Y = 0;
		private float achesYCOVID19N = 0;
		
		
		//SoreThroat Attributes
		private float soreThroatY = 0;
		private float soreThroatN = 0;
		private float soreThroatYCOVID19Y = 0;
		private float soreThroatNCOVID19N = 0;
		private float soreThroatNCOVID19Y = 0;
		private float soreThroatYCOVID19N = 0;
		
		
		
		//Cough Attributes
		private float coughY = 0;
		private float coughN = 0;
		private float coughYCOVID19Y = 0;
		private float coughNCOVID19N = 0;
		private float coughYCOVID19N = 0;
		private float coughNCOVID19Y = 0;
		
		
		//fromDZ Attributes
		private float DZY = 0;
		private float DZN = 0;
		private float fromDZY = 0;
		private float fromDZN = 0;
		private float fromDZYCOVID19Y = 0;
		private float fromDZNCOVID19N = 0;
		private float fromDZYCOVID19N = 0;
		private float fromDZNCOVID19Y = 0;
		
		
		//hasCOVID19 Attributes
		private float hasCOVID19Y = 0;
		private float hasCOVID19N = 0;
		
		private float Correct;
		
		
		public TestAccuracy() 
		{
			
			//FileProcessing findingProb = new FileProcessing("MLdata.csv");
			
			
			
			
			//Temperature variables
			this.setTemperatureCool(temperatureCool);
			this.setTemperatureNorm(temperatureNorm);
			this.setTemperatureHot(temperatureHot);
			this.setTemperatureCoolCOVID19Y(temperatureCoolCOVID19Y);
			this.setTemperatureCoolCOVID19N(temperatureCoolCOVID19N);
			this.setTemperatureNormCOVID19Y(temperatureNormCOVID19Y);
			this.setTemperatureNormCOVID19N(temperatureNormCOVID19N);
			this.setTemperatureHotCOVID19Y(temperatureHotCOVID19Y);
			this.setTemperatureHotCOVID19N(temperatureHotCOVID19N);
			
			
			//Aches variables
			this.setAchesY(achesY);
			this.setAchesN(achesN);
			this.setAchesCOVID19Y(achesYCOVID19Y);
			this.setAchesCOVID19N(achesNCOVID19N);
			
			
			//Sore Throat variables
			this.setSoreThroatY(soreThroatY);
			this.setSoreThroatN(soreThroatN);
			this.setSoreThroatCOVID19Y(soreThroatYCOVID19Y);
			this.setSoreThroatCOVID19N(soreThroatNCOVID19N);
			
			
			//Cough Variables
			this.setCoughY(coughY);
			this.setCoughN(coughN);
			this.setCoughCOVID19Y(coughYCOVID19Y);
			
			
			//Travelled from Danger Zone Variables
			this.setFromDZY(fromDZY);
			this.setFromDZN(fromDZN);
			this.setFromDZCOVID19Y(fromDZYCOVID19Y);
			this.setFromDZCOVID19N(fromDZNCOVID19N);
			
			
			//Does the patient have COVID19 virus variables
			this.setHasCOVID19Y(hasCOVID19Y);
			this.setHasCOVID19N(hasCOVID19N);
			
			
		}

		
		public void findAccuracy()
		{
			
			setCorrect(0);
			
			
			
			
			FileProcessing findAccuracy = new FileProcessing(Control.getCsvFile());
			
			findAccuracy.openFile();
			
			findAccuracy.readFile();
				 
			fullList = findAccuracy.getSymptomsList();
			
			float size = fullList.size() - Math.round(fullList.size() * .70) ;
			
			System.out.println("Size 1 " +size);
			
			float size2 = fullList.size() - size;
			
			System.out.println(size2);
			
			
			
			for(int i=(int)size; i<size2; i++)
			{
				
				Probability prob = new Probability(fullList.get(i).getTemperature(), fullList.get(i).getAches(), fullList.get(i).getSoreThroat(), fullList.get((int) i).getCough(), fullList.get(i).getTravelFromDZ());
			
				prob.count();
				
			}
			
			for(int i = 0; i<size; i++)
			{
				testList.add(fullList.get(i));
				
				
			}
			
			
			System.out.println(testList);
			
			
			//System.out.println(testList);
			
			//System.out.println(size2);
			
			
			for(int i = 0; i<size; i++)
			{
				
			
				Probability prob = new Probability(testList.get(i).getTemperature(), testList.get(i).getAches(), testList.get(i).getSoreThroat(), testList.get(i).getCough(), testList.get(i).getTravelFromDZ());
			
				
				
				prob.findProb();
				
				System.out.println(testList.get(i));
				System.out.println(prob.getAnswer());
				
				if(prob.getAnswer() > 49 & testList.get(i).getHasCOVID19().equals("yes"))
				{
				
					
					Correct++;
					
					System.out.println("Correct guesses = "+Correct);
						
					
				
				}
				else if(prob.getAnswer() < 49 & testList.get(i).getHasCOVID19().equals("no"))
				{
					
					Correct++;
						
					System.out.println("Correct guesses = "+Correct);
					
				}
			}
			
			Correct = Correct/(float)testList.size()*100;
			
			System.out.println(Correct);
			
		}//End findAccuracy()
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		private void setHasCOVID19N(float hasCOVID19N2) {
			// TODO Auto-generated method stub
			
		}




		private void setHasCOVID19Y(float hasCOVID19Y2) {
			// TODO Auto-generated method stub
			
		}




		private void setFromDZCOVID19N(float fromDZNCOVID19N2) {
			// TODO Auto-generated method stub
			
		}




		private void setFromDZCOVID19Y(float fromDZYCOVID19Y2) {
			// TODO Auto-generated method stub
			
		}




		private void setFromDZN(float fromDZN2) {
			// TODO Auto-generated method stub
			
		}




		private void setFromDZY(float fromDZY2) {
			// TODO Auto-generated method stub
			
		}




		private void setCoughCOVID19Y(float coughYCOVID19Y2) {
			// TODO Auto-generated method stub
			
		}




		private void setCoughN(float coughN2) {
			// TODO Auto-generated method stub
			
		}




		private void setCoughY(float coughY2) {
			// TODO Auto-generated method stub
			
		}




		private void setSoreThroatCOVID19N(float soreThroatNCOVID19N2) {
			// TODO Auto-generated method stub
			
		}




		private void setSoreThroatCOVID19Y(float soreThroatYCOVID19Y2) {
			// TODO Auto-generated method stub
			
		}




		private void setSoreThroatN(float soreThroatN2) {
			// TODO Auto-generated method stub
			
		}




		private void setSoreThroatY(float soreThroatY2) {
			// TODO Auto-generated method stub
			
		}




		private void setAchesCOVID19N(float achesNCOVID19N2) {
			// TODO Auto-generated method stub
			
		}




		private void setAchesCOVID19Y(float achesYCOVID19Y2) {
			// TODO Auto-generated method stub
			
		}




		private void setAchesN(float achesN2) {
			// TODO Auto-generated method stub
			
		}




		private void setAchesY(float achesY2) {
			// TODO Auto-generated method stub
			
		}




		private void setTemperatureHotCOVID19N(float temperatureHotCOVID19N2) {
			// TODO Auto-generated method stub
			
		}




		private void setTemperatureHotCOVID19Y(float temperatureHotCOVID19Y2) {
			// TODO Auto-generated method stub
			
		}




		private void setTemperatureNormCOVID19N(float temperatureNormCOVID19N2) {
			// TODO Auto-generated method stub
			
		}




		private void setTemperatureNormCOVID19Y(float temperatureNormCOVID19Y2) {
			// TODO Auto-generated method stub
			
		}




		private void setTemperatureCoolCOVID19N(float temperatureCoolCOVID19N2) {
			// TODO Auto-generated method stub
			
		}




		private void setTemperatureHot(float temperatureHot2) {
			// TODO Auto-generated method stub
			
		}




		private void setTemperatureCoolCOVID19Y(float temperatureCoolCOVID19Y2) {
			// TODO Auto-generated method stub
			
		}




		private void setTemperatureNorm(float temperatureNorm2) {
			// TODO Auto-generated method stub
			
		}




		private void setTemperatureCool(float temperatureCool2) {
			// TODO Auto-generated method stub
			
		}




		float getCorrect() {
			return Correct;
		}




		void setCorrect(float correct) {
			Correct = correct;
		}

		
		
		
	
	
}
