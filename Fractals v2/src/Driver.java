import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Driver extends JPanel implements ActionListener {

	/* Attributes a.k.a. Instance Variables */
	int w = 800, h = 800;

	public void paint(Graphics g) {
		super.paintComponent(g);
		//rings(g, 200, 0, 0);
//		clover(g, 100, 0, 100);
//		clover2(g, 100, 0, 0);
//		clover3(g, 100, 100, 100);
//		clover4(g, 100, 100, 0);
		
//		squaresOne(g, 10, 1, 1);
//		squaresTwo(g, 20, 1, 19);
//		squaresThree(g, 70, 1, 63);
//		bigSquare(g, 240, 200, 210);

		snowflake(g, 400, 300, 60, 90, 108);
	
	}// end of paint method - put code above for anything dealing with drawing -

	public void clover(Graphics g, int radius, int x, int y) {
		g.drawOval(x, y, radius, radius);
		if(radius > 1) {
			clover(g, radius - 10, x + 10 , y );
			}
	}
	
	public void clover2(Graphics g, int radius, int x, int y) {
		g.drawOval(x, y, radius, radius);
		if(radius > 1) {
			clover2(g, radius - 10, x + 10, y + 10);
			}
	}
	
	public void clover3(Graphics g, int radius, int x, int y) {
		g.drawOval(x, y, radius, radius);
		if(radius > 1) {
			clover3(g, radius - 10, x , y );
			}
	}
	
	public void clover4(Graphics g, int radius, int x, int y) {
		g.drawOval(x, y, radius, radius);
		if(radius > 1) {
			clover4(g, radius - 10, x, y + 10);
			}
	}
	
//	public void globe(Graphics g, int radius, int x, int y) {
//		g.drawOval(x, y, radius, radius);
//		int count = 0;
//		while(count < 100) {
//			globe(g, radius, x + 10, y + 10);
//			count ++;
//		}
//	}
	

	public void rings(Graphics g, int radius, int x, int y) {
		// each method call draws one part of the fractal
		g.drawOval(x, y, radius, radius);
		
		//each call to the method would draw another ring
		// base case -- where you stop drawing 
		if(radius > 1) {
		rings(g, radius - 10, x + 10, y + 10);
		}
	}
	
	public void squaresOne (Graphics g, int radius, int x, int y) {

		int column = x;
		int row = y;
		
		
		Color c = new Color((int)(Math.random()*250), (int)(Math.random()*250), (int)(Math.random()*250));
		g.setColor(c);
		// x limit = 685

		g.fill3DRect(column * 25 - 10, row, radius, radius, false);
		if(column < 27) {
			
			squaresOne(g, radius, column+1, row);
		
		}else {
			if(column >= 27 && row < 580) {
				column = 1;
				squaresOne(g, radius, column, row + 23);
			}
		}
	}
	
	//   BIGGER SQUARES 
	public void squaresTwo (Graphics g, int radius, int x, int y) { 

		int column = x;
		int row = y;
		
		Color c = new Color((int)(Math.random()*250), (int)(Math.random()*250), (int)(Math.random()*250));
		g.setColor(c);
		// x limit = 685
		g.fill3DRect(column * 75 - 40, row, radius, radius, false);
		if(column < 9) {
			squaresTwo(g, radius, column + 1, row);
		}else {
			if(column >= 9 && row < 550) {
				column = 1;
				squaresTwo(g, radius, column, row + 69);
			}
		}
	}
	
 //   THREE 
	public void squaresThree (Graphics g, int radius, int x, int y) { 

		int column = x;
		int row = y;
		
		Color c = new Color((int)(Math.random()*250), (int)(Math.random()*250), (int)(Math.random()*250));
		g.setColor(c);
		// x limit = 685
		g.setColor(c);
		g.fill3DRect(column * 226 - 143, row, radius, radius, false);
		if(column < 3) {
			squaresThree(g, radius, column + 1, row);
			
		}else {
			if(column >= 3 && row < 400) {
				column = 1;
				squaresThree(g, radius, column, row + 207);
			}
		}
	}
	
	public void bigSquare(Graphics g, int x, int y, int width) {
		Color c = new Color((int)(Math.random()*250), (int)(Math.random()*250), (int)(Math.random()*250));
		g.setColor(c);
		g.fill3DRect(x, y, width, width, false);
	}
	
	public void snowflake(Graphics g, int x, int y, int one, int two, int three) {
		

		
		
		g.drawLine(x, y, x+one, y-two);
		g.drawLine(x, y, x+three, y);
		g.drawLine(x, y, x+one, y+two);
		g.drawLine(x, y, x-one, y+two);
		g.drawLine(x, y, x-three, y);
		g.drawLine(x, y, x-one, y-two);
		
		if(one > 1) {
			snowflake(g,x+one, y-two, one/3, two/3, three/3);
			snowflake(g, x+three, y, one/3, two/3, three/3);
			snowflake(g, x+one, y+two, one/3, two/3, three/3);
			snowflake(g, x-one, y+two, one/3, two/3, three/3);
			snowflake(g, x-three, y, one/3, two/3, three/3);
			snowflake(g, x-one, y-two, one/3, two/3, three/3);
			
			one /= 3;
			two /= 3;
			three /= 3;
		}
		
	}


	/**
	 * Update the positions of the ball and paddle. Update the scores, counter
	 * and time
	 */
	public void update() {

	}// end of update method - put code above for any updates on variable

	// ==================code above ===========================

	@Override
	public void actionPerformed(ActionEvent arg0) {
		update();
		repaint();
	}

	public static void main(String[] arg) {
		Driver d = new Driver();
	}

	/* Instantiate any attributes here (instance variables */
	public Driver() {

		JFrame f = new JFrame();
		f.setTitle("Pong");
		f.setSize(w, h);
		f.setBackground(Color.BLACK);
		f.setResizable(false);

		f.add(this);
		t = new Timer(17, this);
		t.start();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);

	}

	Timer t;

}
