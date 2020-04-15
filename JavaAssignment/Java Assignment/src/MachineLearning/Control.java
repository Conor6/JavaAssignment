package MachineLearning;


//Control Class

public class Control 
{

	public static void main(String[] args) 
	{
		
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
		
		
		TestAccuracy test = new TestAccuracy();
		
		test.findAccuracy();
		
	}

}
