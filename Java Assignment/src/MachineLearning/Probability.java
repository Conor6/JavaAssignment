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
	private float achesCOVID19Y = 0;
	private float achesCOVID19N = 0;
	private float achesNCOVID19Y = 0;
	private float achesYCOVID19N = 0;
	
	
	//SoreThroat Attributes
	private float soreThroatY = 0;
	private float soreThroatN = 0;
	private float soreThroatCOVID19Y = 0;
	private float soreThroatCOVID19N = 0;
	
	
	//Cough Attributes
	private float coughY = 0;
	private float coughN;
	private float coughCOVID19Y = 0;
	private float coughCOVID19N = 0;
	
	
	//fromDZ Attributes
	private float fromDZY = 0;
	private float fromDZN = 0;
	private float fromDZCOVID19Y = 0;
	private float fromDZCOVID19N = 0;
	
	
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
		this.setAchesCOVID19Y(achesCOVID19Y);
		this.setAchesCOVID19N(achesCOVID19N);
		
		
		//Sore Throat variables
		this.setSoreThroatY(soreThroatY);
		this.setSoreThroatN(soreThroatN);
		this.setSoreThroatCOVID19Y(soreThroatCOVID19Y);
		this.setSoreThroatCOVID19N(soreThroatCOVID19N);
		
		
		//Cough Variables
		this.setCoughY(coughY);
		this.setCoughN(coughN);
		this.setCoughCOVID19Y(coughCOVID19Y);
		
		
		//Travelled from Danger Zone Variables
		this.setFromDZY(fromDZY);
		this.setFromDZN(fromDZN);
		this.setFromDZCOVID19Y(fromDZCOVID19Y);
		this.setFromDZCOVID19N(fromDZCOVID19N);
		
		
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
				 coughCOVID19Y++;
			 }
			 else
			 {
				 coughCOVID19N++;
			 }
			 
			 
			 
			 if(hasAches == true & hasCOVID19 == true)
			 {
				 achesCOVID19Y++;
			 }
			 else
			 {
				 achesCOVID19N++;
				 
			 }
			 
			 if(hasAches == false & hasCOVID19 == true)
			 {
				 achesCOVID19
			 }
			 
			 
			 if(tempCool == true & hasCOVID19 == true)
			 {
				 setTemperatureCoolCOVID19Y(getTemperatureCoolCOVID19Y() + 1);
			 }
			 else
			 {
				 setTemperatureCoolCOVID19N(getTemperatureCoolCOVID19N() + 1);
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
				 soreThroatCOVID19Y++;
			 }
			 else
			 {
				 soreThroatCOVID19N++;
			 }
			 
			 
			 if(fromDZ == true & hasCOVID19 == true)
			 {
				 fromDZCOVID19Y++;
			 }
			 else
			 {
				 fromDZCOVID19N++;
			 }
			 
			
			
		 }//End for loop
		 
		 
		 
		 
		 System.out.println(coughCOVID19Y);
		 System.out.println(coughCOVID19N);
	
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
		achesCOVID19Y = achesCOVID19Y / hasCOVID19Y;
		
		
		//Calculating the probability of having Aches if COVID19 is No
		achesCOVID19N = achesCOVID19N / hasCOVID19N;
		
		
		//Calculating the probability of having a Sore Throat if COVI19 is Yes
		soreThroatCOVID19Y = soreThroatCOVID19Y / hasCOVID19Y;
		
		
		//Calculating the probability of having a Sore Throat if COVI19 is No
		soreThroatCOVID19N = soreThroatCOVID19N / hasCOVID19N;
		
		
		//Calculating the probability of having a Cough if COVID19 is Yes
		coughCOVID19Y = coughCOVID19Y / hasCOVID19Y;
		
		
		//Calculating the probability of having a Cough if COVID19 is No
		coughCOVID19N = coughCOVID19N / hasCOVID19N;
		
		
		//Calculating the probability of having travelled to a DZ if COVID19 is Yes
		fromDZCOVID19Y = fromDZCOVID19Y / hasCOVID19Y;
		
		
		//Calculating the probability of having travelled to a DZ if COVID19 is No
		fromDZCOVID19N = fromDZCOVID19N / hasCOVID19N;
		
		
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
		
		
		if(aches.contains( "yes"))
		{
			float achesY = achesCOVID19Y;
			float achesN = achesCOVID19N;
		}
		
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



	private void setFromDZCOVID19N(float fromDZCOVID19N) {
		this.fromDZCOVID19N = fromDZCOVID19N;
	}





	public float getTemperatureNormCOVID19Y() {
		return temperatureNormCOVID19Y;
	}





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