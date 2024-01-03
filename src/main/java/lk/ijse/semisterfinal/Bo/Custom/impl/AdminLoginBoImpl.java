package lk.ijse.semisterfinal.Bo.Custom.impl;

import lk.ijse.semisterfinal.Bo.Custom.AdminLoginBo;
import lk.ijse.semisterfinal.Dao.Custom.AdminLoginDao;
import lk.ijse.semisterfinal.Dao.Custom.impl.AdminLoginImpl;
import lk.ijse.semisterfinal.dto.AdminDTO;

import java.sql.SQLException;

public class AdminLoginBoImpl implements AdminLoginBo {

    AdminLoginDao adminLoginDao = new AdminLoginImpl();

    @Override
    public boolean registerAdmin(AdminDTO dto) throws SQLException, ClassNotFoundException {
        return adminLoginDao.registerAdmin(dto);
    }
}
