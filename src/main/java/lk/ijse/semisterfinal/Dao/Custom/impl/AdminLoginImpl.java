package lk.ijse.semisterfinal.Dao.Custom.impl;

import lk.ijse.semisterfinal.Dao.Custom.AdminLoginDao;
import lk.ijse.semisterfinal.Dao.SqlUtil;
import lk.ijse.semisterfinal.dto.AdminDTO;
import java.sql.SQLException;

public class AdminLoginImpl implements AdminLoginDao {

    @Override
    public boolean registerAdmin(AdminDTO dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("INSERT INTO admin VALUES(?,?,?)",dto.getId(),dto.getUserName(),dto.getPassword());

    }

}
