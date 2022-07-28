package fa.trainning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
@ComponentScan
public class TheGioiDiDongNhom7Application {

	public static void main(String[] args) {
		SpringApplication.run(TheGioiDiDongNhom7Application.class, args);
	}

}
