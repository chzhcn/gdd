package cn.edu.whu.iss.gdd.data;

/**
 * Describe class Path here.
 *
 * a path that acts as an arc in a logical "graph", takes a starting and ending point to represent. Note that a path is non-directed
 *
 * Created: Mon Mar 22 19:50:39 2010
 *
 * @author <a href="mailto:chzhcn@chzhcn-laptop">chzhcn</a>
 * @version 1.0
 */
public class Path {

	// final int id = ++counter;

	// static int counter = 0;	

	int id;
	
	Location l1;
	Location l2;

	// String name;

	double length;

	double weight = -1;
	
	/**
	 * Creates a new <code>Path</code> instance.
	 *
	 */
	public Path() {

	}

	public Path(int id, Location l1, Location l2, double length) {
		this.id = id;
		this.l1 = l1;
		this.l2 = l2;
		// this.name = name;
		this.length = length;
	}


	/**
	 * Gets the value of id
	 *
	 * @return the value of id
	 */
	public final int getId() {
		return this.id;
	}


	/**
	 * Gets the value of length
	 *
	 * @return the value of length
	 */
	public final double getLength() {
		return this.length;
	}

	
	/**
	 * Sets the value of id
	 *
	 * @param argId Value to assign to this.id
	 */
	public final void setId(final int argId) {
		this.id = argId;
	}

	/**
	 * Gets the value of l1
	 *
	 * @return the value of l1
	 */
	public final Location getL1() {
		return this.l1;
	}

	/**
	 * Sets the value of l1
	 *
	 * @param argL1 Value to assign to this.l1
	 */
	public final void setL1(final Location argL1) {
		this.l1 = argL1;
	}

	/**
	 * Gets the value of l2
	 *
	 * @return the value of l2
	 */
	public final Location getL2() {
		return this.l2;
	}

	/**
	 * Sets the value of l2
	 *
	 * @param argL2 Value to assign to this.l2
	 */
	public final void setL2(final Location argL2) {
		this.l2 = argL2;
	}


	/**
	 * Sets the value of length
	 *
	 * @param argLength Value to assign to this.length
	 */
	public final void setLength(final double argLength) {
		this.length = argLength;
	}

	/**
	 * Gets the value of weight
	 *
	 * @return the value of weight
	 */
	public final double getWeight() {
		return this.weight;
	}

	/**
	 * Sets the value of weight
	 *
	 * @param argWeight Value to assign to this.weight
	 */
	public final void setWeight(final double argWeight) {
		this.weight = argWeight;
	}

	public final Location getOtherEnd(final Location location) {
<<<<<<< HEAD
		return location.getId() == l1.getId() ? l2 : l1;
	}

	public final boolean hasLocation(Location location) {
		if (l1.getId() == location.getId()) {
			return true;
		} else if (l2.getId() == location.getId()) {
			return true;
		}
		return false;
	}

	// public  void decrementTrafficByOne() {
	// 	traffic--;
	// }

	// public  void incrementTrafficByOne() {
	// 	traffic++;
	// }

	public boolean hasLocations(Location s, Location d) {
		if ( (s.getId() == l1.getId() && d.getId() == l2.getId())
			 || (s.getId() == l2.getId() && d.getId() == l1.getId()) ) {
			return true;
		} else {
			return false;
		}
=======
		return location == l1 ? l2 : l1;
>>>>>>> 2270c3f... M is done, waiting for test
	}
	
}
