import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.lang.Thread.sleep;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Principal extends JFrame implements Runnable{
	
	Desenho bcgrnd = new Desenho("images/background.gif", 498, 720);
	
	JLabel lBcgrnd = new JLabel(bcgrnd.getImg());
	
	DesenhoMovel stone1 = new DesenhoMovel("images/stone1.png", ThreadLocalRandom.current().nextInt(0, 418), 0);
	DesenhoMovel stone2 = new DesenhoMovel("images/stone2.png", ThreadLocalRandom.current().nextInt(0, 418), 0);
	DesenhoMovel stone3 = new DesenhoMovel("images/stone3.png", ThreadLocalRandom.current().nextInt(0, 418), 0);
	
	JLabel lStone1 = new JLabel(stone1.getImg());
	JLabel lStone2 = new JLabel(stone2.getImg());
	JLabel lStone3 = new JLabel(stone3.getImg());	
	
	DesenhoMovel ship1 = new DesenhoMovel("images/ship1.png", 188, 568);
	JLabel lShip1 = new JLabel(ship1.getImg());
	
	DesenhoMovel missile = new DesenhoMovel("images/missile.png", ship1.getX()+23, ship1.getY()-56);
	JLabel lMissile = new JLabel(missile.getImg());
	
	 public boolean collision(Component a, Component b) {
	        int aX = a.getX();
	        int aY = a.getY();
	        int ladoDireitoA = aX + a.getWidth();
	        int ladoEsquerdoA = aX;
	        int ladoBaixoA = aY + a.getHeight();
	        int ladoCimaA = aY;

	        int bX = b.getX();
	        int bY = b.getY();
	        int ladoDireitoB = bX + b.getWidth();
	        int ladoEsquerdoB = bX;
	        int ladoBaixoB = bY + b.getHeight();
	        int ladoCimaB = bY;

	        boolean collision = false;

	        boolean cDireita = false;
	        boolean cCima = false;
	        boolean cBaixo = false;
	        boolean cEsquerda = false;

	        if (ladoDireitoA >= ladoEsquerdoB) {
	            cDireita = true;
	        }
	        if (ladoCimaA <= ladoBaixoB) {
	            cCima = true;
	        }
	        if (ladoBaixoA >= ladoCimaB) {
	            cBaixo = true;
	        }
	        if (ladoEsquerdoA <= ladoDireitoB) {
	            cEsquerda = true;
	        }

	        if (cDireita && cEsquerda && cBaixo && cCima) {
	            collision = true;
	        }

	        return collision;
	    }
	
	
	public Principal() {
	    this.window();
	    this.component();
	    this.addMoviment();
	    //new Veficacao().start();
    }
	
	private DesenhoMovel DesenhoMovel(String string, int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		Runnable a = new Principal();
		new Thread(a).start();
	}
	public void run() {
		this.upMissile();
		this.downStones();
		this.collisionThread();
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
						ship1.moveUp(10);
					} catch (LimitBackgroundException e) {
					}
				} else if(arg0.getKeyCode() == 40){
					try {
						ship1.moveDown(588);
					} catch (LimitBackgroundException e) {
					}
				} else if(arg0.getKeyCode() == 39){
					try {
						ship1.moveRight();
					} catch (LimitBackgroundException e) {
					}
				} else if(arg0.getKeyCode() == 37){
					try {
						ship1.moveLeft();
					} catch (LimitBackgroundException e) {
					}
				}
				lShip1.setBounds(ship1.getX(), ship1.getY(), lShip1.getWidth(), lShip1.getHeight());
			}
		});
	}
	public void dead() {
		System.out.println("morreu");
	}
	public void addPoint() {
		System.out.println("ponto");
	}
	public void collisionThread() {
		new Thread() {
			@Override
			public void run() {
				while (true) {
					if(!collision(lStone1, lShip1)) {
						dead();
					} else if(collision(lMissile, lStone1)) {
						addPoint();
					}
				}
			}
		}.start();
	}
	public void upMissile() {
		new Thread() {
			@Override
			public void run() {
				while (true){
					try {
						sleep(1);
						missile.moveUp(0, 25, ship1, missile);
						lMissile.setBounds(missile.getX(), missile.getY(), lMissile.getWidth(), lMissile.getHeight());
					} catch (LimitBackgroundException | InterruptedException e) {
						
					}
				}
			}
		}.start();
	}
	public void downStones(){
		new Thread() {
			@Override
			public void run() {
				while (true) {
					
					try {
						sleep(1);
						stone1.moveDown(730, 100, stone1);
						lStone1.setBounds(stone1.getX(), stone1.getY(), lStone1.getWidth(), lStone1.getHeight());
					} catch (LimitBackgroundException | InterruptedException e) {	
					}
				}
			}
		}.start();
	}
	
	public void window() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(498, 720);
        this.setVisible(true);
        setResizable(false);
    	
        this.add(lStone1);
        this.add(lMissile);
        
        this.add(lShip1);
        this.add(lBcgrnd);
	}
	public void component() {
		lBcgrnd.setBounds(0, 0, 498, 720);
		lShip1.setBounds(ship1.getX(), ship1.getY(), 128, 128);
		lStone1.setBounds(stone1.getX(), stone1.getY(), 80, 60);
		lMissile.setBounds(missile.getX(), missile.getY(), 80, 60);
		
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
