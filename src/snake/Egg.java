package snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Egg {
	int row,col;
	Random r = new Random();
	
	public Egg(int i, int j)
	{
		row = i;
		col = j;
	}
	
	
	public void draw(Graphics g)
	{
		Color c = g.getColor();
		g.setColor(Color.GREEN);
		g.fillOval(col*15, row*15, 15, 15);
		g.setColor(c);
	}
	
	public Rectangle getRectangle()
	{
		return new Rectangle(col*15,row*15,15,15);
	}
	
	public void getNew()
	{
		row = r.nextInt(27)+2;
		col = r.nextInt(27)+2;
	}
	
	public int getrow()
	{
		return row;
	}
	public int getcol()
	{
		return col;
	}

}
