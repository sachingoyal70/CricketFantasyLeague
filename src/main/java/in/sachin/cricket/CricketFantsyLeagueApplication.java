package in.sachin.cricket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class CricketFantsyLeagueApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CricketFantsyLeagueApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(CricketFantsyLeagueApplication.class, args);
	}

}
