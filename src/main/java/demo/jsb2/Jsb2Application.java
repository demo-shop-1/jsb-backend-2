package demo.jsb2;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Jsb2Application {

	protected static final Logger logger = Logger.getLogger(Jsb2Application.class.getName());

	public static void main(String[] args) {
		logger.info("Starting web server!");
		SpringApplication.run(Jsb2Application.class, args);
	}

}
