package factory.arithmeticExpr;

import junit.framework.TestCase;

public class ParserTest extends TestCase {
	private ArithmeticExpressionParser parser;

	public void setUp() {
		parser = new ArithmeticExpressionParser();
	}

	public void test1() {
		assertEquals(4, parser.parse("1+3").eval().getValue());
	}

	public void test2() {
		assertEquals(22, parser.parse("1+3*7").eval().getValue());
	}

	public void test3() {
		assertEquals(15, parser.parse("1+2+3+4+5").eval().getValue());
	}

	public void test4() {
		assertEquals(6, parser.parse("1*2*3").eval().getValue());
	}

	public void test5() {
		assertEquals(88, parser.parse("5+4*6+7*8+3").eval().getValue());
	}

	public void test6() {
		assertEquals(5, parser.parse("(2+3)").eval().getValue());
	}

	public void test7() {
		assertEquals(20, parser.parse("4*(2+3)").eval().getValue());
	}

	public void test8() {
		assertEquals(22, parser.parse("(4+7)*2").eval().getValue());
	}

	public void test9() {
		assertEquals(55, parser.parse("(4+7)*(2+3)").eval().getValue());
	}

	public void test10() {
		assertEquals(672, parser.parse("(4+3)*(3*(4*(5+3)))").eval().getValue());
	}

	public void test11() {
		try {
			parser.parse("(4+3))").eval().getValue();
			fail("Should have thrown IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	public void test12() {
		try {
			parser.parse("((4+3)").eval().getValue();
			fail("Should have thrown IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}

	public void test13() {
		try {
			parser.parse("(4++3)").eval().getValue();
			fail("Should have thrown IllegalArgumentException");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}
}
