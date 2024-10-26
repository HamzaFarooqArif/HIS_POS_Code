package strategy;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Seminar seminar = new Seminar();
		seminar.add(new Student(12334378, "Vlissides"));
		seminar.add(new Student(12643823, "Gamma"));
		seminar.add(new Student(85316371, "Johnson"));		
		seminar.add(new Student(12345678, "Alexander"));
		
		System.out.println(seminar.sort());
		
		
		Sorter sorter = new NameSorter();
		seminar.setSorter(sorter);
		System.out.println(seminar.sort());
		
		
		sorter = new NumberSorter();
		seminar.setSorter(sorter);
		System.out.println(seminar.sort());
		
		

	}

}
