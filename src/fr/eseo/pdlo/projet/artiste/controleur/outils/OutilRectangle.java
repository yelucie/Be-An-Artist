package fr.eseo.pdlo.projet.artiste.controleur.outils;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

import fr.eseo.pdlo.projet.artiste.modele.formes.Rectangle;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueRectangle;

public class OutilRectangle extends OutilForme{
	
	protected VueForme creerVueForme() {
		Rectangle rectangle = new Rectangle(getDebut());
		
		rectangle.setLargeur(Math.abs(getFin().getAbscisse() - getDebut().getAbscisse()));
		rectangle.setHauteur(Math.abs(getFin().getOrdonnee() - getDebut().getOrdonnee()));
		
		if(getDebut().getAbscisse() > getFin().getAbscisse()) {
			rectangle.setLargeur(Math.abs(getDebut().getAbscisse() - getFin().getAbscisse()));
			rectangle.setHauteur(Math.abs(getDebut().getOrdonnee() - getFin().getOrdonnee()));
			rectangle.setPosition(new Coordonnees(getFin().getAbscisse(), getFin().getOrdonnee() - rectangle.getHauteur()));
			if(getDebut().getOrdonnee() > getFin().getOrdonnee()) rectangle.setPosition(getFin());
		}
		
		else if(getDebut().getAbscisse() < getFin().getAbscisse() && getDebut().getOrdonnee() > getFin().getOrdonnee()) {
			rectangle.setLargeur(Math.abs(getDebut().getAbscisse() - getFin().getAbscisse()));
			rectangle.setHauteur(Math.abs(getDebut().getOrdonnee() - getFin().getOrdonnee()));
			rectangle.setPosition(new Coordonnees(getFin().getAbscisse() - rectangle.getLargeur(), getFin().getOrdonnee()));
		}
		
		rectangle.setCouleur(this.getPanneauDessin().getCouleurCourante());
		rectangle.setCouleurP(this.getPanneauDessin().getCouleurPCourante());
		rectangle.setRemplissage(this.getPanneauDessin().getModeRemplissageCourant());
		return new VueRectangle(rectangle);
	}
}