package algorithm;

public class Grid {
	
	//La griglia è una matrice. Ogni posto rappresenta una cellula.

	private int[][] grid;
	private int index;
	
	//Costruttore: crea una matrice vuota.
	public Grid(int index) {
		
		this.index = index;
		
		grid = new int[index][index];
		for(int i = 0; i<index; i++) {
			for(int j = 0; j<index; j++) {
				grid[i][j] = 0;
			}
		}
		
	}
	
	//Controlla se una cellula è viva
	 public boolean isAlive(int i, int j) {
		if(i<0 || i > index-1 || j < 0 || j > index-1) {
			return false;
		}
		
		if(grid[i][j]==1) {
			return true;
		}
		return false;
	}
	 
	//Fai nascere una cellula
	public void giveLife(int i, int j) {
		
		grid[i][j] = 1;
	}
	 
	//Uccidi una cellula
	public void kill(int i, int j) {
		grid[i][j] = 0;
	}
	
	//Controlla se la cellula può sopravvivere o no.
	public int checkSurvive(int i, int j) {
		
		int relatives = 0;
		
		if(this.isAlive(i+1, j)) {relatives++;}
		if(this.isAlive(i-1, j)) {relatives++;}
		if(this.isAlive(i, j+1)) {relatives++;}
		if(this.isAlive(i, j-1)) {relatives++;}
		if(this.isAlive(i+1, j+1)) {relatives++;}
		if(this.isAlive(i+1, j-1)) {relatives++;}
		if(this.isAlive(i-1, j+1)) {relatives++;}
		if(this.isAlive(i-1, j-1)) {relatives++;}
		
		if(relatives < 2 || relatives > 3) {return 0;}
		if(relatives == 3 || relatives == 2) {return 1;}
		return 2;
		
	}
	
	//Controlla se la cellula deve nascere o no
	
	public int checkBirth(int i, int j) {
		
		int relatives = 0;
		
		if(this.isAlive(i+1, j)) {relatives++;}
		if(this.isAlive(i-1, j)) {relatives++;}
		if(this.isAlive(i, j+1)) {relatives++;}
		if(this.isAlive(i, j-1)) {relatives++;}
		if(this.isAlive(i+1, j+1)) {relatives++;}
		if(this.isAlive(i+1, j-1)) {relatives++;}
		if(this.isAlive(i-1, j+1)) {relatives++;}
		if(this.isAlive(i-1, j-1)) {relatives++;}
		
		if(relatives == 3) {return 1;}
		return 0;
		
	}
	
	//@Override
	public void toString(Grid g) {
		
		for(int i=0; i<index; i++) {
			
			for(int j=0; j<index; j++) {
				
				System.out.print(" " + grid[i][j]);
			}
			System.out.print("\n");
		}
		
	}
	
	
	
}
