package main;

import moteurJeu.MoteurGraphique;
import projet_zeldiablo.Labyrinthe;

public class JeuLab {
	public final static int TAILLE = 800;

	public static void main(String[] args) throws InterruptedException {
		Labyrinthe lab = new Labyrinthe(15);
		MoteurGraphique mot = new MoteurGraphique(lab, lab.getLabyrintheDessin());
		mot.lancerJeu(TAILLE, TAILLE);
	}
}
