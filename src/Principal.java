import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.lang.Thread.sleep;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Principal extends JFrame implements Runnable{
	
	Desenho bcgrnd = new Desenho("background.gif", 498, 720);
	
	JLabel lBcgrnd = new JLabel(bcgrnd.getImg());
	
	ArrayList<DesenhoMovel> stones = new ArrayList<DesenhoMovel>();
	
	
	boolean stone1 = stones.add(new DesenhoMovel("stone1.png", ThreadLocalRandom.current().nextInt(0, 418), 10));	
	JLabel lStone1 = new JLabel(stones.get(0).getImg());
//	DesenhoMovel stone2 = new DesenhoMovel("stone2.png", 256, 256);	
//	JLabel lStone2 = new JLabel(stone2.getImg());
//	DesenhoMovel stone3 = new DesenhoMovel("stone3.png", 256, 256);	
//	JLabel lStone3 = new JLabel(stone3.getImg());
	
	DesenhoMovel ship1 = new DesenhoMovel("ship1.png", 188, 568);
	JLabel lShip1 = new JLabel(ship1.getImg());
	
	public void run() {
		while (true) {
			try {
				sleep(190);
				stones.get(0).moveDown();
				lStone1.setBounds(stones.get(0).getX(), stones.get(0).getY(), lStone1.getWidth(), lStone1.getHeight());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
	public Principal() {
	    this.window();
	    this.component();
	    this.addMoviment();
	    //new Veficacao().start();
    }
	
	public void moveRight(DesenhoMovel d, JLabel e) {
		if(d.getX() < 388) {
			d.moveRight();
			e.setBounds(d.getX(), d.getY(), e.getWidth(), e.getHeight());
		}
	}
	
	public void moveUp(DesenhoMovel d, JLabel e) {
		if(d.getY() > 10) {
			d.moveUp();
			e.setBounds(d.getX(), d.getY(), e.getWidth(), e.getHeight());
		}
	}
	
	public void moveLeft(DesenhoMovel d, JLabel e) {
		if(d.getX() > 0) {
			d.moveLeft();
			e.setBounds(d.getX(), d.getY(), e.getWidth(), e.getHeight());
		}
	}
	
	public void moveDown(DesenhoMovel d, JLabel e) {
		if(d.getY() < 568) {
			d.moveDown();
			e.setBounds(d.getX(), d.getY(), e.getWidth(), e.getHeight());
		}
	}
	
	
	public static void main(String[] args) {
		Runnable app = new Principal();
		Thread app0 = new Thread(app);
		app0.start();
	}
	public void addMoviment() {
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == 38) {
				moveUp(ship1, lShip1);
				} else if(arg0.getKeyCode() == 40){
					moveDown(ship1, lShip1);
				} else if(arg0.getKeyCode() == 39){
					moveRight(ship1, lShip1);
				} else if(arg0.getKeyCode() == 37){
					moveLeft(ship1, lShip1);
				}
			}
		});
	}
	public void window() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(498, 720);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        setResizable(false);
        
        this.add(lStone1);
//        this.add(lStone2);
//        this.add(lStone3);
        this.add(lShip1);
        this.add(lBcgrnd);
	}
	public void component() {
		lBcgrnd.setBounds(0, 0, 498, 720);
		lShip1.setBounds(ship1.getX(), ship1.getY(), 128, 128);
		lStone1.setBounds(stones.get(0).getX(), stones.get(0).getY(), 80, 60);
//		lStone2.setBounds(stone2.getX(), stone2.getY(), 40, 60);
//		lStone3.setBounds(stone3.getX(), stone3.getY(), 10, 60);
	}
	
	
}
