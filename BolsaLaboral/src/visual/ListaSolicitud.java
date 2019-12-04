package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFormattedTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.text.MaskFormatter;

import logico.BolsaLaboral;
import logico.Empresa;
import logico.Solicitud;
import logico.SolicitudObrero;
import logico.SolicitudTecnico;
import logico.SolicitudUniversitario;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.ImageIcon;

public class ListaSolicitud extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private static Object[] fila;
	private static DefaultTableModel modeloTabla;
	private static DefaultTableCellRenderer centrar = new DefaultTableCellRenderer();
	public static JComboBox cbxfiltro;
	private Empresa empresaListar = null;
	private JFormattedTextField ftxtRNCempresa;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnDetallar;
	private String codigo = "";

	private static JComboBox<String> cbxHabilidades;
	private static JComboBox<String> cbxIdioma;

	/**
	
	}

	/**
	 * Create the dialog.
	 */
	public ListaSolicitud() {
		getContentPane().setBackground(new Color(245, 255, 250));
		setTitle("Listar Solicitudes");
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 943, 519);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(245, 255, 250));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(245, 255, 250));
			panel.setBorder(
					new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Lista De Solicitudes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JLabel lblFiltrarPor = new JLabel("Filtrar por:");
				lblFiltrarPor.setBounds(10, 25, 68, 14);
				panel.add(lblFiltrarPor);
			}
			{
				cbxfiltro = new JComboBox();
				cbxfiltro.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						btnDetallar.setEnabled(false);
						btnEliminar.setEnabled(false);
						btnModificar.setEnabled(false);
					}
				});
				cbxfiltro.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						if (cbxfiltro.getSelectedIndex() == 0) {
							ftxtRNCempresa.setText("");
							loadtabla(0);
						} else if (cbxfiltro.getSelectedIndex() == 1) {
							ftxtRNCempresa.setText("");
							loadtabla(1);
						} else if (cbxfiltro.getSelectedIndex() == 2) {
							ftxtRNCempresa.setText("");
							loadtabla(2);
						} else if (cbxfiltro.getSelectedIndex() == 3) {
							ftxtRNCempresa.setText("");
							loadtabla(3);
						}

					}

				});
				cbxfiltro.setModel(
						new DefaultComboBoxModel(new String[] { "Todos", "Universitatio", "T\u00E9cnico", "Obrero" }));
				cbxfiltro.setBounds(77, 21, 118, 23);
				panel.add(cbxfiltro);
			}
			{
				JLabel lblRncEmpresa = new JLabel("RNC Empresa:");
				lblRncEmpresa.setBounds(211, 25, 85, 14);
				panel.add(lblRncEmpresa);
			}
			{
				MaskFormatter mascara;
				try {
					mascara = new MaskFormatter("##########");
					ftxtRNCempresa = new JFormattedTextField(mascara);
					ftxtRNCempresa.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							btnDetallar.setEnabled(false);
							btnEliminar.setEnabled(false);
							btnModificar.setEnabled(false);
						}
					});
					ftxtRNCempresa.setBounds(306, 21, 118, 23);
					panel.add(ftxtRNCempresa);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						btnDetallar.setEnabled(false);
						btnEliminar.setEnabled(false);
						btnModificar.setEnabled(false);
					}
				});
				scrollPane.setBounds(10, 58, 903, 363);
				panel.add(scrollPane);
				{
					table = new JTable();
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							int aux = table.getSelectedRow();
							if (aux > -1) {
								btnModificar.setEnabled(true);
								btnEliminar.setEnabled(true);
								btnDetallar.setEnabled(true);
								codigo = (String) table.getModel().getValueAt(aux, 0);

							} else {
								btnModificar.setEnabled(false);
								btnEliminar.setEnabled(false);
								btnDetallar.setEnabled(false);
								codigo = "";
							}

						}
					});
					modeloTabla = new DefaultTableModel();
					table.getTableHeader().setResizingAllowed(false);
					loadAll();
					scrollPane.setViewportView(table);
				}
			}
			{
				JButton button = new JButton("");
				button.setIcon(new ImageIcon(ListaSolicitud.class.getResource("/img/buscar.png")));
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						btnDetallar.setEnabled(false);
						btnEliminar.setEnabled(false);
						btnModificar.setEnabled(false);
						empresaListar = BolsaLaboral.getInstance().RetornarEmpresa(ftxtRNCempresa.getText());

						if (empresaListar != null) {
							loadTablaRNC();
						} else {
							JOptionPane.showMessageDialog(null, "No se encontr� ning�n solicitud para el RNC dado.",
									"ATENCI�N", JOptionPane.ERROR_MESSAGE, null);
						}

					}

				});
				button.setBounds(430, 22, 29, 25);
				panel.add(button);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(245, 255, 250));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.setIcon(new ImageIcon(ListaSolicitud.class.getResource("/img/borrar.png")));
				btnEliminar.setEnabled(false);
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(JOptionPane.showConfirmDialog(null, "�Seguro que desea eliminar esta solicitud?", "Atenci�n Requerida", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
							if (!codigo.equalsIgnoreCase("")) {
								if (BolsaLaboral.getInstance().EliminarSolicitud(codigo)) {
									loadtabla(cbxfiltro.getSelectedIndex());
									JOptionPane.showMessageDialog(null, "Se ha eliminada la solicitud", "Informaci�n",
											JOptionPane.INFORMATION_MESSAGE, null);

									btnEliminar.setEnabled(false);
									btnDetallar.setEnabled(false);
									btnModificar.setEnabled(false);
								}
							}
						}
						
					}
				});
				{
					btnDetallar = new JButton("Ver Solicitud");
					btnDetallar.setIcon(new ImageIcon(ListaSolicitud.class.getResource("/img/ver.png")));
					btnDetallar.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							InfoSoli detalle = new InfoSoli(BolsaLaboral.getInstance().RetornarSolocitudCod(codigo));
							detalle.setLocationRelativeTo(null);
							detalle.setModal(true);
							detalle.setVisible(true);
						}
					});
					btnDetallar.setEnabled(false);
					buttonPane.add(btnDetallar);
				}
				buttonPane.add(btnEliminar);
			}
			{
				btnModificar = new JButton("Modificar");
				btnModificar.setIcon(new ImageIcon(ListaSolicitud.class.getResource("/img/modificar.png")));
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						SolicitudEmpresa modifSoli = new SolicitudEmpresa(BolsaLaboral.getInstance().RetornarSolocitudCod(codigo));
						modifSoli.setModal(true);
						modifSoli.setVisible(true);
						Solicitud soli = BolsaLaboral.getInstance().RetornarSolocitudCod(codigo);
					}
				});
				btnModificar.setEnabled(false);
				btnModificar.setActionCommand("OK");
				buttonPane.add(btnModificar);
				getRootPane().setDefaultButton(btnModificar);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setIcon(new ImageIcon(ListaSolicitud.class.getResource("/img/cancelar.png")));
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

	public static void loadtabla(int i) {
		if (i == 0) {
			loadAll();
			cbxIdioma = new JComboBox<String>();
		}
		if (i == 1) {
			loadUniversitario();
		}
		if (i == 2) {
			loadTecnico();

		}
		if (i == 3) {
			loadObrero();
		}

	}

	private static void loadAll() {
		String[] nombreColumna = { "C�digo", "Empresa", "Tipo", "Rango Edad", "Vehiculo", "Provincia" };
		modeloTabla.setColumnIdentifiers(nombreColumna);
		modeloTabla.setRowCount(0);
		fila = new Object[modeloTabla.getColumnCount()];
		for (Solicitud soli : BolsaLaboral.getInstance().getMisSolicitudes()) {

			fila[0] = soli.getCodigo();
			fila[1] = soli.getEmpresa().getNombre();
			if (soli instanceof SolicitudUniversitario) {
				fila[2] = "Universitario";
			}
			if (soli instanceof SolicitudTecnico) {
				fila[2] = "T�cnico";
			}
			if (soli instanceof SolicitudObrero) {
				fila[2] = "Obrero";
			}
			String min = Integer.toString(soli.getEdadMin());
			String max = Integer.toString(soli.getEdadMax());
			fila[3] = min + " - " + max;

			if (soli.isVehiculoPropio()) {
				fila[4] = "Si";
			} else {
				fila[4] = "No";
			}
			fila[5] = soli.getLocalidad();
			modeloTabla.addRow(fila);
		}
		table.setModel(modeloTabla);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getTableHeader().setReorderingAllowed(false);
		TableColumnModel columnModel = table.getColumnModel();
		centrar.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < nombreColumna.length; i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(centrar);
		}

		columnModel.getColumn(0).setPreferredWidth(110);
		columnModel.getColumn(1).setPreferredWidth(180);
		columnModel.getColumn(2).setPreferredWidth(150);
		columnModel.getColumn(3).setPreferredWidth(170);
		columnModel.getColumn(4).setPreferredWidth(130);
		columnModel.getColumn(5).setPreferredWidth(159);

	}

	private static void loadUniversitario() {
		String[] nombreColumna = { "C�digo", "Empresa", "Vacantes", "Rango Edad", "Vehiculo", "Provincia", "Idiomas",
				"Carrera", "PostGrado" };
		modeloTabla.setColumnIdentifiers(nombreColumna);
		modeloTabla.setRowCount(0);
		fila = new Object[modeloTabla.getColumnCount()];
		for (Solicitud soli : BolsaLaboral.getInstance().getMisSolicitudes()) {
			if (soli instanceof SolicitudUniversitario) {
				String[] idioma = llenado(soli.getIdiomas());
				cbxIdioma = new JComboBox<String>(idioma);
				setComboIdiomas();

				fila[0] = soli.getCodigo();
				fila[1] = soli.getEmpresa().getNombre();
				fila[2] = soli.getCantVacantes();
				String min = Integer.toString(soli.getEdadMin());
				String max = Integer.toString(soli.getEdadMax());
				fila[3] = min + " - " + max;
				if (soli.isVehiculoPropio()) {
					fila[4] = "Si";
				} else {
					fila[4] = "No";
				}
				fila[5] = soli.getLocalidad();
				fila[6] = "Ver Idiomas";
				fila[7] = ((SolicitudUniversitario) soli).getCarrera();
				if (((SolicitudUniversitario) soli).isPostGrado()) {
					fila[8] = "Si";
				} else {
					fila[8] = "No";
				}
				modeloTabla.addRow(fila);

			}

		}
		table.setModel(modeloTabla);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getTableHeader().setReorderingAllowed(false);
		TableColumnModel columnModel = table.getColumnModel();
		centrar.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < nombreColumna.length; i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(centrar);
		}

		columnModel.getColumn(0).setPreferredWidth(65);
		columnModel.getColumn(1).setPreferredWidth(149);
		columnModel.getColumn(2).setPreferredWidth(80);
		columnModel.getColumn(3).setPreferredWidth(110);
		columnModel.getColumn(4).setPreferredWidth(60);
		columnModel.getColumn(5).setPreferredWidth(110);
		columnModel.getColumn(6).setPreferredWidth(120);
		columnModel.getColumn(7).setPreferredWidth(121);
		columnModel.getColumn(8).setPreferredWidth(84);

	}

	private static void loadTecnico() {
		String[] nombreColumna = { "C�digo", "Empresa", "Vacantes", "Rango Edad", "Vehiculo", "Provincia", "Idiomas",
				"Area" };

		modeloTabla.setColumnIdentifiers(nombreColumna);
		modeloTabla.setRowCount(0);
		fila = new Object[modeloTabla.getColumnCount()];
		for (Solicitud soli : BolsaLaboral.getInstance().getMisSolicitudes()) {
			if (soli instanceof SolicitudTecnico) {
				String[] idioma = llenado(soli.getIdiomas());
				cbxIdioma = new JComboBox<String>(idioma);
				setComboIdiomas();

				fila[0] = soli.getCodigo();
				fila[1] = soli.getEmpresa().getNombre();
				fila[2] = soli.getCantVacantes();

				String min = Integer.toString(soli.getEdadMin());
				String max = Integer.toString(soli.getEdadMax());
				fila[3] = min + " - " + max;

				if (soli.isVehiculoPropio()) {
					fila[4] = "Si";
				} else {
					fila[4] = "No";
				}
				fila[5] = soli.getLocalidad();
				fila[6] = "Ver Idiomas";
				fila[7] = ((SolicitudTecnico) soli).getArea();

				modeloTabla.addRow(fila);

			}

		}
		table.setModel(modeloTabla);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getTableHeader().setReorderingAllowed(false);
		TableColumnModel columnModel = table.getColumnModel();
		centrar.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < nombreColumna.length; i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(centrar);
		}

		columnModel.getColumn(0).setPreferredWidth(65);
		columnModel.getColumn(1).setPreferredWidth(149);
		columnModel.getColumn(2).setPreferredWidth(80);
		columnModel.getColumn(3).setPreferredWidth(120);
		columnModel.getColumn(4).setPreferredWidth(81);
		columnModel.getColumn(5).setPreferredWidth(130);
		columnModel.getColumn(6).setPreferredWidth(135);
		columnModel.getColumn(7).setPreferredWidth(139);

	}

	private static void loadObrero() {
		String[] nombreColumna = { "C�digo", "Empresa", "Vacantes", "Rango Edad", "Vehiculo", "Provincia", "Idiomas",
				"Habilidades" };
		modeloTabla.setColumnIdentifiers(nombreColumna);
		modeloTabla.setRowCount(0);
		fila = new Object[modeloTabla.getColumnCount()];
		for (Solicitud soli : BolsaLaboral.getInstance().getMisSolicitudes()) {
			if (soli instanceof SolicitudObrero) {
				String[] idioma = llenado(soli.getIdiomas());
				String[] habilidad = llenado(((SolicitudObrero) soli).getHabilidades());
				cbxHabilidades = new JComboBox<String>(habilidad);
				cbxIdioma = new JComboBox<String>(idioma);
				setComboIdiomas();
				setCombo();

				fila[0] = soli.getCodigo();
				fila[1] = soli.getEmpresa().getNombre();
				fila[2] = soli.getCantVacantes();

				String min = Integer.toString(soli.getEdadMin());
				String max = Integer.toString(soli.getEdadMax());
				fila[3] = min + " - " + max;
				if (soli.isVehiculoPropio()) {
					fila[4] = "Si";
				} else {
					fila[4] = "No";
				}
				fila[5] = soli.getLocalidad();
				fila[6] = "Ver Idiomas";
				fila[7] = "Ver Habilidades";

				modeloTabla.addRow(fila);

			}

		}
		table.setModel(modeloTabla);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getTableHeader().setReorderingAllowed(false);
		TableColumnModel columnModel = table.getColumnModel();
		centrar.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < nombreColumna.length; i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(centrar);
		}

		columnModel.getColumn(0).setPreferredWidth(65);
		columnModel.getColumn(1).setPreferredWidth(149);
		columnModel.getColumn(2).setPreferredWidth(80);
		columnModel.getColumn(3).setPreferredWidth(120);
		columnModel.getColumn(4).setPreferredWidth(81);
		columnModel.getColumn(5).setPreferredWidth(130);
		columnModel.getColumn(6).setPreferredWidth(135);
		columnModel.getColumn(7).setPreferredWidth(139);

	}

	private void loadTablaRNC() {
		ArrayList<Solicitud> lista = new ArrayList<>();
		lista = BolsaLaboral.getInstance().RetornaSolicitudEmp(empresaListar);
		String[] nombreColumna = { "C�digo", "Empresa", "Tipo","Rango Edad", "Vehiculo","Provincia" };
		modeloTabla.setColumnIdentifiers(nombreColumna);
		modeloTabla.setRowCount(0);
		fila = new Object[modeloTabla.getColumnCount()];

		for (Solicitud soli : lista) {
		
			fila[0] = soli.getCodigo();
			fila[1] = soli.getEmpresa().getNombre();
			if (soli instanceof SolicitudUniversitario) {
				fila[2] = "Universitario";
			}
			if (soli instanceof SolicitudTecnico) {
				fila[2] = "T�cnico";
			}
			if (soli instanceof SolicitudObrero) {
				fila[2] = "Obrero";
			}
			String min = Integer.toString(soli.getEdadMin());
			String max = Integer.toString(soli.getEdadMax());
			fila[3] = min + " - " + max;
			if (soli.isVehiculoPropio()) {
				fila[4] = "Si";
			} else {
				fila[4] = "No";
			}
			fila[5] = soli.getLocalidad();
			modeloTabla.addRow(fila);

		}
		table.setModel(modeloTabla);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getTableHeader().setReorderingAllowed(false);
		TableColumnModel columnModel = table.getColumnModel();
		centrar.setHorizontalAlignment(SwingConstants.CENTER);
		for (int i = 0; i < nombreColumna.length; i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(centrar);
		}

		columnModel.getColumn(0).setPreferredWidth(110);
		columnModel.getColumn(1).setPreferredWidth(180);
		columnModel.getColumn(2).setPreferredWidth(150);
		columnModel.getColumn(3).setPreferredWidth(170);
		columnModel.getColumn(4).setPreferredWidth(130);
		columnModel.getColumn(5).setPreferredWidth(159);
	}

	public static void setComboIdiomas() {
		TableColumn col = table.getColumnModel().getColumn(6);
		col.setCellEditor(new DefaultCellEditor(cbxIdioma));
	}

	public static void setCombo() {
		TableColumn col = table.getColumnModel().getColumn(7);
		col.setCellEditor(new DefaultCellEditor(cbxHabilidades));

	}

	public static String[] llenado(ArrayList<String> copiado) {
		String[] arr = new String[copiado.size()];
		copiado.toArray(arr);
		return arr;
	}

}

