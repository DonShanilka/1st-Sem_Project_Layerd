package lk.ijse.semisterfinal.Bo.Custom;

import lk.ijse.semisterfinal.Bo.SupperBo;
import lk.ijse.semisterfinal.dto.PlaceOrderDto;

import java.sql.SQLException;

public interface CashiyerBo extends SupperBo {

    boolean placeOrder(PlaceOrderDto placeOrderDto) throws SQLException;

}
