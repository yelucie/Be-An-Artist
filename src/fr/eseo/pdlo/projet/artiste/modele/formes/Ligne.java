package fr.eseo.pdlo.projet.artiste.modele.formes;

import java.text.DecimalFormat;

import java.util.Locale;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public class Ligne extends Forme{
	
	public static final double EPSILON = 0.1 ;
	
	public Ligne(Coordonnees position, double largeur, double hauteur) {
		super(position, largeur, hauteur);
	}
	
	public Ligne(){
		this(new Coordonnees(), Forme.LARGEUR_PAR_DEFAUT, Forme.HAUTEUR_PAR_DEFAUT);
	}
	
	public Ligne(Coordonnees position) {
		this(position, Forme.LARGEUR_PAR_DEFAUT, Forme.HAUTEUR_PAR_DEFAUT);
	}
	
	public Ligne(double largeur, double hauteur) {
		this(new Coordonnees(), largeur, hauteur);
	}
	
	public void setC1(Coordonnees coordonnee) {
		super.setLargeur(getC2().getAbscisse() - coordonnee.getAbscisse());
		super.setHauteur(getC2().getOrdonnee() - coordonnee.getOrdonnee());
		super.setPosition(coordonnee);
	}
	
	public void setC2(Coordonnees coordonnee) {
		super.setLargeur(coordonnee.getAbscisse() - getC1().getAbscisse());
		super.setHauteur(coordonnee.getOrdonnee() - getC1().getOrdonnee());
	}
	
	public Coordonnees getC1() {
		return getPosition();
	}
	
	public Coordonnees getC2() {
		return new Coordonnees(getC1().getAbscisse() + super.getLargeur(), getC1().getOrdonnee() + super.getHauteur());
	}
	
	@Override
	public double aire() {
		return 0;
	};
	
	@Override
	public double perimetre() {
		return getC1().distanceVers(getC2());
	};
	
	@Override
	public boolean contient(Coordonnees coordonnee) {
		double distanceC1VersC = Math.abs(getC1().distanceVers(coordonnee));
		double distanceCVersC2 = Math.abs(coordonnee.distanceVers(getC2()));
		double distanceC1VersC2 = Math.abs(getC1().distanceVers(getC2()));
		return (distanceC1VersC + distanceCVersC2 - distanceC1VersC2) <= EPSILON;
	}
	
	public String toString() {
		DecimalFormat format = new DecimalFormat();
	    format.setMaximumFractionDigits(2);
	    format.setMinimumFractionDigits(1);
	    
	    Locale locale = Locale.getDefault();
	    
		String longueur = format.format(this.perimetre());
		double angle = this.getC1().angleVers(this.getC2());
		String angleFormate = format.format((angle * 180) / Math.PI);
		
		if(angle < 0) {
			angleFormate = format.format(((angle * 180) / Math.PI) + 360);
		}
		
		String couleur = " couleur = R" + getCouleur().getRed() + ",G" + getCouleur().getGreen() + ",B" + getCouleur().getBlue();
		if(locale.getLanguage().equals("fr")){
			couleur = " couleur = R" + getCouleur().getRed() + ",V" + getCouleur().getGreen() + ",B" + getCouleur().getBlue();
		}
		
		return "[Ligne] c1 : "+ this.getC1().toString() + " c2 : " + this.getC2().toString()
				+ " longueur : " + longueur + " angle : " + angleFormate + "°" + couleur;
	}
}