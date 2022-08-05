package lab3;

import java.awt.Graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class Lab3  {

	public static final int IMAGE_WIDTH = 400;
	public static final int IMAGE_HEIGHT = 600;
	public static final int FONT_SIZE_SMALL = 30;
	public static final int FONT_SIZE_LARGE = 50;	
	
	public static final int LEFT_CLICK = 1;
	public static final int RIGHT_CLICK = 3;
	public static final int MIDDLE_MOUSE = 2;
	

	public static void main(String[] args) {
		//Set up graphical things
		BufferedImage bi = new BufferedImage(IMAGE_WIDTH, IMAGE_HEIGHT, BufferedImage.TYPE_INT_RGB);
		Graphics g = bi.getGraphics();
		Font smallFont = new Font("Arial", Font.BOLD, FONT_SIZE_SMALL);
		Font largeFont = new Font("Arial", Font.BOLD, FONT_SIZE_LARGE);
		 
		ArrayList<Letter> letter = new ArrayList<Letter>();
		
		
		char keyPressed = 'A';
		int index = 0;
		
		//Set up EasyWindow
		EasyWindow ew = new EasyWindow();
		while(!ew.getQuit()) {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, bi.getWidth(), bi.getHeight());
			
		//Get user input and make necessary changes
		//HINT: You can make for loops with char as such:
		//for(char c = 'A'; c <= 'Z'; c++)
		//WRITE CODE HERE 
			
			for(char c = 'A'; c <= 'Z'; c++) {
				if(ew.getKeyFirst(c)) {
					
					keyPressed = c;
					
					ew.setTitle(""+ keyPressed);
					
				}
			}
			if(ew.getMouseButtonFirst(LEFT_CLICK)) {
					
				Letter newletter = new Letter(ew.getMouseX(), ew.getMouseY(), ""+ keyPressed);
				letter.add(newletter);
				letter.get(index);
			}
			
			if(ew.getMouseButtonFirst(RIGHT_CLICK)) {
				Letter newletter = new Letter(ew.getMouseX(), ew.getMouseY(), ""+ keyPressed);
				letter.remove(newletter);
			}
			
			ew.getMouseWheel();
			
			
			//keeps track of the index
			for(index = 0; index < letter.size(); index++) {
				letter.get(index);
			}
			
					
					
			
			//Make a for loop to cycle over your ArrayList and call the draw method for each Letter.
			//If the Letter's index is the same as the selected index, increase the fontSize first.
			//You can set the font-size with:
			//g.setFont(smallFont);  or  g.setFont(largeFont);
			//WRITE CODE HERE
			for(Letter let : letter) {
				
				if(letter.indexOf(let) == index) 
					g.setFont(largeFont);
					
				else 
					g.setFont(smallFont);
				
				let.draw(g);	
			}
			
			//Updates the screen with the fresh image and checks for more user input.	
			ew.update(bi);		
		}
		//Get rid of the Graphics to save resources (similar to closing a File object you open).
		 g.dispose();
		 

	}
}


