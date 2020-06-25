package it.univpm.Project;

import java.io.IOException;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjectApplication {

	public static void main(String[] args) throws ParseException, IOException {
		SpringApplication.run(ProjectApplication.class, args);
	}

}
