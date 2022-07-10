package projet_zeldiablo;

public class Aventurier extends Personnage {
	private int attaque;

	/**
	 * Constructeur qui cr�e un aventurier � partir d'une case
	 * 
	 * @param c Case de d�part
	 */
	public Aventurier(Case c) {
		super(c, 500, 40);
		this.c.setEtat(Case.AVENT);
		this.attaque = 0;
	}

	/**
	 * M�thode qui retourne true si l'aventurier peut se d�placer sur la case
	 * voulue, false sinon
	 * 
	 * @param x   Abscisse de la case
	 * @param y   Ordonn�e de la case
	 * @param tab Grille des cases
	 */
	public boolean estDisponible(int x, int y, Case[][] tab) {
		boolean res = false;
		if (x < tab.length && x > -1 && y < tab.length && y > -1) {
			if (tab[x][y].getEtat() == Case.VIDE || tab[x][y].getEtat() == Case.ECHELLE || tab[x][y].getEtat() == Case.BONUS) {
				res = true;
			}
		}
		return res;
	}

	/**
	 * M�thode qui permets de modifier les coordonn�es de l'aventurier
	 * 
	 * @param x nouvelle coordonn�e de l'aventurier
	 * @param y nouvelle coordonn�� de l'aventurier
	 */
	public void modifierCoords(Case c) {
		this.c.setEtat(0);
		this.c = c;
		this.c.setEtat(Case.AVENT);
	}

	public void attaquer(Labyrinthe l) {
		this.attaquer(l, false);
	}
	
	/**
	 * Methode qui sert � attaquer un monstre. Attaque autour du joueur Elle
	 * recherche d'abord les cases autour du joueurs, puis v�rifie pour chaque case,
	 * si un monstre est pr�sent. Si un monstre est pr�sent , il subit alors des
	 * d�gats �quivalent au points de d�gat du joueur. Si le param�tre repousse est
	 * vrai, alors tous les monstres � c�t� du monstre sont repouss�s au maximum
	 * 
	 * @param l        : Labyrinthe dans lequel se situe le joueur et le monstre.
	 * @param repousse : bool�en qui sp�cifie si l'attaque est normale ou non
	 */
	public void attaquer(Labyrinthe l, boolean repousse) {
		if(repousse) {
			this.attaque=2;
		} else {
			this.attaque=1;
		}
		Case c = this.getC();
		int d = this.getDegat();
		int x = c.getX();
		int y = c.getY();
		Monstre[] tab = l.getMonstre();
		if (x + 1 < l.getLargeur()) {
			Case c1 = l.getCase(x + 1, y);
			int e1 = c1.getEtat();
			if ((e1 >= 10) && (e1 < 20)) {
				for (int i = 0; i < tab.length; i++) {
					if (tab[i].getC().equals(c1)) {
						if (repousse) {
							int r = 2;
							while (tab[i].estDisponible(x + r, y, l.getCases())) {
								if (tab[i] instanceof Colosse) {
									l.getCase(x + r, y).setEtat(0);
								}
								r++;
							}
							if (r > 0) {
								r--;
							}
							tab[i].modifierCoords(l.getCases()[x + r][y]);
						} else {
							tab[i].attaquer(l);
						}
						tab[i].subirDegat(d);
					}
				}
			}
		}

		if (y + 1 < l.getLargeur()) {
			Case c2 = l.getCase(x, y + 1);
			int e2 = c2.getEtat();
			if ((e2 >= 10) && (e2 < 20)) {
				for (int i = 0; i < tab.length; i++) {
					if (tab[i].getC().equals(c2)) {
						if (repousse) {
							int r = 2;
							while (tab[i].estDisponible(x, y + r, l.getCases())) {
								if (tab[i] instanceof Colosse) {
									l.getCase(x, y + r).setEtat(0);
								}
								r++;

							}
							if (r > 0) {
								r--;
							}
							tab[i].modifierCoords(l.getCases()[x][y + r]);
						} else {
							tab[i].attaquer(l);
						}
						tab[i].subirDegat(d);
					}
				}
			}
		}
		if (x - 1 >= 0) {
			Case c3 = l.getCase(x - 1, y);
			int e3 = c3.getEtat();
			if ((e3 >= 10) && (e3 < 20)) {
				for (int i = 0; i < tab.length; i++) {
					if (tab[i].getC().equals(c3)) {
						if (repousse) {
							int r = 2;
							while (tab[i].estDisponible(x - r, y, l.getCases())) {
								if (tab[i] instanceof Colosse) {
									l.getCase(x - r, y).setEtat(0);
								}
								r++;

							}
							if (r > 0) {
								r--;
							}
							tab[i].modifierCoords(l.getCases()[x - r][y]);
						} else {
							tab[i].attaquer(l);
						}
						tab[i].subirDegat(d);
					}
				}
			}
		}
		if (y - 1 >= 0) {
			Case c4 = l.getCase(x, y - 1);
			int e4 = c4.getEtat();
			if ((e4 >= 10) && (e4 < 20)) {
				for (int i = 0; i < tab.length; i++) {
					if (tab[i].getC().equals(c4)) {
						if (repousse) {
							int r = 2;
							while (tab[i].estDisponible(x, y - r, l.getCases())) {
								if (tab[i] instanceof Colosse) {
									l.getCase(x, y - r).setEtat(0);
								}
								r++;

							}
							if (r > 0) {
								r--;
							}
							tab[i].modifierCoords(l.getCases()[x][y - r]);
						} else {
							tab[i].attaquer(l);
						}
						tab[i].subirDegat(d);
					}
				}
			}
		}

	}

	/**
	 * Getter qui dit si l'aventurier attaque ou pas
	 * 
	 * @return attaque true si l'aventurier attaque
	 */
	public int getAttaque() {
		return attaque;
	}

	/**
	 * M�thode qui dit que l'aventurier n'attaque plus
	 */
	public void FinAttaque() {
		this.attaque = 0;
	}

	/**
	 * M�thode qui regenere l'aventurier de la valeur pass�e en param�tre
	 * 
	 * @param heal montant de la r�g�n�ration
	 */
	public void regenererAventurier(int heal) {
		if (this.getVie() + heal > this.getVieBase()) {
			this.setVie(this.getVieBase());
		} else {
			this.setVie(this.getVie() + heal);
		}
	}

}
