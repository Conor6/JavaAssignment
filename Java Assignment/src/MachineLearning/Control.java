package MachineLearning;


public class Control 
{

	public static void main(String[] args) 
	{
		FileProcessing myFileStuff = new FileProcessing("MLdata.csv");
		
		myFileStuff.openFile();
		
		myFileStuff.readFile();

		//Algorithm firstCount = new Algorithm("MLdata.csv");
		
		//firstCount.counting();
		
	
		
	}

}
