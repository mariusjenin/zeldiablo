package projet_zeldiablo;

public abstract class Personnage {
	protected Case c;// Case du personnage
	private int vie;// Vie du personnage
	private int vieBase;// Vie normale du personnage
	private int degat;// D�gats du personnage

	/**
	 * Constructeur d'un personnage,
	 * 
	 * @param c     Case courant
	 * @param vie
	 * @param degat
	 */
	public Personnage(Case c, int vie, int degat) {
		this.c = c;
		this.vie = vie;
		this.vieBase = vie;
		this.degat = degat;
	}

	/**
	 * Modifie les coordonn�es du personnage
	 * 
	 * @param c Case de destination
	 */
	public abstract void modifierCoords(Case c);

	/**
	 * Getter qui retourne la case du personnage
	 * 
	 * @return c
	 */
	public Case getC() {
		return this.c;
	}

	/**
	 * M�thode qui enl�ve des points de vie au personnage de la valeur de deg
	 * 
	 * @param deg montant des d�gats � subir
	 */
	public void subirDegat(int deg) {
		if (deg < 0) {
			deg = deg * -1;
		}
		if (this.vie - deg > 0) {
			this.vie -= deg;
		} else {
			this.vie = 0;
		}
	}

	/**
	 * M�thode qui teste la disponibilit� de la case selon le personnage voulu
	 * 
	 * @param x   abscisse
	 * @param y   ordonn�e
	 * @param tab ensemble des cases
	 * @return res true si d�placement possible
	 */
	public abstract boolean estDisponible(int x, int y, Case[][] tab);

	public abstract void attaquer(Labyrinthe l);
	
	/**
	 * Getter qui retourne la vie du personnage
	 * 
	 * @return vie montant de la vie
	 */
	public int getVie() {
		return vie;
	}

	/**
	 * Getter qui retourne la vie de base du personnage
	 * 
	 * @return vie montant de la vie non modifi�e
	 */
	public int getVieBase() {
		return this.vieBase;
	}

	/**
	 * M�thode qui teste l'�tat d'un personnage
	 * 
	 * @return true si mort , false sinon
	 */
	public boolean etreMort() {
		if (this.vie <= 0) {
			return true;
		} else {
			return false;

		}
	}

	/**
	 * Getter qui retourne les d�gats du Personnage
	 * 
	 * @return degat d�gats du personnage
	 */
	public int getDegat() {
		return this.degat;
	}

	/**
	 * Setter qui set la vie du personnage
	 * 
	 * @param v valeur de la nouvelle vie
	 */
	public void setVie(int v) {
		this.vie = v;
	}
	
	/**
	 * setter de d�gats qui permet de changer les d�gats du personnage
	 * @param d entier qui correspond au nouveau degat a attribuer au personnage
	 */
	public void setDegats(int d) {
		this.degat = d;
	}

}
