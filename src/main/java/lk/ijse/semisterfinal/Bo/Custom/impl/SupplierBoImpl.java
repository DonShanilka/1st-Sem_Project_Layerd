package lk.ijse.semisterfinal.Bo.Custom.impl;

import lk.ijse.semisterfinal.Bo.Custom.SupplierBo;
import lk.ijse.semisterfinal.DB.DbConnetion;
import lk.ijse.semisterfinal.Dao.Custom.SupplierDao;
import lk.ijse.semisterfinal.Dao.DaoFactory;
import lk.ijse.semisterfinal.Dao.SqlUtil;
import lk.ijse.semisterfinal.dto.SupplierDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierBoImpl implements SupplierBo {

    SupplierDao supplierDao = (SupplierDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DaoTyps.SUPPLIER);

    @Override
    public boolean add(SupplierDTO dto) throws SQLException, ClassNotFoundException {
        return supplierDao.add(dto);
    }

    @Override
    public boolean delete(SupplierDTO id) throws SQLException, ClassNotFoundException {
        return supplierDao.delete(id);
    }

    @Override
    public boolean update(SupplierDTO dto) throws SQLException, ClassNotFoundException {
        return supplierDao.update(dto);
    }

    @Override
    public ArrayList<SupplierDTO> getAll() throws SQLException, ClassNotFoundException {
        return supplierDao.getAll();
    }

    public SupplierDTO searchsupplier(String id) throws SQLException, ClassNotFoundException {
        return supplierDao.searchsupplier(id);
    }

}
