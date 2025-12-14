package com.br.tinnova.model.dto;


import com.br.tinnova.model.Car;

public class CarDetailsDTO {

    private Long id;
    private String model;
    private String make;
    private String plate;
    private Double price;
    private String color;
    private Integer modelYear;

    public CarDetailsDTO() {
    }

    public CarDetailsDTO(Long id, String plate, String model, String make, Double price, Integer modelYear, String color) {
        this.id = id;
        this.plate = plate;
        this.model = model;
        this.make = make;
        this.price = price;
        this.modelYear = modelYear;
        this.color = color;
    }

    public CarDetailsDTO(Car car) {
        this.id = car.getId();
        this.model = car.getModel();
        this.make = car.getMake();
        this.plate = car.getPlate();
        this.price = car.getPrice();
        this.color = car.getColor();
        this.modelYear = car.getModelYear();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
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

    public Integer getModelYear() {
        return modelYear;
    }

    public void setModelYear(Integer modelYear) {
        this.modelYear = modelYear;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
