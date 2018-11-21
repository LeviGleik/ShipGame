import static java.lang.Thread.sleep;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JLabel;
public class DesenhoMovel extends Desenho{
	public DesenhoMovel(String path, int x, int y) {
        super(path, x, y);
    }

  

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
}
