package Test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.SortedSet;

import org.junit.Test;

import inscriptions.Candidat;
import inscriptions.Competition;
import inscriptions.Inscriptions;
import inscriptions.Personne;

public class TestCandidat {
	
	Inscriptions i = Inscriptions.getInscriptions();
	SortedSet<Candidat> can = i.getCandidats();
	Personne p = i.createPersonne("Riviere", "Jean", "jean.riviere@mail.com");
	Personne p2 = i.createPersonne("Dupont", "Michel", "michel.dupont@mail.com");
	Competition c = i.createCompetition("Competition 1", LocalDate.of(2020, 1, 1), false);

	@Test
	public void testGetNom() {
		c.add(p);
		assertEquals(can.last().getNom(), "Riviere");
	}

	@Test
	public void testSetNom() {
		c.add(p);
		can.last().setNom("Robert");
		assertEquals(can.last().getNom(), "Robert");
	}

	@Test
	public void testGetCompetitions() {
		assertNotNull(i.getCompetitions());
	}

	@Test
	public void testDelete() {
		c.add(p);
		c.add(p2);
		can.last().delete();
		assertEquals(i.getCandidats().toString(), "["+can.last()+"]");
	}

	@Test
	public void testCompareTo() {
		c.add(p);
		c.add(p2);
		assertEquals(can.first().compareTo(can.first()), can.last().compareTo(can.last()));
	}

	@Test
	public void testToString() {
		assertEquals(can.last().toString(), "\nRiviere -> inscrit à [] membre de []");
	}

}
