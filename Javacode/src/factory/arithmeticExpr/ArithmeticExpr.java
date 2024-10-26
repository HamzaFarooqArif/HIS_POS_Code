package factory.arithmeticExpr;

/**
 * @author Joerg Schaefer FH-Frankfurt
 * 
 * see http://www.cs.rice.edu/~cork/book/node63.html
 */

public interface ArithmeticExpr {
	 Const eval();

	void setLeft(ArithmeticExpr left);

	void setRight(ArithmeticExpr right);
	
	int precedenceLevel();
}
