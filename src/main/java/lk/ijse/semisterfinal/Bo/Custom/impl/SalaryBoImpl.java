package lk.ijse.semisterfinal.Bo.Custom.impl;

import lk.ijse.semisterfinal.Bo.Custom.SalaryBo;
import lk.ijse.semisterfinal.Dao.Custom.SalaryDao;
import lk.ijse.semisterfinal.Dao.DaoFactory;
import lk.ijse.semisterfinal.dto.AtendanceDTO;
import lk.ijse.semisterfinal.dto.SalaryDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class SalaryBoImpl implements SalaryBo {

    SalaryDao salaryDao = (SalaryDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DaoTyps.SALARY);

    @Override
    public boolean add(SalaryDTO dto) throws SQLException, ClassNotFoundException {
        return salaryDao.add(dto);
    }

    @Override
    public ArrayList<SalaryDTO> getAll() throws SQLException, ClassNotFoundException {
        return salaryDao.getAll();
    }

    @Override
    public AtendanceDTO getABcount(String id) throws SQLException, ClassNotFoundException {
        return salaryDao.getABcount(id);
    }

    @Override
    public AtendanceDTO getPRcount(String id) throws SQLException, ClassNotFoundException {
        return salaryDao.getPRcount(id);
    }
}
