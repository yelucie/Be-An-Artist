package fr.eseo.pdlo.projet.artiste.modele.formes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;
import java.util.Locale;

import org.junit.jupiter.api.Test;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;

public class EllipseTest{
	
	@Test
	public void testConstructeurs() {
		Ellipse ellipse = new Ellipse();
		Ellipse ellipsePos = new Ellipse(new Coordonnees(5,10));
		Ellipse ellipseLH = new Ellipse(8,26);

		assertEquals(0, ellipse.getPosition().getAbscisse(),"Abscisse (e1) : ");
		assertEquals(0, ellipse.getPosition().getOrdonnee(),"Ordonnee (e1) : ");
		assertEquals(100, ellipse.getLargeur(),"Largeur (e1) : ");
		assertEquals(150, ellipse.getHauteur(),"Hauteur (e1) : ");
		
		assertEquals(5, ellipsePos.getPosition().getAbscisse(),"Abscisse (e2) : ");
		assertEquals(10, ellipsePos.getPosition().getOrdonnee(),"Ordonnee (e2) : ");
		assertEquals(100, ellipsePos.getLargeur(),"Largeur (e2) : ");
		assertEquals(150, ellipsePos.getHauteur(),"Hauteur (e2) : ");
		
		assertEquals(0, ellipseLH.getPosition().getAbscisse(),"Abscisse (e3) : ");
		assertEquals(0, ellipseLH.getPosition().getOrdonnee(),"Ordonnee (e3) : ");
		assertEquals(8, ellipseLH.getLargeur(),"Largeur (e3) : ");
		assertEquals(26, ellipseLH.getHauteur(),"Hauteur (e3) : ");
	}
	
	@Test
	public void testCouleur() {
		Ellipse ellipse = new Ellipse();
		ellipse.setCouleur(Color.GREEN);
		
		assertEquals(Color.GREEN, ellipse.getCouleur(), "Couleur");
		assertEquals(Remplissage.AUCUNE, 
				ellipse.getRemplissage(), "Remplissage vide");
		
		ellipse.setRemplissage(Remplissage.UNIFORME);
		
		assertEquals(Color.GREEN, ellipse.getCouleur(), "Couleur");
		assertEquals(Remplissage.UNIFORME, 
				ellipse.getRemplissage(), "Remplissage uniforme");
	}
	
	@Test
	public void testContient() {
		Ellipse ellipse = new Ellipse();
		Coordonnees c1 = new Coordonnees();
		Coordonnees c2 = new Coordonnees(50,50);
		
		assertEquals(false, ellipse.contient(c1), "L'ellipse ne contient pas C1");
		assertEquals(true, ellipse.contient(c2), "L'ellipse contient C2");
	}
	
	@SuppressWarnings("unused")
	@Test
	public void testException() {
		String erreurMsg = "";
		try {
			Ellipse ellipseErreur = new Ellipse(-5,50);
		} catch(Exception e) {
			erreurMsg = e.getMessage();
		}
		
		assertEquals("La largeur doit être positive!", erreurMsg);
		
		try {
			Ellipse ellipseErreur = new Ellipse(5,-50);
		} catch(Exception e) {
			erreurMsg = e.getMessage();
		}
		
		assertEquals("La hauteur doit être positive!", erreurMsg);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testToString() {
		Ellipse ellipse = new Ellipse(new Coordonnees(10,10),25,15);
		
		assertEquals("[Ellipse Aucune] : pos (10,0 , 10,0) petit rayon 7,5 grand rayon 12,5 "
				+ "périmètre : 63,82 aire : 294,52 couleur = R51,V51,B51", ellipse.toString(), "Texte de l'ellipse FR");
		
		Locale locale = Locale.getDefault();
		locale.setDefault(Locale.ENGLISH);
		Ellipse ellipseAutre = new Ellipse(new Coordonnees(),100,50);
		
		assertEquals("[Ellipse Aucune] : pos (0.0 , 0.0) petit rayon 25.0 grand rayon "
				+ "50.0 périmètre : 242.21 aire : 3926.99 couleur = R51,G51,B51", ellipseAutre.toString(), "Texte de l'ellipse EN");
		
		locale.setDefault(Locale.FRENCH);
	}
}
