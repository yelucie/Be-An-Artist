package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.Color;
import javax.swing.JFrame;
import org.junit.jupiter.api.Test;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Cercle;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class VueCercleTest {
	
	public VueCercleTest() {
		test();
	}
	
	@Test
	private void test(){
		JFrame fenetre = new JFrame("Etre un Artiste - Cercles");
		
		PanneauDessin panneau = new PanneauDessin();
		
		Cercle cercle1 = new Cercle();
		Cercle cercle2 = new Cercle(new Coordonnees(100,100), 50);
		
		cercle1.setCouleur(Color.BLACK);
		cercle2.setCouleur(Color.CYAN);
		
		VueCercle unCercle = new VueCercle(cercle1);
		VueCercle unAutreCercle = new VueCercle(cercle2);
		
		panneau.ajouterVueForme(unCercle);
		panneau.ajouterVueForme(unAutreCercle);
		
		panneau.repaint();
		
		fenetre.add(panneau);
		fenetre.pack();
		fenetre.setVisible(true);
		
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String [] args) {
		new VueCercleTest();
	}
}
