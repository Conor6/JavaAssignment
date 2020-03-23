package MachineLearning;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Control 
{

	public static void main(String[] args) 
	{
		String fileName = "MLdata.csv";
		File file = new File(fileName);
		
		try
		{
			Scanner inputStream = new  Scanner(file);
			
			while(inputStream.hasNext()) 
			{
				String data = inputStream.nextLine(); //Gets a whole line from file
				String[] values = data.split(",");//Gets a column
				System.out.println(values[1]);
			
			
				
			}
			
			inputStream.close();
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		
	}

}
