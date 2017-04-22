package utilitaires;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Date;
import java.time.LocalDate;
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

import DB.Requete;
import inscriptions.Candidat;
import inscriptions.Competition;
import inscriptions.Equipe;
import inscriptions.Inscriptions;
import inscriptions.Personne;

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
	private JTextField txtNomEquipe;
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
		Inscriptions insc = Inscriptions.getInscriptions();
//		ArrayList<ArrayList<String>> lesCompets = r.getCompetition();
//		int i = 0;
//		for(String compet : r.getCompetition().get(0)) {
//			insc.createCompetition(lesCompets.get(1).get(i), LocalDate.parse(lesCompets.get(2).get(i)), Boolean.parseBoolean(lesCompets.get(3).get(i)));
//			i++;
//		}
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setBackground(Color.DARK_GRAY);
		frame.setSize(879, 500);
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
		tabbedPane.setBounds(0, 45, 863, 416);
		frame.getContentPane().add(tabbedPane);
		
		JLayeredPane panelPersonne = new JLayeredPane();
		tabbedPane.addTab("Personnes", null, panelPersonne, null);
		
		JComboBox<Object> listePersonne = new JComboBox<Object>();
		for(Personne personne : insc.getPersonnes()){
			listePersonne.addItem(personne.getPrenom()+" "+personne.getNom());
		}
		listePersonne.setBounds(227, 35, 190, 20);
		panelPersonne.add(listePersonne);
		
		List listeEquipePersonne = new List();
		listeEquipePersonne.setBounds(445, 35, 190, 160);
		panelPersonne.add(listeEquipePersonne);
		
		List listCompetitionPersonne = new List();
		listCompetitionPersonne.setBounds(445, 218, 190, 160);
		panelPersonne.add(listCompetitionPersonne);
		
		listePersonne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!refresh){
					listeEquipePersonne.removeAll();
					listCompetitionPersonne.removeAll();
					int i = 0;
					for(Personne p : insc.getPersonnes()){
						if (i == listePersonne.getSelectedIndex()){
							for(Equipe e : p.getEquipes()){
								listeEquipePersonne.add(e.getNom());
								for(Competition comp : e.getCompetitions()){
									listCompetitionPersonne.add(comp.getNom());
								}
							}
							for(Competition comp : p.getCompetitions()){
								listCompetitionPersonne.add(comp.getNom());
							}
							txtNomPersonne.setText(p.getNom());
							txtPrenomPersonne.setText(p.getPrenom());
							txtMailPersonne.setText(p.getMail());
						}
						i++;
					}
				}
			}
		});
		
		
		
		JLabel lblNewLabel = new JLabel("Nom\r\n");
		lblNewLabel.setBounds(10, 14, 189, 14);
		panelPersonne.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Pr\u00E9nom");
		lblNewLabel_1.setBounds(10, 66, 189, 14);
		panelPersonne.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mail");
		lblNewLabel_2.setBounds(10, 124, 189, 14);
		panelPersonne.add(lblNewLabel_2);
		
		txtNomPersonne = new JTextField();
		txtNomPersonne.setBounds(10, 35, 187, 20);
		panelPersonne.add(txtNomPersonne);
		txtNomPersonne.setColumns(10);
		
		txtPrenomPersonne = new JTextField();
		txtPrenomPersonne.setBounds(10, 91, 189, 20);
		panelPersonne.add(txtPrenomPersonne);
		txtPrenomPersonne.setColumns(10);
		
		txtMailPersonne = new JTextField();
		txtMailPersonne.setBounds(10, 151, 189, 20);
		panelPersonne.add(txtMailPersonne);
		txtMailPersonne.setColumns(10);
		
		JButton btnAjouterUnePersonne = new JButton("Ajouter");
		buttonGroup.add(btnAjouterUnePersonne);
		btnAjouterUnePersonne.setBounds(10, 238, 190, 40);
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
		
		JButton btnModifierUnePersonne = new JButton("Modifier");
		btnModifierUnePersonne.setBounds(10, 290, 190, 40);
		panelPersonne.add(btnModifierUnePersonne);
		btnModifierUnePersonne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//txtNomPersonne.setText((String) comboBox.);
			}
		});
		
		JButton btnSupprimerUnePersonne = new JButton("Supprimer");
		btnSupprimerUnePersonne.setBounds(10, 340, 190, 40);
		panelPersonne.add(btnSupprimerUnePersonne);
		btnSupprimerUnePersonne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				r.supprimerPersonne(Integer.parseInt(r.getPersonne().get(0).get(listePersonne.getSelectedIndex())));
				listePersonne.removeItem(listePersonne.getSelectedItem());
			}
		});
		
		JLabel lblNewLabel_6 = new JLabel("S\u00E9l\u00E9ctionner une personne");
		lblNewLabel_6.setBounds(227, 14, 190, 14);
		panelPersonne.add(lblNewLabel_6);
		
		JLabel lblEquipesDeLa = new JLabel("Equipe(s) de la personne");
		lblEquipesDeLa.setBounds(445, 14, 190, 14);
		panelPersonne.add(lblEquipesDeLa);
		
		JLabel lblComptitionsDeLa = new JLabel("Compétition(s) de la personne");
		lblComptitionsDeLa.setBounds(445, 198, 190, 14);
		panelPersonne.add(lblComptitionsDeLa);
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.setBounds(656, 33, 190, 20);
		panelPersonne.add(comboBox);
		
		JComboBox<Object> comboBox_1 = new JComboBox<Object>();
		comboBox_1.setBounds(656, 104, 190, 20);
		panelPersonne.add(comboBox_1);
		
		JComboBox<Object> comboBox_2 = new JComboBox<Object>();
		comboBox_2.setBounds(656, 218, 190, 20);
		panelPersonne.add(comboBox_2);
		
		JComboBox<Object> comboBox_3 = new JComboBox<Object>();
		comboBox_3.setBounds(656, 284, 190, 20);
		panelPersonne.add(comboBox_3);
		
		JButton button = new JButton("Ajouter");
		button.setBounds(656, 52, 96, 20);
		panelPersonne.add(button);
		
		JButton button_1 = new JButton("Ajouter");
		button_1.setBounds(656, 239, 96, 20);
		panelPersonne.add(button_1);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(656, 124, 96, 20);
		panelPersonne.add(btnSupprimer);
		
		JButton btnSupprimer_1 = new JButton("Supprimer");
		btnSupprimer_1.setBounds(656, 305, 96, 20);
		panelPersonne.add(btnSupprimer_1);
		
		JLabel lblAjouterUne = new JLabel("Ajouter à une équipe");
		lblAjouterUne.setBounds(656, 13, 190, 14);
		panelPersonne.add(lblAjouterUne);
		
		JLabel lblSupprimerDunequipe = new JLabel("Supprimer d'une équipe");
		lblSupprimerDunequipe.setBounds(656, 84, 190, 14);
		panelPersonne.add(lblSupprimerDunequipe);
		
		JLabel lblAjouterUne_1 = new JLabel("Ajouter à une compétition");
		lblAjouterUne_1.setBounds(656, 197, 190, 14);
		panelPersonne.add(lblAjouterUne_1);
		
		JLabel lblSupprimerDuneComptition = new JLabel("Supprimer d'une compétition");
		lblSupprimerDuneComptition.setBounds(656, 264, 190, 14);
		panelPersonne.add(lblSupprimerDuneComptition);
		
		JLayeredPane panelEquipe = new JLayeredPane();
		tabbedPane.addTab("Equipes", null, panelEquipe, null);
		
		JButton btnAjouterUneEquipe = new JButton("Ajouter");
		btnAjouterUneEquipe.setBounds(10, 236, 190, 40);
		panelEquipe.add(btnAjouterUneEquipe);
		
		JButton btnModifierUneEquipe = new JButton("Modifier");
		btnModifierUneEquipe.setBounds(10, 286, 190, 40);
		panelEquipe.add(btnModifierUneEquipe);
		
		JButton btnSupprimerUneEquipe = new JButton("Supprimer");
		btnSupprimerUneEquipe.setBounds(10, 336, 190, 40);
		panelEquipe.add(btnSupprimerUneEquipe);
		
		JLabel lblNomEquipe = new JLabel("Nom de l'\u00E9quipe\r\n");
		lblNomEquipe.setBounds(10, 14, 190, 20);
		panelEquipe.add(lblNomEquipe);
		
		txtNomEquipe = new JTextField();
		txtNomEquipe.setBounds(10, 39, 190, 20);
		panelEquipe.add(txtNomEquipe);
		txtNomEquipe.setColumns(10);
		
		JComboBox<Object> listeEquipe = new JComboBox<Object>();
		for(Equipe equipe : insc.getEquipes())
			listeEquipe.addItem(equipe.getNom());
		listeEquipe.setBounds(232, 36, 190, 20);
		panelEquipe.add(listeEquipe);
		
		List listePersonneEquipe = new List();
		listePersonneEquipe.setBounds(444, 30, 190, 160);
		panelEquipe.add(listePersonneEquipe);
		
		listeEquipe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!refresh){
					listePersonneEquipe.removeAll();
					int i = 0;
					for(Equipe e : insc.getEquipes()){
						if (i == listeEquipe.getSelectedIndex()){
							for(Personne p : e.getMembres()){
								listePersonneEquipe.add(p.getPrenom()+" "+p.getNom());
							}
							txtNomEquipe.setText(e.getNom());
						}
						i++;
					}
				}
			}
		});
		
		
		JLabel lblSlctionnerUnequipe = new JLabel("S\u00E9l\u00E9ctionner une \u00E9quipe");
		lblSlctionnerUnequipe.setBounds(232, 14, 190, 14);
		panelEquipe.add(lblSlctionnerUnequipe);	

		
		JLabel lblPersonnesDeLequipe = new JLabel("Personne(s) de l'equipe");
		lblPersonnesDeLequipe.setBounds(444, 14, 190, 14);
		panelEquipe.add(lblPersonnesDeLequipe);
		
		List list = new List();
		list.setBounds(444, 218, 190, 160);
		panelEquipe.add(list);
		
		JLabel label = new JLabel("Personne(s) de l'equipe");
		label.setBounds(444, 196, 190, 14);
		panelEquipe.add(label);
		
		JLayeredPane panelCompetition = new JLayeredPane();
		tabbedPane.addTab("Competitions", null, panelCompetition, null);
		
		dateCloture = new JTextField("YYYY-MM-DD");
		dateCloture.setBounds(10,91,190,23);
		panelCompetition.add(dateCloture);
		dateCloture.setColumns(10);
		
		JComboBox<Object> listeCompetition = new JComboBox<Object>();
		for(Competition c : insc.getCompetitions())
			listeCompetition.addItem(c.getNom());
		listeCompetition.setBounds(319, 35, 190, 20);
		panelCompetition.add(listeCompetition);
		
		List listeCandidatCompetition = new List();
		listeCandidatCompetition.setBounds(658, 35, 190, 343);
		panelCompetition.add(listeCandidatCompetition);
		
		listeCompetition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!refresh){
					listeCandidatCompetition.removeAll();
					int i = 0;
					for(Competition c : insc.getCompetitions()){
						if (i == listeCompetition.getSelectedIndex()){
							for(Candidat candi : c.getCandidats()){
								listeCandidatCompetition.add(candi.getNom());
							}
							txtNomEpreuve.setText(c.getNom());
							dateCloture.setText(c.getDateCloture().toString());
							if(c.estEnEquipe())
								rdbtnOui.setSelected(true);
							if(!c.estEnEquipe())
								rdbtnNo.setSelected(true);
						}
						i++;
					}
				}
//				listeCandidatCompetition.removeAll();
//				for(int i=0; i<r.candidatsInscritsCompetition(Integer.parseInt(r.getCompetition().get(0).get(listeCompetition.getSelectedIndex()))).get(0).size();i++) {
//					listeCandidatCompetition.add(r.candidatsInscritsCompetition(Integer.parseInt(r.getCompetition().get(0).get(listeCompetition.getSelectedIndex()))).get(0).get(i) +" "+ r.candidatsInscritsCompetition(Integer.parseInt(r.getCompetition().get(0).get(listeCompetition.getSelectedIndex()))).get(1).get(i));
//				}
//				txtNomEpreuve.setText(r.getCompetition().get(1).get(listeCompetition.getSelectedIndex()));
//				dateCloture.setText(r.getCompetition().get(2).get(listeCompetition.getSelectedIndex()));
//				if(r.getCompetition().get(3).get(listeCompetition.getSelectedIndex()).equals("1"))
//					rdbtnOui.setSelected(true);
//				if(r.getCompetition().get(3).get(listeCompetition.getSelectedIndex()).equals("0"))
//					rdbtnNo.setSelected(true);
			}
		});
		
		JLabel lblListeCompetition = new JLabel("S\u00E9l\u00E9ctionner une comp\u00E9tition");
		lblListeCompetition.setBounds(319, 14, 190, 14);
		panelCompetition.add(lblListeCompetition);
		
		JLabel lblNomEpreuve = new JLabel("Nom Epreuve");
		lblNomEpreuve.setBounds(10, 14, 190, 14);
		panelCompetition.add(lblNomEpreuve);
		
		JLabel lblDateCloture = new JLabel("Date Cloture (YYYY-MM-DD)");
		lblDateCloture.setBounds(10, 66, 190, 14);
		panelCompetition.add(lblDateCloture);
		
		JLabel lblEnEquipe = new JLabel("En Equipe");
		lblEnEquipe.setBounds(10, 126, 190, 14);
		panelCompetition.add(lblEnEquipe);
		
		txtNomEpreuve = new JTextField();
		txtNomEpreuve.setBounds(10, 35, 190, 20);
		panelCompetition.add(txtNomEpreuve);
		txtNomEpreuve.setColumns(10);
		
		rdbtnOui.setBounds(10, 148, 85, 23);
		panelCompetition.add(rdbtnOui);
		
		rdbtnNo.setBounds(115, 148, 85, 23);
		panelCompetition.add(rdbtnNo);
		
		JButton btnAjouterCompetition = new JButton("Ajouter");
		btnAjouterCompetition.setBounds(10, 234, 190, 40);
		panelCompetition.add(btnAjouterCompetition);
		
		JButton btnModifierCompetition = new JButton("Modifier");
		btnModifierCompetition.setBounds(10, 286, 190, 40);
		panelCompetition.add(btnModifierCompetition);
		
		JButton btnSupprimerCompetition = new JButton("Supprimer");
		btnSupprimerCompetition.setBounds(10, 338, 190, 40);
		panelCompetition.add(btnSupprimerCompetition);
		
		JLabel lblCandidatCompetition = new JLabel("Candidat(s) de la compétition");
		lblCandidatCompetition.setBounds(658, 14, 188, 14);
		panelCompetition.add(lblCandidatCompetition);
	}
}
