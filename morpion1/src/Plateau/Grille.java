package Plateau;

public class Grille {
	
	private final int max = 3;
	private char[][] grille;
	
	public Grille(){
		grille = new char[max][max];
		initGrille();
	}

	public char[][] getGrille() {
		return grille;
	}

	public void setGrille(char[][] grille) {
		this.grille = grille;
	}

	public int getMax() {
		return max;
	}
	
	public Boolean estVide(int i, int j){
		return(grille[i][j] == ' ');
	}
	
	public Boolean estPleine(int i, int j){
		return(grille[i][j] != ' ');
	}
	
	public void initGrille(){
		for(int i=0; i<max; i++){
			for(int j=0; j<max; j++){
				grille[i][j] = ' ';
			}
		}
	}
	
	public Boolean grillePleine(){
		Boolean flag = true;
		for(int i=0; i<max; i++){
			for(int j=0; j<max; j++){
				if(estVide(i, j)){
					flag = false;
				}
			}
		}
		return flag;
	}
	
	public Boolean Win(char p){
		Boolean flag = false;
		
		for(int i=0; i<max; i++){
			if(grille[i][0]==p && grille[i][1]==p && grille[i][2]==p){
				flag = true;
			}
		}
		
		for(int j=0; j<max; j++){
			if(grille[0][j]==p && grille[1][j]==p && grille[2][j]==p){
				flag = true;
			}
		}
		
		if((grille[0][0]==p && grille[1][1]==p && grille[2][2]==p) || (grille[0][2]==p && grille[1][1]==p && grille[2][0]==p)){
			flag = true;
		}
		
		return flag;
	}
	
	public void addTo(int i, int j, char p){
			grille[i][j]=p;
	}
	
	public void afficheGrille(){
		System.out.println();
		for(int i=0; i<max; i++){
			for(int j=0; j<max; j++){
				System.out.println("|"+grille[i][j]);
			}
			System.out.println("|");
		}
		System.out.println();
	}
}
