package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import java.awt.Color;

public class SolicitudPersonal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SolicitudPersonal frame = new SolicitudPersonal();
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
	public SolicitudPersonal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(12, 13, 56, 16);
		contentPane.add(label_1);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBorder(new TitledBorder(null, "Nivel de Educaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(22, 13, 398, 71);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JRadioButton rdbtnUniversitario = new JRadioButton("Universitario");
		rdbtnUniversitario.setBounds(8, 25, 99, 25);
		panel.add(rdbtnUniversitario);
		
		JRadioButton rdbtnTcnico = new JRadioButton("T\u00E9cnico");
		rdbtnTcnico.setBounds(121, 25, 82, 25);
		panel.add(rdbtnTcnico);
		
		JRadioButton rdbtnObrero = new JRadioButton("Obrero");
		rdbtnObrero.setBounds(214, 25, 69, 25);
		panel.add(rdbtnObrero);
	}
}
