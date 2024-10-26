package mvc;

public class ConsoleView implements Observer {

	private int id;

	public ConsoleView(int id) {
		this.id = id;
	}

	public void update(String state) {
		System.out
				.println("ConsoleView: " + id + " My Model has changed to: " + state);

	}

}
