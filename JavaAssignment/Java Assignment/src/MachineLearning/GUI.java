package MachineLearning;


/* This class is the Home Screen for the GUI. This is used to create the buttons and text on the home page of the program.
 * The user uses the buttons on this home page to test the accuracy of the program, check whether someone has the coronavirus,
 * choose a file or exit the program.
 * 
 * Author:   Conor Flood
 * 
 * Compiler: Eclipse IDE
 * 
*/
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class GUI extends JFrame 
{
	//Used to store the file path
	private JFileChooser openFileChooser;
	private String fileName;	//Used to store the file name
	
	
	/**
	 * Create the frame.
	 */
	public GUI() 
	{
		
		//Setting up the Frame
		getContentPane().setFont(new Font("Arial Black", Font.PLAIN, 14));
		getContentPane().setBackground(new Color(135, 206, 235));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 462);
		getContentPane().setLayout(null);
		
		
		//Creating the Exit button
		JButton btnExit = new JButton("Exit");
		
		btnExit.setForeground(new Color(0, 0, 0)); //Setting Foreground colour for button
		
		btnExit.setBackground(new Color(255, 255, 255)); //Setting Background colour for button
		
		btnExit.setBounds(540, 340, 89, 23); //Location of button
		
		getContentPane().add(btnExit); //Adding the button to the content pane
		
	
		//This action listener is used to see if the Exit button is clicked. If it is the program will exit
		btnExit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent myEvent) 
			{
				if(myEvent.getSource() == btnExit) 
				{
					System.exit(0);
				}
			}
			
		});
		
		
		
		//Creating the Accuracy Button, setting the colours and location
		JButton btnTrainProgram = new JButton("Accuracy");
		btnTrainProgram.setForeground(new Color(0, 0, 0));
		
		btnTrainProgram.setBackground(new Color(255, 255, 255));
		
		
		//Adding an Action listener
		btnTrainProgram.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent myEvent) //If the button is clicked findAccuracy from the TestAccuracy class is run
			{
				if(myEvent.getSource() == btnTrainProgram) 
				{
					TestAccuracy accuracy = new TestAccuracy(); //Creating Test accuracy object
					
					accuracy.findAccuracy();

					JOptionPane.showMessageDialog(getContentPane(),"The accuracy of this program is " +accuracy.getCorrect()+ "%");		//Printing out the results of accuracy test
				}
			}
			
		});
		
		
		btnTrainProgram.setBounds(10, 340, 109, 23); //Setting location
		getContentPane().add(btnTrainProgram);//Adding the button to the panel
		
		
		
		//Creating Check button to allow the user to enter the patients symptoms and find out the probability of the patient having COVID19
		JButton Check = new JButton("Check");
		Check.setForeground(new Color(0, 0, 0));
		
		//Adding an Action Listner to Check button
		Check.addActionListener(new ActionListener() 
		{
			//If the Check button is clicked the CoronaCheck Window is opened to allow the user to enter in the patients symptoms
			public void actionPerformed(ActionEvent myEvent) 
			{
				if(myEvent.getSource() == Check) 
				{
					//This will display pop-up
					CoronaCheck patient = new CoronaCheck(); //New CoronaCheck object Patient is created
					setVisible(false); 					//Hides the GUI home screen
					patient.setVisible(true);			//CoronaCheck window is opened
					
				}
			}
		});
		Check.setBackground(new Color(255, 255, 255));	//Setting colour
		
		Check.setBounds(129, 340, 89, 23);				//Setting location
		
		getContentPane().add(Check);					//Adding Check button
		
		
		
		//Creating Choose File button
		JButton btnChooseFile = new JButton("Choose File");
		btnChooseFile.setBackground(new Color(255, 255, 255));	//Setting background colour
		btnChooseFile.setForeground(new Color(0, 0, 0));		//Setting foreground colour
		
		
		openFileChooser = new JFileChooser();					//Creating a new FileChooser
		openFileChooser.setCurrentDirectory(new File("C:\\temp")); //Setting the file directory
		openFileChooser.setFileFilter(new FileNameExtensionFilter(".csv file", ".csv"));	//Setting a file filter so that only csv files can be seen
		
		btnChooseFile.addActionListener(new ActionListener() //Adding Action Listener to button
		{
			public void actionPerformed(ActionEvent myEvent) 
			{
				if(myEvent.getSource() == btnChooseFile) 
				{
					chooseFile();							//Calling chooseFile method
					Control.setCsvFile(getFileName());		//Setting the file path
					
				}
			}
		});
		
		
		btnChooseFile.setBounds(260, 340, 101, 23);			//Setting button location
		getContentPane().add(btnChooseFile);				//Adding the button to content pane
		
		JPanel panel = new JPanel();						//Creating a new panel as a white background to the title
		panel.setBackground(Color.WHITE);
		panel.setBounds(157, 24, 366, 49);					//Setting location
		getContentPane().add(panel);
		
		
		
		JLabel lblCoronavirusTestingTool = new JLabel("COVID19 Testing Tool");	//Title
		panel.add(lblCoronavirusTestingTool);									//Adding to the panel
		lblCoronavirusTestingTool.setForeground(new Color(0, 0, 0));			//Setting the colours
		lblCoronavirusTestingTool.setBackground(new Color(0, 0, 0));			//Setting the colours
		
		lblCoronavirusTestingTool.setFont(new Font("Arial Black", Font.BOLD, 24)); //Setting fond type and size
		
		lblCoronavirusTestingTool.setHorizontalAlignment(SwingConstants.CENTER);	//Centring the title
		
		

		
	}
	
	//chooseFile method allows the user to select which file they want to enter into the program
	public String chooseFile() 
	{
		
		 Control.setCsvFile("C:\\Users\\conor\\git\\JavaAssignment\\Java Assignment\\MLdata.csv");
		
		openFileChooser = new JFileChooser();
		openFileChooser.setCurrentDirectory(new File("C:\\"));								//Setting default directory
		openFileChooser.setFileFilter(new FileNameExtensionFilter(".csv file", "csv"));		//Used to filter the files so that only csv files show up
		
		int returnValue = openFileChooser.showOpenDialog(getContentPane());					//Returns a value if the user has selected a file
		
		if(returnValue == JFileChooser.APPROVE_OPTION)					//If the user has selected a file the file path is passes to Control csvFile
		{
			setFileName(openFileChooser.getSelectedFile().getPath());
			
			System.out.println(Control.getCsvFile());
		}
		else //If the user doesn't selecta file they are prompted to select a file. The program wont work without a file
		{
			JOptionPane.showMessageDialog(getContentPane(),"No file has been chosen! Please choose a file!");
			
			chooseFile(); //User prompted to enter file
		}
		
		return getFileName();
		
	}
	
	
	public String getFileName() 
	{
		return fileName;
	}
	
	public void setFileName(String fileName) 
	{
		
		this.fileName = fileName;
	}
}
