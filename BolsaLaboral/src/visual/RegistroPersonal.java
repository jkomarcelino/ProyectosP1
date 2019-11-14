package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.ScrollPane;

public class RegistroPersonal extends JFrame {

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
					RegistroPersonal frame = new RegistroPersonal();
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
	public RegistroPersonal() {
		setTitle("Registro de Datos Personales");
		setForeground(Color.BLACK);
		setFont(new Font("Dialog", Font.PLAIN, 12));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(12, 34, 56, 16);
		contentPane.add(lblNombre);
		
		textField = new JTextField();
		textField.setBounds(92, 31, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(12, 72, 56, 16);
		contentPane.add(lblApellido);
		
		textField_1 = new JTextField();
		textField_1.setBounds(92, 69, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblCdula = new JLabel("C\u00E9dula");
		lblCdula.setBounds(220, 52, 56, 16);
		contentPane.add(lblCdula);
		
		textField_2 = new JTextField();
		textField_2.setBounds(271, 49, 116, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(12, 114, 56, 16);
		contentPane.add(lblTelefono);
		
		textField_3 = new JTextField();
		textField_3.setBounds(92, 111, 116, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Correo");
		lblNewLabel.setBounds(220, 87, 56, 16);
		contentPane.add(lblNewLabel);
		
		textField_4 = new JTextField();
		textField_4.setBounds(271, 84, 116, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblEstaraDispuestoaA = new JLabel("Estar\u00EDa dispuesto/a a viajar?");
		lblEstaraDispuestoaA.setBounds(130, 198, 162, 16);
		contentPane.add(lblEstaraDispuestoaA);
		
		JRadioButton rdbtnSi = new JRadioButton("Si");
		rdbtnSi.setBounds(149, 171, 39, 25);
		contentPane.add(rdbtnSi);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBounds(222, 171, 54, 25);
		contentPane.add(rdbtnNo);
		
		JLabel lblCuentaConVehiculo = new JLabel("Cuenta con veh\u00EDculo propio?");
		lblCuentaConVehiculo.setBounds(130, 146, 182, 16);
		contentPane.add(lblCuentaConVehiculo);
		
		JRadioButton rdbtnSi_1 = new JRadioButton("Si");
		rdbtnSi_1.setBounds(149, 219, 39, 25);
		contentPane.add(rdbtnSi_1);
		
		JRadioButton rdbtnNo_1 = new JRadioButton("No");
		rdbtnNo_1.setBounds(222, 219, 54, 25);
		contentPane.add(rdbtnNo_1);
	}
}
