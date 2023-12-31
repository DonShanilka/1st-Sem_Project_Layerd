package lk.ijse.semisterfinal.Dao.Custom;

import lk.ijse.semisterfinal.dto.AdminDTO;

import java.sql.SQLException;

public interface AdminLoginDao {

    boolean registerAdmin(AdminDTO dto) throws SQLException, ClassNotFoundException;

}
