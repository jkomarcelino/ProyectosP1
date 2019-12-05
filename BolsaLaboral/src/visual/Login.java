package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import logico.BolsaLaboral;
import logico.Empresa;
import logico.Personal;


import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Login extends JFrame {
/*
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 *
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				FileInputStream empresa;
				FileOutputStream empresa2;
				ObjectInputStream empresaRead;
				ObjectOutputStream empresaWrite;
				try {
					empresa = new FileInputStream ("BolsaLaboral.dat");
					empresaRead = new ObjectInputStream(empresa);
					BolsaLaboral temp = (BolsaLaboral)empresaRead.readObject();
			//		BolsaLaboral.getInstance().insertEmpresa(temp);
					
				} catch (FileNotFoundException e) {
					try {
						empresa2 = new  FileOutputStream("altice.dat");
						empresaWrite = new ObjectOutputStream(empresa2);
					/*	Personal aux = new Administrador("1","Altice",0,"Altice","altice",0, "Recursos Humanos");
						Empresa.getInstance().insertpersonal(aux);
						empresaWrite.writeObject(Empresa.getInstance());
					} catch (FileNotFoundException e1) {
					} catch (IOException e1) {
						// TODO Auto-generated catch block
					}
				} catch (IOException e) {
					
					
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				try {
				/*	login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 252, 267);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(20, 21, 147, 14);
		panel.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setBounds(20, 103, 105, 14);
		panel.add(lblContrasea);
		
		textField = new JTextField();
		textField.setBounds(20, 48, 191, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(true){
					NewPrincipalVisual frame = new NewPrincipalVisual();
					dispose();
					frame.setVisible(true);
				};
				
			}
		});
		btnLogin.setBounds(59, 172, 89, 23);
		panel.add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(20, 128, 191, 20);
		panel.add(passwordField);
	}
*/
}
