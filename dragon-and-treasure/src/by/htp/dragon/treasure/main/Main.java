package by.htp.dragon.treasure.main;

import by.htp.dragon.treasure.controller.Controller;
import by.htp.dragon.treasure.view.View;

/**
 * Main class with method <b>main</b>.
 * 
 * @author Magomet Kochkarov
 * @version 2.0
 */
public class Main {

	/**
	 * Main function that starts our application.
	 * 
	 * @param args - String arguments for the main function.
	 */
	public static void main(String[] args) {

		// create new controller and set it for view layer
		Controller controller = new Controller();
		View view = new View();
		view.setController(controller);

		// start our view layer
		// it will handle all input from user
		view.start();

	}

}
