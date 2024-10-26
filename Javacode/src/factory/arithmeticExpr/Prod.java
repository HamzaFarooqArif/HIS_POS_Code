package factory.arithmeticExpr;

/**
 * @author Joerg Schaefer FH-Frankfurt
 * 
 *         see http://www.cs.rice.edu/~cork/book/node63.html
 */
class Prod implements ArithmeticExpr {
	/* fields */
	ArithmeticExpr left, right;

	/* constructor */
	Prod(ArithmeticExpr l, ArithmeticExpr r) {
		left = l;
		right = r;
	}

	public Prod() {
	}

	public void setLeft(ArithmeticExpr left) {
		this.left = left;
	}

	public void setRight(ArithmeticExpr right) {
		this.right = right;
	}
	
	public Const eval() {
		return new Const(left.eval().getValue() * right.eval().getValue());
	}

	public int precedenceLevel() {
		return 2;
	}

	/* toString */
	public String toString() {
		// here we have recursive calls to toString,
		// as we would expect in an inductively-defined type
		return "[" + left + "*" + right + "]";
	}

}