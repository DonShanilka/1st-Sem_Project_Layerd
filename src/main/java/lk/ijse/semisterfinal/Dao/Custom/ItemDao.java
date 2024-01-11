package lk.ijse.semisterfinal.Dao.Custom;

import lk.ijse.semisterfinal.Tm.CartTm;
import lk.ijse.semisterfinal.dto.ItemDTO;
import lk.ijse.semisterfinal.dto.SupplierDTO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ItemDao {

    boolean add(ItemDTO dto) throws SQLException, ClassNotFoundException;

    boolean delete(ItemDTO id) throws SQLException, ClassNotFoundException;

    boolean update(ItemDTO dto) throws SQLException, ClassNotFoundException;

    ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException;

    ArrayList<SupplierDTO> getAllSupplier() throws SQLException, ClassNotFoundException;

    boolean update(List<CartTm> cartTmList) throws SQLException;

    boolean updateQty(String code, int qty) throws SQLException;
}
