package lk.ijse.semisterfinal.Bo.Custom.impl;

import lk.ijse.semisterfinal.Bo.Custom.AdminLoginBo;
import lk.ijse.semisterfinal.Dao.Custom.AdminLoginDao;
import lk.ijse.semisterfinal.Dao.DaoFactory;
import lk.ijse.semisterfinal.dto.AdminDTO;
import lk.ijse.semisterfinal.entity.AdminEntity;

import java.sql.SQLException;

public class AdminLoginBoImpl implements AdminLoginBo {

    AdminLoginDao adminLoginDao = (AdminLoginDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DaoTyps.ADMIN);

    @Override
    public boolean registerAdmin(AdminDTO dto) throws SQLException, ClassNotFoundException {
        return adminLoginDao.registerAdmin(new AdminEntity(dto.getId(), dto.getUserName(), dto.getPassword()));
    }
}
