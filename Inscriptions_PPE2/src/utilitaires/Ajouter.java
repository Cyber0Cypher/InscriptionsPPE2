package utilitaires;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DB.Requete;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ajouter extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5710667649806192170L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNom;
	private JTextField txtPrenom;
	private JTextField txtMail;
	private boolean valider;
	private Requete r = new Requete();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Ajouter dialog = new Ajouter();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Ajouter() {
		setTitle("Ajouter");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNom = new JLabel("Nom");
			lblNom.setBounds(12, 12, 171, 14);
			contentPanel.add(lblNom);
		}
		
		txtNom = new JTextField();
		txtNom.setBounds(12, 37, 171, 20);
		contentPanel.add(txtNom);
		txtNom.setColumns(10);
		
		JLabel lblPrnom = new JLabel("Prénom");
		lblPrnom.setBounds(12, 68, 171, 14);
		contentPanel.add(lblPrnom);
		
		txtPrenom = new JTextField();
		txtPrenom.setColumns(10);
		txtPrenom.setBounds(12, 93, 171, 20);
		contentPanel.add(txtPrenom);
		
		JLabel lblMail = new JLabel("Mail");
		lblMail.setBounds(12, 124, 171, 14);
		contentPanel.add(lblMail);
		
		txtMail = new JTextField();
		txtMail.setColumns(10);
		txtMail.setBounds(12, 149, 171, 20);
		contentPanel.add(txtMail);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Valider");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						r.creerPersonne(txtNom.getText(), txtPrenom.getText(), txtMail.getText());
						setValider(true);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Annuler");
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
	
	public void setValider(boolean valider) {
		this.valider = valider;
	}
	
	public boolean getValider() {
		return valider;
	}
}
