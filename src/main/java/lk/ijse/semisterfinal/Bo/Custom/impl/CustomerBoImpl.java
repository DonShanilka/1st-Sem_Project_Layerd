package lk.ijse.semisterfinal.Bo.Custom.impl;

import lk.ijse.semisterfinal.Bo.Custom.CustomerBo;
import lk.ijse.semisterfinal.Dao.Custom.CustomerDao;
import lk.ijse.semisterfinal.Dao.Custom.impl.CustomerDaoImpl;
import lk.ijse.semisterfinal.Dao.DaoFactory;
import lk.ijse.semisterfinal.dto.CusromerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBoImpl implements CustomerBo {

    CustomerDao customerDao = (CustomerDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DaoTyps.CUSTOMER);

    @Override
    public boolean Add(CusromerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDao.add(dto);
    }

    @Override
    public boolean delete(CusromerDTO id) throws SQLException, ClassNotFoundException {
        return customerDao.delete(id);
    }

    @Override
    public boolean update(CusromerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDao.update(dto);
    }

    @Override
    public ArrayList<CusromerDTO> getAll() throws SQLException, ClassNotFoundException {
        return customerDao.getAll();
    }

    @Override
    public CusromerDTO searchCustomer(String id) throws SQLException {
        return customerDao.searchCustomer(id);
    }
}
