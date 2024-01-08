package lk.ijse.semisterfinal.Dao.Custom.impl;

import lk.ijse.semisterfinal.Dao.Custom.OderDetailsDao;
import lk.ijse.semisterfinal.Dao.SqlUtil;
import lk.ijse.semisterfinal.Tm.CartTm;
import java.sql.SQLException;
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

}
