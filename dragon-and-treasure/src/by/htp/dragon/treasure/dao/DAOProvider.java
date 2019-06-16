package by.htp.dragon.treasure.dao;

import by.htp.dragon.treasure.dao.impl.FileTreasureDAO;

/**
 * DAO layer provider (singleton) class (MVC) with fields <b>instance</b>,
 * <b>treasureDAO</b> and methods <b>getInstance</b>, <b>getTreasureDAO</b>.
 * 
 * @author Magomet Kochkarov
 * @version 2.0
 */
public class DAOProvider {

	/** Field instance. */
	private static final DAOProvider instance = new DAOProvider();

	/** Field treasureDAO. */
	private TreasureDAO treasureDAO = new FileTreasureDAO();

	/**
	 * Constructor - for creating new DAO singleton.
	 */
	private DAOProvider() {
	}

	/**
	 * Method for returning {@link DAOProvider#instance} field.
	 * 
	 * @return Returns this instance field.
	 */
	public static DAOProvider getInstance() {
		return instance;
	}

	/**
	 * Method for returning {@link DAOProvider#treasureDAO} field.
	 * 
	 * @return Returns this treasureDAO field.
	 */
	public TreasureDAO getTreasureDAO() {
		return treasureDAO;
	}
	
}
