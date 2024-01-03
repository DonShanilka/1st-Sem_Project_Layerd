package lk.ijse.semisterfinal.Bo.Custom;

import lk.ijse.semisterfinal.Bo.SupperBo;
import lk.ijse.semisterfinal.dto.ItemDTO;
import lk.ijse.semisterfinal.dto.SupplierDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBo extends SupperBo {

    boolean addItem(ItemDTO dto) throws SQLException, ClassNotFoundException;

    boolean deleteItem(ItemDTO id) throws SQLException, ClassNotFoundException;

    boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException;

    ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException;

    ArrayList<SupplierDTO> getAllSupplier() throws SQLException, ClassNotFoundException;

}
