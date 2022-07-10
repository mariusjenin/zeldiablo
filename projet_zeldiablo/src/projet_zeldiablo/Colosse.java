package projet_zeldiablo;

public class Colosse extends Monstre {

	/**
	 * Constructeur de Colosse � partir d'une case
	 * 
	 * @param c Case du colosse
	 */
	public Colosse(Case c) {
		super(c, 1000, 5, 100);
	}

	/**
	 * M�thode qui d�termine si la case demand�e est disponible pour le d�placement
	 * de Colosse (Peut casser les murs)
	 * 
	 * @param x   abscisse
	 * @param y   ordonn�e
	 * @param tab ensemble des Cases du labyrinthe
	 * @return res true si case disponible, false sinon
	 */
	public boolean estDisponible(int x, int y, Case[][] tab) {
		boolean res = false;
		if (x < tab.length && x > -1 && y < tab.length && y > -1) {
			if (tab[x][y].getEtat() == Case.VIDE || tab[x][y].getEtat() == Case.MUR) {
				res = true;
			}
		}
		return res;
	}

	/**
	 * modifie l'etat de la case precedente du monstre et change l'etat de la
	 * nouvelle
	 */
	public void modifierCoords(Case cas) {
		this.c.setEtat(0);
		this.c = cas;
		this.c.setEtat(Case.COLOSSE);
	}
}
