
public class Task1_2 {
	// khi 2 ma trận có cùng kích cỡ thì có thể thực hiện phép trừ
	public static int[][] add(int[][] a, int[][] b) {
		int[][] result = new int[a.length][a[0].length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				result[i][j] = a[i][j] - b[i][j];
			}
		}
		return result;
	}

	public static void printArr(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print("  " + arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] a = { { 7, 2 }, { 5, 3 } };
		int[][] b = { { 2, 1 }, { 3, 1 } };
		int[][] c = { { 5, 4, 3 }, { 2, 8, 6 } };
		int[][] d = { { 7, 8, -3 }, { 1, 6, -4 } };
		int[][] e = { { 2, 1, 6 }, { -1, 3, 4 }, { 1, 8, 2 } };
		int[][] f = { { 2, 7, 3 }, { 1, 6, -4 }, { 0, -8, 7 } };
		printArr(add(a, b));
		System.out.println("--------------------");
		printArr(add(c, d));
		System.out.println("--------------------");
		printArr(add(e, f));

	}
}
