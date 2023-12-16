package fr.eseo.pdlo.projet.artiste;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauBarreEtat;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class EtreUnArtiste{
	public static final String TITRE_PAR_DEFAUT = "Etre un Artiste";
	public static final String LARGEUR_PAR_DEFAUT = "640";
	public static final String HAUTEUR_PAR_DEFAUT = "650";
	
	private PanneauDessin panneau;
	private PanneauBarreOutils barreOutils;
	private PanneauBarreEtat barreEtat;
	
	public void etreUnArtiste(String titre, String largeur, String hauteur) {
		JFrame fenetre = new JFrame(titre);
		this.panneau = new PanneauDessin();
		this.barreOutils = new PanneauBarreOutils(this.panneau);
		this.barreEtat = new PanneauBarreEtat(this.panneau);
		
		fenetre.add(this.panneau, BorderLayout.CENTER);
		fenetre.add(this.barreEtat, BorderLayout.SOUTH);
		fenetre.add(this.barreOutils, BorderLayout.EAST);
		
		try {
			int larg = Integer.valueOf(largeur);
			int haut = Integer.valueOf(hauteur);
			this.panneau.setSize(larg, haut);
		} catch(Exception nfe) {
			this.panneau.setSize(Integer.valueOf(LARGEUR_PAR_DEFAUT), 
					Integer.valueOf(HAUTEUR_PAR_DEFAUT));
		}
		
		fenetre.pack();
		fenetre.setVisible(true);
		
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void defaut() {
		etreUnArtiste(TITRE_PAR_DEFAUT, LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
	}

	public static void main(String[] arg) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				EtreUnArtiste main = new EtreUnArtiste();
				if(arg.length != 3) {
					main.defaut();
				} else {
					main.etreUnArtiste(arg[0], arg[1], arg[2]);
				}
			}
		});
	}
}