package projet_zeldiablo;

import main.JeuLab;
import moteurJeu.Commande;
import moteurJeu.Jeu;

public class Labyrinthe implements Jeu {
	private Aventurier avent;// Aventurier du labyrinthe
	private Case[][] grille;// Ensemble des cases du labyrinthe
	private Monstre[] tabMonstre;// Ensemble des monstres du labyrinthe
	private int largeur;// Largeur du labyrinthe
	private int tp;// �tat de la t�l�portation du labyrinthe
	private int repousse;// �tat de l'attaque repousse du labyrinthe
	private LabyrintheDessin dess;// LabyrintheDessin qui permet de refaire le labyrinthe
	private boolean boss;// Boole�n qui indique si l'on est au niveau final

	/**
	 * Constructeur du labyrinthe avec la taille en param�tre
	 * 
	 * @param a
	 *            largeur du labyrinthe � cr�er
	 */
	public Labyrinthe(int a) {
		this.largeur = a;
		this.tp = 0;
		this.repousse = 0;
		this.grille = new Case[this.largeur][this.largeur];
		PatternLabyrinthe pattLab = new PatternLabyrinthe();
		this.grille = pattLab.getLab(this.largeur);
		this.avent = new Aventurier(this.grille[this.largeur / 2][this.largeur - 1]);
		this.genererMonstre();
		this.dess = new LabyrintheDessin(this, JeuLab.TAILLE);
	}

	/**
	 * Getter du LabyrintheDessin
	 * 
	 * @return LabyrintheDessin
	 */
	public LabyrintheDessin getLabyrintheDessin() {
		return dess;
	}

	/**
	 * M�thode qui change de donjon (niveau de labyrinthe) quand l'aventurier monte
	 * l'�chelle
	 */
	public void nouvelEtage() {
		this.largeur++;
		this.tp = 0;
		this.repousse = 0;
		this.grille = new Case[this.largeur][this.largeur];
		PatternLabyrinthe pattLab = new PatternLabyrinthe();
		this.grille = pattLab.getLab(this.largeur);
		this.avent.modifierCoords(this.grille[this.largeur / 2][this.largeur - 1]);
		this.avent.regenererAventurier(this.avent.getVieBase() / 2);
		this.genererMonstre();
		this.dess.setLabyrintheDessin(this, JeuLab.TAILLE);
		if (this.largeur == 16) {
			boss = true;
			for (int i = 0; i < this.tabMonstre.length; i++) {
				this.tabMonstre[i].setVision(0);
			}
		}

	}

	/**
	 * M�thode qui g�n�re les monstres dans le labyrinthe � partir de
	 * PatternLabyrinthe
	 */
	public void genererMonstre() {
		int nbMonstres = 0;
		for (int i = 0; i < this.grille.length; i++) {
			for (int j = 0; j < this.grille.length; j++) {
				if (this.grille[j][i].getEtat() >= 10 && this.grille[j][i].getEtat() < 20) {
					nbMonstres++;
				}
			}
		}
		this.tabMonstre = new Monstre[nbMonstres];
		int ind = 0;
		for (int i = 0; i < this.grille.length; i++) {
			for (int j = 0; j < this.grille.length; j++) {
				if (this.grille[j][i].getEtat() >= 10 && this.grille[j][i].getEtat() < 20) {
					this.tabMonstre[ind] = creerMonstre(this.grille[j][i]);
					ind++;
				}
			}
		}
	}

	/**
	 * M�thode permettant de creer un monstre � la case c
	 * 
	 * @param c
	 *            Case de cr�ation du monstre
	 * @return m Monstre cr�e
	 */
	public Monstre creerMonstre(Case c) {
		Monstre m = null;
		switch (c.getEtat()) {
		case 10:
			m = new Gnome(c);
			break;
		case 11:
			m = new Fantome(c);
			break;
		case 12:
			m = new Fantome(c);
			break;
		case 13:
			m = new Troll(c);
			break;
		case 14:
			m = new Colosse(c);
			break;
		}
		return m;
	}

	/**
	 * M�thode qui d�place l'aventurier au sein du Labyrinthe Si l'aventurier est au
	 * dernier niveau et � la Case bonus Alors sa vie est augment�e au maximum et
	 * son attaque est augment�e aussi
	 * 
	 * @param s
	 *            Action souhait�e : Nord/Sud/Ouest/Est
	 * @return true si le d�placement a bien abouti
	 */
	public boolean seDeplacer(String s) {
		boolean res = false;
		int x = this.avent.getC().getX();
		int y = this.avent.getC().getY();
		switch (s) {
		case "e":
			if (this.avent.estDisponible(x + 1, y, this.grille)) {
				if (this.grille[x + 1][y].getEtat() == Case.ECHELLE) {
					this.nouvelEtage();
				} else {
					this.avent.modifierCoords(this.grille[x + 1][y]);
					res = true;
				}
			}
			break;
		case "o":
			if (this.avent.estDisponible(x - 1, y, this.grille)) {
				if (this.grille[x - 1][y].getEtat() == Case.ECHELLE) {
					this.nouvelEtage();
				} else {
					this.avent.modifierCoords(this.grille[x - 1][y]);
					res = true;
				}
			}
			break;
		case "n":
			if (this.avent.estDisponible(x, y - 1, this.grille)) {
				if (this.grille[x][y - 1].getEtat() == Case.ECHELLE) {
					this.nouvelEtage();
				} else {
					this.avent.modifierCoords(this.grille[x][y - 1]);
					res = true;
				}
			}
			break;
		case "s":
			if (this.avent.estDisponible(x, y + 1, this.grille)) {
				if (this.grille[x][y + 1].getEtat() == Case.ECHELLE) {
					this.nouvelEtage();
				} else {
					this.avent.modifierCoords(this.grille[x][y + 1]);
					res = true;
				}
			}
			break;
		}
		if (this.avent.getC().getX() == 8 && this.avent.getC().getY() == 7 && boss) {
			this.avent.setDegats(500);
			this.grille[7][7].setEtat(Case.VIDE);
			this.avent.regenererAventurier(this.avent.getVieBase());
			for (int i = 0; i < this.tabMonstre.length; i++) {
				this.tabMonstre[i].setVision(100);
				this.tabMonstre[i].setDegats(15);
			}
			boss = false;
			res = false;
			this.deplacerMonstre();
		}
		if (this.avent.getC().getX() == 7 && this.avent.getC().getY() == 7 && boss) {
			this.avent.setVie(1);
			this.grille[8][7].setEtat(Case.VIDE);
			for (int i = 0; i < this.tabMonstre.length; i++) {
				this.tabMonstre[i].setVision(100);
			}
			boss = false;
			res = false;
			this.deplacerMonstre();
		}
		return res;
	}

	/**
	 * M�thode �voluer qui d�roule le jeu Avec plusieurs types de commandes :
	 * Haut/Bas/Droit/Gauche/TP/Repousse/Attaquer
	 * 
	 * @param commandeUser
	 *            Commande saisie par le joueur
	 */
	@Override
	public void evoluer(Commande commandeUser) {
		if (commandeUser.bas) {
			if (this.seDeplacer("s")) {
				this.Regeneration();
				this.deplacerMonstre();
				this.faireAttaquerMonstre();
			}
		}
		if (commandeUser.haut) {
			if (this.seDeplacer("n")) {
				this.Regeneration();
				this.deplacerMonstre();
				this.faireAttaquerMonstre();
			}
		}
		if (commandeUser.droite) {
			if (this.seDeplacer("e")) {
				this.Regeneration();
				this.deplacerMonstre();
				this.faireAttaquerMonstre();
			}
		}
		if (commandeUser.gauche) {
			if (this.seDeplacer("o")) {
				this.Regeneration();
				this.deplacerMonstre();
				this.faireAttaquerMonstre();
			}
		}
		if (commandeUser.attaque) {
			this.getAvent().attaquer(this, false);
			this.deplacerMonstre();
		}
		if (commandeUser.tp) {
			this.teleportationAventurier();
			tp++;
		}
		if (commandeUser.repousse) {
			if (this.repousse < 3) {
				this.avent.attaquer(this, true);
			}
			this.repousse++;
		}

		int nbreMort = 0;
		for (int i = 0; i < tabMonstre.length; i++) {
			if (this.tabMonstre[i].etreMort()) {
				nbreMort++;
			}
		}
		Monstre[] tab = new Monstre[tabMonstre.length - nbreMort];
		int ind = 0;
		for (int i = 0; i < tabMonstre.length; i++) {
			if (!this.tabMonstre[i].etreMort()) {
				tab[ind] = this.tabMonstre[i];
				ind++;
			} else {
				if (this.tabMonstre[i] instanceof Fantome) {
					this.tabMonstre[i].getC().setEtat(this.tabMonstre[i].getC().getEtat() - Case.FANTOME_VIDE);
				} else {
					this.tabMonstre[i].getC().setEtat(0);
				}
			}
		}
		tabMonstre = tab;
	}

	/**
	 * M�thode qui fait attaquer tout les monstres si ils sont assez proches de
	 * l'aventurier
	 */
	public void faireAttaquerMonstre() {
		for (int i = 0; i < this.tabMonstre.length; i++) {
			this.tabMonstre[i].attaquer(this);
		}
	}

	/**
	 * M�thode qui retourne l'aventurier du labyrinthe
	 * 
	 * @return Aventurier aventurier du labyrinthe
	 */
	public Aventurier getAvent() {
		return this.avent;
	}

	/**
	 * M�thode qui retourne la Case donn�e de la grille
	 * 
	 * @param i
	 *            abscisse de la case demand�e
	 * @param j
	 *            ordonn�e de la case demand�e
	 * @return case Case demand�e par rapport aux abscisses et ordonn�es en
	 *         param�tre
	 */
	public Case getCase(int i, int j) {
		return this.grille[i][j];
	}

	/**
	 * Retourne la largeur du labyrinthe
	 * 
	 * @return int largeur du labyrinthe
	 */
	public int getLargeur() {
		return this.largeur;
	}

	/**
	 * M�thode qui retourne le tableau de tous les monstres
	 * 
	 * @return Monstre[] tableau de tous les monstres du labyrinthe
	 */
	public Monstre[] getMonstre() {
		return this.tabMonstre;
	}

	/**
	 * M�thode qui indique si le jeu est fini
	 * 
	 * @return boolean si le h�ros est mort ou a fini le jeu
	 */
	@Override
	public boolean etreFini() {
		boolean res = false;
		if (this.avent.getVie() == 0 || (this.getLargeur() == 16 && this.tabMonstre.length == 0)) {
			res = true;
		}
		return res;
	}

	/**
	 * M�thode qui d�place les monstres le plus rapidement possible vers
	 * l'aventurier Si le monstre est trop loin et ne voit pas l'aventurier : alors
	 * il ne se d�place pas
	 */
	public void deplacerMonstre() {
		int xAv = this.avent.getC().getX();
		int yAv = this.avent.getC().getY();
		for (int i = 0; i < this.tabMonstre.length; i++) {
			int x = this.tabMonstre[i].getC().getX();
			int y = this.tabMonstre[i].getC().getY();
			double d1 = 100, d2 = 100, d3 = 100, d4 = 100;
			if (this.tabMonstre[i].estDisponible(x - 1, y, this.grille)) {
				d1 = Math.sqrt(((xAv - x + 1) * (xAv - x + 1)) + (yAv - y) * (yAv - y));
			}
			if (this.tabMonstre[i].estDisponible(x + 1, y, this.grille)) {
				d2 = Math.sqrt(((xAv - x - 1) * (xAv - x - 1)) + (yAv - y) * (yAv - y));
			}
			if (this.tabMonstre[i].estDisponible(x, y - 1, this.grille)) {
				d3 = Math.sqrt(((xAv - x) * (xAv - x)) + (yAv - y + 1) * (yAv - y + 1));
			}
			if (this.tabMonstre[i].estDisponible(x, y + 1, this.grille)) {
				d4 = Math.sqrt(((xAv - x) * (xAv - x)) + (yAv - y - 1) * (yAv - y - 1));
			}
			double distance = Math.sqrt(((xAv - x) * (xAv - x)) + (yAv - y) * (yAv - y));
			boolean test = false;
			distance = Math.min(distance, Math.min(Math.min(d1, d2), Math.min(d3, d4)));
			if (test != true) {
				if (distance == d1 && this.tabMonstre[i].getVision() > distance) {
					this.tabMonstre[i].modifierCoords(this.grille[x - 1][y]);
				}
				if (distance == d2 && this.tabMonstre[i].getVision() > distance) {
					this.tabMonstre[i].modifierCoords(this.grille[x + 1][y]);
				}
				if (distance == d3 && this.tabMonstre[i].getVision() > distance) {
					this.tabMonstre[i].modifierCoords(this.grille[x][y - 1]);
				}
				if (distance == d4 && this.tabMonstre[i].getVision() > distance) {
					this.tabMonstre[i].modifierCoords(this.grille[x][y + 1]);
				}
			}
		}
	}

	/**
	 * M�thode qui permet � l'aventurier de se t�l�porter et de revenir au d�but du
	 * labyrinthe
	 */
	public void teleportationAventurier() {
		if (this.tp < 1 && this.avent.estDisponible(this.largeur / 2, this.largeur - 1, this.grille)) {
			this.grille[this.avent.getC().getX()][this.avent.getC().getY()].setEtat(0);
			this.avent.modifierCoords(this.grille[this.largeur / 2][this.largeur - 1]);
			if(this.largeur==16){
				this.avent.regenererAventurier(this.avent.getVieBase());
			}
		}
	}

	/**
	 * M�thode qui retourne la grille de labyrinthe
	 * 
	 * @return Case[][] ensemble des cases du labyrinthe sous forme de tableau �
	 *         double dimensions
	 */
	public Case[][] getCases() {
		return this.grille;
	}

	public void Regeneration() {
		this.avent.regenererAventurier(5);
		for (int i = 0; i < tabMonstre.length; i++) {
			if (this.tabMonstre[i] instanceof Troll) {
				((Troll) tabMonstre[i]).regenererTroll(5);
			}
		}
	}

}
