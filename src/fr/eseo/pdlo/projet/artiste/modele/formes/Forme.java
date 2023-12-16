package fr.eseo.pdlo.projet.artiste.modele.formes;

import java.awt.Color;

import javax.swing.UIManager;

import fr.eseo.pdlo.projet.artiste.modele.Coloriable;
import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

public abstract class Forme implements Coloriable{
	
	public static final double LARGEUR_PAR_DEFAUT = 100;
	public static final double HAUTEUR_PAR_DEFAUT = 150;
	public static final Color COULEUR_PAR_DEFAUT = UIManager.getColor("Panel.foreground");
	
	protected double largeur;
	protected double hauteur;
	private Coordonnees position;
	private Color couleur;
	private Color couleurP;
	
	public Forme(Coordonnees position, double largeur, double hauteur) {
		this.setPosition(position);
		this.setLargeur(largeur);
		this.setHauteur(hauteur);
		this.setCouleur(COULEUR_PAR_DEFAUT);
		this.setCouleurP(null);
	}
	
	public Forme(){
		this(new Coordonnees(), LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
	} 
	
	public Forme(Coordonnees position) {
		this(position, LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT);
	}
	
	public Forme(double largeur, double hauteur) {
		this(new Coordonnees(), largeur, hauteur);
	}
	
	public Coordonnees getPosition(){
		return this.position;
	}
	
	public double getLargeur(){
		return this.largeur;
	}
	
	public double getHauteur(){
		return this.hauteur;
	}
	
	public Color getCouleur() {
		return this.couleur;
	}
	
	public Color getCouleurP() {
		return this.couleurP;
	}
	
	public void setPosition(Coordonnees position){
		this.position = position;
	}
	
	public void setLargeur(double largeur){
		this.largeur = largeur;
	}
	
	public void setHauteur(double hauteur){
		this.hauteur = hauteur;
	}
	
	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}
	
	public void setCouleurP(Color couleurP) {
		this.couleurP = couleurP;
	}
	
	public void deplacerVers(double nouvX, double nouvY) {
		this.position.deplacerVers(nouvX, nouvY);
	}
	
	public void deplacerDe(double deltaX, double deltaY) {
		this.position.deplacerDe(deltaX, deltaY);
	}

	public double getCadreMinX() {
		return Math.min(getPosition().getAbscisse() + getLargeur(), getPosition().getAbscisse());
	}
	
	public double getCadreMinY() {
		return Math.min(getPosition().getOrdonnee() + getHauteur(), getPosition().getOrdonnee());
	}
	
	public double getCadreMaxX() {
		return Math.max(getPosition().getAbscisse() + getLargeur(), getPosition().getAbscisse());
	}
	
	public double getCadreMaxY() {
		return Math.max(getPosition().getOrdonnee() + getHauteur(), getPosition().getOrdonnee());
	}
	
	public abstract double aire();
	
	public abstract double perimetre();
	
	public abstract boolean contient(Coordonnees coordonnee);
}