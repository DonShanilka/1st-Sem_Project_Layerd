package lk.ijse.semisterfinal.Dao.Custom;

import lk.ijse.semisterfinal.dto.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ItemDao {

    boolean addItem(ItemDTO dto) throws SQLException;
    boolean deleteItem(String id) throws SQLException;

    boolean updateItem(ItemDTO dto) throws SQLException;

    List<ItemDTO> loadAllItems() throws SQLException;

    ArrayList<ItemDTO> getAllItem() throws SQLException;

    ItemDTO searchItemId(String id) throws SQLException;

}
