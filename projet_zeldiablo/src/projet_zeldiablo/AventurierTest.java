package projet_zeldiablo;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class AventurierTest {
	
	@Test
	/**
	 * Test qui vérfie si un aventurier se construit correctement
	 */
	public void testAventurierBon() {
		Case c = new Case(9,9);
		assertEquals("La case doit etre vide", c.getEtat(),0 );
		Aventurier a = new Aventurier(c);
		a.subirDegat(1);
		assertEquals("L'aventurier devrait avoir 499 points de vie",499, a.getVie() );
		assertEquals("L'aventurier à 10 points de dégats",40, a.getDegat());
		assertEquals("La case ne prends pas en compte l'aventurier", c.getEtat(),Case.AVENT );
	}
	@Test
	/**
	 * Test qui vérifie si un un aventurier attaque de façon correct
	 */
	
	public void testAventurierAttaque() {
		Labyrinthe l = new Labyrinthe(10);
		Case c=  new Case(9,9);
		Case c2 = new Case (9,8);
		Aventurier a = new Aventurier(c);
		Monstre m = new Gnome(c2);
		a.attaquer(l,false);
		assertEquals("Le monstre ne perds pas de vie car il ne sont pas sur le même labyrinthe",100 ,m.getVie() );
		
		l.getAvent().modifierCoords(l.getCase(2, 5));
		l.getAvent().attaquer(l);
		Monstre f = l.getMonstre()[10];
		assertEquals("Le monstre devrait avoir 160 points de vie",160 ,f.getVie());
		
		l.getAvent().modifierCoords(l.getCase(0, 4));
		f.modifierCoords(l.getCase(0, 5));
		l.getAvent().attaquer(l, true);
		assertEquals("Le monstre devrait avoir 120 points de vie",120 ,f.getVie());
		assertEquals("Le monstre devrait être sur la case 0/9",l.getCase(0, 9) ,f.getC());
	}
	@Test
	
	/**
	 * Test qui vérifie si un aventurier peut se régénerer 
	 * 
	 */
	public void testRegenererAventurier() {
		Case c=new Case(1,1);
		Aventurier a=new Aventurier(c);
		a.subirDegat(30);
		a.regenererAventurier(10);
		assertEquals("l'aventurier  devrait avoir 480 pv ",480,a.getVie());
	}
	@Test
	
	/**
	 * Test qui vérifie si la méthode repousser fonctionne bien 
	 */
	public void testRepousser() {
		Labyrinthe l = new Labyrinthe(10);
		l.getAvent().modifierCoords(l.getCase(2, 5));
		l.getAvent().attaquer(l, true);
		Monstre f = l.getMonstre()[10];
		assertEquals("Le monstre devrait être sur la case 0/9",l.getCase(0, 5) ,f.getC());
		assertEquals("Le monstre devrait avoir 160 points de vie",160 ,f.getVie());
	}
	/**
	 * Test qui verifie si l'aventurier peut se déplacer correctement
	 */
	
	public void testEstDisponibleBonAventurier() {
		Labyrinthe l = new Labyrinthe(10);
		assertEquals("La case devrait être accessible",true,l.getAvent().estDisponible(6, 9, l.getCases()) );
		assertEquals("La case devrait ne pas être accessible",false,l.getAvent().estDisponible(11, 9, l.getCases()) );
		assertEquals("La case devrait ne pas être accessible",false,l.getAvent().estDisponible(9, 9, l.getCases()) );
		assertEquals("La case devrait ne pas être accessible",false,l.getAvent().estDisponible(6, 8, l.getCases()) );
	}


	
}
