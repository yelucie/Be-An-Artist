package fr.eseo.pdlo.projet.artiste.modele.formes;

import java.text.DecimalFormat;
import java.util.Locale;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.Remplissable;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;

public class Ellipse extends Forme implements Remplissable{
	private Remplissage remplissage;

	public Ellipse(Coordonnees position, double largeur, double hauteur) {
		super(position, largeur, hauteur);
		setRemplissage(Remplissage.AUCUNE);
	}
	
	public Ellipse(){
		this(new Coordonnees(), Forme.LARGEUR_PAR_DEFAUT, Forme.HAUTEUR_PAR_DEFAUT);
	} 
	
	public Ellipse(Coordonnees position) {
		this(position, Forme.LARGEUR_PAR_DEFAUT, Forme.HAUTEUR_PAR_DEFAUT);
	}
	
	public Ellipse(double largeur, double hauteur) {
		this(new Coordonnees(), largeur, hauteur);
	}
	
	@Override
	public Remplissage getRemplissage() {
		return this.remplissage;
	}
	
	@Override
	public void setLargeur(double largeur) {
		this.largeur = largeur;
		if(largeur<0) {
			throw new IllegalArgumentException("La largeur doit être positive!");
		}
	}
	
	@Override
	public void setHauteur(double hauteur) {
		this.hauteur = hauteur;
		if(hauteur<0) {
			throw new IllegalArgumentException("La hauteur doit être positive!");
		}
	}
	
	@Override
	public void setRemplissage(Remplissage remplissage) {
		this.remplissage = remplissage;
	}
	
	@Override
	public double aire() {
		return Math.PI * (1/4.0) * getLargeur() * getHauteur();
	}
	
	@Override
	public double perimetre() {
		double grand = Math.max(getLargeur()/2, getHauteur()/2);
		double petit = Math.min(getLargeur()/2, getHauteur()/2);
		
		double h = Math.pow((petit - grand) / (petit + grand),2);
		return Math.PI * (petit + grand) * (1 + ((3 * h) / (10 + Math.sqrt(4 - (3 * h)))));
	}
	
	@Override
	public boolean contient(Coordonnees coordonnee) {
		Coordonnees centre = new Coordonnees(getPosition().getAbscisse() + getLargeur()/2,
				getPosition().getOrdonnee() + getHauteur()/2);
		
		double grand = Math.max(getLargeur()/2, getHauteur()/2);
		double petit = Math.min(getLargeur()/2, getHauteur()/2);
		
		double c = Math.sqrt(Math.pow(grand, 2) - Math.pow(petit, 2));
		Coordonnees f1 = new Coordonnees(centre.getAbscisse() + c,centre.getOrdonnee());
		Coordonnees f2 = new Coordonnees(centre.getAbscisse() - c,centre.getOrdonnee());
		
		double distanceCVersf1 = Math.abs(coordonnee.distanceVers(f1));
		double distanceCversf2 = Math.abs(coordonnee.distanceVers(f2));
		
		return distanceCVersf1 + distanceCversf2 <= 2 * grand;
	}
	
	@Override
	public String toString() {
		DecimalFormat format = new DecimalFormat("0.0#");
	    Locale locale = Locale.getDefault();
	    
		double grand = Math.max(getLargeur()/2, getHauteur()/2);
		double petit = Math.min(getLargeur()/2, getHauteur()/2);
		
		String couleur = " couleur = R" + getCouleur().getRed() + ",G" + getCouleur().getGreen() + ",B" + getCouleur().getBlue();
		if(locale.getLanguage().equals("fr")) {
			couleur = " couleur = R" + getCouleur().getRed() + ",V" + getCouleur().getGreen() + ",B" + getCouleur().getBlue();
		}
		return "[Ellipse " + getRemplissage().getMode() +"] : pos " 
		+ getPosition().toString() + " petit rayon " + format.format(petit) + " grand rayon " + format.format(grand)
		+ " périmètre : " + format.format(perimetre()) + " aire : " + format.format(aire()) + couleur;
	}
}