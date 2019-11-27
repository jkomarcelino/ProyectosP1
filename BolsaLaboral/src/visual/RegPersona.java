package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class RegPersona extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtGenero;
	private JTextField txtEdad;
	private JTextField txtId;
	private JTextField textField_4;
	private JTextField txtApellido;
	private JTextField txtEmail;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegPersona dialog = new RegPersona();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegPersona() {
		setTitle("Registro Personal");
		setBounds(100, 100, 448, 378);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(null, "Informaci\u00F3n de la Persona", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(10, 60, 61, 14);
			panel.add(lblNombre);
			
			txtGenero = new JTextField();
			txtGenero.setColumns(10);
			txtGenero.setBounds(81, 120, 132, 20);
			panel.add(txtGenero);
			
			JLabel lblGnero = new JLabel("G\u00E9nero:");
			lblGnero.setBounds(10, 123, 61, 14);
			panel.add(lblGnero);
			
			txtEdad = new JTextField();
			txtEdad.setColumns(10);
			txtEdad.setBounds(81, 151, 132, 20);
			panel.add(txtEdad);
			
			JLabel lblEdad = new JLabel("Edad:");
			lblEdad.setBounds(10, 154, 46, 14);
			panel.add(lblEdad);
			
			txtId = new JTextField();
			txtId.setColumns(10);
			txtId.setBounds(81, 26, 74, 20);
			panel.add(txtId);
			
			JLabel lblCdigo = new JLabel("C\u00E9dula:");
			lblCdigo.setBounds(10, 29, 61, 14);
			panel.add(lblCdigo);
			
			JLabel lblIdiomas = new JLabel("Idiomas:");
			lblIdiomas.setBounds(10, 185, 61, 14);
			panel.add(lblIdiomas);
			
			txtApellido = new JTextField();
			txtApellido.setColumns(10);
			txtApellido.setBounds(81, 89, 132, 20);
			panel.add(txtApellido);
			
			JLabel lblApellido = new JLabel("Apellido:");
			lblApellido.setBounds(10, 92, 51, 14);
			panel.add(lblApellido);
			
			JComboBox cmbIdiomas = new JComboBox();
			cmbIdiomas.setBounds(81, 182, 132, 20);
			panel.add(cmbIdiomas);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(81, 57, 132, 20);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "Contacto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(10, 223, 405, 62);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblEmail = new JLabel("E-mail:");
			lblEmail.setBounds(10, 27, 46, 14);
			panel_1.add(lblEmail);
			
			textField_4 = new JTextField();
			textField_4.setBounds(62, 24, 111, 20);
			panel_1.add(textField_4);
			textField_4.setColumns(10);
			
			JLabel lblTelef = new JLabel("Tel\u00E9fono:");
			lblTelef.setBounds(205, 27, 61, 14);
			panel_1.add(lblTelef);
			
			txtEmail = new JTextField();
			txtEmail.setBounds(276, 24, 111, 20);
			panel_1.add(txtEmail);
			txtEmail.setColumns(10);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(RegPersona.class.getResource("/icon/boss127.png")));
			lblNewLabel.setBounds(268, 71, 128, 128);
			panel.add(lblNewLabel);
			
			JLabel lblCdigo_1 = new JLabel("C\u00F3digo: ");
			lblCdigo_1.setBounds(243, 29, 46, 14);
			panel.add(lblCdigo_1);
			
			textField = new JTextField();
			textField.setBounds(299, 26, 86, 20);
			panel.add(textField);
			textField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
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
	}
}
