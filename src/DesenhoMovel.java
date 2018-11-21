import static java.lang.Thread.sleep;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JLabel;
public class DesenhoMovel extends Desenho{
	public DesenhoMovel(String path, int x, int y) {
        super(path, x, y);
    }
	
	ArrayList<JLabel> points = new ArrayList<JLabel>();
	int point = 0;

    public boolean moveUp(int a) throws LimitBackgroundException{
    	boolean b = false;
    	if((this.getY() - 28) > a) {
    		this.setY(this.getY() - 28);
    		b = true;
    	} else {
    		b = false;
    		throw new LimitBackgroundException();
    	}
    	return b;
    }
    
    public void moveUp(int a, int time, DesenhoMovel s, DesenhoMovel m) throws LimitBackgroundException{
    	if((this.getY() - 28) > a) {
    		this.setY(this.getY() - 28);
    		try {
				sleep(time);
			} catch (InterruptedException e) {
			}
    	} else {
    		m.setX(s.getX()+23);
    		m.setY(s.getY()-56);
    		throw new LimitBackgroundException();
    	}
    }
    
    public boolean moveDown(int a) throws LimitBackgroundException{
    	boolean b = false;
    	if((this.getY() + 28) < a) {
    		this.setY(this.getY() + 28);
    		b = true;
    	} else {
    		b = false;
    		throw new LimitBackgroundException();
    	}
    	return b;
    }
    
    public void moveDown(int a, int time, DesenhoMovel s) throws LimitBackgroundException{
    	if((this.getY() + 28) < a) {
    		this.setY(this.getY() + 28);
    		try {
				sleep(time);
			} catch (InterruptedException e) {
			}
    	} else {
    		s.setY(0);
    		s.setX(ThreadLocalRandom.current().nextInt(0, 418));
    		throw new LimitBackgroundException();
    		
    	}
    }
    
    public void moveRight() throws LimitBackgroundException{
    	if((this.getX() + 30) < 388) {
    		this.setX(this.getX() + 28);
    	} else {
    		throw new LimitBackgroundException();
    	}
    }

    public void moveLeft() throws LimitBackgroundException{
    	if((this.getX() ) > 0) {
    		this.setX(this.getX() - 28);
    	} else {
    		throw new LimitBackgroundException();
    	}
    }
    
//    public void dead() {
//		this.death++;
//		File deaths = new File("C:\\Users\\levig\\Desktop\\highscore.txt");
//		try {
//			FileInputStream fis = new FileInputStream(deaths);
//			FileOutputStream fos = new FileOutputStream(deaths);
//			fos.write(death);
//			System.out.println(fis.read());
//			fis.close();
//			fos.close();
//		} catch (FileNotFoundException e) {
//			System.out.println("Arquivo não encontrado.");
//		} catch (IOException e) {
//			System.out.println("Erro de IO.");
//		}
//	}
	public void addPoint(JLabel j) {
//		if (!(this.points.contains(j))) {
            this.points.add(j);
//        }
		File highscore = new File("C:\\Users\\levig\\Desktop\\highscore.txt");
		try {
			FileInputStream fis = new FileInputStream(highscore);
			FileOutputStream fos = new FileOutputStream(highscore);
			fos.write(getPoint());
			fos.close();
			System.out.println(fis.read());
			fis.close();
		} catch (IOException e) {
		}
	}
//	public int getDeaths() {
//		return this.point;
//	}
	public int getPoint() {
		return this.points.size();
	}
}
