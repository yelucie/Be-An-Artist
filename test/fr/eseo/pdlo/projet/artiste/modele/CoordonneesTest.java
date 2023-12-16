package fr.eseo.pdlo.projet.artiste.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CoordonneesTest {

	@Test
	public void testConstructeurs() {
		Coordonnees coordonnee1 = new Coordonnees(2.3, 5.1);
		Coordonnees coordonnee2 = new Coordonnees(-0.2, -4.33);
		
		assertEquals(2.3, coordonnee1.getAbscisse(), "L'abscisse c2: ");
		assertEquals(5.1, coordonnee1.getOrdonnee(), "L'ordonnée c2: ");
		assertEquals(-0.2, coordonnee2.getAbscisse(), "L'abscisse c3: ");
		assertEquals(-4.33, coordonnee2.getOrdonnee(), "L'ordonnée c3: ");
	}

	@Test
	public void testCoordonnees() {
		Coordonnees coordonnee1 = new Coordonnees();
		Coordonnees coordonnee2 = new Coordonnees();
		
		coordonnee1.deplacerVers(0.0,2.0);
		assertEquals(0.0, coordonnee1.getAbscisse(), "Abscisse déplacée vers :");
		assertEquals(2.0, coordonnee1.getOrdonnee(), "Ordonnée déplacée vers :");

		coordonnee2.deplacerDe(2.0,0.0);
		assertEquals(2.0, coordonnee2.getAbscisse(), "Abscisse déplacée de :");
		assertEquals(0.0, coordonnee2.getOrdonnee(), "Ordonnée déplacée de :");
		
		assertEquals(2.8284271247461903, coordonnee1.distanceVers(coordonnee2),"Distance :");
		assertEquals(-0.7853981633974483, coordonnee1.angleVers(coordonnee2),"Angle :");
	}
	
	@Test
	public void testToString() {
		Coordonnees coordonnee1 = new Coordonnees(2.3, 5.1);
		Coordonnees coordonnee2 = new Coordonnees(-7.9, 1.5);
		
		assertEquals("(2,3 , 5,1)", coordonnee1.toString(), "Coordonnée 1 :");
		assertEquals("(-7,9 , 1,5)", coordonnee2.toString(), "Coordonnée 2 :");
	}
}


