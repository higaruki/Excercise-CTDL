import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class MyFIFO_App {
	// method stutter that accepts a queue of integers as
	// a parameter
	// and replaces
	// every element of the queue with two copies of that
	// element

	// front [1, 2, 3] back
	// becomes
	// front [1, 1, 2, 2, 3, 3] back
	public static <E> void stutter(Queue<E> input) {
		int size = input.size();
		for (int i = 0; i < size; i++) {
			input.offer(input.peek());
			input.offer(input.poll());
		}
		System.out.println(input);
	}

	// Method mirror that accepts a queue of strings as a
	// parameter and
	// appends the
	// queue's contents to itself in reverse order
	// front [a, b, c] back
	// becomes
	// front [a, b, c, c, b, a] back
	public static <E> void mirror(Queue<E> input) {
		Stack<E> s1 = new Stack<E>();
		s1.addAll(input);
		int size = input.size();
		for (int i = 0; i < size; i++) {
			input.offer(s1.pop());
		}
		System.out.println(input);
	}

	public static void main(String[] args) {
		Queue<Integer> q1 = new LinkedList<Integer>();
		q1.offer(1);
		q1.offer(2);
		q1.offer(3);
		stutter(q1);
		Queue<Integer> q2 = new LinkedList<Integer>();
		q2.offer(1);
		q2.offer(2);
		q2.offer(3);
		mirror(q2);
	}
}
