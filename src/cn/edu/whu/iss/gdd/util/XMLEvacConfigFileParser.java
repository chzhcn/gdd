package cn.edu.whu.iss.gdd.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import cn.edu.whu.iss.gdd.data.EvacMap;
import cn.edu.whu.iss.gdd.data.HashEvacMap;
import cn.edu.whu.iss.gdd.data.Location;
import cn.edu.whu.iss.gdd.data.Path;
import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Elements;
import nu.xom.ParsingException;


/**
 * Describe class XMLEvacConfigFileParser here.
 *
 * the concrete XML parser class, use open source library XOM
 *
 * Created: Thu Mar 25 10:29:06 2010
 *
 * @author <a href="mailto:chzhcn@chzhcn-laptop">chzhcn</a>
 * @version 1.0
 */
public class XMLEvacConfigFileParser implements EvacConfigFileParser {

	/**
	 * Creates a new <code>XMLEvacConfigFileParser</code> instance.
	 *
	 */
	public XMLEvacConfigFileParser() {

	}

	public EvacMap loadEvacMap(File file) {
		HashMap<Integer, Location> pnts = new HashMap<Integer, Location>();
		HashMap<Integer, Path> pths = new HashMap<Integer, Path>();
		Builder parser = new Builder();
		try {
			Document doc = parser.build(file);
			Element map = doc.getRootElement();
			Elements points = map.getFirstChildElement("points").getChildElements();
			Elements paths = map.getFirstChildElement("paths").getChildElements();

			for (int i = 0; i < points.size(); i++) {
				Element point = points.get(i);
				int id = Integer.parseInt(point.getAttributeValue("id"));
				double lat = Double.parseDouble(point.getFirstChildElement("lat").getValue());
				double lng = Double.parseDouble(point.getFirstChildElement("lng").getValue());
				pnts.put(id, new Location(id, lat, lng));
			}

			for (int i = 0; i < paths.size(); i++) {
				Element path = paths.get(i);
				int id = Integer.parseInt(path.getAttributeValue("id"));
				int l1 = Integer.parseInt(path.getChildElements("point").get(0).getValue());
				int l2 = Integer.parseInt(path.getChildElements("point").get(1).getValue());
				double length = Double.parseDouble(path.getFirstChildElement("length").getValue());
				int traffic = Integer.parseInt(path.getAttributeValue("traffic"));
				pths.put(id, new Path(id, pnts.get(l1), pnts.get(l2), length, traffic));	
			}

		} catch (ParsingException e) {
			System.err.println("xml malformed");
		} catch (IOException e) {
			System.err.println("IOException at XMLEvacMap, creating the doc object");
		} catch (NumberFormatException e) {
			System.err.println(e);
		}
		return new HashEvacMap(pnts, pths);
	}

}
