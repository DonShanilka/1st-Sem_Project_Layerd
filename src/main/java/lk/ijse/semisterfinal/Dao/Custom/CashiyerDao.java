package lk.ijse.semisterfinal.Dao.Custom;

import lk.ijse.semisterfinal.Dao.CrudDAO;
import lk.ijse.semisterfinal.dto.CashiyerDTO;
import lk.ijse.semisterfinal.dto.PlaceOrderDto;
import lk.ijse.semisterfinal.entity.CashiyerEntity;

import java.sql.SQLException;

public interface CashiyerDao extends CrudDAO<CashiyerEntity> {

    boolean placeOrder(CashiyerEntity placeOrderDto) throws SQLException;

}
