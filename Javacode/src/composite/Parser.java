package composite;

import java.util.StringTokenizer;

/**
 *  Simple recursive descent demo parser for arithmetic expressions. 
 *  
 *  The BNF grammar the parser recognizes looks as follows:
 *  <expression>  	::=  <term> [  "+" <term> ]...
 * 	<term>  		::=  <factor> [ "*"  <factor> ]...
 *	<factor>  		::=  <number>  |  "<expression>"
 *   
 *  Note, that the usual (mathematical) operator precedence is NOT implemented 
 *  and no support for parenthesis exists. Furthermore, numbers and operators such as 
 *  * and + have to be properly separated by whitespace, i.e. 3 +4 is illegal. 
 *  No error handling has been implemented. These features are left as an exercise to the reader.
 * 
 * 	Usage: 	java Parser "expression" where expression must be enclosed in parenthesis, e.g.
 * 			java Parser "3 + 4 * 5"
 * 
 * @author Joerg Schaefer
 * FH-Frankfurt
 *
 */
public class Parser {

	// the current Token we look at
	private static String curr = "";
	// the current Arithmetic Expression we assemble
	private static ArithmeticExpr currExpr = null;
	
	private static StringTokenizer st = null;

	public static void main(String[] args) {
		String exprStr = args[0];
		st = new StringTokenizer(exprStr, " ");
		// initialize
		next();
		ArithmeticExpr expr = parseExpr();
		System.out.println(expr);
		Environment env = new Environment();
		System.out.println(expr.eval(env));
	}

	private static void next() {
		curr = st.nextToken();
	}

	private static ArithmeticExpr parseOperator(ArithmeticExpr left) {
		ArithmeticExpr expr = null;
		if (curr.equals("+")) {
			next();
			ArithmeticExpr right = parseExpr();
			expr = new Sum(left, right);
		}
		if (curr.equals("*")) {
			next();
			ArithmeticExpr right = parseExpr();
			expr = new Prod(left, right);
		}
		return expr;
	}

	private static ArithmeticExpr parseNumber() {
		int i = Integer.parseInt(curr);
		return new Const(i);
	}

	private static ArithmeticExpr parseExpr() {
		// operator
		if (curr.equals("+") || curr.equals("*")) {
			currExpr = parseOperator(currExpr);
		}
		// digit
		else  {
			currExpr = parseNumber();
			if (st.hasMoreElements()) {
				next();
				parseExpr();
			}
		} 
		return currExpr;
	}

}
