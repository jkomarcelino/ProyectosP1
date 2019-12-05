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
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JSeparator;


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
		setBounds(100, 100, 630, 423);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.inactiveCaption);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setTitle(title);
		JPanel panel = new JPanel();
		panel.setBackground(new Color(248, 248, 255));
		panel.setBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, new Color(153, 180, 209), null, null), new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informaci\u00F3n General", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0))));
		panel.setBounds(10, 55, 605, 118);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel lblRnc = new JLabel("RNC:");
		lblRnc.setBounds(10, 35, 46, 14);
		panel.add(lblRnc);

		JLabel lblTelefono = new JLabel("Tel�fono:");
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
					JOptionPane.showMessageDialog(null,"Este campo no adminte n�mero");

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
		panel_1.setBorder(new CompoundBorder(new CompoundBorder(new BevelBorder(BevelBorder.RAISED, null, new Color(153, 180, 209), new Color(153, 180, 209), null), new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Ubicaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0))), null));
		panel_1.setBounds(10, 185, 605, 166);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblProvincia = new JLabel("Provincia:   ");
		lblProvincia.setBounds(10, 35, 73, 14);
		panel_1.add(lblProvincia);

		cbxProvincia = new JComboBox();
		cbxProvincia.setBackground(Color.WHITE);
		cbxProvincia.setModel(new DefaultComboBoxModel(new String[] {
				"<Seleccione>", "Azua ", "Bahoruco ", "Barahona ",
				"Dajab�n ", "Distrito Nacional ", "Duarte ",
				"El�as Pi�a ", "El Seibo ", "Espaillat ",
				"Hato Mayor ", "Independencia ", "La Altagracia ",
				"La Romana ", "La Vega ", "Mar�a Trinidad S�nchez ",
				"Monse�or Nouel ", "Montecristi ", "Monte Plata ",
				"Pedernales ", "Peravia ", "Puerto Plata ",
				"Hermanas Mirabal ", "Saman� ",
				"S�nchez Ram�rez ", "San Crist�bal ",
				"San Jos� de Ocoa ", "San Juan ",
				"San Pedro de Macor�s ", "Santiago ",
				"Santiago Rodr�guez ", "Santo Domingo ", "Valverde " }));
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
					JOptionPane.showMessageDialog(null,"Este campo no adminte n�mero");

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
					JOptionPane.showMessageDialog(null,"Este campo no adminte n�mero");

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
					JOptionPane.showMessageDialog(null,"Este campo no adminte n�mero");

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
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(RegEmpresa.class.getResource("/img/JOBIFYpeque.png")));
		lblNewLabel_2.setBounds(232, 0, 169, 44);
		contentPanel.add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 44, 605, 2);
		contentPanel.add(separator);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(null);
			buttonPane.setBackground(SystemColor.inactiveCaption);
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
							Empresa miEmpresa = new Empresa(id, nombre, tele, email, provincia, direcion, sector, ciudad, calle, local, referencia);
							

							if (txtNombre.getText().isEmpty()) {
								JOptionPane
										.showMessageDialog(
												null,
												"Se debe ingresar  el nombre de la empresa a registrar",
												"ATENCI�N",
												JOptionPane.WARNING_MESSAGE,
												null);
							} else if (ftxtRnc.getText().isEmpty()) {
								JOptionPane
										.showMessageDialog(
												null,
												"Se debe ingresar el RNC de la empresa a registrar",
												"ATENCI�N",
												JOptionPane.WARNING_MESSAGE,
												null);
							} else if (txtTel.getText().isEmpty()) {
								JOptionPane
										.showMessageDialog(
												null,
												"Se debe ingresar el telefono la empresa a registrar",
												"ATENCI�N",
												JOptionPane.WARNING_MESSAGE,
												null);
							} else if (txtEmail.getText().isEmpty()) {
								JOptionPane
										.showMessageDialog(
												null,
												"Se debe ingresar el email la empresa a registrar",
												"ATENCI�N",
												JOptionPane.WARNING_MESSAGE,
												null);
							} else if (cbxProvincia.getSelectedIndex() == 0) {
								JOptionPane
										.showMessageDialog(
												null,
												"Se debe seleccionar la Provincia de la empresa a registrar",
												"ATENCI�N",
												JOptionPane.WARNING_MESSAGE,
												null);
							} else if (txtCalle.getText().isEmpty()) {
								JOptionPane
										.showMessageDialog(
												null,
												"Se debe ingresar la calle  de la empresa a registrar",
												"ATENCI�N",
												JOptionPane.WARNING_MESSAGE,
												null);
							} else if (txtCuidad.getText().isEmpty()) {
								JOptionPane
										.showMessageDialog(
												null,
												"Se debe la cuidad de la empresa a registrar",
												"ATENCI�N",
												JOptionPane.WARNING_MESSAGE,
												null);
							} else if (txtSector.getText().isEmpty()) {
								JOptionPane
										.showMessageDialog(
												null,
												"Se debe ingresar el sector de la empresa a registrar",
												"ATENCI�N",
												JOptionPane.WARNING_MESSAGE,
												null);
							} else if (txtReferencia.getText().isEmpty()) {
								JOptionPane
										.showMessageDialog(
												null,
												"Se debe ingresar una referencia  de la empresa a registrar",
												"ATENCI�N",
												JOptionPane.WARNING_MESSAGE,
												null);
							} else if (spnlocalidad.getValue().toString().equalsIgnoreCase("0")) {
								JOptionPane
										.showMessageDialog(
												null,
												"Se debe ingresar el No. de localidad de la empresa a registrar",
												"ATENCI�N",
												JOptionPane.WARNING_MESSAGE,
												null);
							} else if (empresaRep(id)) {
								JOptionPane.showMessageDialog(null,
										"Empresa existente", "ATENCI�N",
										JOptionPane.WARNING_MESSAGE, null);
							} else {
								if ((BolsaLaboral.getInstance()
										.validarEmail(email))) {
									JOptionPane.showMessageDialog(null,
											"Favor registar un E-mail valido",
											"ATENCI�N",
											JOptionPane.WARNING_MESSAGE, null);
									txtEmail.setText(null);

								} else {
									BolsaLaboral.getInstance().insertEmpresa(miEmpresa);;
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

						} else {
						String rnc = ftxtRnc.getText();
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
						Empresa modiEmpre = new Empresa(rnc, nombre, tele, email, provincia, direcion, sector, ciudad, calle, local, referencia);
						BolsaLaboral.getInstance().modificaEmpresa(modiEmpre);
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
				JButton cancelButton = new JButton("Atr\u00E1s");
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
		for (Empresa empresa : BolsaLaboral.getInstance().getMisEmpresas()) {
			if (empresa.getRNC().equalsIgnoreCase(rnc)) {
				aux = true;
			}

		}
		return aux;
	}
}