package cn.edu.whu.iss.gdd.core;

import cn.edu.whu.iss.gdd.data.Location;
import cn.edu.whu.iss.gdd.data.EvacRoute;
import cn.edu.whu.iss.gdd.data.EvacMap;
import cn.edu.whu.iss.gdd.data.Location;
import cn.edu.whu.iss.gdd.data.EvacRoute;

/**
 * the evacuation algorithm based on Dijkastra's shortest path algorithm
 *
 *
 * Created: Tue Mar 30 15:55:46 2010
 *
 * @author <a href="mailto:chzhcn@chzhcn-laptop">chzhcn</a>
 * @version 1.0
 */
public class ShortestPathEvacProcessor implements EvacProcessor {

	/**
	 * the Evac Map based on which this algorithm is running
	 *
	 */
	EvacMap evacMap;
	
	
	/**
	 * Creates a new <code>ShortestPathEvacProcessor</code> instance.
	 *
	 */
	public ShortestPathEvacProcessor() {

	}

	// Implementation of cn.edu.whu.iss.gdd.core.EvacProcessor
	
	/**
	 * Gets the value of evaMap
	 *
	 * @return the value of evaMap
	 */
	public final EvacMap getEvaMap() {
		return this.evacMap;
	}

	/**
	 * Sets the value of evaMap
	 *
	 * @param argEvaMap Value to assign to this.evaMap
	 */
	public final void setEvacMap(EvacMap argEvacMap) {
		this.evacMap = argEvacMap;
	}

	
	// Implementation of cn.edu.whu.iss.gdd.core.EvacProcessor

	/**
	 * Describe <code>computeEvacRoute</code> method here.
	 *
	 * @param location a <code>Location</code> value
	 * @return an <code>EvacRoute</code> value
	 */
	public final EvacRoute computeEvacRoute(final Location location) {
		return null;
	}
	
}
