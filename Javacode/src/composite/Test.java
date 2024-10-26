package composite;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testOne();
		testSecond();

	}

	private static void testOne() {
		ArithmeticExpr x = new Const(42);
		ArithmeticExpr y = new Const(4);
		ArithmeticExpr z = new Const(7);
		ArithmeticExpr prod = new Prod(y, z);
		ArithmeticExpr sum = new Sum(x, new Neg(prod));
		Environment env = new Environment();
		System.out.println(sum + "=" + sum.eval(env));
	}

	private static void testSecond() {
		ArithmeticExpr x = new Var("x");
		ArithmeticExpr y = new Const(4);
		ArithmeticExpr z = new Const(7);
		ArithmeticExpr prod = new Prod(y, z);
		ArithmeticExpr sum = new Sum(x, new Neg(prod));
		Environment env = new Environment();
		env.put("x", new Const(-34));
		System.out.println(sum + "=" + sum.eval(env));
	}
}
