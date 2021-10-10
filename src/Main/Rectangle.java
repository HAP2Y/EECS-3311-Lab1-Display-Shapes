package Main;

import java.awt.Graphics;

public class Rectangle extends Shape {

	// Constructor
	public Rectangle(int position) {
		super();
		// TODO Auto-generated constructor stub
		setColorToRandom();
		setX(position * 75);
		setY(position * 75);
		setWtoRandom();
		setHtoRandom();
		setArea();
	}

	// Fill the RECT of random SIZE and desiered POSITION with random COLOR
	@Override
	public void drawShape(Graphics fill) {
		// TODO Auto-generated method stub
		fill.setColor(this.getColor());
		fill.fillRect(this.getX(), this.getY(), this.getW(), this.getH());
	}

	// area = width * height
	@Override
	public void setArea() {
		// TODO Auto-generated method stub
		this.area = this.getW() * this.getH();
	}
}
