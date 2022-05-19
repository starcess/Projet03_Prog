/* Fichier FeAu.java
 * Auteur : rebec
 * Date de création : May 11, 2022
 */
package projet03_gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	private JTextField textField_Username;
	private JPasswordField passwordField;
	private JButton btnNewButton;
	private JLabel lbl_Username;
	private JLabel lbl_Pasword;
	private JLabel lbl_Status;

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
		setTitle("Authentification");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_Username = new JTextField();
		textField_Username.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_Username.setText("");
		textField_Username.setBounds(172, 74, 192, 32);
		contentPane.add(textField_Username);
		textField_Username.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordField.setBounds(172, 140, 192, 38);
		contentPane.add(passwordField);
		
		btnNewButton = new JButton("Connexion");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(35, 204, 127, 32);
		contentPane.add(btnNewButton);
		
		lbl_Username = new JLabel("Utilisateur :");
		lbl_Username.setForeground(Color.WHITE);
		lbl_Username.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_Username.setBounds(46, 83, 86, 13);
		contentPane.add(lbl_Username);
		
		lbl_Pasword = new JLabel("Mot de passe :");
		lbl_Pasword.setForeground(Color.WHITE);
		lbl_Pasword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_Pasword.setBounds(46, 152, 116, 13);
		contentPane.add(lbl_Pasword);
		
		lbl_Status = new JLabel("essayer de nouveau");
		lbl_Status.setForeground(Color.RED);
		lbl_Status.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_Status.setBounds(194, 214, 144, 13);
		contentPane.add(lbl_Status);
	}
	
	public boolean authentifier() {
		String id = textField_Username.getText();
		String pwd = String.valueOf(passwordField.getPassword());
		System.out.println("ID: " + id + "\nPassword : " + pwd);
		return true;
	}
}
