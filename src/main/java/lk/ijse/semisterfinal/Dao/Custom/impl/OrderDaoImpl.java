package lk.ijse.semisterfinal.Dao.Custom.impl;

import lk.ijse.semisterfinal.DB.DbConnetion;
import lk.ijse.semisterfinal.Dao.Custom.OrderDao;
import lk.ijse.semisterfinal.Dao.SqlUtil;
import lk.ijse.semisterfinal.dto.PlaceOrderDto;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class OrderDaoImpl implements OrderDao {

    @Override
    public boolean saveOrder(String orderId, String customerId, LocalDate date) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("INSERT INTO orders VALUES(?,?,?)",orderId,customerId,date);

    }

    @Override
    public String getLastId() throws SQLException {
        Connection connection = DbConnetion.getInstance().getConnection();

        String sql = "SELECT order_id FROM orders ORDER BY order_id DESC LIMIT 1";
        PreparedStatement pstm = connection.prepareStatement(sql);

        ResultSet resultSet = pstm.executeQuery();
        if(resultSet.next()) {
            return (resultSet.getString(1));
        }
        return null;
    }

    @Override
    public ArrayList<PlaceOrderDto> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean add(PlaceOrderDto placeOrderDto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(PlaceOrderDto placeOrderDto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(PlaceOrderDto placeOrderDto) throws SQLException, ClassNotFoundException {
        return false;
    }
}
