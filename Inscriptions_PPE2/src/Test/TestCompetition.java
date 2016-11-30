package Test;

import java.util.SortedSet;

import org.junit.Test;

import inscriptions.Candidat;
import inscriptions.Competition;
import inscriptions.Equipe;
import inscriptions.Inscriptions;
import inscriptions.Personne;
import junit.framework.TestCase;

public class TestCompetition extends TestCase{
	
	Inscriptions i = Inscriptions.getInscriptions();
	Competition c = i.createCompetition("Competition 1", null, false);
	Equipe e = i.createEquipe("Nom Equipe");
	Personne p = i.createPersonne("Claude", "Jean", "jean.claude@mail.com");
	SortedSet<Candidat> can = i.getCandidats();
	
	protected void setUp() throws Exception {
		super.setUp();
		c = i.createCompetition("Competition 1", null, false);
		e = i.createEquipe("Nom Equipe");
		p = i.createPersonne("Claude", "Jean", "jean.claude@mail.com");
		can = i.getCandidats();
	}

	@Test
	public void testCompetition() {
		
	}

	@Test
	public void testGetNom() {
		assertEquals(c.getNom(), "Competition 1");
	}

	@Test
	public void testSetNom() {
		c.setNom("Nom de la compet 2");
		assertEquals(c.getNom(), "Nom de la compet 2");
	}

	@Test
	public void testInscriptionsOuvertes() {
		assert(c.inscriptionsOuvertes());
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
		assertNotNull(c.getCandidats());
	}

	@Test
	public void testAddPersonne() {
		c.add(p);
		assertNotNull(c.getCandidats());
	}

	@Test
	public void testAddEquipe() {
		Competition c2 = i.createCompetition("Nom de la compet'", null, true);
		c2.add(e);
		assertNotNull(i.getEquipes());
		c2.delete();
	}

	/*@Test
	public void testRemove() {
		c.remove(can.last());
		assertEquals(i.getCandidats(), "[]");
	}*/

	@Test
	public void testDelete() {
		c.delete();
		assertNotSame(i.getCompetitions(), "[Competition 1]");
	}

	@Test
	public void testCompareTo() {
		Competition c2 = i.createCompetition("Nom de la compet'", null, true);
		c.compareTo(c2);
	}

	@Test
	public void testToString() {
		assertEquals(c.toString(), "Competition 1");
	}

}
