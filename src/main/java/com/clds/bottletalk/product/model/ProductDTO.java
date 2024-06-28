package com.clds.bottletalk.product.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Long id;
    private String name;
    private String img;
    private int price;
    private String country;

//    public ProductDTO() {
//    }
//
//    public ProductDTO(Integer id, String name, String img, int price, String country) {
//        this.id = id;
//        this.name = name;
//        this.img = img;
//        this.price = price;
//        this.country = country;
//    }
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getImg() {
//        return img;
//    }
//
//    public void setImg(String img) {
//        this.img = img;
//    }
//
//    public int getPrice() {
//        return price;
//    }
//
//    public void setPrice(int price) {
//        this.price = price;
//    }
//
//    public String getCountry() {
//        return country;
//    }
//
//    public void setCountry(String country) {
//        this.country = country;
//    }
//
//    @Override
//    public String toString() {
//        return "ProductDTO{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", img='" + img + '\'' +
//                ", price=" + price +
//                ", country='" + country + '\'' +
//                '}';
//    }
}
