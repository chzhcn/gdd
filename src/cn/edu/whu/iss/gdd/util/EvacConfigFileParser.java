package cn.edu.whu.iss.gdd.util;

import java.io.File;

import cn.edu.whu.iss.gdd.data.EvacMap;

/**
 * Describe interface EvacConfigFileParser here.
 *
 * the general interface for parsing config file, implement this interface to support new Config file type
 *
 *
 * Created: Thu Mar 25 09:56:48 2010
 *
 * @author <a href="mailto:chzhcn@chzhcn-laptop">chzhcn</a>
 * @version 1.0
 */
public interface EvacConfigFileParser {
	/**
	 * Describe <code>loadEvacMap</code> method here.
	 *
	 * use a File object to parse, in order to create an EvacMap object
	 *
	 * @param file a <code>File</code> value that used to parse out the <code>EvacMap</code> object
	 * @return an <code>EvacMap</code> value
	 */
	EvacMap loadEvacMap(File file);
}
