package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

@SuppressWarnings("serial")
public class ActionChoisirModeRemplissage extends AbstractAction{
	private Remplissage remplissage;
	private PanneauDessin panneauDessin;
	
	public ActionChoisirModeRemplissage(PanneauDessin panneau, 
			Remplissage remplissage) {
		super(remplissage.getMode());
		this.panneauDessin = panneau;
		this.remplissage = remplissage;
	}
	
	public void actionPerformed(ActionEvent event) {
		if(this.remplissage.getMode() == event.getActionCommand()) {
			this.panneauDessin.setModeRemplissageCourant(this.remplissage);
		}
	}
}