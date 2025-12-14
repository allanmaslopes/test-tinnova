package com.br.tinnova.model.dto;

public class CarRequestDTO {

    private Long id;

    private String plate;

    private String model;

    private String make;

    private Double price;

    private Integer modelYear;

    private String color;

    private Boolean active;

    public CarRequestDTO() {
    }

    public CarRequestDTO(Long id, String plate, String model, String make, Double price, Integer modelYear, String color, Boolean active) {
        this.id = id;
        this.plate = plate;
        this.model = model;
        this.make = make;
        this.price = price;
        this.modelYear = modelYear;
        this.color = color;
        this.active = active;
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
