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

public class RegPersona extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtGenero;
	private JTextField txtEdad;
	private JTextField txtId;
	private JTextField textField_4;
	private JTextField txtApellido;
	private JTextField txtEmail;

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
		setBounds(100, 100, 450, 379);
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
			lblNombre.setBounds(10, 54, 61, 14);
			panel.add(lblNombre);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(80, 51, 111, 20);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			txtGenero = new JTextField();
			txtGenero.setColumns(10);
			txtGenero.setBounds(80, 82, 111, 20);
			panel.add(txtGenero);
			
			JLabel lblGnero = new JLabel("G\u00E9nero:");
			lblGnero.setBounds(10, 85, 61, 14);
			panel.add(lblGnero);
			
			txtEdad = new JTextField();
			txtEdad.setColumns(10);
			txtEdad.setBounds(294, 82, 111, 20);
			panel.add(txtEdad);
			
			JLabel lblEdad = new JLabel("Edad:");
			lblEdad.setBounds(229, 85, 46, 14);
			panel.add(lblEdad);
			
			txtId = new JTextField();
			txtId.setColumns(10);
			txtId.setBounds(80, 23, 74, 20);
			panel.add(txtId);
			
			JLabel lblCdigo = new JLabel("C\u00F3digo:");
			lblCdigo.setBounds(10, 26, 61, 14);
			panel.add(lblCdigo);
			
			textField_4 = new JTextField();
			textField_4.setColumns(10);
			textField_4.setBounds(80, 113, 111, 20);
			panel.add(textField_4);
			
			JLabel lblIdiomas = new JLabel("Idiomas:");
			lblIdiomas.setBounds(229, 26, 61, 14);
			panel.add(lblIdiomas);
			
			txtApellido = new JTextField();
			txtApellido.setColumns(10);
			txtApellido.setBounds(294, 54, 111, 20);
			panel.add(txtApellido);
			
			JLabel lblApellido = new JLabel("Apellido:");
			lblApellido.setBounds(229, 54, 51, 14);
			panel.add(lblApellido);
			
			JComboBox cmbIdiomas = new JComboBox();
			cmbIdiomas.setBounds(294, 23, 111, 20);
			panel.add(cmbIdiomas);
			
			JLabel lblEmail = new JLabel("E-mail:");
			lblEmail.setBounds(10, 116, 46, 14);
			panel.add(lblEmail);
			
			JLabel label = new JLabel("E-mail:");
			label.setBounds(231, 116, 46, 14);
			panel.add(label);
			
			txtEmail = new JTextField();
			txtEmail.setColumns(10);
			txtEmail.setBounds(294, 113, 111, 20);
			panel.add(txtEmail);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, "Adicional", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(10, 154, 404, 132);
			panel.add(panel_1);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
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
