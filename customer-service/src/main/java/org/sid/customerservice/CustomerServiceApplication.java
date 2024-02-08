package org.sid.customerservice;

import org.sid.customerservice.entities.Customer;
import org.sid.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(CustomerRepository customerRepository, RepositoryRestConfiguration restConfiguration){
        return args -> {
            restConfiguration.exposeIdsFor(Customer.class);

            customerRepository.saveAll(
                    List.of(
                            Customer.builder().name("Thali").email("thali@outlook.fr").build(),
                            Customer.builder().name("Neph").email("neph@outlook.fr").build(),
                            Customer.builder().name("Tuto").email("tuto@outlook.fr").build()

                    )
            );

        customerRepository.findAll().forEach(c->{
            System.out.println(c);
                }
                );

        };
    }


}

