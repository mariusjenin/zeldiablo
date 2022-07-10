package projet_zeldiablo;

public abstract class Personnage {
	protected Case c;// Case du personnage
	private int vie;// Vie du personnage
	private int vieBase;// Vie normale du personnage
	private int degat;// Dégats du personnage

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
	 * Modifie les coordonnées du personnage
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
	 * Méthode qui enlève des points de vie au personnage de la valeur de deg
	 * 
	 * @param deg montant des dégats à subir
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
	 * Méthode qui teste la disponibilité de la case selon le personnage voulu
	 * 
	 * @param x   abscisse
	 * @param y   ordonnée
	 * @param tab ensemble des cases
	 * @return res true si déplacement possible
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
	 * @return vie montant de la vie non modifiée
	 */
	public int getVieBase() {
		return this.vieBase;
	}

	/**
	 * Méthode qui teste l'état d'un personnage
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
	 * Getter qui retourne les dégats du Personnage
	 * 
	 * @return degat dégats du personnage
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
	 * setter de dégats qui permet de changer les dégats du personnage
	 * @param d entier qui correspond au nouveau degat a attribuer au personnage
	 */
	public void setDegats(int d) {
		this.degat = d;
	}

}
