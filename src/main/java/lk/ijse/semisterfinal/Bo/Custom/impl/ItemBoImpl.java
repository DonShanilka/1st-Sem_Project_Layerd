package lk.ijse.semisterfinal.Bo.Custom.impl;

import lk.ijse.semisterfinal.Bo.Custom.ItemBo;
import lk.ijse.semisterfinal.Dao.Custom.ItemDao;
import lk.ijse.semisterfinal.Dao.Custom.impl.ItemDaoImpl;
import lk.ijse.semisterfinal.dto.ItemDTO;
import lk.ijse.semisterfinal.dto.SupplierDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBoImpl implements ItemBo {

    ItemDao itemDao = new ItemDaoImpl();

    @Override
    public boolean addItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDao.addItem(dto);
    }

    @Override
    public boolean deleteItem(ItemDTO id) throws SQLException, ClassNotFoundException {
        return itemDao.deleteItem(id);
    }

    @Override
    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return itemDao.updateItem(dto);
    }

    @Override
    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException {
        return itemDao.getAllItem();
    }

    @Override
    public ArrayList<SupplierDTO> getAllSupplier() throws SQLException, ClassNotFoundException {
        return itemDao.getAllSupplier();
    }
}
