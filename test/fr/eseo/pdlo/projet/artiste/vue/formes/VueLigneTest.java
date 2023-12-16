package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.Color;

import javax.swing.JFrame;
import org.junit.jupiter.api.Test;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Ligne;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class VueLigneTest {
	
	public VueLigneTest() {
		test();
	}
	
	@Test
	private void test(){
		JFrame fenetre = new JFrame("Etre un Artiste - Lignes");
		
		PanneauDessin panneau = new PanneauDessin();
		
		Ligne ligne1 = new Ligne();
		Ligne ligne2 = new Ligne(new Coordonnees(100,100),-50,-76);
		Ligne ligne3 = new Ligne(new Coordonnees(300,20),-60,70);
		Ligne ligne4 = new Ligne(new Coordonnees(400,100),90,-50);
		
		ligne1.setCouleur(Color.BLACK);
		ligne2.setCouleur(Color.CYAN);
		ligne3.setCouleur(Color.GREEN);
		ligne4.setCouleur(Color.RED);
		
		VueLigne uneLigne = new VueLigne(ligne1);
		VueLigne uneAutreLigne = new VueLigne(ligne2);
		VueLigne uneEncoreAutreLigne = new VueLigne(ligne3);
		VueLigne uneDerniereLigne = new VueLigne(ligne4);
		
		panneau.ajouterVueForme(uneLigne);
		panneau.ajouterVueForme(uneAutreLigne);
		panneau.ajouterVueForme(uneEncoreAutreLigne);
		panneau.ajouterVueForme(uneDerniereLigne);
		
		panneau.repaint();
		
		fenetre.add(panneau);
		fenetre.pack();
		fenetre.setVisible(true);
		
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String [] args) {
		new VueLigneTest();
	}
}
