package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.ImageIcon;

public class RegEmpresa extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtId;
	private JTextField txtApellido;
	private JTextField txtEmail;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegEmpresa dialog = new RegEmpresa();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegEmpresa() {
		setBounds(100, 100, 425, 332);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n de la Empresa", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel lblNombre = new JLabel("Nombre Empresa:");
			lblNombre.setBounds(10, 54, 93, 14);
			panel.add(lblNombre);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(113, 51, 116, 20);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			JLabel lblGnero = new JLabel("Tipo de Empresa:");
			lblGnero.setBounds(10, 116, 94, 14);
			panel.add(lblGnero);
			
			txtId = new JTextField();
			txtId.setColumns(10);
			txtId.setBounds(113, 20, 116, 20);
			panel.add(txtId);
			
			JLabel lblCdigo = new JLabel("C\u00F3digo Empresa:");
			lblCdigo.setBounds(10, 26, 93, 14);
			panel.add(lblCdigo);
			
			txtApellido = new JTextField();
			txtApellido.setColumns(10);
			txtApellido.setBounds(113, 82, 116, 20);
			panel.add(txtApellido);
			
			JLabel lblApellido = new JLabel("Ubicaci\u00F3n Empresa:");
			lblApellido.setBounds(10, 86, 111, 14);
			panel.add(lblApellido);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Contacto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_1.setBounds(10, 147, 379, 92);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			textField = new JTextField();
			textField.setBounds(118, 59, 146, 20);
			panel_1.add(textField);
			textField.setColumns(10);
			
			JLabel lblEmail = new JLabel("Correo Electr\u00F3nico:");
			lblEmail.setBounds(10, 31, 102, 14);
			panel_1.add(lblEmail);
			
			txtEmail = new JTextField();
			txtEmail.setBounds(118, 28, 146, 20);
			panel_1.add(txtEmail);
			txtEmail.setColumns(10);
			
			JLabel lblTelefono = new JLabel("Telefono:");
			lblTelefono.setBounds(10, 62, 64, 14);
			panel_1.add(lblTelefono);
			
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(RegEmpresa.class.getResource("/icon/customer-service.png")));
			lblNewLabel_1.setBounds(285, 11, 71, 68);
			panel_1.add(lblNewLabel_1);
			
			JComboBox comboBox = new JComboBox();
			comboBox.setBounds(113, 113, 116, 20);
			panel.add(comboBox);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(RegEmpresa.class.getResource("/icon/online-store (2).png")));
			lblNewLabel.setBounds(252, 9, 137, 121);
			panel.add(lblNewLabel);
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

