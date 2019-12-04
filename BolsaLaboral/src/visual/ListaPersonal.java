package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import logico.BolsaLaboral;
import logico.Obrero;
import logico.Personal;
import logico.Tecnico;
import logico.Universitario;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.border.EtchedBorder;
import javax.swing.ImageIcon;

public class ListaPersonal extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private static Object[] fila;
	private static DefaultTableModel modeloTabla;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JComboBox cbxFiltro;
	private JButton cancelButton;
	private String cedulaCliente = "";
	private JComboBox<String> habilidades;
	private static JComboBox<String> cbxIdioma;

	/**
	 * Launch the application.
	 * 
	 * public static void main(String[] args) { try { ListarSolicitante dialog =
	 * new ListarSolicitante();
	 * dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	 * dialog.setVisible(true); } catch (Exception e) { e.printStackTrace(); } }
	 * 
	 * /** Create the dialog.
	 */
	public ListaPersonal() {
		getContentPane().setBackground(new Color(248, 248, 255));
		setBackground(new Color(248, 248, 255));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				cbxFiltro.setSelectedIndex(0);
				loadTablaG();
			}
		});
		setResizable(false);
		setModal(true);
		setTitle("Listar Solicitantes\r\n");
		setResizable(false);
		setBounds(100, 100, 987, 511);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(248, 248, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(248, 248, 255));
			panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null),
					"Listado De Solicitantes", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);

			cbxFiltro = new JComboBox();
			cbxFiltro.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String seleccion = cbxFiltro.getSelectedItem().toString();
					if (seleccion.equalsIgnoreCase("General")) {
						loadTablaG();
					}
					if (seleccion.equalsIgnoreCase("Universitarios")) {
						loadTablaU();
					}
					if (seleccion.equalsIgnoreCase("Obreros")) {
						loadTablaO();
					}
					if (seleccion.equalsIgnoreCase("T�cnicos")) {
						loadTablaT();
					}
				}
			});
			cbxFiltro.setModel(
					new DefaultComboBoxModel(new String[] { "General", "Obreros", "T\u00E9cnicos", "Universitarios" }));
			cbxFiltro.setBounds(80, 26, 119, 20);
			panel.add(cbxFiltro);

			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setBounds(10, 60, 951, 343);
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
							cedulaCliente = (String) table.getModel().getValueAt(aux, 0);
						} else {
							btnModificar.setEnabled(false);
							btnEliminar.setEnabled(false);
							cedulaCliente = "";
						}
					}
				});
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				table.getTableHeader().setResizingAllowed(false);
				modeloTabla = new DefaultTableModel() {

					@Override
					public boolean isCellEditable(int row, int column) {
						return true;
					}
				};
				String tipo = cbxFiltro.getSelectedItem().toString();

				loadTabla(tipo);
				scrollPane.setViewportView(table);
			}

			JLabel lblFiltrarPor = new JLabel("Filtrar por :");
			lblFiltrarPor.setBounds(10, 29, 63, 14);
			panel.add(lblFiltrarPor);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBorder(null);
			buttonPane.setBackground(new Color(248, 248, 255));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.setIcon(new ImageIcon(ListaPersonal.class.getResource("/img/borrar.png")));
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						Personal soli = BolsaLaboral.getInstance().retornarSolicitante(cedulaCliente);

						if (soli != null) {
							if (JOptionPane.showConfirmDialog(null, "�Desea eliminar  esta solicitud?", "Advertencia",
									JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
								BolsaLaboral.getInstance().eliminarSolicitante(soli);
								Principal.actualizarChart();

							}
						}
					}
				});
				btnEliminar.setEnabled(false);
				buttonPane.add(btnEliminar);
			}
			{
				btnModificar = new JButton("Modificar");
				btnModificar.setIcon(new ImageIcon(ListaPersonal.class.getResource("/img/modificar.png")));
				btnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Personal persona = BolsaLaboral.getInstance().retornarSolicitante(cedulaCliente);
						RegPersona soli = new RegPersona("Modificar Solicitante", true, persona, null);
						soli.setModal(true);
						soli.setLocationRelativeTo(null);
						soli.setVisible(true);
						btnModificar.setEnabled(false);
						btnEliminar.setEnabled(false);
						cedulaCliente = "";

					}
				});
				btnModificar.setEnabled(false);
				btnModificar.setActionCommand("OK");
				buttonPane.add(btnModificar);
				getRootPane().setDefaultButton(btnModificar);
			}
			{
				cancelButton = new JButton("Cancelar");
				cancelButton.setIcon(new ImageIcon(ListaPersonal.class.getResource("/img/cancelar.png")));
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

	public static void loadTabla(String seleccion) {
		if (seleccion.equalsIgnoreCase("General")) {
			loadTablaG();
		}
		if (seleccion.equalsIgnoreCase("Universitarios")) {
			loadTablaU();

		}
		if (seleccion.equalsIgnoreCase("Obreros")) {

		}
		if (seleccion.equalsIgnoreCase("T�cnicos")) {

		}
	}

	public static void loadTablaG() {
		String tipo = "";
		String[] nombreColumna = { "C�dula", "Nombre", "Edad", "A�os de Experiencia", "Tipo" };
		modeloTabla.setColumnIdentifiers(nombreColumna);
		modeloTabla.setRowCount(0);
		fila = new Object[modeloTabla.getColumnCount()];
		for (Personal soli : BolsaLaboral.getInstance().getMisPersonas()) {
			if (soli.isContratado() == false) {
				if (!soli.isContratado()) {
					tipo = "Universitario";
					if (soli instanceof Obrero) {
						tipo = "Obrero";
					}
					if (soli instanceof Tecnico) {
						tipo = "T�cnico";
					}
					fila[0] = soli.getCedula();
					fila[1] = soli.getNombres() + " " + soli.getApellidos();
					fila[2] = soli.getEdad() + " a�os";
					fila[3] = soli.getAnnosExperiencia() + " a�os";
					fila[4] = tipo;
					modeloTabla.addRow(fila);

					table.setModel(modeloTabla);
					table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					table.getTableHeader().setReorderingAllowed(false);
					TableColumnModel modeloColumna = table.getColumnModel();
					modeloColumna.getColumn(0).setPreferredWidth(160);
					modeloColumna.getColumn(1).setPreferredWidth(282);
					modeloColumna.getColumn(2).setPreferredWidth(160);
					modeloColumna.getColumn(3).setPreferredWidth(170);
					modeloColumna.getColumn(4).setPreferredWidth(150);
				}
			}

		}

	}

	public static void loadTablaU() {

		String[] nombreColumna = { "C�dula", "Nombre", "Edad", "Carrera", "Idiomas", "A�os de Experiencia", "Tel�fono",
				"E-Mail" };
		modeloTabla.setColumnIdentifiers(nombreColumna);
		modeloTabla.setRowCount(0);
		fila = new Object[modeloTabla.getColumnCount()];
		for (Personal soli : BolsaLaboral.getInstance().getMisPersonas()) {
			if (soli instanceof Universitario) {
				if (soli.isContratado() == false) {
					String[] idioma = llenado(soli.getIdiomas());
					cbxIdioma = new JComboBox<String>(idioma);
					setComboIdiomas();

					fila[0] = soli.getCedula();
					fila[1] = soli.getNombres() + " " + soli.getApellidos();
					fila[2] = soli.getEdad() + " a�os";
					fila[3] = ((Universitario) soli).getCarrera();
					fila[4] = "Hacer click";
					fila[5] = soli.getAnnosExperiencia() + " a�os";
					fila[6] = soli.getTelefono();
					fila[7] = soli.getEmail();

					modeloTabla.addRow(fila);

					table.setModel(modeloTabla);
					table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					table.getTableHeader().setReorderingAllowed(false);
					TableColumnModel modeloColumna = table.getColumnModel();
					modeloColumna.getColumn(0).setPreferredWidth(110);
					modeloColumna.getColumn(1).setPreferredWidth(150);
					modeloColumna.getColumn(2).setPreferredWidth(80);
					modeloColumna.getColumn(3).setPreferredWidth(110);
					modeloColumna.getColumn(4).setPreferredWidth(100);
					modeloColumna.getColumn(5).setPreferredWidth(160);
					modeloColumna.getColumn(6).setPreferredWidth(100);
					modeloColumna.getColumn(7).setPreferredWidth(140);
				}
			}

		}
	}

	public void loadTablaO() {

		String[] nombreColumna = { "C�dula", "Nombre", "Edad", "Habilidades", "Idiomas", "A�os de Experiencia",
				"Tel�fono", "E-Mail" };
		modeloTabla.setColumnIdentifiers(nombreColumna);
		modeloTabla.setRowCount(0);
		fila = new Object[modeloTabla.getColumnCount()];
		for (Personal soli : BolsaLaboral.getInstance().getMisPersonas()) {
			if (soli instanceof Obrero) {
				if (soli.isContratado() == false) {
					String[] idioma = llenado(soli.getIdiomas());
					String[] habilidad = llenado(((Obrero) soli).getHabilidades());
					habilidades = new JComboBox<String>(habilidad);
					cbxIdioma = new JComboBox<String>(idioma);
					setComboIdiomas();
					setCombo();

					fila[0] = soli.getCedula();
					fila[1] = soli.getNombres() + " " + soli.getApellidos();
					fila[2] = soli.getEdad() + " a�os";
					fila[3] = "Hacer click";
					fila[4] = "Hacer click";
					fila[5] = soli.getAnnosExperiencia() + " a�os";
					fila[6] = soli.getTelefono();
					fila[7] = soli.getEmail();
					modeloTabla.addRow(fila);

					table.setModel(modeloTabla);
					table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					table.getTableHeader().setReorderingAllowed(false);
					TableColumnModel modeloColumna = table.getColumnModel();
					modeloColumna.getColumn(0).setPreferredWidth(110);
					modeloColumna.getColumn(1).setPreferredWidth(160);
					modeloColumna.getColumn(2).setPreferredWidth(90);
					modeloColumna.getColumn(3).setPreferredWidth(100);
					modeloColumna.getColumn(4).setPreferredWidth(100);
					modeloColumna.getColumn(5).setPreferredWidth(160);
					modeloColumna.getColumn(6).setPreferredWidth(100);
					modeloColumna.getColumn(7).setPreferredWidth(140);
				}
			}

		}
	}

	public void loadTablaT() {
		String[] nombreColumna = { "C�dula", "Nombre", "Edad", "�rea", "Idiomas", "A�os de Experiencia", "Tel�fono",
				"E-Mail" };
		modeloTabla.setColumnIdentifiers(nombreColumna);
		modeloTabla.setRowCount(0);
		fila = new Object[modeloTabla.getColumnCount()];
		for (Personal soli : BolsaLaboral.getInstance().getMisPersonas()) {
			if (soli instanceof Tecnico) {
				if (soli.isContratado() == false) {
					String[] idioma = llenado(soli.getIdiomas());
					cbxIdioma = new JComboBox<String>(idioma);
					setComboIdiomas();

					fila[0] = soli.getCedula();
					fila[1] = soli.getNombres() + " " + soli.getApellidos();
					fila[2] = soli.getEdad() + " a�os";
					fila[3] = ((Tecnico) soli).getArea();
					fila[4] = "Hacer click";
					fila[5] = soli.getAnnosExperiencia() + " a�os";
					fila[6] = soli.getTelefono();
					fila[7] = soli.getEmail();
					modeloTabla.addRow(fila);

					table.setModel(modeloTabla);
					table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
					table.getTableHeader().setReorderingAllowed(false);
					TableColumnModel modeloColumna = table.getColumnModel();
					modeloColumna.getColumn(0).setPreferredWidth(110);
					modeloColumna.getColumn(1).setPreferredWidth(160);
					modeloColumna.getColumn(2).setPreferredWidth(90);
					modeloColumna.getColumn(3).setPreferredWidth(100);
					modeloColumna.getColumn(4).setPreferredWidth(100);
					modeloColumna.getColumn(5).setPreferredWidth(160);
					modeloColumna.getColumn(6).setPreferredWidth(100);
					modeloColumna.getColumn(7).setPreferredWidth(140);
				}
			}

		}

	}

	public static void setComboIdiomas() {
		TableColumn col = table.getColumnModel().getColumn(4);
		col.setCellEditor(new DefaultCellEditor(cbxIdioma));
	}

	public void setCombo() {
		TableColumn col = table.getColumnModel().getColumn(3);
		col.setCellEditor(new DefaultCellEditor(habilidades));
		habilidades.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});

	}

	public static String[] llenado(ArrayList<String> copiado) {
		String[] arr = new String[copiado.size()];
		copiado.toArray(arr);
		return arr;
	}
}
