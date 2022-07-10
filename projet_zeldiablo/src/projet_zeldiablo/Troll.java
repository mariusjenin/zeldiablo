package projet_zeldiablo;

public class Troll extends Monstre{
	
	/**
	 * Constructeur de Troll � partir d'une case
	 * @param c Case du troll
	 */
	public Troll(Case c) {
		super(c, 500,3,15);
	}


	/**
	 * M�thode qui modifie les coordonn�es du Troll � partir d'une case
	 * @param cas Case nouvelle du Troll
	 */
	public void modifierCoords(Case cas) {
		this.c.setEtat(0);
		this.c = cas;
		this.c.setEtat(Case.TROLL);
	}
	
	/**
	 * M�thode qui regenere Troll � partir du param�tre
	 * @param heal repr�sente le soin attribu� au troll
	 */
	public void regenererTroll(int heal){
		if(this.getVie()+heal>this.getVieBase()) {
			this.setVie(this.getVieBase());
		}else {
			this.setVie(this.getVie()+heal);
		}
	}
}
