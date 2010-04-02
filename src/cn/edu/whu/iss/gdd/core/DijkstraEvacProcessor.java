package cn.edu.whu.iss.gdd.core;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import cn.edu.whu.iss.gdd.data.DijkstraAlgorEdge;
import cn.edu.whu.iss.gdd.data.DijkstraAlgorNode;
import cn.edu.whu.iss.gdd.data.EvacMap;
import cn.edu.whu.iss.gdd.data.EvacRoute;
import cn.edu.whu.iss.gdd.data.Location;
import cn.edu.whu.iss.gdd.data.Path;





/**
 * the evacuation algorithm based on Dijkstra's shortest path algorithm
 *
 *
 * Created: Tue Mar 30 15:55:46 2010
 *
 * @author <a href="mailto:chzhcn@chzhcn-laptop">chzhcn</a>
 * @version 1.0
 */
public class DijkstraEvacProcessor implements EvacProcessor {

	/**
	 * the Evac Map based on which this algorithm is running
	 *
	 */
	EvacMap evacMap;

	Map<Integer, DijkstraAlgorNode> nodes;
	Map<Integer, DijkstraAlgorEdge> edges;
	
	/**
	 * Creates a new <code>DijkstraEvacProcessor</code> instance.
	 *
	 */
	public DijkstraEvacProcessor() {
		
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
		prepareMap();
	}

	private void prepareMap() {
		nodes = new HashMap<Integer, DijkstraAlgorNode>();
		Collection<Location> pnts = evacMap.getPoints().values();
		Iterator<Location> it = pnts.iterator();
		while(it.hasNext()) {
			Location l = it.next();
			nodes.put(l.getId(), new DijkstraAlgorNode(l));
		}
		
		edges = new HashMap<Integer, DijkstraAlgorEdge>();
		Collection<Path> pths = evacMap.getPaths().values();
		Iterator<Path> ite = pths.iterator();
		while(ite.hasNext()) {
			Path p = ite.next();
			edges.put(p.getId(), new DijkstraAlgorEdge(p));
		}
		
	}

	private Map<DijkstraAlgorNode, DijkstraAlgorEdge> getNeighbourNodePathPairs(DijkstraAlgorNode node) {
		Map<DijkstraAlgorNode, DijkstraAlgorEdge> neighbourNodePathPairs = new HashMap<DijkstraAlgorNode, DijkstraAlgorEdge>();
		Collection<DijkstraAlgorEdge> es = edges.values();
		Iterator<DijkstraAlgorEdge> it = es.iterator();
		while (it.hasNext()) {
			DijkstraAlgorEdge e = it.next();
			if (e.hasLocation(node)) {
				Location ltemp = e.getOtherEnd(node);
				DijkstraAlgorNode neighbourNode = nodes.get(ltemp.getId());
				if (!neighbourNode.isVisited()) {
					neighbourNodePathPairs.put(neighbourNode, e);
				}
			}
		}
		return neighbourNodePathPairs;
	}

	private  void resetWeight(DijkstraAlgorNode node) {
		Iterator<DijkstraAlgorNode> it = nodes.values().iterator();
		while (it.hasNext()) {
			DijkstraAlgorNode n = it.next();
			n.setWeight(Double.MAX_VALUE);
		}
		node.setWeight(0);
	}
	
	// Implementation of cn.edu.whu.iss.gdd.core.EvacProcessor

	/**
	 * Describe <code>computeEvacRoute</code> method here.
	 *
	 * @param location a <code>Location</code> value
	 * @return an <code>EvacRoute</code> value
	 */
	public final EvacRoute computeEvacRoute(Evacuatable evacuatable) {
		EvacRoute er = new EvacRoute();

		Location currentLocation = evacuatable.getCurrentLocation();
		Path currentPath = evacuatable.getCurrentPath();
		double velocity = evacuatable.getVelocity();

		// DijkstraAlgorEdge pastEdge = edges.get(currentPath.getId());
		// pastEdge.decrementTrafficByOne();

		DijkstraAlgorNode node = nodes.get(currentLocation.getId());
		resetWeight(node);
		DijkstraAlgorNode minNode = calcuateOneNode(node, velocity);
		
		toEvacRoute(er, minNode);
		return er;
	}

	private void toEvacRoute(EvacRoute er, DijkstraAlgorNode node) {
		DijkstraAlgorNode prevNode;
		while (null != (prevNode = node.getPrevNode())) {
			int pathId = evacMap.getPathIdByLocations(node,prevNode);
			if (pathId != -1) {
				Path path = edges.get(pathId);
				er.addFirst(path);
			}
			node = prevNode;
		}

	}

	private DijkstraAlgorNode calcuateOneNode(DijkstraAlgorNode node, Double velocity) {
		Map<DijkstraAlgorNode, DijkstraAlgorEdge> neighbourNodePathPairs = getNeighbourNodePathPairs(node);
		DijkstraAlgorNode minNode = new DijkstraAlgorNode();
		Iterator<DijkstraAlgorNode> it = neighbourNodePathPairs.keySet().iterator();
		while (it.hasNext()) {
			DijkstraAlgorNode n = it.next();
			DijkstraAlgorEdge e = neighbourNodePathPairs.get(n);
			
			double density = e.getCurrentTraffic()/e.getTraffic();
			density = density > 1 ? density : 1;
			
			double weight = node.getWeight() + e.getLength()/velocity*density;
			if (weight < n.getWeight()) {
				n.setWeight(weight);
				n.setPrevNode(node);
			}

			if (n.getWeight() < minNode.getWeight()) {
				minNode = n;
			}

		}
		node.setVisited(true);
		minNode.setPrevNode(node);
		if (evacMap.hasthisExitLocation(minNode)) {
			return minNode;			
		} else {
			return calcuateOneNode(minNode, velocity);
		}
	}
	
}
