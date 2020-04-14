package MachineLearning;


//Control Class

public class Control 
{

	public static void main(String[] args) 
	{
		FileProcessing myFileStuff = new FileProcessing("MLdata.csv");
		
		myFileStuff.openFile();
		
		myFileStuff.readFile();
		
		GUI homeScreen = new GUI();
		homeScreen.setVisible(true);
		
		Probability prob = new Probability("cool", "yes", "yes", "yes", "yes");
		
		
		prob.count();
		prob.findProb();
		
		

		//Algorithm firstCount = new Algorithm("MLdata.csv");
		
		//firstCount.counting();
		
		
		
	}

}
