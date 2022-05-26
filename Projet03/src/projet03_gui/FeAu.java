/* Fichier FeAu.java
 * Auteur : rebec
 * Date de création : May 11, 2022
 */
package projet03_gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import util.UserInfo;

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
	private static JLabel lbl_Status;
	//My attributes
	private UserInfo user = new UserInfo();
	private boolean verify = false;
	private FeGestion frameGestion;
	

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					FeAu frameAu = new FeAu();
					frameAu.setVisible(true);					
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
		btnNewButton.addActionListener(new BtnNewButtonActionListener());
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
		lbl_Status.setVisible(false);
		contentPane.add(lbl_Status);
	}
	
	
	public boolean authentifier() {
		int i = 0;
		String id = textField_Username.getText();
		String pwd = String.valueOf(passwordField.getPassword());
		System.out.println("ID: " + id + "\nPassword : " + pwd);
		
		while(i < user.getPwd().size()) {
			if(id.equals(user.getUsername().get(i)) 
					&& pwd.equals(user.getPwd().get(i))) {
				verify = true;
			}
			i++;
		}
		return verify;
	}//fin méthode
	
	
	public class BtnNewButtonActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			//Nom utilisteur : Rebecca et Jackson
			//Mot de pass : prog
			try {
				boolean check = authentifier();
				if (check == true) {
					frameGestion = new FeGestion();
					frameGestion.setVisible(true);
					lbl_Status.setVisible(false);
					dispose();
					//frameAu.setVisible(false);
				}else{
					lbl_Status.setVisible(true);
				}
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}//fin méthode
}
