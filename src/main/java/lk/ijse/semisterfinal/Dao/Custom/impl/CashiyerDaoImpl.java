package lk.ijse.semisterfinal.Dao.Custom.impl;

import lk.ijse.semisterfinal.DB.DbConnetion;
import lk.ijse.semisterfinal.Dao.Custom.CashiyerDao;
import lk.ijse.semisterfinal.Dao.Custom.ItemDao;
import lk.ijse.semisterfinal.Dao.Custom.OderDetailsDao;
import lk.ijse.semisterfinal.Dao.Custom.OrderDao;
import lk.ijse.semisterfinal.dto.CashiyerDTO;
import lk.ijse.semisterfinal.dto.PlaceOrderDto;
import lk.ijse.semisterfinal.entity.CashiyerEntity;
import lk.ijse.semisterfinal.entity.PlaceOrderEntity;


import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class CashiyerDaoImpl implements CashiyerDao {

    private static OrderDao orderDao = new OrderDaoImpl();
    private static ItemDao itemDao = new ItemDaoImpl();
    private static OderDetailsDao oDetails = new OrderDetailsDaoImpl();


    public boolean placeOrder(PlaceOrderEntity placeOrderDto) throws SQLException {
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
    public ArrayList<CashiyerEntity> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean add(CashiyerEntity cashiyerDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(CashiyerEntity cashiyerDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(CashiyerEntity cashiyerDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean placeOrder(CashiyerEntity placeOrderDto) throws SQLException {
        return false;
    }
}
