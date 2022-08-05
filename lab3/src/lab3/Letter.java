package lab3;

import java.awt.Color;
import java.awt.Graphics;


public class Letter {
	int x;
	int y;
	String text;
	Color c;
	
	public Letter(int x, int y, String text) {
		this.x = x;
		this.y = y;
		this.text = text;
		c = Color.getHSBColor((float)Math.random(), 1, 1);
		
	}
	
	public void draw(Graphics g) {
		g.setColor(c);
		g.drawString(text, x, y);
	}
}
