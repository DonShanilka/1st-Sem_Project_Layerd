package lk.ijse.semisterfinal.Dao.Custom.impl;

import lk.ijse.semisterfinal.Dao.Custom.AdminLoginDao;
import lk.ijse.semisterfinal.Dao.SqlUtil;
import lk.ijse.semisterfinal.dto.AdminDTO;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminLoginImpl implements AdminLoginDao {

    @Override
    public boolean registerAdmin(AdminDTO dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("INSERT INTO admin VALUES(?,?,?)",dto.getId(),dto.getUserName(),dto.getPassword());

    }

    @Override
    public ArrayList<AdminDTO> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean add(AdminDTO adminDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(AdminDTO adminDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(AdminDTO adminDTO) throws SQLException, ClassNotFoundException {
        return false;
    }
}



