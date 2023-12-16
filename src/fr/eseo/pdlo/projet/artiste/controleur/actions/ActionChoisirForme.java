package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilCarre;
import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilCercle;
import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilEllipse;
import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilLigne;
import fr.eseo.pdlo.projet.artiste.controleur.outils.OutilRectangle;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauBarreOutils;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

@SuppressWarnings("serial")
public class ActionChoisirForme extends AbstractAction{
	public static final String NOM_ACTION_LIGNE = "Ligne";
	public static final String NOM_ACTION_ELLIPSE = "Ellipse";
	public static final String NOM_ACTION_CERCLE = "Cercle";
	public static final String NOM_ACTION_RECTANGLE = "Rectangle";
	public static final String NOM_ACTION_CARRE = "Carré";
	
	private PanneauDessin panneauDessin;
	
	public ActionChoisirForme(PanneauDessin panneauDessin, 
			PanneauBarreOutils barreOutils, String nom) {
		super(nom);
		this.panneauDessin = panneauDessin;
	}
	
	public void actionPerformed(ActionEvent event) {
		switch(event.getActionCommand()) {
		case NOM_ACTION_LIGNE:
			this.panneauDessin.associerOutil(new OutilLigne());
			break;
		case NOM_ACTION_ELLIPSE:
			this.panneauDessin.associerOutil(new OutilEllipse());
			break;
		case NOM_ACTION_CERCLE:
			this.panneauDessin.associerOutil(new OutilCercle());
			break;
		case NOM_ACTION_RECTANGLE:
			this.panneauDessin.associerOutil(new OutilRectangle());
			break;
		case NOM_ACTION_CARRE:
			this.panneauDessin.associerOutil(new OutilCarre());
			break;
		default:
		}
	}
}