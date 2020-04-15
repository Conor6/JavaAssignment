package MachineLearning;

import java.util.ArrayList;
import java.lang.Math;

//Check calculation***

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
	
	
	private float ansY = 0;
	private float ansN = 0;
	private float answer = 0;


	
	public Probability(String temperature, String aches, String soreThroat, String cough, String fromDZ) 
	{
		
		//FileProcessing findingProb = new FileProcessing("MLdata.csv");
		
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
		
		
	}

	
	 public void count()
	{
		
		FileProcessing findingProb = new FileProcessing("MLdata.csv");
		
		findingProb.openFile();
			 
		ArrayList<PatientInfo> probabilityList = new ArrayList<PatientInfo>();
			 
		probabilityList = findingProb.getSymptomsList();
		 
		 
		int size = probabilityList.size();
		
		
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
			 else if(hasCough == false & hasCOVID19 == false)
			 {
				 coughNCOVID19N++;
			 }
			 
			 if(hasCough == false & hasCOVID19 == true)
			 {
				 coughNCOVID19Y++;
			 }
			 else if(hasCough == true & hasCOVID19 == false)
			 {
				 coughYCOVID19N++;
			 }
			 
			 
			 if(hasAches == true & hasCOVID19 == true)
			 {
				 achesYCOVID19Y++;
			 }
			 else if (hasAches == true & hasCOVID19 == false)
			 {
				 achesYCOVID19N++;
				 
			 }
			 
			 
			 if(hasAches == false & hasCOVID19 == true)
			 {
				 achesNCOVID19Y++;
			 }
			 else if(hasAches == false & hasCOVID19 == false)
			 {
				 achesNCOVID19N++;
			 }
			 
			 
			 if(tempCool == true & hasCOVID19 == true)
			 {
				 temperatureCoolCOVID19Y++;
			 }
			 else if(tempCool == true & hasCOVID19 == false)
			 {
				 temperatureCoolCOVID19N++;
			 }
			 
			
			 if(tempNorm == true & hasCOVID19 == true)
			 {
				 temperatureNormCOVID19Y++;
			 }
			 else if(tempNorm == true & hasCOVID19 == false)
			 {
				 temperatureNormCOVID19N++;
			 }
			 
			 
			 if(tempHot == true & hasCOVID19 == true)
			 {
				 temperatureHotCOVID19Y++;
			 }
			 else if(tempHot == true & hasCOVID19 == false)
			 {
				 temperatureHotCOVID19N++;
			 }
			 
			 
			 if(hasSoreThroat == true & hasCOVID19 == true)
			 {
				 soreThroatYCOVID19Y++;
			 }
			 else if(hasSoreThroat == false & hasCOVID19 == false)
			 {
				 soreThroatNCOVID19N++;
			 }
			 
			 
			 if(hasSoreThroat == false & hasCOVID19 == true)
			 {
				 soreThroatNCOVID19Y++;
			 }
			 else if(hasSoreThroat == true & hasCOVID19 == false)
			 {
				 soreThroatYCOVID19N++;
			 }
			 
			 
			 if(fromDZ == true & hasCOVID19 == true)
			 {
				 fromDZYCOVID19Y++;
			 }
			 else if(fromDZ == false & hasCOVID19 == false)
			 {
				 fromDZNCOVID19N++;
			 }
			 
			 
			 if(fromDZ == false & hasCOVID19 == true)
			 {
				 fromDZNCOVID19Y++;
			 }
			 else if(fromDZ == true & hasCOVID19 == false)
			 { 
				 fromDZYCOVID19N++;
			 }
			
			 
		 }//End for loop
		 
		 
	}//End count()
	 
	 
	 
	 public void findProb()
	 {
		 
		 FileProcessing findingProb = new FileProcessing("MLdata.csv");
			
		 findingProb.openFile();
			 
		ArrayList<PatientInfo> probabilityList = new ArrayList<PatientInfo>();
			 
		probabilityList = findingProb.getSymptomsList();
		 
		 
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
		hasCOVID19Y = (hasCOVID19Y / (float)probabilityList.size());
		
		
		//Calculating the probability of having COVID19 No
		hasCOVID19N = hasCOVID19N / (float)probabilityList.size();
		
		
		if(temperature.contains( "cool"))
		{
			tempY = temperatureCoolCOVID19Y;
			tempN = temperatureCoolCOVID19N;
		}
		
		
		if(temperature.contains( "normal"))
		{
			tempY = temperatureNormCOVID19Y;
			tempN = temperatureNormCOVID19N;
		}
		
		
		if(temperature.contains( "hot"))
		{
			
			tempY = temperatureHotCOVID19Y;
		
			tempN = temperatureHotCOVID19N;
		}
		
		
		if(aches.contains("yes"))
		{
			
			 achesY = achesYCOVID19Y;
			 achesN = achesYCOVID19N;
		}
		else
		{
			 achesY = achesNCOVID19Y;
			 achesN = achesNCOVID19N;
		}
		
		
		if(soreThroat.contains("yes"))
		{
			
			 soreThroatY = soreThroatYCOVID19Y;
			 soreThroatN = soreThroatYCOVID19N;
		}
		else
		{
			
			 soreThroatY = soreThroatNCOVID19Y;
			 soreThroatN = soreThroatNCOVID19N;
		}
	
		
		if(cough.contains("yes"))
		{
			 coughY = coughYCOVID19Y;
			 coughN = coughYCOVID19N;
		}
		else
		{
			 coughY = coughNCOVID19Y;
			 coughN = coughNCOVID19N;
		}
		
		
		if(fromDZ.contains("yes"))
		{
			 DZY = fromDZYCOVID19Y;
			 DZN = fromDZYCOVID19N;
	
		}
		else
		{
			 DZY = fromDZNCOVID19Y;
			 DZN = fromDZNCOVID19N;
		}
		
		
		//Calculating COVID19Y
		ansY = (tempY * achesY * soreThroatY * coughY * DZY * hasCOVID19Y);
		 
		
		//Calculating COVID19N
		
		ansN = tempN * achesN * soreThroatN * coughN * DZN * (hasCOVID19N);
		
		setAnswer(ansY/(ansN + ansY));
		setAnswer(getAnswer() *100);
		
		setAnswer(Math.round(getAnswer()));
		
		//System.out.println(getAnswer());
		
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
		return achesYCOVID19Y;
	}


	private void setAchesCOVID19Y(float achesCOVID19Y) {
		this.achesYCOVID19Y = achesCOVID19Y;
	}


	private float getAchesCOVID19N() {
		return achesNCOVID19N;
	}


	private void setAchesCOVID19N(float achesCOVID19N) {
		this.achesNCOVID19N = achesCOVID19N;
	}


	private float getSoreThroatCOVID19Y() {
		return soreThroatYCOVID19Y;
	}


	private void setSoreThroatCOVID19Y(float soreThroatCOVID19Y) {
		this.soreThroatYCOVID19Y = soreThroatCOVID19Y;
	}


	float getSoreThroatCOVID19N() {
		return soreThroatNCOVID19N;
	}


	void setSoreThroatCOVID19N(float soreThroatCOVID19N) {
		this.soreThroatNCOVID19N = soreThroatCOVID19N;
	}


	float getCoughCOVID19Y() {
		return coughYCOVID19Y;
	}


	void setCoughCOVID19Y(float coughCOVID19Y) {
		this.coughYCOVID19Y = coughCOVID19Y;
	}


	float getCoughCOVID19N() {
		return coughYCOVID19N;
	}


	void setCoughCOVID19N(float coughCOVID19N) {
		this.coughNCOVID19N = coughCOVID19N;
	}


	float getFromDZCOVID19Y() {
		return fromDZYCOVID19Y;
	}


	private void setFromDZCOVID19Y(float fromDZCOVID19Y) {
		this.fromDZYCOVID19Y = fromDZCOVID19Y;
	}


	private float getFromDZCOVID19N() {
		return fromDZNCOVID19N;
	}

	private void setFromDZCOVID19N(float fromDZCOVID19N)
	{
		this.fromDZNCOVID19N = fromDZCOVID19N;
	}


	public float getTemperatureNormCOVID19Y() 
	{
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


	float getAnswer() {
		return answer;
	}


	private void setAnswer(float answer) {
		this.answer = answer;
	}

}