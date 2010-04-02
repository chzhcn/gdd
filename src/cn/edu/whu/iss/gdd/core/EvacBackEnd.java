package cn.edu.whu.iss.gdd.core;

import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import cn.edu.whu.iss.gdd.data.EvacMap;
import cn.edu.whu.iss.gdd.util.EvacConfigFileParser;
import java.io.File;
import cn.edu.whu.iss.gdd.data.EvacRoute;
import cn.edu.whu.iss.gdd.data.Location;

// public abstract EvacBackEnd implements Evacuatable {

/**
 * the general interface for Evacuation back-end
 *
 * @author <a href="mailto:chzhcn@chzhcn-laptop">chzhcn</a>
 * @version 1.0
 */

public class EvacBackEnd implements Observer {

	/**
	 * the evacucation algorithm this backend is going to use
	 *
	 */
	static EvacProcessor evacProcessor;
	/**
	 * the evacuation config file
	 *
	 */
	static File file;
	
	/**
	 * the EvacuationAssistant this backend is cooperating with
	 */
	EvacAssistant ea;
	
	/**
	 * the Evacuation Map, the background
	 */
	static EvacMap evacMap;

	/**
	 * the file parser this backend is going to use
	 */
	static EvacConfigFileParser ecfp;

	/**
	 * get BackEnd to prepare, like loading the data, remote backend watching the port, etc
	 *
	 */
	static void init(File fiel, EvacConfigFileParser ecfp, EvacProcessor evacProcessor) {
		// evacMap = ecfp.loadEvacMap(file);set
		EvacBackEnd.file = file;
		// LocalEvacBackEnd.evacMap = evacMap;
		EvacBackEnd.ecfp = ecfp;
		EvacBackEnd.evacProcessor = evacProcessor;
		evacMap = ecfp.loadEvacMap(file);
		evacProcessor.setEvacMap(evacMap);
	}
	
	// Implementation of java.util.Observer

	/**
	 * Describe <code>update</code> method here.
	 *
	 * @param observable an <code>Observable</code> value
	 * @param object an <code>Object</code> value
	 */
	public final void update(final Observable observable, final Object object) {
		if (observable instanceof Evacuatable) {
			EvacRoute er  = evacProcessor.computeEvacRoute((Location)object);
			ea.setRoute(er);
		}

	}

	
	/**
	 * Gets the value of ea
	 *
	 * @return the value of ea
	 */
	public final EvacAssistant getEa() {
		return this.ea;
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
	 * Gets the value of evacMap
	 *
	 * @return the value of evacMap
	 */
	public static final EvacMap getEvacMap() {
		return EvacBackEnd.evacMap;
	}

	/**
	 * Sets the value of evacMap
	 *
	 * @param argEvacMap Value to assign to this.evacMap
	 */
	public static final void setEvacMap(final EvacMap argEvacMap) {
		EvacBackEnd.evacMap = argEvacMap;
	}

	/**
	 * Gets the value of ecfp
	 *
	 * @return the value of ecfp
	 */
	public static final EvacConfigFileParser getEcfp() {
		return EvacBackEnd.ecfp;
	}

	/**
	 * Sets the value of ecfp
	 *
	 * @param argEcfp Value to assign to this.ecfp
	 */
	public static final void setEcfp(final EvacConfigFileParser argEcfp) {
		EvacBackEnd.ecfp = argEcfp;
	}

	
	/**
	 * Gets the value of file
	 *
	 * @return the value of file
	 */
	public static final File getFile() {
		return EvacBackEnd.file;
	}

	/**
	 * Sets the value of file
	 *
	 * @param argFile Value to assign to this.file
	 */
	public static final void setFile(final File argFile) {
		EvacBackEnd.file = argFile;
	}

	
	/**
	 * Gets the value of evacProcessor
	 *
	 * @return the value of evacProcessor
	 */
	public static final EvacProcessor getEvacProcessor() {
		return EvacBackEnd.evacProcessor;
	}

	/**
	 * Sets the value of evacProcessor
	 *
	 * @param argEvacProcessor Value to assign to this.evacProcessor
	 */
	public static final void setEvacProcessor(final EvacProcessor argEvacProcessor) {
		EvacBackEnd.evacProcessor = argEvacProcessor;
	}


	
}
