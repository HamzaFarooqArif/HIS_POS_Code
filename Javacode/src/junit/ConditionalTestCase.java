package junit;

import junit.framework.TestCase;
import junit.framework.TestResult;

/**
 * @author Joerg Schaefer FH-Frankfurt
 * 
 *         following an idea from
 *         http://www.javaranch.com/journal/2004/01/Journal200401.jsp
 * 
 *         shouldRun should be implemented by subclasses (i.e. depending on
 *         context, return true or false)
 * 
 */
public class ConditionalTestCase extends TestCase {

	public ConditionalTestCase(String name) {
		super(name);
	}

	public ConditionalTestCase() {
		super();
	}

	public void run(TestResult result) {
		if (shouldRun())
			super.run(result);
		// TODO implement code to measure performance (before after idiom)
		//		implement code add failure if code (test) execution takes too long	
		// 		make above configurable
		// 		relate to Decorator Pattern (fwd reference)
		
		// conditionally add the code below	
		// result.addFailure(this, new AssertionFailedError("Takes too long"));
	}

	/**
	 * Sub classes should overwrite
	 * 
	 * @return true if test case should be run, false otherwise
	 */
	public boolean shouldRun() {
		return true;
	}
}
