package MachineLearning;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//FP class

public class FileProcessing 
{
	//Attributes
	private File dataFile;
	private String data;
	private String[] values;
	public static ArrayList<PatientInfo> symptomsList = new ArrayList<PatientInfo>();
	
	
	public FileProcessing (String fileName) 
	{
		this.setDataFile(dataFile);
		this.setData(data);
		this.setValues(values);
	}
	
	
	//This method opens the file that has been selected. The default file is MLdata.csv
	void openFile()
	{
		setDataFile(new File(Control.getCsvFile()));
	}
	
	
	//This method reads through the selected file. Each row is stored as a patient object in the ArrayList symptomsList
	public void readFile()
	{
		try
		{
			Scanner inputStream = new  Scanner(getDataFile());
			
			inputStream.nextLine(); //This ignores the first line of the CSV file
			
			while(inputStream.hasNext()) //Keep going until there are no more lines left in the file
			{
				String data = inputStream.nextLine(); //Gets a whole line from file
				
				String[] values = data.split(",");//Gets a column
				
				
				symptomsList.add(new PatientInfo(values[0], values[1], values[2], values[3], values[4], values[5])); //Creates a new Patient and adds their symptoms 
			}
		
			inputStream.close(); //Closes the Scanner class
		}
		
		catch(FileNotFoundException e)
		
		{
			e.printStackTrace();
		}

	}//End readFile()
	
	
	//Getters and setters
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


	public File getDataFile() 
	{
		return dataFile;
	}


	public void setDataFile(File dataFile) 
	{
		this.dataFile = dataFile;
	}



	public ArrayList<PatientInfo> getSymptomsList() 
	{
		return symptomsList;
	}

	@SuppressWarnings("static-access")
	public void setSymptomsList(ArrayList<PatientInfo> symptomsList) 
	{
		this.symptomsList = symptomsList;
	}
	
}
