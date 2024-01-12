package lk.ijse.semisterfinal.Dao.Custom;


import lk.ijse.semisterfinal.Dao.CrudDAO;
import lk.ijse.semisterfinal.dto.Tm.CartTm;
import lk.ijse.semisterfinal.dto.PlaceOrderDto;

import java.sql.SQLException;
import java.util.List;

public interface OderDetailsDao extends CrudDAO<PlaceOrderDto> {

    boolean saveOrderDetails(String orderId, List<CartTm> cartTmList) throws SQLException, ClassNotFoundException;

    boolean saveOrderDetails(String orderId, CartTm tm) throws SQLException, ClassNotFoundException;

}
