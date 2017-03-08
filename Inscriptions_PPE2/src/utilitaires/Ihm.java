package utilitaires;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

import DB.Requete;
import inscriptions.Equipe;
import inscriptions.Inscriptions;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

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
	private ButtonGroup bg = new ButtonGroup();
	private JRadioButton rdbtnOui = new JRadioButton("Oui");
	private JRadioButton rdbtnNo = new JRadioButton("Non");
	private JDateChooser dateCloture = new JDateChooser();

	private static Requete r;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					r = new Requete();
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
		frame = new JFrame();
		frame.setBounds(100, 100, 520, 392);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		bg.add(rdbtnOui);
		bg.add(rdbtnNo);
		
		JLabel lblAccueil = new JLabel("Inscriptions\r\n");
		lblAccueil.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAccueil.setBounds(197, 11, 82, 35);
		frame.getContentPane().add(lblAccueil);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 45, 504, 308);
		frame.getContentPane().add(tabbedPane);
		
		JLayeredPane panelPersonne = new JLayeredPane();
		tabbedPane.addTab("Personnes", null, panelPersonne, null);
		
		JButton btnAjouterUnePersonne = new JButton("Ajouter une personne");
		btnAjouterUnePersonne.setBounds(10, 203, 152, 23);
		panelPersonne.add(btnAjouterUnePersonne);
		
		JComboBox<Object> comboBox = new JComboBox<Object>();
		comboBox.addItem(null);
		for(String l : r.getPersonne())
			comboBox.addItem(l);
		comboBox.setBounds(290, 35, 152, 20);
		panelPersonne.add(comboBox);
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtNomPersonne.setText(r.getNom(comboBox.getSelectedIndex()));
				txtPrenomPersonne.setText(r.getPrenom(comboBox.getSelectedIndex()));
				txtMailPersonne.setText(r.getMail(comboBox.getSelectedIndex()));
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
		
		JButton btnModifierUnePersonne = new JButton("Modifier une personne\r\n");
		btnModifierUnePersonne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//txtNomPersonne.setText((String) comboBox.);
			}
		});
		btnModifierUnePersonne.setBounds(172, 203, 152, 23);
		panelPersonne.add(btnModifierUnePersonne);
		
		JButton btnSupprimerUnePersonne = new JButton("Supprimer une personne");
		btnSupprimerUnePersonne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSupprimerUnePersonne.setBounds(337, 203, 152, 23);
		panelPersonne.add(btnSupprimerUnePersonne);
		
		JLabel lblNewLabel_6 = new JLabel("S\u00E9l\u00E9ctionner une personne");
		lblNewLabel_6.setBounds(290, 10, 165, 14);
		panelPersonne.add(lblNewLabel_6);
		
		JLayeredPane panelEquipe = new JLayeredPane();
		tabbedPane.addTab("Equipes", null, panelEquipe, null);
		
		JButton btnAjouterUneEquipe = new JButton("Ajouter une \u00E9quipe\r\n");
		btnAjouterUneEquipe.setBounds(10, 203, 152, 23);
		panelEquipe.add(btnAjouterUneEquipe);
		
		JButton btnModifierUneEquipe = new JButton("Modifier une \u00E9quipe");
		btnModifierUneEquipe.setBounds(175, 203, 152, 23);
		panelEquipe.add(btnModifierUneEquipe);
		
		JButton btnSupprimerUneEquipe = new JButton("Supprimer une \u00E9quipe");
		btnSupprimerUneEquipe.setBounds(337, 203, 152, 23);
		panelEquipe.add(btnSupprimerUneEquipe);
		
		JLabel lblNewLabel_3 = new JLabel("Acronyme");
		lblNewLabel_3.setBounds(10, 25, 74, 14);
		panelEquipe.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Nom de l'\u00E9quipe\r\n");
		lblNewLabel_4.setBounds(10, 78, 89, 14);
		panelEquipe.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Mail de l'\u00E9quipe\r\n");
		lblNewLabel_5.setBounds(10, 135, 74, 14);
		panelEquipe.add(lblNewLabel_5);
		
		txtAcronymeEquipe = new JTextField();
		txtAcronymeEquipe.setBounds(10, 50, 125, 20);
		panelEquipe.add(txtAcronymeEquipe);
		txtAcronymeEquipe.setColumns(10);
		
		txtNomEquipe = new JTextField();
		txtNomEquipe.setBounds(10, 103, 125, 20);
		panelEquipe.add(txtNomEquipe);
		txtNomEquipe.setColumns(10);
		
		txtMailEquipe = new JTextField();
		txtMailEquipe.setBounds(10, 160, 125, 20);
		panelEquipe.add(txtMailEquipe);
		txtMailEquipe.setColumns(10);
		
		JComboBox<Object> comboBox_1 = new JComboBox<Object>();
		comboBox_1.addItem(null);
		for(String l : r.getEquipe())
			comboBox_1.addItem(l);
		comboBox_1.setBounds(254, 50, 179, 20);
		panelEquipe.add(comboBox_1);
		
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtAcronymeEquipe.setText(r.getAcrEquipe(comboBox_1.getSelectedIndex()));
				txtNomEquipe.setText(r.getNomEquipe(comboBox_1.getSelectedIndex()));
				txtMailEquipe.setText(r.getMailEquipe(comboBox_1.getSelectedIndex()));
			}
		});
		
		
		JLabel lblSlctionnerUnequipe = new JLabel("S\u00E9l\u00E9ctionner une \u00E9quipe");
		lblSlctionnerUnequipe.setBounds(254, 25, 179, 14);
		panelEquipe.add(lblSlctionnerUnequipe);
		
		JLayeredPane panelCompetition = new JLayeredPane();
		tabbedPane.addTab("Competitions", null, panelCompetition, null);
		
		dateCloture = new JDateChooser();
		dateCloture.setBounds(10,91,152,23);
		dateCloture.setDate(Date.valueOf("2017-01-01"));
		panelCompetition.add(dateCloture);
		
		JComboBox<Object> comboBox_2 = new JComboBox<Object>();
		comboBox_2.addItem(null);
		for(String l : r.getCompetition())
			comboBox_2.addItem(l);
		comboBox_2.setBounds(290, 35, 152, 20);
		panelCompetition.add(comboBox_2);
		
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtNomEpreuve.setText(r.nomCompetition(comboBox_2.getSelectedIndex()));
				dateCloture.setDateFormatString(r.dateClotureInscription(comboBox_2.getSelectedIndex()));
				if(r.enEquipe(comboBox_2.getSelectedIndex()).equals("1"))
					rdbtnOui.setSelected(true);
				if(r.enEquipe(comboBox_2.getSelectedIndex()).equals("0"))
					rdbtnNo.setSelected(true);
			}
		});
		
		JLabel lblNewLabel_7 = new JLabel("S\u00E9l\u00E9ctionner une comp\u00E9tition");
		lblNewLabel_7.setBounds(290, 10, 165, 14);
		panelCompetition.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Nom Epreuve");
		lblNewLabel_8.setBounds(10, 14, 88, 14);
		panelCompetition.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Date Cloture");
		lblNewLabel_9.setBounds(10, 66, 88, 14);
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
		btnNewButton.setBounds(10, 203, 152, 23);
		panelCompetition.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Modifier");
		btnNewButton_1.setBounds(175, 203, 152, 23);
		panelCompetition.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Supprimer");
		btnNewButton_2.setBounds(337, 203, 152, 23);
		panelCompetition.add(btnNewButton_2);
	}
}
