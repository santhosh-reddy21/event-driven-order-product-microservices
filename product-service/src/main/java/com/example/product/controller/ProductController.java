
package com.example.product.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.product.repo.ProductRepository;
import com.example.product.model.Product;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository repo;

    public ProductController(ProductRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return repo.save(product);
    }

    @GetMapping
    public List<Product> getAll() {
        return repo.findAll();
    }
}
