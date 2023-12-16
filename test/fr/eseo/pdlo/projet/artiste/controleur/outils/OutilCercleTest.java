package fr.eseo.pdlo.projet.artiste.controleur.outils;


import javax.swing.JFrame;
import org.junit.Test;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class OutilCercleTest {
	
	public OutilCercleTest() {
		test();
	}
	
	@Test
	private void test(){
		JFrame fenetre = new JFrame("Etre un Artiste - Outil Cercle");
		PanneauDessin panneau = new PanneauDessin();
		OutilCercle outil = new OutilCercle();
		panneau.associerOutil(outil);

		fenetre.add(panneau);
		fenetre.pack();
		fenetre.setVisible(true);
		
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	
	public static void main(String [] args) {
		new OutilCercleTest();
	}
}
