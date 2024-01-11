package lk.ijse.semisterfinal.Dao.Custom.impl;

import lk.ijse.semisterfinal.DB.DbConnetion;
import lk.ijse.semisterfinal.Dao.Custom.CashiyerDao;
import lk.ijse.semisterfinal.Dao.Custom.ItemDao;
import lk.ijse.semisterfinal.Dao.Custom.OderDetailsDao;
import lk.ijse.semisterfinal.Dao.Custom.OrderDao;
import lk.ijse.semisterfinal.Tm.CartTm;
import lk.ijse.semisterfinal.dto.CashiyerDTO;
import lk.ijse.semisterfinal.dto.ItemDTO;
import lk.ijse.semisterfinal.dto.PlaceOrderDto;


import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CashiyerDaoImpl implements CashiyerDao {

    private static OrderDao orderDao = new OrderDaoImpl();
    private static ItemDao itemDao = new ItemDaoImpl();
    private static OderDetailsDao oDetails = new OrderDetailsDaoImpl();


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

    @Override
    public ArrayList<CashiyerDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean add(CashiyerDTO cashiyerDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(CashiyerDTO cashiyerDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(CashiyerDTO cashiyerDTO) throws SQLException, ClassNotFoundException {
        return false;
    }
}
