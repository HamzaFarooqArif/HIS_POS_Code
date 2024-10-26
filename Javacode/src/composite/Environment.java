package composite;
/**
 * @author Joerg Schaefer FH-Frankfurt
 * 
 * see http://www.cs.rice.edu/~cork/book/node63.html
 */
import java.util.HashMap;

public class Environment {

	private static HashMap<String, Const> globalEnv = new HashMap<String, Const>();

	public Const lookup(String name) {
		return globalEnv.get(name);
	}

	public void put(String name, Const value) {
		globalEnv.put(name, value);
	}

}
