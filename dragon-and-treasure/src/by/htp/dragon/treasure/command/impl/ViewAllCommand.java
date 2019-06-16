package by.htp.dragon.treasure.command.impl;

import java.util.ArrayList;
import java.util.List;

import by.htp.dragon.treasure.command.Command;
import by.htp.dragon.treasure.entity.Treasure;
import by.htp.dragon.treasure.service.LogicException;
import by.htp.dragon.treasure.service.ServiceProvider;
import by.htp.dragon.treasure.service.TreasureService;

/**
 * viewAllCommand class that implements <b>Command</b> with method
 * <b>execute</b>. It reads all treasures from the file into a list and returns
 * it into View layer.
 * 
 * @author Magomet Kochkarov
 * @version 2.0
 */
public class ViewAllCommand implements Command {

	/**
	 * Method for reading all treasures from the file/db and returning them into
	 * view as a list of treasures.
	 * 
	 * @param params - Parameters, not used in this case.
	 * @return List of all treasures.
	 */
	@Override
	public List<Treasure> execute(String[] params) {

		ServiceProvider provider = ServiceProvider.getInstance();
		TreasureService treasureService = provider.getTreasureService();
		List<Treasure> treasure = new ArrayList<Treasure>();
		try {
			treasure = treasureService.takeAll();
		} catch (LogicException e) {
			// log
			System.err.println(e);
		}
		return treasure;

	}

}
