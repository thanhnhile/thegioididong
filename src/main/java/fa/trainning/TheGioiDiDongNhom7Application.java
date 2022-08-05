package fa.trainning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories("fa.trainning.repository")
@EntityScan(basePackages = { "fa.trainning.entity" })
@EnableJpaAuditing
public class TheGioiDiDongNhom7Application {

	public static void main(String[] args) {
		SpringApplication.run(TheGioiDiDongNhom7Application.class, args);
	}

}
