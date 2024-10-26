package composite;
/**
 * @author Joerg Schaefer FH-Frankfurt
 * 
 * see http://www.cs.rice.edu/~cork/book/node63.html
 */
public class Neg implements ArithmeticExpr {
	/* fields */
	private ArithmeticExpr value;

	/* constructor */
	Neg(ArithmeticExpr e) {
		value = e;
	}

	public ArithmeticExpr getValue() {
		return value;
	}

	/* toString */
	public String toString() {
		return "-" + value.toString();
	}
	
	public Const eval(Environment env) {
		return new Const(-1 * value.eval(env).getValue());
	}

}
