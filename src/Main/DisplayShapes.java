package Main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.List;

public class DisplayShapes {
	private static DisplayShapes shapes; // Single DisplayShapes
	private List<Shape> shapeDisplayList; 

	// Constructor
	private DisplayShapes() {
	}

	// Get Single DisplayShapes newly created if null
	// Create new Single DisplayShapes
	public static DisplayShapes getInstance() {
		if (shapes == null) {
			shapes = new DisplayShapes();
		}
		return shapes;
	}

	public void paintComponent(Graphics g, List<Shape> list, int WD, int HD) {
		Graphics2D g2d = (Graphics2D) g;
		
		// Clear the GUI before displaying new Shapes from List
		g.clearRect(50, 50, WD, HD);

		// Saving the list
		shapeDisplayList = list;

		// calling drawShape method for each shape in the list
		for (Shape shape : shapeDisplayList) {
			shape.drawShape(g2d);
		}
	}
}
