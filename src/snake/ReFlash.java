package snake;

import java.awt.Frame;

public class ReFlash implements Runnable{

	MyWindow f;

	ReFlash(MyWindow f)
	{
		this.f = f;
	}
	@Override
	public void run() 
	{
		while(f.isLive)
		{
			if (f.pause) {
//				System.out.println("122221");
				continue;
				}
//			System.out.println("111111111");
			f.repaint();
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
