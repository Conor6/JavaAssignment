package MachineLearning;


/* Patient Info Class -
 * 
 * This class is used in the symptomsList ArrayList. The ArrayList is populated using data from the entered file. 
 * The ArrayList symptomsList creates various patient objects. All their attributes are created using the constructor of this class
 * 
 * Author:   Conor Flood
 * 
 * Compiler: Eclipse IDE
 * 
 */

public class PatientInfo 
{
	
	//Attributes
	private String temperature;			//Patient's temperature is stored here
	private String aches;				//Whether the patient has aches is store in aches
	private String cough;				//Whether the patient has a cough is stored here
	private String soreThroat;			//Whether the patient has a sore Throat is stored in this variable
	private String travelFromDZ;		//Whether or not the patient has travelled from a danger zone is stored here
	private String hasCOVID19;			//Whether or not the patient has COVID19 is stored here
	
	
	
	//Constructor Method
	public PatientInfo(String temperature, String aches, String cough, String soreThroat, String travelFromDZ, String hasCOVID19)
	{
		
		this.setTemperature(temperature);
		this.setAches(aches);
		this.setCough(cough);
		this.setSoreThroat(soreThroat);
		this.setTravelFromDZ(travelFromDZ);
		this.setHasCOVID19(hasCOVID19);
		
	}

	
	//toString to print out the patient symptoms for testing
	public String toString()
	{
		return("Temperature is  " +getTemperature()+ "  Has Aches " +getAches()+ "  Has a Cough " +getCough()+ "  Has a SoreThroat " +getSoreThroat()+" Travelled from Danger Zone? " 
		+getTravelFromDZ()+ " Has COVID19 " +getHasCOVID19() );
	}
	
	

//Getters and Setters
	public String getTemperature() 
	{
		return temperature;
	}


	void setTemperature(String temperature) 
	{
		this.temperature = temperature;
	}
	
	
	String getAches() 
	{
		return aches;
	}


	void setAches(String aches) 
	{
		this.aches = aches;
	}


	String getSoreThroat() 
	{
		return soreThroat;
	}


	void setSoreThroat(String soreThroat) 
	{
		this.soreThroat = soreThroat;
	}

	String getTravelFromDZ() 
	{
		return travelFromDZ;
	}


	void setTravelFromDZ(String travelFromDZ) 
	{
		this.travelFromDZ = travelFromDZ;
	}

	String getHasCOVID19() 
	{
		return hasCOVID19;
	}


	void setHasCOVID19(String hasCOVID19) 
	{
		this.hasCOVID19 = hasCOVID19;
	}

	String getCough() 
	{
		return cough;
	}


	void setCough(String cough) 
	{
		this.cough = cough;
	}

}//End class
