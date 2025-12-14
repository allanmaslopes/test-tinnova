package com.br.tinnova.model.dto;

public class CarsCountByMakeDTO {

    private String make;
    private Long carsCount;

    public CarsCountByMakeDTO() {
    }

    public CarsCountByMakeDTO(String make, Long carsCount) {
        this.make = make;
        this.carsCount = carsCount;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public Long getCarsCount() {
        return carsCount;
    }

    public void setCarsCount(Long carsCount) {
        this.carsCount = carsCount;
    }
}
