package composite;
/**
 * @author Joerg Schaefer FH-Frankfurt
 * 
 * see http://www.cs.rice.edu/~cork/book/node63.html
 */
class Var implements ArithmeticExpr {
	/* fields */
	String name;

	/* constructor */
	Var(String n) {
		name = n;
	}

	/* toString */
	public String toString() {
		return name;
	}

	public Const eval(Environment env) {
		return env.lookup(name);
	}

}