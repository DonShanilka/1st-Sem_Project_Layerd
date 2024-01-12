package lk.ijse.semisterfinal.Bo.Custom.impl;

import lk.ijse.semisterfinal.Bo.Custom.ItemBo;
import lk.ijse.semisterfinal.Dao.Custom.ItemDao;
import lk.ijse.semisterfinal.Dao.Custom.impl.ItemDaoImpl;
import lk.ijse.semisterfinal.Dao.DaoFactory;
import lk.ijse.semisterfinal.dto.ItemDTO;
import lk.ijse.semisterfinal.dto.SupplierDTO;
import lk.ijse.semisterfinal.entity.ItemEntity;
import lk.ijse.semisterfinal.entity.SupplierEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBoImpl implements ItemBo {

    ItemDao itemDao = (ItemDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DaoTyps.ITEM);

    @Override
    public boolean add(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDao.add(new ItemEntity(dto.getItemCode(),dto.getItemDetails(),dto.getItemPrice(),
                dto.getSupplierId(),dto.getWarrantyPeriod(),dto.getItemQty(),dto.getCato()));
    }

    @Override
    public boolean delete(ItemDTO id) throws SQLException, ClassNotFoundException {
        return itemDao.delete(new ItemEntity(id.getItemCode()));
    }

    @Override
    public boolean update(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDao.update(new ItemEntity(dto.getItemCode(),dto.getItemDetails(),dto.getItemPrice(),dto.getSupplierId(),dto.getWarrantyPeriod(),dto.getItemQty(),dto.getCato()));
    }

    @Override
    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<ItemEntity> itemEntities = itemDao.getAll();
        ArrayList<ItemDTO> dtos = new ArrayList<>();

        for (ItemEntity dto : itemEntities){
            dtos.add(new ItemDTO(dto.getItemCode(),dto.getItemDetails(),dto.getItemPrice(),dto.getSupplierId(),dto.getWarrantyPeriod(),dto.getItemQty(),dto.getCato()));
        }
        return dtos;
    }

    @Override
    public ArrayList<SupplierDTO> getAllSupplier() throws SQLException, ClassNotFoundException {
        ArrayList<SupplierEntity> supplierEntities = itemDao.getAllSupplier();
        ArrayList<SupplierDTO> dtos = new ArrayList<>();

        for (SupplierEntity dto : supplierEntities){
            dtos.add(new SupplierDTO(dto.getSupNic(),dto.getSupName(),dto.getMobile(),dto.getEmail(),dto.getCoName(),dto.getCoAddress(),dto.getItemcode(),
                    dto.getItemName(),dto.getQty(),dto.getBNum(),dto.getCatagory()));
        }

        return dtos;
    }

    @Override
    public ItemDTO searchItemId(String id) throws SQLException {
        ItemEntity dto = itemDao.searchItemId(id);
        return new ItemDTO(dto.getItemCode(),dto.getItemDetails(),dto.getItemPrice(),
                dto.getSupplierId(),dto.getWarrantyPeriod(),dto.getItemQty(),dto.getCato());
    }
}
