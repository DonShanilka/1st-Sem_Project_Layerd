package lk.ijse.semisterfinal.Dao.Custom;

import lk.ijse.semisterfinal.dto.ItemDTO;
import lk.ijse.semisterfinal.dto.SupplierDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ItemDao {

    boolean addItem(ItemDTO dto) throws SQLException, ClassNotFoundException;

    boolean deleteItem(ItemDTO id) throws SQLException, ClassNotFoundException;

    boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException;

    ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException;

    ArrayList<SupplierDTO> getAllSupplier() throws SQLException, ClassNotFoundException;

}
