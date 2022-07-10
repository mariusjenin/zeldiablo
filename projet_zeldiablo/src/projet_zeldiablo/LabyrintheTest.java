package projet_zeldiablo;

import static org.junit.Assert.*;

import org.junit.Test;

public class LabyrintheTest {

	/**
	 * test si un labyrinthe est correctment construit
	 */
	@Test
	public void testLabyrinthe_vide() {
		Labyrinthe test = new Labyrinthe(10);
		assertEquals("Il devrait y avoir 100 cases en tout", 100, test.getLargeur() * test.getLargeur());
		assertEquals("La case 0,0 devrait être un mur", 1, test.getCase(0, 0).getEtat());
		assertEquals("La case 3,0 devrait être vide", 0, test.getCase(3, 0).getEtat());
		assertEquals("La case 5,10 devrait être l'aventurier", 2, test.getCase(5, 9).getEtat());
	}

	/**
	 * test les deplacements de l'aventurier dans le labyrinthe
	 */
	@Test
	public void testLabyrinthe_DeplacementAventurier() {
		Labyrinthe test = new Labyrinthe(10);
		test.seDeplacer("s");
		assertEquals("L'aventurier n'aurait pas du bouger", test.getCase(5, 9), test.getAvent().getC());
		test.seDeplacer("n");
		assertEquals("L'aventurier devrait se trouver plus au nord", test.getCase(5, 8), test.getAvent().getC());
		test.seDeplacer("s");
		assertEquals("L'aventurier devrait être retourner au départ", test.getCase(5, 9), test.getAvent().getC());
		test.seDeplacer("o");
		assertEquals("L'aventurier devrait se trouver plus à l'ouest", test.getCase(4, 9), test.getAvent().getC());
		test.seDeplacer("e");
		assertEquals("L'aventurier devrait se trouver plus à l'est", test.getCase(5, 9), test.getAvent().getC());
		test.seDeplacer("o");
		test.seDeplacer("o");
		assertEquals("L'aventurier n'aurait pas du traverser le mur", test.getCase(4, 9), test.getAvent().getC());
	}

}
