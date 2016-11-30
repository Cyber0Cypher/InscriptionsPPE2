package Test;

import org.junit.Test;

import inscriptions.Inscriptions;
import inscriptions.Personne;
import junit.framework.TestCase;

public class TestPersonne extends TestCase {
	
	Inscriptions i = Inscriptions.getInscriptions();
	Personne p1 = i.createPersonne("Wayne", "Bruce", "bruce.wayne@mail.com");
	
	protected void setUp() throws Exception {
		super.setUp();
		i = Inscriptions.getInscriptions();
		p1 = i.createPersonne("Wayne", "Bruce", "bruce.wayne@mail.com");
	}

	@Test
	public void testDelete() {
		p1.delete();
		assertEquals(i.getPersonnes().toString(), "[]");
	}

	@Test
	public void testToString() {
		assertEquals(p1.toString(), "\nWayne -> inscrit à [] membre de []");
	}

	@Test
	public void testGetPrenom() {
		assertEquals(p1.getPrenom(), "Bruce");
	}

	@Test
	public void testSetPrenom() {
		p1.setPrenom("Jack");
		assertEquals(p1.getPrenom(), "Jack");
	}

	@Test
	public void testGetMail() {
		assertEquals(p1.getMail(), "bruce.wayne@mail.com");
	}

	@Test
	public void testSetMail() {
		p1.setMail("jack.wayne@mail.com");
		assertEquals(p1.getMail(), "jack.wayne@mail.com");
	}

	@Test
	public void testGetEquipes() {
		assertEquals(p1.getEquipes().toString(), "[]");
	}

}
