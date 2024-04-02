package org.peaksoft.service;

import java.sql.SQLException;
import java.util.List;

public interface Service<T> {

    void createTable() throws SQLException;

    void dropTable() throws SQLException;

    void save(T t) throws SQLException;

    void removeById(long id) throws SQLException;

    List<T> getAll() throws SQLException;

    void cleanTable() throws SQLException;
    T getById(long id) throws SQLException;

}

