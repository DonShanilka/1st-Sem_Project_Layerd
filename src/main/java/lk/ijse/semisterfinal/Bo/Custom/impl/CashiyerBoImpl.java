package lk.ijse.semisterfinal.Bo.Custom.impl;

import javafx.scene.control.TextField;
import lk.ijse.semisterfinal.Bo.Custom.CashiyerBo;
import lk.ijse.semisterfinal.DB.DbConnetion;
import lk.ijse.semisterfinal.Dao.Custom.ItemDao;
import lk.ijse.semisterfinal.Dao.Custom.OderDetailsDao;
import lk.ijse.semisterfinal.Dao.Custom.OrderDao;
import lk.ijse.semisterfinal.Dao.Custom.impl.ItemDaoImpl;
import lk.ijse.semisterfinal.Dao.Custom.impl.OrderDaoImpl;
import lk.ijse.semisterfinal.Dao.Custom.impl.OrderDetailsDaoImpl;
import lk.ijse.semisterfinal.Dao.DaoFactory;
import lk.ijse.semisterfinal.dto.ItemDTO;
import lk.ijse.semisterfinal.dto.PlaceOrderDto;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;

public class CashiyerBoImpl implements CashiyerBo {

    private static OrderDao orderDao = (OrderDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DaoTyps.ORDERS);
    private static ItemDao itemDao = (ItemDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DaoTyps.ITEM);
    private static OderDetailsDao oDetails = (OderDetailsDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DaoTyps.ORDERDETAIL);


    public boolean placeOrder(PlaceOrderDto placeOrderDto) throws SQLException {
        System.out.println(placeOrderDto);

        String orderId = placeOrderDto.getOrderId();
        String customerId = placeOrderDto.getCustomerId();
        LocalDate date = placeOrderDto.getDate();

        Connection connection = null;
        try {
            connection = DbConnetion.getInstance().getConnection();
            connection.setAutoCommit(false);

            boolean isOrderSaved = orderDao.saveOrder(orderId, customerId, date);
            if (isOrderSaved) {
                boolean isUpdated = itemDao.update(placeOrderDto.getCartTmList());
                if (isUpdated) {
                    boolean isOrderDetailSaved = oDetails.saveOrderDetails(placeOrderDto.getOrderId(), placeOrderDto.getCartTmList());
                    if (isOrderDetailSaved)
                        connection.commit();

                }
            }
            connection.rollback();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            connection.setAutoCommit(true);
        }
        return true;
    }

}
