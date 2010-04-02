package cn.edu.whu.iss.gdd.data;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import cn.edu.whu.iss.gdd.util.XMLEvacConfigFileParser;
import cn.edu.whu.iss.gdd.util.EvacConfigFileParser;

/**
 *  Unit Test for class Path
 *
 *
 * Created: Fri Apr  2 10:20:52 2010
 *
 * @author <a href="mailto:chzhcn@chzhcn-laptop">chzhcn</a>
 * @version 1.0
 */
public class TestData {

	EvacMap map;
	Path p1;
	Path p3;
	Location l1;
	Location l2;
	Location l3;
	Location l4;
	
	/** 
	 * Creates a new <code>TestData</code> instance.
	 *
	 * @param name test name
	 */
	public TestData() {

	}

	@Before
		public void setUp() {
		EvacConfigFileParser xecfp = new XMLEvacConfigFileParser();
		map = xecfp.loadEvacMap(new File("build/data.xml"));
		p1 = (Path)map.getPaths().values().toArray()[0];
		p3 = (Path)map.getPaths().values().toArray()[2];
		l1 = (Location)map.getPoints().values().toArray()[0];
		l2 = (Location)map.getPoints().values().toArray()[1];
		l3 = (Location)map.getPoints().values().toArray()[2];
		l4 = (Location)map.getPoints().values().toArray()[3];
		Map<Integer, Location> exits = new HashMap<Integer, Location>();
		exits.put(l1.getId(), l1);
		exits.put(l2.getId(), l2);
		map.setExits(exits);
	}
	
	/**
	 * @return a <code>TestMethod</code>
	 */
	@Test
		public void testHasLocations() {
		assertTrue(p1.hasLocations(l1, l2));
		assertTrue(p1.hasLocations(l2, l1));
		assertTrue(p3.hasLocations(l3, l4));
		assertFalse(p1.hasLocations(l1, l3));
	}

	@Test
		public void testHasLocation() {
		assertTrue(p1.hasLocation(l1));
		assertFalse(p3.hasLocation(l1));
	}

	@Test
		public void testMapExits() {
		assertEquals(2, map.getExits().values().size());
	}
	
	@Test
		public void testHasExit() {
		assertTrue(map.hasExit(l1));
		assertFalse(map.hasExit(l2));
	}

	// /** 
	//  * Test Adapter 
	//  */ 
	// public static junit.framework.Test suite() {
	// 	return new JUnit4TestAdapter(TestData.class);
	// }
}// TestData
