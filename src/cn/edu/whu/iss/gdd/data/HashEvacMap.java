package cn.edu.whu.iss.gdd.data;

import java.util.HashMap;
import java.util.Map;
import java.util.Iterator;


/**
 * Describe class HashEvacMap here.
 *
 *
 * Created: Mon Mar 22 20:03:16 2010
 *
 * @author <a href="mailto:chzhcn@chzhcn-laptop">chzhcn</a>
 * @version 1.0
 */
public class HashEvacMap implements EvacMap {

	HashMap<Integer, Location> points;
	HashMap<Integer, Path> paths;
	HashMap<Integer, Location> exits;

	/**
	 * Creates a new <code>HashEvacMap</code> instance.
	 *
	 */
	public HashEvacMap(HashMap<Integer, Location> points, HashMap<Integer, Path> paths, HashMap<Integer, Location> exits) {
		this.points = points;
		this.paths = paths;
		this.exits = exits;
	}

	/**
	 * Creates a new <code>HashEvacMap</code> instance.
	 *
	 */
	public HashEvacMap(HashMap<Integer, Location> points, HashMap<Integer, Path> paths) {
		this.points = points;
		this.paths = paths;
	}

	// Implementation of cn.edu.whu.iss.gdd.data.EvacMap

	/**
	 * Describe <code>setExits</code> method here.
	 *
	 * @param map a <code>Map</code> value
	 */
	public final void setExits(final Map<Integer, Location> exits) {
		this.exits = (HashMap<Integer, Location>)exits;
	}

	/**
	 * Describe <code>setPaths</code> method here.
	 *
	 * @param map a <code>Map</code> value
	 */
	public final void setPaths(final Map<Integer, Path> paths) {
		this.paths = (HashMap<Integer, Path>)paths;
	}

	/**
	 * Describe <code>setPoints</code> method here.
	 *
	 * @param map a <code>Map</code> value
	 */
	public final void setPoints(final Map<Integer, Location> points) {
		this.points = (HashMap<Integer, Location>)points;
	}

	/**
	 * Describe <code>getPaths</code> method here.
	 *
	 * @return a <code>Map</code> value
	 */
	public final Map<Integer, Path> getPaths() {
		return paths;
	}

	/**
	 * Describe <code>getPoints</code> method here.
	 *
	 * @return a <code>Map</code> value
	 */
	public final Map<Integer, Location> getPoints() {
		return points;
	}

	/**
	 * Describe <code>getExits</code> method here.
	 *
	 * @return a <code>Map</code> value
	 */
	public final Map<Integer, Location> getExits() {
		return exits;
	}

	public boolean hasExit(Location location) {
		Iterator<Location> it = exits.values().iterator();
		while(it.hasNext()) {
			Location l = it.next();
			if (location.getId() == l.getId()) {
				return true;
			}
		}
		return false;
	}

	public int getPathIdByLocations(Location l1, Location l2) {
		Iterator<Path> it = paths.values().iterator();
		while(it.hasNext()) {
			Path p = it.next();
			if (p.hasLocations(l1, l2)) {
				return p.getId();
			}
		}
		return -1;
	}
}
