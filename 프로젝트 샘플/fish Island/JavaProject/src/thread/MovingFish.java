package thread;
import javax.swing.JLabel;

public class MovingFish extends Thread {
	int fishPower;
	JLabel lblFish;
	
	public MovingFish(int fishPower, JLabel lblFish) {
		this.fishPower = fishPower;
		this.lblFish = lblFish;
	}
	
	@Override
	public void run() {
		System.out.println("fish Thread");
		int x = lblFish.getX();
		int y = lblFish.getY();
		while(true) {
			// TODO Auto-generated method stub
			
			int flag = (int)(Math.random()*2);
			int moving = (int)(Math.random()*fishPower*7);
			try {
				if(flag==0)
				{
					Thread.sleep((int)(Math.random()*(320-fishPower*6))*5+50);
					if((y+moving)<=lblFish.getParent().getHeight()-20) {
						y=y+moving;
						lblFish.setLocation(x, y);
					}
				}
				else if(flag==1)
				{
					Thread.sleep((int)(Math.random()*(320-fishPower*6))*5+50);
					if((y-moving)>=20) {
						y=y-moving;
						lblFish.setLocation(x, y);
					}
				}
				if(moving>= 100)
					Thread.sleep(80);
				else if(moving>=80)
					Thread.sleep(70);
				
				
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		
	}
}
