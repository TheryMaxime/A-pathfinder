package carte;
import java.io.Serializable;

public class Case implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final int vitesseDefaut =1;
	private int coordX , coordY;
	private double vitesseCase;
	
	public Case (int coordX, int coordY) {
		this.coordX=coordX;
		this.coordY=coordY;
		vitesseCase=vitesseDefaut;
	}
	
	public Case (int coordX, int coordY, double vitesseCase) {
		this.coordX=coordX;
		this.coordY=coordY;
		this.vitesseCase=vitesseCase;
	}
	
	public int getCoordX() {
		return coordX;
	}
	
	public int getCoordY() {
		return coordY;
	}
	
	public void setVitesse(double vitesse) {
		this.vitesseCase=vitesse;
	}
	
	public double getVitesse() {
		return vitesseCase;
	}
}


