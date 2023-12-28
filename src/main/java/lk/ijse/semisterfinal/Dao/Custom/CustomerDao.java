package lk.ijse.semisterfinal.Dao.Custom;

import lk.ijse.semisterfinal.dto.CusromerDTO;

import java.sql.SQLException;

public interface CustomerDao {
    boolean AddCustomer(CusromerDTO dto) throws SQLException;
    boolean deleteCustomer(String id) throws SQLException;

    boolean updateCustomer(CusromerDTO dto) throws SQLException;
}
