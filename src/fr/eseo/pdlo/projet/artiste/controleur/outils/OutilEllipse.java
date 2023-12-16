package fr.eseo.pdlo.projet.artiste.controleur.outils;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Ellipse;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueEllipse;

public class OutilEllipse extends OutilForme{
	
	protected VueForme creerVueForme() {
		Ellipse ellipse = new Ellipse(getDebut());
		
		ellipse.setLargeur(Math.abs(getFin().getAbscisse() - getDebut().getAbscisse()));
		ellipse.setHauteur(Math.abs(getFin().getOrdonnee() - getDebut().getOrdonnee()));
		
		if(getDebut().getAbscisse() > getFin().getAbscisse()) {
			ellipse.setLargeur(Math.abs(getDebut().getAbscisse() - getFin().getAbscisse()));
			ellipse.setHauteur(Math.abs(getDebut().getOrdonnee() - getFin().getOrdonnee()));
			ellipse.setPosition(new Coordonnees(getFin().getAbscisse(), getFin().getOrdonnee() - ellipse.getHauteur()));
			if(getDebut().getOrdonnee() > getFin().getOrdonnee()) ellipse.setPosition(getFin());
		}
		
		else if(getDebut().getAbscisse() < getFin().getAbscisse() && getDebut().getOrdonnee() > getFin().getOrdonnee()) {
			ellipse.setLargeur(Math.abs(getDebut().getAbscisse() - getFin().getAbscisse()));
			ellipse.setHauteur(Math.abs(getDebut().getOrdonnee() - getFin().getOrdonnee()));
			ellipse.setPosition(new Coordonnees(getFin().getAbscisse() - ellipse.getLargeur(), getFin().getOrdonnee()));
		}
		
		ellipse.setCouleur(this.getPanneauDessin().getCouleurCourante());
		ellipse.setCouleurP(this.getPanneauDessin().getCouleurPCourante());
		ellipse.setRemplissage(this.getPanneauDessin().getModeRemplissageCourant());
		return new VueEllipse(ellipse);
	}
}