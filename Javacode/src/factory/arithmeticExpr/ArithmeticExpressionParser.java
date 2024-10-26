package factory.arithmeticExpr;

import java.util.Stack;

/**
 * @author Joerg Schaefer FH-Frankfurt
 * 
 *         Simple Parser/Lexer for Arithmetic Expressions. Using the
 *         shunting-yard algorithm by Edsger Dijkstra.
 *         (http://en.literateprograms.org/Shunting_yard_algorithm_(C))
 */
public class ArithmeticExpressionParser {

	private Stack<ArithmeticExpr> exprStack = new Stack<ArithmeticExpr>();
	private Stack<ArithmeticExpr> operatorStack = new Stack<ArithmeticExpr>();
	private StringBuffer token = new StringBuffer();
	private int i = 0;
	
	public ArithmeticExpr parse(String input) {
		try {
			reset();
			/* remove any whitespace and then the do actual parse */
			doParse(input.replaceAll("\\s+", ""));
		} catch (Exception e) {
			reportParseError(input);
		}
		// return result
		ArithmeticExpr res = exprStack.pop();
		if (!exprStack.isEmpty())
			reportParseError(input);
		return res;
	}

	private void reportParseError(String input) {
		throw new IllegalArgumentException("Unable to parse expression "
				+ input + ", consumed: " + input.substring(0,i));
			
	}

	private void reset() {
		exprStack.clear();
		operatorStack.clear();
		token = new StringBuffer();
		i=0;
	}

	private void doParse(String input) {
		for (i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (isLeftParenthesis(c)) {
				operatorStack.push(new LeftParenthesis());
			} else if (isRightParenthesis(c)) {
				evaluateAndAddNumber();
				while (!operatorStack.isEmpty()
						&& !(operatorStack.peek() instanceof LeftParenthesis)) {
					composeAndAddOpToExpr();
				}
				exprStack.push(new RightParenthesis());
				composeAndAddOpToExpr();
			} else if (isVariable(c)) {
				evaluateAndAddVariable(c);
			} else if (isOperator(c)) {
				// operator, try to thus we can safely evaluate the number
				// accumulated in token (if any)
				evaluateAndAddNumber();
				ArithmeticExpr op = createOperator(c);
				// able to evaluate (compose) operators if any on stack
				if (!operatorStack.empty()) {
					// if precedence of op is lower than on the
					// operatorStack we
					// can evaluate (compose) the one on the operatorStack
					if (op.precedenceLevel() < operatorStack.peek()
							.precedenceLevel())
						composeAndAddOpToExpr();
				}
				// add for later evaluation/composition
				operatorStack.push(op);
			}
			// must be part of number
			else {
				// append characters to token for later evaluation
				token.append(c);
			}

		}
		// maybe still one last number to add
		evaluateAndAddNumber();

		// now evaluate remaining operator stack
		while (!operatorStack.empty()) {
			composeAndAddOpToExpr();
		}
	}

	private void evaluateAndAddVariable(char c) {
		ArithmeticExpr var = new Var(Character.toString(c));
		exprStack.push(var);
	}

	private boolean isVariable(char c) {
		// implementation works only for single character variables
		return Character.isLetter(c);
	}

	private void composeAndAddOpToExpr() {
		ArithmeticExpr op = operatorStack.pop();
		ArithmeticExpr x = exprStack.pop();
		ArithmeticExpr y = exprStack.pop();
		op.setLeft(y);
		op.setRight(x);
		exprStack.push(op);
	}

	private void evaluateAndAddNumber() {
		// if token is non empty we try to interpret as number
		if (!token.toString().equals("")) {
			Integer j = Integer.parseInt(token.toString());
			exprStack.push(new Const(j));
			// reset token
			token = new StringBuffer();
		}
	}

	private ArithmeticExpr createOperator(char c) {
		ArithmeticExpr op = null;
		if (c == '+')
			op = new Sum();
		if (c == '*')
			op = new Prod();
		return op;
	}

	private boolean isLeftParenthesis(char c) {
		return (c == '(');
	}

	private boolean isRightParenthesis(char c) {
		return (c == ')');
	}

	private boolean isOperator(char c) {
		return (c == '+' || c == '*') ? true : false;
	}

	public static void main(String[] args) {
		ArithmeticExpressionParser parser = new ArithmeticExpressionParser();
		ArithmeticExpr expr = parser.parse("42 + 4 * 7");
		System.out.println("Expression:" + expr + "=" + expr.eval());

		expr = parser.parse("(4 + 3)*(3*(3+4))");
		System.out.println("Expression:" + expr + "=" + expr.eval());

		Environment.env.put("x", new Const(32));
		expr = parser.parse("(x+3)*(3*(3+4))");
		System.out.println("Expression:" + expr + "=" + expr.eval());

	}
}
