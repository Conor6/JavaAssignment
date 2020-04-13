package MachineLearning;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddPatient extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPatient frame = new AddPatient();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddPatient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCoronavirusTestingTool = new JLabel("Coronavirus Testing Tool");
		lblCoronavirusTestingTool.setFont(new Font("Arial Black", Font.BOLD, 24));
		lblCoronavirusTestingTool.setHorizontalAlignment(SwingConstants.CENTER);
		lblCoronavirusTestingTool.setBounds(10, 11, 414, 35);
		contentPane.add(lblCoronavirusTestingTool);
		
		JLabel lblEnterPaitientInformation = new JLabel("Enter Patient Information:");
		lblEnterPaitientInformation.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		lblEnterPaitientInformation.setBounds(10, 76, 267, 14);
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
		
		textField = new JTextField();
		textField.setBounds(97, 134, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(97, 159, 96, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(97, 186, 96, 20);
		contentPane.add(textField_2);
		
		JLabel lblCough = new JLabel("Cough:\r\n");
		lblCough.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblCough.setBounds(229, 137, 87, 14);
		contentPane.add(lblCough);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(285, 134, 96, 20);
		contentPane.add(textField_3);
		
		JLabel lblTravelledFromDanger = new JLabel("Been to Danger Zone:");
		lblTravelledFromDanger.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTravelledFromDanger.setBounds(229, 162, 152, 14);
		contentPane.add(lblTravelledFromDanger);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(359, 159, 65, 20);
		contentPane.add(textField_4);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBackground(Color.BLACK);
		btnAdd.setBounds(124, 227, 89, 23);
		contentPane.add(btnAdd);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(229, 227, 89, 23);
		contentPane.add(btnNewButton);
	}
}
