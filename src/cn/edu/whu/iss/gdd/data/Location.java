package cn.edu.whu.iss.gdd.data;

/**
 * Describe class Location here.
 *
 * a single point on the map that takes latitude and longtitude as location parameters
 *
 *
 * Created: Mon Mar 22 19:48:09 2010
 *
 * @author <a href="mailto:chzhcn@chzhcn-laptop">chzhcn</a>
 * @version 1.0
 */
public class Location {

	int id;
	
	double lat;
	double lng;
	
	/**
	 * Creates a new <code>Location</code> instance.
	 *
	 */
	public Location() {

	}

	public Location(int id, double lat, double lng) {
		this.id = id;
		this.lat = lat;
		this.lng = lng;
	}

	public double getLat() {
		return lat;
	}

	public double getLng() {
		return lng;
	}

	public int getId() {
		return id;
	}

}
