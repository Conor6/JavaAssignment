package MachineLearning;

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

public class CoronaCheck extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private final ButtonGroup buttonGroup_3 = new ButtonGroup();
	private final ButtonGroup buttonGroup_4 = new ButtonGroup();
	
	
	private String temperature;
	private String aches;
	private String cough;
	private String soreThroat;
	private String travelFromDZ;
	private String hasCOVID19;
	private int    counter;

	/**
	 * Create the frame.
	 */
	public CoronaCheck() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 526, 389);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCoronavirusTestingTool = new JLabel("Coronavirus Testing Tool");
		lblCoronavirusTestingTool.setFont(new Font("Arial Black", Font.BOLD, 24));
		lblCoronavirusTestingTool.setHorizontalAlignment(SwingConstants.CENTER);
		lblCoronavirusTestingTool.setBounds(10, 11, 414, 35);
		contentPane.add(lblCoronavirusTestingTool);
		
		JLabel lblEnterPaitientInformation = new JLabel("Enter Symptoms:");
		lblEnterPaitientInformation.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		lblEnterPaitientInformation.setBounds(10, 76, 267, 23);
		contentPane.add(lblEnterPaitientInformation);
		
		JLabel lblTemperature = new JLabel("Temperature:");
		lblTemperature.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTemperature.setBounds(10, 136, 87, 14);
		contentPane.add(lblTemperature);
		
		JLabel lblAches = new JLabel("Aches:");
		lblAches.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblAches.setBounds(10, 161, 87, 14);
		contentPane.add(lblAches);
		
		JLabel lblTemperature_1 = new JLabel("Sore Throat:\r\n");
		lblTemperature_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTemperature_1.setBounds(10, 186, 87, 14);
		contentPane.add(lblTemperature_1);
		
		JLabel lblCough = new JLabel("Cough:\r\n");
		lblCough.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCough.setBounds(10, 211, 87, 14);
		contentPane.add(lblCough);
		
		JLabel lblTravelledFromDanger = new JLabel("Been to Danger Zone:");
		lblTravelledFromDanger.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTravelledFromDanger.setBounds(10, 236, 152, 14);
		contentPane.add(lblTravelledFromDanger);
		
		JButton btnResults = new JButton("See Restults");
		btnResults.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent myEvent) 
			{
				if(myEvent.getSource() == btnResults) 
				{
					if(getCounter() > 4)
					{
						
						
						FileProcessing myFileStuff = new FileProcessing(Control.getCsvFile());
						
						myFileStuff.openFile();
						
						myFileStuff.readFile();
						
						GUI homeScreen = new GUI();
						homeScreen.setVisible(true);
						
						Probability prob = new Probability(temperature, aches, soreThroat, cough, travelFromDZ);
						
						prob.count();
						prob.findProb();
						
						JOptionPane.showMessageDialog(getContentPane(),"The probability that this person has COVID19 is " +prob.getAnswer()+ "%");
						
						setVisible(false);
						
						
					}//End nested if
					else
					{
						JOptionPane.showMessageDialog(null,"Please enter all of the patient's symptoms");
					}
						
				}
			}
		});
		
		//Back button
		btnResults.setBackground(Color.WHITE);
		btnResults.setBounds(96, 316, 116, 23);
		contentPane.add(btnResults);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent myEvent) 
			{
				if(myEvent.getSource() == btnNewButton) 
				{
					//This will display pop-up
					//AddPatient patient = new AddPatient();
					//patient.setVisible(true);
					setVisible(false);
					
					GUI home = new GUI();
					
					home.setVisible(true);
				}
			}
		});
		btnNewButton.setBounds(229, 316, 106, 23);
		contentPane.add(btnNewButton);
		
		//Radio button for Cool temperature
		JRadioButton Cool = new JRadioButton("Cool");
		Cool.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent myEvent) 
			{
				if(Cool.isSelected() == true)
				{
					setTemperature("cool");
					
					setCounter(getCounter() + 1);
				}
			}
		});
		
		
		buttonGroup.add(Cool);
		Cool.setBounds(103, 133, 64, 23);
		contentPane.add(Cool);
		
		//Radio button for Normal Temperature
		JRadioButton Normal = new JRadioButton("Normal");
		Normal.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent myEvent) 
			{
				if(Normal.isSelected() == true)
				{
					setTemperature("normal");
					
					setCounter(getCounter() + 1);
					
				}
			}
		});
		
		
		buttonGroup.add(Normal);
		Normal.setBounds(168, 133, 79, 23);
		contentPane.add(Normal);
		
		
		//Radio button for hot temperature
		JRadioButton Hot = new JRadioButton("Hot");
		Hot.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent myEvent) 
			{
				if(Hot.isSelected() == true)
				{
					setTemperature("hot");
					
					setCounter(getCounter() + 1);
				}
			}
		});
		
		
		buttonGroup.add(Hot);
		Hot.setBounds(249, 133, 109, 23);
		contentPane.add(Hot);
		
		
		//Radio button for Aches Yes
		JRadioButton achesYes = new JRadioButton("Yes");
		achesYes.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent myEvent) 
			{
				if(achesYes.isSelected() == true)
				{
					setAches("yes");
					
					setCounter(getCounter() + 1);
					
				}
			}
		});
		
		
		buttonGroup_1.add(achesYes);
		achesYes.setBounds(103, 158, 56, 23);
		contentPane.add(achesYes);
		
		//Radio button for Aches no
		JRadioButton achesNo = new JRadioButton("No");
		achesNo.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent myEvent) 
			{
				if(achesNo.isSelected() == true)
				{
					setAches("no");
					
					setCounter(getCounter() + 1);
				}
			}
		});
		
		
		buttonGroup_1.add(achesNo);
		achesNo.setBounds(168, 158, 109, 23);
		contentPane.add(achesNo);
		
		//Radio button for SoreThroat Yes
		JRadioButton soreThroatYes = new JRadioButton("Yes");
		soreThroatYes.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent myEvent) 
			{
				if(soreThroatYes.isSelected() == true)
				{
					setSoreThroat("yes");
					
					
					setCounter(getCounter() + 1);
				}
			}
		});
		buttonGroup_2.add(soreThroatYes);
		soreThroatYes.setBounds(103, 183, 64, 23);
		contentPane.add(soreThroatYes);
		
		//Radio button for SoreThroat No
		JRadioButton soreThroatNo = new JRadioButton("No");
		soreThroatNo.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent myEvent) 
			{
				if(soreThroatNo.isSelected() == true)
				{
					setSoreThroat("no");
					
					setCounter(getCounter() + 1);
					
				}
			}
		});
		buttonGroup_2.add(soreThroatNo);
		soreThroatNo.setBounds(168, 183, 109, 23);
		contentPane.add(soreThroatNo);
		
		//Radio for Cough Yes
		JRadioButton coughYes = new JRadioButton("Yes");
		coughYes.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent myEvent) 
			{
				if(coughYes.isSelected() == true)
				{
					setCough("yes");
					
					setCounter(getCounter() + 1);
					
				}
			}
		});
		buttonGroup_3.add(coughYes);
		coughYes.setBounds(96, 207, 56, 23);
		contentPane.add(coughYes);
		
		
		//Radio button for Cough No
		JRadioButton coughNo = new JRadioButton("No");
		coughNo.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent myEvent) 
			{
				if(coughNo.isSelected() == true)
				{
					setCough("no");
					
					setCounter(getCounter() + 1);
				}
			}
		});
		buttonGroup_3.add(coughNo);
		coughNo.setBounds(168, 208, 109, 23);
		contentPane.add(coughNo);
		
		//Radio button for Been to DZ Yes
		JRadioButton DZYes = new JRadioButton("Yes");
		DZYes.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent myEvent) 
			{
				if(DZYes.isSelected() == true)
				{
					setTravelFromDZ("yes");
					counter++;
				}
			}
		});
		buttonGroup_4.add(DZYes);
		DZYes.setBounds(168, 233, 56, 23);
		contentPane.add(DZYes);
		
		//Radio button for Been to DZ No
		JRadioButton DZNo = new JRadioButton("No");
		DZNo.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent myEvent) 
			{
				if(DZNo.isSelected() == true)
				{
					setTravelFromDZ("no");
					counter++;
				}
			}
		});
		buttonGroup_4.add(DZNo);
		DZNo.setBounds(229, 233, 109, 23);
		contentPane.add(DZNo);
	}

	private String getTemperature() {
		return temperature;
	}

	private void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	private String getAches() {
		return aches;
	}

	private void setAches(String aches) {
		this.aches = aches;
	}

	private String getCough() {
		return cough;
	}

	private void setCough(String cough) {
		this.cough = cough;
	}

	private String getSoreThroat() {
		return soreThroat;
	}

	private void setSoreThroat(String soreThroat) {
		this.soreThroat = soreThroat;
	}

	private String getTravelFromDZ() {
		return travelFromDZ;
	}

	private void setTravelFromDZ(String travelFromDZ) {
		this.travelFromDZ = travelFromDZ;
	}

	private String getHasCOVID19() {
		return hasCOVID19;
	}

	private void setHasCOVID19(String hasCOVID19) {
		this.hasCOVID19 = hasCOVID19;
	}

	private int getCounter() {
		return counter;
	}

	private void setCounter(int counter) {
		this.counter = counter;
	}
}
