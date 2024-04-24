package com.kaba.customerapp;

import com.kaba.customerapp.entities.Customer;
import com.kaba.customerapp.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerAppApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner (CustomerRepository customerRepository) {
        return args -> {
          Customer customer1 = new Customer() ;
          customer1.setName("Mohamed");
          customer1.setEmail(customer1.getName()+ customer1.getId() +"@gmail.com");
          Customer customer2 = new Customer() ;
          customer2.setName("Issa");
          customer2.setEmail(customer2.getName()+customer2.getId()+"@gmail.com");
          Customer customer3 = new Customer() ;
          customer3.setName("Mariam");
          customer3.setEmail(customer3.getName()+customer3.getId()+"@gmail.com");

          customerRepository.save(customer1) ;
          customerRepository.save(customer2);
          customerRepository.save(customer3);
        };
    }
}
