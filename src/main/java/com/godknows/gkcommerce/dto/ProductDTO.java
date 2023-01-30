package com.godknows.gkcommerce.dto;

import com.godknows.gkcommerce.entities.Product;
import jakarta.validation.MessageInterpolator;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public class ProductDTO {

    private Long id;

    @NotBlank(message="Campo Obrigatório")
    @Size(min=3,max=80, message="Mínimo de 3 e Máximo de 80 caracteres.")
    private String name;

    @NotBlank(message="Campo Obrigatório")
    @Size(min=10, message="Mínimo de 10 caracteres.")
    private String description;

    @Positive(message="Valor tem de ser positivo.")
    private Double price;
    private String imgUrl;

    public ProductDTO(Long id, String name, String description, Double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public ProductDTO(Product entity) {
        id = entity.getId();
        name = entity.getName();
        description = entity.getDescription();
        price = entity.getPrice();
        imgUrl = entity.getImgUrl();
    }



    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }


    public String getDescription() {
        return description;
    }


    public Double getPrice() {
        return price;
    }


    public String getImgUrl() {
        return imgUrl;
    }


}
