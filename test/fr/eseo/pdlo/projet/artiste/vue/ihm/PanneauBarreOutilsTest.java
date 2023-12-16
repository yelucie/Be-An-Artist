package fr.eseo.pdlo.projet.artiste.vue.ihm;

import org.junit.jupiter.api.Test;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class PanneauBarreOutilsTest {
	public PanneauBarreOutilsTest() {
		testEffacer();
	}
	
	@Test
	private void testEffacer() {
		JFrame fenetre = new JFrame("Etre un Artiste - Barre Outils");

		PanneauDessin panneau = new PanneauDessin();
		PanneauBarreEtat barreEtat = new PanneauBarreEtat(panneau);
		PanneauBarreOutils barreOutil = new PanneauBarreOutils(panneau);
		
		fenetre.add(panneau);
		fenetre.add(barreEtat, BorderLayout.SOUTH);
		fenetre.add(barreOutil, BorderLayout.EAST);
		
		fenetre.pack();
		fenetre.setVisible(true);
		
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String [] args) {
		new PanneauBarreOutilsTest();
	}
}
