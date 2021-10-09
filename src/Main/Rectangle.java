package Main;

import java.awt.Graphics;

public class Rectangle extends Shape {
	
//  Just for testing purpose
//	public Rectangle(int x, int y, int w, int h, Color color) {
//		setX(x);
//		setY(y);
//		setW(w);
//		setH(h);
//		setColor(color);
//	}

	public Rectangle(int position) {
		super();
		// TODO Auto-generated constructor stub
		setColorToRandom();
		setX(position*75);
		setY(position*75);
		setWtoRandom();
		setHtoRandom();
		setArea();
	}

	@Override
	public void drawShape(Graphics fill) {
		// TODO Auto-generated method stub
		fill.setColor(this.getColor());
		fill.fillRect(this.getX(), this.getY(), this.getW(), this.getH());
	}

	@Override
	public void setArea() {
		// TODO Auto-generated method stub
		this.area = this.getW() * this.getH();
	}
	
//  Just for testing purpose
//	public static void main(String[] args) {
//		Shape test = new Rectangle(3);
//		System.out.println(test.getX());
//		System.out.println(test.getW());
//		System.out.println(test.getH());
//		System.out.println(test.getColor());
//		System.out.println(test.getArea());
//	}
}
