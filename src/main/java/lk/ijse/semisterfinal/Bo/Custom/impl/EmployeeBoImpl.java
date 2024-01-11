package lk.ijse.semisterfinal.Bo.Custom.impl;

import lk.ijse.semisterfinal.Bo.Custom.EmployeeBo;
import lk.ijse.semisterfinal.Dao.Custom.EmployeeDao;
import lk.ijse.semisterfinal.Dao.Custom.impl.EmployeeDaoImpl;
import lk.ijse.semisterfinal.Dao.DaoFactory;
import lk.ijse.semisterfinal.dto.AddEmployeeDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeBoImpl implements EmployeeBo {

    EmployeeDao employeeDao = (EmployeeDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DaoTyps.EMPLOYEE);

    @Override
    public boolean Add(AddEmployeeDTO dto) throws SQLException, ClassNotFoundException {
        return employeeDao.add(dto);
    }

    @Override
    public ArrayList<AddEmployeeDTO> getAll() throws SQLException, ClassNotFoundException {
        return employeeDao.getAll();
    }

    @Override
    public boolean update(AddEmployeeDTO dto) throws SQLException, ClassNotFoundException {
        return employeeDao.update(dto);
    }

    @Override
    public boolean delete(AddEmployeeDTO id) throws SQLException, ClassNotFoundException {
        return employeeDao.delete(id);
    }
}
