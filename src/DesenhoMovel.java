import static java.lang.Thread.sleep;

import java.util.ArrayList;

import javax.swing.JLabel;
public class DesenhoMovel extends Desenho{
	public DesenhoMovel(String path, int x, int y) {
        super(path, x, y);
    }

  
    public void moveUp() throws LimitBackgroundException{
    	if((this.getY() - 28) > 10) {
    		this.setY(this.getY() - 28);
    	} else {
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
    
    public boolean moveDown(int a, int time) throws LimitBackgroundException{
    	boolean b = false;
    	if((this.getY() + 28) < a) {
    		this.setY(this.getY() + 28);
    		try {
				sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    		b = true;
    	} else {
    		b = false;
    		throw new LimitBackgroundException();
    		
    	}
    	return b;
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
