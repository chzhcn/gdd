package cn.edu.whu.iss.gdd.data;

/**
 * Describe class DijkstraAlgorNode here.
 *
 *
 * Created: Wed Mar 31 10:06:13 2010
 *
 * @author <a href="mailto:chzhcn@chzhcn-laptop">chzhcn</a>
 * @version 1.0
 */
public class DijkstraAlgorNode extends Location {

	double weight = Double.MAX_VALUE;

	DijkstraAlgorNode prevNode = null;

	boolean visited = false;
	
	/**
	 * Creates a new <code>DijkstraAlgorNode</code> instance.
	 *
	 */
	public DijkstraAlgorNode(Location location) {
		super(location);
	}

	public DijkstraAlgorNode() {
		
	}

	
	/**
	 * Gets the value of weight
	 *
	 * @return the value of weight
	 */
	public final double getWeight() {
		return this.weight;
	}

	/**
	 * Sets the value of weight
	 *
	 * @param argWeight Value to assign to this.weight
	 */
	public final void setWeight(final double argWeight) {
		this.weight = argWeight;
	}

	/**
	 * Gets the value of prevNode
	 *
	 * @return the value of prevNode
	 */
	public final DijkstraAlgorNode getPrevNode() {
		return this.prevNode;
	}

	/**
	 * Sets the value of prevNode
	 *
	 * @param argPrevNode Value to assign to this.prevNode
	 */
	public final void setPrevNode(final DijkstraAlgorNode argPrevNode) {
		this.prevNode = argPrevNode;
	}


	/**
	 * Gets the value of visited
	 *
	 * @return the value of visited
	 */
	public final boolean isVisited() {
		return this.visited;
	}

	/**
	 * Sets the value of visited
	 *
	 * @param argVisited Value to assign to this.visited
	 */
	public final void setVisited(final boolean argVisited) {
		this.visited = argVisited;
	}
}
