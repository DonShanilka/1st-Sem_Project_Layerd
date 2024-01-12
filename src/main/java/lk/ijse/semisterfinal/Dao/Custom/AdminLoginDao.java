package lk.ijse.semisterfinal.Dao.Custom;

import lk.ijse.semisterfinal.Dao.CrudDAO;
import lk.ijse.semisterfinal.dto.AdminDTO;
import lk.ijse.semisterfinal.entity.AdminEntity;

import java.sql.SQLException;

public interface AdminLoginDao extends CrudDAO<AdminEntity> {

    boolean registerAdmin(AdminEntity dto) throws SQLException, ClassNotFoundException;

}



