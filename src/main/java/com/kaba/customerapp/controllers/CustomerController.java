package com.kaba.customerapp.controllers;

import com.kaba.customerapp.entities.Customer;
import com.kaba.customerapp.repository.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class CustomerController {

    private CustomerRepository customerRepository ;

    //Une fonction qui affiche les customers
    @GetMapping("/customers")
    public String customers (Model model) {
        List<Customer> customerList = customerRepository.findAll() ;
        model.addAttribute("customers",customerList) ;
        return "customers" ;
    }
}
