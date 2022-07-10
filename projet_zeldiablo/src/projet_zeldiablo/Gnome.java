package projet_zeldiablo;

public class Gnome extends Monstre{
	
	/**
	 * Constructeur de Gnome � partir d'une case
	 * @param c Case voulue
	 */
	public Gnome(Case c) {
		super(c,100,2,10);
	}
	
	/**
	 * M�thode qui modifie les coordonn�es du Gnome
	 * @param cas nouvelle case du Gnome
	 */
	public void modifierCoords(Case cas) {
		this.c.setEtat(0);
		this.c = cas;
		this.c.setEtat(Case.GNOME);
	}
}

