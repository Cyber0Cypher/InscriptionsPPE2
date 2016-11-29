package Test;

import static org.junit.Assert.*;

import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import inscriptions.Candidat;
import inscriptions.Competition;
import inscriptions.Equipe;
import inscriptions.Inscriptions;
import inscriptions.Personne;
import junit.framework.TestCase;

public class TestCompetition extends TestCase{
	
	Inscriptions i = Inscriptions.getInscriptions();
	Competition c = i.createCompetition("Nom de la compet'", null, false);
	Equipe e = i.createEquipe("Nom Equipe");
	Personne p = i.createPersonne("Claude", "Jean", "jean.claude@mail.com");
	Set<Candidat> candidats = new TreeSet<Candidat>();
	
	protected void setUp() throws Exception {
		super.setUp();
		Competition c = i.createCompetition("Nom de la compet'", null, false);
		Equipe e = i.createEquipe("Nom Equipe");
		Personne p = i.createPersonne("Claude", "Jean", "jean.claude@mail.com");
		Set<Candidat> candidats = new TreeSet<Candidat>();
	}

	@Test
	public void testCompetition() {
		
	}

	@Test
	public void testGetNom() {
		assertEquals(c.getNom(), "Nom de la compet'");
	}

	@Test
	public void testSetNom() {
		c.setNom("Nom de la compet 2");
		assertEquals(c.getNom(), "Nom de la compet 2");
	}

	@Test
	public void testInscriptionsOuvertes() {
		assertEquals(c.inscriptionsOuvertes(), false);
	}

	@Test
	public void testGetDateCloture() {
		assertEquals(c.getDateCloture(),null);
	}

	@Test
	public void testEstEnEquipe() {
		assertEquals(c.estEnEquipe(),false);
	}

	@Test
	public void testSetDateCloture() {
		c.setDateCloture(null);
		assertEquals(c.getDateCloture(), null);
	}

	@Test
	public void testGetCandidats() {
		candidats.add(p);
		assertNotNull(c.getCandidats());
	}

	@Test
	public void testAddPersonne() {
		c.add(p);
		assertNotNull(i.getPersonnes());
	}

	@Test
	public void testAddEquipe() {
		Competition c2 = i.createCompetition("Nom de la compet'", null, true);
		c2.add(e);
		assertNotNull(i.getEquipes());
	}

	@Test
	public void testRemove() {
		c.remove(p);
		assertEquals(c.getCandidats(), null);
	}

	@Test
	public void testDelete() {
		c.delete();
		assertEquals(i.getCompetitions(), null);
	}

	@Test
	public void testCompareTo() {
		
	}

	@Test
	public void testToString() {
		assertEquals(c.toString(), "Nom de la compet'");
	}

}
