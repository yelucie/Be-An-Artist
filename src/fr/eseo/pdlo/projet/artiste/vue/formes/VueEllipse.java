package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Stroke;

import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.modele.formes.Ellipse;

public class VueEllipse extends VueForme{
	
	private Ellipse ellipse;

	public VueEllipse(Ellipse ellipse) {
		super(ellipse);
		this.ellipse = ellipse;
	}
	
	@Override
	public void affiche(Graphics2D g2d) {
		Color couleur = g2d.getColor();
		g2d.setColor(getForme().getCouleur());
		
		g2d.drawOval((int) getForme().getPosition().getAbscisse(),
				(int) getForme().getPosition().getOrdonnee(),
				(int) getForme().getLargeur(), (int) getForme().getHauteur());
		
		g2d.setPaint(null);
		
		boolean degrade = false;
		boolean contour = false;
		
		if(this.ellipse.getRemplissage() == Remplissage.DEGRADE) {
			degrade = true;
			Color startColor = ellipse.getCouleur();
			Color endColor = getForme().getCouleurP();
		    
			GradientPaint gradient = new GradientPaint(
					(int) ellipse.getCadreMinX(), 
					(int) ellipse.getCadreMinY(), 
					startColor, 
					(int) ellipse.getCadreMaxX(), 
					(int) ellipse.getCadreMaxY(),
					endColor);
			
			g2d.setPaint(gradient);
			this.ellipse.setRemplissage(Remplissage.UNIFORME);
		}
		
		if(this.ellipse.getRemplissage() == Remplissage.CONTOUR) {
			contour = true;
			Stroke ancien = g2d.getStroke();
			
		    final BasicStroke plain = new BasicStroke(
		    		10f,
		    		BasicStroke.CAP_BUTT,
		    		BasicStroke.JOIN_MITER);
		    
			g2d.setStroke(plain);
			g2d.drawOval((int) getForme().getPosition().getAbscisse(),
					(int) getForme().getPosition().getOrdonnee(),
					(int) getForme().getLargeur(), (int) getForme().getHauteur());
			
			g2d.setStroke(ancien);
			g2d.setColor(getForme().getCouleurP());
			this.ellipse.setRemplissage(Remplissage.UNIFORME);
		}
		
		if(this.ellipse.getRemplissage() == Remplissage.UNIFORME) {
			g2d.fillOval((int) getForme().getPosition().getAbscisse(),
				(int) getForme().getPosition().getOrdonnee(),
				(int) getForme().getLargeur(), (int) getForme().getHauteur());
		}
		
		g2d.setColor(couleur);
		
		if(degrade) {
			this.ellipse.setRemplissage(Remplissage.DEGRADE);
		}
		
		if(contour) {
			this.ellipse.setRemplissage(Remplissage.CONTOUR);
		}
	}
}