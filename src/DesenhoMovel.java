public class DesenhoMovel extends Desenho{
	public DesenhoMovel(String path, int x, int y) {
        super(path, x, y);
    }

  
    public void moveUp() throws LimitBackgroundException{
    	if((this.getY() - 20) > 10) {
    		this.setY(this.getY() - 20);
    	}
    }
    
    public boolean moveDown(int a) throws LimitBackgroundException{
    	boolean b = false;
    	if((this.getY() + 20) < a) {
    		this.setY(this.getY() + 20);
    		b = true;
    	} else {
    		b = false;
    	}
    	return b;
    }
    
//    public void moveShipDown() throws LimitBackgroundException{
//    	if((this.getY() + 20) < 558) {
//    		this.setY(this.getY() + 20);
//    	}
//    }
//    
    public void moveRight() throws LimitBackgroundException{
    	if((this.getX() + 20) < 388) {
    		this.setX(this.getX() + 20);
    	}
    }

    public void moveLeft() throws LimitBackgroundException{
    	if((this.getX() - 20) > 0) {
    		this.setX(this.getX() - 20);
    	}
    }
}
