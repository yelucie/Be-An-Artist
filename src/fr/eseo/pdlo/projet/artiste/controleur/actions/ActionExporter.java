package fr.eseo.pdlo.projet.artiste.controleur.actions;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.JOptionPane;

import fr.eseo.pdlo.projet.artiste.vue.ihm.PanneauDessin;

@SuppressWarnings("serial")
public class ActionExporter extends AbstractAction{
	public static final String NOM_ACTION = "Exporter";
	public static final String NOM_PAR_DEFAUT = "Dessin";
	
	private PanneauDessin panneauDessin;
	
	public ActionExporter(PanneauDessin panneauDessin) {
		super(NOM_ACTION);
		this.panneauDessin = panneauDessin;
	}
	
	public void actionPerformed(ActionEvent event) {
		int action = JOptionPane.showConfirmDialog(
				this.panneauDessin,
				"Exporter?", 
				NOM_ACTION, 
				JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
		if(action == 0) {
			String nom = (String) JOptionPane.showInputDialog(
					this.panneauDessin,
					"Choisissez un nom", 
					"Nom du nouveau dessin", 
					JOptionPane.QUESTION_MESSAGE,
					null, null, null);
			if(nom.equals("")) {
				nom = NOM_PAR_DEFAUT;
			}
			
			BufferedImage bufferedImage = new BufferedImage(
		    		this.panneauDessin.getWidth(),
		    		this.panneauDessin.getHeight(),
		    		BufferedImage.TYPE_INT_RGB);
		    
		    Graphics2D g2d = bufferedImage.createGraphics();
		    this.panneauDessin.paint(g2d);
		    g2d.dispose();
		    
		    try { 
		        ImageIO.write(bufferedImage, "jpg", new File(nom + ".jpg")); 
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		}
	  }
}