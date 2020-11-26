package pl.luczak.przemyslaw.pracadomowatydzien7.database;

import org.springframework.stereotype.Component;
import pl.luczak.przemyslaw.pracadomowatydzien7.dao.CarDao;
import pl.luczak.przemyslaw.pracadomowatydzien7.model.Car;

@Component
public class DBInit {

    private CarDao carDao;

    public DBInit(CarDao carDao) {
        this.carDao = carDao;
//        carDao.addCar(new Car(3L, "Audi", "A4", "black", "2001"));
//        carDao.addCar(new Car(4L, "BMW", "X5", "red", "2020"));
//        carDao.addCar(new Car(5L, "Opel", "Corsa", "white", "2015"));
    }
}
