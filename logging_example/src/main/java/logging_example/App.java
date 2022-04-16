package logging_example;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
	private static final Logger LOGGER = LogManager.getLogger(App.class);

	public static void main(String[] args) {
		LOGGER.fatal("This is an FATAL!");
		LOGGER.error("This is an ERROR!");
		LOGGER.warn("This is an WARN!");
		LOGGER.info("This is an INFO!");
		LOGGER.debug("This is an DEBUG!");
		LOGGER.trace("This is an TRACE!");
	}
}
