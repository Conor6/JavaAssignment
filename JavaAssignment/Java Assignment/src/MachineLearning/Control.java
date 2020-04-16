package MachineLearning;


//Control Class

public class Control 
{

	private static String csvFile = "MLdata.csv";
	
	public static void main(String[] args) 
	{
		
		
		FileProcessing myFileStuff = new FileProcessing(getCsvFile()); 
		
		
		GUI homeScreen = new GUI();
		homeScreen.setVisible(true);
		
		//FileProcessing myFileStuff = new FileProcessing("MLdata.csv");
		//myFileStuff.openFile();
		//myFileStuff.readFile();
		//Probability prob = new Probability("normal", "no", "no", "no", "yes");
		//prob.count();
		//prob.findProb();
		//Algorithm firstCount = new Algorithm("MLdata.csv");
		//firstCount.counting();
		
		
		//TestAccuracy test = new TestAccuracy();
		
		//test.findAccuracy();
		
	}

	public static String getCsvFile() {
		return csvFile;
	}

	public static void setCsvFile(String csvFile) 
	{
		Control.csvFile = csvFile;
	}

}
