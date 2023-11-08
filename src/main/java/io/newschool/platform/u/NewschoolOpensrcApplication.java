package io.newschool.platform.u;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class NewschoolOpensrcApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewschoolOpensrcApplication.class, args);
    }

}
