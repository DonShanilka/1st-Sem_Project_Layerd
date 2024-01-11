package lk.ijse.semisterfinal.Bo.Custom;

import lk.ijse.semisterfinal.Bo.SupperBo;
import lk.ijse.semisterfinal.dto.ItemDTO;
import lk.ijse.semisterfinal.dto.SupplierDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBo extends SupperBo {

    boolean add(ItemDTO dto) throws SQLException, ClassNotFoundException;

    boolean delete(ItemDTO id) throws SQLException, ClassNotFoundException;

    boolean update(ItemDTO dto) throws SQLException, ClassNotFoundException;

    ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException;

    ArrayList<SupplierDTO> getAllSupplier() throws SQLException, ClassNotFoundException;

    ItemDTO searchItemId(String id) throws SQLException;

}
