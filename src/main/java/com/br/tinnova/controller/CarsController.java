package com.br.tinnova.controller;

import com.br.tinnova.model.Car;
import com.br.tinnova.model.dto.*;
import com.br.tinnova.service.CarService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/cars")
@Tag(name = "Veiculos")
public class CarsController {

    @Autowired
    private CarService carService;

    @PreAuthorize("hasRole('ADMIN','USER')")
    @GetMapping
    private ResponseEntity<Page<CarResponseDTO>> allCars(
           Pageable pageable
    ) {

        Page<CarResponseDTO> carsPageable = carService.findAll(pageable);

        if (carsPageable.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok().body(carsPageable);
        }
    }

    @GetMapping("/filter")
    private ResponseEntity<Page<CarResponseDTO>> carsByMakeAndModelYearAndColor(
            @RequestParam(name = "make", required = false) String make,
            @RequestParam(name = "modelYear", required = false) String modelYear,
            @RequestParam(name = "color", required = false) String color,
            Pageable pageable

    ){
        Page<CarResponseDTO> carsFiltered = carService.findCarsByMakeAndModelYearAndColor(
                make.toUpperCase(),
                modelYear.toUpperCase(),
                color.toUpperCase(),
                pageable
        );

        if (carsFiltered.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok().body(carsFiltered);
        }
    }

    @GetMapping("/filteredByPrice")
    private ResponseEntity<Page<CarResponseDTO>> carsByPrice(
            @RequestParam(name = "minPrice", required = false, defaultValue = "0") Double minPrice,
            @RequestParam(name = "maxPrice") Double maxPrice,
            Pageable pageable
    ){
        Page<CarResponseDTO> carsFiltered = carService.filterCarsByPrice(minPrice, maxPrice, pageable);

        if (carsFiltered.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok().body(carsFiltered);
        }
    }

    @GetMapping("/countByMake")
    private ResponseEntity<CarsCountByMakeDTO> carsCountByMake(
            @RequestParam(name = "make") String make
    ){
        CarsCountByMakeDTO carsCountByMake = carService.countCarsByMake(make.toUpperCase());
        return ResponseEntity.ok(carsCountByMake);
    }

    @GetMapping("/{id}")
    private ResponseEntity<CarDetailsDTO> getOneCar(@PathVariable Long id){
        Optional<CarDetailsDTO> car = carService.getOneCar(id);

        if (car.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(car.get());
        }
    }

    @PostMapping("/save")
    private ResponseEntity<Object> save(@RequestBody CarRequestDTO car) {
        try {
            return ResponseEntity.created(null).body(carService.save(car));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @PutMapping("/update")
    private ResponseEntity<Object> update(@RequestBody CarRequestDTO car){

        Optional<CarDetailsDTO> carValidation = carService.getOneCar(car.getId());

        if (carValidation.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        try {
            CarDetailsDTO responseCar = carService.update(car);
            return ResponseEntity.created(null).body(responseCar);
        } catch (RuntimeException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }

    }

    @PatchMapping("/patch")
    private ResponseEntity<Object> patch(@RequestBody CarPatchRequestDTO car){

        Optional<CarDetailsDTO> carValidation = carService.getOneCar(car.getId());

        if (carValidation.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        try {
            CarDetailsDTO responseCar = carService.patchUpdate(car);
            return ResponseEntity.created(null).body(responseCar);
        } catch (Exception ex) {
           return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }

    @DeleteMapping("/delete/{idCar}")
    private ResponseEntity<Car> delete(@PathVariable Long idCar){
        Optional<CarDetailsDTO> carValidation = carService.getOneCar(idCar);

        if (carValidation.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            carService.delete(carValidation.get());
            return ResponseEntity.accepted().build();
        }
    }


}
