package lk.ijse.semisterfinal.Dao.Custom.impl;

import lk.ijse.semisterfinal.DB.DbConnetion;
import lk.ijse.semisterfinal.Dao.Custom.OrderDao;
import lk.ijse.semisterfinal.Dao.SqlUtil;

import java.sql.*;
import java.time.LocalDate;

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

}
