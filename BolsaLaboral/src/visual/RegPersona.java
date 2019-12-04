package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import logico.Personal;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.JFormattedTextField;

public class RegPersona extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtGenero;
	private JTextField txtEdad;
	private JTextField txtCorreo;
	private JTextField txtApellido;
	//txtCiudad
	//txtxAniosExp
	//soltero
	//vehiculo
	//disp_viajar
	private	JLabel lblLogoCrear;
	private JLabel lblLogoModif;
	private JFormattedTextField txtTelefono;
	private JFormattedTextField txtId;
	private boolean check1=false;
	private boolean check2=false;
	int loguito =0;

	/**
	 * Launch the application.
	 *
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
	private Personal miPerson;
	private JTextField txtNacionalidad;
	public RegPersona(Personal person) {
		
		miPerson = person;
		if(miPerson == null) {
			setTitle("Registrar Cliente");
			loguito=1;
		
		}
		else {
			setTitle("Modificar Cliente");
			txtNombre.setText(miPerson.getNombre());
			txtGenero.setText(miPerson.getSexo());
			txtEdad.setText(String.valueOf(miPerson.getEdad()));
		    txtId.setText(miPerson.getId());
			txtCorreo.setText(miPerson.getSexo());
			txtApellido.setText(miPerson.getApellido());
			txtTelefono.setText(miPerson.getTelefono());
			loguito=2;
			
		}
		MaskFormatter CedulaFormat = null;
		MaskFormatter TelFormat = null;
		try {
			CedulaFormat = new MaskFormatter("###-#######-#");
			TelFormat  = new MaskFormatter("(###)-###-####");
			
		}catch (Exception e) {

		}
		setTitle("Registro Personal");
		setBounds(100, 100, 462, 354);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.activeCaption);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(10, 11, 426, 268);
			panel.setBackground(SystemColor.inactiveCaptionBorder);
			panel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null), new EtchedBorder(EtchedBorder.RAISED, new Color(0, 120, 215), new Color(153, 180, 209))));
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JLabel lblNombre = new JLabel("Nombre:");
			lblNombre.setBounds(10, 45, 61, 14);
			panel.add(lblNombre);
			
			txtGenero = new JTextField();
			txtGenero.setColumns(10);
			txtGenero.setBounds(81, 135, 132, 20);
			panel.add(txtGenero);
			
			JLabel lblGnero = new JLabel("G\u00E9nero:");
			lblGnero.setBounds(10, 138, 61, 14);
			panel.add(lblGnero);
			
			txtEdad = new JTextField();
			txtEdad.setColumns(10);
			txtEdad.setBounds(81, 166, 132, 20);
			panel.add(txtEdad);
			
			JLabel lblEdad = new JLabel("Edad:");
			lblEdad.setBounds(10, 169, 46, 14);
			panel.add(lblEdad);
			
			JLabel lblCdigo = new JLabel("C\u00E9dula:");
			lblCdigo.setBounds(10, 14, 61, 14);
			panel.add(lblCdigo);
			
			txtApellido = new JTextField();
			txtApellido.setColumns(10);
			txtApellido.setBounds(81, 73, 132, 20);
			panel.add(txtApellido);
			
			JLabel lblApellido = new JLabel("Apellido:");
			lblApellido.setBounds(10, 76, 51, 14);
			panel.add(lblApellido);
			
			txtNombre = new JTextField();
			txtNombre.setBounds(81, 42, 132, 20);
			panel.add(txtNombre);
			txtNombre.setColumns(10);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(SystemColor.inactiveCaptionBorder);
			panel_1.setBorder(new TitledBorder(null, "Contacto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(10, 197, 405, 62);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel lblEmail = new JLabel("E-mail:");
			lblEmail.setBounds(10, 27, 46, 14);
			panel_1.add(lblEmail);
			
			txtCorreo = new JTextField();
			txtCorreo.setBounds(66, 24, 119, 20);
			panel_1.add(txtCorreo);
			txtCorreo.setColumns(10);
			
			JLabel lblTelef = new JLabel("Tel\u00E9fono:");
			lblTelef.setBounds(205, 27, 61, 14);
			panel_1.add(lblTelef);
			
			txtTelefono = new JFormattedTextField(TelFormat);
			txtTelefono.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
					
					//int tam = txtBuscar.getText().length();
					if (txtTelefono.getText().equalsIgnoreCase("   -   -    ") && !check2) {
						txtTelefono.setText("   -   -    ");
						check2=true;
					}

				}
			});
			txtTelefono.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (txtTelefono.getText().equalsIgnoreCase("   -   -    ") && !check2) {
						txtTelefono.setText("   -   -    ");
						check2=true;
					}
				}
			});
			txtTelefono.setBounds(276, 24, 119, 20);
			panel_1.add(txtTelefono);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(RegPersona.class.getResource("/icon/boss127.png")));
			lblNewLabel.setBounds(265, 58, 128, 128);
			panel.add(lblNewLabel);
			

		
			JLabel lblLogo = new JLabel("");
			lblLogo.setIcon(new ImageIcon(RegPersona.class.getResource("/icon/JOBIFYpeque.png")));
			lblLogo.setBounds(236, 0, 169, 35);
			panel.add(lblLogo);
			
			txtNacionalidad = new JTextField();
			txtNacionalidad.setBounds(81, 104, 132, 20);
			panel.add(txtNacionalidad);
			txtNacionalidad.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel("Nacionalidad:");
			lblNewLabel_1.setBounds(10, 108, 80, 14);
			panel.add(lblNewLabel_1);

			txtId = new JFormattedTextField(CedulaFormat);
			txtId.addKeyListener(new KeyAdapter() {
				@Override
				public void keyPressed(KeyEvent e) {
				
					if (txtId.getText().equalsIgnoreCase("   -       - ") && !check2) {
						txtId.setText("   -       - ");
						check2=true;
					}

				}
			});
			txtId.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (txtId.getText().equalsIgnoreCase("   -       - ") && !check1) {
						txtId.setText("   -       - ");
						check1=true;
					}
				}
			});
			txtId.setBounds(81, 11, 132, 20);
			panel.add(txtId);


			if (loguito==1) {

				lblLogoCrear = new JLabel("");
				lblLogoCrear.setIcon(new ImageIcon(RegPersona.class.getResource("/icon/CrearEmp.png")));
				lblLogoCrear.setBounds(239, 26, 176, 18);
				panel.add(lblLogoCrear);
			}else if (loguito==2) {
				lblLogoModif = new JLabel("");
				lblLogoModif.setHorizontalAlignment(SwingConstants.LEFT);
				lblLogoModif.setIcon(new ImageIcon(RegPersona.class.getResource("/icon/ModEmpleado.png")));
				lblLogoModif.setBounds(204, 31, 212, 21);
				panel.add(lblLogoModif);
			}

		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.activeCaption);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{

				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String nombre = txtNombre.getText();
						String genero =txtGenero.getText();
						String edad = txtEdad.getText();
						String cedula = txtId.getText();
						String correo = txtCorreo.getText();
						String apellido = txtApellido.getText();
						String telefono = txtTelefono.getText();
						String nacionalidad = txtNacionalidad.getText();
						//soltero
						//ciudad
						String ciudad=txtCiudad.getText();
						//aniosexp
						String anios_exp=txtAniosExp.getText;
						//disp_viajar
						//vehiculo
						
						if (nacionalidad.isEmpty()||nombre.isEmpty()||genero.isEmpty()||edad.isEmpty()||cedula.isEmpty()||correo.isEmpty()||apellido.isEmpty()||telefono.isEmpty()) {   
							JOptionPane.showMessageDialog(null, "Debe llenar todos los campos", "Error", JOptionPane.WARNING_MESSAGE);

						}else if (miPerson==null) {
						//	Personal aux = new Personal() 
						}else {

						}
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
	
	public void validacion(KeyEvent e) {//esto valida si se intenta introducir un numero en campo texto
		char c = e.getKeyChar();
		if (Character.isDigit(c)) {
			getToolkit().beep();

			e.consume();
			JOptionPane.showMessageDialog(null, "Este campo no adminte número");
		}

	}
}
