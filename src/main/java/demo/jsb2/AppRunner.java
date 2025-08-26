package demo.jsb2;

import java.util.logging.Logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppRunner {

	protected static final Logger logger = Logger.getLogger(AppRunner.class.getName());

	public static void main(String[] args) {
		logger.info("AppRunner > main > Starting web server!");
		SpringApplication.run(AppRunner.class, args);
	}

}
