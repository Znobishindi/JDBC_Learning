package com.example.jdbc_learning.controller;


import com.example.jdbc_learning.repository.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    private final Repository repository;

    public Controller(Repository repository) {
        this.repository = repository;
    }


    @GetMapping("/products/fetch-product")
    public List<String> returnProductName(@RequestParam("name") String customerName) {
        return repository.returnProductNameByCustomerName(customerName);
    }
}
