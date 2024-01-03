package lk.ijse.semisterfinal.Bo.Custom.impl;

import lk.ijse.semisterfinal.Bo.Custom.SupplierBo;
import lk.ijse.semisterfinal.Dao.Custom.SupplierDao;
import lk.ijse.semisterfinal.Dao.Custom.impl.SupplierDaoImpl;
import lk.ijse.semisterfinal.dto.SupplierDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierBoImpl implements SupplierBo {

    SupplierDao supplierDao = new SupplierDaoImpl();

    @Override
    public boolean addSuppliers(SupplierDTO dto) throws SQLException, ClassNotFoundException {
        return supplierDao.addSuppliers(dto);
    }

    @Override
    public boolean deleteSupplier(SupplierDTO id) throws SQLException, ClassNotFoundException {
        return supplierDao.deleteSupplier(id);
    }

    @Override
    public boolean updateSupplier(SupplierDTO dto) throws SQLException, ClassNotFoundException {
        return supplierDao.updateSupplier(dto);
    }

    @Override
    public ArrayList<SupplierDTO> getAllSupplier() throws SQLException, ClassNotFoundException {
        return supplierDao.getAllSupplier();
    }
}
