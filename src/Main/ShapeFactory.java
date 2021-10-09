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
	private static final int ListLoopSize = 7; // List Size = 6
	private static JFrame f; // Frame
	private static JPanel p; // Panel
	private static Graphics g; // Graphics
	private static DisplayShapes shapes; // Display Shapes Instance
	private static BubbleSort bubble; // Bubble Sort Instance
	private List<Shape> shapeList; // List of Shapes
	
	private void createNewList(){		
		List<Shape> tempList = new ArrayList <Shape>();
		int pos;
		
		for (pos = 1; pos < ListLoopSize; pos++) {
			int tempValue = (int) (new Random().nextInt(3));
			if(tempValue == 0) {
				tempList.add(new Circle(pos));
			}else if(tempValue == 1) {
				tempList.add(new Rectangle(pos));
			}else {
				tempList.add(new Square(pos));
			}
		}
		
		this.shapeList = tempList;
	}
	
	private List<Shape> getShapeList() {
		return this.shapeList;
	}
	
	private void setShapeList(List<Shape> list) {
		this.shapeList = list;
	}
	
	public void Sort(List<Shape> list, int size) {
		if(size == 1) {
			return;
		}
		
		for(int i = 0; i < size -1 ; i++) {
			if(list.get(i).getArea() > list.get(i+1).getArea()) {
				Shape s = list.get(i);
				list.set(i, list.get(i+1));
				list.get(i).setX((i+1)*75);
				list.get(i).setY((i+1)*75);
				list.set(i+1, s);
				list.get(i+1).setX((i+2)*75);
				list.get(i+1).setY((i+2)*75);
			}
		}
		
		Sort(list, size-1);
	}

	public ShapeFactory() {
		f = new JFrame("Display shapes");
		p = new JPanel();

		// frame
		f.setSize(new Dimension(WD, HD)); // Initial Window Size
		f.setLocationRelativeTo(null); // Location of JFrame
		f.setResizable(false); // Window non-resizable
		f.add(p);

		// button
		JButton loadBtn = new JButton();
		JButton sortBtn = new JButton();
		loadBtn.setText("Load shapes");
		sortBtn.setText("Sort shapes");
		
		// Action Listener
		loadBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// set Graphics to same as Panel Graphics
				g = p.getGraphics();
				
				// Create new instance of DisplayShapes
				shapes = DisplayShapes.getInstance();
				// Generate new Random Shapes List
				createNewList();
				// Paint each shape in the list onto JPanel
				shapes.paintComponent(g, getShapeList(), WD, HD);
			}
		});
		
		sortBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				// set Graphics to same as Panel Graphics
				g = p.getGraphics();
				System.out.println("Hello from sort BTN");
				
				// Create new instance of DisplayShapes and BubbleSort
				shapes = DisplayShapes.getInstance();
				bubble = BubbleSort.getInstance();
				
				// Sort List
				bubble.Sort(getShapeList(), 6);
				
				// Paint each shape in the list onto JPanel
				shapes.paintComponent(g, getShapeList(), WD, HD);
			}
		});

		// panel
		p.setLayout(new FlowLayout());
		p.add(loadBtn);
		p.add(sortBtn);

		// stuff

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	public static void main(String[] args) {
		new ShapeFactory();
	}
}
