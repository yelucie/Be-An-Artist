package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.Color;

import javax.swing.JFrame;
import org.junit.jupiter.api.Test;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Carre;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class VueCarreTest {
	
	public VueCarreTest() {
		test();
	}
	
	@Test
	private void test(){
		JFrame fenetre = new JFrame("Etre un Artiste - Carrés");
		
		PanneauDessin panneau = new PanneauDessin();
		
		Carre carre1 = new Carre();
		Carre carre2 = new Carre(new Coordonnees(100,100),50);
		Carre carre3 = new Carre(new Coordonnees(300,20),70);
		
		carre1.setCouleur(Color.BLACK);
		carre2.setCouleur(Color.CYAN);
		carre3.setCouleur(Color.GREEN);	
		
		VueCarre unCarre = new VueCarre(carre1);
		VueCarre unAutreCarre = new VueCarre(carre2);
		VueCarre unEncoreAutreCarre = new VueCarre(carre3);
		
		panneau.ajouterVueForme(unCarre);
		panneau.ajouterVueForme(unAutreCarre);
		panneau.ajouterVueForme(unEncoreAutreCarre);
		
		panneau.repaint();
		
		fenetre.add(panneau);
		fenetre.pack();
		fenetre.setVisible(true);
		
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String [] args) {
		new VueCarreTest();
	}
}
