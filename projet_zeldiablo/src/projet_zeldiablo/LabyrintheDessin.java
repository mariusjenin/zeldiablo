package projet_zeldiablo;

import java.awt.*;
import java.awt.image.BufferedImage;

import moteurJeu.DessinJeu;

public class LabyrintheDessin implements DessinJeu {
	/**
	 * Attribut Labyrinthe a dessiner
	 */
	private Labyrinthe jeu;

	/**
	 * taille d'une case et du labyrinthe total
	 */
	private int taille_case, taille_lab;

	/**
	 * constructeur initialisant un nouveau labyrinthe dessin
	 * 
	 * @param jeu Labyrinthe a initialiser
	 * @param i   taille du labyrinthe
	 */
	public LabyrintheDessin(Labyrinthe jeu, int i) {
		this.jeu = jeu;
		this.taille_lab = i;
		this.taille_case = this.taille_lab / this.jeu.getLargeur();
	}

	/**
	 * Setter de LabyrintheDessin
	 * 
	 * @param jeu Labyrinthe
	 * @param i   Taille du Labyrinthe
	 */
	public void setLabyrintheDessin(Labyrinthe jeu, int i) {
		this.jeu = jeu;
		this.taille_lab = i;
		this.taille_case = this.taille_lab / this.jeu.getLargeur();
	}

	/**
	 * Methode pour dessiner une case Bonus
	 * 
	 * @param g Graphic
	 * @param i abscisse
	 * @param j ordonnee
	 */
	public void dessinerBonus(Graphics g, int i, int j) {

		g.setColor(new Color(239, 197, 98));
		g.fillRect(i * taille_case, j * taille_case, taille_case, taille_case);

		g.setColor(Color.black);
		g.drawRect((int) (i * taille_case + 0.2 * taille_case), (int) (j * taille_case + 0.2 * taille_case),
				(int) (taille_case * 0.6), (int) (taille_case * 0.6));
		g.setColor(new Color(191, 140, 32));
		g.fillRect((int) (i * taille_case + 0.2 * taille_case), (int) (j * taille_case + 0.2 * taille_case),
				(int) (taille_case * 0.6), (int) (taille_case * 0.6));
	}

	/**
	 * Methode pour dessiner un Colosse
	 * 
	 * @param g   Graphic
	 * @param num indice du monstre
	 */
	public void dessinerColosse(Graphics g, int num) {
		Monstre Colosse = this.jeu.getMonstre()[num];
		this.dessinerSol(g, Colosse.getC().getX(), Colosse.getC().getY());

		g.setColor(new Color(209, 108, 77));
		g.fillRect((int) (Colosse.getC().getX() * taille_case + taille_case * 0.3),
				(int) (Colosse.getC().getY() * taille_case + taille_case * 0.2), (int) (taille_case * 0.4),
				(int) (taille_case * 0.6));

		g.fillRect((int) (Colosse.getC().getX() * taille_case + taille_case * 0.4),
				(int) (Colosse.getC().getY() * taille_case + taille_case * 0.05), (int) (taille_case * 0.2),
				(int) (taille_case * 0.3));

		g.fillRect((int) (Colosse.getC().getX() * taille_case + taille_case * 0.3),
				(int) (Colosse.getC().getY() * taille_case + taille_case * 0.8), (int) (taille_case * 0.1),
				(int) (taille_case * 0.2));

		g.fillRect((int) (Colosse.getC().getX() * taille_case + taille_case * 0.6),
				(int) (Colosse.getC().getY() * taille_case + taille_case * 0.8), (int) (taille_case * 0.1),
				(int) (taille_case * 0.2));

		g.fillRect((int) (Colosse.getC().getX() * taille_case + taille_case * 0.2),
				(int) (Colosse.getC().getY() * taille_case + taille_case * 0.3), (int) (taille_case * 0.6),
				(int) (taille_case * 0.1));

		int aleat = (int) Math.round(Math.random());
		if (aleat == 0) {
			g.fillRect((int) (Colosse.getC().getX() * taille_case + taille_case * 0.1),
					(int) (Colosse.getC().getY() * taille_case + taille_case * 0.3), (int) (taille_case * 0.1),
					(int) (taille_case * 0.6));
		} else {
			g.fillRect((int) (Colosse.getC().getX() * taille_case + taille_case * 0.8),
					(int) (Colosse.getC().getY() * taille_case + taille_case * 0.3), (int) (taille_case * 0.1),
					(int) (taille_case * 0.6));
		}

	}

	/**
	 * Methode pour dessiner une aventurier
	 * 
	 * @param g Graphic
	 */
	public void dessinerAvent(Graphics g) {
		Aventurier avent = this.jeu.getAvent();
		this.dessinerSol(g, avent.getC().getX(), avent.getC().getY());
		BasicStroke line = new BasicStroke((int) (0.1 * taille_case));
		((Graphics2D) g).setStroke(line);

		g.setColor(new Color(165, 117, 72));
		g.drawLine(avent.getC().getX() * taille_case + taille_case / 2,
				(int) (avent.getC().getY() * taille_case + 0.7 * taille_case),
				(int) (avent.getC().getX() * taille_case + taille_case / 2 - taille_case * 0.2),
				(int) (avent.getC().getY() * taille_case + 0.95 * taille_case));
		g.drawLine(avent.getC().getX() * taille_case + taille_case / 2,
				(int) (avent.getC().getY() * taille_case + 0.7 * taille_case),
				(int) (avent.getC().getX() * taille_case + taille_case / 2 + taille_case * 0.2),
				(int) (avent.getC().getY() * taille_case + 0.95 * taille_case));

		g.setColor(new Color(130, 221, 240));
		g.drawLine(avent.getC().getX() * taille_case + taille_case / 2,
				(int) (avent.getC().getY() * taille_case + 0.5 * taille_case),
				(int) (avent.getC().getX() * taille_case + taille_case / 2 - taille_case * 0.2),
				(int) (avent.getC().getY() * taille_case + 0.6 * taille_case));
		g.drawLine(avent.getC().getX() * taille_case + taille_case / 2,
				(int) (avent.getC().getY() * taille_case + 0.5 * taille_case),
				(int) (avent.getC().getX() * taille_case + taille_case / 2 + taille_case * 0.2),
				(int) (avent.getC().getY() * taille_case + 0.6 * taille_case));

		BasicStroke line2 = new BasicStroke((int) (0.2 * taille_case));
		((Graphics2D) g).setStroke(line2);

		g.drawLine(avent.getC().getX() * taille_case + taille_case / 2,
				(int) (avent.getC().getY() * taille_case + 0.4 * taille_case),
				avent.getC().getX() * taille_case + taille_case / 2,
				(int) (avent.getC().getY() * taille_case + 0.7 * taille_case));

		BasicStroke line3 = new BasicStroke((int) (0.02 * taille_case));
		((Graphics2D) g).setStroke(line3);
		g.setColor(Color.black);
		g.drawOval((int) (avent.getC().getX() * taille_case + taille_case / 2 - taille_case * 0.2),
				avent.getC().getY() * taille_case, (int) (0.4 * taille_case), (int) (0.4 * taille_case));
		g.setColor(new Color(245, 200, 170));
		g.fillOval((int) (avent.getC().getX() * taille_case + taille_case / 2 - taille_case * 0.2),
				avent.getC().getY() * taille_case, (int) (0.4 * taille_case), (int) (0.4 * taille_case));

		g.setColor(new Color(102, 72, 44));
		g.fillRect((int) (avent.getC().getX() * taille_case + taille_case / 2 - taille_case * 0.175),
				avent.getC().getY() * taille_case, (int) (0.35 * taille_case), (int) (0.07 * taille_case));
	}

	/**
	 * Methode pour dessiner le sol
	 * 
	 * @param g Graphic
	 * @param i abscisse
	 * @param j ordonnee
	 */
	public void dessinerSol(Graphics g, int i, int j) {
		g.setColor(new Color(239, 215, 136));
		g.fillRect(i * taille_case, j * taille_case, taille_case, taille_case);
	}

	/**
	 * Methode pour dessiner une attaque
	 * 
	 * @param g Graphic
	 */
	public void dessinerAttaque(Graphics g) {
		BasicStroke line = new BasicStroke((int) (0.05 * taille_case));
		((Graphics2D) g).setStroke(line);

		g.drawLine(this.jeu.getAvent().getC().getX() * taille_case, this.jeu.getAvent().getC().getY() * taille_case,
				(int) (this.jeu.getAvent().getC().getX() * taille_case - 0.6 * taille_case),
				(int) (this.jeu.getAvent().getC().getY() * taille_case + 0.5 * taille_case));

		g.drawLine(this.jeu.getAvent().getC().getX() * taille_case,
				(int) (this.jeu.getAvent().getC().getY() * taille_case + 0.2 * taille_case),
				(int) (this.jeu.getAvent().getC().getX() * taille_case - 0.3 * taille_case),
				(int) (this.jeu.getAvent().getC().getY() * taille_case + 0.5 * taille_case));

		g.drawLine((int) (this.jeu.getAvent().getC().getX() * taille_case - 0.2 * taille_case),
				(int) (this.jeu.getAvent().getC().getY() * taille_case),
				(int) (this.jeu.getAvent().getC().getX() * taille_case - 0.9 * taille_case),
				(int) (this.jeu.getAvent().getC().getY() * taille_case + 0.5 * taille_case));

		g.drawLine(this.jeu.getAvent().getC().getX() * taille_case,
				(int) (this.jeu.getAvent().getC().getY() * taille_case + taille_case),
				(int) (this.jeu.getAvent().getC().getX() * taille_case - 0.6 * taille_case),
				(int) (this.jeu.getAvent().getC().getY() * taille_case + taille_case - 0.5 * taille_case));

		g.drawLine(this.jeu.getAvent().getC().getX() * taille_case,
				(int) (this.jeu.getAvent().getC().getY() * taille_case + taille_case - 0.2 * taille_case),
				(int) (this.jeu.getAvent().getC().getX() * taille_case - 0.3 * taille_case),
				(int) (this.jeu.getAvent().getC().getY() * taille_case + 0.5 * taille_case));

		g.drawLine((int) (this.jeu.getAvent().getC().getX() * taille_case - 0.2 * taille_case),
				(int) (this.jeu.getAvent().getC().getY() * taille_case + taille_case),
				(int) (this.jeu.getAvent().getC().getX() * taille_case - 0.9 * taille_case),
				(int) (this.jeu.getAvent().getC().getY() * taille_case + 0.5 * taille_case));

		g.drawLine(this.jeu.getAvent().getC().getX() * taille_case,
				this.jeu.getAvent().getC().getY() * taille_case + taille_case,
				(int) (this.jeu.getAvent().getC().getX() * taille_case + 0.5 * taille_case),
				(int) (this.jeu.getAvent().getC().getY() * taille_case + taille_case + 0.6 * taille_case));

		g.drawLine((int) (this.jeu.getAvent().getC().getX() * taille_case + 0.2 * taille_case),
				(int) (this.jeu.getAvent().getC().getY() * taille_case + taille_case),
				(int) (this.jeu.getAvent().getC().getX() * taille_case + 0.5 * taille_case),
				(int) (this.jeu.getAvent().getC().getY() * taille_case + taille_case + 0.3 * taille_case));

		g.drawLine((int) (this.jeu.getAvent().getC().getX() * taille_case),
				(int) (this.jeu.getAvent().getC().getY() * taille_case + taille_case + 0.2 * taille_case),
				(int) (this.jeu.getAvent().getC().getX() * taille_case + 0.5 * taille_case),
				(int) (this.jeu.getAvent().getC().getY() * taille_case + taille_case + 0.9 * taille_case));

		g.drawLine(this.jeu.getAvent().getC().getX() * taille_case + taille_case,
				this.jeu.getAvent().getC().getY() * taille_case + taille_case,
				(int) (this.jeu.getAvent().getC().getX() * taille_case + taille_case - 0.5 * taille_case),
				(int) (this.jeu.getAvent().getC().getY() * taille_case + taille_case + 0.6 * taille_case));

		g.drawLine((int) (this.jeu.getAvent().getC().getX() * taille_case + taille_case - 0.2 * taille_case),
				(int) (this.jeu.getAvent().getC().getY() * taille_case + taille_case),
				(int) (this.jeu.getAvent().getC().getX() * taille_case + taille_case - 0.5 * taille_case),
				(int) (this.jeu.getAvent().getC().getY() * taille_case + taille_case + 0.3 * taille_case));

		g.drawLine((int) (this.jeu.getAvent().getC().getX() * taille_case + taille_case),
				(int) (this.jeu.getAvent().getC().getY() * taille_case + taille_case + 0.2 * taille_case),
				(int) (this.jeu.getAvent().getC().getX() * taille_case + taille_case - 0.5 * taille_case),
				(int) (this.jeu.getAvent().getC().getY() * taille_case + taille_case + 0.9 * taille_case));

		g.drawLine(this.jeu.getAvent().getC().getX() * taille_case, this.jeu.getAvent().getC().getY() * taille_case,
				(int) (this.jeu.getAvent().getC().getX() * taille_case + 0.5 * taille_case),
				(int) (this.jeu.getAvent().getC().getY() * taille_case - 0.6 * taille_case));

		g.drawLine((int) (this.jeu.getAvent().getC().getX() * taille_case + 0.2 * taille_case),
				(int) (this.jeu.getAvent().getC().getY() * taille_case),
				(int) (this.jeu.getAvent().getC().getX() * taille_case + 0.5 * taille_case),
				(int) (this.jeu.getAvent().getC().getY() * taille_case - 0.3 * taille_case));

		g.drawLine((int) (this.jeu.getAvent().getC().getX() * taille_case),
				(int) (this.jeu.getAvent().getC().getY() * taille_case - 0.2 * taille_case),
				(int) (this.jeu.getAvent().getC().getX() * taille_case + 0.5 * taille_case),
				(int) (this.jeu.getAvent().getC().getY() * taille_case - 0.9 * taille_case));

		g.drawLine(this.jeu.getAvent().getC().getX() * taille_case + taille_case,
				this.jeu.getAvent().getC().getY() * taille_case,
				(int) (this.jeu.getAvent().getC().getX() * taille_case + taille_case - 0.5 * taille_case),
				(int) (this.jeu.getAvent().getC().getY() * taille_case - 0.6 * taille_case));

		g.drawLine((int) (this.jeu.getAvent().getC().getX() * taille_case + taille_case - 0.2 * taille_case),
				(int) (this.jeu.getAvent().getC().getY() * taille_case),
				(int) (this.jeu.getAvent().getC().getX() * taille_case + taille_case - 0.5 * taille_case),
				(int) (this.jeu.getAvent().getC().getY() * taille_case - 0.3 * taille_case));

		g.drawLine((int) (this.jeu.getAvent().getC().getX() * taille_case + taille_case),
				(int) (this.jeu.getAvent().getC().getY() * taille_case - 0.2 * taille_case),
				(int) (this.jeu.getAvent().getC().getX() * taille_case + taille_case - 0.5 * taille_case),
				(int) (this.jeu.getAvent().getC().getY() * taille_case - 0.9 * taille_case));

		g.drawLine(this.jeu.getAvent().getC().getX() * taille_case + taille_case,
				this.jeu.getAvent().getC().getY() * taille_case,
				(int) (this.jeu.getAvent().getC().getX() * taille_case + taille_case + 0.6 * taille_case),
				(int) (this.jeu.getAvent().getC().getY() * taille_case + 0.5 * taille_case));

		g.drawLine(this.jeu.getAvent().getC().getX() * taille_case + taille_case,
				(int) (this.jeu.getAvent().getC().getY() * taille_case + 0.2 * taille_case),
				(int) (this.jeu.getAvent().getC().getX() * taille_case + taille_case + 0.3 * taille_case),
				(int) (this.jeu.getAvent().getC().getY() * taille_case + 0.5 * taille_case));

		g.drawLine((int) (this.jeu.getAvent().getC().getX() * taille_case + taille_case + 0.2 * taille_case),
				(int) (this.jeu.getAvent().getC().getY() * taille_case),
				(int) (this.jeu.getAvent().getC().getX() * taille_case + taille_case + 0.9 * taille_case),
				(int) (this.jeu.getAvent().getC().getY() * taille_case + 0.5 * taille_case));

		g.drawLine(this.jeu.getAvent().getC().getX() * taille_case + taille_case,
				(int) (this.jeu.getAvent().getC().getY() * taille_case + taille_case),
				(int) (this.jeu.getAvent().getC().getX() * taille_case + taille_case + 0.6 * taille_case),
				(int) (this.jeu.getAvent().getC().getY() * taille_case + taille_case - 0.5 * taille_case));

		g.drawLine(this.jeu.getAvent().getC().getX() * taille_case + taille_case,
				(int) (this.jeu.getAvent().getC().getY() * taille_case + taille_case - 0.2 * taille_case),
				(int) (this.jeu.getAvent().getC().getX() * taille_case + taille_case + 0.3 * taille_case),
				(int) (this.jeu.getAvent().getC().getY() * taille_case + 0.5 * taille_case));

		g.drawLine((int) (this.jeu.getAvent().getC().getX() * taille_case + taille_case + 0.2 * taille_case),
				(int) (this.jeu.getAvent().getC().getY() * taille_case + taille_case),
				(int) (this.jeu.getAvent().getC().getX() * taille_case + taille_case + 0.9 * taille_case),
				(int) (this.jeu.getAvent().getC().getY() * taille_case + 0.5 * taille_case));
	}

	/**
	 * Methode pour dessiner un Troll
	 * 
	 * @param g   Graphic
	 * @param num indice du monstre
	 */
	public void dessinerTroll(Graphics g, int num) {
		Monstre troll = this.jeu.getMonstre()[num];
		this.dessinerSol(g, troll.getC().getX(), troll.getC().getY());

		BasicStroke line2 = new BasicStroke((int) (0.2 * taille_case));
		((Graphics2D) g).setStroke(line2);

		g.setColor(new Color(54, 174, 81));
		g.drawLine(troll.getC().getX() * taille_case + taille_case / 2,
				(int) (troll.getC().getY() * taille_case + 0.7 * taille_case),
				(int) (troll.getC().getX() * taille_case + taille_case / 2 - taille_case * 0.2),
				(int) (troll.getC().getY() * taille_case + 0.9 * taille_case));
		g.drawLine(troll.getC().getX() * taille_case + taille_case / 2,
				(int) (troll.getC().getY() * taille_case + 0.7 * taille_case),
				(int) (troll.getC().getX() * taille_case + taille_case / 2 + taille_case * 0.2),
				(int) (troll.getC().getY() * taille_case + 0.9 * taille_case));

		g.drawLine(troll.getC().getX() * taille_case + taille_case / 2,
				(int) (troll.getC().getY() * taille_case + 0.5 * taille_case),
				(int) (troll.getC().getX() * taille_case + taille_case / 2 - taille_case * 0.2),
				(int) (troll.getC().getY() * taille_case + 0.6 * taille_case));
		g.drawLine(troll.getC().getX() * taille_case + taille_case / 2,
				(int) (troll.getC().getY() * taille_case + 0.5 * taille_case),
				(int) (troll.getC().getX() * taille_case + taille_case / 2 + taille_case * 0.2),
				(int) (troll.getC().getY() * taille_case + 0.6 * taille_case));

		g.drawLine(troll.getC().getX() * taille_case + taille_case / 2,
				(int) (troll.getC().getY() * taille_case + 0.4 * taille_case),
				troll.getC().getX() * taille_case + taille_case / 2,
				(int) (troll.getC().getY() * taille_case + 0.7 * taille_case));

		g.fillOval((int) (troll.getC().getX() * taille_case + taille_case / 2 - taille_case * 0.2),
				troll.getC().getY() * taille_case, (int) (0.4 * taille_case), (int) (0.4 * taille_case));
	}

	/**
	 * Methode pour dessiner une case Echelle
	 * 
	 * @param g Graphic
	 * @param i abscisse
	 * @param j ordonnee
	 */
	public void dessinerEchelle(Graphics g, int i, int j) {
		g.setColor(Color.black);
		g.fillRect(i * taille_case, j * taille_case, taille_case, taille_case);

		BasicStroke line = new BasicStroke((int) (0.1 * taille_case));
		((Graphics2D) g).setStroke(line);

		int epaisseur = taille_case / 13;

		g.setColor(new Color(128, 128, 128));
		g.drawLine((int) (i * taille_case + taille_case * 0.1), j * taille_case,
				(int) (i * taille_case + taille_case * 0.3 + taille_case * 0.1), j * taille_case + epaisseur * 12);
		g.drawLine((int) (i * taille_case + taille_case * 0.9), j * taille_case,
				(int) (i * taille_case - taille_case * 0.3 + taille_case * 0.9), j * taille_case + epaisseur * 12);

		for (int k = 1; k <= 7; k++) {
			g.setColor(new Color(100 + (k - 1) * 25, 100 + (k - 1) * 25, 100 + (k - 1) * 25));
			int taille = (int) (taille_case * 0.3 + ((taille_case * 0.7) / 6) * (k - 1));
			g.fillRect(i * taille_case + (taille_case - taille) / 2, j * taille_case + epaisseur * (2 * (7 - k)),
					taille, epaisseur);
		}
	}

	/**
	 * Methode pour dessiner un fantome
	 * 
	 * @param g   Graphic
	 * @param num indice du monstre
	 */
	public void dessinerFantome(Graphics g, int num) {
		if (this.jeu.getMonstre()[num].getC().getEtat() == 12) {
			this.dessinerMur(g, this.jeu.getMonstre()[num].getC().getX(), this.jeu.getMonstre()[num].getC().getY());
		} else {
			this.dessinerSol(g, this.jeu.getMonstre()[num].getC().getX(), this.jeu.getMonstre()[num].getC().getY());
		}
		g.setColor(new Color(200, 200, 200));
		g.fillOval((int) (this.jeu.getMonstre()[num].getC().getX() * taille_case + taille_case * 0.1),
				(this.jeu.getMonstre()[num].getC().getY() * taille_case), (int) (taille_case - 0.2 * taille_case),
				taille_case);
		g.fillRect((int) (this.jeu.getMonstre()[num].getC().getX() * taille_case + taille_case * 0.1),
				(int) (this.jeu.getMonstre()[num].getC().getY() * taille_case + taille_case / 2),
				(int) (taille_case * 0.8), (int) (taille_case / 2 - taille_case * 0.1));
	}

	/**
	 * Methode pour dessiner un Gnome
	 * 
	 * @param g   Graphic
	 * @param num indice du monstre
	 */
	public void dessinerGnome(Graphics g, int num) {

		this.dessinerSol(g, this.jeu.getMonstre()[num].getC().getX(), this.jeu.getMonstre()[num].getC().getY());
		BasicStroke line = new BasicStroke((int) (0.1 * taille_case));
		((Graphics2D) g).setStroke(line);

		g.setColor(new Color(196, 167, 137));
		g.fillOval((int) (this.jeu.getMonstre()[num].getC().getX() * taille_case + 0.3 * taille_case),
				(int) (this.jeu.getMonstre()[num].getC().getY() * taille_case + 0.6 * taille_case),
				(int) (0.4 * taille_case), (int) (0.4 * taille_case));
		g.drawLine((int) (this.jeu.getMonstre()[num].getC().getX() * taille_case + 0.4 * taille_case),
				(int) (this.jeu.getMonstre()[num].getC().getY() * taille_case + 0.7 * taille_case),
				(int) ((int) (this.jeu.getMonstre()[num].getC().getX() * taille_case + 0.2 * taille_case)),
				(int) ((int) (this.jeu.getMonstre()[num].getC().getY() * taille_case + 0.5 * taille_case)));
		g.drawLine((int) (this.jeu.getMonstre()[num].getC().getX() * taille_case + 0.6 * taille_case),
				(int) (this.jeu.getMonstre()[num].getC().getY() * taille_case + 0.7 * taille_case),
				(int) ((int) (this.jeu.getMonstre()[num].getC().getX() * taille_case + 0.8 * taille_case)),
				(int) ((int) (this.jeu.getMonstre()[num].getC().getY() * taille_case + 0.5 * taille_case)));

	}

	/**
	 * Methode pour dessiner un monstre
	 * 
	 * @param g   Graphic
	 * @param num indice du monstre
	 */
	public void dessinerMonstre(Graphics g, int num) {
		g.setColor(Color.black);
		g.fillRect((this.jeu.getMonstre()[num].getC().getX() * taille_case) + (int) (taille_case * 0.1),
				(this.jeu.getMonstre()[num].getC().getY() * taille_case) + (int) (taille_case * 0.1),
				(int) (taille_case * 0.8), (10 * taille_case) / 50);
		g.setColor(Color.green);
		g.fillRect((this.jeu.getMonstre()[num].getC().getX() * taille_case) + (int) (taille_case * 0.1),
				(this.jeu.getMonstre()[num].getC().getY() * taille_case) + (int) (taille_case * 0.1), (int) (taille_case
						* 0.8 * this.jeu.getMonstre()[num].getVie() / this.jeu.getMonstre()[num].getVieBase()),
				(10 * taille_case) / 50);
	}

	/**
	 * Methode pour dessiner une case mur
	 * 
	 * @param g Graphic
	 * @param i abscisse
	 * @param j ordonnee
	 */
	public void dessinerMur(Graphics g, int i, int j) {
		g.setColor(Color.darkGray);
		g.fillRect(i * taille_case, j * taille_case, taille_case, taille_case);
		g.setColor(Color.gray);
		double unite = taille_case / 21.0;

		g.fillRect((int) (i * taille_case), (int) (j * taille_case + unite), (int) (3 * unite), (int) (4 * unite));
		g.fillRect((int) (i * taille_case + 4 * unite), (int) (j * taille_case + unite), (int) (6 * unite),
				(int) (4 * unite));
		g.fillRect((int) (i * taille_case + 11 * unite), (int) (j * taille_case + unite), (int) (6 * unite),
				(int) (4 * unite));
		g.fillRect((int) (i * taille_case + 18 * unite), (int) (j * taille_case + unite), (int) (3 * unite),
				(int) (4 * unite));

		g.fillRect((int) (i * taille_case), (int) (j * taille_case + 7 * unite), (int) (5 * unite), (int) (4 * unite));
		g.fillRect((int) (i * taille_case + 6 * unite), (int) (j * taille_case + 7 * unite), (int) (6 * unite),
				(int) (4 * unite));
		g.fillRect((int) (i * taille_case + 13 * unite), (int) (j * taille_case + 7 * unite), (int) (6 * unite),
				(int) (4 * unite));
		g.fillRect((int) (i * taille_case + 20 * unite), (int) (j * taille_case + 7 * unite), (int) (1 * unite),
				(int) (4 * unite));

		g.fillRect((int) (i * taille_case), (int) (j * taille_case + 13 * unite), (int) (1 * unite), (int) (4 * unite));
		g.fillRect((int) (i * taille_case + 2 * unite), (int) (j * taille_case + 13 * unite), (int) (6 * unite),
				(int) (4 * unite));
		g.fillRect((int) (i * taille_case + 9 * unite), (int) (j * taille_case + 13 * unite), (int) (6 * unite),
				(int) (4 * unite));
		g.fillRect((int) (i * taille_case + 16 * unite), (int) (j * taille_case + 13 * unite), (int) (5 * unite),
				(int) (4 * unite));

		g.fillRect((int) (i * taille_case), (int) (j * taille_case + 19 * unite), (int) (3 * unite), (int) (2 * unite));
		g.fillRect((int) (i * taille_case + 4 * unite), (int) (j * taille_case + 19 * unite), (int) (6 * unite),
				(int) (2 * unite));
		g.fillRect((int) (i * taille_case + 11 * unite), (int) (j * taille_case + 19 * unite), (int) (6 * unite),
				(int) (2 * unite));
		g.fillRect((int) (i * taille_case + 18 * unite), (int) (j * taille_case + 19 * unite), (int) (3 * unite),
				(int) (2 * unite));

	}

	/**
	 * Methode dessiner pour le moteur de jeu
	 * 
	 * @param image parametre correspondant au composant graphique du moteur de jeu
	 */
	public void dessiner(BufferedImage image) {
		Graphics2D g = (Graphics2D) image.getGraphics();
		if (!this.jeu.etreFini()) {
			g.setColor(Color.gray);
			for (int i = 0; i < this.jeu.getLargeur(); i++) {
				g.drawLine(i * taille_case, 0, i * taille_case, this.taille_lab);
				g.drawLine(0, i * taille_case, this.taille_lab, i * taille_case);
			}
			g.setColor(Color.black);
			for (int i = 0; i < this.jeu.getLargeur(); i++) {
				for (int j = 0; j < this.jeu.getLargeur(); j++) {
					switch (this.jeu.getCase(i, j).getEtat()) {
					case Case.VIDE:
						this.dessinerSol(g, i, j);
						break;
					case Case.MUR:
						this.dessinerMur(g, i, j);
						break;
					case Case.ECHELLE:
						this.dessinerEchelle(g, i, j);
						break;
					case Case.BONUS:
						this.dessinerBonus(g, i, j);
						break;
					}
					g.setColor(Color.black);
				}
			}
			if (!this.jeu.getAvent().etreMort()) {
				this.dessinerAvent(g);

				// creation de la barre de vie graphique
				g.setColor(Color.black);
				g.fillRect((this.jeu.getAvent().getC().getX() * taille_case) + (int) (taille_case * 0.1),
						(this.jeu.getAvent().getC().getY() * taille_case) + (int) (taille_case * 0.1),
						(int) (taille_case * 0.8), (10 * taille_case) / 50);
				g.setColor(Color.green);
				g.fillRect((this.jeu.getAvent().getC().getX() * taille_case) + (int) (taille_case * 0.1),
						(this.jeu.getAvent().getC().getY() * taille_case) + (int) (taille_case * 0.1),
						(int) (taille_case * 0.8 * this.jeu.getAvent().getVie() / this.jeu.getAvent().getVieBase()),
						(10 * taille_case) / 50);
			}
			g.setColor(Color.black);
			// affichage des lettres sur les monstres et de leur couleurs
			for (int i = 0; i < this.jeu.getMonstre().length; i++) {
				g.setColor(Color.black);
				if (this.jeu.getMonstre()[i] instanceof Fantome) {
					this.dessinerFantome(g, i);
				} else if (this.jeu.getMonstre()[i] instanceof Troll) {
					this.dessinerTroll(g, i);
				} else if (this.jeu.getMonstre()[i] instanceof Colosse) {
					this.dessinerColosse(g, i);
				} else if (this.jeu.getMonstre()[i] instanceof Gnome) {
					this.dessinerGnome(g, i);
				}
				this.dessinerMonstre(g, i);
			}

			if (this.jeu.getAvent().getAttaque() > 0) {
				if (this.jeu.getAvent().getAttaque() == 1) {
					g.setColor(Color.black);
				} else if (this.jeu.getAvent().getAttaque() == 2) {
					g.setColor(Color.blue);
				}
				this.dessinerAttaque(g);
				try {
					Thread.sleep(50);
				} catch (InterruptedException ie) {
					System.out.println("InterruptedException");
				}
				this.jeu.getAvent().FinAttaque();
			}
		} else {
			this.affichageFin(g);
		}
		g.dispose();
	}

	/**
	 * Methode qui affiche si le joueur a perdu ou non
	 * 
	 * @param g Graphic
	 */
	public void affichageFin(Graphics g) {
		if (this.jeu.getAvent().etreMort()) {
			g.setColor(Color.darkGray);
			g.fillRect(0, 0, taille_lab, taille_lab);
			g.setColor(Color.RED);
			g.setFont(new Font("Arial", Font.BOLD, (int) (0.1 * taille_lab)));
			g.drawString("GAME OVER", (int) (0.21 * taille_lab), (int) (0.5 * taille_lab));
		} else {
			g.setColor(Color.white);
			g.fillRect(0, 0, taille_lab, taille_lab);
			g.setColor(Color.green);
			g.setFont(new Font("Arial", Font.BOLD, (int) (0.07 * taille_lab)));
			g.drawString("CONGRATULATIONS !!!", (int) (0.1 * taille_lab), (int) (0.5 * taille_lab));
		}
	}
}
