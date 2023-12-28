package lk.ijse.semisterfinal.Dao.Custom.impl;

import lk.ijse.semisterfinal.DB.DbConnetion;
import lk.ijse.semisterfinal.Dao.Custom.CustomerDao;
import lk.ijse.semisterfinal.dto.CusromerDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public boolean AddCustomer(CusromerDTO dto) throws SQLException {
        Connection connection = DbConnetion.getInstance().getConnection();

        String sql = "INSERT INTO customer VALUES(?,?,?,?,?,?)";
        PreparedStatement ptm = connection.prepareStatement(sql);

        ptm.setString(1, dto.getTxtCustId());
        ptm.setString(2, dto.getTxtCustAddress());
        ptm.setString(3, dto.getTxtCustName());
        ptm.setString(4, dto.getTxtCustMobile());
        ptm.setString(5, dto.getTxtCustitemId());
        ptm.setString(6, dto.getTxtCustPayment());

        return ptm.executeUpdate()>0;
    }
    @Override
    public boolean deleteCustomer(String id) throws SQLException {
        Connection connection = DbConnetion.getInstance().getConnection();

        String sql = "DELETE FROM customer WHERE customer_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, id);

        return pstm.executeUpdate() > 0;
    }
    @Override
    public boolean updateCustomer(CusromerDTO dto) throws SQLException {
        Connection connection = DbConnetion.getInstance().getConnection();

        String sql = "UPDATE customer SET customer_address = ?, customer_name = ?, customer_mobile = ?, item_id = ? , payment =?  WHERE customer_id = ?";

        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1,dto.getTxtCustAddress());
        pstm.setString(2,dto.getTxtCustName());
        pstm.setString(3,dto.getTxtCustMobile());
        pstm.setString(4, dto.getTxtCustitemId());
        pstm.setString(5, dto.getTxtCustPayment());
        pstm.setString(6, dto.getTxtCustId());

        return pstm.executeUpdate() >0;

    }

}
