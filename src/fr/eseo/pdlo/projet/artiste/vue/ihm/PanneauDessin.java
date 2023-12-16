package fr.eseo.pdlo.projet.artiste.vue.ihm;

import java.awt.BasicStroke;
import java.awt.Color;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

import fr.eseo.pdlo.projet.artiste.controleur.outils.Outil;
import fr.eseo.pdlo.projet.artiste.modele.Remplissage;
import fr.eseo.pdlo.projet.artiste.modele.formes.Forme;
import fr.eseo.pdlo.projet.artiste.vue.formes.VueForme;

@SuppressWarnings("serial")
public class PanneauDessin extends javax.swing.JPanel{
	public static final int LARGEUR_PAR_DEFAUT = 500;
	public static final int HAUTEUR_PAR_DEFAUT = 250;
	public static final Color COULEUR_FOND_PAR_DEFAUT = Color.white;
	
	private int largeur;
	private int hauteur;
	private Color couleur;
	private Color couleurP;
	private Remplissage remplissage;
	private VueForme formeSelected;
	private boolean anticrenelage;
	private boolean grille;
	
	private final List<VueForme> vueFormes;
	private final List<VueForme> tracage;
	private final List<VueForme> annulerRefaire;
	private Outil outilCourant;
	
	public PanneauDessin(int largeur, int hauteur, Color fond){
		new JPanel();
		setPreferredSize(new Dimension(largeur,hauteur));
		setBackground(fond);
		this.formeSelected = null;
		this.vueFormes = new ArrayList<VueForme>();
		this.tracage = new ArrayList<VueForme>();
		this.annulerRefaire = new ArrayList<VueForme>();
		setCouleurCourante(Forme.COULEUR_PAR_DEFAUT);
		setCouleurPCourante(null);
		setModeRemplissageCourant(Remplissage.AUCUNE);
		setAnticrenelage(false);
		setGrille(false);
	}
	
	public PanneauDessin(){
		this(LARGEUR_PAR_DEFAUT, HAUTEUR_PAR_DEFAUT, COULEUR_FOND_PAR_DEFAUT);
	}
	
	public List<VueForme> getVueFormes(){
		return this.vueFormes;
	}
	
	public List<VueForme> getTracage(){
		return this.tracage;
	}
	
	public List<VueForme> getAnnulerRefaire(){
		return this.annulerRefaire;
	}

	public int getLargeur() {
		return this.largeur;
	}
	
	public int getHauteur() {
		return this.hauteur;
	}
	
	public Color getCouleur() {
		return this.couleur;
	}
	
	public Outil getOutilCourant() {
		return this.outilCourant;
	}
	
	public Color getCouleurCourante() {
		return this.couleur;
	}
	
	public Color getCouleurPCourante() {
		return this.couleurP;
	}
	
	public Remplissage getModeRemplissageCourant() {
		return this.remplissage;
	}
	
	public VueForme getSelected() {
		return this.formeSelected;
	}
	
	public boolean getAnticrenelage() {
		return this.anticrenelage;
	}
	
	public boolean getGrille() {
		return this.grille;
	}
	
	private void setOutilCourant(Outil outil) {
		if (outil != null) {
			this.outilCourant = outil;
			addMouseListener(outil);
			addMouseMotionListener(outil);
		}
	}
	
	public void setCouleurCourante(Color couleurCourante) {
		this.couleur = couleurCourante;
	}
	
	public void setCouleurPCourante(Color couleurCouranteP) {
		this.couleurP = couleurCouranteP;
	}
	
	public void setModeRemplissageCourant(Remplissage modeRemplissage) {
		this.remplissage = modeRemplissage;
	}
	
	public void setSelected(VueForme vueForme) {
		this.formeSelected = vueForme;
	}
	
	public void setAnticrenelage(boolean anticrenelage) {
		this.anticrenelage = anticrenelage;
	}
	
	public void setGrille(boolean grille) {
		this.grille = grille;
	}
	
	public void ajouterVueForme(VueForme vueForme) {
		getVueFormes().add(vueForme);
	}
	
	public void ajouterTracage(VueForme vueForme) {
		getTracage().add(vueForme);
	}
	
	public void ajouterAnnulerRefaire(VueForme vueForme) {
		getAnnulerRefaire().add(vueForme);
	}
	
	protected void paintComponent(Graphics g) {
		final float points[] = {3.0f};
	    final BasicStroke dashed = new BasicStroke(
	    		1.0f,
	    		BasicStroke.CAP_ROUND,
	    		BasicStroke.JOIN_ROUND,
	    		10.0f, points, 5.0f);
	    
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D)g.create();
		
		anticrenelage(g2D);
		grille(g2D);
		
		for (int i = 0 ; i<vueFormes.size(); i++) {
			vueFormes.get(i).affiche(g2D);
		}
		
		rubberbanding(g2D);
		
		if(this.formeSelected != null) {
			Stroke ancien = g2D.getStroke();
			Color avant = g2D.getColor();
			g2D.setColor(new Color(190,190,190));
			g2D.setStroke(dashed);
			
			Forme f = formeSelected.getForme();
			g2D.drawRect((int)f.getCadreMinX(), 
					(int)f.getCadreMinY(), 
					(int) Math.abs(f.getLargeur()),
					(int) Math.abs(f.getHauteur()));

			g2D.setStroke(ancien);
			g2D.setColor(avant);
		}
		
		g2D.dispose();
	}
	
	public void rubberbanding(Graphics2D g2D) {
		for (int j = 0 ; j<tracage.size(); j++) {
			tracage.get(j).affiche(g2D);
			tracage.remove(j);
		}
	}
	
	public void anticrenelage(Graphics2D g2D) {
		RenderingHints rh = new RenderingHints(
				RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_OFF);
		
		if(getAnticrenelage()) {
			rh = new RenderingHints(
					RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
		}
		
		g2D.setRenderingHints(rh);
	}
	
	public void grille(Graphics2D g2D) {
		final float points[] = {2.0f};
	    final BasicStroke dashed = new BasicStroke(
	    		0.25f,
	    		BasicStroke.CAP_ROUND,
	    		BasicStroke.JOIN_ROUND,
	    		5.0f, points, 5.0f);
	    
		if(getGrille()) {
			Stroke ancien = g2D.getStroke();
			Color avant = g2D.getColor();
			g2D.setColor(new Color(230,230,230));
			g2D.setStroke(dashed);
			
	        int cote = 20;
	        int ligne = getHeight() / cote;
	        int x = cote;
	        for (int i = 0; i < ligne; i++) {
	            g2D.drawLine(0, x, getWidth(), x);
	            x = x + cote;
	        }

	        int colonne = getWidth() / cote;
	        int y = cote;
	        for (int i = 0; i < colonne; i++) {
	            g2D.drawLine(y, 0, y, getHeight());
	            y = y + cote;
	        }
	        
	        g2D.setColor(avant);
	        g2D.setStroke(ancien);
		}
	}
	
	public void associerOutil(Outil outil) {
		if (getOutilCourant() != null) {
			dissocierOutil();
		}
		setOutilCourant(outil);
		getOutilCourant().setPanneauDessin(this);
	}
	
	public void dissocierOutil() {
		if(getOutilCourant() != null) {
			getOutilCourant().setPanneauDessin(null);
			removeMouseListener(getOutilCourant());
			removeMouseMotionListener(getOutilCourant());
			setOutilCourant(null);
		}
	}
}