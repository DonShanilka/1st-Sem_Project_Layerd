package lk.ijse.semisterfinal.Dao.Custom;


import java.sql.*;
import java.time.LocalDate;

public interface OrderDao {

    boolean saveOrder(String orderId, String customerId, LocalDate date) throws SQLException, ClassNotFoundException;

    String getLastId() throws SQLException;

}
