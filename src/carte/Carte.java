package carte;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Carte implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Case cases[][];
	
	public Carte(String nomDuFichier) {
		ObjectInputStream objetAOuvrir;
		try {
			objetAOuvrir = new ObjectInputStream(
					new BufferedInputStream(
							new FileInputStream(
									new File(nomDuFichier))));
			this.cases=((Carte)objetAOuvrir.readObject()).getCase();
			objetAOuvrir.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();;
		}
	}
	
	public Carte(Case[][] cases) {
		this.cases=cases;
	}
	
	public void enregistrerMap(String nomDuFichier){
		ObjectOutputStream objetASauvegarder;
		try {
			objetASauvegarder = new ObjectOutputStream(
					new BufferedOutputStream(
							new FileOutputStream(
									new File(nomDuFichier))));
			
			objetASauvegarder.writeObject(this);
			objetASauvegarder.close();
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public Case[][] getCase() {
		return this.cases;
	}
	
	public void setCase(Case[][] cases) {
		this.cases=cases;
	}
}
