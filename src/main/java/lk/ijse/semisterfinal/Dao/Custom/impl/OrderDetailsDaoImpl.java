package lk.ijse.semisterfinal.Dao.Custom.impl;

import lk.ijse.semisterfinal.Dao.Custom.OderDetailsDao;
import lk.ijse.semisterfinal.Dao.SqlUtil;
import lk.ijse.semisterfinal.dto.Tm.CartTm;
import lk.ijse.semisterfinal.dto.PlaceOrderDto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailsDaoImpl implements OderDetailsDao {

    @Override
    public boolean saveOrderDetails(String orderId, List<CartTm> cartTmList) throws SQLException, ClassNotFoundException {
        for(CartTm tm : cartTmList) {
            if(!saveOrderDetails(orderId, tm)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean saveOrderDetails(String orderId, CartTm tm) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("INSERT INTO order_detail VALUES(?, ?, ?, ?)",orderId,tm.getItem_code(),tm.getQty(),tm.getUnit_price());
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
