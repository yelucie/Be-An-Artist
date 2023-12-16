package fr.eseo.pdlo.projet.artiste.controleur.outils;

import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionSelectionner;
import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;

public class OutilSelectionner extends Outil{
	
	private VueForme formeSelectionnee;
	
	@Override
	public void mouseClicked(MouseEvent event) {
		for(int i=0 ; i < this.getPanneauDessin().getVueFormes().size(); i++) {
			VueForme vueForme = this.getPanneauDessin().getVueFormes().get(i);
			if(vueForme.getForme().contient(new Coordonnees(event.getX(), event.getY()))) {
				this.formeSelectionnee = vueForme;
				this.getPanneauDessin().setSelected(formeSelectionnee);
			}
		}
		
		if(this.formeSelectionnee != null) {
			this.getPanneauDessin().repaint();
			JOptionPane.showMessageDialog(this.getPanneauDessin(), this.formeSelectionnee.getForme().toString(), 
					ActionSelectionner.NOM_ACTION, JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	@Override
	public void mouseDragged(MouseEvent event) {
		setFin(new Coordonnees(event.getX(), event.getY()));
		if(this.getPanneauDessin().getSelected() != null
				&& this.getPanneauDessin().getSelected().getForme().contient(getDebut())) {
			double deltaX = getFin().getAbscisse() - getDebut().getAbscisse();
			double deltaY = getFin().getOrdonnee() - getDebut().getOrdonnee();
			
			this.formeSelectionnee.getForme().deplacerDe(deltaX, deltaY);
			setDebut(getFin());
			this.getPanneauDessin().repaint();
		}
		
		
	}
	
}