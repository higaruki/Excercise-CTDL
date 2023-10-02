import java.util.Arrays;

public class Task1_2 {
	public static int getFibonacci(int n) {
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		return getFibonacci(n - 2) + getFibonacci(n - 1);
	}

	public static void printFibonacci(int n) {
		for (int i = 0; i < n; i++) {
			System.out.print(getFibonacci(i) + " ");
		}
	}

	public static void main(String[] args) {
		printFibonacci(6);
	}
}
