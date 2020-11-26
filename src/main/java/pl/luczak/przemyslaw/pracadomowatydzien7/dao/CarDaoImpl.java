package pl.luczak.przemyslaw.pracadomowatydzien7.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.luczak.przemyslaw.pracadomowatydzien7.model.Car;

import java.util.List;
import java.util.Optional;

@Repository
public class CarDaoImpl implements CarDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CarDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Car> getCars() {
        String sql = "SELECT * FROM Cars";
        List<Car> cars = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Car.class));
        return cars;
    }

    @Override
    public Optional<Car> getCar(long id) {
        String sql = "SELECT * FROM Cars WHERE car_id = ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Car.class), id).stream().findAny();
    }

    @Override
    public void addCar(Car car) {
        String sql = "INSERT INTO Cars VALUES (?,?,?,?,?)";
        jdbcTemplate.update(sql, car.getId(), car.getMark(), car.getModel(), car.getColor(), car.getYear());
    }

    @Override
    public List<Car> findCarsBetween(String from, String to) {
        String sql = "SELECT * FROM Cars WHERE year BETWEEN ? AND ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Car.class), from, to);
    }
}
