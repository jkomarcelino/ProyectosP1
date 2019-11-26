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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegEmpresa extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtId;
	private JTextField txtApellido;
	private JTextField txtEmail;
	private JTextField txtTlf;

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
		setBounds(100, 100, 501, 346);
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
			lblNombre.setBounds(10, 60, 128, 14);
			panel.add(lblNombre);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(142, 57, 137, 20);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			txtId = new JTextField();
			txtId.setColumns(10);
			txtId.setBounds(142, 20, 137, 20);
			panel.add(txtId);
			
			JLabel lblCdigo = new JLabel("C\u00F3digo Empresa:");
			lblCdigo.setBounds(10, 26, 111, 14);
			panel.add(lblCdigo);
			
			txtApellido = new JTextField();
			txtApellido.setColumns(10);
			txtApellido.setBounds(142, 94, 137, 20);
			panel.add(txtApellido);
			
			JLabel lblApellido = new JLabel("Ubicaci\u00F3n:");
			lblApellido.setBounds(10, 98, 128, 14);
			panel.add(lblApellido);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Contacto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_1.setBounds(10, 141, 455, 98);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			txtTlf = new JTextField();
			txtTlf.setBounds(137, 59, 180, 20);
			panel_1.add(txtTlf);
			txtTlf.setColumns(10);
			
			JLabel lblEmail = new JLabel("Correo Electr\u00F3nico:");
			lblEmail.setBounds(10, 31, 128, 14);
			panel_1.add(lblEmail);
			
			txtEmail = new JTextField();
			txtEmail.setBounds(137, 28, 180, 20);
			panel_1.add(txtEmail);
			txtEmail.setColumns(10);
			
			JLabel lblTelefono = new JLabel("Telefono:");
			lblTelefono.setBounds(10, 62, 86, 14);
			panel_1.add(lblTelefono);
			
			JLabel lblNewLabel_1 = new JLabel("");
			lblNewLabel_1.setIcon(new ImageIcon(RegEmpresa.class.getResource("/icon/customer-service.png")));
			lblNewLabel_1.setBounds(359, 11, 71, 68);
			panel_1.add(lblNewLabel_1);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(RegEmpresa.class.getResource("/icon/online-store (2).png")));
			lblNewLabel.setBounds(328, 9, 137, 121);
			panel.add(lblNewLabel);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						//CARGAR DATOS
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}

