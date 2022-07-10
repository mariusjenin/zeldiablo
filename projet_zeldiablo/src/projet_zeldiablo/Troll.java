package projet_zeldiablo;

public class Troll extends Monstre{
	
	/**
	 * Constructeur de Troll à partir d'une case
	 * @param c Case du troll
	 */
	public Troll(Case c) {
		super(c, 500,3,15);
	}


	/**
	 * Méthode qui modifie les coordonnées du Troll à partir d'une case
	 * @param cas Case nouvelle du Troll
	 */
	public void modifierCoords(Case cas) {
		this.c.setEtat(0);
		this.c = cas;
		this.c.setEtat(Case.TROLL);
	}
	
	/**
	 * Méthode qui regenere Troll à partir du paramètre
	 * @param heal représente le soin attribué au troll
	 */
	public void regenererTroll(int heal){
		if(this.getVie()+heal>this.getVieBase()) {
			this.setVie(this.getVieBase());
		}else {
			this.setVie(this.getVie()+heal);
		}
	}
}
