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
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import java.awt.Toolkit;
import java.awt.GridLayout;
import javax.swing.border.EtchedBorder;

public class Principal extends JFrame implements Runnable {
	private JPanel panel;
	JLabel lblHora ;
    int hora, minutos, segundos;
    Calendar calendario;
    Thread h1;

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
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/icon/networking.png")));
		setResizable(false);
		setTitle("Bolsa Laboral");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1072, 729);
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
		panel_2.setBounds(10, 94, 1046, 549);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.controlHighlight);
		panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(529, 11, 507, 249);
		panel_2.add(panel_3);
		
		JLabel lblPorcientoMujer = new JLabel("porciento por genero");
		panel_3.add(lblPorcientoMujer);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.controlHighlight);
		panel_4.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(10, 271, 507, 265);
		panel_2.add(panel_4);
		
		
		
		JLabel label = new JLabel("");
		panel_4.add(label);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(SystemColor.controlHighlight);
		panel_5.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(529, 271, 507, 265);
		panel_2.add(panel_5);
		
		JLabel lblEmpleadosEnEspera = new JLabel("empleados en espera");
		panel_5.add(lblEmpleadosEnEspera);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(SystemColor.controlHighlight);
		panel_1.setBounds(10, 11, 507, 249);
		panel_2.add(panel_1);
		
		JLabel label_1 = new JLabel("");
		panel_1.add(label_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/icon/JOBIFY.png")));
		lblNewLabel.setBounds(413, 11, 237, 76);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Principal.class.getResource("/icon/bolsalaboral.png")));
		lblNewLabel_1.setBounds(434, 51, 296, 26);
		panel.add(lblNewLabel_1);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(SystemColor.inactiveCaptionBorder);
		panel_6.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panel_6.setBounds(984, 71, 72, 20);
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
		h1 = new Thread(this);
	    h1.start();
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.PINK);
		menuBar.setBorderPainted(false);
		menuBar.setBackground(SystemColor.activeCaption);
		
		setJMenuBar(menuBar);
		
		JMenu mnPersonal = new JMenu("Personal");
		mnPersonal.setBackground(SystemColor.activeCaption);
		mnPersonal.setIcon(new ImageIcon(Principal.class.getResource("/icon/empresario.png")));
		menuBar.add(mnPersonal);
		
		JMenuItem mntmRegistrar = new JMenuItem("Registrar Persona");
		mntmRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegPersona regper = new RegPersona();
				regper.setLocationRelativeTo(null);
				regper.setVisible(true);
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
		mnEmpresa.setIcon(new ImageIcon(Principal.class.getResource("/icon/edificio-de-oficinas.png")));
		menuBar.add(mnEmpresa);
		
		JMenuItem mntmRegEmp = new JMenuItem("Registrar Empresa");
		mntmRegEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegEmpresa regemp = new RegEmpresa();
				regemp.setLocationRelativeTo(null);
				regemp.setVisible(true);
				
			}
		});
		mnEmpresa.add(mntmRegEmp);
		
		JMenuItem mntmSoliEmp = new JMenuItem("Generar Solicitud");
		mntmSoliEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				SolicitudEmpresa solemp = new SolicitudEmpresa();
				solemp.setLocationRelativeTo(null);
				solemp.setVisible(true);	
}
		});
		mnEmpresa.add(mntmSoliEmp);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("Lista");
		mnEmpresa.add(mntmNewMenuItem_8);
		
		JMenu mnReporte = new JMenu("Reportes");
		mnReporte.setBackground(SystemColor.activeCaption);
		mnReporte.setIcon(new ImageIcon(Principal.class.getResource("/icon/impresora.png")));
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
