package inscriptions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.time.LocalDate;
import java.util.SortedSet;
import java.util.TreeSet;

import dialogue.Action;
import dialogue.Menu;
import dialogue.Option;

/**
 * Point d'entrée dans l'application, un seul objet de type Inscription
 * permet de gérer les compétitions, candidats (de type equipe ou personne)
 * ainsi que d'inscrire des candidats à des compétition.
 */

public class Inscriptions implements Serializable
{
	private static final long serialVersionUID = -3095339436048473524L;
	private static final String FILE_NAME = "Inscriptions.srz";
	private static Inscriptions inscriptions;
	
	private SortedSet<Competition> competitions = new TreeSet<>();
	private SortedSet<Candidat> candidats = new TreeSet<>();

	private Inscriptions()
	{
	}
	
	/**
	 * Retourne les compétitions.
	 * @return
	 */
	
	public SortedSet<Competition> getCompetitions()
	{
		return Collections.unmodifiableSortedSet(competitions);
	}
	
	/**
	 * Retourne tous les candidats (personnes et équipes confondues).
	 * @return
	 */
	
	public SortedSet<Candidat> getCandidats()
	{
		return Collections.unmodifiableSortedSet(candidats);
	}

	/**
	 * Retourne toutes les personnes.
	 * @return
	 */
	
	public SortedSet<Personne> getPersonnes()
	{
		SortedSet<Personne> personnes = new TreeSet<>();
		for (Candidat c : getCandidats())
			if (c instanceof Personne)
				personnes.add((Personne)c);
		return Collections.unmodifiableSortedSet(personnes);
	}

	/**
	 * Retourne toutes les équipes.
	 * @return
	 */
	
	public SortedSet<Equipe> getEquipes()
	{
		SortedSet<Equipe> equipes = new TreeSet<>();
		for (Candidat c : getCandidats())
			if (c instanceof Equipe)
				equipes.add((Equipe)c);
		return Collections.unmodifiableSortedSet(equipes);
	}

	/**
	 * Créée une compétition. Ceci est le seul moyen, il n'y a pas
	 * de constructeur public dans {@link Competition}.
	 * @param nom
	 * @param dateCloture
	 * @param enEquipe
	 * @return
	 */
	
	public Competition createCompetition(String nom, 
			LocalDate dateCloture, boolean enEquipe)
	{
		Competition competition = new Competition(this, nom, dateCloture, enEquipe);
		competitions.add(competition);
		return competition;
	}

	/**
	 * Créée une Candidat de type Personne. Ceci est le seul moyen, il n'y a pas
	 * de constructeur public dans {@link Personne}.

	 * @param nom
	 * @param prenom
	 * @param mail
	 * @return
	 */
	
	public Personne createPersonne(String nom, String prenom, String mail)
	{
		Personne personne = new Personne(this, nom, prenom, mail);
		candidats.add(personne);
		return personne;
	}
	
	/**
	 * Créée une Candidat de type équipe. Ceci est le seul moyen, il n'y a pas
	 * de constructeur public dans {@link Equipe}.
	 * @param nom
	 * @param prenom
	 * @param mail
	 * @return
	 */
	
	public Equipe createEquipe(String nom)
	{
		Equipe equipe = new Equipe(this, nom);
		candidats.add(equipe);
		return equipe;
	}
	
	void remove(Competition competition)
	{
		competitions.remove(competition);
	}
	
	void remove(Candidat candidat)
	{
		candidats.remove(candidat);
	}
	
	/**
	 * Retourne l'unique instance de cette classe.
	 * Crée cet objet s'il n'existe déjà.
	 * @return l'unique objet de type {@link Inscriptions}.
	 */
	
	public static Inscriptions getInscriptions()
	{
		
		if (inscriptions == null)
		{
			inscriptions = readObject();
			if (inscriptions == null)
				inscriptions = new Inscriptions();
		}
		return inscriptions;
	}

	/**
	 * Retourne un object inscriptions vide. Ne modifie pas les compétitions
	 * et candidats déjà existants.
	 */
	
	public Inscriptions reinitialiser()
	{
		inscriptions = new Inscriptions();
		return getInscriptions();
	}

	/**
	 * Efface toutes les modifications sur Inscriptions depuis la dernière sauvegarde.
	 * Ne modifie pas les compétitions et candidats déjà existants.
	 */
	
	public Inscriptions recharger()
	{
		inscriptions = null;
		return getInscriptions();
	}
	
	private static Inscriptions readObject()
	{
		ObjectInputStream ois = null;
		try
		{
			FileInputStream fis = new FileInputStream(FILE_NAME);
			ois = new ObjectInputStream(fis);
			return (Inscriptions)(ois.readObject());
		}
		catch (IOException | ClassNotFoundException e)
		{
			return null;
		}
		finally
		{
				try
				{
					if (ois != null)
						ois.close();
				} 
				catch (IOException e){}
		}	
	}
	
	/**
	 * Sauvegarde le gestionnaire pour qu'il soit ouvert automatiquement 
	 * lors d'une exécution ultérieure du programme.
	 * @throws IOException 
	 */
	
	public void sauvegarder() throws IOException
	{
		ObjectOutputStream oos = null;
		try
		{
			FileOutputStream fis = new FileOutputStream(FILE_NAME);
			oos = new ObjectOutputStream(fis);
			oos.writeObject(this);
		}
		catch (IOException e)
		{
			throw e;
		}
		finally
		{
			try
			{
				if (oos != null)
					oos.close();
			} 
			catch (IOException e){}
		}
	}
	
	@Override
	public String toString()
	{
		return "Candidats : " + getCandidats().toString()
			+ "\nCompetitions  " + getCompetitions().toString();
	}
	
	public static void main(String[] args)
	{
//		Inscriptions inscriptions = Inscriptions.getInscriptions();
//		Competition flechettes = inscriptions.createCompetition("Mondial de fléchettes", null, false);
//		Personne tony = inscriptions.createPersonne("Tony", "Dent de plomb", "azerty"), 
//				boris = inscriptions.createPersonne("Boris", "le Hachoir", "ytreza");
//		flechettes.add(tony);
//		Equipe lesManouches = inscriptions.createEquipe("Les Manouches");
//		lesManouches.add(boris);
//		lesManouches.add(tony);
//		System.out.println(inscriptions);
//		lesManouches.delete();
//		System.out.println(inscriptions);
		
		Inscriptions inscriptions = Inscriptions.getInscriptions();
		
		// connection à la base
		Connect db = new Connect();		
		
		System.out.println("\n ----------------------------------- \n Utilitaire des inscriptions sportives M2L \n ----------------------------------- \n");
		
		// Menu principal
		Menu menuPrincipal = new Menu("Menu Princpial");
		
		
		
		/*
		 * 
		 */
		
		// Menu Candidat et ajout de ses options
		Menu menuCandidat = new Menu("Candidats", "a");
		menuCandidat.ajouteRevenir("r");
		// Supression Candidat
		menuCandidat.ajoute(new Option("Supprimer un candiat", "a", new Action() {
			public void optionSelectionnee() {
				int idCandidat = utilitaires.EntreesSorties.getInt("Saisissez l'id du candidat à supprimer : ");
				db.sql("call deleteCandidat(" + idCandidat + ")");
			}
		}));
		// Compétitions auxquelles le candidat est inscrit 
		menuCandidat.ajoute(new Option("Compétitions du candidat", "b", new Action() {
			public void optionSelectionnee() {
				int idCandidat = utilitaires.EntreesSorties.getInt("Saisissez l'id du candidat: ");
				db.sql("call competCandidat(" + idCandidat + ")");
			}
		}));
		// Nom du candidat
		menuCandidat.ajoute(new Option("Nom du candidat", "c", new Action() {
			public void optionSelectionnee() {
				int idCandidat = utilitaires.EntreesSorties.getInt("Saisissez l'id du candidat: ");
				db.sql("call nameCandidat(" + idCandidat + ")");
			}
		}));
		// Modifier nom candidat
		menuCandidat.ajoute(new Option("Modifier le nom du candidat", "d", new Action() {
			public void optionSelectionnee() {
				int idCandidat = utilitaires.EntreesSorties.getInt("Saisissez l'id du candidat: ");
				String nomCandidat = utilitaires.EntreesSorties.getString("Saissisez le nouveau nom du candidat: ");
				db.sql("call renameCandidat(" + idCandidat + ", " + nomCandidat + ")");
			}
		}));
		// Afficher les candidats
		menuCandidat.ajoute(new Option("Afficher les candidats", "e", new Action() {
			public void optionSelectionnee() {
				db.sql("call getCand()");
			}
		}));
		
		/*
		 * 
		 */
		
		// Menu compétition et ajout de ses options
		Menu menuCompetition = new Menu("Compétitions", "b");
		menuCompetition.ajouteRevenir("r");
		// inscrit une équipe é la compétition
		menuCompetition.ajoute(new Option("Ajouter une équipe à une compétition", "a", new Action() {
			public void optionSelectionnee() {
				int idEquipe = utilitaires.EntreesSorties.getInt("Saisissez l'id de l'équipe: ");
				int idComp = utilitaires.EntreesSorties.getInt("Saisissez l'id de la compétition: ");
				db.sql("call ajouterEquipeACompetition(" + idEquipe + ", " + idComp + ")");
			}
		}));
		menuCompetition.ajoute(new Option("Ajouter une personne à une compétition", "b", new Action() {
			public void optionSelectionnee() {
				int idPersonne = utilitaires.EntreesSorties.getInt("Saisissez l'id de la personne: ");
				int idComp = utilitaires.EntreesSorties.getInt("Saisissez l'id de la compétition: ");
				db.sql("call ajouterPersonneACompetition(" + idPersonne + ", " + idComp + ")");
			}
		}));
		menuCompetition.ajoute(new Option("Supprimer une compétition", "c", new Action() {
			public void optionSelectionnee() {
				int idComp = utilitaires.EntreesSorties.getInt("Saisissez l'id de la compétition: ");
				db.sql("call suprCom(" + idComp + ")");
			}
		}));
		menuCompetition.ajoute(new Option("Candidats inscrits à une compétition", "e", new Action() {
			public void optionSelectionnee() {
				int idComp = utilitaires.EntreesSorties.getInt("Saisissez l'id de la compétition: ");
				db.sql("call candidatsInscritsComp(" + idComp + ")");
			}
		}));
		menuCompetition.ajoute(new Option("date de cloture des compétitions", "f", new Action() {
			public void optionSelectionnee() {
				db.sql("call dateClotureInscription()");
			}
		}));
		menuCompetition.ajoute(new Option("Nom d'une compétition", "g", new Action() {
			public void optionSelectionnee() {
				int idComp = utilitaires.EntreesSorties.getInt("Saisissez l'id de la compétition: ");
				db.sql("call nom_de_competition(" + idComp + ")");
			}
		}));
		menuCompetition.ajoute(new Option("Les inscriptions d'une compétition sont elles encore ouvertes", "h", new Action() {
			public void optionSelectionnee() {
				int idComp = utilitaires.EntreesSorties.getInt("Saisissez l'id de la compétition: ");
				db.sql("call inscriptions_date(" + idComp + ")");
			}
		}));
		menuCompetition.ajoute(new Option("Désinscrire un candidat d'une compétition", "i", new Action() {
			public void optionSelectionnee() {
				int idCandidat = utilitaires.EntreesSorties.getInt("Saisissez l'id du candidat: ");
				int idComp = utilitaires.EntreesSorties.getInt("Saisissez l'id de la compétition: ");
				db.sql("call desinscritCandidat(" + idCandidat + ", " + idComp + ")");
			}
		}));
		menuCompetition.ajoute(new Option("Modifier date de cloture d'une compétition", "j", new Action() {
			public void optionSelectionnee() {
				int idComp = utilitaires.EntreesSorties.getInt("Saisissez l'id de la compétition: ");
				String date = utilitaires.EntreesSorties.getString("Saisissez la nouvelle date de cloture: ");
				db.sql("call modifdatecloture(" + idComp + ", " + date + ")");
			}
		}));
		menuCompetition.ajoute(new Option("Modifier le nom d'une compétition", "k", new Action() {
			public void optionSelectionnee() {
				int idComp = utilitaires.EntreesSorties.getInt("Saisissez l'id de la compétition: ");
				String nom = utilitaires.EntreesSorties.getString("Saisissez le nouveau nom: ");
				db.sql("call modifnomcompetition(" + idComp + "," + nom + ")");
			}
		}));
		menuCompetition.ajoute(new Option("Créer une compétition", "l", new Action() {
			public void optionSelectionnee() {
				String nom = utilitaires.EntreesSorties.getString("Saisissez le nom de la nouvelle compétition: ");
				String date = utilitaires.EntreesSorties.getString("Saisissez la date de cloture: ");
				int enEquipe = utilitaires.EntreesSorties.getInt("Compétition en équipe ? oui 1, non 0: ");
				db.sql("call creatcomp(" + nom + ", " + date + ", " + enEquipe + ")");
			}
		}));
		menuCompetition.ajoute(new Option("Afficher les compétitions", "m", new Action() {
			public void optionSelectionnee() {
				db.sql("call getComp()");
			}
		}));
		
		/*
		 * 
		 */
		
		// Menu Personne
		Menu menuPersonne = new Menu("Personnes", "c");
		menuPersonne.ajouteRevenir("r");
		// Supprimer une personne
		menuPersonne.ajoute(new Option("Supprimer une personne", "a", new Action() {
			public void optionSelectionnee() {
				int idPers = utilitaires.EntreesSorties.getInt("Saisissez l'id de la personne: ");
				db.sql("call supprPersonne(" + idPers + ")");
			}
		}));
		// Affiche les équipes de la personne
		menuPersonne.ajoute(new Option("Afficher les équipes d'une personne", "b", new Action() {
			public void optionSelectionnee() {
			int idPers = utilitaires.EntreesSorties.getInt("Saisissez l'id de la personne: ");
			db.sql("call retourCandidatEquipe(" + idPers + ")");
			}
		}));
		// Affiche le mail d'une personne
		menuPersonne.ajoute(new Option("Afficher le mail d'une personne", "c", new Action() {
			public void optionSelectionnee() {
				int idPers = utilitaires.EntreesSorties.getInt("Saisissez l'id de la personne: ");
				db.sql("call retourMail(" + idPers + ")");
			}
		}));
		// Afficher le prénom d'une personne
		menuPersonne.ajoute(new Option("Afficher le prénom d'une personne", "d", new Action() {
			public void optionSelectionnee() {
				int idPers = utilitaires.EntreesSorties.getInt("Saisissez l'id de la personne: ");
				db.sql("call retourPrenom(" + idPers + ")");
			}
		}));
		// Modifier le prénom
		menuPersonne.ajoute(new Option("Modifier le prénom d'une personne", "e", new Action() {
			public void optionSelectionnee() {
				
			}
		}));
		// Modifier le mail d'une personne
		menuPersonne.ajoute(new Option("Modifier le mail d'une personne", "f", new Action() {
			public void optionSelectionnee() {
				int idPers = utilitaires.EntreesSorties.getInt("Saisissez l'id de la personne: ");
				String mail = utilitaires.EntreesSorties.getString("Saisissez le nouveau mail: ");
				db.sql("call changeMail(" + idPers + ", " + mail + ")");
			}
		}));
		// Modifier le prenom
		menuPersonne.ajoute(new Option("Modifier le prenom d'une personne", "g", new Action() {
			public void optionSelectionnee() {
				int idPers = utilitaires.EntreesSorties.getInt("Saisissez l'id de la personne: ");
				String prenom = utilitaires.EntreesSorties.getString("Saisissez le nouveau prenom: ");
				db.sql("call renommerPersonne(" + idPers + "," + prenom + ")");
			}
		}));
		// Créer une personne
		menuPersonne.ajoute(new Option("Créer une personne", "h", new Action() {
			public void optionSelectionnee() {
				String nom = utilitaires.EntreesSorties.getString("Saisissez le nom: ");
				String prenom = utilitaires.EntreesSorties.getString("Saisissez le prenom: ");
				String mail = utilitaires.EntreesSorties.getString("Saisissez le mail: ");
				db.sql("call create_personne(" + nom + ", " + prenom + ", " + mail + ")");
			}
		}));
		// Afficher les personnes
		menuPersonne.ajoute(new Option("Afficher les personnes", "i", new Action() {
			public void optionSelectionnee() {
				db.sql("call affPersonnes()");
			}
		}));
		
		/*
		 * 
		 */
		
		// menu Equipe
		Menu menuEquipe = new Menu("Equipes", "d");
		menuEquipe.ajouteRevenir("r");
		// Ajouter une personne dans l'équipe
		menuEquipe.ajoute(new Option("Ajouter une personne dans une équipe", "a", new Action() {
			public void optionSelectionnee() {
				int idCandidat = utilitaires.EntreesSorties.getInt("Saisissez l'id du candidat qui rejoindra l'équipe: ");
				int idEquipe = utilitaires.EntreesSorties.getInt("Saisissez l'id de l'équipe: ");
				db.sql("call ajoutPers(" + idCandidat + ", " + idEquipe + ")");
			}
		}));
		// Supprime une équipe
		menuEquipe.ajoute(new Option("Supprimer une équipe", "b", new Action() {
			public void optionSelectionnee() {
				int idEquipe = utilitaires.EntreesSorties.getInt("Saisissez l'id de l'équipe: ");
				db.sql("call delete_equipe(" + idEquipe + ")");
			}
		}));
		// Afficher les membres de l'équipe
		menuEquipe.ajoute(new Option("Afficher les membres d'une équipe", "c", new Action() {
			public void optionSelectionnee() {
				int idEquipe = utilitaires.EntreesSorties.getInt("Saisissez l'id de l'équipe: ");
				db.sql("call retourPersonneEquipe(" + idEquipe + ")");
			}
		}));
		// Supprimer un membre de l'équipe
		menuEquipe.ajoute(new Option("Supprimer un membre de l'équipe", "d", new Action() {
			public void optionSelectionnee() {
				int idEquipe = utilitaires.EntreesSorties.getInt("Saisissez l'id de l'équipe: ");
				int idPers = utilitaires.EntreesSorties.getInt("Saisissez l'id de la personne: ");
				db.sql("call supprMembrEq(" + idEquipe + ", " + idPers + ")");
			}
		}));
		// créer une équipe
		menuEquipe.ajoute(new Option("Créer une équipe", "e", new Action() {
			public void optionSelectionnee() {
				String nom = utilitaires.EntreesSorties.getString("Saisissez le nom de la nouvelle équipe: ");
				db.sql("call create_equipe(" + nom + ")");
			}
		}));
		// Affiche les équipes
		menuEquipe.ajoute(new Option("Afficher les équipes", "f", new Action() {
			public void optionSelectionnee() {
				db.sql("call affEquipes()");
			}
		}));
		
		
		
		// Ajout au menu princpal
		menuPrincipal.ajoute(menuCandidat);
		menuPrincipal.ajoute(menuCompetition);
		menuPrincipal.ajoute(menuPersonne);
		menuPrincipal.ajoute(menuEquipe);
		menuPrincipal.ajouteQuitter("q");
		
		menuPrincipal.start();
		
		try
		{
			inscriptions.sauvegarder();
		} 
		catch (IOException e)
		{
			System.out.println("Sauvegarde impossible." + e);
		}
	}
}
