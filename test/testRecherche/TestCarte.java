package testRecherche;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import carte.Carte;
import carte.Case;

class TestCarte {
	
	private static final int tailleX =30;
	private static final int tailleY =30;

	@Test
	void testCarteString() {
		fail("Not yet implemented");
	}

	@Test
	void testCarteCaseArrayArray() {
		fail("Not yet implemented");
	}

	@Test
	void testEnregistrerMap() {
		fail("Not yet implemented");
	}

	@Test
	void testGetCase() {
		Carte test;
		//tableau correspondant a test
		Case cases[][] = new Case[tailleX][tailleY];//
		int y=0,x=0;
		while(y<tailleY) {
			while(x<tailleX) {
				cases[x][y]= new Case(x,y);
				x=x+1;
			}
			x=0;
			y=y+1;
		}
		
		test = new Carte(cases);		
		assertEquals(test.getCase(),cases);
	}

	@Test
	void testSetCase() {
		Carte test;
		//tableau correspondant a test
		Case cases[][] = new Case[tailleX][tailleY];//
		int y=0,x=0;
		while(y<tailleY) {
			while(x<tailleX) {
				cases[x][y]= new Case(x,y);
				x=x+1;
			}
			x=0;
			y=y+1;
		}
		
		test = new Carte(cases);
		
		Case casesDeRemplacement[][] = new Case[tailleX][tailleY];//
		x=0;y=0;
		while(y<tailleY) {
			while(x<tailleX) {
				casesDeRemplacement[x][y]= new Case(x,y,0);
				x=x+1;
			}
			x=0;
			y=y+1;
		}
		
		c.set
		assertEquals(test.getCase(),cases);
	}

}
