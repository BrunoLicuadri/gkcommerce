package com.godknows.gkcommerce.dto;

import com.godknows.gkcommerce.entities.OrderItem;

public class OrderItemDTO {
    private Long productID;
    private String name;
    private Double price;
    private Integer quantity;

    public OrderItemDTO(Long productID, String name, Double price, Integer quantity) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public OrderItemDTO(OrderItem entity) {
        this.productID = entity.getProduct().getId();
        this.name = entity.getProduct().getName();
        this.price = entity.getPrice();
        this.quantity = entity.getQuantity();
    }

    public Long getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getSubtotal(){
        return quantity*price;
    }
}
