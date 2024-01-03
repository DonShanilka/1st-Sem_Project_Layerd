package lk.ijse.semisterfinal.Bo.Custom.impl;

import lk.ijse.semisterfinal.Bo.Custom.SalaryBo;
import lk.ijse.semisterfinal.Dao.Custom.SalaryDao;
import lk.ijse.semisterfinal.Dao.Custom.impl.SalaryDaoImpl;
import lk.ijse.semisterfinal.dto.AtendanceDTO;
import lk.ijse.semisterfinal.dto.SalaryDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class SalaryBoImpl implements SalaryBo {

    SalaryDao salaryDao = new SalaryDaoImpl();

    @Override
    public boolean addSalary(SalaryDTO dto) throws SQLException, ClassNotFoundException {
        return salaryDao.addSalary(dto);
    }

    @Override
    public ArrayList<SalaryDTO> getAllSalary() throws SQLException, ClassNotFoundException {
        return salaryDao.getAllSalary();
    }

    @Override
    public AtendanceDTO getABcount(SalaryDTO id) throws SQLException, ClassNotFoundException {
        return salaryDao.getABcount(id);
    }

    @Override
    public AtendanceDTO getPRcount(SalaryDTO id) throws SQLException, ClassNotFoundException {
        return salaryDao.getPRcount(id);
    }
}
