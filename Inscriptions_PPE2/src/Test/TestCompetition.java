package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import inscriptions.Competition;
import inscriptions.Equipe;
import inscriptions.Inscriptions;
import junit.framework.TestCase;

public class TestCompetition extends TestCase{
	
	Inscriptions i = Inscriptions.getInscriptions();
	Competition c = i.createCompetition("Nom de la compet'", null, false);
	Equipe e = i.createEquipe("Nom Equipe");
	
	protected void setUp() throws Exception {
		super.setUp();
		Inscriptions i = Inscriptions.getInscriptions();
		Competition c = i.createCompetition("Nom de la compet'", null, false);
		Equipe e = i.createEquipe("Nom Equipe");
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
		assertEquals(c.getCandidats(), null);
	}

	@Test
	public void testAddPersonne() {
		c.add(e);
		assertEquals(c.getCandidats(), e);
	}

	@Test
	public void testAddEquipe() {
		
	}

	@Test
	public void testRemove() {
		
	}

	@Test
	public void testDelete() {
		
	}

	@Test
	public void testCompareTo() {
		
	}

	@Test
	public void testToString() {
		assertEquals(c.toString(), "Nom de la compet'");
	}

}
