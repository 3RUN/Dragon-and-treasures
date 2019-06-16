package by.htp.dragon.treasure.command;

import java.util.HashMap;
import java.util.Map;

import by.htp.dragon.treasure.command.impl.FindPrecious;
import by.htp.dragon.treasure.command.impl.FindToLimit;
import by.htp.dragon.treasure.command.impl.ViewAllCommand;

/**
 * Command provider with field <b>commands</b> and methods
 * <b>CommandProvider</b>, <b>getCommand</b>.
 * 
 * @author Magomet Kochkarov
 * @version 2.0
 */
public class CommandProvider {

	/** Field commands. */
	private Map<String, Command> commands = new HashMap<String, Command>();

	/**
	 * Constructor - for creating new Command provider. It initializes all list of
	 * available commands into the HashMap.
	 */
	public CommandProvider() {
		commands.put("view", new ViewAllCommand());
		commands.put("precious", new FindPrecious());
		commands.put("value", new FindToLimit());
	}

	/**
	 * Method for returning a command from the HashMap field commands.
	 * 
	 * @param commandName - the name of the command to search for.
	 * @return Returns the command from the HashMap.
	 */
	public Command getCommand(String commandName) {
		Command command;
		command = commands.get(commandName);
		return command;
	}

}
