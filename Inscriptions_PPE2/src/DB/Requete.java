package DB;

public class Requete {
	
	Connect db = new Connect();
	
	/* COMPETITION */
	
	public void supprimerCompetiton(int idCompetition) {
		db.sql("call supprimerCompetiton(" + idCompetition + ")");
	}
	
	public void candidatsInscritsCompetition(int idCompetiton) {
		db.sql("call candidatsInscritsCompetition(" + idCompetiton + ")");
	}
	
	public void dateClotureInscriptions() {
		db.sql("call dateClotureInscriptions()");
	}
	
	public void nomCompetition(int idCompetiton) {
		db.sql("call nomCompetition(" + idCompetiton + ")");
	}
	
	public void inscriptionsOuvertes(int idCompetition) {
		db.sql("call inscriptionsOuvertes(" + idCompetition + ")");
	}
	
	public void desinscrireCandidat(int idCandidat,int idCompetition) {
		db.sql("call desinscrireCandidat(" + idCandidat + ", " + idCompetition + ")");
	}
	
	public void ajouterCandidatCompetition(int idCandidat,int idCompetition) {
		db.sql("call ajouterCandidatCompetition(" + idCandidat + ", " + idCompetition + ")");
	}
	
	public void modifierDateCloture(int idCompetiton, String date) {
		db.sql("call modifierDateCloture(" + idCompetiton + ",\"" + date +"\" )");
	}
	
	public void modifierNomCompetition(int idCompetition, String nom) {
		db.sql("call modifierNomCompetition(" + idCompetition + ",\""+ nom +"\" )");
	}
	
	public void creerCompetition(String nom, String date, int enEquipe) {
		db.sql("call creerCompetition(\"" + nom +"\",\" " + date +"\", " + enEquipe +")");
	}
	
	public void getCompetition() {
		db.sql("call getCompetition()");
	}
	
	/* PERSONNE */
	
	public void supprimerPersonne(int idPersonne) {
		db.sql("call supprimerPersonne(" + idPersonne + ")");
	}
	
	public void getEquipePersonne(int idPersonne) {
		db.sql("call getEquipePersonne(" + idPersonne + ")");
	}
	
	public void getMail(int idPersonne) {
		db.sql("call getMail(" + idPersonne + ")");
	}
	
	public void getPrenom(int idPersonne) {
		db.sql("call getPrenom(" + idPersonne + ")");
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
	
	public void getPersonne() {
		db.sql("call getPersonne();");
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
	
	public void getEquipe() {
		db.sql("call getEquipe()");
	}
}
