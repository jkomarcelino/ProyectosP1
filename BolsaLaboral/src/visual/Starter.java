package visual;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.border.BevelBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;

import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import java.awt.Toolkit;
import java.awt.GridLayout;
import javax.swing.border.EtchedBorder;

public class Starter extends JFrame {
	private JPanel panel;
	private JPanel panelGrafi1;
	private JPanel panelGrafi2;
	private JPanel panelGrafi3;
	JLabel lblHora ;
    int hora, minutos, segundos;
    Calendar calendario;
    Thread h1;
 /// CLASE UTILIZADA CON FINES DE PRUEBAS
	/**
	 * Launch the application.
	 *
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
	public Starter() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Starter.class.getResource("/icon/networking.png")));
		setResizable(false);
		setTitle("Bolsa Laboral");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1072, 696);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		 panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBackground(SystemColor.inactiveCaption);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.inactiveCaptionBorder);
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_2.setBounds(10, 82, 1046, 532);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		panelGrafi1 = new JPanel();
		panelGrafi1.setBackground(SystemColor.controlHighlight);
		panelGrafi1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelGrafi1.setBounds(529, 11, 507, 249);
		panel_2.add(panelGrafi1);
		showGraf1();
		
		JLabel lblPorcientoMujer = new JLabel("porciento por genero");
		lblPorcientoMujer.setBounds(203, 261, 101, 14);
		panelGrafi1.add(lblPorcientoMujer);
		
		 panelGrafi3 = new JPanel();
		panelGrafi3.setBackground(SystemColor.controlHighlight);
		panelGrafi3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelGrafi3.setBounds(10, 271, 507, 249);
		panel_2.add(panelGrafi3);
		showGraf3();
		
		
		JLabel label = new JLabel("");
		label.setBounds(253, 432, 0, 0);
		panelGrafi3.add(label);
		
		 panelGrafi2 = new JPanel();
		panelGrafi2.setBackground(SystemColor.controlHighlight);
		panelGrafi2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelGrafi2.setBounds(529, 271, 507, 249);
		panel_2.add(panelGrafi2);
		showGraf2();
		
		JLabel lblEmpleadosEnEspera = new JLabel("empleados en espera");
		panelGrafi2.add(lblEmpleadosEnEspera);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBounds(10, 11, 507, 249);
		panel_2.add(panel_1);
		
		JLabel label_1 = new JLabel("");
		panel_1.add(label_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(Starter.class.getResource("/icon/JOBIFY.png")));
		lblNewLabel.setBounds(407, 11, 237, 76);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Starter.class.getResource("/icon/bolsalaboral.png")));
		lblNewLabel_1.setBounds(434, 51, 296, 26);
		panel.add(lblNewLabel_1);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(SystemColor.inactiveCaptionBorder);
		panel_6.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_6.setBounds(984, 59, 72, 20);
		panel.add(panel_6);
		
		lblHora = new JLabel("HO:RA:ACT");
		lblHora.setVerticalAlignment(SwingConstants.TOP);
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblHora, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addComponent(lblHora, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_6.setLayout(gl_panel_6);
		/*h1 = new Thread(this);
	    h1.start();*/
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.PINK);
		menuBar.setBorderPainted(false);
		menuBar.setBackground(SystemColor.activeCaption);
		
		setJMenuBar(menuBar);
		
		JMenu mnPersonal = new JMenu("Personal");
		mnPersonal.setBackground(SystemColor.activeCaption);
		mnPersonal.setIcon(new ImageIcon(Starter.class.getResource("/icon/empresario.png")));
		menuBar.add(mnPersonal);
		
		JMenuItem mntmRegistrar = new JMenuItem("Registrar Persona");
		mntmRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		/*		RegPersona regper = new RegPersona(null);
				regper.setLocationRelativeTo(null);
				regper.setVisible(true);*/
			}
		});
		mnPersonal.add(mntmRegistrar);
		
		
		JMenuItem mntmSolicPerson = new JMenuItem("Generar Solicitud");
		mntmSolicPerson.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SolicitudPersonal solper = new SolicitudPersonal();
				solper.setLocationRelativeTo(null);
				solper.setVisible(true);
			}
		});
		mnPersonal.add(mntmSolicPerson);
		
		JMenuItem mntmLista = new JMenuItem("Lista");
		mnPersonal.add(mntmLista);
		
		JMenu mnEmpresa = new JMenu("Empresa");
		mnEmpresa.setBackground(SystemColor.activeCaption);
		mnEmpresa.setIcon(new ImageIcon(Starter.class.getResource("/icon/edificio-de-oficinas.png")));
		menuBar.add(mnEmpresa);
		
		JMenuItem mntmRegEmp = new JMenuItem("Registrar Empresa");
		mntmRegEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			/*	RegEmpresa regemp = new RegEmpresa();
				regemp.setLocationRelativeTo(null);
				regemp.setVisible(true);*/
				
			}
		});
		mnEmpresa.add(mntmRegEmp);
		
		JMenuItem mntmSoliEmp = new JMenuItem("Generar Solicitud");
		mntmSoliEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
			/*	SolicitudEmpresa solemp = new SolicitudEmpresa();
				solemp.setLocationRelativeTo(null);
				solemp.setVisible(true);	*/
}
		});
		
		JMenuItem mntmModificarEmpresa = new JMenuItem("Modificar Empresa");
		mnEmpresa.add(mntmModificarEmpresa);
		mnEmpresa.add(mntmSoliEmp);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Lista");
		mnEmpresa.add(mntmNewMenuItem_8);
		
		JMenu mnReporte = new JMenu("Reportes");
		mnReporte.setBackground(SystemColor.activeCaption);
		mnReporte.setIcon(new ImageIcon(Starter.class.getResource("/icon/impresora.png")));
		menuBar.add(mnReporte);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("New menu item");
		mnReporte.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("New menu item");
		mnReporte.add(mntmNewMenuItem_4);
		
		JMenu mnNewMenu_3 = new JMenu("New menu");
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("New menu item");
		mnNewMenu_3.add(mntmNewMenuItem_3);
		
		
	}
	

    private void showGraf1() {
      
        // Fuente de Datos
        DefaultPieDataset data = new DefaultPieDataset();
        data.setValue("Obrero", 40);
        data.setValue("Universitario", 45);
        data.setValue("Tecnico", 15);
 
        // Creando el Grafico
        JFreeChart chart = ChartFactory.createPieChart(
         "Cantidad de solicitantes en espera", 
         data, 
         true, 
         true, 
         false);
        panelGrafi1.setLayout(null);
 
        // Crear el Panel del Grafico con ChartPanel
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        chart.setBackgroundPaint( SystemColor.inactiveCaption);
      
        chartPanel.setBounds(0, 0, 507, 249);
        chartPanel.setPreferredSize(new java.awt.Dimension(panelGrafi1.getWidth(), panelGrafi1.getHeight()));
        panelGrafi1.add(chartPanel);
    }
    private void showGraf2() {
        
        
        // Fuente de Datos
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(8, "Mujeres", "Lunes");
        dataset.setValue(7, "Hombres", "Lunes");
        dataset.setValue(9, "Mujeres", "Martes");
        dataset.setValue(4, "Hombres", "Martes");
        dataset.setValue(4, "Mujeres", "Miercoles");
        dataset.setValue(5, "Hombres", "Miercoles");
        dataset.setValue(8, "Mujeres", "Jueves");
        dataset.setValue(9, "Hombres", "Jueves");
        dataset.setValue(7, "Mujeres", "Viernes");
        dataset.setValue(8, "Hombres", "Viernes");
        
        // Creando el Grafico
        JFreeChart chart = ChartFactory.createBarChart3D
                ("Participacion por Genero","Genero", "Dias", 
                dataset, PlotOrientation.VERTICAL, true,true, false);
                chart.setBackgroundPaint(SystemColor.inactiveCaption);
                chart.getTitle().setPaint(Color.black); 
                CategoryPlot p = chart.getCategoryPlot(); 
                p.setRangeGridlinePaint(Color.red); 
        panelGrafi2.setLayout(null);
 
        // Crear el Panel del Grafico con ChartPanel
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
      //  chart.getPlot().setBackgroundPaint( SystemColor.inactiveCaptionBorder );
      
        chartPanel.setBounds(0, 0, 507, 249);
        chartPanel.setPreferredSize(new java.awt.Dimension(panelGrafi2.getWidth(), panelGrafi2.getHeight()));
        panelGrafi2.add(chartPanel);
        
        
        
        

    }
    
    private void showGraf3() {
        
        // Fuente de Datos
        DefaultPieDataset data = new DefaultPieDataset();
        data.setValue("Obrero", 40);
        data.setValue("Universitario", 45);
        data.setValue("Tecnico", 15);
 
        DefaultPieDataset defaultpiedataset = new DefaultPieDataset(); 
        defaultpiedataset.setValue("Mujeres", new Double(41.200000000000003D)); 
        defaultpiedataset.setValue("Hombres", new Double(11D)); 
       /* defaultpiedataset.setValue("Hacking", new Double(19.5D)); 
        defaultpiedataset.setValue("SEO", new Double(30.5D)); 
        defaultpiedataset.setValue("Redes", new Double(2.0D)); */
 
        // Creando el Grafico
        JFreeChart chart = ChartFactory.createPieChart3D("Porcentaje de contratacion por genero", defaultpiedataset, true, true, false); 
        PiePlot3D pieplot3d = (PiePlot3D)chart.getPlot(); 
        pieplot3d.setDepthFactor(0.5); 
        pieplot3d.setStartAngle(290D); 
        pieplot3d.setDirection(Rotation.CLOCKWISE); 
        pieplot3d.setForegroundAlpha(0.5F); 
        panelGrafi3.setLayout(null);
        
        ChartPanel chartPanel = new ChartPanel(chart);
        chart.setBackgroundPaint( SystemColor.inactiveCaption);
        chartPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
        chartPanel.setBounds(0, 0, 507, 249);
        panelGrafi3.add(chartPanel);
    }
    
    
    
   /*
	
	public void calcula() {
        Calendar calendario = new GregorianCalendar();
        hora =calendario.get(Calendar.HOUR_OF_DAY);
        minutos = calendario.get(Calendar.MINUTE);
        segundos = calendario.get(Calendar.SECOND);
    }*/
}
