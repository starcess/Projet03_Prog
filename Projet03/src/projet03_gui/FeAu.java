/* Fichier FeAu.java
 * Auteur : rebec
 * Date de création : May 11, 2022
 */
package projet03_gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 *  TODO
 * Author : Prénom, nom
 */
public class FeAu extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					FeAu frame = new FeAu();
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
	public FeAu() {
		initialize();
	}
	private void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setText("");
		textField.setBounds(92, 47, 72, 27);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(92, 98, 72, 32);
		contentPane.add(passwordField);
	}
	
	public boolean authentifier() {
		String id = textField.getText();
		String pwd = String.valueOf(passwordField.getPassword());
		System.out.println("ID: " + id + "\nPassword : " + pwd);
		return true;
	}
}
