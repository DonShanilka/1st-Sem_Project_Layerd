package lk.ijse.semisterfinal.Bo.Custom;

import lk.ijse.semisterfinal.Bo.SupperBo;
import lk.ijse.semisterfinal.dto.AdminDTO;

import java.sql.SQLException;

public interface AdminLoginBo extends SupperBo {

    boolean registerAdmin(AdminDTO dto) throws SQLException, ClassNotFoundException;

}
