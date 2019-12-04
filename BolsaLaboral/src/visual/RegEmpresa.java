package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import logico.BolsaLaboral;
import logico.Empresa;


public class RegEmpresa extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtEmail;
	private JTextField txtSector;
	private JTextField txtCuidad;
	private JTextField txtCalle;
	private JTextField txtReferencia;
	private JFormattedTextField txtTel;
	private JFormattedTextField ftxtRnc;
	private JComboBox cbxProvincia;
	private JButton btnregistrar;
	private Empresa modificarEmpre = null;
	private JSpinner spnlocalidad;

	/*
	 * public static void main(String[] args) { try { InsertarEmpresa dialog =
	 * new InsertarEmpresa(null);
	 * dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	 * dialog.setVisible(true); } catch (Exception e) { e.printStackTrace(); } }
	 * 
	 * /** Create the dialog.
	 * 
	 * @throws ParseException
	 */
	public RegEmpresa(String title, boolean modi, Empresa empresa, String RNCsoli) throws ParseException {
		setBackground(SystemColor.inactiveCaptionBorder);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				if (RNCsoli != null) {
					ftxtRnc.setText(RNCsoli);
					ftxtRnc.setEnabled(false);
				}
			}
		});
		modificarEmpre = empresa;
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 614, 413);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(248, 248, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setTitle(title);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(248, 248, 255));
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Información General", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(5, 26, 605, 118);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblRnc = new JLabel("RNC:");
		lblRnc.setBounds(10, 35, 46, 14);
		panel.add(lblRnc);

		JLabel lblTelefono = new JLabel("Teléfono:");
		lblTelefono.setBounds(10, 84, 62, 14);
		panel.add(lblTelefono);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(312, 32, 62, 14);
		panel.add(lblNombre);

		txtNombre = new JTextField();
		txtNombre.setBackground(Color.WHITE);
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isDigit(c)) {
					getToolkit().beep();

					e.consume();
					JOptionPane.showMessageDialog(null,"Este campo no adminte número");

				}

			}
		});
		txtNombre.setBounds(405, 32, 174, 23);
		panel.add(txtNombre);
		txtNombre.setColumns(10);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(312, 81, 46, 14);
		panel.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBackground(Color.WHITE);
		txtEmail.setBounds(405, 78, 174, 23);
		panel.add(txtEmail);
		txtEmail.setColumns(10);

		MaskFormatter mascara = new MaskFormatter("##########");
		ftxtRnc = new JFormattedTextField(mascara);
		ftxtRnc.setBackground(Color.WHITE);
		ftxtRnc.setBounds(93, 32, 174, 23);
		panel.add(ftxtRnc);

		MaskFormatter mascara1 = new MaskFormatter("###-###-####");
		txtTel = new JFormattedTextField(mascara1);
		txtTel.setBackground(Color.WHITE);
		txtTel.setBounds(93, 81, 174, 23);
		panel.add(txtTel);
		txtTel.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(248, 248, 255));
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Ubicación", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(5, 155, 605, 166);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblProvincia = new JLabel("Provincia:   ");
		lblProvincia.setBounds(10, 35, 73, 14);
		panel_1.add(lblProvincia);

		cbxProvincia = new JComboBox();
		cbxProvincia.setBackground(Color.WHITE);
		cbxProvincia.setModel(new DefaultComboBoxModel(new String[] {
				"<Seleccione>", "Azua ", "Bahoruco ", "Barahona ",
				"Dajabón ", "Distrito Nacional ", "Duarte ",
				"Elías Piña ", "El Seibo ", "Espaillat ",
				"Hato Mayor ", "Independencia ", "La Altagracia ",
				"La Romana ", "La Vega ", "María Trinidad Sánchez ",
				"Monseñor Nouel ", "Montecristi ", "Monte Plata ",
				"Pedernales ", "Peravia ", "Puerto Plata ",
				"Hermanas Mirabal ", "Samaná ",
				"Sánchez Ramírez ", "San Cristóbal ",
				"San José de Ocoa ", "San Juan ",
				"San Pedro de Macorís ", "Santiago ",
				"Santiago Rodríguez ", "Santo Domingo ", "Valverde " }));
		cbxProvincia.setBounds(93, 35, 174, 23);
		panel_1.add(cbxProvincia);

		JLabel lblSector = new JLabel("Sector:");
		lblSector.setBounds(10, 84, 54, 14);
		panel_1.add(lblSector);

		txtSector = new JTextField();
		txtSector.setBackground(Color.WHITE);
		txtSector.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isDigit(c)) {
					getToolkit().beep();

					e.consume();
					JOptionPane.showMessageDialog(null,"Este campo no adminte número");

				}

			}
		});
		txtSector.setBounds(93, 81, 174, 23);
		panel_1.add(txtSector);
		txtSector.setColumns(10);

		JLabel lblNewLabel = new JLabel("No. Localidad");
		lblNewLabel.setBounds(10, 134, 88, 14);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Cuidad:");
		lblNewLabel_1.setBounds(312, 32, 62, 14);
		panel_1.add(lblNewLabel_1);

		txtCuidad = new JTextField();
		txtCuidad.setBackground(Color.WHITE);
		txtCuidad.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isDigit(c)) {
					getToolkit().beep();

					e.consume();
					JOptionPane.showMessageDialog(null,"Este campo no adminte número");

				}

			}
		});
		txtCuidad.setBounds(405, 32, 174, 23);
		panel_1.add(txtCuidad);
		txtCuidad.setColumns(10);

		JLabel lblCalle = new JLabel("Calle:");
		lblCalle.setBounds(312, 81, 46, 14);
		panel_1.add(lblCalle);

		txtCalle = new JTextField();
		txtCalle.setBackground(Color.WHITE);
		txtCalle.setBounds(405, 78, 174, 23);
		panel_1.add(txtCalle);
		txtCalle.setColumns(10);

		JLabel lblReferencia = new JLabel("Referencia:");
		lblReferencia.setBounds(312, 131, 73, 14);
		panel_1.add(lblReferencia);

		txtReferencia = new JTextField();
		txtReferencia.setBackground(Color.WHITE);
		txtReferencia.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (Character.isDigit(c)) {
					getToolkit().beep();

					e.consume();
					JOptionPane.showMessageDialog(null,"Este campo no adminte número");

				}

			}
		});
		txtReferencia.setBounds(405, 128, 174, 23);
		panel_1.add(txtReferencia);
		txtReferencia.setColumns(10);
		
		spnlocalidad = new JSpinner();
		spnlocalidad.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
		spnlocalidad.setBounds(93, 131, 174, 21);
		panel_1.add(spnlocalidad);

		JLabel lblTodosLosCampos = new JLabel(
				"Todos los campos son obligatorios");
		lblTodosLosCampos.setForeground(Color.RED);
		lblTodosLosCampos.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTodosLosCampos.setBounds(454, 11, 220, 13);
		contentPanel.add(lblTodosLosCampos);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(null);
			buttonPane.setBackground(new Color(248, 248, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnregistrar = new JButton("Registrar");
				//btnregistrar.setIcon(new ImageIcon(InsertarEmpresa.class.getResource("/img/add.png")));
				btnregistrar.setBackground(UIManager.getColor("Button.darkShadow"));
				if(modi){
					btnregistrar.setText("Salvas Modificaciones");
				}
				btnregistrar.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {
						if (!(modi)) {
							String id = ftxtRnc.getText();
							String nombre = txtNombre.getText();
							String tele = txtTel.getText();
							String email = txtEmail.getText();
							String provincia = cbxProvincia.getSelectedItem()
									.toString();

							String direcion = "";
							String ciudad = txtCuidad.getText();
							String sector = txtSector.getText();
							String calle = txtCalle.getText();
							String referencia = txtReferencia.getText();
							int local = (int) spnlocalidad.getValue();
						//	Empresa miEmpresa = new Empresa(rnc, nombre, tele, email, provincia, direcion, sector, ciudad, calle, local, referencia);
							Empresa miEmpresa = new Empresa(nombre, id, tele, email, ciudad);

							if (txtNombre.getText().isEmpty()) {
								JOptionPane
										.showMessageDialog(
												null,
												"Se debe ingresar  el nombre de la empresa a registrar",
												"ATENCIÓN",
												JOptionPane.WARNING_MESSAGE,
												null);
							} else if (ftxtRnc.getText().isEmpty()) {
								JOptionPane
										.showMessageDialog(
												null,
												"Se debe ingresar el RNC de la empresa a registrar",
												"ATENCIÓN",
												JOptionPane.WARNING_MESSAGE,
												null);
							} else if (txtTel.getText().isEmpty()) {
								JOptionPane
										.showMessageDialog(
												null,
												"Se debe ingresar el telefono la empresa a registrar",
												"ATENCIÓN",
												JOptionPane.WARNING_MESSAGE,
												null);
							} else if (txtEmail.getText().isEmpty()) {
								JOptionPane
										.showMessageDialog(
												null,
												"Se debe ingresar el email la empresa a registrar",
												"ATENCIÓN",
												JOptionPane.WARNING_MESSAGE,
												null);
							} else if (cbxProvincia.getSelectedIndex() == 0) {
								JOptionPane
										.showMessageDialog(
												null,
												"Se debe seleccionar la Provincia de la empresa a registrar",
												"ATENCIÓN",
												JOptionPane.WARNING_MESSAGE,
												null);
							} else if (txtCalle.getText().isEmpty()) {
								JOptionPane
										.showMessageDialog(
												null,
												"Se debe ingresar la calle  de la empresa a registrar",
												"ATENCIÓN",
												JOptionPane.WARNING_MESSAGE,
												null);
							} else if (txtCuidad.getText().isEmpty()) {
								JOptionPane
										.showMessageDialog(
												null,
												"Se debe la cuidad de la empresa a registrar",
												"ATENCIÓN",
												JOptionPane.WARNING_MESSAGE,
												null);
							} else if (txtSector.getText().isEmpty()) {
								JOptionPane
										.showMessageDialog(
												null,
												"Se debe ingresar el sector de la empresa a registrar",
												"ATENCIÓN",
												JOptionPane.WARNING_MESSAGE,
												null);
							} else if (txtReferencia.getText().isEmpty()) {
								JOptionPane
										.showMessageDialog(
												null,
												"Se debe ingresar una referencia  de la empresa a registrar",
												"ATENCIÓN",
												JOptionPane.WARNING_MESSAGE,
												null);
							} else if (spnlocalidad.getValue().toString().equalsIgnoreCase("0")) {
								JOptionPane
										.showMessageDialog(
												null,
												"Se debe ingresar el No. de localidad de la empresa a registrar",
												"ATENCIÓN",
												JOptionPane.WARNING_MESSAGE,
												null);
							} else if (empresaRep(id)) {
								JOptionPane.showMessageDialog(null,
										"Empresa existente", "ATENCIÓN",
										JOptionPane.WARNING_MESSAGE, null);
							} else {
								if ((BolsaLaboral.getInstance()
										.validarEmail(email))) {
									JOptionPane.showMessageDialog(null,
											"Favor registar un E-mail valido",
											"ATENCIÓN",
											JOptionPane.WARNING_MESSAGE, null);
									txtEmail.setText(null);

								} else {
									BolsaLaboral.getInstance().agregarEmpresa(miEmpresa);;
									if (RNCsoli == null) {
										ftxtRnc.setText(null);
									}

									txtNombre.setText(null);
									txtTel.setText(null);
									txtEmail.setText(null);
									cbxProvincia.setSelectedIndex(0);
									txtSector.setText(null);
									spnlocalidad.setValue(0);
									txtCuidad.setText(null);
									txtReferencia.setText(null);
									txtCalle.setText(null);
									JOptionPane
											.showMessageDialog(null,
													"Empresa Agregada Satisfactoriamente");
									if (RNCsoli != null) {
										dispose();
									}

								}

							}

						} else {String rnc = ftxtRnc.getText();
						String nombre = txtNombre.getText();
						String tele = txtTel.getText();
						String email = txtEmail.getText();
						String provincia = cbxProvincia.getSelectedItem()
								.toString();

						String direcion = "";
						String ciudad = txtCuidad.getText();
						String sector = txtSector.getText();
						String calle = txtCalle.getText();
						String referencia = txtReferencia.getText();
						int local = (int) spnlocalidad.getValue();
						//Empresa modiEmpre = new Empresa(rnc, nombre, tele, email, provincia, direcion, sector, ciudad, calle, local, referencia);
							//BolsaLaboral.getInstance().modificaEmpresa(modiEmpre);
							JOptionPane.showMessageDialog(null, "Empresa Modificada");
							dispose();
							
						}
					}

				});
				btnregistrar.setActionCommand("OK");
				buttonPane.add(btnregistrar);
				getRootPane().setDefaultButton(btnregistrar);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				//cancelButton.setIcon(new ImageIcon(InsertarEmpresa.class.getResource("/img/cancelar.png")));
				cancelButton.setBackground(UIManager.getColor("Button.darkShadow"));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();

					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
if(modi){
	loadEmpresaModi();
}
	}

	private void loadEmpresaModi() {
		if (modificarEmpre != null) {
			ftxtRnc.setEnabled(false);
		//	ftxtRnc.setText(modificarEmpre.getRNC());
		//	txtEmail.setText(modificarEmpre.getEmail());
			txtNombre.setText(modificarEmpre.getNombre());
			txtTel.setText(modificarEmpre.getTelefono());
		//	txtSector.setText(modificarEmpre.getSector());
			//spnlocalidad.setValue(modificarEmpre.getNumeroLocal());
			//txtCuidad.setText(modificarEmpre.getCiudad());
			//txtReferencia.setText(modificarEmpre.getReferencia());
		//	txtCalle.setText(modificarEmpre.getCalle());
			//cbxProvincia.setSelectedItem(modificarEmpre.getArea());
		}

	}

	public boolean empresaRep(String rnc) {
		boolean aux = false;
		for (Empresa empresa : BolsaLaboral.getInstance().getListEmpresa()) {
			if (empresa.getId().equalsIgnoreCase(rnc)) {
				aux = true;
			}

		}
		return aux;
	}
}
/*
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
	 *
	
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
*/
