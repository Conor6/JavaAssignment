package MachineLearning;

//Patient Info

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

	
	//toString to print out the patient symptoms
	public String toString()
	{
		return("Temperature is  " +getTemperature()+ "  Has Aches " +getAches()+ "  Has a Cough " +getCough()+ "  Has a SoreThroat " +getSoreThroat()+" Travelled from Danger Zone? " 
		+getTravelFromDZ()+ " Has COVID19 " +getHasCOVID19() );
	}
	
	

///////////////////////////////////////////////////////////////////Getters and Setters for the Attributes//////////////////////////////////////////////////////////////////
	
	
	
	//Temperature Getter and Setter
	public String getTemperature() 
	{
		return temperature;
	}


	void setTemperature(String temperature) 
	{
		this.temperature = temperature;
	}



	
	//Aches Getter and Setter
	String getAches() 
	{
		return aches;
	}


	void setAches(String aches) 
	{
		this.aches = aches;
	}


	
	//Sore Throat Getter and Setter
	String getSoreThroat() 
	{
		return soreThroat;
	}


	void setSoreThroat(String soreThroat) 
	{
		this.soreThroat = soreThroat;
	}


	
	
	//Travel fromDZ Getter and Setter
	String getTravelFromDZ() 
	{
		return travelFromDZ;
	}


	void setTravelFromDZ(String travelFromDZ) 
	{
		this.travelFromDZ = travelFromDZ;
	}


	
	//HasCOVID19 Getter and Setter
	String getHasCOVID19() 
	{
		return hasCOVID19;
	}


	void setHasCOVID19(String hasCOVID19) 
	{
		this.hasCOVID19 = hasCOVID19;
	}


	
	//Cough Getter and Setter
	String getCough() 
	{
		return cough;
	}


	void setCough(String cough) 
	{
		this.cough = cough;
	}



	
	
}
