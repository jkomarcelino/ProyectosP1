package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import logico.BolsaLaboral;
import logico.Empresa;

import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.SwingConstants;

public class RegEmpresa extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtId;
	private JTextField txtUbicacion;
	private JTextField txtEmail;
	private JTextField txtTlf;
	private boolean check2=false;
	int loguito=0;

	/**
	 * Launch the application.
	 *
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
	
	private Empresa miEmpresa;
	public RegEmpresa(Empresa empresa) {
		miEmpresa = empresa;
		if(miEmpresa == null) {
			setTitle("Registrar Empresa");
			loguito=1;
		}
		else {
			setTitle("Modificar Empresa");
			txtNombre.setText(miEmpresa.getNombre());
			txtId.setText(miEmpresa.getId());
			txtUbicacion.setText(miEmpresa.getUbicacion());
			txtEmail.setText(miEmpresa.getCorreo());
			txtTlf.setText(miEmpresa.getTelefono());
			loguito=2;
		}
		
	//	MaskFormatter CedulaFormat = null;
		MaskFormatter TelFormat = null;
	//	MaskFormatter EmailFormat = null;
		try {
	//		CedulaFormat = new MaskFormatter("###-#######-#");
			TelFormat  = new MaskFormatter("(###)-###-####");
		//	EmailFormat = new MaskFormatter("");
		}catch (Exception e) {
			
		}

		setBounds(100, 100, 501, 376);
		getContentPane().setLayout(null);
		contentPanel.setBackground(SystemColor.activeCaption);
		contentPanel.setBounds(0, 0, 485, 304);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(SystemColor.inactiveCaptionBorder);
			panel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new EtchedBorder(EtchedBorder.RAISED, new Color(0, 120, 215), new Color(153, 180, 209))));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
	
			JLabel lblNombre = new JLabel("Nombre Empresa:");
			lblNombre.setBounds(21, 104, 128, 14);
			panel.add(lblNombre);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(135, 101, 137, 20);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			txtId = new JTextField();
			txtId.setColumns(10);
			txtId.setBounds(135, 64, 137, 20);
			panel.add(txtId);
			
			JLabel lblCdigo = new JLabel("RNC Empresa:");
			lblCdigo.setBounds(20, 67, 111, 14);
			panel.add(lblCdigo);
			
			txtUbicacion = new JTextField();
			txtUbicacion.setColumns(10);
			txtUbicacion.setBounds(135, 138, 137, 20);
			panel.add(txtUbicacion);
			
			JLabel lblApellido = new JLabel("Ubicaci\u00F3n:");
			lblApellido.setBounds(21, 141, 128, 14);
			panel.add(lblApellido);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Contacto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			panel_1.setBounds(21, 169, 432, 98);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			txtTlf = new JFormattedTextField(TelFormat);
			txtTlf.setFont(new Font("Tahoma", Font.PLAIN, 11));
			txtTlf.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					
					//int tam = txtBuscar.getText().length();
					if (txtTlf.getText().equalsIgnoreCase("   -   -    ") && !check2) {
						txtTlf.setText("   -   -    ");
						check2=true;
					}

				}
			});
			txtTlf.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (txtTlf.getText().equalsIgnoreCase("   -   -    ") && !check2) {
						txtTlf.setText("   -   -    ");
						check2=true;
					}
				}
			});
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
			lblNewLabel.setBounds(316, 36, 137, 121);
			panel.add(lblNewLabel);
			
			JLabel lblLogo = new JLabel("");
			lblLogo.setHorizontalAlignment(SwingConstants.TRAILING);
			lblLogo.setVerticalAlignment(SwingConstants.BOTTOM);
			lblLogo.setIcon(new ImageIcon(RegEmpresa.class.getResource("/icon/JOBIFYpeque.png")));
			lblLogo.setBounds(10, 9, 146, 44);
			panel.add(lblLogo);
			

			if (loguito==1) {
				JLabel label = new JLabel("");
				label.setIcon(new ImageIcon(RegEmpresa.class.getResource("/icon/CrearEmpresa.png")));
				label.setBounds(111, 0, 205, 44);
				panel.add(label);
				
		
			}else if (loguito==2) {
				JLabel label = new JLabel("");
				label.setIcon(new ImageIcon(RegEmpresa.class.getResource("/icon/ModEmpresa.png")));
				label.setBounds(91, 0, 205, 44);
				panel.add(label);
			}
			
			
			
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.activeCaption);
			buttonPane.setBounds(0, 304, 485, 33);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String nombre = txtNombre.getText();
						String telefono = txtTlf.getText();
						String correo = txtEmail.getText();
						String ubicacion = txtUbicacion.getText();
						String rnc= txtId.getText();
						if(correo.isEmpty() ||nombre.isEmpty()||ubicacion.isEmpty()||telefono.isEmpty()||rnc.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Debe llenar todos los campos", "Error", JOptionPane.WARNING_MESSAGE);
						}else if(miEmpresa==null) {
							Empresa aux = new Empresa(nombre, rnc, telefono, correo, ubicacion);
							BolsaLaboral.getInstance().agregarEmpresa(aux);
							JOptionPane.showMessageDialog(null, "Operacion Satisfactoria", "Informacion", JOptionPane.INFORMATION_MESSAGE);
							clean();
						}else {
							miEmpresa.setCorreo(correo);
							miEmpresa.setUbicacion(ubicacion);
							miEmpresa.setId(rnc);
							miEmpresa.setNombre(nombre);
							miEmpresa.setTelefono(telefono);
							dispose();
						}
			

							
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
	
	private void clean() {
		txtId.setText("");
		txtNombre.setText("");
		txtEmail.setText("");
		txtTlf.setText(null);
		txtUbicacion.setText("");
	}
}

