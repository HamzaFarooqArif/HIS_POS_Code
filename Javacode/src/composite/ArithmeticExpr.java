package composite;

/**
 * @author Joerg Schaefer FH-Frankfurt
 * 
 * see http://www.cs.rice.edu/~cork/book/node63.html
 */

public interface ArithmeticExpr {
	 Const eval(Environment env);
}
