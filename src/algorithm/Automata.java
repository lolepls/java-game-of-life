package algorithm;
import java.util.concurrent.ThreadLocalRandom;

public class Automata {
	
	private static final int ADAMEVE = 300; //Numero di adamo ed eva da generare
	public Grid cells;
	public Grid next_generation;
	private int index;
	
	public Automata(int index) {
		
		this.index = index;
		cells = new Grid(index);
		this.initialize(cells);
		
	}
	
	public void step() {
		int i = 0;
		int j = 0;
		next_generation = new Grid(index);
		
		for(i=0; i<index; i++) {
			for(j=0;j<index;j++) {
				
				if(cells.isAlive(i, j)== true) {
					if(cells.checkSurvive(i, j)==0) {next_generation.kill(i, j);}
					if(cells.checkSurvive(i, j)==1) { next_generation.giveLife(i, j);}
				}
				if(cells.isAlive(i, j)== false) {
					if(cells.checkBirth(i, j)==1) { next_generation.giveLife(i, j);}
				}
			}
		}
		
		cells = next_generation;
	}
	
	public void initialize(Grid g) {

		int n_AdamEve = ThreadLocalRandom.current().nextInt(0, ADAMEVE);
		
		
		for(; n_AdamEve != 0; n_AdamEve--) {
			
			
			int i = ThreadLocalRandom.current().nextInt(index/3, index/2);
			int j = ThreadLocalRandom.current().nextInt(index/3, index/2);
			
			
			if (g.isAlive(i, j)==false) {
				g.giveLife(i, j);
			}	
		}	
	}
	
	

}
