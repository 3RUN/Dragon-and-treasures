package by.htp.dragon.treasure.service;

/**
 * Logic (Service) Exception class which extends Exception class with 4
 * overloaded constructors.
 * 
 * @author Magomet Kochkarov
 * @version 2.0
 */
public class LogicException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor - for creating new logic exception.
	 */
	public LogicException() {
		super();
	}

	/**
	 * Constructor - for creating new logic exception with String message.
	 * 
	 * @param message - exception message.
	 */
	public LogicException(String message) {
		super(message);
	}

	/**
	 * Constructor - for creating new logic exception with Exception.
	 * 
	 * @param e - exception.
	 */
	public LogicException(Exception e) {
		super(e);
	}

	/**
	 * Constructor - for creating new logic exception with String message and
	 * Exception.
	 * 
	 * @param message - exception message.
	 * @param e       - exception.
	 */
	public LogicException(String message, Exception e) {
		super(message, e);
	}

}
