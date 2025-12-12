package com.br.tinnova.repository;

import com.br.tinnova.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsRepositoy extends JpaRepository<Car, Integer> {
}
