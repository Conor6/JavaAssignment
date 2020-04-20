package MachineLearning;


/*This program is a machine learning program used to determine whether or not a person has the Coronaviurs.
 * This program uses a Naive Bayes classifier to determine if a patient has the virus. There are 7 classes in the program:
 * FileProcessing, PatientInfo, Probability, TestAccuracy, GUI and CoronaCheck.
 * 
 * FileProcessing - This class is used to obtain the information from the entered file. This is done by an ArrayList which creates a PatientInfo object
 * 
 * PatientInfo - This class contains the same variables and attributes that the file has in order to create a patient with the same information as the file
 * 
 * Probability - This class counts the amount of times each symptom appears and adds it to a variable. Then, the probability of having each symptom with COVID19
 * and without COVID19 is calculated. This is then used to predict whether or not a person has the Coronavirus
 * 
 * TestAccuracy - This class is used to test the accuracy of the program. This is done by splitting the file into a 70/30 split. This program is trained by the 70% and
 * then it is tested on the 30%. The amount of right answers are recorded and the accuracy is calculated
 * 
 * GUI - This is the home screen of the program. The user uses this window to navegate around the program and utilize its various features
 * 
 * CoronaCheck - This is the window where the user enters the patients symptoms into the program. The probability of the patient having the coronavirus
 * is the displayed on the screen
 * 
 * 
 * Author:   Conor Flood
 * 
 * Compiler: Eclipse IDE
 * 
 * Date Started: March 21st 2020
 * 
 * Date Finished: April 20th 2020
 * 
 */

public class Control 
{

	private static String csvFile = "MLdata.csv"; //This is used to read in the file into the file processor. It is also used to allow the user to change test file
	
	public static void main(String[] args) 
	{
		
		GUI homeScreen = new GUI();	  //Creating a new GUI object
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
