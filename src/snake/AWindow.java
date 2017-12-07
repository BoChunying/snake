package snake;

import java.awt.*;
import java.awt.event.*;

public class AWindow {

	public static void main(String[] args) {
		MyWindow x = new MyWindow();
		x.launch();
	}

}

class MyWindow extends Frame
{
	int sitesize = 15;
	ReFlash reFlash;
	MySnake s = new MySnake(this);
	Egg e = new Egg(10,10);
	Boolean isLive = true;
	Boolean pause = false;
	
	public void launch()
	{
		
		this.setBounds(200,200,460,460);
		this.addWindowListener(new MyWindowMonitor());
		reFlash = new ReFlash(this);
		new Thread(reFlash).start();
		this.addKeyListener(new KeyMonitor(this));
		this.setVisible(true);
		
	}
	
	@Override
	public void paint(Graphics g)
	{
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, 30 * 15, 30*15);
		g.setColor(Color.BLACK);
//		for(int i=0;i<=30;i++)
//			g.drawLine(0, sitesize*i , 30*sitesize , sitesize*i);
//		for(int i=0; i<=30; i++)
//			g.drawLine(sitesize*i, 0, sitesize*i, sitesize*30);
		
		s.draw(g);
//		System.out.println(s.head.col+" "+s.head.row);
		s.eat(e);
//		System.out.println(e.col+" "+e.row);
		e.draw(g);
	}
	
	class MyWindowMonitor extends WindowAdapter
	{
		public void windowClosing(WindowEvent e)
		{
			System.exit(0);
		}
	}
}

class KeyMonitor extends KeyAdapter
{
	MyWindow f;
	
	public KeyMonitor(MyWindow f)
	{
		this.f = f;
	}
	
	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
		switch(key)
		{
			case KeyEvent.VK_LEFT:
				if(f.s.head.dir != direction.right)
					f.s.head.dir = direction.left;
				break;
			case KeyEvent.VK_RIGHT:
				if(f.s.head.dir != direction.left)
					f.s.head.dir = direction.right;
				break;
			case KeyEvent.VK_UP:
				if(f.s.head.dir != direction.down)
					f.s.head.dir = direction.up;
				break;
			case KeyEvent.VK_DOWN:
				if(f.s.head.dir != direction.up)
					f.s.head.dir = direction.down;
				break;
			case KeyEvent.VK_A:
				f.pause = true;
				break;
			case KeyEvent.VK_S:
				f.pause = false;
			break;
		}
	}
}
