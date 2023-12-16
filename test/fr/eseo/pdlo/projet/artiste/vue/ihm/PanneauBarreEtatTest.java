package fr.eseo.pdlo.projet.artiste.vue.ihm;

import org.junit.jupiter.api.Test;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class PanneauBarreEtatTest {
	public PanneauBarreEtatTest() {
		test();
	}
	
	@Test
	private void test() {
		JFrame fenetre = new JFrame("Etre un Artiste - Souris");

		PanneauDessin panneau = new PanneauDessin();
		PanneauBarreEtat barreEtat = new PanneauBarreEtat(panneau);
		fenetre.add(panneau);

		fenetre.add(barreEtat, BorderLayout.SOUTH);
		
		fenetre.pack();
		fenetre.setVisible(true);
		
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String [] args) {
		new PanneauBarreEtatTest();
	}
}
