package projet_zeldiablo;

public class Fantome extends Monstre {

	/**
	 * Constructeur de fantome � partir d'une case
	 * 
	 * @param c Case du Monstre
	 */
	public Fantome(Case c) {
		super(c, 200, 2, 10);
	}

	/**
	 * M�thode qui d�termine si la case demand�e est disponible pour le d�placement
	 * de Fantome (Peut traverser les murs)
	 * 
	 * @param x   abscisse
	 * @param y   ordonn�e
	 * @param tab ensemble des Cases du labyrinthe
	 * @return res true si case disponible, false sinon
	 */
	public boolean estDisponible(int x, int y, Case[][] tab) {
		boolean res = false;
		if (x < tab.length && x > -1 && y < tab.length && y > -1) {
			if (tab[x][y].getEtat() == Case.VIDE || tab[x][y].getEtat() == Case.MUR
					|| tab[x][y].getEtat() == Case.ECHELLE) {
				res = true;
			}
		}
		return res;
	}

	/**
	 * M�thode qui modifie les coordonn�es du Fantome � partir d'une case
	 * @param cas nouvelle case du monstre
	 */
	public void modifierCoords(Case cas) {
		this.c.setEtat(this.c.getEtat() - Case.FANTOME_VIDE);
		this.c = cas;
		this.c.setEtat(this.c.getEtat() + Case.FANTOME_VIDE);
	}
}
