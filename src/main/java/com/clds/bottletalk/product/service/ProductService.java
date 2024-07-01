package com.clds.bottletalk.product.service;

import com.clds.bottletalk.product.model.Product;
import com.clds.bottletalk.product.model.ProductDTO;
import com.clds.bottletalk.product.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<ProductDTO> findProductList(String search) {
        List<Product> ProductList = productRepository.findByNameContainingIgnoreCase(search);
        List<ProductDTO> ProductDTOList = ProductList.stream().map(product -> modelMapper.map(product,ProductDTO.class)).collect(Collectors.toList());

        return ProductDTOList;


    }
}
