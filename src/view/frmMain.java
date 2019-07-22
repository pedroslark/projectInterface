package view;

import java.sql.*;
import dal.DbConnect;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Canvas;
import java.awt.Button;
import java.awt.Color;
import javax.swing.JDesktopPane;

public class frmMain extends JFrame {

	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	private JPanel contentPane;

	public static void main(String[] args) {
		
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
			System.err.println(ex);
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmMain frame = new frmMain();
					frame.setVisible(true);					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public frmMain() throws ClassNotFoundException {
		setResizable(false);
		setTitle("Project Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnProjects = new JMenu("Projects");
		menuBar.add(mnProjects);
		
		JMenuItem mntmViewProjects = new JMenuItem("View Projects");
		mntmViewProjects.setIcon(new ImageIcon(frmMain.class.getResource("/icons/table_multiple.png")));
		mnProjects.add(mntmViewProjects);
		
		
		JMenu mnScenarios = new JMenu("Scenarios");
		menuBar.add(mnScenarios);
		
		JMenuItem mntmViewScenarios = new JMenuItem("View Scenarios");
		mntmViewScenarios.setIcon(new ImageIcon(frmMain.class.getResource("/icons/table_multiple.png")));
		mnScenarios.add(mntmViewScenarios);
		
		JMenuItem mntmNewScenario = new JMenuItem("New Scenario");
		mntmNewScenario.setIcon(new ImageIcon(frmMain.class.getResource("/icons/add.png")));
		mnScenarios.add(mntmNewScenario);
		
		JMenu mnSettings = new JMenu("Settings");
		menuBar.add(mnSettings);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setIcon(new ImageIcon(frmMain.class.getResource("/icons/cross.png")));
		mnSettings.add(mntmExit);
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent agr0) {
				
				System.exit(0);
			}
		});		
		
		
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.DARK_GRAY);
		desktopPane.setBounds(0, 0, 795, 551);
		contentPane.add(desktopPane);
		setLocationRelativeTo(null);
		con = DbConnect.dbconnect();
		
		
		JMenuItem mntmNewProject = new JMenuItem("New Project");
		mntmNewProject.setIcon(new ImageIcon(frmMain.class.getResource("/icons/add.png")));
		mnProjects.add(mntmNewProject);
		mntmNewProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent agr0) {
				
				frmProjects form = null;
				try {
					form = new frmProjects();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				form.setVisible(true);
				desktopPane.add(form);
			}
		});
	}
}
