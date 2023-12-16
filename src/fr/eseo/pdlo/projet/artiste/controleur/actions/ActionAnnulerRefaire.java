package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;
import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

@SuppressWarnings("serial")
public class ActionAnnulerRefaire extends AbstractAction{
	public static final String NOM_ACTION_ANNULER = "Annuler";
	public static final String NOM_ACTION_REFAIRE = "Refaire";
	
	private PanneauDessin panneauDessin;
	
	public ActionAnnulerRefaire(PanneauDessin panneauDessin, String nom) {
		super(nom);
		this.panneauDessin = panneauDessin;
	}
	
	public void actionPerformed(ActionEvent event) {
		if(event.getActionCommand().equals(NOM_ACTION_ANNULER)) {
			if(this.panneauDessin.getVueFormes().size() > 0) {
				VueForme aAnnuler = this.panneauDessin.getVueFormes().get(
						this.panneauDessin.getVueFormes().size() - 1);
				if(this.panneauDessin.getSelected() != null) {
					aAnnuler = this.panneauDessin.getSelected();
				}
				this.panneauDessin.getAnnulerRefaire().add(aAnnuler);
				this.panneauDessin.getVueFormes().remove(aAnnuler);
				this.panneauDessin.setSelected(null);
			}
		}
		else if(event.getActionCommand().equals(NOM_ACTION_REFAIRE)) {
			if(this.panneauDessin.getAnnulerRefaire().size() > 0) {
				VueForme aRefaire = this.panneauDessin.getAnnulerRefaire().get(
						this.panneauDessin.getAnnulerRefaire().size() - 1);
				this.panneauDessin.getVueFormes().add(aRefaire);
				this.panneauDessin.getAnnulerRefaire().remove(aRefaire);
			}
		}
		this.panneauDessin.repaint();
	}
}