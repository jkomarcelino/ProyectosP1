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
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.border.BevelBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;

public class Principal extends JFrame {

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
		setResizable(false);
		setTitle("Bolsa Laboral");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1072, 729);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(10, 641, 1046, 27);
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(10, 78, 1048, 563);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(531, 11, 507, 265);
		panel_2.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBounds(10, 287, 511, 265);
		panel_2.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBounds(531, 287, 507, 265);
		panel_2.add(panel_5);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnPersonal = new JMenu("Personal");
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
}
