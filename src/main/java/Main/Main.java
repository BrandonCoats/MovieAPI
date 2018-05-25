package Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages="Controllers")
@EntityScan(basePackages="Models")
@EnableMongoRepositories(basePackages="Repos")
@EnableJpaRepositories(basePackages="Repos")
public class Main extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Main.class,args);
	}

}
