package by.htp.dragon.treasure.service.impl;

import java.util.ArrayList;
import java.util.List;

import by.htp.dragon.treasure.dao.DAOException;
import by.htp.dragon.treasure.dao.DAOProvider;
import by.htp.dragon.treasure.dao.TreasureDAO;
import by.htp.dragon.treasure.entity.Treasure;
import by.htp.dragon.treasure.service.LogicException;
import by.htp.dragon.treasure.service.TreasureService;

/**
 * Service implementation (MVC) with methods <b>takeAll</b>, <b>findToLimit</b>,
 * <b>findMostExpensive</b>.
 * 
 * @author Magomet Kochkarov
 * @version 2.0
 */
public class TreasureServiceImpl implements TreasureService {

	/**
	 * Method for viewing all {@link Treasure} entities.
	 * 
	 * @return Return all treasures as a list.
	 * @throws LogicException to Controller layer
	 */
	@Override
	public List<Treasure> takeAll() throws LogicException {

		DAOProvider provider = DAOProvider.getInstance();
		TreasureDAO treasureDAO = provider.getTreasureDAO();
		List<Treasure> treasure = new ArrayList<Treasure>();
		try {
			// try to read all treasures from the file/db
			treasure = treasureDAO.read();
		} catch (DAOException e) {
			throw new LogicException(e);
		}
		return treasure;

	}

	/**
	 * Method for finding {@link Treasure} entities within the given price limit.
	 * 
	 * @param limit - Price limit.
	 * @return Returns information about all treasures as a single string containing
	 *         name, id and price.
	 * @throws LogicException to Controller layer
	 */
	@Override
	public List<Treasure> findToLimit(int limit) throws LogicException {

		int i = 0;
		int sum = 0;
		List<Treasure> treasure = new ArrayList<Treasure>();
		try {
			// try to load all treasures
			treasure = takeAll();
		} catch (LogicException e) {
			throw new LogicException(e);
		}

		List<Treasure> result = new ArrayList<Treasure>();

		for (i = 0; i < treasure.size(); i++) {
			Treasure tempTreasure = treasure.get(i);

			if (tempTreasure.getPrice() < limit && (sum + tempTreasure.getPrice() < limit)) {
				sum += tempTreasure.getPrice();
				result.add(tempTreasure);
			}

		}

		return result;

	}

	/**
	 * Method for finding a {@link Treasure} with the biggest price within all
	 * treasure entities.
	 * 
	 * @return Returns single {@link Treasure} entity.
	 * @throws LogicException to Controller layer
	 */
	@Override
	public List<Treasure> findMostExpensive() throws LogicException {
		int i = 0;
		int priceMax = 0;

		List<Treasure> treasure = new ArrayList<Treasure>();
		try {
			// try to load all treasures
			treasure = takeAll();
		} catch (LogicException e) {
			throw new LogicException(e);
		}

		List<Treasure> result = new ArrayList<Treasure>();
		Treasure precious = treasure.get(0);

		for (i = 0; i < treasure.size(); i++) {

			Treasure tempTreasure = treasure.get(i);
			int price = tempTreasure.getPrice();
			if (price > priceMax) {
				priceMax = price;
				precious = tempTreasure;
			}

		}

		result.add(precious);
		return result;

	}

}
