package utilitaires;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
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
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import java.util.Calendar;

@SuppressWarnings("unused")
public class Ihm {

	private JFrame frame;
	private JTextField txtNomPersonne;
	private JTextField txtPrenomPersonne;
	private JTextField txtMailPersonne;
	private JTextField txtNomEquipe;
	private JTextField txtNomEpreuve;
	private JTextField txtDateCloture;
	//private JTextField dateCloture;
	private ButtonGroup bg = new ButtonGroup();
	private JRadioButton rdbtnOui = new JRadioButton("Oui");
	private JRadioButton rdbtnNo = new JRadioButton("Non");
	private JLabel lblAccueil = new JLabel("Inscriptions");
	private JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private JLayeredPane panelPersonne = new JLayeredPane();
	private JComboBox<Object> listePersonne = new JComboBox<Object>();
	private List listeEquipePersonne = new List();
	private List listeCompetitionPersonne = new List();
	private JLabel lblNom = new JLabel("Nom");
	private JLabel lblPrenom = new JLabel("Prénom");
	private JLabel lblMail = new JLabel("Mail");
	private JButton btnAjouterUnePersonne = new JButton("Ajouter");
	private JButton btnModifierUnePersonne = new JButton("Modifier");
	private JButton btnSupprimerUnePersonne = new JButton("Supprimer");
	private JLabel lblSelectPersonne = new JLabel("Sélectionner une personne");
	private JLabel lblEquipesDeLa = new JLabel("Equipe(s) de la personne");
	private JLabel lblComptitionsDeLa = new JLabel("Compétition(s) de la personne");
	private JComboBox<Object> listeEquipeAjouter = new JComboBox<Object>();
	private JComboBox<Object> listeEquipeSupprimer = new JComboBox<Object>();
	private JComboBox<Object> listeCompetitionAjouter = new JComboBox<Object>();
	private JComboBox<Object> listeCompetitionSupprimer = new JComboBox<Object>(); 
	private JButton btnAjouter = new JButton("Ajouter");
	private JButton btnAjouter2 = new JButton("Ajouter");
	private JButton btnSupprimer = new JButton("Supprimer");
	private JButton btnSupprimer2 = new JButton("Supprimer");
	private JLabel lblAjouterAEquipe = new JLabel("Ajouter à une équipe");
	private JLabel lblSupprimerDEquipe = new JLabel("Supprimer d'une équipe");
	private JLabel lblAjouterACompetition = new JLabel("Ajouter à une compétition");
	private JLabel lblSupprimerDCompetition = new JLabel("Supprimer d'une compétition");
	private JLayeredPane panelEquipe = new JLayeredPane();
	private JLabel lblNomEquipe = new JLabel("Nom de l'équipe");
	private JLabel lblPersonnesDeLequipe = new JLabel("Personne(s) de l'equipe");
	private List listePersonneEquipe = new List();
	private JLabel lblComptitionsDeLquipe = new JLabel("Compétition(s) de  l'équipe");
	private List listeCompetitionEquipe = new List();
	private JLabel lblSelectEquipe = new JLabel("Sélectionner une équipe");
	private JComboBox<Object> listeEquipe = new JComboBox<Object>();
	private JButton btnAjouterUneEquipe = new JButton("Ajouter");
	private JButton btnModifierUneEquipe = new JButton("Modifier");
	private JButton btnSupprimerUneEquipe = new JButton("Supprimer");
	private JComboBox<Object> comboBox_4 = new JComboBox<Object>();
	private JComboBox<Object> comboBox_5 = new JComboBox<Object>();
	private JComboBox<Object> comboBox_6 = new JComboBox<Object>();
	private JComboBox<Object> comboBox_7 = new JComboBox<Object>();
	private JButton button_2 = new JButton("Ajouter");
	private JButton button_3 = new JButton("Ajouter");
	private JButton button_4 = new JButton("Supprimer");
	private JButton button_5 = new JButton("Supprimer");
	private JLabel lblAjouterUnePersonne = new JLabel("Ajouter une personne");
	private JLabel lblSupprimerUnePersonne = new JLabel("Supprimer une personne");
	private JLabel label_2 = new JLabel("Ajouter à une compétition");
	private JLabel label_3 = new JLabel("Supprimer d'une compétition");
	private JLayeredPane panelCompetition = new JLayeredPane();
	private JComboBox<Object> listeCompetition = new JComboBox<Object>();
	private List listeCandidatCompetition = new List();
	private JLabel lblListeCompetition = new JLabel("Sélectionner une compétition");
	private JLabel lblNomEpreuve = new JLabel("Nom Epreuve");
	private JLabel lblDateCloture = new JLabel("Date Cloture (YYYY-MM-DD)");
	private JLabel lblEnEquipe = new JLabel("En Equipe");
	private JButton btnAjouterCompetition = new JButton("Ajouter");
	private JButton btnModifierCompetition = new JButton("Modifier");
	private JButton btnSupprimerCompetition = new JButton("Supprimer");
	private JLabel lblCandidatCompetition = new JLabel("Candidat(s) de la compétition");
	private JSpinner dateCloture = new JSpinner();
	
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
		
		
		lblAccueil.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblAccueil.setBounds(385, 12, 117, 35);
		frame.getContentPane().add(lblAccueil);
		
		
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(0, 45, 863, 416);
		frame.getContentPane().add(tabbedPane);
		
		//////////////
		// PERSONNE //
		//////////////
		//Configuration IHM Onglet Equipe	
		tabbedPane.addTab("Personnes", null, panelPersonne, null);
		
		btnAjouter2.setBounds(656, 239, 96, 20);
		panelPersonne.add(btnAjouter2);
		
		
		btnSupprimer.setEnabled(false);
		btnSupprimer.setBounds(656, 124, 96, 20);
		panelPersonne.add(btnSupprimer);
		
		
		btnSupprimer2.setEnabled(false);
		btnSupprimer2.setBounds(656, 305, 96, 20);
		panelPersonne.add(btnSupprimer2);
		
		
		lblAjouterAEquipe.setBounds(656, 13, 190, 14);
		panelPersonne.add(lblAjouterAEquipe);
		
		
		
		lblSupprimerDEquipe.setBounds(656, 84, 190, 14);
		panelPersonne.add(lblSupprimerDEquipe);
		
		
		lblAjouterACompetition.setBounds(656, 197, 190, 14);
		panelPersonne.add(lblAjouterACompetition);
		
		
		lblSupprimerDCompetition.setBounds(656, 264, 190, 14);
		panelPersonne.add(lblSupprimerDCompetition);
		
		listePersonne.setBounds(227, 35, 190, 20);
		panelPersonne.add(listePersonne);
		
		listeEquipePersonne.setBounds(445, 35, 190, 160);
		panelPersonne.add(listeEquipePersonne);
		listeCompetitionPersonne.setBounds(445, 218, 190, 160);
		panelPersonne.add(listeCompetitionPersonne);
		
		
		lblNom.setBounds(10, 14, 189, 14);
		panelPersonne.add(lblNom);
		
		
		lblPrenom.setBounds(10, 66, 189, 14);
		panelPersonne.add(lblPrenom);
		
		
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
		
		buttonGroup.add(btnAjouterUnePersonne);
		btnAjouterUnePersonne.setBounds(10, 238, 190, 40);
		panelPersonne.add(btnAjouterUnePersonne);
		
		btnModifierUnePersonne.setBounds(10, 290, 190, 40);
		panelPersonne.add(btnModifierUnePersonne);
		
		btnSupprimerUnePersonne.setBounds(10, 340, 190, 40);
		panelPersonne.add(btnSupprimerUnePersonne);
		
		lblSelectPersonne.setBounds(227, 14, 190, 14);
		panelPersonne.add(lblSelectPersonne);
		
		
		lblEquipesDeLa.setBounds(445, 14, 190, 14);
		panelPersonne.add(lblEquipesDeLa);
		
		
		lblComptitionsDeLa.setBounds(445, 198, 190, 14);
		panelPersonne.add(lblComptitionsDeLa);
		
		
		listeEquipeAjouter.setBounds(656, 33, 190, 20);
		panelPersonne.add(listeEquipeAjouter);
		
		listeEquipeSupprimer.setBounds(656, 104, 190, 20);
		panelPersonne.add(listeEquipeSupprimer);
		
		
		listeCompetitionAjouter.setBounds(656, 218, 190, 20);
		panelPersonne.add(listeCompetitionAjouter);
		
		
		listeCompetitionSupprimer.setBounds(656, 284, 190, 20);
		panelPersonne.add(listeCompetitionSupprimer);
		
		btnAjouter.setBounds(656, 52, 96, 20);
		panelPersonne.add(btnAjouter);
		
		///////////////////////////////////////FONCTION PERSONNE ////////////////////////
		for(Personne personne : insc.getPersonnes()){
			listePersonne.addItem(personne.getPrenom()+" "+personne.getNom());
		}
	
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
		btnModifierUnePersonne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = 0;
				for(Personne p : insc.getPersonnes()) {
					if(i == listePersonne.getSelectedIndex()){
						p.setNom(txtNomPersonne.getText());
						p.setPrenom(txtPrenomPersonne.getText());
						p.setMail(txtMailPersonne.getText());
					}
					i++;
				}
				refresh = true;
				listePersonne.removeAllItems();
				for(Personne p : insc.getPersonnes()) {
					listePersonne.addItem(p.getPrenom()+" "+p.getNom());
				}
				refresh = false;
			}
		});
		
		

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
		
		
	
		
		listeEquipeAjouter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		
		
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
				
		listeEquipePersonne.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				btnSupprimer.setEnabled(true);
			}
		});
		listeCompetitionPersonne.addItemListener(new ItemListener() {
		public void itemStateChanged(ItemEvent arg0) {
			btnSupprimer2.setEnabled(true);
		}
	});
		////////////
		// EQUIPE //
		////////////
		
		/////////////////////////////////CONFIGURATION IHM EQUIPE /////////////////////////////////////////////////////
		
		tabbedPane.addTab("Equipes", null, panelEquipe, null);
		
		lblNomEquipe.setBounds(10, 14, 190, 20);
		panelEquipe.add(lblNomEquipe);
		
		txtNomEquipe = new JTextField();
		txtNomEquipe.setBounds(10, 39, 190, 20);
		panelEquipe.add(txtNomEquipe);
		txtNomEquipe.setColumns(10);
		
		lblPersonnesDeLequipe.setBounds(444, 14, 190, 14);
		panelEquipe.add(lblPersonnesDeLequipe);
		
		listePersonneEquipe.setBounds(444, 30, 190, 160);
		panelEquipe.add(listePersonneEquipe);
		
		lblComptitionsDeLquipe.setBounds(444, 196, 190, 14);
		panelEquipe.add(lblComptitionsDeLquipe);
		
		listeCompetitionEquipe.setBounds(444, 218, 190, 160);
		panelEquipe.add(listeCompetitionEquipe);
		
		lblSelectEquipe.setBounds(232, 14, 190, 14);
		panelEquipe.add(lblSelectEquipe);
		
		comboBox_4.setBounds(656, 50, 190, 20);
		panelEquipe.add(comboBox_4);
		
		comboBox_5.setBounds(656, 121, 190, 20);
		panelEquipe.add(comboBox_5);
		
		comboBox_6.setBounds(656, 235, 190, 20);
		panelEquipe.add(comboBox_6);
		
		comboBox_7.setBounds(656, 301, 190, 20);
		panelEquipe.add(comboBox_7);
		
		button_2.setBounds(656, 69, 96, 20);
		panelEquipe.add(button_2);
		
		button_3.setBounds(656, 256, 96, 20);
		panelEquipe.add(button_3);
		
		button_4.setBounds(656, 141, 96, 20);
		panelEquipe.add(button_4);
		
		button_5.setBounds(656, 322, 96, 20);
		panelEquipe.add(button_5);
		
		lblAjouterUnePersonne.setBounds(656, 30, 190, 14);
		panelEquipe.add(lblAjouterUnePersonne);
		
		lblSupprimerUnePersonne.setBounds(656, 101, 190, 14);
		panelEquipe.add(lblSupprimerUnePersonne);
		
		label_2.setBounds(656, 214, 190, 14);
		panelEquipe.add(label_2);
		
		label_3.setBounds(656, 281, 190, 14);
		panelEquipe.add(label_3);
		
		btnAjouterUneEquipe.setBounds(10, 236, 190, 40);
		panelEquipe.add(btnAjouterUneEquipe);
		
		listeEquipe.setBounds(232, 36, 190, 20);
		panelEquipe.add(listeEquipe);
		
		btnModifierUneEquipe.setBounds(10, 286, 190, 40);
		panelEquipe.add(btnModifierUneEquipe);
		
		btnSupprimerUneEquipe.setBounds(10, 336, 190, 40);
		panelEquipe.add(btnSupprimerUneEquipe);
		
		
		//////////////////////////////////////////FONCTION ONGLET COMPETITION /////////////////////////////////////////////////
		
		for(Equipe equipe : insc.getEquipes())
			listeEquipe.addItem(equipe.getNom());
		
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
		
		
		
		
		btnModifierUneEquipe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = 0;
				for(Equipe equ : insc.getEquipes()) {
					if(i == listeEquipe.getSelectedIndex()){
						equ.setNom(txtNomEquipe.getText());
					}
					i++;
				}
				refresh = true;
				listeEquipe.removeAllItems();
				for(Equipe equ : insc.getEquipes()) {
					listeEquipe.addItem(equ.getNom());
				}
				refresh = false;
			}
		});
		
		
		
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
		
		
		
		
		/////////////////
		// COMPETITION //
		/////////////////
		
		////////////////////////////////////////CONFIGURATION IHM ONGLET COMPETITION ///////////////////////////////////////////
		tabbedPane.addTab("Competitions", null, panelCompetition, null);
		
		//dateCloture = new JTextField("YYYY-MM-DD");
		//dateCloture.setBounds(245,99,190,23);
		//panelCompetition.add(dateCloture);
		//dateCloture.setColumns(10);
		
		listeCompetition.setBounds(319, 35, 190, 20);
		panelCompetition.add(listeCompetition);
		
		listeCandidatCompetition.setBounds(658, 35, 190, 343);
		panelCompetition.add(listeCandidatCompetition);
		
		lblListeCompetition.setBounds(319, 14, 190, 14);
		panelCompetition.add(lblListeCompetition);
		
		
		lblNomEpreuve.setBounds(10, 14, 190, 14);
		panelCompetition.add(lblNomEpreuve);
		
		
		lblDateCloture.setBounds(10, 66, 190, 14);
		panelCompetition.add(lblDateCloture);
		
		
		lblEnEquipe.setBounds(10, 126, 190, 14);
		panelCompetition.add(lblEnEquipe);
		
		txtNomEpreuve = new JTextField();
		txtNomEpreuve.setBounds(10, 35, 190, 20);
		panelCompetition.add(txtNomEpreuve);
		txtNomEpreuve.setColumns(10);
		rdbtnOui.setEnabled(false);
		
		rdbtnOui.setBounds(10, 148, 85, 23);
		panelCompetition.add(rdbtnOui);
		rdbtnNo.setEnabled(false);
		
		rdbtnNo.setBounds(115, 148, 85, 23);
		panelCompetition.add(rdbtnNo);
		
		
		btnAjouterCompetition.setBounds(10, 234, 190, 40);
		panelCompetition.add(btnAjouterCompetition);
		
		btnModifierCompetition.setBounds(10, 286, 190, 40);
		panelCompetition.add(btnModifierCompetition);
		
		btnSupprimerCompetition.setBounds(10, 338, 190, 40);
		panelCompetition.add(btnSupprimerCompetition);
		
		lblCandidatCompetition.setBounds(658, 14, 188, 14);
		panelCompetition.add(lblCandidatCompetition);
		
		dateCloture.setModel(new SpinnerDateModel(new java.util.Date(1494194400000L), null, null, Calendar.DAY_OF_YEAR));
		dateCloture.setBounds(10, 95, 159, 20);
		panelCompetition.add(dateCloture);
		
		
		
		////////////////////////////////////////FONCTION ONGLET COMPETITION //////////////////////////////
		
		for(Competition c : insc.getCompetitions())
			listeCompetition.addItem(c.getNom());
		
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
							Date date = java.sql.Date.valueOf(c.getDateCloture());
							dateCloture.setValue(date);
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
		
		btnAjouterCompetition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AjouterCompetition ajoutCompet = new AjouterCompetition();
					ajoutCompet.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					ajoutCompet.setVisible(true);
					ajoutCompet.okButton.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							Date date = (Date)dateCloture.getValue();
							LocalDate localDate = LocalDate.parse( new SimpleDateFormat("yyyy-MM-dd").format(date) );
							insc.createCompetition(insc.getAICompetitions(), ajoutCompet.txtNom.getText(), localDate, ajoutCompet.rdbtnOui.isSelected());
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
	
		btnModifierCompetition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = 0;
				for(Competition c : insc.getCompetitions()) {
					if(i == listeCompetition.getSelectedIndex()){
						c.setNom(txtNomEpreuve.getText());
						//c.setDateCloture(LocalDate.parse(txtDateCloture.getText()));
					}
					i++;
				}
				refresh = true;
				listeCompetition.removeAllItems();
				for(Competition c : insc.getCompetitions()) {
					listeCompetition.addItem(c.getNom());
				}
				refresh = false;
			}
		});
	
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
	}
}
