package fr.eseo.pdlo.projet.artiste.modele.formes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;
import java.util.Locale;

import org.junit.jupiter.api.Test;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;

public class RectangleTest{
	
	@Test
	public void testConstructeurs() {
		Rectangle rect = new Rectangle();
		Rectangle rectPos = new Rectangle(new Coordonnees(5,10));
		Rectangle rectLH = new Rectangle(8,26);

		assertEquals(0, rect.getPosition().getAbscisse(),"Abscisse (r1) : ");
		assertEquals(0, rect.getPosition().getOrdonnee(),"Ordonnee (r1) : ");
		assertEquals(100, rect.getLargeur(),"Largeur (r1) : ");
		assertEquals(150, rect.getHauteur(),"Hauteur (r1) : ");
		
		assertEquals(5, rectPos.getPosition().getAbscisse(),"Abscisse (r2) : ");
		assertEquals(10, rectPos.getPosition().getOrdonnee(),"Ordonnee (r2) : ");
		assertEquals(100, rectPos.getLargeur(),"Largeur (r2) : ");
		assertEquals(150, rectPos.getHauteur(),"Hauteur (r2) : ");
		
		assertEquals(0, rectLH.getPosition().getAbscisse(),"Abscisse (r3) : ");
		assertEquals(0, rectLH.getPosition().getOrdonnee(),"Ordonnee (r3) : ");
		assertEquals(8, rectLH.getLargeur(),"Largeur (r3) : ");
		assertEquals(26, rectLH.getHauteur(),"Hauteur (r3) : ");
	}
	
	@Test
	public void testCouleur() {
		Rectangle rect = new Rectangle();
		rect.setCouleur(Color.GREEN);
		
		assertEquals(Color.GREEN, rect.getCouleur(), "Couleur");
		assertEquals(Remplissage.AUCUNE, rect.getRemplissage(), "Remplissage vide");
		
		rect.setRemplissage(Remplissage.UNIFORME);
		
		assertEquals(Color.GREEN, rect.getCouleur(), "Couleur");
		assertEquals(Remplissage.UNIFORME, rect.getRemplissage(), "Remplissage uniforme");
	}
	
	@Test
	public void testCadreMinMax() {
		Rectangle rect = new Rectangle(new Coordonnees(77,77), 156, 100);
		
		assertEquals(77,0, rect.getCadreMinX(), "Cadre min X");
		assertEquals(77,0, rect.getCadreMinX(), "Cadre min Y");
		assertEquals(233,0, rect.getCadreMaxX(), "Cadre max X");
		assertEquals(177,0, rect.getCadreMaxX(), "Cadre max Y");
	}
	
	@Test
	public void testContient() {
		Rectangle rect = new Rectangle(new Coordonnees(77,77), 156, 100);
		Coordonnees cOK = new Coordonnees(100,100);
		Coordonnees cHaut = new Coordonnees(120,0);
		Coordonnees cBas = new Coordonnees(120,300);
		Coordonnees cDroite = new Coordonnees(0,120);
		Coordonnees cGauche = new Coordonnees(300,120);
		
		assertEquals(true, rect.contient(cOK), "Le point ok est dans le rectangle");
		assertEquals(false, rect.contient(cHaut), "Le point trop en haut");
		assertEquals(false, rect.contient(cBas), "Le point trop en bas");
		assertEquals(false, rect.contient(cDroite), "Le point trop à droite");
		assertEquals(false, rect.contient(cGauche), "Le point trop à gauche");
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testToString() {
		Rectangle rectangle = new Rectangle(new Coordonnees(77,77), 156, 100);
	
		assertEquals("[Rectangle Aucune] c1 : (77,0 , 77,0) c2 : (233,0 , 77,0) "
				+ "c3 : (77,0 , 177,0) c4 : (233,0 , 177,0) "
				+ "périmètre : 512,0 aire : 15600,0 couleur = R51,V51,B51", rectangle.toString(), "Texte rectangle FR");
		
		Locale locale = Locale.getDefault();
		locale.setDefault(Locale.ENGLISH);
		
		assertEquals("[Rectangle Aucune] c1 : (77.0 , 77.0) c2 : (233.0 , 77.0) "
				+ "c3 : (77.0 , 177.0) c4 : (233.0 , 177.0) "
				+ "périmètre : 512.0 aire : 15600.0 couleur = R51,G51,B51", rectangle.toString(), "Texte rectangle EN");
		
		locale.setDefault(Locale.FRENCH);
	} 
}
