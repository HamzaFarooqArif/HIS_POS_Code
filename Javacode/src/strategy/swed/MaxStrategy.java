package strategy.swed;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaxStrategy implements Strategy {

	public Integer algorithm(List<Integer> list) {
		Comparator<Integer> comparator = new Comparator<Integer>() {
			public int compare(Integer o1, Integer o2) {
				return (o1.intValue() < o2.intValue()) ? 1 : 0;
			}

		};
		 Collections.sort(list, comparator);
		 return list.get(0);
	}

}
