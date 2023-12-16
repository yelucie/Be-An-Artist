package fr.eseo.pdlo.projet.artiste.vue.ihm;

import org.junit.jupiter.api.Test;

import java.awt.Color;
import javax.swing.JFrame;

public class PanneauDessinTest {
	
	public PanneauDessinTest() {
		testConstructeurParDefaut();
		testConstructeur();
	}
	
	@Test
	private void testConstructeurParDefaut(){
		JFrame fenetre = new JFrame("Etre un Artiste");
		
		PanneauDessin panneau = new PanneauDessin();
		fenetre.add(panneau);
		fenetre.pack();
		fenetre.setVisible(true);
		
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	@Test
	private void testConstructeur(){
		JFrame fenetre = new JFrame("Blues du Businessman");
		
		PanneauDessin panneau = new PanneauDessin(1000,1000,Color.cyan);
		fenetre.add(panneau);
		fenetre.pack();
		fenetre.setVisible(true);
		
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String [] args) {
		new PanneauDessinTest();
	}
}
