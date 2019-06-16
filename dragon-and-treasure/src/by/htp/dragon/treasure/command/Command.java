package by.htp.dragon.treasure.command;

import java.util.List;

import by.htp.dragon.treasure.entity.Treasure;

/**
 * Command interface with method <b>execute</b>.
 * 
 * @author Magomet Kochkarov
 * @version 2.0
 */
public interface Command {

	/**
	 * Method for executing a command with the given parameters.
	 * 
	 * @param params - Massive of Strings with the command + parameters/options.
	 * @return Returns String with a response.
	 */
	List<Treasure> execute(String[] params);

}
