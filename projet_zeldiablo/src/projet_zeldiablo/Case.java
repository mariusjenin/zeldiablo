package projet_zeldiablo;

public class Case {
	private int etat;//Etat de la case en fonction de son indice
	private int x,y;//Abscisse et ordonnée de la case
	
	/**
	 * Ensemble des états possibles d'une case en fonction de leur indices
	 */
	public final static int VIDE=0;
	public final static int MUR=1;
	public final static int AVENT=2;
	public final static int ECHELLE=3;
	public final static int GNOME=10;
	public final static int FANTOME_VIDE=11;
	public final static int FANTOME_MUR=12;
	public final static int TROLL=13;
	public final static int COLOSSE=14;
	public final static int BONUS = 8;
	
	/**
	 * Constructeur de Case à partir d'une abscisse et d'une ordonnée
	 * @param x abscisse de la case
	 * @param y ordonnée de la case
	 */
	public Case(int x,int y) {
		this.etat = 0;
		this.x=x;
		this.y=y;
	}
	
	/**
	 * Constructeur de Cas à partir d'une abscisse et d'une ordonnée
	 * avec son etat
	 * @param i indice de l'état de la case
	 */
	public Case(int x,int y,int i) {
		this.etat = i;
		this.x=x;
		this.y=y;
	}
	
	/**
	 * Getter de etat
	 * @return etat état de Case
	 */
	public int getEtat() {
		return this.etat;
	}
	
	/**
	 * Setter de etat
	 * @param i Etat de la case
	 */
	public void setEtat(int i) {
		this.etat = i;
	}
	
	/**
	 * Getter de l'abscisse de la case
	 * @return x Abscisse de la case
	 */
	public int getX() {
		return this.x;
	}
	
	/**
	 * Getter de l'ordonnées de la case
	 * @return entier correspondant a la pos y de la case
	 */
	public int getY() {
		return this.y;
	}
}
