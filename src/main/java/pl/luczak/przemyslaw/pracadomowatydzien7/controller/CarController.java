package pl.luczak.przemyslaw.pracadomowatydzien7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.luczak.przemyslaw.pracadomowatydzien7.dao.CarDao;
import pl.luczak.przemyslaw.pracadomowatydzien7.model.Car;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {

    private CarDao carDao;

    @Autowired
    public CarController(CarDao carDao) {
        this.carDao = carDao;
    }

    @GetMapping
    public ResponseEntity<List<Car>> getCars() {
        List<Car> cars = carDao.getCars();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCar(@PathVariable int id) {
        Optional<Car> car = carDao.getCar(id);
        return car.isPresent()
                ? new ResponseEntity(car, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/addCar")
    public ResponseEntity addCar(@RequestBody Car car) {
        carDao.addCar(car);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/{from}/{to}")
    public ResponseEntity<List<Car>> getCarsBetween(@PathVariable String from, @PathVariable String to) {
        List<Car> cars = carDao.findCarsBetween(from, to);
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }
}
