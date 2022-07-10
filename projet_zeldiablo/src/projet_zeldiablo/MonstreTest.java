package projet_zeldiablo;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MonstreTest {
	// assertEquals("",, );

	@Test
	
	/**
	 * Test qui vérifie si un gnome se construit correctement
	 */
	
	public void testMonstreGnome() {
		Case c = new Case(1,1,10);
		Gnome g = new Gnome(c);
		assertEquals("La vie du gnome devrait valoir 100", g.getVie(), 100);
		assertEquals("La case du gnome devrait valoir 10",10, c.getEtat());
	}
	
	@Test
	
	/**
	 * Test qui vérifie si un Colosse se construit correctement
	 */
	
	public void testMonstreColosse() {
		Case c = new Case(1,1,14);
		Colosse g = new Colosse(c);
		assertEquals("La vie du Colosse devrait valoir 100", g.getVie(), 1000);
		assertEquals("La case du Colosse devrait valoir 14",14, c.getEtat());
	}

	@Test
	
	/**
	 * Test qui vérifie si un Fantome se construit correctement
	 */
	
	public void testMonstreFantome() {
		Case c = new Case(1,1,11);
		Fantome g = new Fantome(c);
		assertEquals("La vie du Fantome devrait valoir 100", g.getVie(), 200);
		assertEquals("La case du Fantome devrait valoir 11",11, c.getEtat());
		
		Case c2 = new Case(1,1,12);
		Fantome g2 = new Fantome(c);
		assertEquals("La vie du Fantome devrait valoir 100", g2.getVie(), 200);
		assertEquals("La case du Fantome devrait valoir 12",12, c2.getEtat());
	}

	@Test
	
	/**
	 * Test qui vérifie si un Troll se construit correctement
	 */
	
	public void testMonstreTroll() {
		Case c = new Case(1,1,13);
		Troll g = new Troll(c);
		assertEquals("La vie du Troll devrait valoir 100", g.getVie(), 500);
		assertEquals("La case du Troll devrait valoir 13",13, c.getEtat());
	}
	
	@Test
	
	/**
	 * Test qui verifie si les monstres subissent des dégats
	 */
	
	public void testDegat() {
		Case c = new Case (1,1);
		Gnome g=  new Gnome(c);
		Gnome g2=  new Gnome(c);
		g.subirDegat(10);
		assertEquals("Le gnome doit avoir 90 points de vie",90,g.getVie() );
		g.subirDegat(90);
		assertEquals("Le gnome doit être mort",true ,g.etreMort() );
		assertEquals("Le gnome g2 ne doit pas subir de degats", 100, g2.getVie());
		
		g2.subirDegat(-10);
		assertEquals("Le gnome doit subir 10 de dégats lorsqu'il subit des dégats négatifs", 90, g2.getVie());
		assertEquals("Le gnome2 doit etre en vie",false,g2.etreMort());
	}
	@Test
	
	/**
	 * Test qui vérifie si les monstres peuvent attaquer un joueur
	 */
	
	public void testAttaquer() {
		Labyrinthe l = new Labyrinthe(10);
		l.seDeplacer("e");
		assertEquals("L'aventurier devrait se trouver plus à l'est", l.getCase(6, 9), l.getAvent().getC());
		l.seDeplacer("e");
		l.seDeplacer("e");
		for(int i=0;i<l.getMonstre().length;i++) {
			l.getMonstre()[i].attaquer(l);
		}
		assertEquals("le joueur doit perdre de la vie", l.getAvent().getVie(), 490);
		
		l.getMonstre()[0].attaquer(l);
		assertEquals("le joueur ne perd pas de vie", l.getAvent().getVie(), 490);
		
	}
	
	/**
	 * Test qui vérifie si un troll se régénere correctement
	 */
	
	public void testRegenererTroll() {
		Case c=new Case(1,1);
		Troll tr=new Troll(c);
		tr.subirDegat(30);
		tr.regenererTroll(10);
		assertEquals("le troll devrait avoir 80 pv ",80,tr.getVie());
	}
	/**
	 * Test qui verifie si les monstres peuvent atteindres les bonnes cases
	 */
	
	public void testEstDisponibleBon() {
		Labyrinthe l = new Labyrinthe(10);
		 assertEquals("La case est un echelle, non disponible pour les monstres",false ,l.getMonstre()[1].estDisponible(5, 0, l.getCases()));
		 assertEquals("La case est disponbile pour les monstres",true ,l.getMonstre()[1].estDisponible(8, 9, l.getCases()));
		 assertEquals("La case est occupé par un joueur",false ,l.getMonstre()[1].estDisponible(5, 9, l.getCases()));
		 assertEquals("La case est occupé par un monstre",false ,l.getMonstre()[1].estDisponible(9, 9, l.getCases()));
		 
	}

}
