package MachineLearning;

public class Algorithm extends FileProcessing
{
	int counter = 0 ;
	
	public Algorithm(String fileName) 
	{
		super(fileName);
		
	
	
	}

	void counting()
	{
	
		for(int i = 0; i< getData().length(); i++);
		{
			if(getData() == "yes")
			{
				counter = counter +1;
			}
		}
		
		System.out.println(counter);
	}
	

}