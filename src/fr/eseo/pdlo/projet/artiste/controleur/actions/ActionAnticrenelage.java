package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JCheckBox;

import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

@SuppressWarnings("serial")
public class ActionAnticrenelage extends AbstractAction{
	public static final String NOM_ACTION = "Anticrénelage";
	
	private PanneauDessin panneauDessin;
	
	public ActionAnticrenelage(PanneauDessin panneauDessin) {
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin;
	}
	
	public void actionPerformed(ActionEvent event) {
		JCheckBox anticrenelage = (JCheckBox) event.getSource();
		this.panneauDessin.setAnticrenelage(anticrenelage.isSelected());
		this.panneauDessin.repaint();
	}
}