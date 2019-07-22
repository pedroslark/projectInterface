package view;

import java.sql.*;
import dal.DbConnect;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.UIManager;

public class frmProjects extends JInternalFrame {
	
	Connection connect;
	PreparedStatement pst;
	ResultSet rs;
	
	private JTextField txtProjectName;
	private JTextField txtProjectDuration;
	private JTextField txtProjectBudget;
	private JTextField txtProjectTimeBudget;
	private JTextField txtProjectCostBudget;


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
					frmProjects frame = new frmProjects();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public frmProjects() throws ClassNotFoundException {
		getContentPane().setBackground(Color.DARK_GRAY);
		setIconifiable(true);
		setClosable(true);
		setResizable(false);
		setTitle("New Project");
		setBounds(100, 100, 390, 551);
		this.setLocation(0, 0);
		getContentPane().setLayout(null);
		connect = DbConnect.dbconnect();
		
		JLabel lblProjectName = new JLabel("Project Name:");
		lblProjectName.setForeground(SystemColor.text);
		lblProjectName.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblProjectName.setBounds(43, 11, 100, 25);
		getContentPane().add(lblProjectName);
		
		txtProjectName = new JTextField();
		txtProjectName.setForeground(Color.DARK_GRAY);
		txtProjectName.setBounds(43, 41, 290, 20);
		getContentPane().add(txtProjectName);
		txtProjectName.setColumns(10);
		
		JLabel lblDuration = new JLabel("Duration:");
		lblDuration.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblDuration.setForeground(SystemColor.text);
		lblDuration.setBounds(43, 72, 119, 25);
		getContentPane().add(lblDuration);
		
		txtProjectDuration = new JTextField();
		txtProjectDuration.setForeground(Color.DARK_GRAY);
		txtProjectDuration.setBounds(43, 102, 290, 20);
		getContentPane().add(txtProjectDuration);
		txtProjectDuration.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Budget:");
		lblNewLabel.setForeground(SystemColor.text);
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel.setBounds(43, 133, 100, 25);
		getContentPane().add(lblNewLabel);
		
		txtProjectBudget = new JTextField();
		txtProjectBudget.setForeground(Color.DARK_GRAY);
		txtProjectBudget.setBounds(43, 163, 290, 20);
		getContentPane().add(txtProjectBudget);
		txtProjectBudget.setColumns(10);
		
		JLabel lblTimeBudget = new JLabel("Time Budget:");
		lblTimeBudget.setForeground(SystemColor.text);
		lblTimeBudget.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblTimeBudget.setBounds(43, 194, 100, 25);
		getContentPane().add(lblTimeBudget);
		
		txtProjectTimeBudget = new JTextField();
		txtProjectTimeBudget.setForeground(Color.DARK_GRAY);
		txtProjectTimeBudget.setBounds(43, 224, 290, 20);
		getContentPane().add(txtProjectTimeBudget);
		txtProjectTimeBudget.setColumns(10);
		
		JLabel lblCostBudget = new JLabel("Cost Budget:");
		lblCostBudget.setForeground(SystemColor.text);
		lblCostBudget.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblCostBudget.setBounds(43, 255, 100, 25);
		getContentPane().add(lblCostBudget);
		
		txtProjectCostBudget = new JTextField();
		txtProjectCostBudget.setForeground(Color.DARK_GRAY);
		txtProjectCostBudget.setBounds(43, 285, 290, 20);
		getContentPane().add(txtProjectCostBudget);
		txtProjectCostBudget.setColumns(10);
		
		JButton btnCreateProject = new JButton("Create");
		btnCreateProject.setBackground(new Color(102, 205, 170));
		btnCreateProject.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnCreateProject.setForeground(Color.WHITE);
		btnCreateProject.setBounds(138, 442, 100, 25);
		getContentPane().add(btnCreateProject);
		
		btnCreateProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent agr0) {
				
				createProject();
			}
		});

	}
	
	public void createProject() {
		
		String sql = "Insert into test(name,duration,budget,timecontingencybudget,costcontingencybudget) values(?,?,?,?,?)";
		
		try {
			pst = connect.prepareStatement(sql);
			pst.setString(1, txtProjectName.getText());
			pst.setDouble(2, Double.parseDouble(txtProjectDuration.getText()));
			pst.setDouble(3, Double.parseDouble(txtProjectBudget.getText()));
			pst.setDouble(4, Double.parseDouble(txtProjectTimeBudget.getText()));
			pst.setDouble(5, Double.parseDouble(txtProjectCostBudget.getText()));
			
			pst.execute();
		}
		catch (SQLException error) {
			JOptionPane.showMessageDialog(null, error);
		}
	}
	
}
