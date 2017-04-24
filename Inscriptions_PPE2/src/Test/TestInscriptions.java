package Test;

import java.util.SortedSet;

import org.junit.Test;

import inscriptions.Candidat;
import inscriptions.Competition;
import inscriptions.Equipe;
import inscriptions.Inscriptions;
import inscriptions.Personne;
import junit.framework.TestCase;

public class TestInscriptions extends TestCase {
	
	Inscriptions i = Inscriptions.getInscriptions();
	Competition compet = i.createCompetition(1,"Competition 1", null, true);
	Personne p1 = i.createPersonne(1,"Wayne", "Bruce", "bruce.wayne@mail.com");
	Equipe e1 = i.createEquipe(1,"Equipe 1");
	SortedSet<Candidat> c1 = i.getCandidats();
	
	protected void setUp() throws Exception {
		super.setUp();
		i = Inscriptions.getInscriptions();
		compet = i.createCompetition(1,"Competition 1", null, true);
		p1 = i.createPersonne(1,"Wayne", "Bruce", "bruce.wayne@mail.com");
		e1 = i.createEquipe(1,"Equipe 1");
		c1 = i.getCandidats();
	}
	
	
	@Test
	public void testGetCompetitions() {
		assertEquals(i.getCompetitions().toString(), "["+compet.toString()+"]");
	}

	@Test
	public void testGetCandidats() {
		assertEquals(i.getCandidats().toString(), c1.toString());
	}

	@Test
	public void testGetPersonnes() {
		assertEquals(i.getPersonnes().toString(), "["+p1.toString()+"]");
	}

	@Test
	public void testGetEquipes() {
		assertEquals(i.getEquipes().toString(), "["+e1.toString()+"]");
	}

	@Test
	public void testCreateCompetition() {
		Competition compet2 = i.createCompetition(2,"Competition 2", null, true);
		compet.delete();
		assertEquals(i.getCompetitions().toString(), "["+compet2.toString()+"]");
		compet2.delete();
	}

	@Test
	public void testCreatePersonne() {
		Personne p2 = i.createPersonne(2,"Claude", "Jean", "jean.claude@mail.com");
		p1.delete();
		assertEquals(i.getPersonnes().toString(), "["+p2.toString()+"]");
		p2.delete();
	}

	@Test
	public void testCreateEquipe() {
		e1.delete();
		Equipe e1 = i.createEquipe(2,"Equipe 1");
		assertEquals(i.getEquipes().toString(), "["+e1.toString()+"]");
	}

	@Test
	public void testGetInscriptions() {
		assertEquals(Inscriptions.getInscriptions().toString(), i.toString());
	}

	@Test
	public void testReinitialiser() {
		Inscriptions i2 = i.reinitialiser();
		assertEquals(i.reinitialiser().toString(), i2.toString());
	}

//	@Test
//	public void testRecharger() {
//		i.recharger();
//		assertEquals(i.recharger().toString(),i.toString());
//		
//	}
//
//	@Test
//	public void testSauvegarder() {
//		try {
//			i.sauvegarder();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		assertEquals(i.recharger().toString(),i.toString());
//		
//	}

	@Test
	public void testToString() {
		assertEquals(i.toString(), "Candidats : [Equipe \nEquipe 1 -> inscrit à [], \nWayne -> inscrit à [] membre de []]\nCompetitions  [Competition 1]");
	}

}
