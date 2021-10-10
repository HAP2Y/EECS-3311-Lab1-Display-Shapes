package Main;

import java.awt.Graphics;

public class Circle extends Shape {

	// Constructor
	public Circle(int position) {
		super();
		// TODO Auto-generated constructor stub
		setColorToRandom();
		setX(position * 75);
		setY(position * 75);
		setWtoRandom();
		setH(getW());
		setArea();
	}

	// Fill the OVAL of random SIZE and desiered POSITION with random COLOR
	@Override
	public void drawShape(Graphics fill) {
		// TODO Auto-generated method stub
		fill.setColor(this.getColor());
		fill.fillOval(this.getX(), this.getY(), this.getW(), this.getH());
	}

	// area = PI * radius * radius
	// radius = width / 2 = heigth / 2
	@Override
	public void setArea() {
		// TODO Auto-generated method stub
		this.area = Math.PI * this.getW() * this.getW() / 4;
	}
}
