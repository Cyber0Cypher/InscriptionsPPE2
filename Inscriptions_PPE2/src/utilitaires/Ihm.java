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
import java.awt.Container;
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
		Inscriptions insc = Inscriptions.getInscriptions();
		
		frame = new JFrame("Inscriptions");
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
		
		JLabel lblAccueil = new JLabel("Inscriptions");
		lblAccueil.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblAccueil.setBounds(385, 12, 117, 35);
		frame.getContentPane().add(lblAccueil);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(0, 45, 863, 416);
		frame.getContentPane().add(tabbedPane);
		
		//////////////
		// PERSONNE //
		//////////////
		
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
		
		List listeCompetitionPersonne = new List();
		listeCompetitionPersonne.setBounds(445, 218, 190, 160);
		panelPersonne.add(listeCompetitionPersonne);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setBounds(10, 14, 189, 14);
		panelPersonne.add(lblNom);
		
		JLabel lblPrenom = new JLabel("Prénom");
		lblPrenom.setBounds(10, 66, 189, 14);
		panelPersonne.add(lblPrenom);
		
		JLabel lblMail = new JLabel("Mail");
		lblMail.setBounds(10, 124, 189, 14);
		panelPersonne.add(lblMail);
		
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
				try {
					AjouterPersonne ajout = new AjouterPersonne();
					ajout.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					ajout.setVisible(true);
					ajout.okButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							insc.createPersonne(insc.getAICandidats(), ajout.txtNom.getText(), ajout.txtPrenom.getText(), ajout.txtMail.getText());
							ajout.dispose();
							refresh = true;
							listePersonne.removeAllItems();
							for(Personne p : insc.getPersonnes()) {
								listePersonne.addItem(p.getPrenom()+" "+p.getNom());
							}
							refresh = false;
						}
					});
				} 
				catch (Exception e) {
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
				int i = 0;
				for(Personne p : insc.getPersonnes()){
					if(i == listePersonne.getSelectedIndex()){
						p.delete();
					}
					i++;
				}
				listePersonne.removeItem(listePersonne.getSelectedItem());
			}
		});
		
		JLabel lblSelectPersonne = new JLabel("Sélectionner une personne");
		lblSelectPersonne.setBounds(227, 14, 190, 14);
		panelPersonne.add(lblSelectPersonne);
		
		JLabel lblEquipesDeLa = new JLabel("Equipe(s) de la personne");
		lblEquipesDeLa.setBounds(445, 14, 190, 14);
		panelPersonne.add(lblEquipesDeLa);
		
		JLabel lblComptitionsDeLa = new JLabel("Compétition(s) de la personne");
		lblComptitionsDeLa.setBounds(445, 198, 190, 14);
		panelPersonne.add(lblComptitionsDeLa);
		
		JComboBox<Object> listeEquipeAjouter = new JComboBox<Object>();
		listeEquipeAjouter.setBounds(656, 33, 190, 20);
		panelPersonne.add(listeEquipeAjouter);
		
		listeEquipeAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JComboBox<Object> listeEquipeSupprimer = new JComboBox<Object>();
		listeEquipeSupprimer.setBounds(656, 104, 190, 20);
		panelPersonne.add(listeEquipeSupprimer);
		
		JComboBox<Object> listeCompetitionAjouter = new JComboBox<Object>();
		listeCompetitionAjouter.setBounds(656, 218, 190, 20);
		panelPersonne.add(listeCompetitionAjouter);
		
		JComboBox<Object> listeCompetitionSupprimer = new JComboBox<Object>();
		listeCompetitionSupprimer.setBounds(656, 284, 190, 20);
		panelPersonne.add(listeCompetitionSupprimer);
		
		listePersonne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!refresh){
					boolean present = false;
					boolean occupe = false;
					listeEquipePersonne.removeAll();
					listeCompetitionPersonne.removeAll();
					listeEquipeAjouter.removeAllItems();
					listeEquipeSupprimer.removeAllItems();
					listeCompetitionAjouter.removeAllItems();
					listeCompetitionSupprimer.removeAllItems();
					int i = 0;
					for(Personne p : insc.getPersonnes()){
						if (i == listePersonne.getSelectedIndex()){
							for(Equipe e : p.getEquipes()){
								for(Competition comp : e.getCompetitions()){
									listeCompetitionPersonne.add(comp.getNom());
								}
							}
							// Equipe
							for(Equipe equipe : insc.getEquipes()){
								present = false;
								occupe = false;
								for(Equipe equ : p.getEquipes()){
									if(equipe.getId() == equ.getId()){
										present = true;
									}
									for(Competition compet : equipe.getCompetitions()){
										for(Competition comp : equ.getCompetitions()){
											if(compet.getId() == comp.getId()){
												occupe = true;
											}
										}
									}
								}
								if(!present && !occupe) {
									listeEquipeAjouter.addItem(equipe.getNom());
								}
								else if (present){
									listeEquipePersonne.add(equipe.getNom());
									listeEquipeSupprimer.addItem(equipe.getNom());
								}
							}
							
							// Competition
							for(Competition competition : insc.getCompetitions()){
								present = false;
								for(Competition comp : p.getCompetitions()){
									if(competition.getId() == comp.getId()){
										present = true;
									}
									
								}
								if(!present && !competition.estEnEquipe()) {
									listeCompetitionAjouter.addItem(competition.getNom());
								}
								else if (present) {
									listeCompetitionPersonne.add(competition.getNom());
									listeCompetitionSupprimer.addItem(competition.getNom());
								}
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
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setBounds(656, 52, 96, 20);
		panelPersonne.add(btnAjouter);
		
		btnAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Equipe> listeEquipeAjout = new ArrayList<Equipe>();
				boolean present;
				boolean occupe;
				int i = 0;
				for(Personne p : insc.getPersonnes()){
					if (i == listePersonne.getSelectedIndex()){
						for(Equipe equipe : insc.getEquipes()){
							present = false;
							occupe = false;
							for(Equipe equ : p.getEquipes()){
								if(equipe.getId() == equ.getId()){
									present = true;
								}
								for(Competition compet : equipe.getCompetitions()){
									for(Competition comp : equ.getCompetitions()){
										if(compet.getId() == comp.getId()){
											occupe = true;
										}
									}
								}
							}
							if(!present && !occupe) {
								listeEquipeAjout.add(equipe);
							}
						}
					}
				}
				int j = 0;
				int k = 0;
				for(Personne p : insc.getPersonnes()){
					if (k == listePersonne.getSelectedIndex()){
						for(Equipe equipe : listeEquipeAjout){
							if(j == listeEquipeAjouter.getSelectedIndex())
								equipe.add(p);
							j++;
						}
					}
					k++;
				}
				
			}
		});
		
		JButton btnAjouter2 = new JButton("Ajouter");
		btnAjouter2.setBounds(656, 239, 96, 20);
		panelPersonne.add(btnAjouter2);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setBounds(656, 124, 96, 20);
		panelPersonne.add(btnSupprimer);
		
		JButton btnSupprimer2 = new JButton("Supprimer");
		btnSupprimer2.setBounds(656, 305, 96, 20);
		panelPersonne.add(btnSupprimer2);
		
		JLabel lblAjouterAEquipe = new JLabel("Ajouter à une équipe");
		lblAjouterAEquipe.setBounds(656, 13, 190, 14);
		panelPersonne.add(lblAjouterAEquipe);
		
		JLabel lblSupprimerDEquipe = new JLabel("Supprimer d'une équipe");
		lblSupprimerDEquipe.setBounds(656, 84, 190, 14);
		panelPersonne.add(lblSupprimerDEquipe);
		
		JLabel lblAjouterACompetition = new JLabel("Ajouter à une compétition");
		lblAjouterACompetition.setBounds(656, 197, 190, 14);
		panelPersonne.add(lblAjouterACompetition);
		
		JLabel lblSupprimerDCompetition = new JLabel("Supprimer d'une compétition");
		lblSupprimerDCompetition.setBounds(656, 264, 190, 14);
		panelPersonne.add(lblSupprimerDCompetition);
		
		////////////
		// EQUIPE //
		////////////
		
		JLayeredPane panelEquipe = new JLayeredPane();
		tabbedPane.addTab("Equipes", null, panelEquipe, null);
		
		JLabel lblNomEquipe = new JLabel("Nom de l'équipe");
		lblNomEquipe.setBounds(10, 14, 190, 20);
		panelEquipe.add(lblNomEquipe);
		
		txtNomEquipe = new JTextField();
		txtNomEquipe.setBounds(10, 39, 190, 20);
		panelEquipe.add(txtNomEquipe);
		txtNomEquipe.setColumns(10);
		
		JLabel lblPersonnesDeLequipe = new JLabel("Personne(s) de l'equipe");
		lblPersonnesDeLequipe.setBounds(444, 14, 190, 14);
		panelEquipe.add(lblPersonnesDeLequipe);
		
		List listePersonneEquipe = new List();
		listePersonneEquipe.setBounds(444, 30, 190, 160);
		panelEquipe.add(listePersonneEquipe);
		
		JLabel lblComptitionsDeLquipe = new JLabel("Compétition(s) de  l'équipe");
		lblComptitionsDeLquipe.setBounds(444, 196, 190, 14);
		panelEquipe.add(lblComptitionsDeLquipe);
		
		List listeCompetitionEquipe = new List();
		listeCompetitionEquipe.setBounds(444, 218, 190, 160);
		panelEquipe.add(listeCompetitionEquipe);
		
		JLabel lblSelectEquipe = new JLabel("Sélectionner une équipe");
		lblSelectEquipe.setBounds(232, 14, 190, 14);
		panelEquipe.add(lblSelectEquipe);
		
		JComboBox<Object> listeEquipe = new JComboBox<Object>();
		for(Equipe equipe : insc.getEquipes())
			listeEquipe.addItem(equipe.getNom());
		listeEquipe.setBounds(232, 36, 190, 20);
		panelEquipe.add(listeEquipe);
		
		listeEquipe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!refresh){
					listePersonneEquipe.removeAll();
					listeCompetitionEquipe.removeAll();
					int i = 0;
					for(Equipe e : insc.getEquipes()){
						if (i == listeEquipe.getSelectedIndex()){
							for(Personne p : e.getMembres()){
								listePersonneEquipe.add(p.getPrenom()+" "+p.getNom());
							}
							for(Competition c : e.getCompetitions()){
								listeCompetitionEquipe.add(c.getNom());
							}
							txtNomEquipe.setText(e.getNom());
						}
						i++;
					}
				}
			}
		});
		
		JButton btnAjouterUneEquipe = new JButton("Ajouter");
		btnAjouterUneEquipe.setBounds(10, 236, 190, 40);
		panelEquipe.add(btnAjouterUneEquipe);
		
		btnAjouterUneEquipe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AjouterEquipe ajoutEquipe = new AjouterEquipe();
					ajoutEquipe.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					ajoutEquipe.setVisible(true);
					ajoutEquipe.okButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							insc.createEquipe(insc.getAICandidats(), ajoutEquipe.txtNom.getText());
							ajoutEquipe.dispose();
							refresh = true;
							listeEquipe.removeAllItems();
							for(Equipe equ : insc.getEquipes()) {
								listeEquipe.addItem(equ.getNom());
							}
							refresh = false;
						}
					});
				} 
				catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnModifierUneEquipe = new JButton("Modifier");
		btnModifierUneEquipe.setBounds(10, 286, 190, 40);
		panelEquipe.add(btnModifierUneEquipe);
		
		JButton btnSupprimerUneEquipe = new JButton("Supprimer");
		btnSupprimerUneEquipe.setBounds(10, 336, 190, 40);
		panelEquipe.add(btnSupprimerUneEquipe);
		
		btnSupprimerUneEquipe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = 0;
				for(Equipe equipe : insc.getEquipes()){
					if(i == listeEquipe.getSelectedIndex()){
						equipe.delete();
					}
					i++;
				}
				listeEquipe.removeItem(listeEquipe.getSelectedItem());
			}
		});
		
		JComboBox<Object> comboBox_4 = new JComboBox<Object>();
		comboBox_4.setBounds(656, 50, 190, 20);
		panelEquipe.add(comboBox_4);
		
		JComboBox<Object> comboBox_5 = new JComboBox<Object>();
		comboBox_5.setBounds(656, 121, 190, 20);
		panelEquipe.add(comboBox_5);
		
		JComboBox<Object> comboBox_6 = new JComboBox<Object>();
		comboBox_6.setBounds(656, 235, 190, 20);
		panelEquipe.add(comboBox_6);
		
		JComboBox<Object> comboBox_7 = new JComboBox<Object>();
		comboBox_7.setBounds(656, 301, 190, 20);
		panelEquipe.add(comboBox_7);
		
		JButton button_2 = new JButton("Ajouter");
		button_2.setBounds(656, 69, 96, 20);
		panelEquipe.add(button_2);
		
		JButton button_3 = new JButton("Ajouter");
		button_3.setBounds(656, 256, 96, 20);
		panelEquipe.add(button_3);
		
		JButton button_4 = new JButton("Supprimer");
		button_4.setBounds(656, 141, 96, 20);
		panelEquipe.add(button_4);
		
		JButton button_5 = new JButton("Supprimer");
		button_5.setBounds(656, 322, 96, 20);
		panelEquipe.add(button_5);
		
		JLabel lblAjouterUnePersonne = new JLabel("Ajouter une personne");
		lblAjouterUnePersonne.setBounds(656, 30, 190, 14);
		panelEquipe.add(lblAjouterUnePersonne);
		
		JLabel lblSupprimerUnePersonne = new JLabel("Supprimer une personne");
		lblSupprimerUnePersonne.setBounds(656, 101, 190, 14);
		panelEquipe.add(lblSupprimerUnePersonne);
		
		JLabel label_2 = new JLabel("Ajouter à une compétition");
		label_2.setBounds(656, 214, 190, 14);
		panelEquipe.add(label_2);
		
		JLabel label_3 = new JLabel("Supprimer d'une compétition");
		label_3.setBounds(656, 281, 190, 14);
		panelEquipe.add(label_3);
		
		/////////////////
		// COMPETITION //
		/////////////////
		
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
		
		JLabel lblListeCompetition = new JLabel("Sélectionner une compétition");
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
		
		btnAjouterCompetition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AjouterCompetition ajoutCompet = new AjouterCompetition();
					ajoutCompet.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					ajoutCompet.setVisible(true);
					ajoutCompet.okButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							insc.createCompetition(insc.getAICompetitions(), ajoutCompet.txtNom.getText(), LocalDate.parse(ajoutCompet.txtDateCloture.getText()), ajoutCompet.rdbtnOui.isSelected());
							ajoutCompet.dispose();
							refresh = true;
							listeCompetition.removeAllItems();
							for(Competition comp : insc.getCompetitions()) {
								listeCompetition.addItem(comp.getNom());
							}
							refresh = false;
						}
					});
				} 
				catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnModifierCompetition = new JButton("Modifier");
		btnModifierCompetition.setBounds(10, 286, 190, 40);
		panelCompetition.add(btnModifierCompetition);
		
		JButton btnSupprimerCompetition = new JButton("Supprimer");
		btnSupprimerCompetition.setBounds(10, 338, 190, 40);
		panelCompetition.add(btnSupprimerCompetition);
		
		btnSupprimerCompetition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = 0;
				for(Competition compet : insc.getCompetitions()){
					if(i == listeCompetition.getSelectedIndex()){
						compet.delete();
					}
					i++;
				}
				listeCompetition.removeItem(listeCompetition.getSelectedItem());
			}
		});
		
		JLabel lblCandidatCompetition = new JLabel("Candidat(s) de la compétition");
		lblCandidatCompetition.setBounds(658, 14, 188, 14);
		panelCompetition.add(lblCandidatCompetition);
	}
}
