package recherche;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

import carte.Carte;
import carte.Case;

public class AlgorithmeDijkstra {
	private static final int obstacle = 0;
	private static final int coutInitial = 0;
	private CaseEnAttenteDeTraitement cases[][];

	public AlgorithmeDijkstra(Carte carte) {
		Case casesTmp[][] = carte.getCase();
		int x=0;
		int y=0;
		this.cases = new CaseEnAttenteDeTraitement[casesTmp.length][casesTmp[y].length];
		while(y<casesTmp.length) {
			while(x<casesTmp[y].length) {
			this.cases[x][y] = new CaseEnAttenteDeTraitement(casesTmp[x][y], 0);
			x=x+1;
			}
			x=0;
			y=y+1;
		}
	}

	private List<CaseEnAttenteDeTraitement> getVoisin(CaseEnAttenteDeTraitement caseActuel) {
		LinkedList<CaseEnAttenteDeTraitement> voisin = new LinkedList<CaseEnAttenteDeTraitement>();

		if ((caseActuel.getCase().getCoordX() + 1)<this.cases[0].length)
			voisin.add(cases[caseActuel.getCase().getCoordX() + 1][caseActuel.getCase().getCoordY()]);
		if ((caseActuel.getCase().getCoordX() - 1)>=0)
			voisin.add(cases[caseActuel.getCase().getCoordX() - 1][caseActuel.getCase().getCoordY()]);
		if ((caseActuel.getCase().getCoordY() + 1)<this.cases.length)
			voisin.add(cases[caseActuel.getCase().getCoordX()][caseActuel.getCase().getCoordY() + 1]);
		if ((caseActuel.getCase().getCoordY() - 1)>=0)
			voisin.add(cases[caseActuel.getCase().getCoordX()][caseActuel.getCase().getCoordY() - 1]);
		
		voisin.remove(caseActuel.getCasePrecedente());
		
		return voisin;
	}

	private LinkedList<CaseEnAttenteDeTraitement> getChemin(CaseEnAttenteDeTraitement caseActuel) {
		LinkedList<CaseEnAttenteDeTraitement> chemin = new LinkedList<CaseEnAttenteDeTraitement>();
		while (caseActuel.getCasePrecedente() != null) {
			chemin.addFirst(caseActuel);
			caseActuel = caseActuel.getCasePrecedente();
		}
		chemin.addFirst(caseActuel);
		return chemin;
	}

	//Fonction trop couteuse !
	private int getKeyCaseEnAttenteDeTraitement(CaseEnAttenteDeTraitement caseActuel, LinkedList<CaseEnAttenteDeTraitement> casesEnAttenteDeTraitement) {
		int indice=0;
		double coutActuel = caseActuel.getLongeurDepuisLaPosition();
		
		while(indice<casesEnAttenteDeTraitement.size()) {
			if(coutActuel<=casesEnAttenteDeTraitement.get(indice).getLongeurDepuisLaPosition()) {
				return indice;
			}
			indice = indice +1;
		}
		
				
		return indice; 
	}
	
	public LinkedList<CaseEnAttenteDeTraitement> getCheminDijkstra(Case caseDepart, Case caseArrive) {
		LinkedList<CaseEnAttenteDeTraitement> chemin = new LinkedList<CaseEnAttenteDeTraitement>();
		//LinkedList<CaseEnAttenteDeTraitement> casesEnAttenteDeTraitement = new LinkedList<CaseEnAttenteDeTraitement>();
		
		Comparator<CaseEnAttenteDeTraitement> comparateur = new DoubleComparateur();
		PriorityQueue<CaseEnAttenteDeTraitement> casesEnAttenteDeTraitement = new PriorityQueue<CaseEnAttenteDeTraitement>(11,comparateur);
		
		CaseEnAttenteDeTraitement depart = this.cases[caseDepart.getCoordX()][caseDepart.getCoordY()];
		CaseEnAttenteDeTraitement arrive = this.cases[caseArrive.getCoordX()][caseArrive.getCoordY()]; 
		CaseEnAttenteDeTraitement caseActuel;
		double nouveauCout=0;
		
		//casesEnAttenteDeTraitement.addFirst(depart);
		casesEnAttenteDeTraitement.add(depart);
		
		
		while (casesEnAttenteDeTraitement!=null) {
			//caseActuel = casesEnAttenteDeTraitement.getFirst();
			caseActuel = casesEnAttenteDeTraitement.remove();
			
			if((caseActuel.getCase().getCoordX()==arrive.getCase().getCoordX())&&(caseActuel.getCase().getCoordY()==arrive.getCase().getCoordY())) {
				return this.getChemin(caseActuel);
			}
			for (CaseEnAttenteDeTraitement voisin:this.getVoisin(caseActuel)) {
				if(voisin.getCase().getVitesse()!=obstacle) {
					nouveauCout=caseActuel.getLongeurDepuisLaPosition()+(1/voisin.getCase().getVitesse());
					if(nouveauCout < voisin.getLongeurDepuisLaPosition()||voisin.getLongeurDepuisLaPosition()==coutInitial) {
						//Pas le faire tout le temps sinon trop long
						//casesEnAttenteDeTraitement.remove(voisin);
						voisin.setCasePrecedente(caseActuel);
						voisin.setLongeurDepuisLaPosition(nouveauCout);
						//casesEnAttenteDeTraitement.add(this.getKeyCaseEnAttenteDeTraitement(voisin, casesEnAttenteDeTraitement), voisin);
						casesEnAttenteDeTraitement.add(voisin);
					}
				}
			}
			//casesEnAttenteDeTraitement.remove(caseActuel);
		}
		return chemin;
	}
}
