/*			Cards
 * 
 * Programmer: Nick Couzelis
 * 		 Date: 29/03/2017
 * 
 * This program finds a random card or user selected card from a number.
 * goo.gl/Bdq728
 */

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

import java.awt.color.*;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class Frame extends JFrame {

	private JPanel contentPane;
	private JTextField txtInput;
	private JTextField txtValue;
	private JTextField txtSuit;

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
	 * Set outputs from card number.
	 */
	public void cardInfo(int num){
		if(num<=13){
			txtSuit.setText("Clubs");
			txtSuit.setForeground(Color.BLACK);
		}else if(num<=26){
			txtSuit.setText("Spades");
			txtSuit.setForeground(Color.BLACK);
		}else if(num<=39){
			txtSuit.setText("Hearts");
			txtSuit.setForeground(Color.RED);
		}else{
			txtSuit.setText("Diamonds");
			txtSuit.setForeground(Color.RED);
		}

		switch(num % 13){
		case 0: txtValue.setText("King");	//0 is King as 13%13 or 39%13 is 0
				break;
		case 1:	txtValue.setText("Ace");
				break;
		case 2:	txtValue.setText("Two");
				break;
		case 3:	txtValue.setText("Three");
				break;
		case 4:	txtValue.setText("Four");
				break;
		case 5:	txtValue.setText("Five");
				break;
		case 6:	txtValue.setText("Six");
				break;
		case 7:	txtValue.setText("Seven");
				break;
		case 8:	txtValue.setText("Eight");
				break;
		case 9:	txtValue.setText("Nine");
				break;
		case 10:txtValue.setText("Ten");
				break;
		case 11:txtValue.setText("Jack");
				break;
		case 12:txtValue.setText("Queen");
				break;
		}
	}
	
	
	/**
	 * Create the frame.
	 */
	public Frame() {
		setTitle("Cards");
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
				int num = (int)(Math.random()*52); 			//Random number from 1-52
				
				txtInput.setText(Integer.toString(num));	//Set Input Field to number selected
				cardInfo(num);
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
					txtValue.setText("Invalid Input.");
					txtSuit.setText("");
					return;
				}
				
				if(!(num<53&&num>0)){	//Checking if input value is 0-52
					txtValue.setText("Input 1-52");
					txtSuit.setText("");
					return;
				}
				
				cardInfo(num);
				
			}
		});
		btnInput.setMargin(new Insets(2, 2, 2, 2));
		btnInput.setBounds(50, 45, 49, 23);
		contentPane.add(btnInput);
		
		txtInput = new JTextField();
		txtInput.setBounds(10, 46, 30, 20);
		contentPane.add(txtInput);
		txtInput.setColumns(10);
		
		txtValue = new JTextField();
		txtValue.setHorizontalAlignment(SwingConstants.CENTER);
		txtValue.setEditable(false);
		txtValue.setBounds(109, 12, 86, 20);
		contentPane.add(txtValue);
		txtValue.setColumns(10);
		
		txtSuit = new JTextField();
		txtSuit.setHorizontalAlignment(SwingConstants.CENTER);
		txtSuit.setEditable(false);
		txtSuit.setBounds(109, 46, 86, 20);
		contentPane.add(txtSuit);
		txtSuit.setColumns(10);
		
		JLabel lblOf = new JLabel("of");
		lblOf.setHorizontalAlignment(SwingConstants.CENTER);
		lblOf.setBounds(128, 31, 46, 14);
		contentPane.add(lblOf);
	}
}
