package org.peaksoft;

import org.peaksoft.model.Car;
import org.peaksoft.model.User;
import org.peaksoft.service.CarServiceImpl;
import org.peaksoft.service.UserServiceImpl;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        // TODO: 27.09.2023   реализуйте алгоритм здесь
        LocalDate localDate = LocalDate.of(2000, 1, 1);
        UserServiceImpl userService = new UserServiceImpl();
        CarServiceImpl carService = new CarServiceImpl();

        userService.createTable();
        userService.save(new User("Jyldyz", "", (byte) 17, (long) 5667347));
        userService.save(new User("Sami", "Uraimjanova", (byte) 16, (long) 123456));
        userService.save(new User("Kanayim", "", (byte) 16, (long) 987654));

        carService.createTable();
        carService.save(new Car("BMW", localDate, "red"));
        carService.save(new Car("Mers",localDate,"black"));




    }
}
