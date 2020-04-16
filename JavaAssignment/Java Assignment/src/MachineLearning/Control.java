package MachineLearning;


//Control Class

public class Control 
{

	private static String csvFile = "MLdata.csv"; //This is used to read in the file into the file processor. It is also used to allow the user to change test file
	
	public static void main(String[] args) 
	{
		
		GUI homeScreen = new GUI();
		homeScreen.setVisible(true); //Opens the GUI when the program is started
		
	}

	
	//Getter and Setter for csvFile
	public static String getCsvFile() 
	{
		return csvFile;
	}

	public static void setCsvFile(String csvFile) 
	{
		Control.csvFile = csvFile;
	}

}
