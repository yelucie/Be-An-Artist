package fr.eseo.pdlo.projet.artiste.vue.ihm;

import java.awt.FlowLayout;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import fr.eseo.pdlo.projet.artiste.modele.Coordonnees;

@SuppressWarnings("serial")
public class PanneauBarreEtat extends JPanel implements MouseMotionListener{
	private JLabel valeurX;
	private JLabel valeurY;
	
	private final PanneauDessin panneauDessin;
	
	public PanneauBarreEtat(PanneauDessin panneauDessin) {
		this.panneauDessin = panneauDessin;
		
		setLayout(new FlowLayout());
		this.valeurX = new JLabel("x: 0");
		this.valeurY = new JLabel("y: 0");
		
		this.add(this.valeurX);
		this.add(this.valeurY);
		
		this.panneauDessin.addMouseMotionListener(this);
	}
	
	@Override
	public void mouseDragged(MouseEvent event) {
		Coordonnees c = new Coordonnees(event.getX(), event.getY());
		mettreAJourAffichage(c);
	}
	
	@Override
	public void mouseMoved(MouseEvent event) {
		Coordonnees c = new Coordonnees(event.getX(), event.getY());
		mettreAJourAffichage(c);
	}
	
	private void mettreAJourAffichage(Coordonnees coords) {
		if (this.valeurX != null || this.valeurY != null) {
			this.valeurX.setText("");
			this.valeurY.setText("");
		}
		
		this.valeurX.setText("x: " + coords.getAbscisse());
		this.valeurY.setText("y: " + coords.getOrdonnee());
	}
}