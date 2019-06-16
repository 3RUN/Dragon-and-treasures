package by.htp.dragon.treasure.command.impl;

import java.util.ArrayList;
import java.util.List;

import by.htp.dragon.treasure.command.Command;
import by.htp.dragon.treasure.entity.Treasure;
import by.htp.dragon.treasure.service.LogicException;
import by.htp.dragon.treasure.service.ServiceProvider;
import by.htp.dragon.treasure.service.TreasureService;

/**
 * FindToLimit class that implements <b>Command</b> with method <b>execute</b>.
 * It reads all treasures from the file and returns list of them till the given
 * price range.
 * 
 * @author Magomet Kochkarov
 * @version 2.0
 */
public class FindToLimit implements Command {

	/**
	 * Method for finding list of treasures within the given price range.
	 * 
	 * @param params - Parameters, in this case, used to pass price limit to
	 *               service.
	 * @return List of treasures withing the range, read from file/db.
	 */
	@Override
	public List<Treasure> execute(String[] params) {

		int limit = Integer.parseInt(params[1]);
		ServiceProvider provider = ServiceProvider.getInstance();
		TreasureService treasureService = provider.getTreasureService();
		List<Treasure> treasure = new ArrayList<Treasure>();
		try {
			treasure = treasureService.findToLimit(limit);
		} catch (LogicException e) {
			// log
			System.err.println(e);
		}
		return treasure;

	}

}
