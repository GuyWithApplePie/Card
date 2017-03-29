package card;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Insets;

public class Frame extends JFrame {

	private JPanel contentPane;
	private JTextField txtInput;
	private JTextField textField;
	private JTextField textField_1;

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
		btnRandom.setMargin(new Insets(2, 2, 2, 2));
		btnRandom.setBounds(10, 11, 89, 23);
		contentPane.add(btnRandom);
		
		JButton btnInput = new JButton("Input");
		btnInput.setMargin(new Insets(2, 2, 2, 2));
		btnInput.setBounds(50, 45, 49, 23);
		contentPane.add(btnInput);
		
		txtInput = new JTextField();
		txtInput.setBounds(10, 46, 30, 20);
		contentPane.add(txtInput);
		txtInput.setColumns(10);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(109, 12, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(109, 46, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
	}
}
