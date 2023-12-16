package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Stroke;

import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.modele.formes.Rectangle;

public class VueRectangle extends VueForme{
	
	private Rectangle rectangle;
	
	public VueRectangle(Rectangle rectangle) {
		super(rectangle);
		this.rectangle = rectangle;
	}
	
	@Override
	public void affiche(Graphics2D g2d) {
		Color couleur = g2d.getColor();
		g2d.setColor(getForme().getCouleur());
		
		g2d.drawRect((int) getForme().getPosition().getAbscisse(), (int) getForme().getPosition().getOrdonnee(),
				(int) getForme().getLargeur(), (int) getForme().getHauteur());
		
		g2d.setPaint(null);
		
		boolean degrade = false;
		boolean contour = false;
		
		if(this.rectangle.getRemplissage() == Remplissage.DEGRADE) {
			degrade = true;
			Color startColor = rectangle.getCouleur();
			Color endColor = getForme().getCouleurP();
		    
			GradientPaint gradient = new GradientPaint(
					(int) rectangle.getCadreMinX(), 
					(int) rectangle.getCadreMinY(), 
					startColor, 
					(int) rectangle.getCadreMaxX(), 
					(int) rectangle.getCadreMaxY(),
					endColor);
			
			g2d.setPaint(gradient);
			this.rectangle.setRemplissage(Remplissage.UNIFORME);
		}
		
		if(this.rectangle.getRemplissage() == Remplissage.CONTOUR) {
			contour = true;
			Stroke ancien = g2d.getStroke();
			
		    final BasicStroke plain = new BasicStroke(
		    		10f,
		    		BasicStroke.CAP_BUTT,
		    		BasicStroke.JOIN_MITER);
		    
			g2d.setStroke(plain);
			g2d.drawRect((int) getForme().getPosition().getAbscisse(), (int) getForme().getPosition().getOrdonnee(),
					(int) getForme().getLargeur(), (int) getForme().getHauteur());
			
			g2d.setStroke(ancien);
			g2d.setColor(getForme().getCouleurP());
			this.rectangle.setRemplissage(Remplissage.UNIFORME);
		}
		
		if(this.rectangle.getRemplissage() == Remplissage.UNIFORME) {
			g2d.fillRect((int) getForme().getPosition().getAbscisse(), (int) getForme().getPosition().getOrdonnee(),
				(int) getForme().getLargeur(), (int) getForme().getHauteur());
		}

		g2d.setColor(couleur);
		
		if(degrade) {
			this.rectangle.setRemplissage(Remplissage.DEGRADE);
		}
		
		if(contour) {
			this.rectangle.setRemplissage(Remplissage.CONTOUR);
		}
	}
}
