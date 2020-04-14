package MachineLearning;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.Box;
import java.awt.Component;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JEditorPane;

public class GUI extends JFrame implements ActionListener
{


	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 655, 413);
		getContentPane().setLayout(null);
		
		JButton btnExit = new JButton("Exit");
		
		btnExit.setForeground(Color.BLACK);
		
		btnExit.setBackground(Color.WHITE);
		
		btnExit.setBounds(540, 340, 89, 23);
		
		getContentPane().add(btnExit);
		
		
		btnExit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent myEvent) 
			{
				if(myEvent.getSource() == btnExit) 
				{

					setVisible(false);
					
				}
			}
			
			
		});
		
		
		
		JButton btnTrainProgram = new JButton("Train ");
		
		btnTrainProgram.setBackground(Color.WHITE);
		
		btnTrainProgram.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				
			}
			
			
		});
		btnTrainProgram.setBounds(10, 340, 89, 23);
		getContentPane().add(btnTrainProgram);
		
		JLabel lblCoronavirusTestingTool = new JLabel("Coronavirus Testing Tool");
		
		lblCoronavirusTestingTool.setFont(new Font("Arial Black", Font.BOLD, 24));
		
		lblCoronavirusTestingTool.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblCoronavirusTestingTool.setBounds(10, 0, 619, 47);
		
		getContentPane().add(lblCoronavirusTestingTool);
		
		
		JButton btnAddPatient = new JButton("Add Patient");
		
		btnAddPatient.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent myEvent) 
			{
				if(myEvent.getSource() == btnAddPatient) 
				{
					//This will display pop-up
					AddPatient patient = new AddPatient();
					patient.setVisible(true);
					
				}
				
			
			}
		});
		
		
		btnAddPatient.setBackground(Color.WHITE);
		
		btnAddPatient.setBounds(109, 340, 105, 23);
		
		getContentPane().add(btnAddPatient);
		
		
		JButton btnNewButton = new JButton("Check");
		
		
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent myEvent) 
			{
				if(myEvent.getSource() == btnNewButton) 
				{
					//This will display pop-up
					CoronaCheck patient = new CoronaCheck();
					patient.setVisible(true);
					
				}
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		
		btnNewButton.setBounds(296, 340, 89, 23);
		
		getContentPane().add(btnNewButton);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
	}
}
