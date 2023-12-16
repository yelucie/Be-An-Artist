package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JColorChooser;

import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

@SuppressWarnings("serial")
public class ActionChoisirCouleurP extends AbstractAction {
	public static final String NOM_ACTION = "Couleur +";
	
	private PanneauDessin panneauDessin;
	
	public ActionChoisirCouleurP(PanneauDessin panneauDessin) {
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin;
	}
	
	public void actionPerformed(ActionEvent event) {
		Color couleur = JColorChooser.showDialog(this.panneauDessin, 
				NOM_ACTION, this.panneauDessin.getCouleurCourante());
		
		if(couleur != null) {
			this.panneauDessin.setCouleurPCourante(couleur);
		}
	}
}

