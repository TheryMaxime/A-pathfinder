package carte;
//Classe pour créer une Carte 
public class CreerCarte {
	
	//Mettre 
	private static final int tailleX =2000;
	private static final int tailleY =2000;
	private static final double obstacle =0;
	
	public static void main(String[] args){
		Carte test;
		Case cases[][] = new Case[tailleX][tailleY];//
		int y=0,x=0;
		while(y<tailleY) {
			while(x<tailleX) {
				cases[x][y]= new Case(x,y);
				x=x+1;
			}
			x=0;
			y=y+1;
		}
		/*
		//met une ligne d'obstacle
		for(int j=13;j<17;j=j+1) {
			for(int i=0;i<16;i=i+1) {
				cases[15][i].setVitesse(obstacle);
			}
		}
		*/
		test = new Carte(cases);
		test.enregistrerMap("carte/carteDeuxMille.carte");
		
	}
}
