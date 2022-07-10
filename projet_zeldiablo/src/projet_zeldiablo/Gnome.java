package projet_zeldiablo;

public class Gnome extends Monstre{
	
	/**
	 * Constructeur de Gnome à partir d'une case
	 * @param c Case voulue
	 */
	public Gnome(Case c) {
		super(c,100,2,10);
	}
	
	/**
	 * Méthode qui modifie les coordonnées du Gnome
	 * @param cas nouvelle case du Gnome
	 */
	public void modifierCoords(Case cas) {
		this.c.setEtat(0);
		this.c = cas;
		this.c.setEtat(Case.GNOME);
	}
}

