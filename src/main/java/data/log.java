package data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class log {
private static Logger log =LogManager.getLogger(log.class.getName());
	
	public Logger getLogger() {
		return log;
	}

}
