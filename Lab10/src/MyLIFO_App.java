import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.concurrent.DelayQueue;

public class MyLIFO_App {
	// This method reserves the given array
	public static <E> void reserve(E[] array) {
		Stack<E> s1 = new Stack<E>();
		for (int i = 0; i < array.length; i++) {
			s1.push(array[i]);
		}
		for (int i = 0; i < array.length; i++) {
			array[i] = s1.pop();
		}
		System.out.println(Arrays.toString(array));
	}

	// This method checks the correctness of the
	// given input
	// i.e. ()(())[]{(())} ==> true, ){[]}() ==>
	// false
	public static boolean isCorrect(String input) {
		char[] c = input.toCharArray();
		Stack<Character> s1 = new Stack<Character>();
		for (int i = 0; i < c.length; i++) {
			if (c[i] == '{' || c[i] == '[' || c[i] == '(') {
				s1.push(c[i]);
			}
			if (c[i] == '}' || c[i] == ']' || c[i] == ')') {
				if (s1.isEmpty()) {
					return false;
				}
				if (c[i] - s1.pop() > 2) {
					return false;
				}
			}
		}
		if (!s1.isEmpty()) {
			return false;
		}
		return true;
	}

	// This method evaluates the value of an
	// expression
	// i.e. 51 + (54 *(3+2)) = 321
	public static int evaluateExpression(String expression) {
		Stack<Integer> operandStack = new Stack<>();
		Stack<Character> operatorStack = new Stack<>();

		for (int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);

			if (Character.isDigit(c)) {
				int operand = 0;
				while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
					operand = operand * 10 + Character.getNumericValue(expression.charAt(i));
					i++;
				}
				i--; // Adjust the index after extracting the entire number
				operandStack.push(operand);
			} else if (c == '(') {
				operatorStack.push(c);
			} else if (c == ')') {
				while (!operatorStack.isEmpty() && operatorStack.peek() != '(') {
					processOperator(operandStack, operatorStack);
				}
				operatorStack.pop(); // Pop '('
			} else if (isOperator(c)) {
				while (!operatorStack.isEmpty() && precedence(operatorStack.peek()) >= precedence(c)) {
					processOperator(operandStack, operatorStack);
				}
				operatorStack.push(c);
			}
		}

		while (!operatorStack.isEmpty()) {
			processOperator(operandStack, operatorStack);
		}

		return operandStack.pop();
	}

	private static void processOperator(Stack<Integer> operandStack, Stack<Character> operatorStack) {
		char operator = operatorStack.pop();
		int operand2 = operandStack.pop();
		int operand1 = operandStack.pop();
		switch (operator) {
		case '+':
			operandStack.push(operand1 + operand2);
			break;
		case '-':
			operandStack.push(operand1 - operand2);
			break;
		case '*':
			operandStack.push(operand1 * operand2);
			break;
		case '/':
			operandStack.push(operand1 / operand2);
			break;
		}
	}

	private static boolean isOperator(char ch) {
		return ch == '+' || ch == '-' || ch == '*' || ch == '/';
	}

	private static int precedence(char op) {
		switch (op) {
		case '+':
		case '-':
			return 1;
		case '*':
		case '/':
			return 2;
		default:
			return 0;
		}
	}

	public static String insertBlank(String expression) {
		StringBuilder sb = new StringBuilder();

		for (char c : expression.toCharArray()) {
			if (Character.isDigit(c)) {
				sb.append(c);
			} else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')' || c == '{' || c == '}'
					|| c == '[' || c == ']') {
				sb.append(" ").append(c).append(" ");
			}
		}
		return sb.toString().trim();
	}

	public static void main(String[] args) {
		Integer[] arr = { 1, 2, 3, 4 };
		String expression1 = "23+1+2";
		String expression2 = "51 + (54 *(3+2))";
		Queue<Integer> q1 = new LinkedList<Integer>();
		System.out.println("reverse : ");
		reserve(arr);
		System.out.println("------------------------------");
		System.out.println("isCorrect : ");
		System.out.println(isCorrect("()(())[]{(())}"));
		System.out.println(isCorrect("){[]}()"));
		System.out.println(isCorrect("{[("));
		System.out.println(isCorrect("}])"));
		System.out.println(isCorrect("{[}]"));
		System.out.println("------------------------------");
		System.out.println("evaluateExpression : ");
		System.out.println(evaluateExpression(expression1));
		System.out.println(evaluateExpression(expression2));
	}
}
