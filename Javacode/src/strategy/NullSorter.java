package strategy;

import java.util.List;

/**
* @author Joerg Schaefer
* FH-Frankfurt
*
* Note: We are using the Null Object Pattern as we do nothing... 
*/
public class NullSorter  implements Sorter {

	public List<Student> sort(List<Student> list) {		
		return list;
	}

}
