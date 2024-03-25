package net.kaba.ecomspring.repository;

import net.kaba.ecomspring.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,String> {
}
