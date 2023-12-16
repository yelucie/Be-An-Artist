package fr.eseo.pdlo.projet.artiste.vue.ihm;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionAfficheGrille;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionAnnulerRefaire;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionAnticrenelage;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionChoisirCouleur;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionChoisirCouleurP;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionChoisirForme;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionChoisirModeRemplissage;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionEffacer;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionExporter;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionOrdre;
import fr.eseo.pdlo.projet.artiste.controleur.actions.ActionSelectionner;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;

@SuppressWarnings("serial")
public class PanneauBarreOutils extends JPanel{
	
	private PanneauDessin panneauDessin;
	
	public PanneauBarreOutils(PanneauDessin panneauDessin) {
		this.panneauDessin = panneauDessin;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setPreferredSize(new Dimension(110, 25));
		
		initComponents();
	}
	
	private void optionsDessin() {
		JLabel dessin = new JLabel("           DESSIN");
		
		ButtonGroup optionDessin = new ButtonGroup();
		JToggleButton ligne = new JToggleButton(
				new ActionChoisirForme(panneauDessin, 
				this, ActionChoisirForme.NOM_ACTION_LIGNE));
		JToggleButton ellipse = new JToggleButton(
				new ActionChoisirForme(panneauDessin, 
				this, ActionChoisirForme.NOM_ACTION_ELLIPSE));
		JToggleButton cercle = new JToggleButton(
				new ActionChoisirForme(panneauDessin, 
				this, ActionChoisirForme.NOM_ACTION_CERCLE));
		JToggleButton rectangle = new JToggleButton(
				new ActionChoisirForme(panneauDessin, 
				this, ActionChoisirForme.NOM_ACTION_RECTANGLE));
		JToggleButton carre =new JToggleButton(
				new ActionChoisirForme(panneauDessin,
				this, ActionChoisirForme.NOM_ACTION_CARRE));
		JToggleButton selectionner = new JToggleButton(
				new ActionSelectionner(panneauDessin));
		
		ligne.setMaximumSize(this.getPreferredSize());
		ellipse.setMaximumSize(this.getPreferredSize());
		cercle.setMaximumSize(this.getPreferredSize());
		rectangle.setMaximumSize(this.getPreferredSize());
		carre.setMaximumSize(this.getPreferredSize());
		selectionner.setMaximumSize(this.getPreferredSize());
		
		ligne.setName(ActionChoisirForme.NOM_ACTION_LIGNE);
		ellipse.setName(ActionChoisirForme.NOM_ACTION_ELLIPSE);
		cercle.setName(ActionChoisirForme.NOM_ACTION_CERCLE);
		rectangle.setName(ActionChoisirForme.NOM_ACTION_RECTANGLE);
		carre.setName(ActionChoisirForme.NOM_ACTION_CARRE);
		selectionner.setName(ActionSelectionner.NOM_ACTION);
		
		optionDessin.add(ligne);
		optionDessin.add(ellipse);
		optionDessin.add(cercle);
		optionDessin.add(rectangle);
		optionDessin.add(carre);
		optionDessin.add(selectionner);
		
		this.add(dessin);
		this.add(ligne);
		this.add(ellipse);
		this.add(cercle);
		this.add(rectangle);
		this.add(carre);
		this.add(selectionner);
	}
	
	private void optionsCouleur() {
		JLabel couleurs = new JLabel("        COULEURS");
		
		JButton couleur = new JButton(
				new ActionChoisirCouleur(panneauDessin));
		JButton couleurP = new JButton(
				new ActionChoisirCouleurP(panneauDessin));

		ButtonGroup remplissage = new ButtonGroup();
		JToggleButton aucune = new JToggleButton(
				new ActionChoisirModeRemplissage(panneauDessin, 
						Remplissage.AUCUNE));
		JToggleButton uniforme = new JToggleButton(
				new ActionChoisirModeRemplissage(panneauDessin, 
						Remplissage.UNIFORME));
		JToggleButton degrade = new JToggleButton(
				new ActionChoisirModeRemplissage(panneauDessin, 
						Remplissage.DEGRADE));
		JToggleButton contour = new JToggleButton(
				new ActionChoisirModeRemplissage(panneauDessin, 
						Remplissage.CONTOUR));
		
		couleur.setMaximumSize(this.getPreferredSize());
		couleurP.setMaximumSize(this.getPreferredSize());
		aucune.setMaximumSize(this.getPreferredSize());
		uniforme.setMaximumSize(this.getPreferredSize());
		degrade.setMaximumSize(this.getPreferredSize());
		contour.setMaximumSize(this.getPreferredSize());
		
		couleur.setName(ActionChoisirCouleur.NOM_ACTION);
		couleurP.setName(ActionChoisirCouleurP.NOM_ACTION);
		aucune.setName("Aucune");
		uniforme.setName("Uniforme");
		degrade.setName("Dégradé");
		contour.setName("Contour");
		
		remplissage.add(aucune);
		aucune.setSelected(true);
		remplissage.add(uniforme);
		remplissage.add(degrade);
		remplissage.add(contour);
		
		this.add(couleurs);
		this.add(couleur);
		this.add(couleurP);
		this.add(aucune);
		this.add(uniforme);
		this.add(degrade);
		this.add(contour);
	}
	
	private void optionsOrdre() {
		JLabel ordre = new JLabel("            ORDRE");
		
		JButton avant = new JButton(
				new ActionOrdre(panneauDessin, 
						ActionOrdre.NOM_ACTION_AVANT));
		JButton arriere = new JButton(
				new ActionOrdre(panneauDessin, 
						ActionOrdre.NOM_ACTION_ARRIERE));
		JButton avantPlan = new JButton(
				new ActionOrdre(panneauDessin, 
						ActionOrdre.NOM_ACTION_PREMIERPLAN));
		JButton arrierePlan = new JButton(
				new ActionOrdre(panneauDessin, 
						ActionOrdre.NOM_ACTION_ARRIEREPLAN));
		
		avant.setMaximumSize(this.getPreferredSize());
		arriere.setMaximumSize(this.getPreferredSize());
		avantPlan.setMaximumSize(this.getPreferredSize());
		arrierePlan.setMaximumSize(this.getPreferredSize());
		
		avant.setName(ActionOrdre.NOM_ACTION_AVANT);
		arriere.setName(ActionOrdre.NOM_ACTION_ARRIERE);
		avantPlan.setName(ActionOrdre.NOM_ACTION_PREMIERPLAN);
		arrierePlan.setName(ActionOrdre.NOM_ACTION_ARRIEREPLAN);
		
		this.add(ordre);
		this.add(avantPlan);
		this.add(avant);
		this.add(arriere);
		this.add(arrierePlan);
		
	}
	
	private void optionsAutre() {
		JLabel autre = new JLabel("            AUTRE");
		
		JButton annuler = new JButton(
				new ActionAnnulerRefaire(panneauDessin, 
						ActionAnnulerRefaire.NOM_ACTION_ANNULER));
		JButton refaire = new JButton(
				new ActionAnnulerRefaire(panneauDessin, 
						ActionAnnulerRefaire.NOM_ACTION_REFAIRE));
		
		JButton exporter = new JButton(
				new ActionExporter(panneauDessin));
		JButton effacerTout = new JButton(
				new ActionEffacer(panneauDessin));
		
		JCheckBox acrenelage = new JCheckBox("Anticrénelage");
		acrenelage.setFocusable(false);
		acrenelage.addActionListener(new ActionAnticrenelage(panneauDessin));
		JCheckBox grille = new JCheckBox("Grille");
		grille.setFocusable(false);
		grille.addActionListener(new ActionAfficheGrille(panneauDessin));
		
		annuler.setMaximumSize(this.getPreferredSize());
		refaire.setMaximumSize(this.getPreferredSize());
		exporter.setMaximumSize(this.getPreferredSize());
		effacerTout.setMaximumSize(this.getPreferredSize());
		
		annuler.setName(ActionAnnulerRefaire.NOM_ACTION_ANNULER);
		annuler.setName(ActionAnnulerRefaire.NOM_ACTION_REFAIRE);
		effacerTout.setName(ActionEffacer.NOM_ACTION);
		
		this.add(autre);
		this.add(annuler);
		this.add(refaire);
		this.add(exporter);
		this.add(effacerTout);
		this.add(acrenelage);
		this.add(grille);
	}
	
	private void initComponents() {	
		optionsDessin();
		optionsCouleur();
		optionsOrdre();
		optionsAutre();
	}
}