package fr.eseo.pdlo.projet.artiste.modele.formes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Color;
import java.util.Locale;

import org.junit.jupiter.api.Test;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public class LigneTest{
	
	@Test
	public void testConstructeurs() {
		Ligne ligne = new Ligne();
		Ligne lignePos = new Ligne(new Coordonnees(2,10));
		Ligne ligneLH = new Ligne(5,6);
		
		assertEquals(0, ligne.getC1().getAbscisse(),"Abscisse de C1 (l1) : ");
		assertEquals(0, ligne.getC1().getOrdonnee(),"Ordonnee de C1 (l1) : ");
		assertEquals(100, ligne.getC2().getAbscisse(),"Abscisse de C2 (l1) : ");
		assertEquals(150, ligne.getC2().getOrdonnee(),"Ordonnee de C2 (l1) : ");
		assertEquals(2, lignePos.getC1().getAbscisse(),"Abscisse de C1 (l2) : ");
		assertEquals(10, lignePos.getC1().getOrdonnee(),"Ordonnee de C1 (l2) : ");
		assertEquals(102, lignePos.getC2().getAbscisse(),"Abscisse de C2 (l2) : ");
		assertEquals(160, lignePos.getC2().getOrdonnee(),"Ordonnee de C2 (l2) : ");
		assertEquals(0, ligneLH.getC1().getAbscisse(),"Abscisse de C1 (l3) : ");
		assertEquals(0, ligneLH.getC1().getOrdonnee(),"Ordonnee de C1 (l3) : ");
		assertEquals(5, ligneLH.getC2().getAbscisse(),"Abscisse de C2 (l3) : ");
		assertEquals(6, ligneLH.getC2().getOrdonnee(),"Ordonnee de C2 (l3) : ");
	}
	
	
	@Test
	public void testAccesseurs() {
		Ligne ligne1 = new Ligne();
		ligne1.setC1(new Coordonnees(20,50));
		
		assertEquals(20, ligne1.getC1().getAbscisse(),"Abscisse de C1 (l1) : ");
		assertEquals(50, ligne1.getC1().getOrdonnee(),"Ordonnee de C1 (l1) : ");
		assertEquals(100, ligne1.getC2().getAbscisse(),"Abscisse de C2 (l1) : ");
		assertEquals(150, ligne1.getC2().getOrdonnee(),"Ordonnee de C2 (l1) : ");
		
		ligne1.setC2(new Coordonnees(150,60));
		
		assertEquals(20, ligne1.getC1().getAbscisse(),"Abscisse de C1 (l2) : ");
		assertEquals(50, ligne1.getC1().getOrdonnee(),"Ordonnee de C1 (l2) : ");
		assertEquals(150, ligne1.getC2().getAbscisse(),"Abscisse de C2 (l2) : ");
		assertEquals(60, ligne1.getC2().getOrdonnee(),"Ordonnee de C2 (l2) : ");
		
		ligne1.setCouleur(Color.GREEN);
		
		assertEquals(Color.GREEN, ligne1.getCouleur(), "Couleur");
	}
	
	@Test
	public void testCadreMaxMin() {
		Ligne ligne = new Ligne(new Coordonnees(77,77), 156, 100);
		
		assertEquals(77,0, ligne.getCadreMinX(), "Cadre min X");
		assertEquals(77,0, ligne.getCadreMinX(), "Cadre min Y");
		assertEquals(233,0, ligne.getCadreMaxX(), "Cadre max X");
		assertEquals(177,0, ligne.getCadreMaxX(), "Cadre max Y");
	}
	
	@Test
	public void testDeplacements() {
		Ligne ligne = new Ligne();
		
		ligne.deplacerDe(5.0, 5.0);
		assertEquals(5.0, ligne.getC1().getAbscisse(),"Abscisse de C1 : ");
		assertEquals(5.0, ligne.getC1().getOrdonnee(),"Ordonnee de C1 : ");
		assertEquals(105.0, ligne.getC2().getAbscisse(),"Abscisse de C2 : ");
		assertEquals(155.0, ligne.getC2().getOrdonnee(),"Ordonnee de C2 : ");
		
		ligne.deplacerVers(0, 0);
		assertEquals(0, ligne.getC1().getAbscisse(),"Abscisse de C1 : ");
		assertEquals(0, ligne.getC1().getOrdonnee(),"Ordonnee de C1 : ");
		assertEquals(100.0, ligne.getC2().getAbscisse(),"Abscisse de C2 : ");
		assertEquals(150.0, ligne.getC2().getOrdonnee(),"Ordonnee de C2 : ");

	}
	
	@Test
	public void testAirePerimetre() {
		Ligne ligne = new Ligne();
		
		assertEquals(0, ligne.aire(),"Aire : ");
		assertEquals(Math.sqrt(10000 + 22500), ligne.perimetre(),"Périmètre : ");
	}
	
	@Test
	public void testContient() {
		Coordonnees c1 = new Coordonnees();
		Coordonnees c2 = new Coordonnees(2,2);
		Ligne ligne = new Ligne(new Coordonnees(1,1), 3, 3);
		
		assertEquals(false, ligne.contient(c1), "Ligne ne contient pas C1 : ");
		assertEquals(true, ligne.contient(c2), "Ligne contient C2 : ");
	}
	
	
	@SuppressWarnings("static-access")
	@Test
	public void testToString() {
		Ligne ligne1 = new Ligne(new Coordonnees(10.0,10.0), -5.0, 20.0);
		Ligne ligne2 = new Ligne(new Coordonnees(97.98,43.34), -39.4, -52.9);
		
		assertEquals("[Ligne] c1 : (10,0 , 10,0) c2 : (5,0 , 30,0)"
				+ " longueur : 20,62 angle : 104,04° couleur = R51,V51,B51", ligne1.toString(), "Texte de la ligne 1 FR");
		assertEquals("[Ligne] c1 : (97,98 , 43,34) c2 : (58,58 , -9,56)"
				+ " longueur : 65,96 angle : 233,32° couleur = R51,V51,B51", ligne2.toString(), "Texte de la ligne 2 FR");
		
		Locale locale = Locale.getDefault();
		locale.setDefault(Locale.ENGLISH);
		assertEquals("[Ligne] c1 : (10.0 , 10.0) c2 : (5.0 , 30.0)"
				+ " longueur : 20.62 angle : 104.04° couleur = R51,G51,B51", ligne1.toString(), "Texte de la ligne 1 EN");
		assertEquals("[Ligne] c1 : (97.98 , 43.34) c2 : (58.58 , -9.56)"
				+ " longueur : 65.96 angle : 233.32° couleur = R51,G51,B51", ligne2.toString(), "Texte de la ligne 2 EN");
		
		locale.setDefault(Locale.FRENCH);
	} 
}
