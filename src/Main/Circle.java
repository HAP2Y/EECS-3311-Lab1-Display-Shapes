package Main;

import java.awt.Graphics;

public class Circle extends Shape {
	
	public Circle(int position) {
		super();
		// TODO Auto-generated constructor stub
		setColorToRandom();
		setX(position*75);
		setY(position*75);
		setWtoRandom();
		setH(getW());
		setArea();
	}
	
	@Override
	public void drawShape(Graphics fill) {
		// TODO Auto-generated method stub
		fill.setColor(this.getColor());
		fill.fillOval(this.getX(), this.getY(), this.getW(), this.getH());
	}

	@Override
	public void setArea() {
		// TODO Auto-generated method stub
		this.area = Math.PI * this.getW() * this.getW() / 4;
	}

//  Just for testing purpose
//	public static void main(String[] args) {
//		Shape test = new Circle(4);
//		System.out.println(test.getX());
//		System.out.println(test.getW());
//		System.out.println(test.getH());
//		System.out.println(test.getColor());
//		System.out.println(test.getArea());
//	}
}
