package Main;

import java.awt.*;
import java.util.Random;

abstract class Shape {
	private int x, y, w, h; // x and y axis, w = width, h = height
	protected double area;
	private Color color;
	private Random RED, GREEN, BLUE; // COLOR - RGB
	private Random temp = new Random(); // temporary Random for shape's width and height

	public Shape() {}

	// Abstract methods
	abstract public void drawShape(Graphics form); // Draw the shape on Panel

	abstract public void setArea(); // Set Area according to the shape

	// Getters
	public Color getColor() {
		return this.color;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public int getW() {
		return this.w;
	}

	public int getH() {
		return this.h;
	}

	public double getArea() {
		return this.area;
	}

	// Setters
	public void setColorToRandom() {
		RED = new Random();
		GREEN = new Random();
		BLUE = new Random();
		this.color = new Color(RED.nextInt(254) + 1, GREEN.nextInt(254) + 1, BLUE.nextInt(254) + 1);
	}

	public void setWtoRandom() {
		this.w = temp.nextInt(50)+25;
	}

	public void setHtoRandom() {
		this.h = temp.nextInt(50)+25;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void setH(int h) {
		this.h = h;
	}
	
//  Just for testing purpose
//	public void setW(int w) {
//		this.w = w;
//	}
//	
//	public void setColor(Color c) {
//		this.color = c;
//	}
}
