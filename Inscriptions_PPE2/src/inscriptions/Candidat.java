package inscriptions;

import java.io.Serializable;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

import DB.Requete;

/**
 * Candidat à un événement sportif, soit une personne physique, soit une équipe.
 *
 */

public abstract class Candidat implements Comparable<Candidat>, Serializable
{
	private static final long serialVersionUID = -6035399822298694746L;
	private Inscriptions inscriptions;
	private int id;
	private String nom;
	private Set<Competition> competitions;
	
	Candidat(Inscriptions inscriptions, int id, String nom)
	{
		this.inscriptions = inscriptions;
		this.id = id;
		this.nom = nom;
		competitions = new TreeSet<>();
	}
	
	/**
	 * Retourne l'ID du candidat.
	 * @return
	 */
	
	public int getId()
	{
		return id;
	}

	/**
	 * Retourne le nom du candidat.
	 * @return
	 */
	
	public String getNom()
	{
		return nom;
	}

	/**
	 * Modifie le nom du candidat.
	 * @param nom
	 */
	
	public void setNom(String nom)
	{
		Requete r = new Requete();
		r.modifierNomCandidat(id, nom);
		
		this.nom = nom;
	}

	/**
	 * Retourne toutes les compétitions auxquelles ce candidat est inscrit.s
	 * @return
	 */

	public Set<Competition> getCompetitions()
	{
		return Collections.unmodifiableSet(competitions);
	}
	
	boolean add(Competition competition)
	{
		return competitions.add(competition);
	}

	boolean remove(Competition competition)
	{
		return competitions.remove(competition);
	}

	/**
	 * Supprime un candidat de l'application.
	 */
	
	public void delete()
	{
		Requete r = new Requete();
		r.supprimerCandidat(id);
		
		for (Competition c : competitions)
			c.remove(this);
		inscriptions.remove(this);
	}
	
	@Override
	public int compareTo(Candidat o)
	{
		return getNom().compareTo(o.getNom());
	}
	
	@Override
	public String toString()
	{
		return "\n" + getNom() + " -> inscrit à " + getCompetitions();
	}
}
