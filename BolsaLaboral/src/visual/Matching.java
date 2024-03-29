package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.text.MaskFormatter;

import logico.BolsaLaboral;
import logico.Empresa;
import logico.Personal;
import logico.Solicitud;
import logico.SolicitudObrero;
import logico.SolicitudTecnico;
import logico.SolicitudUniversitario;
import javax.swing.border.CompoundBorder;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;

public class Matching extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static Object[] fila;

	private static DefaultTableModel modelo;
	private static DefaultTableCellRenderer centrar = new DefaultTableCellRenderer();
	private JFormattedTextField ftxtRNC;
	Empresa miEmpresa = null;
	private JTextField txtNombreEmpresa;
	private JButton btnCandidatos;
	private DefaultListModel<String> model = new DefaultListModel<>();
	private JList list;
	private String codigo = "";
	private ArrayList<Personal> misSolicitantesC = new ArrayList<>();
	private JFormattedTextField ftxtCodSolicitud;
	private JScrollPane scrollPane;


	public Matching() throws ParseException {
		setResizable(false);
		setModal(true);
		getContentPane().setBackground(new Color(248, 248, 255));
		setBackground(new Color(248, 248, 255));

		setTitle("Ubicaci\u00F3n Laboral");
		setBounds(100, 100, 853, 509);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.inactiveCaption);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(SystemColor.inactiveCaption);
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(SystemColor.inactiveCaption);
				panel_1.setBorder(null);
				panel_1.setBounds(3, 3, 834, 430);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					JPanel panel_2 = new JPanel();
					panel_2.setBackground(SystemColor.inactiveCaptionBorder);
					panel_2.setLayout(null);
					panel_2.setBorder(new CompoundBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Empresa", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), new BevelBorder(BevelBorder.RAISED, null, new Color(153, 180, 209), null, null)));
					panel_2.setBounds(5, 5, 505, 400);
					panel_1.add(panel_2);
					{
						JLabel label = new JLabel("RNC:");
						label.setBounds(10, 35, 46, 14);
						panel_2.add(label);
					}
					{
						JLabel label = new JLabel("Nombre:");
						label.setBounds(10, 66, 59, 14);
						panel_2.add(label);
					}
					{
						txtNombreEmpresa = new JTextField();
						txtNombreEmpresa.setBackground(new Color(255, 255, 255));
						txtNombreEmpresa.setEnabled(false);
						txtNombreEmpresa.setColumns(10);
						txtNombreEmpresa.setBounds(63, 62, 406, 23);
						panel_2.add(txtNombreEmpresa);
					}
					{
						JLabel label = new JLabel("C\u00F3digo Solicitud:");
						label.setBounds(280, 35, 100, 14);
						panel_2.add(label);
					}
					{
						JButton btnBuscar = new JButton("Buscar");
						btnBuscar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
								ftxtCodSolicitud.setValue("");

								if (BolsaLaboral.getInstance().RetornarEmpresa(ftxtRNC.getText()) != null) {
									miEmpresa = BolsaLaboral.getInstance().RetornarEmpresa(ftxtRNC.getText());
									txtNombreEmpresa.setText(miEmpresa.getNombre());
									loadTable(miEmpresa);
								} else {
									JOptionPane.showMessageDialog(null,
											"No se encontro una empresa con el RNC digitado.", "Informaci�n",
											JOptionPane.WARNING_MESSAGE, null);
								}

							}
						});
						btnBuscar.setBounds(205, 30, 65, 25);
						panel_2.add(btnBuscar);
					}
					{
						JScrollPane scrollPane = new JScrollPane();
						scrollPane.addMouseListener(new MouseAdapter() {
							@Override
							public void mouseClicked(MouseEvent arg0) {

							}
						});
						scrollPane.setBounds(10, 118, 469, 230);
						panel_2.add(scrollPane);
						{
							table = new JTable();
							table.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseClicked(MouseEvent e) {
									int aux = table.getSelectedRow();
									if (aux > -1) {
										btnCandidatos.setEnabled(true);
										codigo = (String) table.getModel().getValueAt(aux, 0);
										ftxtCodSolicitud.setValue(codigo);
									} else {
										codigo = "";
										btnCandidatos.setEnabled(false);
									}
								}
							});
							modelo = new DefaultTableModel();
							table.setModel(modelo);
							loadTable(null);
							scrollPane.setViewportView(table);
						}
					}
					{
						JLabel label = new JLabel("Solicitudes");
						label.setFont(new Font("Tahoma", Font.PLAIN, 12));
						label.setBounds(202, 93, 88, 14);
						panel_2.add(label);
					}
					{
						btnCandidatos = new JButton("Ver Solicitantes");
						btnCandidatos.setIcon(new ImageIcon(Matching.class.getResource("/img/ver.png")));
						btnCandidatos.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {

								Solicitud soli = BolsaLaboral.getInstance().RetornarSolocitudCod(codigo);
								if (soli != null) {
									misSolicitantesC = BolsaLaboral.getInstance().matcheo(soli);

								}

								cargarSolicitante();
							}
						});
						btnCandidatos.setEnabled(false);
						btnCandidatos.setBounds(340, 360, 139, 25);
						panel_2.add(btnCandidatos);
					}
					{
						MaskFormatter mascara = new MaskFormatter("##########");
						ftxtRNC = new JFormattedTextField(mascara);
						ftxtRNC.setBackground(new Color(255, 255, 255));
						ftxtRNC.setBounds(63, 31, 139, 23);
						panel_2.add(ftxtRNC);
					}
					{
						ftxtCodSolicitud = new JFormattedTextField();
						ftxtCodSolicitud.setBackground(new Color(255, 255, 255));
						ftxtCodSolicitud.setEnabled(false);
						ftxtCodSolicitud.setBounds(369, 31, 100, 23);
						panel_2.add(ftxtCodSolicitud);
					}

					JButton btnFiltralTodo = new JButton("Filtrar todo");
					btnFiltralTodo.setIcon(new ImageIcon(Matching.class.getResource("/img/filtrar.png")));
					btnFiltralTodo.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							loadTable(null);
							ftxtCodSolicitud.setText("");
							txtNombreEmpresa.setText("");
							ftxtRNC.setText("");
						}
					});
					btnFiltralTodo.setBounds(205, 360, 122, 25);
					panel_2.add(btnFiltralTodo);
				}
				{
					JPanel panel_2 = new JPanel();
					panel_2.setBackground(new Color(248, 248, 255));
					panel_2.setLayout(null);
					panel_2.setBorder(new CompoundBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Solicitantes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)), new BevelBorder(BevelBorder.RAISED, null, new Color(153, 180, 209), null, null)));
					panel_2.setBounds(520, 102, 311, 303);
					panel_1.add(panel_2);
					{
						 scrollPane = new JScrollPane();	
						scrollPane.setBounds(10, 23, 293, 263);
						panel_2.add(scrollPane);
					}
					{
						list = new JList();
						scrollPane.setViewportView(list);
					}
				}
				
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setIcon(new ImageIcon(Matching.class.getResource("/img/JOBIFYpeque.png")));
				lblNewLabel.setBounds(523, 11, 138, 39);
				panel_1.add(lblNewLabel);
				{
					JLabel lblNewLabel_1 = new JLabel("New label");
					lblNewLabel_1.setIcon(new ImageIcon(Matching.class.getResource("/img/encon.png")));
					lblNewLabel_1.setBounds(533, 40, 273, 30);
					panel_1.add(lblNewLabel_1);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.activeCaption);
			buttonPane.setBorder(null);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnContratar = new JButton("Contratar");
				btnContratar.setIcon(new ImageIcon(Matching.class.getResource("/img/Contratar.png")));
				btnContratar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (misSolicitantesC.size() != 0) {
							Solicitud solicitud = BolsaLaboral.getInstance().RetornarSolocitudCod(codigo);
							BolsaLaboral.getInstance().contratarCandidatos(solicitud, misSolicitantesC);
							JOptionPane.showMessageDialog(null, "Los solicitantes han sido contratados.", "Informaci�n",
									JOptionPane.INFORMATION_MESSAGE, null);
							Principal.actualizarChart();
							Principal.actualizarPastel();
							Principal.actualizarPastel2(); 
							BolsaLaboral.getInstance().removerContratados(misSolicitantesC);
							clean();
						} else {
							JOptionPane.showMessageDialog(null,
									"No existen solicitantes en la actualidad para satisfacer esta solicitud",
									"Informaci�n", JOptionPane.INFORMATION_MESSAGE, null);
						}
					}
				});
				btnContratar.setActionCommand("OK");
				buttonPane.add(btnContratar);
				getRootPane().setDefaultButton(btnContratar);
			}
			{
				JButton cancelButton = new JButton("Atr\u00E1s");
				cancelButton.setIcon(new ImageIcon(Matching.class.getResource("/img/cancelar.png")));
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

	private void loadTable(Empresa empresa) {
		String[] columnNames = { "C�digo", "Tipo", "Vacantes", "Rango Edad", "Localidad" };
		modelo.setColumnIdentifiers(columnNames);
		modelo.setRowCount(0);
		fila = new Object[modelo.getColumnCount()];

		if (empresa == null) {
			for (Solicitud soli : BolsaLaboral.getInstance().getMisSolicitudes()) {
				if (soli.getCantVacantes() > 0) {
					fila[0] = soli.getCodigo();
					if (soli instanceof SolicitudUniversitario) {
						fila[1] = "Universitario";
					}
					if (soli instanceof SolicitudTecnico) {
						fila[1] = "T�cnico";
					}
					if (soli instanceof SolicitudObrero) {
						fila[1] = "Obrero";
					}
					fila[2] = soli.getCantVacantes();
					String min = Integer.toString(soli.getEdadMin());
					String max = Integer.toString(soli.getEdadMax());
					String rango = min + "-" + max;
					fila[3] = rango;
					fila[4] = soli.getLocalidad();

					modelo.addRow(fila);

				}
			}

		} else {
			ArrayList<Solicitud> solicitudesEmpresa = new ArrayList<>();
			for (Solicitud solicitud : BolsaLaboral.getInstance().RetornaSolicitudEmp(empresa)) {
				solicitudesEmpresa.add(solicitud);

			}

			for (Solicitud soli : solicitudesEmpresa) {
				if (soli.getCantVacantes() > 0) {
					fila[0] = soli.getCodigo();
					if (soli instanceof SolicitudUniversitario) {
						fila[1] = "Universitario";
					}
					if (soli instanceof SolicitudTecnico) {
						fila[1] = "T�cnico";
					}
					if (soli instanceof SolicitudObrero) {
						fila[1] = "Obrero";
					}
					fila[2] = soli.getCantVacantes();
					String min = Integer.toString(soli.getEdadMin());
					String max = Integer.toString(soli.getEdadMax());
					String rango = min + "-" + max + " A�os";
					fila[3] = rango;
					fila[4] = soli.getLocalidad();

					modelo.addRow(fila);

				}
			}
		}

		TableColumnModel columnModel = table.getColumnModel();
		centrar.setHorizontalAlignment(SwingConstants.CENTER);

		for (int i = 0; i < columnNames.length; i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(centrar);
		}
		columnModel.getColumn(0).setPreferredWidth(80);
		columnModel.getColumn(1).setPreferredWidth(80);
		columnModel.getColumn(2).setPreferredWidth(106);
		columnModel.getColumn(3).setPreferredWidth(120);
		columnModel.getColumn(4).setPreferredWidth(80);

	}

	public void cargarSolicitante() {
		if (misSolicitantesC.size() != 0) {
			for (Personal soli : misSolicitantesC) {
				String candidato = soli.getCedula() + " " + soli.getNombres() + " " + soli.getApellidos();
				model.addElement(candidato);
			}
			list.setModel(model);
		} else {
			JOptionPane.showMessageDialog(null,
					"No existen solicitantes en la actualidad para satisfacer esta solicitud", "Informaci�n",
					JOptionPane.INFORMATION_MESSAGE, null);
		}
	}

	public void clean() {
		model.clear();
		misSolicitantesC = new ArrayList<>();
		loadTable(null);
	}
}
