package com.br.tinnova.service;

import com.br.tinnova.model.Car;
import com.br.tinnova.model.dto.CarsCountByMakeDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


public interface CarService {

    Page<Car> findAll(Pageable pageable);

    Page<List<Car>> findCarsByMakeAndYearAndColor(String make, String year, String color);

    Optional<Car> getOneCar(Long id);

    Car save(Car car);

    Car update(Car car);

    Car delete(Long id);

    Page<List<CarsCountByMakeDto>> countCarsByMake();

    Page<List<Car>> filterCarsByPrice(Double minPrice, Double maxPrice);
}
