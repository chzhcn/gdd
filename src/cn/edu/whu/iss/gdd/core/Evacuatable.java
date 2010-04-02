package cn.edu.whu.iss.gdd.core;

import cn.edu.whu.iss.gdd.data.Location;
import cn.edu.whu.iss.gdd.data.Path;
import cn.edu.whu.iss.gdd.data.EvacRoute;

import java.util.Map;


/**
 * Describe interface evacuatable here.
 *
 * the interface anything that want to evacuate should implement
 *
 * Created: Mon Mar 22 11:19:29 2010
 *
 * @author <a href="mailto:chzhcn@chzhcn-laptop">chzhcn</a>
 * @version 1.0
 */
public interface Evacuatable {

	void evacuate();
	
	void setRoute(EvacRoute evacRoute);

	double getVelocity();
	
	Location getCurrentLocation();

	Path getCurrentPath();

	// EvacRoute getRoute();

	// EvacRoute getPastRoute();
	
	Map<Integer, Location> getExits();
	
}


