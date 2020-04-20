package MachineLearning;

/*CoronaCheck Class
 * 
 * This class is the UI for the user entering symptoms into the program to
 * check the likelihood that they have COVID19
 * The user selects which symptoms the patient has by clicking on Yes or No buttons next to the patient's symptoms
 * 
 * Author:   Conor Flood
 * 
 * Complier: Eclipse IDE
 * 
*/
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

@SuppressWarnings("serial")
public class CoronaCheck extends JFrame 
{

	private JPanel contentPane;
	private final ButtonGroup temperatureGroup = new ButtonGroup();		//Button group for Temperature
	private final ButtonGroup achesGroup = new ButtonGroup();			//Button group for Aches
	private final ButtonGroup soreThroatGroup = new ButtonGroup();		//Button group for Sore Throat
	private final ButtonGroup coughGroup = new ButtonGroup();			//Button group for Cough
	private final ButtonGroup dangerZoneGroup = new ButtonGroup();		//Button group for Travel from Danger Zone
	
	
	//These variables are passed into the 
	private String temperature;
	private String aches;
	private String cough;
	private String soreThroat;
	private String travelFromDZ;
	
	//Counter variable used as basic error checking to ensure that all symptoms are entered
	private int    counter;

	
	//This class is used to pass information into the probability class to calculate the probability that the patient has COVID19
	public CoronaCheck() 
	{
		
		//Creating the window
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 462);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(135, 206, 235));	//Setting background colour
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));		//Creating a new border
		setContentPane(contentPane);							
		contentPane.setLayout(null);
		
		//Main Title	
		JLabel lblCoronavirusTestingTool = new JLabel("Coronavirus Testing Tool");				//Label displaying name of program
		lblCoronavirusTestingTool.setFont(new Font("Arial Black", Font.BOLD, 24));				//Setting font colour
		lblCoronavirusTestingTool.setHorizontalAlignment(SwingConstants.CENTER);				//Setting the alignment of the text
		lblCoronavirusTestingTool.setBounds(119, 11, 414, 35);									//Setting location of the text
		contentPane.add(lblCoronavirusTestingTool);												//Adding text
		
		
		//Secondary Title
		JLabel lblEnterPaitientInformation = new JLabel("Enter Symptoms:");						//Creating new secondary title
		lblEnterPaitientInformation.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));	//Setting font
		lblEnterPaitientInformation.setBounds(10, 76, 267, 23);			
		contentPane.add(lblEnterPaitientInformation);											//Adding secondary title to the window
		
		
		//Temperature Label
		JLabel lblTemperature = new JLabel("Temperature:");					//Creating Temperature label
		lblTemperature.setFont(new Font("Tahoma", Font.PLAIN, 12));			//Setting font
		lblTemperature.setBounds(10, 136, 87, 14);							//Setting location
		contentPane.add(lblTemperature);									//Adding to window	
		
		
		//Aches Label													
		JLabel lblAches = new JLabel("Aches:");								//Creating Temperature label
		lblAches.setFont(new Font("Tahoma", Font.PLAIN, 12));				//Setting font
		lblAches.setBounds(10, 161, 87, 14);								//Setting location
		contentPane.add(lblAches);											//Adding to window
		
		
		//Sore Throat Label
		JLabel lblTemperature_1 = new JLabel("Sore Throat:\r\n");			//Creating Sore Throat label
		lblTemperature_1.setFont(new Font("Tahoma", Font.PLAIN, 12));		//Setting font
		lblTemperature_1.setBounds(10, 186, 87, 14);						//Setting location
		contentPane.add(lblTemperature_1);									//Adding to the window
		
		
		//Cough Label
		JLabel lblCough = new JLabel("Cough:\r\n");							//Creating Cough label
		lblCough.setFont(new Font("Tahoma", Font.PLAIN, 12));				//Setting font
		lblCough.setBounds(10, 211, 87, 14);								//Setting location
		contentPane.add(lblCough);											//Adding to window
		
		
		//Danger Zone Label
		JLabel lblTravelledFromDanger = new JLabel("Been to Danger Zone:");	//Creating Danger Zone label
		lblTravelledFromDanger.setFont(new Font("Tahoma", Font.PLAIN, 12));	//Setting font
		lblTravelledFromDanger.setBounds(10, 236, 152, 14);					//Setting location
		contentPane.add(lblTravelledFromDanger);							//Adding to the window
		
		
		//Creating See Results label
		JButton btnResults = new JButton("See Restults");					//Cerating See Results button
		btnResults.addActionListener(new ActionListener() 					//Adding Action Listener to see if user clicked button
		{
			public void actionPerformed(ActionEvent myEvent) 
			{
				if(myEvent.getSource() == btnResults) 
				{
					if(getCounter() > 4)
					{
						
						
						FileProcessing dataFile = new FileProcessing(Control.getCsvFile());	//Getting file 
						
						dataFile.openFile();		//Opening file
							
						dataFile.readFile();		//Reading information into the file
						
						
						Probability prob = new Probability(temperature, aches, soreThroat, cough, travelFromDZ); //Passing the entered information into Probability class
						
						prob.count();		//Counting the number of times each symptom is present
						prob.findProb();	//Calculating the patients probability of having COVID19
						
						JOptionPane.showMessageDialog(getContentPane(),"The probability that this person has COVID19 is " +prob.getAnswer()+ "%");
						
						setVisible(false); //Closing the enter symptoms page
						
						GUI homeScreen = new GUI();	//Creating a new GUI object so the user returns to the home screen
						homeScreen.setVisible(true);//Making the home screen visible
						
					}//End nested if
					else
					{	
						//If the user does not enter all of the required symptoms they are prompted to enter all the users symptoms
						JOptionPane.showMessageDialog(null,"Please enter all of the patient's symptoms");
					}
						
				}
			}
		});
		
		
		
		//Results button
		btnResults.setBackground(Color.WHITE);		//Setting background colour
		btnResults.setBounds(96, 316, 116, 23);		//Setting location
		contentPane.add(btnResults);				//Adding button to window
		
		
		
		//Creating Back button
		JButton backButton = new JButton("Back");			//Craeting button
		backButton.setBackground(Color.WHITE);				//Setting background colour
		backButton.setBounds(229, 316, 106, 23);			//Setting location for button
		contentPane.add(backButton);						//Adding button to the window
		
		backButton.addActionListener(new ActionListener() //Adding Action listener to listen for mouse clicks
		{
			public void actionPerformed(ActionEvent myEvent) 
			{
				if(myEvent.getSource() == backButton) 
				{
					setVisible(false); //CoronaCheck window is closed
					
					GUI home = new GUI();	//New GUI object is made
					
					home.setVisible(true); 	//Home screen is made visible
				}
			}
		});
		
		
		
		//Radio button for Cool temperature
		JRadioButton Cool = new JRadioButton("Cool");				///Creating radio button for Cool temperature
		Cool.setBackground(new Color(135, 206, 235));				//Setting background colour
		temperatureGroup.add(Cool);									//Adding Cool to Temperature Button group
		Cool.setBounds(103, 133, 64, 23);							//Setting location
		contentPane.add(Cool);										//Ading to window
		
		
		//Adding Action listener to see if button is selected
		Cool.addActionListener(new ActionListener() 				
		{
			public void actionPerformed(ActionEvent myEvent) 
			{
				if(Cool.isSelected() == true)						//If button is selected setTemperature to cool
				{
					setTemperature("cool");
					
					setCounter(getCounter() + 1);					//Increment counter by 1
				}//End if
			}
		});
		
		
		
		
		//Radio button for Normal Temperature
		JRadioButton Normal = new JRadioButton("Normal");			//Creating Normal temperature radio button
		Normal.setBackground(new Color(135, 206, 235));				//Setting backgrund colour of button
		temperatureGroup.add(Normal);								//Adding button to temperature button group
		Normal.setBounds(168, 133, 79, 23);							//Setting button location
		contentPane.add(Normal);									//Adding to window
		
		Normal.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent myEvent) 
			{
				if(Normal.isSelected() == true)						//If Normal is selected set temperature to Normal
				{
					setTemperature("normal");
					
					setCounter(getCounter() + 1);					//Increment counter by 1
					
				}//End if
			}
		});
		
		
		//Radio button for hot temperature
		JRadioButton Hot = new JRadioButton("Hot");					//Create Hot temperature radio button
		Hot.setBackground(new Color(135, 206, 235));				//Set button background colour	
		temperatureGroup.add(Hot);									//Add button to temperature radio button group	
		Hot.setBounds(249, 133, 109, 23);							//Setting location of button
		contentPane.add(Hot);										//Adding button to window
		
		
		Hot.addActionListener(new ActionListener() 					//Adding Action listener to see if button is selected
		{
			public void actionPerformed(ActionEvent myEvent) 
			{
				if(Hot.isSelected() == true)						//If Hot is selected set temperature to hot
				{
					setTemperature("hot");
					
					setCounter(getCounter() + 1);					//Increment counter by 1
				}
			}
		});
		
		
		
		//Radio button for Aches Yes
		JRadioButton achesYes = new JRadioButton("Yes");			//Creating Yes radio button
		achesYes.setBackground(new Color(135, 206, 235));			//Setting background colour
		achesGroup.add(achesYes);									//Adding to aches button group
		achesYes.setBounds(103, 158, 56, 23);						//Setting location of button
		contentPane.add(achesYes);									//Adding button to window
		
		
		achesYes.addActionListener(new ActionListener() 			//Action listener to see if button is selected
		{
			public void actionPerformed(ActionEvent myEvent) 
			{
				if(achesYes.isSelected() == true)					//If Yes is selected set aches to yes
				{
					setAches("yes");			
					
					setCounter(getCounter() + 1);					//Increment counter by 1
					
				}//End if
			}
		});
		
		
		
		
		//Radio button for Aches no
		JRadioButton achesNo = new JRadioButton("No");				//Creating radio button for aches no
		achesNo.setBackground(new Color(135, 206, 235));			//Setting background colour
		achesGroup.add(achesNo);									//Adding to button group aches 
		achesNo.setBounds(168, 158, 79, 23);						//Setting button location
		contentPane.add(achesNo);									//Adding to window
		
		
		achesNo.addActionListener(new ActionListener() 				//Action listener to see if button is selected
		{
			public void actionPerformed(ActionEvent myEvent) 
			{
				if(achesNo.isSelected() == true)					//If aches no is true set Aches to no
				{
					setAches("no");
					
					setCounter(getCounter() + 1);					//Increment counter by 1
				}
			}
		});
		
		
		
		
		//Radio button for SoreThroat Yes
		JRadioButton soreThroatYes = new JRadioButton("Yes");		//Creating radio button for soreThroat yes
		soreThroatYes.setBackground(new Color(135, 206, 235));		//Setting colour
		soreThroatGroup.add(soreThroatYes);							//Adding button to sore throat button group
		soreThroatYes.setBounds(103, 183, 64, 23);					//Setting location
		contentPane.add(soreThroatYes);								//Adding button to window
		
		
		soreThroatYes.addActionListener(new ActionListener() 		//Add Action listener to see if sore throat yes is selected
		{
			public void actionPerformed(ActionEvent myEvent) 		//If sore throat yes is selected set sore throat to yes and increment counter
			{
				if(soreThroatYes.isSelected() == true)
				{
					setSoreThroat("yes");
					
					
					setCounter(getCounter() + 1);
				}
			}
		});
		
		
		
		
		//Radio button for SoreThroat No
		JRadioButton soreThroatNo = new JRadioButton("No");			//Creaing radio button for sore throat no
		soreThroatNo.setBackground(new Color(135, 206, 235));		//Setting colour
		soreThroatGroup.add(soreThroatNo);							//Adding sore throat no to button group
		soreThroatNo.setBounds(168, 183, 109, 23);					//Setting location
		contentPane.add(soreThroatNo);								//Add button to window
		
		soreThroatNo.addActionListener(new ActionListener() 		//Add action listener to see if button is selected
		{
			public void actionPerformed(ActionEvent myEvent) 
			{
				if(soreThroatNo.isSelected() == true)				//If sore throat no is selected set sore throat to no and increment counter
				{
					setSoreThroat("no");
					
					setCounter(getCounter() + 1);
					
				}
			}
		});
		
		
		
		
		//Radio for Cough Yes
		JRadioButton coughYes = new JRadioButton("Yes");			//Creating radio button for cough yes
		coughYes.setBackground(new Color(135, 206, 235));			//Setting background colour
		coughGroup.add(coughYes);									//Adding button to coughGroup
		coughYes.setBounds(96, 207, 56, 23);						//Setting location	
		contentPane.add(coughYes);									//Adding button to window
		
		
		coughYes.addActionListener(new ActionListener() 			//Adding button to see if cough  yes is selected
		{
			public void actionPerformed(ActionEvent myEvent) 
			{
				if(coughYes.isSelected() == true)					//If cough yes is selected set cough to yes and increment counter
				{
					setCough("yes");
					
					setCounter(getCounter() + 1);
					
				}
			}
		});
		
		
		
		
		//Radio button for Cough No
		JRadioButton coughNo = new JRadioButton("No");				//Creating radio button for cough no
		coughNo.setBackground(new Color(135, 206, 235));			//Setting background colour
		coughGroup.add(coughNo);									//Add button to button group coughGroup
		coughNo.setBounds(168, 208, 109, 23);						//Setting location of button
		contentPane.add(coughNo);									//Adding buttont to window
		
		
		coughNo.addActionListener(new ActionListener() 				//Action listener to see if button is selected
		{
			public void actionPerformed(ActionEvent myEvent) 
			{
				if(coughNo.isSelected() == true)					//If button is selected set cough to no and increment counter
				{
					setCough("no");
					
					setCounter(getCounter() + 1);
				}
			}
		});
		
		
		
		//Radio button for Been to DZ Yes
		JRadioButton DZYes = new JRadioButton("Yes");				//Creating radio button for danger zone yes
		DZYes.setBackground(new Color(135, 206, 235));				//Setting background colour
		dangerZoneGroup.add(DZYes);									//Add button to dangerZoneGroup
		DZYes.setBounds(168, 233, 56, 23);							//Set button location
		contentPane.add(DZYes);										//Add button to window
		
		DZYes.addActionListener(new ActionListener() 				//Add ActionListener to see if button is seleced
		{
			public void actionPerformed(ActionEvent myEvent) 
			{
				if(DZYes.isSelected() == true)						//If button is true set travel from DZ to yes and increment counter
				{
					setTravelFromDZ("yes");
					counter++;
				}
			}
		});
		
		
		
		
		//Radio button for Been to DZ No
		JRadioButton DZNo = new JRadioButton("No");					//Create dangerzone no button
		DZNo.setBackground(new Color(135, 206, 235));				//Set colour
		dangerZoneGroup.add(DZNo);									//Add button to dangerzone button group
		DZNo.setBounds(229, 233, 109, 23);							//Set button location
		contentPane.add(DZNo);										//Add button to window
		
		DZNo.addActionListener(new ActionListener() 				//Add action listener to see if button is selected
		{
			public void actionPerformed(ActionEvent myEvent) 
			{
				if(DZNo.isSelected() == true)						//If button is selected setTravelFromDZ to no and increment counter
				{
					setTravelFromDZ("no");
					counter++;
				}
			}
		});
		
		
		
	}

	

	//Getters and Setters
	private void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	

	private void setAches(String aches) {
		this.aches = aches;
	}

	

	private void setCough(String cough) {
		this.cough = cough;
	}


	private void setSoreThroat(String soreThroat) {
		this.soreThroat = soreThroat;
	}

	

	private void setTravelFromDZ(String travelFromDZ) {
		this.travelFromDZ = travelFromDZ;
	}

	

	
	private int getCounter() {
		return counter;
	}

	private void setCounter(int counter) {
		this.counter = counter;
	}
}
