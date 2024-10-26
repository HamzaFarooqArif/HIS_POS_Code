package mvc;

public class TestMVC {

	public static void main(String[] args){
		Model model = new Model();
		
		Controller controllerOne = new Controller(model, new ConsoleView(1));
		Controller controllerTwo = new Controller(model, new ConsoleView(2));
		controllerOne.setState("3");
		controllerTwo.setState("42");
		
		controllerTwo.start();
		
		
	}
}
