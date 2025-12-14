package com.br.tinnova.model.dto;

public class CarPatchRequestDTO {

    private Long id;

    private Double price;

    private String color;

    public CarPatchRequestDTO() {
    }

    public CarPatchRequestDTO(Double price, String color) {
        this.price = price;
        this.color = color;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
