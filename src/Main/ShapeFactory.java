package Main;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.*;

public class ShapeFactory extends JFrame {

	private static final int WD = 600; // Width Dimension
	private static final int HD = 600; // Height Dimension
	private static final int LOOPSIZE = 7; // List Size = 6
	private static JFrame frame; // Frame
	private static JPanel panel; // Panel
	private static Graphics graphic; // Graphics
	private static DisplayShapes shapes; // Display Shapes Instance
	private static BubbleSort bubble; // Bubble Sort Instance
	private static List<Shape> shapeList; // List of Shapes

	// Creating a List of 6, consisting of Random Shapes
	private void createNewList() {
		List<Shape> tempList = new ArrayList<Shape>();
		int pos;

		// Random 33.33% chance for each Shape
		for (pos = 1; pos < LOOPSIZE; pos++) {
			int tempValue = (int) (new Random().nextInt(3));
			if (tempValue == 0) {
				tempList.add(new Circle(pos));
			} else if (tempValue == 1) {
				tempList.add(new Rectangle(pos));
			} else {
				tempList.add(new Square(pos));
			}
		}

		this.shapeList = tempList;
	}

	// GET shape list
	private List<Shape> getShapeList() {
		return this.shapeList;
	}

	public ShapeFactory() {
		frame = new JFrame("Display shapes");
		panel = new JPanel();

		// frame
		frame.setSize(new Dimension(WD, HD)); // Initial Window Size
		frame.setLocationRelativeTo(null); // Location of JFrame
		frame.setResizable(false); // Window non-resizable
		frame.add(panel);

		// button
		JButton loadBtn = new JButton();
		JButton sortBtn = new JButton();
		loadBtn.setText("Load shapes");
		sortBtn.setText("Sort shapes");

		// Action Listeners
		loadBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// set Graphics to same as Panel Graphics
				graphic = panel.getGraphics();

				// Create new instance of DisplayShapes
				shapes = DisplayShapes.getInstance();
				// Generate new Random Shapes List
				createNewList();
				// Paint each shape in the list onto JPanel
				shapes.paintComponent(graphic, getShapeList(), WD, HD);
			}
		});

		sortBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// set Graphics to same as Panel Graphics
				graphic = panel.getGraphics();

				// Create new instance of DisplayShapes and BubbleSort
				shapes = DisplayShapes.getInstance();
				bubble = BubbleSort.getInstance();

				// Sort List
				bubble.Sort(getShapeList(), LOOPSIZE - 1);

				// Paint each shape in the list onto JPanel
				shapes.paintComponent(graphic, getShapeList(), WD, HD);
			}
		});

		// panel
		panel.setLayout(new FlowLayout());
		panel.add(loadBtn);
		panel.add(sortBtn);

		// stuff
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new ShapeFactory();
	}
}
