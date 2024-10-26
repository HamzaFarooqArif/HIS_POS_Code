package strategy;

import java.util.ArrayList;
import java.util.List;

public class Seminar {
	
	private Sorter sorter;
	private ArrayList<Student> students;
	
	public Seminar() {
		this(new NullSorter());
	}
	
	public Seminar(Sorter sorter) {
		this(sorter, new ArrayList<Student>());
	}

	public Seminar(Sorter sorter, ArrayList<Student> students) {
		super();
		this.sorter = sorter;
		this.students = students;
	}
	
	public void setSorter(Sorter sorter) {
		this.sorter = sorter;
	}

	public List<Student> sort() {

		return sorter.sort(students);
	}


	public void add(Student student) {
		this.students.add(student);		
	}

}
