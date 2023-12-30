package lk.ijse.semisterfinal.Dao.Custom.impl;

import lk.ijse.semisterfinal.Dao.Custom.CustomerDao;
import lk.ijse.semisterfinal.Dao.SqlUtil;
import lk.ijse.semisterfinal.dto.CusromerDTO;
import lombok.Getter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerDaoImpl implements CustomerDao {

    @Override
    public boolean Add(CusromerDTO dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("INSERT INTO customer VALUES(?,?,?,?,?,?)",dto.getTxtCustId(),dto.getTxtCustAddress(),dto.getTxtCustName(),dto.getTxtCustMobile(),dto.getTxtCustitemId(),dto.getTxtCustPayment());

    }

    @Override
    public boolean update(CusromerDTO dto) throws SQLException,ClassNotFoundException {
        return SqlUtil.test("UPDATE customer SET customer_address = ?, customer_name = ?, customer_mobile = ?, item_id = ? , payment =?  WHERE customer_id = ?",dto.getTxtCustAddress(),dto.getTxtCustName(),dto.getTxtCustMobile(),dto.getTxtCustitemId(),dto.getTxtCustPayment(),dto.getTxtCustId());
    }

    @Override
    public boolean delete(CusromerDTO id) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("DELETE FROM customer WHERE customer_id = ?",id);
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("DELETE FROM customer WHERE customer_id = ?",id);
    }

    @Override
    public ArrayList<CusromerDTO> getAll() throws SQLException, ClassNotFoundException {
        ResultSet rst = SqlUtil.test("SELECT * FROM customer");

        ArrayList <CusromerDTO> getAllCustomer = new ArrayList<>();
        while (rst.next()) {
            CusromerDTO customerDTO = new CusromerDTO(

                    rst.getString("txtCustId"),
                    rst.getString("txtCustAddress"),
                    rst.getString("txtCustName"),
                    rst.getString("txtCustMobile"),
                    rst.getString("txtCustitemId"),
                    rst.getString("txtCustPayment"));

            getAllCustomer.add(customerDTO);
        }
        return getAllCustomer;
    }


}
