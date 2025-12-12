package com.br.tinnova.controller;

import com.br.tinnova.model.Car;
import com.br.tinnova.model.dto.CarsCountByMakeDto;
import com.br.tinnova.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/cars")
public class CarsController {

    @Autowired
    private CarService carService;

    @GetMapping
    private ResponseEntity<Page<Car>> allCars(
           Pageable pageable
    ) {

        Page<Car> carsPageable = carService.findAll(pageable);

        if (carsPageable.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok().body(carsPageable);
        }
    }

    @GetMapping("/filter")
    private ResponseEntity<Page<List<Car>>> carsByMakeAndYearAndColor(
            @RequestParam("make") String make,
            @RequestParam("year") String year,
            @RequestParam("color") String color
    ){
        Page<List<Car>> carsFiltered = carService.findCarsByMakeAndYearAndColor(make, year, color);

        if (carsFiltered.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok().body(carsFiltered);
        }
    }

    @GetMapping("/sortedByPrice")
    private ResponseEntity<Page<List<Car>>> carsByPrice(
            @RequestParam("minPrice") Double minPrice,
            @RequestParam("maxPrice") Double maxPrice
    ){
        Page<List<Car>> carsFiltered = carService.filterCarsByPrice(minPrice, maxPrice);

        if (carsFiltered.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok().body(carsFiltered);
        }
    }

    @GetMapping("/countByMake")
    private ResponseEntity<Page<List<CarsCountByMakeDto>>> carsCountByMake(){

        Page<List<CarsCountByMakeDto>> carsCountByMakeList = carService.countCarsByMake();

        if (carsCountByMakeList.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(carsCountByMakeList);
        }

    }

    @GetMapping("/{id}")
    private ResponseEntity<Car> getOneCar(@PathVariable Long id){

        Optional<Car> car = carService.getOneCar(id);

        if (car.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(car.get());
        }
    }

    //ADMIN
    @PostMapping
    private ResponseEntity<Car> save(@RequestBody Car car) {

        Car responseCar = carService.save(car);

        if (responseCar == null) {
            return ResponseEntity.created(null).build();
        } else {
            return ResponseEntity.internalServerError().build();
        }
    }

    //ADMIN
    @PutMapping
    private ResponseEntity<Car> update(@RequestBody Car car){

        Optional<Car> carValidation = carService.getOneCar(car.getId());

        if (carValidation.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Car responseCar = carService.update(car);

        if (responseCar == null) {
            return ResponseEntity.created(null).build();
        } else {
            return ResponseEntity.internalServerError().build();
        }

    }

    //ADMIN
    @PatchMapping
    private ResponseEntity<Car> patch(@RequestBody Car car){
        Optional<Car> carValidation = carService.getOneCar(car.getId());

        if (carValidation.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Car responseCar = carService.update(car);

        if (responseCar == null) {
            return ResponseEntity.created(null).build();
        } else {
            return ResponseEntity.internalServerError().build();
        }

    }

    //ADMIN
    @DeleteMapping
    private ResponseEntity<Car> delete(@RequestBody Car car){
        Optional<Car> carValidation = carService.getOneCar(car.getId());

        if (carValidation.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            carService.delete(car.getId());
            return ResponseEntity.accepted().build();
        }
    }


}
