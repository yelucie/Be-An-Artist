package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.BorderLayout;

import javax.swing.JFrame;

import org.junit.jupiter.api.Test;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauBarreEtat;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionSelectionnerTest {
	public ActionSelectionnerTest() {
		testSelectionner();
	}
	
	@Test
	private void testSelectionner() {
		JFrame fenetre = new JFrame("Etre un Artiste - Sélection");

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
		new ActionSelectionnerTest();
	}
}
