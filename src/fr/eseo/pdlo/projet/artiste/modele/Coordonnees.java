package fr.eseo.pdlo.projet.artiste.modele;

import java.text.DecimalFormat;

public class Coordonnees{
	
	public static final double ABSCISSE_PAR_DEFAUT = 0.0;
	public static final double ORDONNEE_PAR_DEFAUT = 0.0;
	private double x;
	private double y;
	
	public Coordonnees(double x, double y){
		setAbscisse(x);
		setOrdonnee(y);
	}
	
	public Coordonnees(){
		this(ABSCISSE_PAR_DEFAUT,ORDONNEE_PAR_DEFAUT);
	}
	
	public double getAbscisse(){
		return this.x;
	}
	
	public double getOrdonnee(){
		return this.y;
	}
	
	public void setAbscisse(double abs){
		this.x = abs;
	}
	
	public void setOrdonnee(double ord){
		this.y = ord;
	}
	
	public void deplacerDe(double deltaX, double deltaY) {
		setAbscisse(getAbscisse() + deltaX);
		setOrdonnee(getOrdonnee() + deltaY);
	}
	
	public void deplacerVers(double nouvX, double nouvY) {
		setAbscisse(nouvX);
		setOrdonnee(nouvY);
	}
	
	public double angleVers(Coordonnees autre){
		double abs = autre.getAbscisse() - getAbscisse();
		double ord = autre.getOrdonnee() - getOrdonnee();
		return Math.atan2(ord,abs);
		
	}
	
	public double distanceVers(Coordonnees autre){
		double x2 = Math.pow(autre.getAbscisse() - getAbscisse(),2);
		double y2 = Math.pow(autre.getOrdonnee() - getOrdonnee(),2);
		return Math.sqrt(x2+y2);
	}
	
	public String toString() {
		DecimalFormat format = new DecimalFormat();
	    format.setMaximumFractionDigits(2);
	    format.setMinimumFractionDigits(1);
	    
		return "(" + format.format(this.getAbscisse()) 
		+ " , " + format.format(this.getOrdonnee()) + ")";
	}
}