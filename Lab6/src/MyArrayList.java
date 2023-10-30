import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MyArrayList<E> {
	public static final int DEFAULT_CAPACITY = 10;
	private E[] elements;
	private int size;

	public MyArrayList() {
		this.elements = (E[]) new Object[DEFAULT_CAPACITY];
	}

	public MyArrayList(int capacity) {
		this.elements = (E[]) new Object[capacity];
	}

	// creates an array of double-size if the array of
	// elements is full
	public void growSize() {
		if (size == elements.length) {
			E[] temp = elements.clone();
			elements = (E[]) new Object[elements.length * 2];
			for (int i = 0; i < temp.length; i++) {
				elements[i] = temp[i];
			}
		}
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		if (size == 0) {
			System.out.println("true");
			return true;
		} else {
			System.out.println("false");
			return false;
		}
	}

	public E get(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i > size) {
			throw new IndexOutOfBoundsException("Index Out of Bounds");
		} else {
			return elements[i];
		}
	}

	public E set(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i > size) {
			throw new IndexOutOfBoundsException("Index Out of Bounds");
		} else {
			elements[i] = e;
			return elements[i];
		}
	}

	public boolean add(E e) {
		if (size == elements.length) {
			growSize();
		}
		elements[size++] = e;
		return false;
	}

	public boolean add(int i, E e) throws IndexOutOfBoundsException {
		if (i < 0 || i > size) {
			throw new IndexOutOfBoundsException("Index Out of Bounds");
		} else {
			if (size == elements.length) {
				growSize();
			}
			size++;
			for (int j = size; j >= 0; j--) {
				if (j == i) {
					elements[j] = e;
					break;
				} else {
					elements[j] = elements[j - 1];
				}
			}
		}
		return true;
	}

	public boolean remove(int i) throws IndexOutOfBoundsException {
		if (i < 0 || i > size) {
			throw new IndexOutOfBoundsException("Index Out of Bounds");
		} else {
			for (int j = i; j < size; j++) {
				if (j == size - 1) {
					size--;
				} else {
					elements[j] = elements[j + 1];
				}
			}
		}
		return true;
	}

	public void clear() {
		size = 0;
	}

	public int lastIndexOf(Object o) {
		int index = 0;
		boolean isContain = false;
		for (int i = 0; i < size; i++) {
			if (elements[i] == o) {
				index = i;
				isContain = true;
			}
		}
		if (isContain == true) {
			System.out.println(index);
			return index;
		} else {
			System.out.println(-1);
			return -1;
		}
	}

	public E[] toArray() {
		return elements;
	}

	public MyArrayList<E> clone() {
		MyArrayList<E> cloneArray = new MyArrayList<E>();
		cloneArray.size = size;
		cloneArray.elements = elements;
		return cloneArray;
	}

	public boolean contains(E o) {
		for (int i = 0; i < size; i++) {
			if (elements[i] == o) {
				return true;
			}
		}
		return false;
	}

	public int indexOf(E o) {
		for (int i = 0; i < size; i++) {
			if (elements[i] == o) {
				System.out.println(i);
				return i;
			}
		}
		System.out.println(-1);
		return -1;
	}

	public boolean remove(E e) {
		remove(indexOf(e));
		return false;
	}

	public void sort(Comparator<E> c) {
		for (int z = 0; z < size; z++) {
			for (int i = 1; i < size; i++) {
				if (c.compare(elements[i - 1], elements[i]) > 0) {
					E tmp = elements[i - 1];
					elements[i - 1] = elements[i];
					elements[i] = tmp;
				}
			}
		}
	}

	// dùng Arrays.sort() được viết sẵn
	public void sort2(Comparator<E> c) {
		Arrays.sort(elements, 0, size, c);
	}

	public void print() {
		if (size != 0) {
			for (int i = 0; i < size; i++) {
				System.out.print(elements[i] + " , ");
			}
		} else {
			System.out.println("An array is EMPTY");
		}
	}

	public static void main(String[] args) {
		MyArrayList<Integer> m1 = new MyArrayList<Integer>();
		// Vì m1 là Integer , khá giống với kiểu nguyên thuỷ int nên phải tạo biến
		// Integer riêng để Test method remove(E e)
		Integer a = 11;
		m1.add(32);
		m1.add(23);
		m1.add(7);
		m1.add(11);
		m1.add(9);
		m1.add(23);
		m1.add(0, 10);
		m1.print();
	}
}
