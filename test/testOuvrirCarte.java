import carte.Carte;
import carte.Case;

public class testOuvrirCarte {
		
	public static void main(String[] args){
		Carte test;
		int y=0,x=0;
		test = new Carte("carte/testObstacle.carte");
		Case cases[][]=test.getCase();
		while(y<cases.length) {
			while(x<cases[y].length) {
				System.out.print(cases[x][y].getVitesse());
				x=x+1;
			}
			System.out.println("");
			x=0;
			y=y+1;
		}		
	}
	
}
