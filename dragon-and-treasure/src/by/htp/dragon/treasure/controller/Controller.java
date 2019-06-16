package by.htp.dragon.treasure.controller;

import java.util.ArrayList;
import java.util.List;

import by.htp.dragon.treasure.command.Command;
import by.htp.dragon.treasure.command.CommandProvider;
import by.htp.dragon.treasure.entity.Treasure;

/**
 * Controller class with field <b>provider</b> and method <b>doAction</b>.
 * 
 * @author Magomet Kochkarov
 * @version 2.0
 */
public class Controller {

	/** Field provider. */
	private CommandProvider provider = new CommandProvider();

	/**
	 * Method <b>doAction</b>, get's input from View layer and sends it into
	 * <b>Command</b> layer.
	 * 
	 * @param request - name of the command to be performed.
	 * @return Returns list of treasures as a response.
	 */
	public List<Treasure> doAction(String request) {

		// split request String by spaces
		// this will help to split command from option/parameter
		// f.e. when we try to find treasures till the given price limit
		// command name will be = "value" and option/parameter will be a number
		// entered by the user, so request may look like "value 2000"
		String[] params = request.split("\\s+");

		List<Treasure> treasure = new ArrayList<Treasure>();

		// find HashMap with the given command and return it as a command
		Command command = provider.getCommand(params[0]);
		treasure = command.execute(params);

		return treasure;
	}

}
