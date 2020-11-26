package pl.luczak.przemyslaw.pracadomowatydzien7.dao;

import pl.luczak.przemyslaw.pracadomowatydzien7.model.Car;

import java.util.List;
import java.util.Optional;

public interface CarDao {
    List<Car> getCars();
    Optional<Car> getCar(long id);
    void addCar(Car car);
    List<Car> findCarsBetween(String from, String to);

}
