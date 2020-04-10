package MachineLearning;


//Control Class

public class Control 
{

	public static void main(String[] args) 
	{
		FileProcessing myFileStuff = new FileProcessing("MLdata.csv");
		
		myFileStuff.openFile();
		
		myFileStuff.readFile();
		
		
		
		Probability prob = new Probability();
		
		
		prob.count();
		prob.findProb();
		
		

		//Algorithm firstCount = new Algorithm("MLdata.csv");
		
		//firstCount.counting();
		
		
		
	}

}
