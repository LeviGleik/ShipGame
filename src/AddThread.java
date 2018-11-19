public class AddThread extends Principal implements Runnable{
	public void run() {
		while(stones.size()<2) {
        	stones.add(new DesenhoMovel("stone1.png", localStone1, 0));	
            stones.add(new DesenhoMovel("stone2.png", localStone2, 0));
        	stones.add(new DesenhoMovel("stone3.png", localStone3, 0));	
        }
	}
}