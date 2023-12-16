package fr.eseo.pdlo.projet.artiste.controleur.outils;

import java.awt.Color;
import java.awt.event.MouseEvent;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.modele.formes.Forme;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;

public abstract class OutilForme extends Outil{
	
	@Override
	public void mousePressed(MouseEvent event) {
		getPanneauDessin().setSelected(null);
		getPanneauDessin().repaint();
		setDebut(new Coordonnees(event.getX(), event.getY()));
	}
	
	@Override
	public void mouseClicked(MouseEvent event) {
		setFin(new Coordonnees(event.getX() + Forme.LARGEUR_PAR_DEFAUT,
				event.getY() + Forme.HAUTEUR_PAR_DEFAUT));
		if(event.getClickCount() == 2) {
			getPanneauDessin().ajouterVueForme(creerVueForme());
			getPanneauDessin().repaint();
		}
	}
	
	@Override
	public void mouseReleased(MouseEvent event) {
		getPanneauDessin().getTracage().clear();
		setFin(new Coordonnees(event.getX(), event.getY()));
		if(getDebut().getAbscisse() != getFin().getAbscisse()
				|| getDebut().getOrdonnee() != getFin().getOrdonnee()) {			
			getPanneauDessin().ajouterVueForme(creerVueForme());
			getPanneauDessin().repaint();
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent event) {
		setFin(new Coordonnees(event.getX(), event.getY()));
		Color couleur = this.getPanneauDessin().getCouleurCourante();
		Remplissage mode = this.getPanneauDessin().getModeRemplissageCourant();
		
		getPanneauDessin().setModeRemplissageCourant(Remplissage.AUCUNE);
		getPanneauDessin().setCouleurCourante(new Color(190,190,190));
		getPanneauDessin().ajouterTracage(creerVueForme());
		getPanneauDessin().repaint();
		
		getPanneauDessin().setCouleurCourante(couleur);
		getPanneauDessin().setModeRemplissageCourant(mode);
	}
	
	protected abstract VueForme creerVueForme();
}