package DB;

import java.time.LocalDate;
import java.util.ArrayList;

public class Requete {
	
	private Connect db;
	
	public Requete() {
		db = new Connect();
	}
	
	/* COMPETITION */
	
	public void supprimerCompetition(int idCompetition) {
		db.sql("call supprimerCompetition(" + idCompetition + ")");
	}
	
	public ArrayList<ArrayList<String>> candidatsInscritsCompetition(int idCompetition) {
		return db.get("call candidatsInscritsCompetition(" + idCompetition + ")");
	}
	
	public String dateClotureInscription(int idCompetition) {
		return db.select("call dateClotureInscription("+ idCompetition +")");
	}
	
	public String nomCompetition(int idCompetition) {
		return db.select("call nomCompetition(" + idCompetition + ")");
	}
	
	public String inscriptionsOuvertes(int idCompetition) {
		return db.select("select inscriptionsOuvertes(" + idCompetition + ");");
	}
	
	public String enEquipe(int idCompetition) {
		return db.select("call enEquipe(" + idCompetition + ")");
	}
	
	public void desinscrireCandidat(int idCandidat,int idCompetition) {
		db.sql("call desinscrireCandidat(" + idCandidat + ", " + idCompetition + ")");
	}
	
	public void ajouterCandidatCompetition(int idCandidat,int idCompetition) {
		db.sql("call ajouterCandidatCompetition(" + idCandidat + ", " + idCompetition + ")");
	}
	
	public void modifierDateCloture(int idCompetition, LocalDate dateCloture) {
		db.sql("call modifierDateCloture(" + idCompetition + ",\"" + dateCloture +"\" )");
	}
	
	public void modifierNomCompetition(int idCompetition, String nom) {
		db.set("call modifierNomCompetition(" + idCompetition + ",'"+ nom +"' )");
	}
	
	public void creerCompetition(String nom, String date, boolean enEquipe) {
		db.set("call creerCompetition('" + nom +"', '" + date +"', " + enEquipe +")");
	}
	
	public ArrayList<ArrayList<String>> getCompetition() {
		return db.get("call getCompetition()");
	}
	
	// Récupère la valeur de l'auto-incrémentation
	public ArrayList<ArrayList<String>> getAICompetition() {
		return db.get("call getAICompetition()");
	}
	
	/* PERSONNE */
	
	public void supprimerCandidat(int i) {
		db.set("call supprimerCandidat(" + i + ")");
	}
	
	public ArrayList<ArrayList<String>> getEquipePersonne(int idPersonne) {
		return db.get("call getEquipePersonne(" + idPersonne + ")");
	}
	
	public String getMail(int idPersonne) {
		return db.select("call getMail(" + idPersonne + ")");
	}
	
	public String getPrenom(int idPersonne) {
		return db.select("call getPrenom(" + idPersonne + ")");
	}
	
	public String getNom(int idPersonne) {
		return db.select("call getNom(" + idPersonne + ")");
	}
	
	public void modifierNomCandidat(int idPersonne,String nom) {
		db.set("call modifierNomCandidat(" + idPersonne + ",'" + nom +"')");
	}
	
	public void modifierPrenom(int idPersonne,String prenom) {
		db.set("call modifierPrenom(" + idPersonne + ",'" + prenom +"')");
	}
	
	public void modifierMail(int idPersonne, String mail) {
		db.set("call modifierMail('" + idPersonne + "', '" + mail + "')");
	}
	
	public void creerPersonne(String nom, String prenom, String mail) {
		db.set("call creerPersonne('" + nom + "', '" + prenom + "', '" + mail + "')");
	}
	
	public ArrayList<ArrayList<String>> getPersonne() {
		return db.get("call getPersonne()");
	}
	
	// Récupère la valeur de l'auto-incrémentation
	public ArrayList<ArrayList<String>> getAICandidat() {
		return db.get("call getAICandidat()");
	}
	
	/* EQUIPE */ //commit
	
	public void ajouterPersonneEquipe(int idCandidat, int idEquipe) {
		db.sql("call ajouterPersonneEquipe(" + idCandidat + ", " + idEquipe + ")");
	}
	
	public ArrayList<ArrayList<String>> getPersonneEquipe(int idEquipe) {
		return db.get("call getPersonneEquipe(" + idEquipe + ")");
	}
	
	public void supprimerPersonneEquipe(int idEquipe, int idPersonne) {
		db.sql("call supprimerPersonneEquipe(" + idEquipe + ", " + idPersonne + ")");
	}
	
	public void ajouterEquipeCompetition(int idEquipe, int idCompetition){
		db.sql("call ajouterEquipeCompetition(" + idEquipe + ", " + idCompetition + ")");
	}
	
	public void creerEquipe(String nom) {
		db.set("call creerEquipe('" + nom + "')");
	}
	
	public String getAcrEquipe(int idEquipe) {
		return db.select("call getAcrEquipe("+idEquipe+")");
	}
	
	public String getNomEquipe(int idEquipe) {
		return db.select("call getNomEquipe("+idEquipe+")");
	}
	
	public String getMailEquipe(int idEquipe) {
		return db.select("call getMailEquipe("+idEquipe+")");
	}
	
	public ArrayList<ArrayList<String>> getEquipe() {
		return db.get("call getEquipe()");
	}
}
