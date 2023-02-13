package com.example.sprsecurity.services;


import com.example.sprsecurity.dtos.ProductDto;
import com.example.sprsecurity.mappers.ProductMapper;
import com.example.sprsecurity.models.Product;
import com.example.sprsecurity.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class StoreService {

    private final ProductRepository productRepository;

    public ProductDto getProductById(int id) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Product with id = " + id + " wasn`t found!")
        );
        return ProductMapper.INSTANCE.toProductDto(product);
    }

    public List<ProductDto> getProducts() {
        List<Product> products = (List<Product>) productRepository.findAll();
        return products.stream()
                .map(ProductMapper.INSTANCE::toProductDto)
                .collect(Collectors.toList());
    }

    public ProductDto addProduct(@NonNull ProductDto productDto) {
        Product product = ProductMapper.INSTANCE.toProduct(productDto);
        productRepository.save(product);
        productDto.setId(product.getId());
        log.info("Product with id = " + productDto.getId() + "was successfully added!");
        return productDto;
    }

    public void deleteProductById(int id) {
        productRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Product with id = " + id + " wasn`t found!")
        );
        productRepository.deleteById(id);
        log.info("Product with id = " + id + "was successfully deleted!");
    }



}
