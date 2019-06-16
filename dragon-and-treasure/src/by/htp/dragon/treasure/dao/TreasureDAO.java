package by.htp.dragon.treasure.dao;

import java.util.List;

import by.htp.dragon.treasure.entity.Treasure;

/**
 * DAO layer interface with method <b>read</b>.
 * 
 * @author Magomet Kochkarov
 * @version 2.0
 */
public interface TreasureDAO {

	/**
	 * Method for reading info about all Dragon treasures from file/db.
	 * 
	 * @return Returns list of all treasures from the file/db.
	 * @throws DAOException to Service layer
	 */
	public List<Treasure> read() throws DAOException;

}
