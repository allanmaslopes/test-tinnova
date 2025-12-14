package com.br.tinnova.repository;

import com.br.tinnova.model.Car;
import com.br.tinnova.model.dto.CarsCountByMakeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarsRepository extends JpaRepository<Car, Long> {

    Page<Car> findAllByMakeAndModelYearAndColorAndActive(String make, String year, String color, Boolean active, Pageable pageable);

    @Query(value = "SELECT * FROM tb_car as c WHERE c.price >= ?1 AND c.price <= ?2 AND c.active = ?3", nativeQuery = true)
    Page<Car> findAllSortedByPrice(Double minPrice, Double maxPrice, Boolean active, Pageable pageable);

    Long countAllByMakeAndActive(String make, Boolean active);

    Optional<Car> findByPlate(String plate);

    Page<Car> findAllByActive(Boolean active,Pageable pageable);

    Optional<Car> findByIdAndActive(Long id, Boolean active);

    Optional<Car> findByIdAndPlate(String plate, Long carId);
}
