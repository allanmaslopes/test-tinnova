package com.br.tinnova.service;

import com.br.tinnova.model.Car;
import com.br.tinnova.model.dto.CarsCountByMakeDto;
import com.br.tinnova.repository.CarsRepositoy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService{

    @Autowired
    private CarsRepositoy carsRepositoy;

    @Override
    public Page<Car> findAll(Pageable pageable) {
        return carsRepositoy.findAll(pageable);
    }

    @Override
    public Page<List<Car>> findCarsByMakeAndYearAndColor(String make, String year, String color) {
        return null;
    }

    @Override
    public Optional<Car> getOneCar(Long id) {
        return Optional.empty();
    }

    @Override
    public Car save(Car car) {
        return null;
    }

    @Override
    public Car update(Car car) {
        return null;
    }

    @Override
    public Car delete(Long id) {
        return null;
    }

    @Override
    public Page<List<CarsCountByMakeDto>> countCarsByMake() {
        return null;
    }

    @Override
    public Page<List<Car>> filterCarsByPrice(Double minPrice, Double maxPrice) {
        return null;
    }
}
