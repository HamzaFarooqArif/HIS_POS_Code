package strategy;

public class Student {

	private int matriculationNumber;
	private String name;

	public Student(int matriculationNumber, String name) {
		super();
		this.matriculationNumber = matriculationNumber;
		this.name = name;
	}

	public String toString() {
		return "Name: " + name + ", Matriculation Number: "
				+ matriculationNumber;
	}

	public int getMatriculationNumber() {
		return matriculationNumber;
	}

	public String getName() {
		return name;
	}
}
