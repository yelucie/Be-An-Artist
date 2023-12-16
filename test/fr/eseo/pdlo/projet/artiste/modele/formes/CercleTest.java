package fr.eseo.pdlo.projet.artiste.modele.formes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Locale;

import org.junit.jupiter.api.Test;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public class CercleTest{
	
	@Test
	public void testConstructeurs() {
		Cercle cercle = new Cercle();
		Ellipse cerclePos = new Cercle(new Coordonnees(5,10));
		Ellipse cercleT = new Cercle(26);

		assertEquals(0, cercle.getPosition().getAbscisse(),"Abscisse (c1) : ");
		assertEquals(0, cercle.getPosition().getOrdonnee(),"Ordonnee (c1) : ");
		assertEquals(100, cercle.getLargeur(),"Largeur (c1) : ");
		assertEquals(100, cercle.getHauteur(),"Hauteur (c1) : ");
		
		assertEquals(5, cerclePos.getPosition().getAbscisse(),"Abscisse (c2) : ");
		assertEquals(10, cerclePos.getPosition().getOrdonnee(),"Ordonnee (c2) : ");
		assertEquals(100, cerclePos.getLargeur(),"Largeur (c2) : ");
		assertEquals(100, cerclePos.getHauteur(),"Hauteur (c2) : ");
		
		assertEquals(0, cercleT.getPosition().getAbscisse(),"Abscisse (c3) : ");
		assertEquals(0, cercleT.getPosition().getOrdonnee(),"Ordonnee (c3) : ");
		assertEquals(26, cercleT.getLargeur(),"Largeur (c3) : ");
		assertEquals(26, cercleT.getHauteur(),"Hauteur (c3) : ");
	}
	
	@SuppressWarnings("unused")
	@Test
	public void testException() {
		String erreurMsg = "";
		try {
			Cercle cercleErreur = new Cercle(-5);
		} catch(Exception e) {
			erreurMsg = e.getMessage();
		}
		
		assertEquals("La taille doit être positive!", erreurMsg);
		
		try {
			Cercle cercleErreur = new Cercle(5);
			cercleErreur.setHauteur(-9);
		} catch(Exception e) {
			erreurMsg = e.getMessage();
		}
		
		assertEquals("La taille doit être positive!", erreurMsg);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void testToString() {
		Cercle cercle = new Cercle(new Coordonnees(10,10),50.5);
	
		assertEquals("[Cercle Aucune] : pos (10,0 , 10,0) rayon 25,25 "
				+ "périmètre : 158,65 aire : 2002,96 couleur = R51,V51,B51", cercle.toString(), "Texte de l'ellipse");
		
		Locale locale = Locale.getDefault();
		locale.setDefault(Locale.ENGLISH);
		
		assertEquals("[Cercle Aucune] : pos (10.0 , 10.0) rayon 25.25 "
				+ "périmètre : 158.65 aire : 2002.96 couleur = R51,G51,B51", cercle.toString(), "Texte de l'ellipse");
		
		locale.setDefault(Locale.FRENCH);
	}
}
