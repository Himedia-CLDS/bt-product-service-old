package com.clds.bottletalk.product.controller;


import com.clds.bottletalk.common.ResponseDTO;
import com.clds.bottletalk.product.model.ProductDTO;
import com.clds.bottletalk.product.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ResponseDTO> getProduct(@PathVariable("productId") long productId){
        ProductDTO productDTO = productService.findProductByProductId(productId);

        System.out.println(productDTO);

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"조회성공",productDTO));




    }










}
