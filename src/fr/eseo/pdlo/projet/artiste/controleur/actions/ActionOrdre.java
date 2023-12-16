package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

@SuppressWarnings("serial")
public class ActionOrdre extends AbstractAction{
	public static final String NOM_ACTION_AVANT = "Avant";
	public static final String NOM_ACTION_ARRIERE = "Arrière";
	public static final String NOM_ACTION_PREMIERPLAN = "Avant-plan";
	public static final String NOM_ACTION_ARRIEREPLAN = "Arrière-plan";
	
	private String nom;
	private PanneauDessin panneauDessin;
	
	public ActionOrdre(PanneauDessin panneauDessin, String nom) {
		super(nom);
		this.panneauDessin = panneauDessin;
		this.nom = nom;
	}

	public void actionPerformed(ActionEvent event) {
		if(this.panneauDessin.getSelected() != null 
				&& this.panneauDessin.getVueFormes().size() > 0) {
			int i = this.panneauDessin.getVueFormes().indexOf(
					this.panneauDessin.getSelected());
			
			switch(this.nom) {
			case NOM_ACTION_ARRIERE:
				this.panneauDessin.getVueFormes().add(i-1, 
						this.panneauDessin.getSelected());
				this.panneauDessin.getVueFormes().remove(i+1);
				break;
			case NOM_ACTION_AVANT:
				this.panneauDessin.getVueFormes().add(i+2, 
						this.panneauDessin.getSelected());
				this.panneauDessin.getVueFormes().remove(i);
				break;
			case NOM_ACTION_ARRIEREPLAN:
				this.panneauDessin.getVueFormes().add(0, 
						this.panneauDessin.getSelected());
				this.panneauDessin.getVueFormes().remove(i+1);
				break;
			case NOM_ACTION_PREMIERPLAN:
				this.panneauDessin.getVueFormes().add(
						this.panneauDessin.getVueFormes().size(), 
						this.panneauDessin.getSelected());
				break;
			default:
			}

			this.panneauDessin.repaint();
		}
	}
}