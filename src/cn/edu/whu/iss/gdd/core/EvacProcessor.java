package cn.edu.whu.iss.gdd.core;

import cn.edu.whu.iss.gdd.data.Location;
import cn.edu.whu.iss.gdd.data.EvacRoute;
import cn.edu.whu.iss.gdd.data.EvacMap;

/**
 * the general interface for the evacuation algorithm 
 * 
 *
 * Created: Tue Mar 30 15:47:35 2010
 *
 * @author <a href="mailto:chzhcn@chzhcn-laptop">chzhcn</a>
 * @version 1.0
 */
public interface EvacProcessor {

	/**
	 * given a starting Location, compute the best evacuation route based on this algorithm
	 *
	 * @param point a <code>Location</code> value
	 * @return an <code>EvacRoute</code> value the evacuation route the algorithm pick up for the evacuatee
	 */
	EvacRoute computeEvacRoute(Evacuatable evacuatable);

	void setEvacMap(EvacMap evacMap);
	
}
