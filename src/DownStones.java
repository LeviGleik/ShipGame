import static java.lang.Thread.sleep;

import java.util.concurrent.ThreadLocalRandom;

public class DownStones extends Principal implements Runnable{
	public void run() {
		int downStone = 400;
		try {
			sleep(700);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		while (true) {
			try {
				sleep(190);
				try {
					if(stonesI ==  0) {
						downStone = 700;
					} else if(stonesI == 1){
						downStone = 700;
					} else if(stonesI == 2){
						downStone = 720;
					}
					
					if(stones.get(stonesI).moveDown(downStone)) {
						stones.get(stonesI).moveDown(downStone);
					}else {
//						remove(lStones.get(stonesI));
						stonesI = ThreadLocalRandom.current().nextInt(0, 3);
					}
					System.out.println(stones.size());
//					while(stones.size()<3) {
//			        	stones.add(new DesenhoMovel("stone1.png", localStone1, 0));	
//			            stones.add(new DesenhoMovel("stone2.png", localStone2, 0));
//			        	stones.add(new DesenhoMovel("stone3.png", localStone3, 0));	
//			        }
					lStones.get(stonesI).setBounds(stones.get(stonesI).getX(), stones.get(stonesI).getY(), lStones.get(stonesI).getWidth(), lStones.get(stonesI).getHeight());
					System.out.println(stonesI +" "+stonesI);
					
				} catch (LimitBackgroundException e) {
					e.printStackTrace();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	}
}
