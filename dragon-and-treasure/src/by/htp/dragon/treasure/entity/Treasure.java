package by.htp.dragon.treasure.entity;

/**
 * Treasure entity class with fields <b>name</b>, <b>id</b>, <b>price</b> and
 * <b>set</b>, <b>get</b> methods. It also contains overridden <b>hashCode</b>,
 * <b>equals</b> and <b>toString</b>.
 * 
 * @author Magomet Kochkarov
 * @version 2.0
 */
public class Treasure {

	/** Field name. */
	private String name;

	/** Field id. */
	private int id;

	/** Field price. */
	private int price;

	/**
	 * Constructor for creating new View object.
	 * 
	 * @see Treasure#Treasure(String, int, int)
	 */
	public Treasure() {
	}

	/**
	 * Overloaded constructor for creating new View object.
	 * 
	 * @param name  - {@link Treasure#name}.
	 * @param id    - {@link Treasure#id}.
	 * @param price - {@link Treasure#price}.
	 * 
	 */
	public Treasure(String name, int id, int price) {
		this.name = name;
		this.id = id;
		this.price = price;
	}

	/**
	 * Setting {@link Treasure#name}.
	 * 
	 * @param name - {@link Treasure#name}.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Setting {@link Treasure#id}.
	 * 
	 * @param id - {@link Treasure#id}.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Setting {@link Treasure#price}.
	 * 
	 * @param price - {@link Treasure#price}.
	 */
	public void setPrice(int price) {
		this.price = price;
	}

	/**
	 * Getting {@link Treasure#name}.
	 * 
	 * @return <b>String</b> containing {@link Treasure#name}.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Getting {@link Treasure#id}.
	 * 
	 * @return <b>int</b> containing {@link Treasure#id}.
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Getting {@link Treasure#price}.
	 * 
	 * @return <b>int</b> containing {@link Treasure#price}.
	 */
	public int getPrice() {
		return this.price;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + price;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Treasure other = (Treasure) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price != other.price)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Treasure [name=" + name + ", id=" + id + ", price=" + price + "]";
	}

}
