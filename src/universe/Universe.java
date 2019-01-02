package universe;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import algorithm.Automata;

@SuppressWarnings("serial")


public class Universe extends JFrame {
	
	public static final int UNIVERSE_HEIGHT = 800;
	public static final int UNIVERSE_WIDTH = 800;
	public static final int CELL_SIZE = 8;
	public static final int CELL_INDEX = UNIVERSE_HEIGHT/CELL_SIZE;
	public static final int GENERATION_UPDATE = 100;
	
	
	public Automata automa = new Automata(CELL_INDEX);
	
	public int contatore = 0;
	
	private class DrawUniverse extends JPanel{
		//@Override
		public void paintComponent(Graphics g) {
			
			int i;
			int j;
			
			
			super.paintComponents(g);
			setBackground(Color.white);
			for(i=0; i<CELL_INDEX; i++) {
				for(j=0; j<CELL_INDEX; j++) {
							if(automa.cells.isAlive(i, j)==true) {
								g.setColor(Color.black);
								g.fillRect(i*CELL_SIZE, j*CELL_SIZE, CELL_SIZE, CELL_SIZE);
							}
				}
			}
		}
		
	}
	
	private DrawUniverse space;
	
	public Universe() {
		
		space = new DrawUniverse();
		space.setPreferredSize(new Dimension(UNIVERSE_WIDTH, UNIVERSE_HEIGHT));
		this.setContentPane(space);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.pack();
		this.setTitle("Cellular automata");
		this.setVisible(true);
		
		ActionListener updateGeneration = new ActionListener() {
			//@Override
			public void actionPerformed(ActionEvent evt) {
				update();
				repaint();
			}
		};
		
		new Timer(GENERATION_UPDATE, updateGeneration).start();
		
	}
	
	public void update() {
		
		System.out.println("Generazione " + contatore++);
		automa.step();
		
	}
	
	public static void main(String[] args) {
		
		new Universe();
	}

}