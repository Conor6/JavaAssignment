package MachineLearning;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;





@SuppressWarnings("serial")
public class GUI extends JFrame implements ActionListener
{


	/**
	 * Create the frame.
	 */
	public GUI() {
		getContentPane().setBackground(Color.WHITE);
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

					JOptionPane.showMessageDialog(getContentPane(),"The program will exit");
					
					System.exit(0);
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
		
		JLabel lblCoronavirusTestingTool = new JLabel("COVID19 Testing Tool");
		lblCoronavirusTestingTool.setBackground(Color.WHITE);
		
		lblCoronavirusTestingTool.setFont(new Font("Arial Black", Font.BOLD, 24));
		
		lblCoronavirusTestingTool.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblCoronavirusTestingTool.setBounds(10, 11, 619, 35);
		
		getContentPane().add(lblCoronavirusTestingTool);
		
		
		JButton btnNewButton = new JButton("Check");
		
		
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent myEvent) 
			{
				if(myEvent.getSource() == btnNewButton) 
				{
					//This will display pop-up
					CoronaCheck patient = new CoronaCheck();
					setVisible(false);
					patient.setVisible(true);
					
				}
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		
		btnNewButton.setBounds(109, 340, 89, 23);
		
		getContentPane().add(btnNewButton);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		// TODO Auto-generated method stub
		
	}
}
