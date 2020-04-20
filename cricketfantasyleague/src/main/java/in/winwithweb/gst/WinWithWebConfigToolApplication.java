package in.winwithweb.gst;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class WinWithWebConfigToolApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WinWithWebConfigToolApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(WinWithWebConfigToolApplication.class, args);
	}

}
