package lk.ijse.semisterfinal.Dao.Custom;

import lk.ijse.semisterfinal.Dao.CrudDAO;
import lk.ijse.semisterfinal.dto.CashiyerDTO;
import lk.ijse.semisterfinal.dto.PlaceOrderDto;

import java.sql.SQLException;

public interface CashiyerDao extends CrudDAO<CashiyerDTO> {

    boolean placeOrder(PlaceOrderDto placeOrderDto) throws SQLException;

}
