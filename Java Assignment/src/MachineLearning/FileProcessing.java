package MachineLearning;

public class FileProcessing 
{
	private String fileName;
	private String data;
	private String[] values;
	
	
	
	
	void openFile()
	{
		setFileName("MLdata.csv");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//Getters and setters
	String getFileName() 
	{
		return fileName;
	}
	
	
	void setFileName(String fileName) 
	{
		
		this.fileName = fileName;
	}


	String getData() 
	{
		return data;
	}


	void setData(String data) 
	{
		this.data = data;
	}


	String[] getValues() 
	{
		return values;
	}


	void setValues(String[] values) 
	{
		this.values = values;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
