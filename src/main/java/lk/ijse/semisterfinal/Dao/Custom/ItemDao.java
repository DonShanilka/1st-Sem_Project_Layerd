package lk.ijse.semisterfinal.Dao.Custom;

import javafx.scene.control.TextField;
import lk.ijse.semisterfinal.DB.DbConnetion;
import lk.ijse.semisterfinal.Tm.CartTm;
import lk.ijse.semisterfinal.dto.ItemDTO;
import lk.ijse.semisterfinal.dto.SupplierDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ItemDao {

    boolean addItem(ItemDTO dto) throws SQLException, ClassNotFoundException;

    boolean deleteItem(ItemDTO id) throws SQLException, ClassNotFoundException;

    boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException;

    ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException;

    ArrayList<SupplierDTO> getAllSupplier() throws SQLException, ClassNotFoundException;

    boolean update(List<CartTm> cartTmList) throws SQLException;

    boolean updateQty(String code, int qty) throws SQLException;
}
