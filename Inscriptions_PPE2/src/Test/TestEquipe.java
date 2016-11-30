package Test;

import org.junit.Test;

import inscriptions.Equipe;
import inscriptions.Inscriptions;
import inscriptions.Personne;
import junit.framework.TestCase;

public class TestEquipe extends TestCase {
	
	Inscriptions i3 = Inscriptions.getInscriptions();
	Equipe e1 = i3.createEquipe("Equipe 1");
	Personne p1 = i3.createPersonne("Wayne", "Bruce", "bruce.wayne@mail.com");
	
	protected void setUp() throws Exception {
		super.setUp();
		i3 = Inscriptions.getInscriptions();
		e1 = i3.createEquipe("Equipe 1");
		p1 = i3.createPersonne("Wayne", "Bruce", "bruce.wayne@mail.com");
	}

	@Test
	public void testDelete() {
		e1.delete();
		assertEquals(i3.getEquipes().toString(), "[]");
	}

	@Test
	public void testToString() {
		assertEquals(e1.toString(), "Equipe \nEquipe 1 -> inscrit à []");
	}

	@Test
	public void testGetMembres() {
		assertEquals(e1.getMembres().toString(), "[]");
	}

	@Test
	public void testAddPersonne() {
		e1.add(p1);
		assertEquals(e1.getMembres().toString(), "[\nWayne -> inscrit à [] membre de ["+e1.toString()+"]]");
	}

	@Test
	public void testRemovePersonne() {
		e1.add(p1);
		e1.remove(p1);
		assertEquals(e1.getMembres().toString(), "[]");
	}

}
