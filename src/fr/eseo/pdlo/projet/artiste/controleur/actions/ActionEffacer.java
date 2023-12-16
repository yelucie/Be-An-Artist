package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

@SuppressWarnings("serial")
public class ActionEffacer extends AbstractAction{
	public static final String NOM_ACTION = "Effacer tout";
	
	private PanneauDessin panneauDessin;
	
	public ActionEffacer(PanneauDessin panneauDessin) {
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin;
	}
	
	public void actionPerformed(ActionEvent event) {
		int action = JOptionPane.showConfirmDialog(this.panneauDessin,
				"Effacer tout?", NOM_ACTION, JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
		if(action == 0) {
			this.panneauDessin.getVueFormes().clear();
			this.panneauDessin.setSelected(null);
			this.panneauDessin.repaint();
		}
	}
}