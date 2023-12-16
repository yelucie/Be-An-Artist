package fr.eseo.pdlo.projet.artiste.modele;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CoordonneesTest {

	@Test
	public void testConstructeurs() {
		Coordonnees coordonnee1 = new Coordonnees(2.3, 5.1);
		Coordonnees coordonnee2 = new Coordonnees(-0.2, -4.33);
		
		assertEquals(2.3, coordonnee1.getAbscisse(), "L'abscisse c2: ");
		assertEquals(5.1, coordonnee1.getOrdonnee(), "L'ordonn�e c2: ");
		assertEquals(-0.2, coordonnee2.getAbscisse(), "L'abscisse c3: ");
		assertEquals(-4.33, coordonnee2.getOrdonnee(), "L'ordonn�e c3: ");
	}

	@Test
	public void testCoordonnees() {
		Coordonnees coordonnee1 = new Coordonnees();
		Coordonnees coordonnee2 = new Coordonnees();
		
		coordonnee1.deplacerVers(0.0,2.0);
		assertEquals(0.0, coordonnee1.getAbscisse(), "Abscisse d�plac�e vers :");
		assertEquals(2.0, coordonnee1.getOrdonnee(), "Ordonn�e d�plac�e vers :");

		coordonnee2.deplacerDe(2.0,0.0);
		assertEquals(2.0, coordonnee2.getAbscisse(), "Abscisse d�plac�e de :");
		assertEquals(0.0, coordonnee2.getOrdonnee(), "Ordonn�e d�plac�e de :");
		
		assertEquals(2.8284271247461903, coordonnee1.distanceVers(coordonnee2),"Distance :");
		assertEquals(-0.7853981633974483, coordonnee1.angleVers(coordonnee2),"Angle :");
	}
	
	@Test
	public void testToString() {
		Coordonnees coordonnee1 = new Coordonnees(2.3, 5.1);
		Coordonnees coordonnee2 = new Coordonnees(-7.9, 1.5);
		
		assertEquals("(2,3 , 5,1)", coordonnee1.toString(), "Coordonn�e 1 :");
		assertEquals("(-7,9 , 1,5)", coordonnee2.toString(), "Coordonn�e 2 :");
	}
}


