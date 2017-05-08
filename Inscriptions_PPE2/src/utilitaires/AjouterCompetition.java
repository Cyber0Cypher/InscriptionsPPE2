package utilitaires;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.ButtonGroup;
import java.awt.Font;

public class AjouterCompetition extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final JPanel contentPanel = new JPanel();
	JButton okButton;
	JTextField txtNom;
	JTextField txtDateCloture;
	JRadioButton rdbtnOui;
	private boolean valider;
	final ButtonGroup buttonGroup = new ButtonGroup();
	JSpinner dateCloture = new JSpinner();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AjouterCompetition ajout = new AjouterCompetition();
			//ajout.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			ajout.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AjouterCompetition() {
		//super();
		setTitle("Nouvelle compétition");
		setSize(240, 275);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(UIManager.getColor("TabbedPane.background"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(12, 12, 202, 14);
		contentPanel.add(lblNom);
		
		txtNom = new JTextField();
		txtNom.setBounds(12, 37, 202, 20);
		contentPanel.add(txtNom);
		txtNom.setColumns(10);
		
		JLabel lblDateCloture = new JLabel("Date de cloture des inscriptions");
		lblDateCloture.setBounds(12, 68, 202, 14);
		contentPanel.add(lblDateCloture);
		
		
		dateCloture.setModel(new SpinnerDateModel(new java.util.Date(1494194400000L), null, null, Calendar.DAY_OF_YEAR));
		dateCloture.setBounds(12, 98, 202, 20);
		contentPanel.add(dateCloture);
		
		JLabel lblAaaammjj = new JLabel("AAAA-MM-JJ");
		lblAaaammjj.setFont(new Font("Tahoma", Font.ITALIC, 10));
		lblAaaammjj.setBounds(12, 82, 202, 14);
		contentPanel.add(lblAaaammjj);
		
		rdbtnOui = new JRadioButton("Oui");
		buttonGroup.add(rdbtnOui);
		rdbtnOui.setBounds(12, 150, 95, 28);
		contentPanel.add(rdbtnOui);
		
		JRadioButton rdbtnNon = new JRadioButton("Non");
		buttonGroup.add(rdbtnNon);
		rdbtnNon.setBounds(119, 150, 95, 28);
		contentPanel.add(rdbtnNon);
		
		JLabel lblEnquipe = new JLabel("En équipe ?");
		lblEnquipe.setBounds(12, 129, 202, 14);
		contentPanel.add(lblEnquipe);
		
		JPanel buttonPane = new JPanel();
		buttonPane.setBackground(UIManager.getColor("TabbedPane.background"));
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		rdbtnOui.doClick();
			
		okButton = new JButton("Valider");
		okButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//						r.creerPersonne(txtNom.getText(), txtPrenom.getText(), txtMail.getText());
//						dispose();
//						super.list.removeAll();
//						for(String l : r.getEquipePersonne(Integer.parseInt(r.getPersonne().get(0).get(comboBox.getSelectedIndex()))).get(0))
//							list.add(l); 
			}
		});
		
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
	
	
		JButton cancelButton = new JButton("Annuler");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
			
		
	}
	
	public void setValider(boolean valider) {
		this.valider = valider;
	}
	
	public boolean getValider() {
		return valider;
	}
}
