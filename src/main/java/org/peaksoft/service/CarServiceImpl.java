package org.peaksoft.service;


import org.peaksoft.model.Car;
import org.peaksoft.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarServiceImpl implements Service<Car> {
    public void createTable() {
        String query = """
                CREATE TABLE cars(
                    id              SERIAL PRIMARY KEY,
                    model           VARCHAR NOT NULL,
                    year_of_Release DATE,
                    color           VARCHAR )
                """;
        Connection connection = Util.getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.execute(query);
        } catch (SQLException e) {
            System.out.println("Ошибка при удалении таблицы: " + e.getMessage());

        }
    }

    public void dropTable() throws SQLException {
        String query = "DROP TABLE cars;";
        Connection connection = Util.getConnection();
        Statement statement = connection.createStatement();
        statement.execute(query);
        statement.close();
    }

    public void save(Car car) throws SQLException {
        String query = "INSERT INTO cars(model,year_of_Release,color)" +
                "VALUES (?,?,?)";
        Connection connection = Util.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, car.getModel());
        preparedStatement.setDate(2, Date.valueOf(car.getYearOfRelease()));
        preparedStatement.setString(3, car.getColor());
        preparedStatement.execute();
    }

    public void removeById(long id) throws SQLException {
        String query = "DELETE FROM cars WHERE id=" + id;
        Connection connection = Util.getConnection();
        Statement statement = connection.createStatement();
        statement.execute(query);
        statement.close();
    }

    public List<Car> getAll() throws SQLException {
        String query = "SELECT * FROM cars;";
        List<Car> list = new ArrayList<>();

        Connection connection = Util.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            Car car = new Car();
            car.setId(resultSet.getLong("id"));
            car.setModel(resultSet.getString("model"));
            car.setColor(resultSet.getString("color"));
            car.setYearOfRelease(resultSet.getDate("year_of_Release").toLocalDate());
            list.add(car);
        }
        return list;
    }

    public void cleanTable() throws SQLException {
        String query = "DELETE FROM cars;";
        Connection connection = Util.getConnection();
        Statement statement = connection.createStatement();
        statement.execute(query);
        statement.close();
    }

    public Car getById(long id) throws SQLException {
        String query = "SELECT * FROM users WHERE id = ?";
        Car car = new Car();
        Connection connection = Util.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setLong(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            car = new Car();
            car.setId(resultSet.getLong("id"));
            car.setModel(resultSet.getString("model"));
            car.setColor(resultSet.getString("color"));
            car.setYearOfRelease(resultSet.getDate("year_of_Release").toLocalDate());
        }
        return car;
    }
}
