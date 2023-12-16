package fr.eseo.pdlo.projet.artiste.vue.formes;

import java.awt.Color;
import java.awt.Graphics2D;
import fr.eseo.pdlo.projet.artiste.modele.formes.Ligne;

public class VueLigne extends VueForme{
	
	private Ligne ligne;
	
	public VueLigne(Ligne ligne) {
		super(ligne);
		this.ligne = ligne;
	}
	
	@Override
	public void affiche(Graphics2D g2d) {
		Color couleur = g2d.getColor();
		g2d.setColor(ligne.getCouleur());

		g2d.drawLine((int) ligne.getC1().getAbscisse(), (int) ligne.getC1().getOrdonnee(),
				(int) ligne.getC2().getAbscisse(), (int) ligne.getC2().getOrdonnee());

		
		g2d.setColor(couleur);
	}
}