package by.htp.dragon.treasure.service;

import java.util.List;

import by.htp.dragon.treasure.dao.DAOException;
import by.htp.dragon.treasure.entity.Treasure;

/**
 * Service interface (MVC) with methods <b>takeAll</b>, <b>findToLimit</b>,
 * <b>findMostExpensive</b>.
 * 
 * @author Magomet Kochkarov
 * @version 2.0
 */
public interface TreasureService {

	/**
	 * Method for viewing all {@link Treasure} entities.
	 * 
	 * @return Return all treasures as a list.
	 * @throws LogicException to Controller layer
	 */
	public List<Treasure> takeAll() throws LogicException;

	/**
	 * Method for finding {@link Treasure} entities within the given price limit.
	 * 
	 * @param limit - Price limit.
	 * @return Returns information about all treasures as a single string containing
	 *         name, id and price.
	 * @throws LogicException to Controller layer
	 */
	public List<Treasure> findToLimit(int limit) throws LogicException;

	/**
	 * Method for finding a {@link Treasure} with the biggest price within all
	 * treasure entities.
	 * 
	 * @return Returns single {@link Treasure} entity.
	 * @throws LogicException to Controller layer
	 */
	public List<Treasure> findMostExpensive() throws LogicException;

}
