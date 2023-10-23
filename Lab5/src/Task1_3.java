
public class Task1_3 {
	public static int[][] multiply(int[][] a, int[][] b) {
		if (a[0].length == b.length) {
			int[][] result = new int[a.length][b[0].length];
			int index = 0;
			// result matrix is 3x3
			// e matrix is 3x2
			// f matrix is 2x3
			for (int i = 0; i < result.length; i++) {
				if (index >= result[i].length) {
					index = 0;
				}
				while (index < result[i].length) {
					for (int j = 0; j < a[i].length; j++) {
						result[i][index] += a[i][j] * b[j][index];
					}
					index++;
				}
			}
			return result;
		} else

		{
			return null;
		}
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
		int[][] e = { { 2, 1 }, { -1, 3 }, { 1, 8 } };
		int[][] f = { { 2, 7, 3 }, { 1, 6, -4 } };
		printArr(multiply(e, f));
	}
}
