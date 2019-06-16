package by.htp.dragon.treasure.dao;

/**
 * DAO Exception class which extends Exception class with 4 overloaded
 * constructors.
 * 
 * @author Magomet Kochkarov
 * @version 2.0
 */
public class DAOException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor - for creating new DAO exception.
	 */
	public DAOException() {
		super();
	}

	/**
	 * Constructor - for creating new DAO exception with String message.
	 * 
	 * @param message - exception message.
	 */
	public DAOException(String message) {
		super(message);
	}

	/**
	 * Constructor - for creating new DAO exception with Exception.
	 * 
	 * @param e - exception.
	 */
	public DAOException(Exception e) {
		super(e);
	}

	/**
	 * Constructor - for creating new DAO exception with String message and
	 * Exception.
	 * 
	 * @param message - exception message.
	 * @param e       - exception.
	 */
	public DAOException(String message, Exception e) {
		super(message, e);
	}

}
