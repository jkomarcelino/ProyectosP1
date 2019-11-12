package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class Principal extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setTitle("Bolsa Laboral");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 596, 383);
		getContentPane().setLayout(null);
		
		JButton btnRegistroPersonal = new JButton("Registro Personal");
		btnRegistroPersonal.setBounds(195, 203, 166, 25);
		getContentPane().add(btnRegistroPersonal);
		
		JButton btnRegistroEmpresa = new JButton("Registro Empresa");
		btnRegistroEmpresa.setBounds(195, 129, 160, 25);
		getContentPane().add(btnRegistroEmpresa);
	}
}
