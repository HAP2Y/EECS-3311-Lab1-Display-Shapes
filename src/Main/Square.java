package Main;

import java.awt.Graphics;

public class Square extends Shape {
	
	public Square(int position) {
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
		fill.fillRect(this.getX(), this.getY(), this.getW(), this.getH());
	}

	@Override
	public void setArea() {
		// TODO Auto-generated method stub
		this.area = this.getW() * this.getW();
	}
	
//  Just for testing purpose
//	public static void main(String[] args) {
//		Shape test = new Square(3);
//		System.out.println(test.getX());
//		System.out.println(test.getW());
//		System.out.println(test.getH());
//		System.out.println(test.getColor());
//		System.out.println(test.getArea());
//	}
}
