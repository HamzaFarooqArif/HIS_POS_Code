package strategy.swed;
import java.util.List;

public interface Strategy {
	/* selects an element from a list */
	Integer algorithm(List<Integer> list);
}
