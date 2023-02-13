package com.example.sprsecurity.mappers;


import com.example.sprsecurity.dtos.ProductDto;
import com.example.sprsecurity.models.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product toProduct(ProductDto productDto);
    ProductDto toProductDto(Product product);

}
