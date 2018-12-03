package ss.week4;

public class Exercises {
	public static int countNegativeNumbers(int[] arr) {
		int countNegative = 0;
		for (int number : arr) {
			if (number < 0) {
				countNegative++;
			}
		}
		return countNegative;
	}

	public static void reverseArray(int[] ints) {
		for (int i = 0; i < ints.length / 2; i++) {
			int j = ints.length - (i + 1);
			int x = ints[i];
			ints[i] = ints[j];
			ints[j] = x;
		}
	}

	class SimpleList {
		public class Element {
		}

		public class Node {
			public Node next;
			public Element element;
		}

		private Node first;

		private Node find(Element element) {
			Node p = first;
			if (p == null) {
				return null;
			}
			while (p.next != null && !p.next.element.equals(element)) {
				p = p.next;
			}
			if (p.next == null) {
				return null;
			} else {
				return p;
			}
		}

		public void remove(Element element) {
			Node p = find(element);
			if (p != null) {
				p.next = p.next.next;
			}
		}
	}
}
