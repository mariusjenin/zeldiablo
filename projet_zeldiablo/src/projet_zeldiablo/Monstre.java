package projet_zeldiablo;


public abstract class Monstre extends Personnage{

	private int vision;//Portée de la vision du monstre

	/**
	 * Constructeur de Monstre
	 * @param c Case courante du monstre
	 * @param v vie du monstre
	 * @param vision portée de vision du monstre
	 * @param degat dégats du monstre
	 */
	public Monstre(Case c,int v, int vision,int degat) {
		super(c, v,  degat);
		this.vision = vision;
		
	}

	/**
	 * Méthode qui modifie les coordonnées du monstre
	 */
	public abstract void modifierCoords(Case c);
	
	public boolean estDisponible(int x, int y, Case[][] tab) {
		boolean res = false;
		if (x < tab.length && x > -1 && y < tab.length && y > -1) {
			if (tab[x][y].getEtat() == Case.VIDE) {
				res = true;
			}
		}
		return res;
	}

	/**
	 * Méthode qui permet au monstre d'attaquer l'aventurier du labyrinthe
	 * @param l Labyrinthe du monstre
	 */
	public void attaquer(Labyrinthe l) {
		int x = this.getC().getX();
		int y = this.getC().getY();
		int p1, p2, p3, p4;
		if (x+1 <l.getLargeur()) {
			p1 = l.getCase(x + 1, y).getEtat();
		}else {
			p1 =0;
		}
		if (y+1 < l.getLargeur()) {
			 p2 = l.getCase(x, y + 1).getEtat();
		}else {
			p2=0;
		}
		if (x-1 >=0) {
			p3 = l.getCase(x - 1, y).getEtat();
		}else {
			p3=0;
		}
		if  (y-1 >=0) {
			p4 = l.getCase(x, y - 1).getEtat();
		} else {
			p4=0;
		}
		if ((p1 == 2) || (p2 == 2) || (p3 == 2) || (p4 == 2)) {
			l.getAvent().subirDegat(this.getDegat());
		}
	}	
	
	/**
	 * methode qui retourne l'attribut vision
	 * @return entier qui correspond au rayon de vision du monstre
	 */
	public int getVision() {
		return this.vision;
	}
	
	/**
	 * setter qui permet de changer la vision du monstre
	 * @param x entier qui correspond à la nouvelle vision à donner au monstre
	 */
	public void setVision(int x) {
		this.vision = x;
	}
	

}
