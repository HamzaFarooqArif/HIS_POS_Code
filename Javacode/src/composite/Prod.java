package composite;
/**
 * @author Joerg Schaefer FH-Frankfurt
 * 
 * see http://www.cs.rice.edu/~cork/book/node63.html
 */
class Prod implements ArithmeticExpr {
	/* fields */
	ArithmeticExpr left, right;

	/* constructor */
	Prod(ArithmeticExpr l, ArithmeticExpr r) {
		left = l;
		right = r;
	}

	/* getters */
	ArithmeticExpr getLeft() {
		return left;
	}

	ArithmeticExpr getRight() {
		return right;
	}

	/* toString */
	public String toString() {
		// here we have recursive calls to toString,
		// as we would expect in an inductively-defined type
		return "(" + left + "*" + right + ")";
	}

	public Const eval(Environment env) {
		return new Const(left.eval(env).getValue() * right.eval(env).getValue());
	}
}