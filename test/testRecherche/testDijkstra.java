package testRecherche;
import java.util.Date;
import java.util.LinkedList;

import carte.Carte;
import recherche.AlgorithmeDijkstra;
import recherche.CaseEnAttenteDeTraitement;

public class testDijkstra {
	private static final int xD = 13;
	private static final int yD = 0;
	private static final int xA = 1900;
	private static final int yA = 1900;
	
	public static void main(String[] args){
		Carte testCarte = new Carte("carte/carteDeuxMille.carte");
		AlgorithmeDijkstra testDeRecherche = new AlgorithmeDijkstra(testCarte);
		LinkedList<CaseEnAttenteDeTraitement> chemin = new LinkedList<CaseEnAttenteDeTraitement>();
		
		
		
		CaseEnAttenteDeTraitement caseDepart = new CaseEnAttenteDeTraitement(testCarte.getCase()[xD][yD],0);
		CaseEnAttenteDeTraitement caseArrive = new CaseEnAttenteDeTraitement(testCarte.getCase()[xA][yA],0);
		long c = new Date().getTime();
		chemin=testDeRecherche.getCheminDijkstra(caseDepart.getCase(), caseArrive.getCase());
		c=new Date().getTime() - c;
		System.out.print(c);
		/*int i=0;
		while(i < chemin.size()) {
			System.out.print(chemin.get(i).getCase().getCoordX()+"-"+chemin.get(i).getCase().getCoordY()+"\n");
			i=i+1;
		}*/
	}
}
