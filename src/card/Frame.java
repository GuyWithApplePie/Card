package card;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Frame extends JFrame {

	private JPanel contentPane;
	private JTextField txtInput;
	private JTextField txtSuit;
	private JTextField txtValue;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame frame = new Frame();
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
	public Frame() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 219, 114);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnRandom = new JButton("Random Card");
		//A random card is selected and displayed.
		btnRandom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Variable List
				int num = (int)(Math.random()*52); //Random number from 1-52
				txtInput.setText("");

			
			}
		});
		btnRandom.setMargin(new Insets(2, 2, 2, 2));
		btnRandom.setBounds(10, 11, 89, 23);
		contentPane.add(btnRandom);

		JButton btnInput = new JButton("Input");
		//The input value is checked then the corresponding card is displayed.
		btnInput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Variable List
				int num = 0;	//User input.
				
				try{			//Checking for integer.
					num = Integer.parseInt(txtInput.getText());
				} catch(NullPointerException|NumberFormatException x){
					txtSuit.setText("Invalid Input.");
					txtValue.setText("");
					return;
				}
				
				if(!(num<=52&&num>0)){	//Checking if input value is 0-52
					txtSuit.setText("Input 1-52");
					txtValue.setText("");
				}
			}
		});
		btnInput.setMargin(new Insets(2, 2, 2, 2));
		btnInput.setBounds(50, 45, 49, 23);
		contentPane.add(btnInput);
		
		txtInput = new JTextField();
		txtInput.setBounds(10, 46, 30, 20);
		contentPane.add(txtInput);
		txtInput.setColumns(10);
		
		txtSuit = new JTextField();
		txtSuit.setEditable(false);
		txtSuit.setBounds(109, 12, 86, 20);
		contentPane.add(txtSuit);
		txtSuit.setColumns(10);
		
		txtValue = new JTextField();
		txtValue.setEditable(false);
		txtValue.setBounds(109, 46, 86, 20);
		contentPane.add(txtValue);
		txtValue.setColumns(10);
	}
}
