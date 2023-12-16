package fr.eseo.pdlo.projet.artiste.modele.formes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Locale;

import org.junit.jupiter.api.Test;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public class CarreTest{
	
	@Test
	public void testConstructeurs() {
		Carre carre = new Carre();
		Carre carrePos = new Carre(new Coordonnees(5,10));
		Carre carreT = new Carre(26);

		assertEquals(0, carre.getPosition().getAbscisse(),"Abscisse (c1) : ");
		assertEquals(0, carre.getPosition().getOrdonnee(),"Ordonnee (c1) : ");
		assertEquals(100, carre.getLargeur(),"Largeur (c1) : ");
		assertEquals(100, carre.getHauteur(),"Hauteur (c1) : ");
		
		assertEquals(5, carrePos.getPosition().getAbscisse(),"Abscisse (c2) : ");
		assertEquals(10, carrePos.getPosition().getOrdonnee(),"Ordonnee (c2) : ");
		assertEquals(100, carrePos.getLargeur(),"Largeur (c2) : ");
		assertEquals(100, carrePos.getHauteur(),"Hauteur (c2) : ");
		
		assertEquals(0, carreT.getPosition().getAbscisse(),"Abscisse (c3) : ");
		assertEquals(0, carreT.getPosition().getOrdonnee(),"Ordonnee (c3) : ");
		assertEquals(26, carreT.getLargeur(),"Largeur (c3) : ");
		assertEquals(26, carreT.getHauteur(),"Hauteur (c3) : ");
	}
	
	@SuppressWarnings("unused")
	@Test
	public void testException() {
		String erreurMsg = "";
		try {
			Carre carreErreur = new Carre(-5);
		} catch(Exception e) {
			erreurMsg = e.getMessage();
		}
		
		assertEquals("La taille doit être positive!", erreurMsg);
		
		try {
			Carre carreErreur = new Carre(5);
			carreErreur.setHauteur(-9);
		} catch(Exception e) {
			erreurMsg = e.getMessage();
		}
		
		assertEquals("La taille doit être positive!", erreurMsg);
	}
	
	
	@SuppressWarnings("static-access")
	@Test
	public void testToString() {
		Carre carre = new Carre(new Coordonnees(77,77), 156);
	
		assertEquals("[Carré Aucune] c1 : (77,0 , 77,0) c2 : (233,0 , 77,0) "
				+ "c3 : (77,0 , 233,0) c4 : (233,0 , 233,0) "
				+ "périmètre : 624,0 aire : 24336,0 couleur = R51,V51,B51", carre.toString());
		
		Locale locale = Locale.getDefault();
		locale.setDefault(Locale.ENGLISH);
		
		assertEquals("[Carré Aucune] c1 : (77.0 , 77.0) c2 : (233.0 , 77.0) "
				+ "c3 : (77.0 , 233.0) c4 : (233.0 , 233.0) "
				+ "périmètre : 624.0 aire : 24336.0 couleur = R51,G51,B51", carre.toString());
		
		locale.setDefault(Locale.FRENCH);
	} 
}
