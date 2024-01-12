package lk.ijse.semisterfinal.Dao.Custom.impl;

import lk.ijse.semisterfinal.DB.DbConnetion;
import lk.ijse.semisterfinal.Dao.Custom.CustomerDao;
import lk.ijse.semisterfinal.Dao.SqlUtil;
import lk.ijse.semisterfinal.dto.CusromerDTO;
import lk.ijse.semisterfinal.entity.CusromerEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDaoImpl implements CustomerDao {

    @Override
    public boolean add(CusromerEntity dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("INSERT INTO customer VALUES(?,?,?,?,?,?)",
                dto.getTxtCustId(),dto.getTxtCustAddress(),dto.getTxtCustName(),dto.getTxtCustMobile(),
                dto.getTxtCustitemId(),dto.getTxtCustPayment());

    }

    @Override
    public boolean update(CusromerEntity dto) throws SQLException,ClassNotFoundException {
        return SqlUtil.test("UPDATE customer SET customer_address = ?, customer_name = ?, customer_mobile = ?, item_id = ? , payment =?  WHERE customer_id = ?",
                dto.getTxtCustAddress(),dto.getTxtCustName(),dto.getTxtCustMobile(),dto.getTxtCustitemId(),
                dto.getTxtCustPayment(),dto.getTxtCustId());
    }

    @Override
    public boolean delete(CusromerEntity id) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("DELETE FROM customer WHERE customer_id = ?",id.getTxtCustId());
    }

    @Override
    public ArrayList<CusromerEntity> getAll() throws SQLException, ClassNotFoundException {

        ResultSet rst = SqlUtil.test("SELECT * FROM customer");
        ArrayList <CusromerEntity> getAllCustomer = new ArrayList<>();

        while (rst.next()) {
            CusromerEntity customerDTO = new CusromerEntity(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6));

            getAllCustomer.add(customerDTO);
        }

        return getAllCustomer;
    }

    public CusromerEntity searchCustomer(String id) throws SQLException {
        Connection connection = DbConnetion.getInstance().getConnection();

        String sql = "SELECT * FROM customer WHERE customer_id = ? ";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, id);

        ResultSet resultSet = pstm.executeQuery();

        CusromerEntity dto = null;

        if (resultSet.next()){
            String cust_id = resultSet.getString(1);
            String cust_address = resultSet.getString(2);
            String cust_name = resultSet.getString(3);
            String cust_mobile = resultSet.getString(4);
            String payment = resultSet.getString(5);

            dto = new CusromerEntity(cust_id,cust_address,cust_name,cust_mobile,payment);
        }
        return dto;
    }


}
