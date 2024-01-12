package lk.ijse.semisterfinal.Bo.Custom.impl;

import lk.ijse.semisterfinal.Bo.Custom.SupplierBo;
import lk.ijse.semisterfinal.Dao.Custom.SupplierDao;
import lk.ijse.semisterfinal.Dao.DaoFactory;
import lk.ijse.semisterfinal.dto.SupplierDTO;
import lk.ijse.semisterfinal.entity.SupplierEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierBoImpl implements SupplierBo {

    SupplierDao supplierDao = (SupplierDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DaoTyps.SUPPLIER);

    @Override
    public boolean add(SupplierDTO dto) throws SQLException, ClassNotFoundException {
        return supplierDao.add(new SupplierEntity(dto.getSupNic(),dto.getSupName(),dto.getMobile(),dto.getEmail(),dto.getCoName(),dto.getCoAddress(),dto.getItemcode(),
                dto.getItemName(),dto.getQty(),dto.getBNum(),dto.getCatagory()));
    }

    @Override
    public boolean delete(SupplierDTO id) throws SQLException, ClassNotFoundException {
        return supplierDao.delete(new SupplierEntity(id.getSupNic()));
    }

    @Override
    public boolean update(SupplierDTO dto) throws SQLException, ClassNotFoundException {
        return supplierDao.update(new SupplierEntity(dto.getSupName(),dto.getMobile(),dto.getEmail(),dto.getCoName(),dto.getCoAddress(),dto.getItemcode(),
                dto.getItemName(),dto.getQty(),dto.getBNum(),dto.getCatagory(),dto.getSupNic()));
    }

    @Override
    public ArrayList<SupplierDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<SupplierEntity> entities = supplierDao.getAll();
        ArrayList<SupplierDTO> dtos = new ArrayList<>();
        for (SupplierEntity dto : entities){
            dtos.add(new SupplierDTO(dto.getSupName(),dto.getMobile(),dto.getEmail(),dto.getCoName(),dto.getCoAddress(),dto.getItemcode(),
                    dto.getItemName(),dto.getQty(),dto.getBNum(),dto.getCatagory(),dto.getSupNic()));
        }
        return dtos;
    }

    public SupplierDTO searchsupplier(String id) throws SQLException, ClassNotFoundException {
        SupplierEntity dto = supplierDao.searchsupplier(id);
        return new SupplierDTO(dto.getSupName(),dto.getMobile(),dto.getEmail(),dto.getCoName(),dto.getCoAddress(),dto.getItemcode(),
                dto.getItemName(),dto.getQty(),dto.getBNum(),dto.getCatagory(),dto.getSupNic());
    }

}
