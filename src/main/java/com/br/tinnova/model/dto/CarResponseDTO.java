package com.br.tinnova.model.dto;

import com.br.tinnova.model.Car;

public class CarResponseDTO {

    private Long id;

    private String model;

    private String make;

    private Double price;

    private Integer year;

    private String color;

    public CarResponseDTO() {
    }

    public CarResponseDTO(Long id, String model, String make, Double price, Integer year, String color) {
        this.id = id;
        this.model = model;
        this.make = make;
        this.price = price;
        this.year = year;
        this.color = color;
    }

    public CarResponseDTO(Car car) {
        this.id = car.getId();
        this.model = car.getModel();
        this.make = car.getMake();
        this.price = car.getPrice();
        this.year = car.getModelYear();
        this.color = car.getColor();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
