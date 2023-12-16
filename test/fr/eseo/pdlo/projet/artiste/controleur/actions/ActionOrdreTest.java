package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.junit.jupiter.api.Test;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.modele.formes.Carre;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueCarre;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauBarreEtat;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

public class ActionOrdreTest {
	public ActionOrdreTest() {
		testEffacer();
	}
	
	@Test
	private void testEffacer() {
		JFrame fenetre = new JFrame("Etre un Artiste - Ordre");

		PanneauDessin panneau = new PanneauDessin();
		PanneauBarreEtat barreEtat = new PanneauBarreEtat(panneau);
		
		Carre carre1 = new Carre();
		Carre carre2 = new Carre(new Coordonnees(50,50),80);
		Carre carre3 = new Carre(new Coordonnees(0,50),70);
		Carre carre4 = new Carre(new Coordonnees(50,0), 90);
		
		carre1.setRemplissage(Remplissage.UNIFORME);
		carre2.setRemplissage(Remplissage.UNIFORME);
		carre3.setRemplissage(Remplissage.UNIFORME);
		carre4.setRemplissage(Remplissage.UNIFORME);
		
		carre1.setCouleur(Color.BLACK);
		carre2.setCouleur(Color.CYAN);
		carre3.setCouleur(Color.GREEN);
		carre4.setCouleur(Color.GRAY);
		
		VueCarre noir = new VueCarre(carre1);
		VueCarre cyan = new VueCarre(carre2);
		VueCarre vert = new VueCarre(carre3);
		VueCarre gris = new VueCarre(carre4);
		
		panneau.ajouterVueForme(noir);
		panneau.ajouterVueForme(cyan);
		panneau.ajouterVueForme(vert);
		panneau.ajouterVueForme(gris);
		
		panneau.getVueFormes().add(0, gris);
		panneau.getVueFormes().remove(4);
		
		JLabel c1 = new JLabel("noir"+ panneau.getVueFormes().indexOf(noir));
		JLabel c2 = new JLabel("cyan"+ panneau.getVueFormes().indexOf(cyan));
		JLabel c3 = new JLabel("vert"+ panneau.getVueFormes().indexOf(vert));
		JLabel c4 = new JLabel("gris"+ panneau.getVueFormes().indexOf(gris));
		
		barreEtat.add(c1);
		barreEtat.add(c2);
		barreEtat.add(c3);
		barreEtat.add(c4);
		
		fenetre.add(panneau);
		fenetre.add(barreEtat, BorderLayout.SOUTH);
		
		fenetre.pack();
		fenetre.setVisible(true);
		
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String [] args) {
		new ActionOrdreTest();
	}
}
