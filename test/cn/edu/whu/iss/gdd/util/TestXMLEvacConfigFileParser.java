package cn.edu.whu.iss.gdd.util;

import static org.junit.Assert.*;

import java.io.File;
import java.util.HashMap;

import cn.edu.whu.iss.gdd.data.EvacMap;
import cn.edu.whu.iss.gdd.data.Location;
import cn.edu.whu.iss.gdd.data.Path;
import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Elements;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import nu.xom.Element;
import java.io.IOException;
import nu.xom.ParsingException;

/**
 *  Unit Test for class TestXMLConfigFileParser
 *
 *
 * Created: Sun Mar 28 14:43:08 2010
 *
 * @author <a href="mailto:chzhcn@chzhcn-laptop">chzhcn</a>
 * @version 1.0
 */
public class  TestXMLEvacConfigFileParser {

	Builder parser;
	Document doc;
	Element map;
	Elements points;
	Elements paths;
	EvacMap em;
	HashMap<Integer, Location> pnts;
	HashMap<Integer, Path> pths;
	Double delta = 1E-15;
	
	@Before
		
		public void setup() {
		pnts = new HashMap<Integer, Location>();
		pths = new HashMap<Integer, Path>();
		parser = new Builder();
		try {
			doc = parser.build(new File("build/data.txt"));
		} catch (ParsingException e) {
			System.err.println("xml malformed");
		} catch (IOException e) {
			System.err.println("IOException at XMLEvacMap, creating the doc object");
		}
		map = doc.getRootElement();									  
		points = map.getFirstChildElement("points").getChildElements();
		paths = map.getFirstChildElement("paths").getChildElements();

		
		// 	em = new XMLEvacConfigFileParser().loadEvacMap(new File("build/data.txt"));
		// 	System.out.println(System.getProperty("user.dir"));
	}
	
	/**
	 * @return a <code>TestMethod</code>
	 */
	@Test
		public void testElementsReady() {
		assertEquals(points.size(), 14);
		assertEquals(paths.size(), 17);
	}

	@Test
		public void testOnePointOk() {
		Element point = points.get(2);
		int id = Integer.parseInt(point.getAttributeValue("id"));
		double lat = Double.parseDouble(point.getFirstChildElement("lat").getValue());
		double lng = Double.parseDouble(point.getFirstChildElement("lng").getValue());
		assertEquals(id, 3);
		assertEquals(lat, 30.525693272533996, delta);
		assertEquals(lng, 114.36185538768768, delta);
	}

	@Test
		public void testPointPathBatchOK() {
		for (int i = 0; i < points.size(); i++) {
			Element point = points.get(i);
			int id = Integer.parseInt(point.getAttributeValue("id"));
			double lat = Double.parseDouble(point.getFirstChildElement("lat").getValue());
			double lng = Double.parseDouble(point.getFirstChildElement("lng").getValue());
			pnts.put(id, new Location(id, lat, lng));
		}

		assertEquals(14, pnts.size());
		assertEquals(114.36286389827728, pnts.get(5).getLng(), delta);

		for (int i = 0; i < paths.size(); i++) {
			Element path = paths.get(i);
			int id = Integer.parseInt(path.getAttributeValue("id"));
			int l1 = Integer.parseInt(path.getChildElements("point").get(0).getValue());
			int l2 = Integer.parseInt(path.getChildElements("point").get(1).getValue());
			double length = Double.parseDouble(path.getFirstChildElement("length").getValue());				
			pths.put(id, new Path(id, pnts.get(l1), pnts.get(l2), length));	
		}
		// assertEquals(em.getPoints().size(), 14);
		// assertEquals(em.getPaths().size(), 17);
		assertEquals(17, pths.size());
		assertEquals(pnts.get(13), pths.get(14).getL1());

	}

		@Test
			public void testPathBatchOk() {

		}

	@After
		public void tearDown() {

		Builder parser = null;
		Document doc = null;
		Element map = null;
		Elements points = null;
		Elements paths = null;
		EvacMap em = null;
		HashMap<Integer, Location> pnts = null;
		HashMap<Integer, Path> pths = null;

	}

}// TestXMLConfigFileParser
