package fr.eseo.pdlo.projet.artiste.modele;

public enum Remplissage {
	AUCUNE("Aucune"), UNIFORME("Uniforme"), CONTOUR("Contour"), DEGRADE("Dégradé");
	private String mode;
	
	private Remplissage(String mode) {
		this.mode = mode;
	}
	
	public String getMode() {
		return this.mode;
	}
}
