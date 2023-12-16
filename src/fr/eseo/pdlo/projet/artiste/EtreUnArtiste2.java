package fr.eseo.pdlo.projet.artiste;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauBarreEtat;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class EtreUnArtiste2{
	public static final String TITRE_PAR_DEFAUT = "Etre un Artiste";
	public static final int LARGEUR_PAR_DEFAUT = 640;
	public static final int HAUTEUR_PAR_DEFAUT = 650;
	
	private PanneauDessin panneau;
	private PanneauBarreOutils barreOutils;
	private PanneauBarreEtat barreEtat;
	
	public EtreUnArtiste2(String titre, int largeur, int hauteur) {
		JFrame fenetre = new JFrame(titre);
		this.panneau = new PanneauDessin(largeur, hauteur, Color.white);
		this.barreOutils = new PanneauBarreOutils(this.panneau);
		this.barreEtat = new PanneauBarreEtat(this.panneau);
		
		fenetre.add(this.panneau, BorderLayout.CENTER);
		fenetre.add(this.barreEtat, BorderLayout.SOUTH);
		fenetre.add(this.barreOutils, BorderLayout.EAST);
		
		fenetre.pack();
		fenetre.setVisible(true);
		
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public EtreUnArtiste2() {
		this(TITRE_PAR_DEFAUT, LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
	}
	
	@SuppressWarnings("unused")
	public static void choixPerso() {
		String titre = (String) JOptionPane.showInputDialog(new JFrame(TITRE_PAR_DEFAUT + " - Choix du titre"),
				"Choisissez un titre", TITRE_PAR_DEFAUT + " - Choix du titre", JOptionPane.QUESTION_MESSAGE,
				null, null, null);
		if(titre.equals("")) {
			titre = TITRE_PAR_DEFAUT;
		}
		
		String dimensionLargeur = (String) JOptionPane.showInputDialog(new JFrame(titre + " - Choix de la largeur"),
				"Choisissez une largeur", titre + " - Choix de la taille", JOptionPane.PLAIN_MESSAGE,
				null, null, null);
		if(!estNombre(dimensionLargeur)) {
			dimensionLargeur = String.valueOf(LARGEUR_PAR_DEFAUT);
		}
		int largeur = Integer.parseInt(dimensionLargeur);
		if(largeur <= 0) {
			largeur = LARGEUR_PAR_DEFAUT;
		}
		
		String dimensionHauteur = (String) JOptionPane.showInputDialog(new JFrame(titre + " - Choix de la hauteur"),
				"Choisissez une hauteur", titre + " - Choix de la taille", JOptionPane.PLAIN_MESSAGE,
				null, null, null);
		if(!estNombre(dimensionHauteur)) {
			dimensionHauteur = String.valueOf(HAUTEUR_PAR_DEFAUT);
		}
		int hauteur = Integer.parseInt(dimensionHauteur);
		if(hauteur <= 0) {
			hauteur = HAUTEUR_PAR_DEFAUT;
		}
		
		EtreUnArtiste2 appli = new EtreUnArtiste2(titre, largeur, hauteur);
	}
	
	@SuppressWarnings("unused")
	public static boolean estNombre(String nb) {
		if (nb == null) {
			return false;
		}
		try {
			int i = Integer.parseInt(nb);
			} catch (NumberFormatException nfe) {
		        return false;
		        }
		    return true;	    
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] arg) {
		Object[] modes = {"Standard", "Personnalisé"};
		String instruction = (String) JOptionPane.showInputDialog(new JFrame(TITRE_PAR_DEFAUT),
		        "Choisissez un mode", TITRE_PAR_DEFAUT, JOptionPane.PLAIN_MESSAGE, null,
		        modes, modes[0]);
		
		if(instruction.equals("Standard")) {
			EtreUnArtiste2 appli = new EtreUnArtiste2();
		}
		else {
			choixPerso();
		}
	}
}