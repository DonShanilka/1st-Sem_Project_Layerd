package lk.ijse.semisterfinal.Dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO<T> extends SupperDAO{

    ArrayList<T> getAll() throws SQLException, ClassNotFoundException;

    boolean add(T t) throws SQLException, ClassNotFoundException;

    boolean update(T t) throws SQLException, ClassNotFoundException;

    boolean delete(T t) throws SQLException, ClassNotFoundException;
}
