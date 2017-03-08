package DB;

import java.util.ArrayList;

public class Requete {
	
	private Connect db;
	
	public Requete() {
		db = new Connect();
	}
	
	/* COMPETITION */
	
	public void supprimerCompetiton(int idCompetition) {
		db.sql("call supprimerCompetiton(" + idCompetition + ")");
	}
	
	public void candidatsInscritsCompetition(int idCompetition) {
		db.sql("call candidatsInscritsCompetition(" + idCompetition + ")");
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
	
	public void modifierDateCloture(int idCompetition, String date) {
		db.sql("call modifierDateCloture(" + idCompetition + ",\"" + date +"\" )");
	}
	
	public void modifierNomCompetition(int idCompetition, String nom) {
		db.sql("call modifierNomCompetition(" + idCompetition + ",\""+ nom +"\" )");
	}
	
	public void creerCompetition(String nom, String date, int enEquipe) {
		db.sql("call creerCompetition(\"" + nom +"\",\" " + date +"\", " + enEquipe +")");
	}
	
	public ArrayList<String> getCompetition() {
		return db.select("call getCompetition()",2);
	}
	
	/* PERSONNE */
	
	public void supprimerPersonne(int idPersonne) {
		db.sql("call supprimerPersonne(" + idPersonne + ")");
	}
	
	public void getEquipePersonne(int idPersonne) {
		db.sql("call getEquipePersonne(" + idPersonne + ")");
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
	
	public void renommerPersonne(int idPersonne,String prenom, String nom) {
		db.sql("call renommerPersonne(" + idPersonne + ",\"" + prenom +",\"" + nom +"\")");
	}
	
	public void modifierMail(int idPersonne, String mail) {
		db.sql("call modifierMail('" + idPersonne + "', '" + mail + "')");
	}
	
	public void creerPersonne(String nom, String prenom, String mail) {
		db.sql("call creerPersonne('" + nom + "', '" + prenom + "', '" + mail + "');");
	}
	
	public ArrayList<String> getPersonne() {
		return db.select("call getPersonne()",2,3);
	}
	
	/* EQUIPE */
	
	public void ajouterPersonneEquipe(int idCandidat, int idEquipe) {
		db.sql("call ajouterPersonneEquipe(" + idCandidat + ", " + idEquipe + ")");
	}
	
	public void getPersonneEquipe(int idEquipe) {
		db.sql("call getPersonneEquipe(" + idEquipe + ")");
	}
	
	public void supprimerPersonneEquipe(int idEquipe, int idPersonne) {
		db.sql("call supprimerPersonneEquipe(" + idEquipe + ", " + idPersonne + ")");
	}
	
	public void ajouterEquipeCompetition(int idEquipe, int idCompetition){
		db.sql("call ajouterEquipeCompetition(" + idEquipe + ", " + idCompetition + ")");
	}
	
	public void supprimerEquipe(int idEquipe) {
		db.sql("call supprimerEquipe(" + idEquipe + ")");
	}
	
	public void creerEquipe(String nom) {
		db.sql("call creerEquipe(\"" + nom + "\")");
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
	
	public ArrayList<String> getEquipe() {
		return db.select("call getEquipe()",3);
	}
}
