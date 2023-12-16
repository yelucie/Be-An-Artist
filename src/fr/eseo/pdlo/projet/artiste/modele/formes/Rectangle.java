package fr.eseo.pdlo.projet.artiste.modele.formes;

import java.text.DecimalFormat;
import java.util.Locale;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.Remplissable;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;

public class Rectangle extends Forme implements Remplissable{
	
	private Remplissage remplissage;
	public static final double EPSILON = 0.1 ;
	
	public Rectangle(Coordonnees position, double largeur, double hauteur) {
		super(position, largeur, hauteur);
		setRemplissage(Remplissage.AUCUNE);
	}
	
	public Rectangle(){
		this(new Coordonnees(), Forme.LARGEUR_PAR_DEFAUT, Forme.HAUTEUR_PAR_DEFAUT);
	}
	
	public Rectangle(Coordonnees position) {
		this(position, Forme.LARGEUR_PAR_DEFAUT, Forme.HAUTEUR_PAR_DEFAUT);
	}
	
	public Rectangle(double largeur, double hauteur) {
		this(new Coordonnees(), largeur, hauteur);
	}
	
	@Override
	public Remplissage getRemplissage() {
		return this.remplissage;
	}
	
	@Override
	public void setRemplissage(Remplissage remplissage) {
		this.remplissage = remplissage;
	}
	
	@Override
	public double aire() {
		return this.largeur * this.hauteur;
	};
	
	@Override
	public double perimetre() {
		return 2 * (this.largeur + this.hauteur);
	};
	
	@Override
	public boolean contient(Coordonnees coordonnee) {
		double x = coordonnee.getAbscisse();
		double y = coordonnee.getOrdonnee();
		boolean absOK = false;
		boolean ordOK = false;
		
		if(x >= this.getCadreMinX() - EPSILON && x <= this.getCadreMaxX() + EPSILON) {
			absOK = true;
		}
		if(y >= this.getCadreMinY() && y <= this.getCadreMaxY()) {
			ordOK = true;
		}
		return absOK && ordOK;
	}
	
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
		
		return "[Rectangle " + getRemplissage().getMode() + "]"
				+ " c1 : "+ (new Coordonnees (this.getCadreMinX(), this.getCadreMinY())).toString() 
				+ " c2 : " + (new Coordonnees (this.getCadreMaxX(), this.getCadreMinY())).toString()
				+ " c3 : " + (new Coordonnees (this.getCadreMinX(), this.getCadreMaxY())).toString()
				+ " c4 : " + (new Coordonnees (this.getCadreMaxX(), this.getCadreMaxY())).toString()
				+ " périmètre : " + perimetre
				+ " aire : " + aire + couleur;
	}
}