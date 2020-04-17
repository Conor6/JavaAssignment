package MachineLearning;

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

	private JFileChooser openFileChooser;
	private String fileName;
	
	
	/**
	 * Create the frame.
	 */
	public GUI() 
	{
		getContentPane().setFont(new Font("Arial Black", Font.PLAIN, 14));
		
		
		
		
		getContentPane().setBackground(new Color(135, 206, 235));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 462);
		getContentPane().setLayout(null);
		
		JButton btnExit = new JButton("Exit");
		
		btnExit.setForeground(new Color(0, 0, 0));
		
		btnExit.setBackground(new Color(255, 255, 255));
		
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
		
		
		
		JButton btnTrainProgram = new JButton("Accuracy");
		btnTrainProgram.setForeground(new Color(0, 0, 0));
		
		btnTrainProgram.setBackground(new Color(255, 255, 255));
		
		btnTrainProgram.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent myEvent) 
			{
				if(myEvent.getSource() == btnTrainProgram) 
				{
					TestAccuracy accuracy = new TestAccuracy();
					
					accuracy.findAccuracy();

					JOptionPane.showMessageDialog(getContentPane(),"The accuracy of this program is " +accuracy.getCorrect()+ "%");
					
				}
				
			}
			
			
		});
		btnTrainProgram.setBounds(10, 340, 109, 23);
		getContentPane().add(btnTrainProgram);
		
		
		JButton btnNewButton = new JButton("Check");
		btnNewButton.setForeground(new Color(0, 0, 0));
		
		
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
		btnNewButton.setBackground(new Color(255, 255, 255));
		
		btnNewButton.setBounds(129, 340, 89, 23);
		
		getContentPane().add(btnNewButton);
		
		JButton btnChooseFile = new JButton("Choose File");
		btnChooseFile.setBackground(new Color(255, 255, 255));
		btnChooseFile.setForeground(new Color(0, 0, 0));
		
		
		openFileChooser = new JFileChooser();
		openFileChooser.setCurrentDirectory(new File("C:\\temp"));
		openFileChooser.setFileFilter(new FileNameExtensionFilter(".csv file", ".csv"));
		
		btnChooseFile.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent myEvent) 
			{
				if(myEvent.getSource() == btnChooseFile) 
				{
					chooseFile();
					Control.setCsvFile(getFileName());
					
				}
			}
		});
		btnChooseFile.setBounds(260, 340, 101, 23);
		getContentPane().add(btnChooseFile);
		
		JPanel panel = new JPanel();
		panel.setBounds(157, 24, 366, 49);
		getContentPane().add(panel);
		
		JLabel lblCoronavirusTestingTool = new JLabel("COVID19 Testing Tool");
		panel.add(lblCoronavirusTestingTool);
		lblCoronavirusTestingTool.setForeground(new Color(0, 0, 0));
		lblCoronavirusTestingTool.setBackground(new Color(0, 0, 0));
		
		lblCoronavirusTestingTool.setFont(new Font("Arial Black", Font.BOLD, 24));
		
		lblCoronavirusTestingTool.setHorizontalAlignment(SwingConstants.CENTER);
		
		

		
	}
	public String chooseFile() 
	{
		
		 Control.setCsvFile("C:\\Users\\conor\\git\\JavaAssignment\\Java Assignment\\MLdata.csv");
		
		openFileChooser = new JFileChooser();
		openFileChooser.setCurrentDirectory(new File("C:\\"));
		openFileChooser.setFileFilter(new FileNameExtensionFilter(".csv file", ".csv"));
		
		int returnValue = openFileChooser.showOpenDialog(getContentPane());
		
		if(returnValue == JFileChooser.APPROVE_OPTION)
		{
			setFileName(openFileChooser.getSelectedFile().getPath());
			
			System.out.println(Control.getCsvFile());
		}
		else
		{
			System.out.println("No file chosen!");
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
