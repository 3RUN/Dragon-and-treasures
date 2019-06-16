package by.htp.dragon.treasure.dao.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import by.htp.dragon.treasure.dao.DAOException;
import by.htp.dragon.treasure.dao.TreasureDAO;
import by.htp.dragon.treasure.entity.Treasure;

/**
 * Implementation of DAO layer with method <b>read</b>.
 * 
 * @author Magomet Kochkarov
 * @version 2.0
 */
public class FileTreasureDAO implements TreasureDAO {

	// file name we load all treasures from
	private static final String fileName = "./resources/treasure.txt";

	/**
	 * Method for reading info about all Dragon treasures from file/db.
	 * 
	 * @return Returns list of all treasures from the file/db.
	 * @throws DAOException to Service layer
	 */
	@Override
	public List<Treasure> read() throws DAOException {

		FileReader reader = null;
		BufferedReader bufferedReader = null;
		List<Treasure> treasure = new ArrayList<Treasure>();

		try {

			String line = null;
			reader = new FileReader(fileName);
			bufferedReader = new BufferedReader(reader);

			// read file line by line
			// and save results into the tempStr list
			while ((line = bufferedReader.readLine()) != null) {

				// get line with treasure, it's ID and price
				String[] tempLine = line.split("\\s+");
				// split the string, to separate data
				String name = tempLine[0].replace("_", " ");
				int id = Integer.parseInt(tempLine[1].split("=")[1]);
				int price = Integer.parseInt(tempLine[2].split("=")[1]);
				// create treasure
				Treasure tempTreasure = new Treasure(name, id, price);
				// add it to the list
				treasure.add(tempTreasure);

			}

		} catch (IOException e) {
			throw new DAOException(e);
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					throw new DAOException(e);
				}
			}
		}

		return treasure;

	}

}
