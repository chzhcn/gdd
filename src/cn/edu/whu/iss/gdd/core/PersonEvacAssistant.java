package cn.edu.whu.iss.gdd.core;

import java.util.Map;

import cn.edu.whu.iss.gdd.data.EvacMap;
import cn.edu.whu.iss.gdd.data.EvacRoute;
import cn.edu.whu.iss.gdd.data.Location;

/**
 * Implements interface EvacAssistant
 *
 * Created: Wed Mar 24 21:31:14 2010
 *
 * @author <a href="mailto:chzhcn@chzhcn-laptop">chzhcn</a>
 * @version 1.0
 */
public class PersonEvacAssistant implements EvacAssistant {

	Evacuatable evacuatable;
	EvacBackEnd evacBackEnd;
	EvacMap evacMap;

	public PersonEvacAssistant(EvacBackEnd evacBackEnd) {
		this.evacBackEnd = evacBackEnd;
		
	}

	public void init() {
		connectEvacBackEnd();
	}

	public void connectEvacBackEnd() {
		if (evacBackEnd instanceof LocalEvacBackEnd) {
			evacBackEnd.setEa(this);
		}

	}

	/**
	 * Gets the value of evacuatable
	 *
	 * @return the value of evacuatable
	 */
	public final Evacuatable getEvacuatable() {
		return this.evacuatable;
	}

	/**
	 * Sets the value of evacuatable
	 *
	 * @param argEvacuatable Value to assign to this.evacuatable
	 */
	public final void setEvacuatable(final Evacuatable argEvacuatable) {
		this.evacuatable = argEvacuatable;
	}

	/**
	 * Gets the value of evacBackEnd
	 *
	 * @return the value of evacBackEnd
	 */
	public final EvacBackEnd getEvacBackEnd() {
		return this.evacBackEnd;
	}

	/**
	 * Sets the value of evacBackEnd
	 *
	 * @param argEvacBackEnd Value to assign to this.evacBackEnd
	 */
	public final void setEvacBackEnd(final EvacBackEnd argEvacBackEnd) {
		this.evacBackEnd = argEvacBackEnd;
	}

	/**
	 * Gets the value of evacMap
	 *
	 * @return the value of evacMap
	 */
	public final EvacMap getEvacMap() {
		return this.evacMap;
	}

	/**
	 * Sets the value of evacMap
	 *
	 * @param argEvacMap Value to assign to this.evacMap
	 */
	public final void setEvacMap(final EvacMap argEvacMap) {
		this.evacMap = argEvacMap;
	}

	/**
	 * Sets the value of route
	 *
	 * @param argRoute Value to assign to this.route
	 */
	public final void setRoute(final EvacRoute argRoute) {
		evacuatable.setRoute(argRoute);
	}

	public final Map<Integer, Location> getExits() {
		return EvacBackEnd.getExits();
	}
	
}