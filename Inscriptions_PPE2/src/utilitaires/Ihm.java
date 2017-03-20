package utilitaires;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Date;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.UtilDateModel;

import DB.Requete;
import inscriptions.Equipe;
import inscriptions.Inscriptions;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.Label;
import javax.swing.JInternalFrame;
import javax.swing.AbstractAction;
import javax.swing.Action;

@SuppressWarnings("unused")
public class Ihm {

	private JFrame frame;
	private JTextField txtNomPersonne;
	private JTextField txtPrenomPersonne;
	private JTextField txtMailPersonne;
	private JTextField txtAcronymeEquipe;
	private JTextField txtNomEquipe;
	private JTextField txtMailEquipe;
	private JTextField txtNomEpreuve;
	private JTextField txtDateCloture;
	private JTextField dateCloture;
	private ButtonGroup bg = new ButtonGroup();
	private JRadioButton rdbtnOui = new JRadioButton("Oui");
	private JRadioButton rdbtnNo = new JRadioButton("Non");
	
	private Requete r;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private boolean refresh = false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ihm window = new Ihm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ihm() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Inscriptions");
		r = new Requete();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBackground(Color.DARK_GRAY);
		frame.setSize(626, 472);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2 - frame.getWidth()/2, dim.height/2 - frame.getHeight()/2);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
//		frame.addWindowListener(new WindowListener() {
//			@Override
//			public void windowOpened(WindowEvent e) {		
//			}
//			@Override
//			public void windowIconified(WindowEvent e) {
//			}
//			@Override
//			public void windowDeiconified(WindowEvent e) {
//			}
//			@Override
//			public void windowDeactivated(WindowEvent e) {
//			}
//			@Override
//			public void windowClosing(WindowEvent e) {
//				int confirmed = JOptionPane.showConfirmDialog(null, 
//				        "Etes vous sûr de vouloir quitter ?", "Message de fermeture",
//				        JOptionPane.YES_NO_OPTION);
//				    if (confirmed == JOptionPane.YES_OPTION) {
//				    	System.exit(0);
//				    }
//			}
//			@Override
//			public void windowClosed(WindowEvent e) {
//			}
//			@Override
//			public void windowActivated(WindowEvent e) {
//			}
//		});
		bg.add(rdbtnOui);
		bg.add(rdbtnNo);
		
		JLabel lblAccueil = new JLabel("Inscriptions\r\n");
		lblAccueil.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAccueil.setBounds(253, 11, 82, 35);
		frame.getContentPane().add(lblAccueil);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(10, 45, 590, 377);
		frame.getContentPane().add(tabbedPane);
		
		JLayeredPane panelPersonne = new JLayeredPane();
		tabbedPane.addTab("Personnes", null, panelPersonne, null);
		
		JComboBox<Object> listePersonne = new JComboBox<Object>();
		int i = 0;
		for(String l : r.getPersonne().get(1)){
			listePersonne.addItem(l+" "+r.getPersonne().get(2).get(i));
			i++;
		}
		listePersonne.setBounds(192, 35, 190, 20);
		panelPersonne.add(listePersonne);
		
		List list = new List();
		list.setBounds(410, 35, 165, 295);
		panelPersonne.add(list);
		
		listePersonne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!refresh){
					list.removeAll();
					for(String l : r.getEquipePersonne(Integer.parseInt(r.getPersonne().get(0).get(listePersonne.getSelectedIndex()))).get(0))
						list.add(l);
					txtNomPersonne.setText(r.getPersonne().get(1).get(listePersonne.getSelectedIndex()));
					txtPrenomPersonne.setText(r.getPersonne().get(2).get(listePersonne.getSelectedIndex()));
					txtMailPersonne.setText(r.getPersonne().get(3).get(listePersonne.getSelectedIndex()));
				}
			}
		});
		
		
		
		JLabel lblNewLabel = new JLabel("Nom\r\n");
		lblNewLabel.setBounds(10, 14, 46, 14);
		panelPersonne.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Pr\u00E9nom");
		lblNewLabel_1.setBounds(10, 66, 46, 14);
		panelPersonne.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mail");
		lblNewLabel_2.setBounds(10, 126, 46, 14);
		panelPersonne.add(lblNewLabel_2);
		
		txtNomPersonne = new JTextField();
		txtNomPersonne.setBounds(10, 35, 152, 20);
		panelPersonne.add(txtNomPersonne);
		txtNomPersonne.setColumns(10);
		
		txtPrenomPersonne = new JTextField();
		txtPrenomPersonne.setBounds(10, 91, 152, 20);
		panelPersonne.add(txtPrenomPersonne);
		txtPrenomPersonne.setColumns(10);
		
		txtMailPersonne = new JTextField();
		txtMailPersonne.setBounds(10, 151, 152, 20);
		panelPersonne.add(txtMailPersonne);
		txtMailPersonne.setColumns(10);
		
		JButton btnAjouterUnePersonne = new JButton("Ajouter une personne");
		buttonGroup.add(btnAjouterUnePersonne);
		btnAjouterUnePersonne.setBounds(192, 133, 190, 38);
		panelPersonne.add(btnAjouterUnePersonne);
		btnAjouterUnePersonne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				JDialog ajout = new JDialog();
//				
//				ajout.setTitle("Ajouter");
//				ajout.setBounds(dim.width/2 - frame.getWidth()/2, dim.height/2 - frame.getHeight()/2, 450, 300);
//				
//				JLabel lblNewLabel = new JLabel("Nom\r\n");
//				lblNewLabel.setBounds(10, 14, 46, 14);
//				ajout.getContentPane().add(lblNewLabel);
//				
//				JLabel lblNewLabel_1 = new JLabel("Pr\u00E9nom");
//				lblNewLabel_1.setBounds(10, 66, 46, 14);
//				ajout.getContentPane().add(lblNewLabel_1);
//				
//				JLabel lblNewLabel_2 = new JLabel("Mail");
//				lblNewLabel_2.setBounds(10, 126, 46, 14);
//				ajout.getContentPane().add(lblNewLabel_2);
//				
//				txtNomPersonne = new JTextField();
//				txtNomPersonne.setBounds(10, 35, 152, 20);
//				ajout.getContentPane().add(txtNomPersonne);
//				txtNomPersonne.setColumns(10);
//				
//				txtPrenomPersonne = new JTextField();
//				txtPrenomPersonne.setBounds(10, 91, 152, 20);
//				ajout.getContentPane().add(txtPrenomPersonne);
//				txtPrenomPersonne.setColumns(10);
//				
//				txtMailPersonne = new JTextField();
//				txtMailPersonne.setBounds(10, 151, 152, 20);
//				ajout.getContentPane().add(txtMailPersonne);
//				txtMailPersonne.setColumns(10);
//				
//				ajout.setVisible(true);
				
				try {
					Ajouter ajout = new Ajouter();
					ajout.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					ajout.setVisible(true);
					ajout.okButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							r.creerPersonne(ajout.txtNom.getText(), ajout.txtPrenom.getText(), ajout.txtMail.getText());
							ajout.dispose();
							refresh = true;
							listePersonne.removeAllItems();
							int i = 0;
							for(String l : r.getPersonne().get(1)) {
								listePersonne.addItem(l+" "+r.getPersonne().get(2).get(i));
								i++;
							}
							refresh = false;
						}
					});
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		
		JButton btnModifierUnePersonne = new JButton("Modifier une personne\r\n");
		btnModifierUnePersonne.setBounds(192, 183, 190, 38);
		panelPersonne.add(btnModifierUnePersonne);
		btnModifierUnePersonne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//txtNomPersonne.setText((String) comboBox.);
			}
		});
		
		JButton btnSupprimerUnePersonne = new JButton("Supprimer une personne");
		btnSupprimerUnePersonne.setBounds(192, 233, 190, 38);
		panelPersonne.add(btnSupprimerUnePersonne);
		btnSupprimerUnePersonne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				r.supprimerPersonne(Integer.parseInt(r.getPersonne().get(0).get(listePersonne.getSelectedIndex())));
				listePersonne.removeItem(listePersonne.getSelectedItem());
			}
		});
		
		JLabel lblNewLabel_6 = new JLabel("S\u00E9l\u00E9ctionner une personne");
		lblNewLabel_6.setBounds(192, 10, 190, 14);
		panelPersonne.add(lblNewLabel_6);
		
		JLabel lblEquipesDeLa = new JLabel("Equipe(s) de la personne");
		lblEquipesDeLa.setBounds(410, 14, 161, 14);
		panelPersonne.add(lblEquipesDeLa);
		
		JLayeredPane panelEquipe = new JLayeredPane();
		tabbedPane.addTab("Equipes", null, panelEquipe, null);
		
		JButton btnAjouterUneEquipe = new JButton("Ajouter une \u00E9quipe\r\n");
		btnAjouterUneEquipe.setBounds(10, 191, 155, 39);
		panelEquipe.add(btnAjouterUneEquipe);
		
		JButton btnModifierUneEquipe = new JButton("Modifier une \u00E9quipe");
		btnModifierUneEquipe.setBounds(10, 241, 155, 39);
		panelEquipe.add(btnModifierUneEquipe);
		
		JButton btnSupprimerUneEquipe = new JButton("Supprimer une \u00E9quipe");
		btnSupprimerUneEquipe.setBounds(10, 291, 155, 40);
		panelEquipe.add(btnSupprimerUneEquipe);
		
		JLabel lblNewLabel_3 = new JLabel("Acronyme");
		lblNewLabel_3.setBounds(10, 11, 155, 20);
		panelEquipe.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Nom de l'\u00E9quipe\r\n");
		lblNewLabel_4.setBounds(10, 67, 152, 20);
		panelEquipe.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Mail de l'\u00E9quipe\r\n");
		lblNewLabel_5.setBounds(10, 123, 152, 20);
		panelEquipe.add(lblNewLabel_5);
		
		txtAcronymeEquipe = new JTextField();
		txtAcronymeEquipe.setBounds(10, 36, 152, 20);
		panelEquipe.add(txtAcronymeEquipe);
		txtAcronymeEquipe.setColumns(10);
		
		txtNomEquipe = new JTextField();
		txtNomEquipe.setBounds(10, 92, 152, 20);
		panelEquipe.add(txtNomEquipe);
		txtNomEquipe.setColumns(10);
		
		txtMailEquipe = new JTextField();
		txtMailEquipe.setBounds(10, 148, 152, 20);
		panelEquipe.add(txtMailEquipe);
		txtMailEquipe.setColumns(10);
		
		JComboBox<Object> listeEquipe = new JComboBox<Object>();
		for(String l : r.getEquipe().get(2))
			listeEquipe.addItem(l);
		listeEquipe.setBounds(198, 36, 176, 20);
		panelEquipe.add(listeEquipe);
		
		List list_1 = new List();
		list_1.setBounds(399, 36, 176, 303);
		panelEquipe.add(list_1);
		
		listeEquipe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				list_1.removeAll();
				for(int i=0; i<r.getPersonneEquipe(Integer.parseInt(r.getEquipe().get(0).get(listeEquipe.getSelectedIndex()))).get(0).size();i++) {
					list_1.add(r.getPersonneEquipe(Integer.parseInt(r.getEquipe().get(0).get(listeEquipe.getSelectedIndex()))).get(0).get(i) +" "+ r.getPersonneEquipe(Integer.parseInt(r.getEquipe().get(0).get(listeEquipe.getSelectedIndex()))).get(1).get(i));
				}
				txtAcronymeEquipe.setText(r.getEquipe().get(1).get(listeEquipe.getSelectedIndex()));
				txtNomEquipe.setText(r.getEquipe().get(2).get(listeEquipe.getSelectedIndex()));
				txtMailEquipe.setText(r.getEquipe().get(3).get(listeEquipe.getSelectedIndex()));
			}
		});
		
		
		JLabel lblSlctionnerUnequipe = new JLabel("S\u00E9l\u00E9ctionner une \u00E9quipe");
		lblSlctionnerUnequipe.setBounds(198, 11, 176, 14);
		panelEquipe.add(lblSlctionnerUnequipe);
		

		
		JLabel lblPersonnesDeLequipe = new JLabel("Personne(s) de l'equipe");
		lblPersonnesDeLequipe.setBounds(399, 11, 176, 14);
		panelEquipe.add(lblPersonnesDeLequipe);
		
		JLayeredPane panelCompetition = new JLayeredPane();
		tabbedPane.addTab("Competitions", null, panelCompetition, null);
		
		dateCloture = new JTextField("YYYY-MM-DD");
		dateCloture.setBounds(10,91,152,23);
		panelCompetition.add(dateCloture);
		dateCloture.setColumns(10);
		
		JComboBox<Object> listeCompetition = new JComboBox<Object>();
		for(String l : r.getCompetition().get(1))
			listeCompetition.addItem(l);
		listeCompetition.setBounds(190, 35, 178, 20);
		panelCompetition.add(listeCompetition);
		
		List list_2 = new List();
		list_2.setBounds(397, 35, 178, 304);
		panelCompetition.add(list_2);
		
		listeCompetition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				list_2.removeAll();
				for(int i=0; i<r.candidatsInscritsCompetition(Integer.parseInt(r.getCompetition().get(0).get(listeCompetition.getSelectedIndex()))).get(0).size();i++) {
					list_2.add(r.candidatsInscritsCompetition(Integer.parseInt(r.getCompetition().get(0).get(listeCompetition.getSelectedIndex()))).get(0).get(i) +" "+ r.candidatsInscritsCompetition(Integer.parseInt(r.getCompetition().get(0).get(listeCompetition.getSelectedIndex()))).get(1).get(i));
				}
				txtNomEpreuve.setText(r.getCompetition().get(1).get(listeCompetition.getSelectedIndex()));
				dateCloture.setText(r.getCompetition().get(2).get(listeCompetition.getSelectedIndex()));
				if(r.getCompetition().get(3).get(listeCompetition.getSelectedIndex()).equals("1"))
					rdbtnOui.setSelected(true);
				if(r.getCompetition().get(3).get(listeCompetition.getSelectedIndex()).equals("0"))
					rdbtnNo.setSelected(true);
			}
		});
		
		JLabel lblNewLabel_7 = new JLabel("S\u00E9l\u00E9ctionner une comp\u00E9tition");
		lblNewLabel_7.setBounds(190, 14, 178, 14);
		panelCompetition.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Nom Epreuve");
		lblNewLabel_8.setBounds(10, 14, 88, 14);
		panelCompetition.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Date Cloture (YYYY-MM-DD)");
		lblNewLabel_9.setBounds(10, 66, 160, 14);
		panelCompetition.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("En Equipe");
		lblNewLabel_10.setBounds(10, 126, 88, 14);
		panelCompetition.add(lblNewLabel_10);
		
		txtNomEpreuve = new JTextField();
		txtNomEpreuve.setBounds(10, 35, 152, 20);
		panelCompetition.add(txtNomEpreuve);
		txtNomEpreuve.setColumns(10);
		
		rdbtnOui.setBounds(10, 154, 70, 23);
		panelCompetition.add(rdbtnOui);
		
		rdbtnNo.setBounds(95, 154, 70, 23);
		panelCompetition.add(rdbtnNo);
		
		JButton btnNewButton = new JButton("Ajouter");
		btnNewButton.setBounds(10, 203, 152, 33);
		panelCompetition.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modifier");
		btnNewButton_1.setBounds(10, 247, 152, 33);
		panelCompetition.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Supprimer");
		btnNewButton_2.setBounds(10, 291, 152, 33);
		panelCompetition.add(btnNewButton_2);
		
		JLabel lblCandidatsDeLa = new JLabel("Candidat(s) de la compétition");
		lblCandidatsDeLa.setBounds(397, 15, 178, 14);
		panelCompetition.add(lblCandidatsDeLa);
	}
}
