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

	int traffic;

	
	public Path(int id, Location l1, Location l2, double length, int traffic) {
		this.id = id;
		this.l1 = l1;
		this.l2 = l2;
		// this.name = name;
		this.length = length;
		this.traffic = traffic;
	}

	public Path(Path p) {
		this(p.getId(), p.getL1(), p.getL2(), p.getLength(), p.getTraffic());
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
	 * Gets the value of traffic
	 *
	 * @return the value of traffic
	 */
	public final int getTraffic() {
		return this.traffic;
	}

	/**
	 * Sets the value of traffic
	 *
	 * @param argTraffic Value to assign to this.traffic
	 */
	public final void setTraffic(final int argTraffic) {
		this.traffic = argTraffic;
	}

	public final Location getOtherEnd(final Location location) {
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
		if (s.getId() == l1.getId() && d.getId() == l2.getId()) {
			return true;
		} else {
			return false;
		}
	}
}
