package fr.eseo.pdlo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.formes.Carre;
import fr.eseo.pdlo.projet.artiste.modele.formes.Forme;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueCarre;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;

public class OutilCarre extends OutilForme{
	
	protected VueForme creerVueForme() {
		Carre carre = new Carre();
		
		double abs = Math.abs(getFin().getAbscisse() - getDebut().getAbscisse());
		double ord = Math.abs(getFin().getOrdonnee() - getDebut().getOrdonnee());
		double max = Math.max(abs, ord);
		carre.setLargeur(max);
		
		if(getDebut().getAbscisse() > getFin().getAbscisse()) {
			carre.setPosition(new Coordonnees(getDebut().getAbscisse() - max, getDebut().getOrdonnee()));
			if(getDebut().getOrdonnee() > getFin().getOrdonnee()) 
				carre.setPosition(new Coordonnees(getDebut().getAbscisse() - max, getDebut().getOrdonnee() - max));
		}
		else {
			carre.setPosition(getDebut());
			if(getDebut().getOrdonnee() > getFin().getOrdonnee()) 
				carre.setPosition(new Coordonnees(getDebut().getAbscisse(), getDebut().getOrdonnee() - max));
		}
		
		carre.setCouleur(this.getPanneauDessin().getCouleurCourante());
		carre.setCouleurP(this.getPanneauDessin().getCouleurPCourante());
		carre.setRemplissage(this.getPanneauDessin().getModeRemplissageCourant());
		return new VueCarre(carre);
	}
	
	@Override
	public void mouseClicked(MouseEvent event) {
		setFin(new Coordonnees(event.getX() + Forme.LARGEUR_PAR_DEFAUT,
				event.getY() + Forme.HAUTEUR_PAR_DEFAUT));
		if(event.getClickCount() == 1) {
			getPanneauDessin().ajouterVueForme(new VueCarre(new Carre(new Coordonnees(event.getX(), event.getY()))));
			getPanneauDessin().repaint();
		}
	}
}