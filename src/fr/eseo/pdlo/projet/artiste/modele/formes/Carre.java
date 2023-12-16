package fr.eseo.pdlo.projet.artiste.modele.formes;

import java.text.DecimalFormat;

import java.util.Locale;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public class Carre extends Rectangle{
	
	public Carre(Coordonnees position, double cote) {
		super(position, cote, cote);
	}
	
	public Carre(){
		this(new Coordonnees(), Forme.LARGEUR_PAR_DEFAUT);
	}
	
	public Carre(Coordonnees position) {
		this(position, Forme.LARGEUR_PAR_DEFAUT);
	}
	
	public Carre(double cote) {
		this(new Coordonnees(), cote);
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
		return Math.pow(getLargeur(), 2);
	};
	
	@Override
	public double perimetre() {
		return 4 * getLargeur();
	};
	
	public String toString() {
		DecimalFormat format = new DecimalFormat("0.0#");
	    format.setMaximumFractionDigits(2);
	    format.setMinimumFractionDigits(1);
	    
	    Locale locale = Locale.getDefault();
	    
		String perimetre = format.format(this.perimetre());
		String aire = format.format(this.aire());

		String couleur = " couleur = R" + getCouleur().getRed()
				+ ",G" + getCouleur().getGreen() + ",B" + getCouleur().getBlue();
		if(locale.getLanguage().equals("fr")){
			couleur = " couleur = R" + getCouleur().getRed() 
					+ ",V" + getCouleur().getGreen() + ",B" + getCouleur().getBlue();
		}
		
		return "[Carré " + getRemplissage().getMode() + "]"
				+ " c1 : "+ (new Coordonnees (this.getCadreMinX(), this.getCadreMinY())).toString() 
				+ " c2 : " + (new Coordonnees (this.getCadreMaxX(), this.getCadreMinY())).toString()
				+ " c3 : " + (new Coordonnees (this.getCadreMinX(), this.getCadreMaxY())).toString()
				+ " c4 : " + (new Coordonnees (this.getCadreMaxX(), this.getCadreMaxY())).toString()
				+ " périmètre : " + perimetre
				+ " aire : " + aire + couleur;
	}
}