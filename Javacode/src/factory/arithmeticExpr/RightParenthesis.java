package factory.arithmeticExpr;

public class RightParenthesis implements ArithmeticExpr {

	ArithmeticExpr left = null;
	ArithmeticExpr right = null;

	public Const eval() {
		// must never get evaluated
		throw new IllegalArgumentException(") should not be evaluated");
	}

	public int precedenceLevel() {
		return 0;
	}

	public void setLeft(ArithmeticExpr left) {
		throw new UnsupportedOperationException(
				"RightParenthesis are just markers and do not support this");
	}

	public void setRight(ArithmeticExpr right) {
		throw new UnsupportedOperationException(
				"RightParenthesis are just markers and do not support this");
	}
	
	public String toString(){
		return ")";
	}
}
