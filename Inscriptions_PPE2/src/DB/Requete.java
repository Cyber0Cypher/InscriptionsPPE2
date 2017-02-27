package DB;

public class Requete {
	
	Connect db = new Connect();
	
	public void deleteCandidat(int idCandidat) {
		db.sql("call deleteCandidat(" + idCandidat + ")");
	}
	
	public void competitionCandidat(int idCandidat) {
		db.sql("call competitionCandidat(" + idCandidat + ")");
	}
	
	public void nomCandidat(int idCandidat) {
		db.sql("call nomCandidat(" + idCandidat + ")");
	}
	
	public void renommerCandidat(int idCandidat, String nomCandidat) {
		db.sql("call renommerCandidat(" + idCandidat + ", \"" + nomCandidat +"\")");
	}
	
	public void getCandidat() {
		db.sql("call getCandidat()");
	}
	
	public void ajouterEquipeACompetition(int idEquipe, int idCompetition) {
		db.sql("call ajouterEquipeACompetition(" + idEquipe + ", " + idCompetition + ")");
	}
	
	public void ajouterPersonneACompetition(int idPersonne, int idCompetition) {
		db.sql("call ajouterPersonneACompetition(" + idPersonne + ", " + idCompetition + ")");
	}
	
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
	
	public void desinscritCandidat(int idCandidat,int idCompetition) {
		db.sql("call desinscritCandidat(" + idCandidat + ", " + idCompetition + ")");
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
	
	public void supprimerCandidat(int idPersonne) {
		db.sql("call supprimerCandidat(" + idPersonne + ")");
	}
	
	public void retourCandidatEquipe(int idPersonne) {
		db.sql("call retourCandidatEquipe(" + idPersonne + ")");
	}
	
	public void retourMail(int idPersonne) {
		db.sql("call retourMail(" + idPersonne + ")");
	}
	
	public void retourPrenom(int idPersonne) {
		db.sql("call retourPrenom(" + idPersonne + ")");
	}
	
	public void renommerPersonne(int idPersonne, String nom) {
		db.sql("call renommerPersonne(" + idPersonne + ",\"" + nom +"\")");
	}
	
	public void changerMail(int idPersonne, String mail) {
		db.sql("call changerMail(" + idPersonne + ", \"" + mail + "\")");
	}
	
	public void creerPersonne(String nom, String prenom, String mail) {
		db.sql("call creerPersonne(" + nom + ", " + prenom + ", " + mail + ")");
	}
	
	public void getPersonne() {
		db.sql("call getPersonne()");
	}
	
	public void ajouterPersonne(int idCandidat, int idEquipe) {
		db.sql("call ajouterPersonne(" + idCandidat + ", " + idEquipe + ")");
	}
	
	public void retourPersonneEquipe(int idEquipe) {
		db.sql("call retourPersonneEquipe(" + idEquipe + ")");
	}
	
	public void supprimerMembreEquipe(int idEquipe, int idPersonne) {
		db.sql("call supprimerMembreEquipe(" + idEquipe + ", " + idPersonne + ")");
	}
	
	public void creerEquipe(String nom) {
		db.sql("call creerEquipe(\"" + nom + "\")");
	}
	
	public void getEquipe() {
		db.sql("call getEquipe()");
	}
}
