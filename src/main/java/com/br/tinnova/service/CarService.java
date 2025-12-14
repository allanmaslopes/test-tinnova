package com.br.tinnova.service;

import com.br.tinnova.model.Car;
import com.br.tinnova.model.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;


public interface CarService {

    Page<CarResponseDTO> findAll(Pageable pageable);

    Page<CarResponseDTO> findCarsByMakeAndModelYearAndColor(String make, String year, String color, Pageable pageable);

    Optional<CarDetailsDTO> getOneCar(Long id);

    CarDetailsDTO save(CarRequestDTO car) throws Exception;

    CarDetailsDTO update(CarRequestDTO car);

    CarsCountByMakeDTO countCarsByMake(String make);

    Page<CarResponseDTO> filterCarsByPrice(Double minPrice, Double maxPrice, Pageable pageable);

    void delete(CarDetailsDTO car);

    CarDetailsDTO patchUpdate(CarPatchRequestDTO car);
}
