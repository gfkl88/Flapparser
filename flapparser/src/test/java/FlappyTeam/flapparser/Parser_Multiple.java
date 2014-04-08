package FlappyTeam.flapparser;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import flappyteam.flapparser.Multiple;
import flappyteam.flapparser.Reponse;

public class Parser_Multiple {
	
	protected Multiple p;

	@Before
	public void setUp() throws Exception {
		p = new Multiple("+ Clojure. - Java. + Groovy. - Scala.");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMultiple() {
		p.parser();
		Reponse reponse1 = p.getListeReponses().get(0);
		Reponse reponse2 = p.getListeReponses().get(1);
		Reponse reponse3 = p.getListeReponses().get(2);
		Reponse reponse4 = p.getListeReponses().get(3);
		
		assertTrue(reponse1.getLibele().equals("Clojure"));
		assertTrue(reponse2.getLibele().equals("Java"));
		assertTrue(reponse3.getLibele().equals("Groovy"));
		assertTrue(reponse4.getLibele().equals("Scala"));

	}

}
