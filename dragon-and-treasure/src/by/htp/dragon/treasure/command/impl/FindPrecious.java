package by.htp.dragon.treasure.command.impl;

import java.util.ArrayList;
import java.util.List;

import by.htp.dragon.treasure.command.Command;
import by.htp.dragon.treasure.entity.Treasure;
import by.htp.dragon.treasure.service.LogicException;
import by.htp.dragon.treasure.service.ServiceProvider;
import by.htp.dragon.treasure.service.TreasureService;

/**
 * FindPrecious class that implements <b>Command</b> with method <b>execute</b>.
 * It reads all treasures from the file and returns the most expensive one.
 * 
 * @author Magomet Kochkarov
 * @version 2.0
 */
public class FindPrecious implements Command {

	/**
	 * Method for finding the most expensive treasure within the given list of
	 * treasures.
	 * 
	 * @param params - Parameters, not used in this case.
	 * @return Most expensive treasure found in file/db.
	 */
	@Override
	public List<Treasure> execute(String[] params) {

		ServiceProvider provider = ServiceProvider.getInstance();
		TreasureService treasureService = provider.getTreasureService();
		List<Treasure> treasure = new ArrayList<Treasure>();
		try {
			treasure = treasureService.findMostExpensive();
		} catch (LogicException e) {
			// log
			System.err.println(e);
		}
		return treasure;

	}

}
