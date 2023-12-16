package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.Color;
import javax.swing.JFrame;
import org.junit.jupiter.api.Test;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class VueEllipseTest {
	
	public VueEllipseTest() {
		test();
	}
	
	@Test
	private void test(){
		JFrame fenetre = new JFrame("Etre un Artiste - Ellipses");
		
		PanneauDessin panneau = new PanneauDessin();
		
		Ellipse ellipse1 = new Ellipse();
		Ellipse ellipse2 = new Ellipse(new Coordonnees(100,100), 50,76);
		Ellipse ellipse3 = new Ellipse(new Coordonnees(300,20),60,70);
		Ellipse ellipse4 = new Ellipse(new Coordonnees(400,100),90,50);
		
		ellipse1.setCouleur(Color.BLACK);
		ellipse2.setCouleur(Color.CYAN);
		ellipse3.setCouleur(Color.GREEN);
		ellipse4.setCouleur(Color.RED);
		
		VueEllipse unEllipse = new VueEllipse(ellipse1);
		VueEllipse unAutreEllipse = new VueEllipse(ellipse2);
		VueEllipse unEncoreAutreEllipse = new VueEllipse(ellipse3);
		VueEllipse unDernierEllipse = new VueEllipse(ellipse4);
		
		panneau.ajouterVueForme(unEllipse);
		panneau.ajouterVueForme(unAutreEllipse);
		panneau.ajouterVueForme(unEncoreAutreEllipse);
		panneau.ajouterVueForme(unDernierEllipse);
		
		panneau.repaint();
		
		fenetre.add(panneau);
		fenetre.pack();
		fenetre.setVisible(true);
		
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String [] args) {
		new VueEllipseTest();
	}
}
