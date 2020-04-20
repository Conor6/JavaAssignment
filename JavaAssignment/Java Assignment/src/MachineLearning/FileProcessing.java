package MachineLearning;

/*FileProcessing -
 * 
 * - This class has two methods: openFile() and readFile()
 * 
 * - openFile()
 * 
 * This method sets the file path that the user has entered. This is set to MLdata.csv by default.
 * 
 * - readFile()
 * 
 * This method goes through the file line by line adding each column to the String array symptoms. Then each line is added 
 * to an arrayList symptomList. A patient object is created for each line of the data. This data is then used in the Probability class
 * 
 * 
 * Author: 	 Conor Flood
 * 
 * Compiler: Eclipse IDE
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



public class FileProcessing 
{
	//Attributes
	private File dataFile;
	private String data;
	private String[] symptom;
	public static ArrayList<PatientInfo> symptomsList = new ArrayList<PatientInfo>();
	
	
	public FileProcessing (String fileName) 
	{
		this.setDataFile(dataFile);
		this.setData(data);
		this.setSymptom(symptom);
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
				
				String[] symptom = data.split(",");//Gets a column
				
				
				symptomsList.add(new PatientInfo(symptom[0], symptom[1], symptom[2], symptom[3], symptom[4], symptom[5])); //Creates a new Patient and adds their symptoms 
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


	String[] getSymptom() 
	{
		return symptom;
	}


	void setSymptom(String[] symptom) 
	{
		this.symptom = symptom;
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
