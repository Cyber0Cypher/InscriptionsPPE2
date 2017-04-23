package utilitaires;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AjouterEquipe extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final JPanel contentPanel = new JPanel();
	JButton okButton;
	JTextField txtNom;
	private boolean valider;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			AjouterEquipe ajout = new AjouterEquipe();
			//ajout.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			ajout.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public AjouterEquipe() {
		setTitle("Nouvelle équipe");
		setSize(240, 275);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(UIManager.getColor("TabbedPane.background"));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(12, 12, 199, 14);
		contentPanel.add(lblNom);
		
		txtNom = new JTextField();
		txtNom.setBounds(12, 37, 199, 20);
		contentPanel.add(txtNom);
		txtNom.setColumns(10);
		

		JPanel buttonPane = new JPanel();
		buttonPane.setBackground(UIManager.getColor("TabbedPane.background"));
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
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
