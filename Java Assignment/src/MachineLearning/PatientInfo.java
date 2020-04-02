package MachineLearning;

public class PatientInfo 
{
	
	//Attributes
	private String temperature;
	private String aches;
	private String cough;
	private String soreThroat;
	private String travelFromDZ;
	private String hasCOVID19;
	
	
	
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

	
	
	public String toString()
	{
		return("Temperature is  " +getTemperature()+ "  Has Aches " +getAches()+ "  Has a Cough " +getCough()+ "  Has a SoreThroat " +getSoreThroat()+" Travelled from Danger Zone? " 
		+getTravelFromDZ()+ " Has COVID19 " +getHasCOVID19() );
	}
	
	

	//Getters and Setters for the Attributes
	String getTemperature() 
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
	
	
}
