package MachineLearning;

import java.util.ArrayList;


//probability class
public class Probability 
{
	
	//Attributes
	String temperature;
	String aches;
	String soreThroat;
	String cough;
	String fromDZ;
	
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
	private float coughN;
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
	
	
	FileProcessing findingProb = new FileProcessing("MLdata.csv");
	
	
	 
	ArrayList<PatientInfo> probabilityList = new ArrayList<PatientInfo>();
	 
	
	
	
	
	public Probability(String temperature, String aches, String soreThroat, String cough, String fromDZ) 
	{
		
		
		
		this.temperature = temperature;
		this.aches = aches;
		this.soreThroat = soreThroat;
		this.cough = cough;
		this.fromDZ = fromDZ;
		
		
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
		
		FileProcessing findingProb = new FileProcessing("MLdata.csv");
		
		findingProb.openFile();
		 
		ArrayList<PatientInfo> probabilityList = new ArrayList<PatientInfo>();
		 
		probabilityList = findingProb.getSymptomsList();
		
	}



	
	
	 void count()
	{
		
		 //System.out.println("***" +probabilityList);
		 
		 int size = probabilityList.size();
		 
		// System.out.println(size);
		 
		 //System.out.println(probabilityList.get(1));
		
		 for(int i = 0; i < size; i++)
		 {
			 
			 boolean tempHot = probabilityList.get(i).getTemperature().contains("hot");
			 
			 if(tempHot == true)
			 {
			
				temperatureHot++;
				
			 }
			 
			 
			 boolean tempCool = probabilityList.get(i).getTemperature().contains("cool");
			 
			 if(tempCool == true)
			 {
			
				temperatureCool++;
				
			 }
			 
			 boolean tempNorm = probabilityList.get(i).getTemperature().contains("normal");
			 
			 if(tempNorm == true)
			 {
			
				temperatureNorm++;
				
			 }
			 
			 
			 
			 boolean hasAches = probabilityList.get(i).getAches().contains("yes");
			 
			 if(hasAches == true)
			 {
			
				achesY++;
				
			 
			 }
			 else
			 {
				 achesN++;
			 }
			 
			 
			 
			 boolean hasSoreThroat = probabilityList.get(i).getSoreThroat().contains("yes");
			 
			 if(hasSoreThroat == true)
			 {
			
				soreThroatY++;
				
			 
			 }
			 else
			 {
				 soreThroatN++;
			 }
			 
			 
	
			 boolean hasCough = probabilityList.get(i).getCough().contains("yes");
			 
			 if(hasCough == true)
			 {
				coughY++;
				
			 }
			 else
			 {
				 coughN++;
				 
				
			 }
			 
			 boolean fromDZ = probabilityList.get(i).getTravelFromDZ().contains("yes");
			 
			 if(fromDZ == true)
			 {
			
				fromDZY++;
				
			 }
			 else
			 {
				 fromDZN++;
			 }
			 
			 
			 boolean hasCOVID19 = probabilityList.get(i).getHasCOVID19().contains("yes");
			 
			 if(hasCOVID19 == true)
			 {
			
				hasCOVID19Y++;
				
			 }
			 else
			 {
				 hasCOVID19N++;
			 }
			 
			 
			 
			 if(hasCough == true & hasCOVID19 == true)
			 {
				 coughYCOVID19Y++;
			 }
			 else
			 {
				 coughNCOVID19N++;
			 }
			 
			 if(hasCough == false & hasCOVID19 == true)
			 {
				 coughNCOVID19Y++;
			 }
			 
			 
			 if(hasAches == true & hasCOVID19 == true)
			 {
				 achesYCOVID19Y++;
			 }
			 else
			 {
				 achesYCOVID19N++;
				 
			 }
			 
			 if(hasAches == false & hasCOVID19 == true)
			 {
				 achesNCOVID19Y++;
			 }
			 else
			 {
				 achesYCOVID19N++;
			 }
			 
			 
			 if(tempCool == true & hasCOVID19 == true)
			 {
				 temperatureCoolCOVID19Y++;
			 }
			 else
			 {
				 temperatureCoolCOVID19N++;
			 }
			 
			
			 if(tempNorm == true & hasCOVID19 == true)
			 {
				 temperatureNormCOVID19Y++;
			 }
			 else
			 {
				 temperatureNormCOVID19Y++;
			 }
			 
			 
			 if(tempHot == true & hasCOVID19 == true)
			 {
				 temperatureHotCOVID19Y++;
			 }
			 else
			 {
				 temperatureHotCOVID19N++;
			 }
			 
			 
			 
			 if(hasSoreThroat == true & hasCOVID19 == true)
			 {
				 soreThroatYCOVID19Y++;
			 }
			 else
			 {
				 soreThroatNCOVID19N++;
			 }
			 
			 if(hasSoreThroat == false & hasCOVID19 == true)
			 {
				 soreThroatNCOVID19Y++;
			 }
			 else
			 {
				 soreThroatYCOVID19N++;
			 }
			 
			 
			 if(fromDZ == true & hasCOVID19 == true)
			 {
				 fromDZYCOVID19Y++;
			 }
			 else
			 {
				 fromDZNCOVID19N++;
			 }
			 
			 
			 if(fromDZ == false & hasCOVID19 == false)
			 {
				 fromDZNCOVID19Y++;
				 
			 }
			 else
			 {
				 fromDZYCOVID19N++;
			 }
			
		 }//End for loop
		 
		 
		 
		 
		 System.out.println(coughYCOVID19Y);
		 System.out.println(coughNCOVID19N);
	
		 /*System.out.println("Temperature count cool =  " +temperatureCool+ " Temperature normal count  " +temperatureNorm+ " Temperature hot count " 
				 +temperatureHot+ " Aches count = " +achesY+ "  Cough count = " +coughY+ 
				 "  SoreThroat count = " +soreThroatY+" Travelled from Danger Zone count = " 
					+fromDZY+ " Has COVID19 count =" +hasCOVID19Y);
		 
		 
		 
		// System.out.println("No Aches count = " +achesN+ "  No Cough count = " +coughN+ 
				 "  No SoreThroat count = " +soreThroatN+" No Travelled from Danger Zone count = " 
					+fromDZN+ " No COVID19 count =" +hasCOVID19N); */
		 
	}//End count()
	 
	 
	 
	 
	 public void findProb()
	 {
		 
		 //Calculating the probability of having Cool, Norm and Hot temperatures if COVID19 is Yes
		 temperatureCoolCOVID19Y = temperatureCoolCOVID19Y / hasCOVID19Y;
		 
		 temperatureNormCOVID19Y = temperatureNormCOVID19Y / hasCOVID19Y;
		 
		 temperatureHotCOVID19Y = temperatureHotCOVID19Y / hasCOVID19Y;
		 
		 
		//Calculating the probability of having Cool, Norm and Hot temperatures if COVID19 is No
		temperatureCoolCOVID19N = temperatureCoolCOVID19N / hasCOVID19N;
		
		temperatureNormCOVID19N = temperatureNormCOVID19N / hasCOVID19N;
		
		temperatureHotCOVID19N = temperatureHotCOVID19N / hasCOVID19N;
		
		
		//Calculating the probability of having Aches if COVID19 is Yes
		achesYCOVID19Y = achesYCOVID19Y / hasCOVID19Y;
		achesNCOVID19Y = achesNCOVID19Y / hasCOVID19Y;
		
		//Calculating the probability of having Aches if COVID19 is No
		achesYCOVID19N = achesYCOVID19N / hasCOVID19N;
		achesNCOVID19N = achesNCOVID19N / hasCOVID19N;
		
		//Calculating the probability of having a Sore Throat if COVI19 is Yes
		soreThroatYCOVID19Y = soreThroatYCOVID19Y / hasCOVID19Y;
		soreThroatNCOVID19Y = soreThroatNCOVID19Y / hasCOVID19Y;
		
		
		
		//Calculating the probability of having a Sore Throat if COVI19 is No
		soreThroatYCOVID19N = soreThroatYCOVID19N / hasCOVID19N;
		soreThroatNCOVID19N = soreThroatNCOVID19N / hasCOVID19N;
		
		
		//Calculating the probability of having a Cough if COVID19 is Yes
		coughYCOVID19Y = coughYCOVID19Y / hasCOVID19Y;
		coughNCOVID19Y = coughNCOVID19Y / hasCOVID19Y;
		
		
		//Calculating the probability of having a Cough if COVID19 is No
		coughYCOVID19N = coughYCOVID19N / hasCOVID19N;
		coughNCOVID19N = coughNCOVID19N / hasCOVID19N;
		
		
		//Calculating the probability of having travelled to a DZ if COVID19 is Yes
		fromDZYCOVID19Y = fromDZYCOVID19Y / hasCOVID19Y;
		fromDZNCOVID19Y = fromDZNCOVID19Y / hasCOVID19Y;
		
		
		
		//Calculating the probability of having travelled to a DZ if COVID19 is No
		fromDZYCOVID19N = fromDZYCOVID19N / hasCOVID19N;
		fromDZNCOVID19N = fromDZNCOVID19N / hasCOVID19N;
		
		
		//Calculating the probability of having COVID19 Yes
		hasCOVID19Y = hasCOVID19Y / probabilityList.size();
		
		
		//Calculating the probability of having COVID19 No
		hasCOVID19N = hasCOVID19N / probabilityList.size();
		
		
		
		if(temperature.contains( "cool"))
		{
			float tempY = temperatureCoolCOVID19Y;
			float tempN = temperatureCoolCOVID19N;
		}
		
		
		if(temperature.contains( "normal"))
		{
			float tempY = temperatureNormCOVID19Y;
			float tempN = temperatureNormCOVID19N;
		}
		
		
		if(temperature.contains( "hot"))
		{
			float tempY = temperatureHotCOVID19Y;
			float tempN = temperatureHotCOVID19N;
		}
		
		
		if(aches.contains("yes"))
		{
			float achesY = achesYCOVID19Y;
			float achesN = achesYCOVID19N;
		}
		else
		{
			float achesY = achesNCOVID19Y;
			float achesN = achesNCOVID19N;
		}
		
		
		if(soreThroat.contains("yes)"))
		{
			float soreThroatY = soreThroatYCOVID19Y;
			float soreThroatN = soreThroatYCOVID19N;
		}
		else
		{
			float soreThroatY = soreThroatNCOVID19Y;
			float soreThroatN = soreThroatNCOVID19N;
		}
	
		
		if(cough.contains("yes"))
		{
			float coughY = coughYCOVID19Y;
			float coughN = coughYCOVID19N;
		}
		else
		{
			float coughY = coughNCOVID19Y;
			float coughN = coughNCOVID19N;
		}
		
		
		if(fromDZ.contains("yes"))
		{
			float DZY = fromDZYCOVID19Y;
			float DZN = fromDZYCOVID19Y;
	
		}
		else
		{
			float DZY = fromDZNCOVID19Y;
			float DZN = fromDZNCOVID19N;
		}
		
		
		
		
		//Calculating COVID19Y
		float ansYes = tempY * achesY * soreThroatY * coughY * DZY * (hasCOVID19Y/probabilityList.size());
		
		//Calculating COVID19N
		float ansNo = tempN * achesN * soreThroatN * coughN * DZN * (hasCOVID19N/probabilityList.size());
		
		System.out.println("The probabilty of having COVID19 is " +ansYes);
		
		
	 }
	
	//Setters and getters
	private float getTemperatureCool() 
	{
		return temperatureCool;
	}


	private void setTemperatureCool(float temperatureCool) 
	{
		this.temperatureCool = temperatureCool;
	}


	private float getTemperatureNorm() 
	{
		return temperatureNorm;
	}


	private void setTemperatureNorm(float temperatureNorm) 
	{
		this.temperatureNorm = temperatureNorm;
	}


	private float getTemperatureHot() 
	{
		return temperatureHot;
	}


	private void setTemperatureHot(float temperatureHot) 
	{
		this.temperatureHot = temperatureHot;
	}


	private float getAchesY() 
	{
		return achesY;
	}


	private void setAchesY(float achesY) 
	{
		this.achesY = achesY;
	}


	private float getAchesN() 
	{
		return achesN;
	}


	private void setAchesN(float achesN) 
	{
		this.achesN = achesN;
	}


	private float getSoreThroatY() 
	{
		return soreThroatY;
	}


	private void setSoreThroatY(float soreThroatY) 
	{
		this.soreThroatY = soreThroatY;
	}


	private float getSoreThroatN() 
	{
		return soreThroatN;
	}


	private void setSoreThroatN(float soreThroatN) 
	{
		this.soreThroatN = soreThroatN;
	}


	private float getCoughY() 
	{
		return coughY;
	}


	private void setCoughY(float coughY) 
	{
		this.coughY = coughY;
	}


	private float getCoughN() 
	{
		return coughN;
	}


	private void setCoughN(float coughN) 
	{
		this.coughN = coughN;
	}


	private float getFromDZY() 
	{
		return fromDZY;
	}


	private void setFromDZY(float fromDZY) 
	{
		this.fromDZY = fromDZY;
	}


	private float getFromDZN() 
	{
		return fromDZN;
	}


	private void setFromDZN(float fromDZN) 
	{
		this.fromDZN = fromDZN;
	}


	private float getHasCOVID19Y() 
	{
		return hasCOVID19Y;
	}


	private void setHasCOVID19Y(float hasCOVID19Y) 
	{
		this.hasCOVID19Y = hasCOVID19Y;
	}


	private float getHasCOVID19N() 
	{
		return hasCOVID19N;
	}


	private void setHasCOVID19N(float hasCOVID19N) 
	{
		this.hasCOVID19N = hasCOVID19N;
	}



	private float getAchesCOVID19Y() {
		return achesCOVID19Y;
	}



	private void setAchesCOVID19Y(float achesCOVID19Y) {
		this.achesCOVID19Y = achesCOVID19Y;
	}



	private float getAchesCOVID19N() {
		return achesCOVID19N;
	}



	private void setAchesCOVID19N(float achesCOVID19N) {
		this.achesCOVID19N = achesCOVID19N;
	}



	private float getSoreThroatCOVID19Y() {
		return soreThroatCOVID19Y;
	}



	private void setSoreThroatCOVID19Y(float soreThroatCOVID19Y) {
		this.soreThroatCOVID19Y = soreThroatCOVID19Y;
	}



	float getSoreThroatCOVID19N() {
		return soreThroatCOVID19N;
	}



	void setSoreThroatCOVID19N(float soreThroatCOVID19N) {
		this.soreThroatCOVID19N = soreThroatCOVID19N;
	}



	float getCoughCOVID19Y() {
		return coughCOVID19Y;
	}



	void setCoughCOVID19Y(float coughCOVID19Y) {
		this.coughCOVID19Y = coughCOVID19Y;
	}



	float getCoughCOVID19N() {
		return coughCOVID19N;
	}



	void setCoughCOVID19N(float coughCOVID19N) {
		this.coughCOVID19N = coughCOVID19N;
	}



	float getFromDZCOVID19Y() {
		return fromDZCOVID19Y;
	}



	private void setFromDZCOVID19Y(float fromDZCOVID19Y) {
		this.fromDZCOVID19Y = fromDZCOVID19Y;
	}



	private float getFromDZCOVID19N() {
		return fromDZCOVID19N;
	}



	//private void setFromDZCOVID19N(float fromDZCOVID19N) {
	//	this.fromDZCOVID19N = fromDZCOVID19N;
	//}





	//public float getTemperatureNormCOVID19Y() {
	//	return temperatureNormCOVID19Y;
	//}





	public void setTemperatureNormCOVID19Y(float temperatureNormCOVID19Y) {
		this.temperatureNormCOVID19Y = temperatureNormCOVID19Y;
	}





	public float getTemperatureNormCOVID19N() {
		return temperatureNormCOVID19N;
	}





	public void setTemperatureNormCOVID19N(float temperatureNormCOVID19N) {
		this.temperatureNormCOVID19N = temperatureNormCOVID19N;
	}





	public float getTemperatureHotCOVID19Y() {
		return temperatureHotCOVID19Y;
	}





	public void setTemperatureHotCOVID19Y(float temperatureHotCOVID19Y) {
		this.temperatureHotCOVID19Y = temperatureHotCOVID19Y;
	}





	public float getTemperatureHotCOVID19N() {
		return temperatureHotCOVID19N;
	}





	public void setTemperatureHotCOVID19N(float temperatureHotCOVID19N) {
		this.temperatureHotCOVID19N = temperatureHotCOVID19N;
	}





	private float getTemperatureCoolCOVID19Y() {
		return temperatureCoolCOVID19Y;
	}





	private void setTemperatureCoolCOVID19Y(float temperatureCoolCOVID19Y) {
		this.temperatureCoolCOVID19Y = temperatureCoolCOVID19Y;
	}





	private float getTemperatureCoolCOVID19N() {
		return temperatureCoolCOVID19N;
	}





	private void setTemperatureCoolCOVID19N(float temperatureCoolCOVID19N) {
		this.temperatureCoolCOVID19N = temperatureCoolCOVID19N;
	}
	
	
}