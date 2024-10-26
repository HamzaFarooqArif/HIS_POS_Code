package mvc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {

	private Model model;
	private ConsoleView view;

	public Controller(Model model, ConsoleView view) {
		this.model = model;
		this.view = view;
		model.register(view);
	}

	public void setState(String state) {
		System.out.println("Controller setting state to: " + state);
		model.setState(state);
	}

	public void start() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			String s = "";
			while (!s.equals("quit")) {
				s = in.readLine();
				//System.out.println(s);
				model.setState(s);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
