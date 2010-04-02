package cn.edu.whu.iss.gdd.data;

/**
 * Describe class DijkstraAlgorPath here.
 *
 *
 * Created: Wed Mar 31 19:51:13 2010
 *
 * @author <a href="mailto:chzhcn@chzhcn-laptop">chzhcn</a>
 * @version 1.0
 */
public class DijkstraAlgorEdge extends Path {

	int currentTraffic = 0;

	double weight = -1;
	
	/**
	 * Creates a new <code>DijkstraAlgorPath</code> instance.
	 *
	 */
	public DijkstraAlgorEdge(Path p) {
		super(p);	
	}

	
	/**
	 * Gets the value of currentTraffic
	 *
	 * @return the value of currentTraffic
	 */
	public final int getCurrentTraffic() {
		return this.currentTraffic;
	}

	/**
	 * Sets the value of currentTraffic
	 *
	 * @param argCurrentTraffic Value to assign to this.currentTraffic
	 */
	public final void setCurrentTraffic(final int argCurrentTraffic) {
		this.currentTraffic = argCurrentTraffic;
	}


}
