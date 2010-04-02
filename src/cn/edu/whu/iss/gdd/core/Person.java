package cn.edu.whu.iss.gdd.core;

import java.util.Map;
import java.util.Observable;

import cn.edu.whu.iss.gdd.data.EvacRoute;
import cn.edu.whu.iss.gdd.data.Location;
import cn.edu.whu.iss.gdd.data.Path;

/**
 * Describe class Person here.
 *
 * the person that wants to evacuate
 *
 * Created: Mon Mar 22 20:18:45 2010
 *
 * @author <a href="mailto:chzhcn@chzhcn-laptop">chzhcn</a>
 * @version 1.0
 */
public class Person extends Observable implements Evacuatable {

	/**
	 * the velocity of this person
	 */
	double velocity;

	/**
	 * the EvacAssistant this person's using
	 */
	EvacAssistant ea;

	/**
	 * the evacuation route this person will follow
	 */
	EvacRoute route;

	/**
	 * the evacuation route this person has covered
	 */
	EvacRoute pastRoute;

	/**
	 * the point this person is standing on, note that this point is on the crosspoint of paths.
	 */
	Location currentLocation;

	/**
	 * the path this person is on
	 */
	Path currentPath;

	Person(double velocity, EvacAssistant ea, Location currentLocation, Path currentPath) {
		this.velocity = velocity;
		this.ea = ea;
		this.currentLocation = currentLocation;
		this.currentPath = currentPath;
	}

	public void evacuate() {
		ea.init();
		addObserver(ea.getEvacBackEnd());
		
		setChanged();
		notifyObservers();
		
		pastRoute = new EvacRoute();
		while (null != route.peekFirst()) {
			Path p  = route.pollFirst();
			currentLocation = p.getOtherEnd(currentLocation);
			currentPath = p;
			pastRoute.push(p);
			setChanged();
			notifyObservers();
		}

	}

	/**
	 * Gets the value of route
	 *
	 * @return the value of route
	 */
	public final EvacRoute getRoute() {
		return this.route;
	}

	/**
	 * Gets the value of pastRoute
	 *
	 * @return the value of pastRoute
	 */
	public final EvacRoute getPastRoute() {
		return this.pastRoute;
	}

	/**
	 * Gets the value of currentLocation
	 *
	 * @return the value of currentLocation
	 */
	public final Location getCurrentLocation() {
		return this.currentLocation;
	}

	/**
	 * Gets the value of currentPath
	 *
	 * @return the value of currentPath
	 */
	public final Path getCurrentPath() {
		return this.currentPath;
	}

	/**
	 * Gets the value of velocity
	 *
	 * @return the value of velocity
	 */
	public final double getVelocity() {
		return this.velocity;
	}

	/**
	 * Sets the value of velocity
	 *
	 * @param argVelocity Value to assign to this.velocity
	 */
	public final void setVelocity(final double argVelocity) {
		this.velocity = argVelocity;
	}

	/**
	 * Sets the value of ea
	 *
	 * @param argEa Value to assign to this.ea
	 */
	public final void setEa(final EvacAssistant argEa) {
		this.ea = argEa;
	}

	/**
	 * Sets the value of route
	 *
	 * @param argRoute Value to assign to this.route
	 */
	public final void setRoute(final EvacRoute argRoute) {
		this.route = argRoute;
	}

	/**
	 * Sets the value of pastRoute
	 *
	 * @param argPastRoute Value to assign to this.pastRoute
	 */
	public final void setPastRoute(final EvacRoute argPastRoute) {
		this.pastRoute = argPastRoute;
	}

	/**
	 * Sets the value of currentLocation
	 *
	 * @param argCurrentLocation Value to assign to this.currentLocation
	 */
	public final void setCurrentLocation(final Location argCurrentLocation) {
		this.currentLocation = argCurrentLocation;
	}

	/**
	 * Sets the value of currentPath
	 *
	 * @param argCurrentPath Value to assign to this.currentPath
	 */
	public final void setCurrentPath(final Path argCurrentPath) {
		this.currentPath = argCurrentPath;
	}
		
	public Map<Integer, Location> getExits() {
		return ea.getExits();
	}

}
