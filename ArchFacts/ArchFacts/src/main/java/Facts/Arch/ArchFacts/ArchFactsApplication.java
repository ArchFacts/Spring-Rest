package Facts.Arch.ArchFacts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class ArchFactsApplication {

	private static final Logger log = LoggerFactory.getLogger(ArchFactsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ArchFactsApplication.class, args);
	}

}
