public class DesenhoMovel extends Desenho{
	public DesenhoMovel(String path, int x, int y) {
        super(path, x, y);
    }

  
    public void moveUp(){
    	this.setY(this.getY() - 20);
    }
    
    public void moveDown(){
    	this.setY(this.getY() + 20);
    }
    
    public void moveRight(){
    	this.setX(this.getX() + 20);
    }

    public void moveLeft(){
    	this.setX(this.getX() - 20);
    }
}
