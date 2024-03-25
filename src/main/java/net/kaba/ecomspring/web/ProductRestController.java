package net.kaba.ecomspring.web;

import lombok.AllArgsConstructor;
import net.kaba.ecomspring.entities.Product;
import net.kaba.ecomspring.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor

public class ProductRestController {

    private ProductRepository productRepository ;
    @GetMapping("/products")
    public List<Product> getAllProducts (){
        return productRepository.findAll();
    }

    @GetMapping("/products/{id}")
    public  Product getProductById(@PathVariable String id){
        return productRepository.findById(id).get() ;
    }

}
