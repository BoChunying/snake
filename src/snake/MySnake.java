package snake;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
//import java.util.Iterator;

public class MySnake {
	
	Node node  = new Node(20,20,direction.right);
//	Node node1  = new Node(20,19,direction.right);
//	Node node2  = new Node(20,18,direction.right);
	ArrayList<Node> body = new ArrayList<Node>();
	int index = 0;
	Node head,tail;
	MyWindow f;
	
	public MySnake(MyWindow f)
	{
		this.f = f;
		head = node;
		tail = node;
		body.add(node);
//		body.add(node1);
//		body.add(node2);
	}
	
	public void move()
	{
		headAdd();
		tailDelete();
	}
	
	public void checkDead()
	{
		if (head.col<=1 || head.col>=30 || head.row<=1 || head.row>= 30)
			f.isLive = false;
		
	}
	
	public void headAdd()
	{
		Node n =null;
		switch(head.dir)
		{
			case up :
				n = new Node(head.row-1,head.col,head.dir);
				break;
			case down:
				n = new Node(head.row+1,head.col,head.dir);
				break;
			case left:
				n = new Node(head.row,head.col-1,head.dir);
				break;
			case right:
				n = new Node(head.row,head.col+1,head.dir);
				break;
		}
		body.add(0, n);
		head = n;
//		System.out.println(body.get(0).col+" "+body.get(0).row+body.get(0).dir);
	}
	public void tailDelete()
	{
		body.remove(body.size()-1);
	}
	
	public void eat(Egg e)
	{
		if(head.col == e.getcol() && head.row == e.getrow())
		{
			e.getNew();
			this.headAdd();
//			System.out.println("11");
		}
	}
	
	public Rectangle getRec()
	{
		return (new Rectangle(head.col*f.sitesize,head.row*f.sitesize,f.sitesize,f.sitesize));
	}
	
	public void draw(Graphics g)
	{
		move();
		checkDead();
		for(index = 0; index < body.size(); index ++)
		{
			Node temp = body.get(index);
			temp.draw(g);
		}
	}
	
	class Node
	{
		int row,col;
		direction dir;
		
		public Node(int i,int j,direction dir)
		{
			row = i;
			col = j;
			this.dir = dir;
		}
		public void draw(Graphics g)
		{
			Color c =g.getColor();
			g.setColor(Color.BLACK);
			g.fillRect(f.sitesize * col, f.sitesize * row, f.sitesize,f.sitesize);
	        g.setColor(c);
		}
		
	}

}

enum direction{
	up,down,right,left;
}