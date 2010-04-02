package cn.edu.whu.iss.gdd.core;

import cn.edu.whu.iss.gdd.data.EvacRoute;

/**
 * Describe interface EvacAssistant here.
 *
 *
 * Created: Sat Mar 27 11:23:58 2010
 *
 * @author <a href="mailto:chzhcn@chzhcn-laptop">chzhcn</a>
 * @version 1.0
 */
public interface EvacAssistant {
	void connectEvacBackEnd();
	void init();
	EvacBackEnd getEvacBackEnd();
	Evacuatable getEvacuatable();
	void setRoute(EvacRoute evacRoute);
}
