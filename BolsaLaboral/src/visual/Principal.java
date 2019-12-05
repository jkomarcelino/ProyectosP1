package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Paint;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale.Category;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;

import logico.BolsaLaboral;

//import de.javasoft.plaf.synthetica.SyntheticaPlainLookAndFeel;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EtchedBorder;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.border.BevelBorder;
import java.awt.Toolkit;
import java.awt.SystemColor;


public class Principal extends JFrame implements Runnable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JPanel panelBarras;
	private static CategoryDataset datasetBarra;
	private static PieDataset datasetPastel;
	private static PieDataset datasetPastel2;
	private static JFreeChart chartBarra;
	private static JFreeChart chartPastel;
	private static JFreeChart chartPastel2;
	private static JPanel panelPastel;
	private static JPanel panelPastel2;


	private JLabel lblHora ;
    int hora, minutos, segundos;
    Calendar calendario;
	Thread h1;
	//private Dimension dim;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
	

					Principal frame = new Principal();

					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/img/edificio-de-oficinas.png")));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (JOptionPane.showConfirmDialog(null, "¿Desea guardar los nuevos cambios en la bolsa laboral?",
						"Atención Requerida", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

				
					BolsaLaboral.getInstance().writeBolsa();
					dispose();
				} else {
					dispose();

				}
			}
		});
		BolsaLaboral.getInstance().readBolsa();
		setBackground(new Color(248, 248, 255));
		setResizable(false);
		setTitle("JOBIFY ~ Bolsa Laboral");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1304, 727);

		setLocationRelativeTo(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.inactiveCaption);
		setJMenuBar(menuBar);

		JMenu mnCandidatos = new JMenu("Personal");
		mnCandidatos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mnCandidatos.setIcon(new ImageIcon(Principal.class.getResource("/img/employeeNoColor.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				mnCandidatos.setIcon(new ImageIcon(Principal.class.getResource("/img/employee.png")));
			}
		});
		
		
		
		JMenu mnMacheo = new JMenu("Bolsa Laboral");
		mnMacheo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mnMacheo.setIcon(new ImageIcon(Principal.class.getResource("/img/handshake noColor.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				mnMacheo.setIcon(new ImageIcon(Principal.class.getResource("/img/handshake.png")));
			}
		});
		mnMacheo.setFont(new Font("Dubai Light", Font.BOLD, 14));
		mnMacheo.setIcon(new ImageIcon(Principal.class.getResource("/img/handshake.png")));
		menuBar.add(mnMacheo);

		JMenuItem mntmRealizarMacheo = new JMenuItem("Realizar Matching");
		mntmRealizarMacheo.setIcon(new ImageIcon(Principal.class.getResource("/img/pareo.png")));
		mntmRealizarMacheo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Matching match;
				try {
					match = new Matching();
					match.setModal(true);
					match.setLocationRelativeTo(null);
					match.setVisible(true);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}

			}
		});
		mnMacheo.add(mntmRealizarMacheo);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Contratados");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Contratado contrat = new Contratado();
				contrat.setModal(true);
				contrat.setLocationRelativeTo(null);
				contrat.setVisible(true);
			}
		});
		mntmNewMenuItem.setIcon(new ImageIcon(Principal.class.getResource("/img/modificar.png")));
		mnMacheo.add(mntmNewMenuItem);

		JSeparator separator = new JSeparator();
		mnMacheo.add(separator);

		JMenuItem mntmCerrar = new JMenuItem("Salir");
		mntmCerrar.setIcon(new ImageIcon(Principal.class.getResource("/img/cancelar.png")));
		mntmCerrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(null, "ï¿½Desea guardar los nuevos cambios en la bolsa laboral?",
						"Atenciï¿½n Requerida", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

					
					BolsaLaboral.getInstance().writeBolsa();
					dispose();
				} else {
					dispose();

				}
			}
		});
		mnMacheo.add(mntmCerrar);
		mnCandidatos.setFont(new Font("Dubai Light", Font.BOLD, 14));
		mnCandidatos.setIcon(new ImageIcon(Principal.class.getResource("/img/employee.png")));
		menuBar.add(mnCandidatos);

		JMenuItem mntmRegistrarCandidato = new JMenuItem("Registrar Persona");
		mntmRegistrarCandidato.setIcon(new ImageIcon(Principal.class.getResource("/img/agregarSolicitante.png")));
		mntmRegistrarCandidato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegPersona soli = new RegPersona("Insertar Solicitante", false, null, null);

				soli.setModal(true);
				soli.setLocationRelativeTo(null);
				soli.setVisible(true);
			}
		});
		mnCandidatos.add(mntmRegistrarCandidato);

		JMenuItem mntmListarCandidatos = new JMenuItem("Listar Persona");
		mntmListarCandidatos.setIcon(new ImageIcon(Principal.class.getResource("/img/Listas.png")));
		mntmListarCandidatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaPersonal soli = new ListaPersonal();
				soli.setModal(true);
				soli.setLocationRelativeTo(null);
				soli.setVisible(true);
			}
		});
		mnCandidatos.add(mntmListarCandidatos);

		JMenu mnEmpresa = new JMenu("Empresa");
		mnEmpresa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mnEmpresa.setIcon(new ImageIcon(Principal.class.getResource("/img/enterpriseNoColor.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				mnEmpresa.setIcon(new ImageIcon(Principal.class.getResource("/img/enterprise.png")));
			}
		});
		mnEmpresa.setIcon(new ImageIcon(Principal.class.getResource("/img/enterprise.png")));
		mnEmpresa.setFont(new Font("Dubai Light", Font.BOLD, 14));
		menuBar.add(mnEmpresa);

		JMenuItem mntmRegistrarEmpresa = new JMenuItem("Registrar Empresa");
		mntmRegistrarEmpresa.setIcon(new ImageIcon(Principal.class.getResource("/img/addEmpresa.png")));
		mntmRegistrarEmpresa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegEmpresa empre;
				try {
					empre = new RegEmpresa("Insertar Empresa", false, null, null);
					empre.setModal(true);
					empre.setLocationRelativeTo(null);
					empre.setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		mnEmpresa.add(mntmRegistrarEmpresa);

		JMenuItem mntmListarEmpresas = new JMenuItem("Listar Empresas");
		mntmListarEmpresas.setIcon(new ImageIcon(Principal.class.getResource("/img/Listas.png")));
		mntmListarEmpresas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListaEmpresas lista = new ListaEmpresas();
				lista.setModal(true);
				lista.setLocationRelativeTo(null);
				lista.setVisible(true);
			}
		});
		mnEmpresa.add(mntmListarEmpresas);
		JMenu mnSolicitud = new JMenu("Solicitud Empresa");
		mnSolicitud.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mnSolicitud.setIcon(new ImageIcon(Principal.class.getResource("/img/archivenoColor.png")));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				mnSolicitud.setIcon(new ImageIcon(Principal.class.getResource("/img/archive.png")));
			}
		});
		mnSolicitud.setFont(new Font("Dubai Light", Font.BOLD, 14));
		mnSolicitud.setIcon(new ImageIcon(Principal.class.getResource("/img/archive.png")));
		menuBar.add(mnSolicitud);

		JMenuItem mntmRegistrarSolicitud = new JMenuItem("Solicitud Empresarial");
		mntmRegistrarSolicitud.setIcon(new ImageIcon(Principal.class.getResource("/img/addSolicitud.png")));
		mntmRegistrarSolicitud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SolicitudEmpresa solicitud = new SolicitudEmpresa(null);
				solicitud.setModal(true);
				solicitud.setVisible(true);
			}
		});
		mnSolicitud.add(mntmRegistrarSolicitud);

		JMenuItem mntmListarSolicitud = new JMenuItem("Listar Solicitud");
		mntmListarSolicitud.setIcon(new ImageIcon(Principal.class.getResource("/img/Listas.png")));
		mntmListarSolicitud.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListaSolicitud soli = new ListaSolicitud();
				soli.setModal(true);
				soli.setVisible(true);
			}
		});
		mnSolicitud.add(mntmListarSolicitud);

		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		panelBarras = new JPanel();
		panelBarras.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelBarras.setBounds(22, 373, 610, 253);
		panel.add(panelBarras);
		panelBarras.setLayout(null);

		panelPastel = new JPanel();
		panelPastel.setBackground(SystemColor.inactiveCaption);
		panelPastel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelPastel.setBounds(658, 373, 610, 253);
		panel.add(panelPastel);
		panelPastel.setLayout(null);
		
		panelPastel2 = new JPanel();
		panelPastel2.setBackground(SystemColor.inactiveCaption);
		panelPastel2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelPastel2.setBounds(658, 113, 610, 249);
		panel.add(panelPastel2);
		panelPastel2.setLayout(null);
		

		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(Principal.class.getResource("/img/JOBIFY.png")));
		lblLogo.setBounds(483, -17, 333, 89);
		panel.add(lblLogo);
		
		JLabel lblBolsa = new JLabel("New label");
		lblBolsa.setIcon(new ImageIcon(Principal.class.getResource("/img/bolsalaboral.png")));
		lblBolsa.setBounds(558, 50, 221, 29);
		panel.add(lblBolsa);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(SystemColor.activeCaption);
		separator_1.setBounds(10, 93, 1270, 9);
		panel.add(separator_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_1.setBackground(SystemColor.inactiveCaptionBorder);
		panel_1.setBounds(10, 104, 1270, 538);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/img/team.png")));
		lblNewLabel.setBounds(188, 11, 263, 256);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.inactiveCaptionBorder);
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.setBounds(1203, 66, 77, 24);
		panel.add(panel_2);
		
		lblHora = new JLabel("HH::MM::RR");
		lblHora.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_2.add(lblHora);
		actualizarChart();
		actualizarPastel();
		actualizarPastel2();
		h1 = new Thread(this);
	    h1.start();
	
		
	}
	public static void actualizarPastel2() {
		panelPastel2.removeAll();
		panelPastel2.revalidate();
		datasetPastel2 = dataSetPastel2();
		chartPastel2 = creadorGraficoP2(datasetPastel2, "Porcentaje de Contratados por Género");
		panelPastel2.setLayout(null);
		ChartPanel chartPanel2 = new ChartPanel(chartPastel2);
		chartPanel2.setBorder(null);
		chartPanel2.setBounds(10, 2, 590, 236);
		chartPanel2.setPreferredSize(new java.awt.Dimension(800, 500));
		panelPastel2.add(chartPanel2);
		chartPanel2.setLayout(null);
		panelPastel2.repaint();

	}

	public static void actualizarPastel() {
		panelPastel.removeAll();
		panelPastel.revalidate();
		datasetPastel = dataSetPastel();
		chartPastel = creadorGraficoP(datasetPastel, "Porcentaje de Contratados Por Tipo");
		panelPastel.setLayout(null);
		ChartPanel chartPanel = new ChartPanel(chartPastel);
		chartPanel.setBorder(null);
		chartPanel.setBounds(10, 2, 590, 240);
		chartPanel.setPreferredSize(new java.awt.Dimension(800, 500));
		panelPastel.add(chartPanel);
		chartPanel.setLayout(null);
		panelPastel.repaint();

	}

	public static void actualizarChart() {
		panelBarras.removeAll();
		panelBarras.revalidate();
		datasetBarra = creadorCategoria();
		chartBarra = creadorGraficoB(datasetBarra, "Solicitantes en Espera por Tipo");
		panelBarras.setLayout(new BorderLayout(0, 0));
		ChartPanel chartPanel = new ChartPanel(chartBarra);
		chartPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		chartPanel.setPreferredSize(new java.awt.Dimension(800, 500));
		panelBarras.add(chartPanel, BorderLayout.CENTER);
		chartPanel.setLayout(null);
		panelBarras.repaint();
		
	}

	public static JFreeChart creadorGraficoB(CategoryDataset dataSet, String titulo) {
		JFreeChart grafico = ChartFactory.createBarChart(titulo, "Tipo de Solicitante", "Catidad Desempleados", dataSet,
				PlotOrientation.VERTICAL, false, true, false);
	
		grafico.setBackgroundPaint(	SystemColor.inactiveCaption);
		CategoryPlot plot = (CategoryPlot) grafico.getPlot();
		plot.setForegroundAlpha(0.8f);
		plot.setBackgroundPaint(new Color(254, 253, 241));
		return grafico;
	}

	public static JFreeChart creadorGraficoP(PieDataset dataSet, String titulo) {
		JFreeChart chart = ChartFactory.createPieChart3D(titulo, dataSet, true, true, false);
		//Color col = new Color(255, 249, 234);
		chart.setBackgroundPaint(	SystemColor.inactiveCaption);
		PiePlot3D plot = (PiePlot3D) chart.getPlot();
		plot.setStartAngle(0.5);
		plot.setDirection(Rotation.CLOCKWISE);
		plot.setForegroundAlpha(0.5f);
		plot.setBackgroundPaint(new Color(254, 253, 241));
		return chart;

	}
	public static JFreeChart creadorGraficoP2(PieDataset dataSet, String titulo) {
		JFreeChart chart = ChartFactory.createPieChart3D(titulo, dataSet, true, true, false);
		//Color col = new Color(255, 249, 234);
		chart.setBackgroundPaint(	SystemColor.inactiveCaption);
		PiePlot3D plot = (PiePlot3D) chart.getPlot();
		plot.setStartAngle(0.5);
		plot.setDirection(Rotation.CLOCKWISE);
		plot.setForegroundAlpha(0.5f);
		plot.setBackgroundPaint(new Color(254, 253, 241));
		return chart;

	}


	public static CategoryDataset creadorCategoria() {
		DefaultCategoryDataset setter = new DefaultCategoryDataset();
		setter.setValue(BolsaLaboral.getInstance().desempleadoO(), "Tipo de Solicitante", "Obreros");
		setter.setValue(BolsaLaboral.getInstance().desempleadoU(), "Tipo de Solicitante", "Universitarios");
		setter.setValue(BolsaLaboral.getInstance().desempleadoT(), "Tipo de Solicitante", "Técnicos");
		return setter;
	}

	public static PieDataset dataSetPastel() {
		DefaultPieDataset result = new DefaultPieDataset();
		if (BolsaLaboral.getInstance().porcientoO() != 0) {
			result.setValue("Obrero", BolsaLaboral.getInstance().porcientoO());
		}
		if (BolsaLaboral.getInstance().porcientoT() != 0) {
			result.setValue("Tecnico", BolsaLaboral.getInstance().porcientoT());
		}
		if (BolsaLaboral.getInstance().porcientoU() != 0) {
			result.setValue("Universitario", BolsaLaboral.getInstance().porcientoU());
		}

		return result;
	}
	
	public static PieDataset dataSetPastel2() {
		DefaultPieDataset result = new DefaultPieDataset();
		if (BolsaLaboral.getInstance().porcientoH() != 0) {
			result.setValue("Masculino", BolsaLaboral.getInstance().porcientoH());
		}
		if (BolsaLaboral.getInstance().porcientoF() != 0) {
			result.setValue("Femenino", BolsaLaboral.getInstance().porcientoF());
		}

		return result;
	}

/*
	public void hiloBarras() {
		Thread actualizar = new Thread() {
			public void run() {
				try {
					for (;;) {
						actualizarChart();
						sleep(1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		};
		actualizar.start();
	}*/
	
	@Override
	public void run() {
		Thread ct = Thread.currentThread();
        while (ct == h1) {
            calcula();
            lblHora.setText(hora + ":" + minutos + ":" + segundos);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
		
	}
	
	public void calcula() {
        Calendar calendario = new GregorianCalendar();
        hora =calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND);
    }
}
