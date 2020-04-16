package MachineLearning;

import java.util.ArrayList;
import java.lang.Math;



public class Probability 
{
	
	//Attributes
	String temperature;
	String aches;
	String soreThroat;
	String cough;
	String fromDZ;
	
	//Temperature Attributes
	private float tempY                   = 0;	//Stores the temperature probability for the COVID19 yes calculation
	private float tempN                   = 0;	//Stores the temperature probability for the COVID19 no calculation
	private float temperatureCool         = 0;	//Stores the count and probability of cool temperatures
	private float temperatureNorm         = 0;	//Stores the count and probability of normal temperatures
	private float temperatureHot          = 0;	///Stores the count and probability of hot temperatures
	private float temperatureCoolCOVID19Y = 0;	//Stores the count and probability of Cool temperatures with COVID19
	private float temperatureCoolCOVID19N = 0;	//Stores the count and probability of Cool temperatures without COVID19
	private float temperatureNormCOVID19Y = 0;	//Stores the count and probability of Normal temperatures with COVID19
	private float temperatureNormCOVID19N = 0;	//Stores the count and probability of Normal temperatures without COVID19
	private float temperatureHotCOVID19Y  = 0;	//Stores the count and probability of Hot temperatures with COVID19
	private float temperatureHotCOVID19N  = 0;	//Stores the count and probability of Hot temperatures without COVID19

	
	//Aches Attributes
	private float achesY         = 0;			//Stores count for people WITH aches and stores the probability of having / not having aches WITH COVID19
	private float achesN         = 0;			//Stores count for people WITHOUT aches and stores the probability of having / not having aches WITHOUT COVID19
	private float achesYCOVID19Y = 0;			//Stores count and probability of HAVING aches WITH COVID19
	private float achesNCOVID19N = 0;			//Stores count and probability of NOT HAVING aches WITHOUT COVID19
	private float achesNCOVID19Y = 0;			//Stores count and probability of NOT HAVING aches WITH COVID19
	private float achesYCOVID19N = 0;			//Stores count and probability of HAVING aches WITHOUT COVID19
	
	
	//SoreThroat Attributes
	private float soreThroatY         = 0;		//Stores count and probability of HAVING a sore throat
	private float soreThroatN         = 0;		//Stores count and probability of NOT HAVING a sore throat
	private float soreThroatYCOVID19Y = 0;		//Stores count and probability of HAVING a sore throat WITH COVID19
	private float soreThroatNCOVID19N = 0;		//Stores count and probability of NOT HAVING a sore throat WITHOUT COVID19
	private float soreThroatNCOVID19Y = 0;		//Stores count and probability of NOT HAVING a sore throat WITH COVID19
	private float soreThroatYCOVID19N = 0;		//Stores count and probability of HAVING a sore throat WITHOUT COVID19
	
	
	
	//Cough Attributes
	private float coughY         = 0;			//Stores count and probability of HAVING a cough
	private float coughN         = 0;			//Stores count and probability of NOT HAVING a cough
	private float coughYCOVID19Y = 0;			//Stores count and probability of HAVING a cough WITH COVID19
	private float coughNCOVID19N = 0;			//Stores count and probability of NOT HAVING a cough WITHOUT COVID19
	private float coughYCOVID19N = 0;			//Stores count and probability of HAVING a cough WITHOUT COVID19
	private float coughNCOVID19Y = 0;			//Stores count and probability of NOT HAVING a cough WITH COVID19
	
	
	//fromDZ Attributes
	private float DZY = 0;						//Stores probability and count of HAVING travelled from a danger zone
	private float DZN = 0;						//Stores probability and count of NOT HAVING travelled from a danger zone
	private float fromDZY         = 0;			//Stores probability and count of HAVING travelled from a danger zone
	private float fromDZN         = 0;			//Stores probability and count of NOT HAVING travelled from a danger zone
	private float fromDZYCOVID19Y = 0;			//Stores probability and count of HAVING travelled from a danger zone and HAVING COVID19
	private float fromDZNCOVID19N = 0;			//Stores probability and count of NOT HAVING travelled from a danger zone and NOT HAVING COVID19
	private float fromDZYCOVID19N = 0;			//Stores probability and count of HAVING travelled from a danger zone and NOT HAVING COVID19
	private float fromDZNCOVID19Y = 0;			//Stores probability and count of NOT HAVING travelled from a danger zone and HAVING COVID19
	
	
	//hasCOVID19 Attributes
	private float hasCOVID19Y = 0;				//Stores the probability and count of HAVING COVID19
	private float hasCOVID19N = 0;				//Stores the probability and count of HAVING COVID19
	
	
	private float ansY   = 0;					//Stores the probability of HAVING COVI19 after multiplying all the entered symptoms together
	private float ansN   = 0;					//Stores the probability of HAVING COVI19 after multiplying all the entered symptoms together
	private float answer = 0;					//Stores the percentage of HAVING COVID19


	
	public Probability(String temperature, String aches, String soreThroat, String cough, String fromDZ) 
	{
		this.temperature = temperature;
		this.aches       =       aches;
		this.soreThroat  =  soreThroat;
		this.cough       =       cough;
		this.fromDZ      =      fromDZ;
		
		
		//Temperature variables
		this.setTemperatureCool(getTemperatureCool());
		this.setTemperatureNorm(getTemperatureNorm());
		this.setTemperatureHot(getTemperatureHot());
		this.setTemperatureCoolCOVID19Y(getTemperatureCoolCOVID19Y());
		this.setTemperatureCoolCOVID19N(getTemperatureCoolCOVID19N());
		this.setTemperatureNormCOVID19Y(getTemperatureNormCOVID19Y());
		this.setTemperatureNormCOVID19N(getTemperatureNormCOVID19N());
		this.setTemperatureHotCOVID19Y(getTemperatureHotCOVID19Y());
		this.setTemperatureHotCOVID19N(getTemperatureHotCOVID19N());
		
		
		//Aches variables
		this.setAchesY(getAchesY());
		this.setAchesN(getAchesN());

		
		//Sore Throat variables
		this.setSoreThroatY(getSoreThroatY());
		this.setSoreThroatN(getSoreThroatN());
		
		
		//Cough Variables
		this.setCoughY(getCoughY());
		this.setCoughN(getCoughN());
		//this.setCoughCOVID19Y(getCoughYCOVID19Y());
		
		
		//Travelled from Danger Zone Variables
		this.setFromDZY(getFromDZY());
		this.setFromDZN(getFromDZN());
		
		
		//Does the patient have COVID19 virus variables
		this.setHasCOVID19Y(getHasCOVID19Y());
		this.setHasCOVID19N(getHasCOVID19N());
		
	}

	
	//This method will count the occurance of each symptom in the list and store it in the appropriate variable
	 public void count()
	{
		//Creating a new FileProcessing object to open the file and populate the probabilityList
		FileProcessing findingProb = new FileProcessing(Control.getCsvFile());
		findingProb.openFile(); 
		ArrayList<PatientInfo> probabilityList = new ArrayList<PatientInfo>(); 
		probabilityList = findingProb.getSymptomsList();
		 
		//Stores the size of the list
		int size = probabilityList.size();
		
		
		//For loop to loop through the file and increment each counter variable
		for(int i = 0; i < size; i++)
		 {
			 
			//tempHot returns a True value if the temperature value is hot, if it is then TemperatureHot is incremented by 1
			 boolean tempHot = probabilityList.get(i).getTemperature().contains("hot");
			 
			 if(tempHot == true)
			 {
				setTemperatureHot(getTemperatureHot() + 1); //Increment TemperatureHot
				
			 }//End if temp hot == true
			 
			//tempCool returns a True value if the temperature value is cool, if it is then TemperatureCool is incremented by 1
			 boolean tempCool = probabilityList.get(i).getTemperature().contains("cool");
			 
			 if(tempCool == true)
			 {
				setTemperatureCool(getTemperatureCool() + 1); //Increment TemperatureCool
				
			 }//End if tempCool == true
			 
			//tempNorm returns a True value if the temperature value is normal, if it is then TemperatureNorm is incremented by 1
			 boolean tempNorm = probabilityList.get(i).getTemperature().contains("normal");
			 
			 if(tempNorm == true)
			 {
				setTemperatureNorm(getTemperatureNorm() + 1); //Increment TemperatureNorm
				
			 }//End if temp Norm == ture
			 
			//hasAches returns a True value if the aches value is yes, if it is then achesY is incremented by 1, otherwise achesN is incremented by 1
			 boolean hasAches = probabilityList.get(i).getAches().contains("yes");
			 
			 if(hasAches == true)
			 {
				setAchesY(getAchesY() + 1); //Increment AchesY
				
			 }//End if hasAches == true
			 else
			 {
				 setAchesN(getAchesN() + 1); //Increment AchesN
				 
			 }//End else setAchesN
			 
			//hasSoreThroat returns a True value if the value is yes, if it is then soreThroatY is incremented by 1, otherwise soreThroatN is incremented by 1
			 boolean hasSoreThroat = probabilityList.get(i).getSoreThroat().contains("yes");
			 
			 if(hasSoreThroat == true)
			 {
			
				setSoreThroatY(getSoreThroatY() + 1); //Increment SoreThroatY
				
			 }//End if hasSoreThroat == true
			 else
			 {
				 setSoreThroatN(getSoreThroatN() + 1); //Increment SoreThroatN
				 
			 }//End else setSoreThroat
			 
			 //hasCough returns a True value if the value is yes, if it is then hasCoughY is incremented by 1, otherwise hasCoughN is incremented by 1
			 boolean hasCough = probabilityList.get(i).getCough().contains("yes");
			 
			 if(hasCough == true)
			 {
				setCoughY(getCoughY() + 1); //Increment CoughY
				
			 }//End if hasCough == true
			 else
			 {
				 setCoughN(getCoughN() + 1); //Increment CoughN
				 
			 }//End setCoughN
			 
			//fromDZ returns a True value if the value is yes, if it is then fromDZY is incremented by 1, otherwise fromDZN is incremented by 1
			 boolean fromDZ = probabilityList.get(i).getTravelFromDZ().contains("yes");
			 
			 if(fromDZ == true)
			 {
				setFromDZY(getFromDZY() + 1); //Increment fromDZY
				
			 }//End if fromDZ == true
			 else
			 {
				 setFromDZN(getFromDZN() + 1); //Increment fromDZN
				 
			 }//End else setFromDZN
			 
			//hasCOVID19 returns a True value if the value is yes, if it is then hasCOVID19 is incremented by 1, otherwise hasCOVID19N is incremented by 1
			 boolean hasCOVID19 = probabilityList.get(i).getHasCOVID19().contains("yes");
			 
			 if(hasCOVID19 == true)
			 {
				setHasCOVID19Y(getHasCOVID19Y() + 1); //Increment setHasCOVID19Y
				
			 }//End if hasCOVID19 == true
			 else
			 {
				 setHasCOVID19N(getHasCOVID19N() + 1); //Increment HasCOVID19
				 
			 }//End else setHasCOVID19N
			 
			 
			 if(hasCough == true & hasCOVID19 == true)
			 {
				 setCoughYCOVID19Y(getCoughYCOVID19Y() + 1); //Increment COVID19Y
				 
			 }//End if setCoughYCOVID19Y
			 else if(hasCough == false & hasCOVID19 == false)
			 {
				 setCoughNCOVID19N(getCoughNCOVID19N() + 1); //Increment COVID19N
				 
			 }//End if setCoughNCOIVD19N
			 
			 
			 //If hasCough is no and hasCOVID19 is Yes increment CoughNCOVID19Y
			 if(hasCough == false & hasCOVID19 == true)		
			 {
				 setCoughNCOVID19Y(getCoughNCOVID19Y() + 1); //Increment CoughNCOVID19Y
				 
			 }//Else if hasCough is yes and hasCOVID19 is no increment CoughYCOVID19N
			 else if(hasCough == true & hasCOVID19 == false)
			 {
				 setCoughYCOVID19N(getCoughYCOVID19N() + 1); //Increment CoughYCOVID19N
				 
			 }//End else if
			 
			 
			 //If hasAches is yes and hasCOVID19 is yes increment AchesYCOVID19Y
			 if(hasAches == true & hasCOVID19 == true)
			 {
				 setAchesYCOVID19Y(getAchesYCOVID19Y() + 1); //Increment AchesYCOVID19Y
				 
			 }//Else if hasAches is yes and hasCOVID19 is false increment AchesYCOVID19N
			 else if (hasAches == true & hasCOVID19 == false)
			 {
				 setAchesYCOVID19N(getAchesYCOVID19N() + 1); //Increment AchesYCOVID19N
				 
			 }//End else if
			 
			 
			 //If hasAches is no and COVID19 is true Increment AchesNCOVID19Y
			 if(hasAches == false & hasCOVID19 == true)
			 {
				 setAchesNCOVID19Y(getAchesNCOVID19Y() + 1); //Increment AchesNCOVID19Y
				 
			 }//If hasAches is no and COVID19 is no Increment AchesNCOVID19Y
			 else if(hasAches == false & hasCOVID19 == false)
			 {
				 setAchesNCOVID19N(getAchesNCOVID19N() + 1); ////Increment AchesNCOVID19N
				 
			 }//Else if
			 
			 
			 //If tempCool is yes and hasCOVID19 is yes increment TemperatureCoolCOVID19Y
			 if(tempCool == true & hasCOVID19 == true)
			 {
				 setTemperatureCoolCOVID19Y(getTemperatureCoolCOVID19Y() + 1); //Increment TemperatureCoolCOVID19Y
				 
			 }//If tempCool is yes and hasCOVID19 is no increment TemperatureCoolCOVID19N
			 else if(tempCool == true & hasCOVID19 == false)
			 {
				 setTemperatureCoolCOVID19N(getTemperatureCoolCOVID19N() + 1); //Increment TemperatureCoolCOVID19Y
				 
			 }//End else if
			 
			
			 //If tempNorm is yes and hasCOVID19 is yes increment TemperatureNormCOVID19Y
			 if(tempNorm == true & hasCOVID19 == true)
			 {
				 setTemperatureNormCOVID19Y(getTemperatureNormCOVID19Y() + 1); //Increment TemperatureNormCOVID19Y
				 
			 }//Else if tempNorm is yes and hasCOVID19 is no increment TemperatureNormCOVID19N
			 else if(tempNorm == true & hasCOVID19 == false)
			 {
				 setTemperatureNormCOVID19N(getTemperatureNormCOVID19N() + 1); //Increment TemperatureNormCOVID19N
				 
			 }//End else if
			 
			 
			 //If tempHot is yes and hasCOVID19 is yes increment TemperatureHotCOVID19Y
			 if(tempHot == true & hasCOVID19 == true)
			 {
				 setTemperatureHotCOVID19Y(getTemperatureHotCOVID19Y() + 1); //Increment TemperatureHotCOVID19Y
				 
			 }//Else if temp hot is yes and hasCOVID19 is no increment TemperatureHotCOVID19N
			 else if(tempHot == true & hasCOVID19 == false)
			 {
				 setTemperatureHotCOVID19N(getTemperatureHotCOVID19N() + 1); //Increment TemperatureHotCOVID19N
				 
			 }//End if else
			 
			 
			 //If soreThroat is yes and hasCOVID19 is yes increment soreThroatYCOVID19Y
			 if(hasSoreThroat == true & hasCOVID19 == true)
			 {
				 setSoreThroatYCOVID19Y(getSoreThroatYCOVID19Y() + 1); //Increment soreThroatYCOVID19Y
				 
			 }//Else if hasSoreThroat is no and hasCOVID19 is no increment SoreThroatNCOVID19N
			 else if(hasSoreThroat == false & hasCOVID19 == false)
			 {
				 setSoreThroatNCOVID19N(getSoreThroatNCOVID19N() + 1); //Increment SoreThroatNCOVID19N
				 
			 }//end if else
			 
			 
			 //hasSoreThroat is no and hasCOVID19 is yes increment SoreThroatNCOVID19Y
			 if(hasSoreThroat == false & hasCOVID19 == true)
			 {
				 setSoreThroatNCOVID19Y(getSoreThroatNCOVID19Y() + 1); //Increment SoreThroatNCOVID19Y
				 
			 }//Else if hasSoreThroat is yes and hasCOVID19 is no increment SoreThroatYCOVID19N
			 else if(hasSoreThroat == true & hasCOVID19 == false)
			 {
				 setSoreThroatYCOVID19N(getSoreThroatYCOVID19N() + 1); //Increment SoreThroatYCOVID19N
				 
			 }//End if else
			 
			 
			 //If fromDZ is yes and hasCOVID19 is yes increment fromDZYCOVID19Y
			 if(fromDZ == true & hasCOVID19 == true)
			 {
				 setFromDZYCOVID19Y(getFromDZYCOVID19Y() + 1); //Increment fromDZYCOVID19Y
				 
			 }//Else if fromDZ is no and hasCOVID19 is no increment fromDZNCOVID19N
			 else if(fromDZ == false & hasCOVID19 == false)
			 {
				 setFromDZNCOVID19N(getFromDZNCOVID19N() + 1); //Increment fromDZNCOVID19N
				 
			 }//End if else
			 
			 
			 //if fromDZ is no and hasCOVID19 is yes increment fromDZNCOVID19Y
			 if(fromDZ == false & hasCOVID19 == true)
			 {
				 setFromDZNCOVID19Y(getFromDZNCOVID19Y() + 1); //Increment fromDZNCOVID19Y
				 
			 }//Else if fromDZ is yes and hasCOVID19 is no increment fromDZYCOVID19N
			 else if(fromDZ == true & hasCOVID19 == false)
			 { 
				 setFromDZYCOVID19N(getFromDZYCOVID19N() + 1); //increment fromDZYCOVID19N
				 
			 }//End else if
			
			 
		 }//End for loop
		 
		 
	}//End count()
	 
	 
	 //This method will use the counts from the count() mehtod to calculate the probability of having COVID19 based on the inputted symptoms
	 public void findProb()
	 {
		 //Opening the Fileprocessor class
		 FileProcessing findingProb = new FileProcessing(Control.getCsvFile());
		 findingProb.openFile();
		
		 //Creating a new ArrayList probabilityList which will store all the Patient objects
		 ArrayList<PatientInfo> probabilityList = new ArrayList<PatientInfo>();
		
		 
		 //Populating probability list with the data from the symptomsList from the FileProcessing class
		 probabilityList = findingProb.getSymptomsList();
		 
		 
		 //Calculating the probability of having Cool, Norm and Hot temperatures if COVID19 is Yes
		 setTemperatureCoolCOVID19Y(getTemperatureCoolCOVID19Y() / getHasCOVID19Y());
		 setTemperatureNormCOVID19Y(getTemperatureNormCOVID19Y() / getHasCOVID19Y());
		 setTemperatureHotCOVID19Y(getTemperatureHotCOVID19Y() / getHasCOVID19Y());
		 
		 
		//Calculating the probability of having Cool, Norm and Hot temperatures if COVID19 is No
		setTemperatureCoolCOVID19N(getTemperatureCoolCOVID19N() / getHasCOVID19N());
		setTemperatureNormCOVID19N(getTemperatureNormCOVID19N() / getHasCOVID19N());
		setTemperatureHotCOVID19N(getTemperatureHotCOVID19N() / getHasCOVID19N());
		
		
		//Calculating the probability of having Aches if COVID19 is Yes
		setAchesYCOVID19Y(getAchesYCOVID19Y() / getHasCOVID19Y());
		setAchesNCOVID19Y(getAchesNCOVID19Y() / getHasCOVID19Y());
		
		//Calculating the probability of having Aches if COVID19 is No
		setAchesYCOVID19N(getAchesYCOVID19N() / getHasCOVID19N());
		setAchesNCOVID19N(getAchesNCOVID19N() / getHasCOVID19N());
		
		//Calculating the probability of having a Sore Throat if COVI19 is Yes
		setSoreThroatYCOVID19Y(getSoreThroatYCOVID19Y() / getHasCOVID19Y());
		setSoreThroatNCOVID19Y(getSoreThroatNCOVID19Y() / getHasCOVID19Y());
		
	
		//Calculating the probability of having a Sore Throat if COVI19 is No
		setSoreThroatYCOVID19N(getSoreThroatYCOVID19N() / getHasCOVID19N());
		setSoreThroatNCOVID19N(getSoreThroatNCOVID19N() / getHasCOVID19N());
		
		
		//Calculating the probability of having a Cough if COVID19 is Yes
		setCoughYCOVID19Y(getCoughYCOVID19Y() / getHasCOVID19Y());
		setCoughNCOVID19Y(getCoughNCOVID19Y() / getHasCOVID19Y());
		
		
		//Calculating the probability of having a Cough if COVID19 is No
		setCoughYCOVID19N(getCoughYCOVID19N() / getHasCOVID19N());
		setCoughNCOVID19N(getCoughNCOVID19N() / getHasCOVID19N());
		
		
		//Calculating the probability of having travelled to a DZ if COVID19 is Yes
		setFromDZYCOVID19Y(getFromDZYCOVID19Y() / getHasCOVID19Y());
		setFromDZNCOVID19Y(getFromDZNCOVID19Y() / getHasCOVID19Y());
		
		
		//Calculating the probability of having travelled to a DZ if COVID19 is No
		setFromDZYCOVID19N(getFromDZYCOVID19N() / getHasCOVID19N());
		setFromDZNCOVID19N(getFromDZNCOVID19N() / getHasCOVID19N());
		
		
		//Calculating the probability of having COVID19 Yes
		setHasCOVID19Y((getHasCOVID19Y() / (float)probabilityList.size()));
		
		
		//Calculating the probability of having COVID19 No
		setHasCOVID19N(getHasCOVID19N() / (float)probabilityList.size());
		
		
		//If the temperature is cool the probability of having COVID19 with a cool temp is put in tempY
		//If the temperature is cool the probability of not having COVI19 with a cool temp is put in tempN
		if(temperature.contains( "cool"))
		{
			setTempY(getTemperatureCoolCOVID19Y()); 
			setTempN(getTemperatureCoolCOVID19N());
		}
		
		//If the temperature is normal the probability of having COVID19 with a cool temp is put in tempY
		//If the temperature is normal the probability of not having COVI19 with a cool temp is put in tempN
		if(temperature.contains( "normal"))
		{
			setTempY(getTemperatureNormCOVID19Y());
			setTempN(getTemperatureNormCOVID19N());
		}
		
		//If the temperature is hot the probability of having COVID19 with a cool temp is put in tempY
		//If the temperature is hot the probability of not having COVI19 with a cool temp is put in tempN
		if(temperature.contains( "hot"))
		{
			setTempY(getTemperatureHotCOVID19Y());
			setTempN(getTemperatureHotCOVID19N());
		}
		
		//If the patient has aches the probability of them having COVID19 with aches is put into achesY
		//If the patient doesn't have aches the probability of them not having COVID19 with aches is put into achesN
		if(aches.contains("yes"))
		{
			 setAchesY(getAchesYCOVID19Y());
			 setAchesN(getAchesYCOVID19N());
		}
		else //If no aches the probability of them having COVID19 is put into achesY and the probability of them not having COVID19 is put into AchesN
		{
			 setAchesY(getAchesNCOVID19Y());
			 setAchesN(getAchesNCOVID19N());
		}
		
		//If the patient has a soreThroat the probability of them having COVID19 with a soreThroat is put into soreThroatY
		//If the patient doesn't have a soreThroat the probability of them not having COVID19 with a soreThroat is put into soreThroatN
		if(soreThroat.contains("yes"))
		{
			 setSoreThroatY(getSoreThroatYCOVID19Y());
			 setSoreThroatN(getSoreThroatYCOVID19N());
		}
		else//If there is no soreThroat the probability of them having COVID19 with no soreThroat is put into soreThroatY and the probability of not having COVID19 is put into soreThroatN
		{
			 setSoreThroatY(getSoreThroatNCOVID19Y());
			 setSoreThroatN(getSoreThroatNCOVID19N());
			 
		}//End if else
	
		
		//If the patient has a cough the probability of them having COVID19 with a cough is put into coughY
		//If the patient doesn't have a cough the probability of them not having COVID19 with a cough is put into coughN
		if(cough.contains("yes"))
		{
			 setCoughY(getCoughYCOVID19Y());
			 setCoughN(getCoughYCOVID19N());
		}
		else//If there is no cough the probability of them having COVID19 with no cough is put into coughY and the probability of not having COVID19 is put into coughN
		{
			 setCoughY(getCoughNCOVID19Y());
			 setCoughN(getCoughNCOVID19N());
		}
		
		//If the patient has travelled from a DZ the probability of them having COVID19 is put into DZY
		//If the patient has not travelled from a DZ the probability of them not having COVID19 is put into DZN
		if(fromDZ.contains("yes"))
		{
			 setDZY(getFromDZYCOVID19Y());
			 setDZN(getFromDZYCOVID19N());
		}
		else//If the patient didn't travel from a DZ the probability of them having COVID19 without travelling from a DZ is put into DZY and the probability of them not having COVID19 is put into DZN
		{
			 setDZY(getFromDZNCOVID19Y());
			 setDZN(getFromDZNCOVID19N());
		}
		
		
		//Calculating COVID19Y
		setAnsY((getTempY() * getAchesY() * getSoreThroatY() * getCoughY() * getDZY() * getHasCOVID19Y()));
		 
		
		//Calculating COVID19N
		setAnsN(getTempN() * getAchesN() * getSoreThroatN() * getCoughN() * getDZN() * (getHasCOVID19N()));
		
		
		//Calculating the probability of having COVI19
		setAnswer(getAnsY()/(getAnsN() + getAnsY()));
		
		//Multiplying by 100 to get a percentage
		setAnswer(getAnswer() *100);
		
		//Rounding the percentage so it is more readable
		setAnswer(Math.round(getAnswer()));
		
	 }

	 //Setters and Getters
	public float getTempY() {
		return tempY;
	}


	public void setTempY(float tempY) {
		this.tempY = tempY;
	}


	public float getTempN() {
		return tempN;
	}


	public void setTempN(float tempN) {
		this.tempN = tempN;
	}


	public float getTemperatureCool() {
		return temperatureCool;
	}


	public void setTemperatureCool(float temperatureCool) {
		this.temperatureCool = temperatureCool;
	}


	public float getTemperatureNorm() {
		return temperatureNorm;
	}


	public void setTemperatureNorm(float temperatureNorm) {
		this.temperatureNorm = temperatureNorm;
	}


	public float getTemperatureHot() {
		return temperatureHot;
	}


	public void setTemperatureHot(float temperatureHot) {
		this.temperatureHot = temperatureHot;
	}


	public float getTemperatureCoolCOVID19Y() {
		return temperatureCoolCOVID19Y;
	}


	public void setTemperatureCoolCOVID19Y(float temperatureCoolCOVID19Y) {
		this.temperatureCoolCOVID19Y = temperatureCoolCOVID19Y;
	}


	private float getTemperatureCoolCOVID19N() {
		return temperatureCoolCOVID19N;
	}


	private void setTemperatureCoolCOVID19N(float temperatureCoolCOVID19N) {
		this.temperatureCoolCOVID19N = temperatureCoolCOVID19N;
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


	public float getAchesY() {
		return achesY;
	}


	public void setAchesY(float achesY) {
		this.achesY = achesY;
	}


	public float getAchesN() {
		return achesN;
	}


	public void setAchesN(float achesN) {
		this.achesN = achesN;
	}


	public float getAchesYCOVID19Y() {
		return achesYCOVID19Y;
	}


	public void setAchesYCOVID19Y(float achesYCOVID19Y) {
		this.achesYCOVID19Y = achesYCOVID19Y;
	}


	public float getAchesNCOVID19N() {
		return achesNCOVID19N;
	}


	public void setAchesNCOVID19N(float achesNCOVID19N) {
		this.achesNCOVID19N = achesNCOVID19N;
	}


	public float getAchesNCOVID19Y() {
		return achesNCOVID19Y;
	}


	public void setAchesNCOVID19Y(float achesNCOVID19Y) {
		this.achesNCOVID19Y = achesNCOVID19Y;
	}


	public float getAchesYCOVID19N() {
		return achesYCOVID19N;
	}


	public void setAchesYCOVID19N(float achesYCOVID19N) {
		this.achesYCOVID19N = achesYCOVID19N;
	}


	public float getSoreThroatY() {
		return soreThroatY;
	}


	public void setSoreThroatY(float soreThroatY) {
		this.soreThroatY = soreThroatY;
	}


	public float getSoreThroatN() {
		return soreThroatN;
	}


	public void setSoreThroatN(float soreThroatN) {
		this.soreThroatN = soreThroatN;
	}


	public float getSoreThroatYCOVID19Y() {
		return soreThroatYCOVID19Y;
	}


	public void setSoreThroatYCOVID19Y(float soreThroatYCOVID19Y) {
		this.soreThroatYCOVID19Y = soreThroatYCOVID19Y;
	}


	public float getSoreThroatNCOVID19N() {
		return soreThroatNCOVID19N;
	}


	public void setSoreThroatNCOVID19N(float soreThroatNCOVID19N) {
		this.soreThroatNCOVID19N = soreThroatNCOVID19N;
	}


	public float getSoreThroatNCOVID19Y() {
		return soreThroatNCOVID19Y;
	}


	public void setSoreThroatNCOVID19Y(float soreThroatNCOVID19Y) {
		this.soreThroatNCOVID19Y = soreThroatNCOVID19Y;
	}


	public float getSoreThroatYCOVID19N() {
		return soreThroatYCOVID19N;
	}


	public void setSoreThroatYCOVID19N(float soreThroatYCOVID19N) {
		this.soreThroatYCOVID19N = soreThroatYCOVID19N;
	}


	public float getCoughY() {
		return coughY;
	}


	public void setCoughY(float coughY) {
		this.coughY = coughY;
	}


	public float getCoughN() {
		return coughN;
	}


	public void setCoughN(float coughN) {
		this.coughN = coughN;
	}


	public float getCoughYCOVID19Y() {
		return coughYCOVID19Y;
	}


	public void setCoughYCOVID19Y(float coughYCOVID19Y) {
		this.coughYCOVID19Y = coughYCOVID19Y;
	}


	public float getCoughNCOVID19N() {
		return coughNCOVID19N;
	}


	public void setCoughNCOVID19N(float coughNCOVID19N) {
		this.coughNCOVID19N = coughNCOVID19N;
	}


	public float getCoughYCOVID19N() {
		return coughYCOVID19N;
	}


	public void setCoughYCOVID19N(float coughYCOVID19N) {
		this.coughYCOVID19N = coughYCOVID19N;
	}


	public float getCoughNCOVID19Y() {
		return coughNCOVID19Y;
	}


	public void setCoughNCOVID19Y(float coughNCOVID19Y) {
		this.coughNCOVID19Y = coughNCOVID19Y;
	}


	public float getDZY() {
		return DZY;
	}


	public void setDZY(float dZY) {
		DZY = dZY;
	}


	public float getDZN() {
		return DZN;
	}


	public void setDZN(float dZN) {
		DZN = dZN;
	}


	public float getFromDZY() {
		return fromDZY;
	}


	public void setFromDZY(float fromDZY) {
		this.fromDZY = fromDZY;
	}


	public float getFromDZN() {
		return fromDZN;
	}


	public void setFromDZN(float fromDZN) {
		this.fromDZN = fromDZN;
	}


	public float getFromDZYCOVID19Y() {
		return fromDZYCOVID19Y;
	}


	public void setFromDZYCOVID19Y(float fromDZYCOVID19Y) {
		this.fromDZYCOVID19Y = fromDZYCOVID19Y;
	}


	public float getFromDZNCOVID19N() {
		return fromDZNCOVID19N;
	}


	public void setFromDZNCOVID19N(float fromDZNCOVID19N) {
		this.fromDZNCOVID19N = fromDZNCOVID19N;
	}


	public float getFromDZYCOVID19N() {
		return fromDZYCOVID19N;
	}


	public void setFromDZYCOVID19N(float fromDZYCOVID19N) {
		this.fromDZYCOVID19N = fromDZYCOVID19N;
	}


	public float getFromDZNCOVID19Y() {
		return fromDZNCOVID19Y;
	}


	public void setFromDZNCOVID19Y(float fromDZNCOVID19Y) {
		this.fromDZNCOVID19Y = fromDZNCOVID19Y;
	}


	public float getHasCOVID19Y() {
		return hasCOVID19Y;
	}


	public void setHasCOVID19Y(float hasCOVID19Y) {
		this.hasCOVID19Y = hasCOVID19Y;
	}


	public float getHasCOVID19N() {
		return hasCOVID19N;
	}


	public void setHasCOVID19N(float hasCOVID19N) {
		this.hasCOVID19N = hasCOVID19N;
	}


	public float getAnsY() {
		return ansY;
	}


	public void setAnsY(float ansY) {
		this.ansY = ansY;
	}


	public float getAnsN() {
		return ansN;
	}


	public void setAnsN(float ansN) {
		this.ansN = ansN;
	}


	public float getAnswer() {
		return answer;
	}


	public void setAnswer(float answer) {
		this.answer = answer;
	}
}

