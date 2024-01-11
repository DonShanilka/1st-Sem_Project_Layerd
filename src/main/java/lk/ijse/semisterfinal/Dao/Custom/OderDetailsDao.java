package lk.ijse.semisterfinal.Dao.Custom;


import lk.ijse.semisterfinal.Tm.CartTm;
import java.sql.SQLException;
import java.util.List;

public interface OderDetailsDao  {

    boolean saveOrderDetails(String orderId, List<CartTm> cartTmList) throws SQLException, ClassNotFoundException;

    boolean saveOrderDetails(String orderId, CartTm tm) throws SQLException, ClassNotFoundException;

}
