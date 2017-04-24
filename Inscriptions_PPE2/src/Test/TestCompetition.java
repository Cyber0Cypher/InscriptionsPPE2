package Test;

import java.time.LocalDate;
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
	Competition c = i.createCompetition(1,"Competition 1", LocalDate.of(2020, 1, 1), false);
	Equipe e = i.createEquipe(1,"Nom Equipe");
	Personne p = i.createPersonne(1,"Claude", "Jean", "jean.claude@mail.com");
	SortedSet<Candidat> can = i.getCandidats();
	
	protected void setUp() throws Exception {
		super.setUp();
		c = i.createCompetition(1,"Competition 1", LocalDate.of(2020, 1, 1), false);
		e = i.createEquipe(1,"Nom Equipe");
		p = i.createPersonne(1,"Claude", "Jean", "jean.claude@mail.com");
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
		assertEquals(c.getDateCloture(),LocalDate.of(2020, 1, 1));
	}

	@Test
	public void testEstEnEquipe() {
		assertEquals(c.estEnEquipe(),false);
	}

	@Test
	public void testSetDateCloture() {
		c.setDateCloture(LocalDate.of(2021, 1, 1));
		assertEquals(c.getDateCloture(),LocalDate.of(2021, 1, 1));
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
		Competition c2 = i.createCompetition(2,"Nom de la compet'", LocalDate.of(2020, 1, 1), true);
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
		Competition c2 = i.createCompetition(2,"Nom de la compet'", null, true);
		c.compareTo(c2);
	}

	@Test
	public void testToString() {
		assertEquals(c.toString(), "Competition 1");
	}

}
