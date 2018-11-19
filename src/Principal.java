import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.lang.Thread.sleep;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Principal extends JFrame{
	
	Desenho bcgrnd = new Desenho("background.gif", 498, 720);
	
	JLabel lBcgrnd = new JLabel(bcgrnd.getImg());
	
	ArrayList<DesenhoMovel> stones = new ArrayList<DesenhoMovel>();
	ArrayList<JLabel> lStones = new ArrayList<JLabel>();
	int stonesI = ThreadLocalRandom.current().nextInt(0, 3);
	int localStone1 = ThreadLocalRandom.current().nextInt(0, 418);
	int localStone2 = ThreadLocalRandom.current().nextInt(0, 412);
	int localStone3 = ThreadLocalRandom.current().nextInt(0, 408);
	int qtdeStones = 10;
	String[] stonesS = {"stone1.png", "stone2.png", "stone3.png"};
	
	
	DesenhoMovel ship1 = new DesenhoMovel("ship1.png", 188, 568);
	JLabel lShip1 = new JLabel(ship1.getImg());
	
//	 public boolean collision(Component a, Component b) {
//	        int aX = a.getX();
//	        int aY = a.getY();
//	        int ladoDireitoA = aX + a.getWidth();
//	        int ladoEsquerdoA = aX;
//	        int ladoBaixoA = aY + a.getHeight();
//	        int ladoCimaA = aY;
//
//	        int bX = b.getX();
//	        int bY = b.getY();
//	        int ladoDireitoB = bX + b.getWidth();
//	        int ladoEsquerdoB = bX;
//	        int ladoBaixoB = bY + b.getHeight();
//	        int ladoCimaB = bY;
//
//	        boolean collision = false;
//
//	        boolean cDireita = false;
//	        boolean cCima = false;
//	        boolean cBaixo = false;
//	        boolean cEsquerda = false;
//
//	        if (ladoDireitoA >= ladoEsquerdoB) {
//	            cDireita = true;
//	        }
//	        if (ladoCimaA <= ladoBaixoB) {
//	            cCima = true;
//	        }
//	        if (ladoBaixoA >= ladoCimaB) {
//	            cBaixo = true;
//	        }
//	        if (ladoEsquerdoA <= ladoDireitoB) {
//	            cEsquerda = true;
//	        }
//
//	        if (cDireita && cEsquerda && cBaixo && cCima) {
//	            collision = true;
//	        }
//
//	        return collision;
//	    }
	
	
	public Principal() {
	    this.window();
	    this.component();
	    this.addMoviment();
	    //new Veficacao().start();
    }
	
	public static void main(String[] args) {
		Runnable down = new DownStones();
//		Runnable add = new AddThread();
		Thread rDown = new Thread(down);
//		Thread rAdd = new Thread(add);
		rDown.start();
//		rAdd.start();	
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
					try {
						ship1.moveUp();
					} catch (LimitBackgroundException e) {
						e.printStackTrace();
					}
				} else if(arg0.getKeyCode() == 40){
					try {
						ship1.moveDown(588);
					} catch (LimitBackgroundException e) {
						e.printStackTrace();
					}
				} else if(arg0.getKeyCode() == 39){
					try {
						ship1.moveRight();
					} catch (LimitBackgroundException e) {
						e.printStackTrace();
					}
				} else if(arg0.getKeyCode() == 37){
					try {
						ship1.moveLeft();
					} catch (LimitBackgroundException e) {
						e.printStackTrace();
					}
				}
				lShip1.setBounds(ship1.getX(), ship1.getY(), lShip1.getWidth(), lShip1.getHeight());
			}
		});
	}
	public void window() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(498, 720);
        this.setVisible(true);
        setResizable(false);
        
        stones.add(new DesenhoMovel("stone1.png", localStone1, 0));	
        stones.add(new DesenhoMovel("stone2.png", localStone2, 0));
    	stones.add(new DesenhoMovel("stone3.png", localStone3, 0));
    	
    	
    	
    	
        for(int i = 0; i < qtdeStones; i++) {
        	stones.add(new DesenhoMovel(stonesS[ThreadLocalRandom.current().nextInt(0, 3)], localStone3, 0));
    		lStones.add(new JLabel(stones.get(stonesI).getImg()));
    		this.add(lStones.get(i));
    	}
        
    	
        
        this.add(lShip1);
        this.add(lBcgrnd);
	}
	public void component() {
		lBcgrnd.setBounds(0, 0, 498, 720);
		lShip1.setBounds(ship1.getX(), ship1.getY(), 128, 128);
		int j = 0;
		for(int i = 0; i < qtdeStones; i++) {
			
			lStones.get(i).setBounds(stones.get(j).getX(), stones.get(j).getY(), 80, 60);
			localStone1 = ThreadLocalRandom.current().nextInt(0, 418);
			localStone2 = ThreadLocalRandom.current().nextInt(0, 412);
			localStone3 = ThreadLocalRandom.current().nextInt(0, 408);
			if(j<2) {
				j++;
			}
		}
		
//		for(int i = 0; i < qtdeStones; i++) {
//			if(stonesI == 0) {
//				paintStone(stonesI, 80, 60);
//			} else if(stonesI == 1) {
//				paintStone(stonesI, 100, 70);
//			} else if(stonesI == 2) {
//				paintStone(stonesI, 120, 90);
//			}
//		}
	}
	
	
}
//public class Verification extends Thread{
//	public void run() {
//		while(true) {
//			try {
//				sleep(10);
//			} catch (Exception e) {
//				
//			}
//		}
//	}
//}
