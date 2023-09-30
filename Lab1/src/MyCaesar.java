
public class MyCaesar {
	public static final char[] ALPHABET = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O',
			'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
	private int n;// shift steps (right shift)

	public MyCaesar(int shiftSteps) {
		this.n = shiftSteps;
	}

	// Encrypt a character according to the given shif steps.
	// Encrypt: En(x) = (x + n) mod 26. x represents the index of c in the ALPHABET
	// array
	public char encryptChar(char c) {
		int x = 0;
		for (int i = 0; i < ALPHABET.length; i++) {
			if (c == ALPHABET[i]) {
				x = i;
			}
		}
		return ALPHABET[(x + n) % 26];
	}

	// Encrypt a text using the above function for encrypting a charater.
	public String encrypt(String input) {
		char[] arr = input.toCharArray();
		String result = "";
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == ' ') {
				result += ' ';
			} else {
				result += encryptChar(arr[i]);
			}
		}
		return result;
	}

	// Decrypt a character according to the given shif steps.
	// Decrypt: Dn(x) = (x – n) mod 26. x represents the index of c in the ALPHABET
	// array
	public char decryptChar(char c) {
		int x = 0;
		char result;
		for (int i = 0; i < ALPHABET.length; i++) {
			if (c == ALPHABET[i]) {
				x = i;
			}
		}
		if (x > n) {
			result = ALPHABET[(x - n) % 26];
		} else {
			result = ALPHABET[((26 + x) - n) % 26];
		}
		return result;
	}

	// Decrypt a encrypted text using the above function for decrypting a charater.
	public String decrypt(String input) {
		char[] arr = input.toCharArray();
		String result = "";
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == ' ') {
				result += ' ';
			} else {
				result += decryptChar(arr[i]);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String input = "AAA ZZZ";
		String input2 = "ABCDED";
		MyCaesar e1 = new MyCaesar(5);
		System.out.println(e1.encrypt(input));
		System.out.println(e1.decrypt(e1.encrypt(input)));
		System.out.println(e1.encrypt(input2));
		System.out.println(e1.decrypt(e1.encrypt(input2)));
	}
}
