package factory.arithmeticExpr;

public class LeftParenthesis implements ArithmeticExpr {

	ArithmeticExpr left = null;
	ArithmeticExpr right = null;

	public Const eval() {
		if (!(right instanceof RightParenthesis))
			throw new IllegalArgumentException();
		return left.eval();
	}

	public int precedenceLevel() {
		return 0;
	}

	// we abuse the semantics of left and right here, however consistent with
	// tree view...
	public void setLeft(ArithmeticExpr left) {
		this.left = left;
	}

	// we abuse the semantics of left and right here, however consistent with
	// tree view...
	public void setRight(ArithmeticExpr right) {
		this.right = right;
	}

	public String toString() {
		return "(" + left + right;
	}
}
