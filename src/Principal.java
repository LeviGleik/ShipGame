import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.lang.Thread.sleep;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Principal extends JFrame {
	
	Desenho bcgrnd = new Desenho("background.gif", 498, 720);
	
	JLabel lBcgrnd = new JLabel(bcgrnd.getImg());
	
	DesenhoMovel stone1 = new DesenhoMovel("stone1.png", 256, 256);	
	JLabel lStone1 = new JLabel(stone1.getImg());
	DesenhoMovel stone2 = new DesenhoMovel("stone2.png", 256, 256);	
	JLabel lStone2 = new JLabel(stone2.getImg());
	DesenhoMovel stone3 = new DesenhoMovel("stone3.png", 256, 256);	
	JLabel lStone3 = new JLabel(stone3.getImg());
	
	DesenhoMovel ship1 = new DesenhoMovel("ship1.png", 128, 128);
	JLabel lShip1 = new JLabel(ship1.getImg());
	
	public Principal() {
	    this.window();
	    this.component();
	    this.addMoviment();
	    //new Veficacao().start();
    }
	
	public void moveRight(DesenhoMovel d) {
		if(ship1.getX() < 388) {
			ship1.moveRight();
			System.out.println(ship1.getX());
			lShip1.setBounds(ship1.getX(), ship1.getY(), lShip1.getWidth(), lShip1.getHeight());
		}
	}
	
	public void moveUp(DesenhoMovel d) {
		if(ship1.getY() > 10) {
			ship1.moveUp();
			lShip1.setBounds(ship1.getX(), ship1.getY(), lShip1.getWidth(), lShip1.getHeight());
		}
	}
	
	public void moveLeft(DesenhoMovel d) {
		if(ship1.getX() > 0) {
			ship1.moveLeft();
			lShip1.setBounds(ship1.getX(), ship1.getY(), lShip1.getWidth(), lShip1.getHeight());
		}
	}
	
	public void moveDown(DesenhoMovel d) {
		if(ship1.getY() < 568) {
			ship1.moveDown();
			lShip1.setBounds(ship1.getX(), ship1.getY(), lShip1.getWidth(), lShip1.getHeight());
		}
	}
	
	
	public static void main(String[] args) {
		Principal app = new Principal();
	}
	public void addMoviment() {
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent arg0) {}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				if(arg0.getKeyCode() == 38) {
					moveUp(ship1);
				} else if(arg0.getKeyCode() == 40){
					moveDown(ship1);
				} else if(arg0.getKeyCode() == 39){
					moveRight(ship1);
				} else if(arg0.getKeyCode() == 37){
					moveLeft(ship1);
				}
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {}
		});
	}
	public void window() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(498, 720);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        setResizable(false);
        
//        this.add(lStone1);
//        this.add(lStone2);
//        this.add(lStone3);
        this.add(lShip1);
        this.add(lBcgrnd);
	}
	public void component() {
		lBcgrnd.setBounds(0, 0, 498, 720);
		lShip1.setBounds(ship1.getX(), ship1.getY(), 128, 128);
//		lStone1.setBounds(stone1.getX(), stone1.getY(), 80, 60);
//		lStone2.setBounds(stone2.getX(), stone2.getY(), 40, 60);
//		lStone3.setBounds(stone3.getX(), stone3.getY(), 10, 60);
	}
	
	
}
