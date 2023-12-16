package fr.eseo.pdlo.projet.artiste.modele.formes;

import java.text.DecimalFormat;
import java.util.Locale;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public class Cercle extends Ellipse{
	
	public Cercle(Coordonnees position, double taille) {
		super(position, taille, taille);
	}
	
	public Cercle(){
		this(new Coordonnees(), Forme.LARGEUR_PAR_DEFAUT);
	} 
	
	public Cercle(Coordonnees position) {
		this(position, Forme.LARGEUR_PAR_DEFAUT);
	}
	
	public Cercle(double taille) {
		this(new Coordonnees(), taille);
	}
	
	@Override
	public void setLargeur(double largeur){
		if(largeur<0) {
			throw new IllegalArgumentException("La taille doit être positive!");
		}
		this.largeur = largeur;
		this.hauteur = largeur;
	} 
	
	@Override
	public void setHauteur(double hauteur){
		if(hauteur<0) {
			throw new IllegalArgumentException("La taille doit être positive!");
		}
		this.largeur = hauteur;
		this.hauteur = hauteur;
	}
	
	@Override
	public double aire() {
		return Math.PI * Math.pow(getLargeur()/2.0,2);
	}
	
	@Override
	public double perimetre() {
		return 2 * Math.PI * (getLargeur()/2.0);
	}
	
	@Override
	public String toString() {
		DecimalFormat format = new DecimalFormat("0.0#");
		Locale locale = Locale.getDefault();
		
		String texte = "[Cercle " + getRemplissage().getMode() + "] : pos "+ getPosition().toString() 
				+ " rayon " + format.format((getLargeur()/2.0)) + " périmètre : " + format.format(perimetre()) 
				+ " aire : " + format.format(aire());
		
		String couleur = " couleur = R" + getCouleur().getRed() + ",G" + getCouleur().getGreen() + ",B" + getCouleur().getBlue();
		if(locale.getLanguage().equals("fr")) {
			couleur = " couleur = R" + getCouleur().getRed() + ",V" + getCouleur().getGreen() + ",B" + getCouleur().getBlue();
		}
		return texte + couleur;
	}
}