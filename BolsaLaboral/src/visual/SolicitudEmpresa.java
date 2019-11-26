package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Panel;
import java.awt.ScrollPane;
import javax.swing.JRadioButton;
import java.awt.Choice;

public class SolicitudEmpresa extends JDialog {
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SolicitudEmpresa dialog = new SolicitudEmpresa();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SolicitudEmpresa() {
		setTitle("Solicitud Empresa");
		setBounds(100, 100, 600, 385);
		getContentPane().setLayout(null);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBounds(0, 303, 582, 35);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("Enviar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n General", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(12, 13, 558, 119);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo Empresa");
		lblCdigo.setBounds(12, 33, 109, 16);
		panel.add(lblCdigo);
		
		textField = new JTextField();
		textField.setBounds(116, 30, 116, 22);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre Empresa");
		lblNombre.setBounds(12, 75, 109, 16);
		panel.add(lblNombre);
		
		textField_1 = new JTextField();
		textField_1.setBounds(126, 72, 116, 22);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setBounds(276, 33, 56, 16);
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Nivel Ac\u00E1demico", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(12, 135, 558, 70);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Universitario");
		rdbtnNewRadioButton.setBounds(38, 24, 107, 25);
		panel_1.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnTcnico = new JRadioButton("T\u00E9cnico");
		rdbtnTcnico.setBounds(200, 24, 73, 25);
		panel_1.add(rdbtnTcnico);
		
		JRadioButton rdbtnObrero = new JRadioButton("Obrero");
		rdbtnObrero.setBounds(360, 24, 73, 25);
		panel_1.add(rdbtnObrero);
	}
}
