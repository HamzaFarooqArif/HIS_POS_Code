package composite;

/**
 * @author Joerg Schaefer FH-Frankfurt
 * 
 * see http://www.cs.rice.edu/~cork/book/node63.html
 */
public class Const implements ArithmeticExpr {
	/* fields */
	private int value;

	/* constructor */
	public Const(int v) {
		value = v;
	}

	/* getters */
	public int getValue() {
		return value;
	}

	/* toString */
	public String toString() {
		return Integer.toString(value);
	}

	
	public Const eval(Environment env) {
		return this;
	}
}
