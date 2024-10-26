package strategy;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;


/**
 * @author Joerg Schaefer
 * FH-Frankfurt
 * 
 * Note: We are using a double (or nested) Strategy Pattern as Comparator is using Strategy, too
 * 
 * Exercises: 
 * 		Check the dependencies!
 * 		Why does NumberSorter refer to Student? 
 * 		Can we avoid that?
 * 		Why does NumberSorter not refer to Seminar?
 */
public class NameSorter implements Sorter {

	public List<Student> sort(List<Student> list) {

		Collections.sort(list, new NameComparator());
		return list;
	}

	public class NameComparator implements Comparator<Student> {

		public int compare(Student o1, Student o2) {
			return o1.getName().compareTo(o2.getName());
		}
	}

}
