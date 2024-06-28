package com.clds.bottletalk.product.service;

import com.clds.bottletalk.product.model.Product;
import com.clds.bottletalk.product.model.ProductDTO;
import com.clds.bottletalk.product.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductService{

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductService(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    public ProductDTO findProductByProductId(long productId) {

        Product product = productRepository.findById(productId).get();
        ProductDTO productDTO = modelMapper.map(product, ProductDTO.class);

        return productDTO;

    }
}
