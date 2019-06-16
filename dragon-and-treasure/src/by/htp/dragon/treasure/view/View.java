package by.htp.dragon.treasure.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import by.htp.dragon.treasure.controller.Controller;
import by.htp.dragon.treasure.entity.Treasure;

/**
 * View layer (MVC) with field <b>controller</b> and method
 * <b>setController</b>, <b>getInput</b>, <b>isNumeric</b>, <b>start</b>.
 * 
 * @author Magomet Kochkarov
 * @version 2.0
 */
public class View {

	// message and error strings
	// used to display info on console (for users)
	private static final String greetMessage = "Welcome to Dragon's Treasure!\nPlease enter [help] to view all commands.";
	private static final String quitMessage = "We are closing. Thank you. Bye bye.";
	private static final String noTreasureError = "No treasures were found within the given range!";
	private static final String inputError = "Wrong input! Please type [help]!";
	private static final String helpStr = "LIST OF ALL AVAILABLE COMMANDS" + "\nNOTE: you can ignore [ ] when typing!"
			+ "\n[view] - load treasures.txt;" + "\n[precious] - find most expensive treasure;"
			+ "\n[number] - find treasures within the given number (by price);" + "\n[exit] - to exit;"
			+ "\n[help] - view list of commands.";

	/** Field controller. */
	private Controller controller;

	/**
	 * Constructor - for creating new View object.
	 */
	public View() {
	}

	/**
	 * Method for setting {@link View#controller} field.
	 * 
	 * @param controller - controller to set {@link View#controller} field.
	 */
	public void setController(Controller controller) {
		this.controller = controller;
	}

	/**
	 * Method for getting input from user.
	 * 
	 * @return Returns input as a string.
	 */
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		return input;
	}

	/**
	 * Method for displaying list of given treasures on console.
	 * 
	 * @param treasure - List of treasures to display on console.
	 */
	public void toConsole(List<Treasure> treasure) {
		int i = 0;
		for (i = 0; i < treasure.size(); i++) {

			Treasure tempTreasure = treasure.get(i);
			System.out.println(tempTreasure.getName() + ", id:" + tempTreasure.getId() + ", price:"
					+ tempTreasure.getPrice() + ";");

		}
	}

	/**
	 * Method for checking if string is numeric or not.
	 * 
	 * @param str - String to check.
	 * @return <b>true</b> - if string is numeric, <b>false</b> otherwise
	 */
	public static boolean isNumeric(String str) {
		try {
			int num = Integer.parseInt(str);
		} catch (NumberFormatException | NullPointerException nfe) {
			return false;
		}
		return true;
	}

	/**
	 * Method for starting view layer and for user interaction.
	 */
	public void start() {

		// false if user decided to quit, otherwise - true
		boolean isRunning = true;

		String input = null;
		List<Treasure> treasure = new ArrayList<Treasure>();

		// greet user
		System.out.println(greetMessage);

		// while console is running
		while (isRunning) {

			input = getInput();

			if (input.equals("help") || input.equals("[help]")) {
				// display help
				System.out.println(helpStr);

			} else if (input.equals("view") || input.equals("[view]")) {
				toConsole(controller.doAction("view"));
			} else if (input.equals("precious") || input.equals("[precious]")) {
				toConsole(controller.doAction("precious"));
			} else if (isNumeric(input)) {
				// user entered numbers, then find something within them!
				treasure = controller.doAction("value " + input);
				// null or nothing ?
				if (treasure == null || treasure.size() <= 0) {
					// no treasures were found!
					System.out.println(noTreasureError);
				} else {
					// display results
					toConsole(treasure);
				}

			} else if (input.equals("exit") || input.equals("[exit]")) {
				System.out.println(quitMessage);
				isRunning = false;
			} else {
				// wrong input
				System.out.println(inputError);
			}

		}

	}

}
