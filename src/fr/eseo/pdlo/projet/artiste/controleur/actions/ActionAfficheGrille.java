package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JCheckBox;

import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

@SuppressWarnings("serial")
public class ActionAfficheGrille extends AbstractAction{
	public static final String NOM_ACTION = "Grille";
	
	private PanneauDessin panneauDessin;
	
	public ActionAfficheGrille(PanneauDessin panneauDessin) {
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin;
	}
	
	public void actionPerformed(ActionEvent event) {
		JCheckBox grille = (JCheckBox) event.getSource();
		this.panneauDessin.setGrille(grille.isSelected());
		this.panneauDessin.repaint();
	}
}