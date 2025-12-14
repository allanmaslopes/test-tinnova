package com.br.tinnova.service;

import com.br.tinnova.model.Car;
import com.br.tinnova.model.dto.*;
import com.br.tinnova.repository.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarServiceImpl implements CarService{

    @Autowired
    private CarsRepository carsRepository;

    @Autowired
    private CheckUsdFallbackClient checkUsdFallbackClient;

    @Autowired
    private CheckUsdClient checkUsdClient;

    @Override
    public Page<CarResponseDTO> findAll(Pageable pageable) {
        return carsRepository.findAllByActive(true, pageable).map(car -> new CarResponseDTO(
                  car.getId(),
                  car.getModel(),
                  car.getMake(),
                  currencyBalance(car.getPrice(), "BRL"),
                  car.getModelYear(),
                  car.getColor()
          ));
    }

    @Override
    public Page<CarResponseDTO> findCarsByMakeAndModelYearAndColor(String make, String year, String color, Pageable pageable) {
        return carsRepository.findAllByMakeAndModelYearAndColorAndActive(make, year, color, true, pageable).map(car -> {
            return new CarResponseDTO(
                    car.getId(),
                    car.getModel(),
                    car.getMake(),
                    currencyBalance(car.getPrice(), "BRL"),
                    car.getModelYear(),
                    car.getColor()
            );
        });
    }

    @Override
    public Optional<CarDetailsDTO> getOneCar(Long id) {
       Optional<Car> carResponse = carsRepository.findByIdAndActive(id, true);

       Optional<CarDetailsDTO> car = Optional.empty();

         if (carResponse.isPresent()) {
             car = Optional.of(new CarDetailsDTO(
                     carResponse.get().getId(),
                     carResponse.get().getPlate(),
                     carResponse.get().getModel(),
                     carResponse.get().getMake(),
                     carResponse.get().getPrice(),
                     carResponse.get().getModelYear(),
                     carResponse.get().getColor()
             ));
         }

         return car;
    }

    @Override
    public Page<CarResponseDTO> filterCarsByPrice(Double minPrice, Double maxPrice, Pageable pageable) {

        Page<Car> carPageByPrice = carsRepository.findAllSortedByPrice(minPrice, maxPrice, true, pageable);

        return carPageByPrice.map(CarResponseDTO::new);
    }

    @Override
    public CarDetailsDTO save(CarRequestDTO car) throws RuntimeException {

        if (plateValidation(car.getPlate(), null)) {
            throw new RuntimeException("Placa de carro já cadastrada");
        }

       car.setPrice(currencyBalance(car.getPrice(), "USD"));
       Car carSaved = carsRepository.save(new Car(car));

       return new CarDetailsDTO(carSaved);
    }

    @Override
    public CarDetailsDTO update(CarRequestDTO carRequest) {

        if (plateValidation(carRequest.getPlate(), carRequest.getId())) {
            throw new RuntimeException("Placa de carro já cadastrada");
        }

        Car car = carsRepository.findById(carRequest.getId()).get();

        car.setPlate(carRequest.getPlate());
        car.setModel(carRequest.getModel());
        car.setMake(carRequest.getMake());
        car.setPrice(carRequest.getPrice());
        car.setModelYear(carRequest.getModelYear());
        car.setColor(carRequest.getColor());
        car.setActive(carRequest.getActive());

        carsRepository.save(car);

        return getOneCar(car.getId()).get();
    }

    @Override
    public CarDetailsDTO patchUpdate(CarPatchRequestDTO carRequest) {
        Car car = carsRepository.findById(carRequest.getId()).get();
        car.setColor(carRequest.getColor());
        car.setPrice(currencyBalance(carRequest.getPrice(), "USD"));
        carsRepository.save(car);
        return getOneCar(car.getId()).get();
    }

    @Override
    public void delete(CarDetailsDTO carRequest) {
        Optional<Car> car = carsRepository.findById(carRequest.getId());
        car.get().setActive(false);
        carsRepository.save(car.get());
    }

    @Override
    public CarsCountByMakeDTO countCarsByMake(String make) {
        return new CarsCountByMakeDTO(make, carsRepository.countAllByMakeAndActive(make, true));
    }

    private boolean plateValidation(String plate, Long carId) {
        if (carId == null) {
           return carsRepository.findByPlate(plate).isPresent();
        } else {
            Optional<Car> car = carsRepository.findById(carId);
            if (car.isPresent()) {
                return !car.get().getPlate().equals(plate);
            } else {
                return true;
            }
        }
    }

    public Double currencyBalance(Double price, String currency) {
        SearchUsdPriceDTO usdPrice = checkUsdClient.searchUSD("USD", "BRL");

        if (usdPrice == null) {
            SearchUsdFallbackPriceDTO usdFallBackPrice = checkUsdFallbackClient.searchUSD("USD", "BRL");
            double brlPriceFallBackPrice = usdFallBackPrice.getRates().get("BRL");
            if (currency.equals("USD")) {
                return price / brlPriceFallBackPrice;
            } else if (currency.equals("BRL")) {
                return price * brlPriceFallBackPrice;
            } else {
                return price;
            }
        }
            Double brlPrice = Double.parseDouble(usdPrice.getUsdBrl().getBid());
            if (currency.equals("USD")) {
                return price / brlPrice;
            } else if (currency.equals("BRL")) {
                return price * brlPrice;
            } else {
                return price;
            }
    }
}
