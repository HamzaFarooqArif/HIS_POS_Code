package strategy.swed;
import java.util.Arrays;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		Strategy strategy = new MaxStrategy();
		List<Integer> list = Arrays.asList(new Integer(2), new Integer(5),
				new Integer(23), new Integer(14), new Integer(12), new Integer(
						7), new Integer(6));
		System.out.println(strategy.algorithm(list));
		strategy = new MinStrategy();
		System.out.println(strategy.algorithm(list));
	}

}
