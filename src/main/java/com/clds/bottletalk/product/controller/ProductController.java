package com.clds.bottletalk.product.controller;


import com.clds.bottletalk.common.ResponseDTO;
import com.clds.bottletalk.product.model.ProductDTO;
import com.clds.bottletalk.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/products")
@Slf4j
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ResponseDTO> getProduct(@PathVariable("productId") long productId){
        ProductDTO productDTO = productService.findProductByProductId(productId);

        System.out.println(productDTO);
        LocalDateTime localDateTime = LocalDateTime.now();
        log.info("Welcome home Page " + localDateTime);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"조회성공",productDTO));

    }


    @GetMapping()
    public ResponseEntity<ResponseDTO> getProductList(@RequestParam(name = "search", defaultValue = "") String search){

        List<ProductDTO> productDTOList = productService.findProductList(search);

        System.out.println(productDTOList);
        log.info(search + " : " + LocalDateTime.now());
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK,"조회성공",productDTOList));

    }












}
