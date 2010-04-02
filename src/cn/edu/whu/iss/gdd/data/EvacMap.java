package cn.edu.whu.iss.gdd.data;

import java.util.Map;
import cn.edu.whu.iss.gdd.data.Location;
import cn.edu.whu.iss.gdd.data.Path;

/**
 * Describe class EvacMap here.
 *
 * the evacuation map based on which a evacuatee will get out.
 *
 * use Map interface to collect a set of points and paths to present a graph 
 *
 * Created: Mon Mar 22 20:03:16 2010
 *
 * @author <a href="mailto:chzhcn@chzhcn-laptop">chzhcn</a>
 * @version 1.0
 */
public interface EvacMap {
	
	void setExits(Map<Integer, Location> exits);
	
	void setPaths(Map<Integer, Path> paths);
	
	void setPoints(Map<Integer, Location> points);

	boolean hasExit(Location location);

	int getPathIdByLocations(Location l1, Location l2);
	
	Map<Integer, Path> getPaths();
	
	Map<Integer, Location> getPoints();

	Map<Integer, Location> getExits();
	
}
