package by.htp.dragon.treasure.service;

import by.htp.dragon.treasure.service.impl.TreasureServiceImpl;

/**
 * Service layer provider (singleton) class (MVC) with fields <b>instance</b>,
 * <b>treasureService</b> and methods <b>getInstance</b>,
 * <b>getTreasureService</b>.
 * 
 * @author Magomet Kochkarov
 * @version 2.0
 */
public class ServiceProvider {

	/** Field instance. */
	private static final ServiceProvider instance = new ServiceProvider();

	/** Field treasureService. */
	private TreasureService treasureService = new TreasureServiceImpl();

	/**
	 * Constructor - for creating new Service singleton.
	 */
	private ServiceProvider() {
	}

	/**
	 * Method for returning {@link ServiceProvider#instance} field.
	 * 
	 * @return Returns this instance field.
	 */
	public static ServiceProvider getInstance() {
		return instance;
	}

	/**
	 * Method for returning {@link ServiceProvider#treasureService} field.
	 * 
	 * @return Returns this treasureService field.
	 */
	public TreasureService getTreasureService() {
		return treasureService;
	}

}
