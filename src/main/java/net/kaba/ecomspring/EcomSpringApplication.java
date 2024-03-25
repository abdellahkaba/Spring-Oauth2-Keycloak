package net.kaba.ecomspring;

import net.kaba.ecomspring.entities.Product;
import net.kaba.ecomspring.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class EcomSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcomSpringApplication.class, args);
    }

    @Bean
    CommandLineRunner start (ProductRepository productRepository){
        return args -> {
            productRepository.save(Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("Ordinateurs")
                    .price(900)
                    .quantity(12)
                    .build());
            productRepository.save(Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("Iphone")
                    .price(1000)
                    .quantity(30)
                    .build());
            productRepository.save(Product.builder()
                    .id(UUID.randomUUID().toString())
                    .name("Habits")
                    .price(400)
                    .quantity(40)
                    .build());
        };
    }

}
