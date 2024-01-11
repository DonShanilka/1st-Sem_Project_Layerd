package lk.ijse.semisterfinal.Dao.Custom;


import lk.ijse.semisterfinal.Dao.CrudDAO;
import lk.ijse.semisterfinal.dto.CashiyerDTO;
import lk.ijse.semisterfinal.dto.PlaceOrderDto;

import java.sql.*;
import java.time.LocalDate;

public interface OrderDao extends CrudDAO<PlaceOrderDto> {

    boolean saveOrder(String orderId, String customerId, LocalDate date) throws SQLException, ClassNotFoundException;

    String getLastId() throws SQLException;

}
