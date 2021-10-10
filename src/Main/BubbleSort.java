package Main;

import java.util.List;

public class BubbleSort {
	private static BubbleSort bubble; // Single DisplayShapes

	// Constructor
	public BubbleSort() {
	}

	// Get Single DisplayShapes newly created if null
	// Create new Single DisplayShapes
	public static BubbleSort getInstance() {
		if (bubble == null) {
			bubble = new BubbleSort();
		}
		return bubble;
	}

	public void Sort(List<Shape> list, int size) {
		// Size should not be 1 in the first place but if it is 1 then return as it is.
		if (size == 1) {
			return;
		}

		// Check if current is greater than next if yes SWITCH BOTH
		for (int i = 0; i < size - 1; i++) {
			if (list.get(i).getArea() > list.get(i + 1).getArea()) {
				Shape s = list.get(i);
				list.set(i, list.get(i + 1));
				list.get(i).setX((i + 1) * 75);
				list.get(i).setY((i + 1) * 75);
				list.set(i + 1, s);
				list.get(i + 1).setX((i + 2) * 75);
				list.get(i + 1).setY((i + 2) * 75);
			}
		}

		// Repeat the loop above till the Given List is SORTED
		Sort(list, size - 1);
	}
}
