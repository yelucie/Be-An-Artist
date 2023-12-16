package fr.eseo.pdlo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Cercle;
import fr.eseo.pdlo.projet.artiste.modele.formes.Forme;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueCercle;

public class OutilCercle extends OutilForme{
	
	protected VueForme creerVueForme() {
		Cercle cercle = new Cercle();
	
		double abs = Math.abs(getFin().getAbscisse() - getDebut().getAbscisse());
		double ord = Math.abs(getFin().getOrdonnee() - getDebut().getOrdonnee());
		double max = Math.max(abs, ord);
		cercle.setLargeur(max);
		
		if(getDebut().getAbscisse() > getFin().getAbscisse()) {
			cercle.setPosition(new Coordonnees(getDebut().getAbscisse() - max, getDebut().getOrdonnee()));
			if(getDebut().getOrdonnee() > getFin().getOrdonnee()) 
				cercle.setPosition(new Coordonnees(getDebut().getAbscisse() - max, getDebut().getOrdonnee() - max));
		}
		else {
			cercle.setPosition(getDebut());
			if(getDebut().getOrdonnee() > getFin().getOrdonnee()) 
				cercle.setPosition(new Coordonnees(getDebut().getAbscisse(), getDebut().getOrdonnee() - max));
		}
		
		cercle.setCouleur(this.getPanneauDessin().getCouleurCourante());
		cercle.setCouleurP(this.getPanneauDessin().getCouleurPCourante());
		cercle.setRemplissage(this.getPanneauDessin().getModeRemplissageCourant());
		return new VueCercle(cercle);
	}
	
	public void mouseClicked(MouseEvent event) {
		setFin(new Coordonnees(event.getX() + Forme.LARGEUR_PAR_DEFAUT,
				event.getY() + Forme.HAUTEUR_PAR_DEFAUT));
		if(event.getClickCount() == 1) {
			getPanneauDessin().ajouterVueForme(new VueCercle(new Cercle(new Coordonnees(event.getX(), event.getY()))));
			getPanneauDessin().repaint();
		}
	}
}