package com.example.sprsecurity.controllers;


import com.example.sprsecurity.dtos.ProductDto;
import com.example.sprsecurity.services.StoreService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/store")
@RequiredArgsConstructor
public class StoreController {

    private final StoreService storeService;

    @GetMapping
    public String helloStore() {
        return "Hello store!";
    }

    @GetMapping("/products")
    public String helloProducts() {
        return "Hello products!";
    }

    @GetMapping("/products/user/{id}")
    public ProductDto getById(@PathVariable Integer id) {
        if (id < 0) {
            log.info("Request denied, incorrect path variable!");
            throw new IllegalArgumentException("Invalid id");
        }
        return storeService.getProductById(id);
    }

    @GetMapping("/products/user")
    public List<ProductDto> getById() {
        return storeService.getProducts();
    }

    @DeleteMapping("/products/admin/{id}")
    public void deleteById(@PathVariable Integer id) {
        if (id < 0) {
            log.info("Request denied, incorrect path variable!");
            throw new IllegalArgumentException("Invalid id");
        }
        storeService.deleteProductById(id);
    }

    @PostMapping("/products/admin/{id}")
    public ProductDto addProduct(@RequestBody ProductDto productDto) {
        return storeService.addProduct(productDto);
    }

}
