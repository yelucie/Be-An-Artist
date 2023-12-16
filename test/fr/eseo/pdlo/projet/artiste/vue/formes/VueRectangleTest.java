package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.Color;

import javax.swing.JFrame;
import org.junit.jupiter.api.Test;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Rectangle;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class VueRectangleTest {
	
	public VueRectangleTest() {
		test();
	}
	
	@Test
	private void test(){
		JFrame fenetre = new JFrame("Etre un Artiste - Rectangles");
		
		PanneauDessin panneau = new PanneauDessin();
		
		Rectangle rect1 = new Rectangle();
		Rectangle rect2 = new Rectangle(new Coordonnees(100,100),-50,-76);
		Rectangle rect3 = new Rectangle(new Coordonnees(300,20),-60,70);
		Rectangle rect4 = new Rectangle(new Coordonnees(400,100),90,-50);
		
		rect1.setCouleur(Color.BLACK);
		rect2.setCouleur(Color.CYAN);
		rect3.setCouleur(Color.GREEN);	
		rect4.setCouleur(Color.RED);
		
		VueRectangle unRect = new VueRectangle(rect1);
		VueRectangle unAutreRect = new VueRectangle(rect2);
		VueRectangle unEncoreAutreRect = new VueRectangle(rect3);
		VueRectangle unDernierRect = new VueRectangle(rect4);
		
		panneau.ajouterVueForme(unRect);
		panneau.ajouterVueForme(unAutreRect);
		panneau.ajouterVueForme(unEncoreAutreRect);
		panneau.ajouterVueForme(unDernierRect);
		
		panneau.repaint();
		
		fenetre.add(panneau);
		fenetre.pack();
		fenetre.setVisible(true);
		
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String [] args) {
		new VueRectangleTest();
	}
}
