package junit;

import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * @author Joerg Schaefer
 * FH-Frankfurt
 *
 */
public class MyTestCase extends ConditionalTestCase {

	public MyTestCase(String name) {
		super(name);
	}

	public MyTestCase() {
		super();
	}

	public void testMethod(){
		System.out.println("running testMethod");
	}
	
	public boolean shouldRun(){
		return true;
	}
	
	
	/**
	 * RUn as application to illustrate Compositor Pattern implemented by suite
	 * @param args
	 */
	public static void main(String[] args) {
		TestSuite suite1 = new TestSuite(MyTestCase.class);
		TestSuite suite2 = new TestSuite(MyTestCase.class);
		TestSuite suite3 = new TestSuite(MyTestCase.class);
		
		// Don't uncomment next line ;-)
		// suite1.addTest(suite1);
		
		suite1.addTest(suite2);
		suite2.addTest(suite3);
		
		Test test = new MyTestCase("testMethod");
		suite1.addTest(test);
		
		test = new MyTestCase("testMethod");
		suite2.addTest(test);
		
		test = new MyTestCase();
		//this fails Nullpointer Exception!
		//suite3.addTest(test);
		
		junit.textui.TestRunner.run(suite1);
    }

}
