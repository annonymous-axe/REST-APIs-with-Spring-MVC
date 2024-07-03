package app;

import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

@SpringBootApplication
@Configuration
public class BankingAppApplication implements WebMvcConfigurer{

	public static void main(String[] args) {
		SpringApplication.run(BankingAppApplication.class, args);
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry viewRegister) {
		viewRegister.addViewController("/").setViewName("home");
	}

}
