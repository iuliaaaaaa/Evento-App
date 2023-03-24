package evento;

import evento.business.impl.CreateUserUseCaseImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication()
@EnableJpaRepositories("evento.repository")
@ComponentScan(basePackageClasses = CreateUserUseCaseImpl.class)
@ComponentScan(basePackages = {"evento.repository"})
@EntityScan({"evento.persistance.entity"})
public class EventoApplication {

    public static void main(String[] args) {

        SpringApplication.run(EventoApplication.class, args);
    }

}
