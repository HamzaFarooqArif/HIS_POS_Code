package factory.arithmeticExpr;

/**
 * @author Joerg Schaefer FH-Frankfurt
 * 
 *         see http://www.cs.rice.edu/~cork/book/node63.html
 */
class Sum implements ArithmeticExpr {
	/* fields */
	ArithmeticExpr left, right;

	/* constructor */
	Sum(ArithmeticExpr l, ArithmeticExpr r) {
		left = l;
		right = r;
	}

	public Sum() {
	}

	public void setLeft(ArithmeticExpr left) {
		this.left = left;
	}

	public void setRight(ArithmeticExpr right) {
		this.right = right;
	}

	public Const eval() {
		return new Const(left.eval().getValue() + right.eval().getValue());
	}

	public int precedenceLevel() {
		return 1;
	}

	/* toString */
	public String toString() {
		// here we have recursive calls to toString,
		// as we would expect in an inductively-defined type
		return "[" + left + "+" + right + "]";
	}

}