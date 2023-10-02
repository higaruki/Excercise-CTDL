
public class Task1_1 {
	public int getSn1(int n) {
		if (n == 0) {
			return 0;
		}
		int result = (int) ((Math.pow(-1, n + 1)) * n);
		return getSn1(n - 1) + result;
	}

	public int factorial(int n) {
		if (n == 0) {
			return 1;
		}
		return factorial(n - 1) * n;
	}

	public int getSn2(int n) {
		if (n == 0) {
			return 0;
		}
		return getSn2(n - 1) + factorial(n);
	}

	public int getSn3(int n) {
		if (n == 0) {
			return 0;
		}
		return getSn3(n - 1) + (int) Math.pow(n, 2);
	}

	public int evenFactorial(int n) {
		if (n == 0) {
			return 1;
		}
		return evenFactorial(n - 1) * (n * 2);
	}

	public double getSn4(int n) {
		if (n == 0) {
			return 1;
		}
		return getSn4(n - 1) + (double) 1 / evenFactorial(n);
	}

	public static void main(String[] args) {
		Task1_1 t1 = new Task1_1();
		System.out.println("Sn1 = " + t1.getSn1(5));
		System.out.println("Sn2 = " + t1.getSn2(3));
		System.out.println("Sn3 = " + t1.getSn3(5));
		System.out.println("Sn4 = " + t1.getSn4(3));

	}
}
