package lk.ijse.semisterfinal.Dao.Custom;

import lk.ijse.semisterfinal.Dao.CrudDAO;
import lk.ijse.semisterfinal.dto.Tm.CartTm;
import lk.ijse.semisterfinal.dto.ItemDTO;
import lk.ijse.semisterfinal.dto.SupplierDTO;
import lk.ijse.semisterfinal.entity.ItemEntity;
import lk.ijse.semisterfinal.entity.SupplierEntity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface ItemDao extends CrudDAO<ItemEntity> {

    boolean add(ItemEntity dto) throws SQLException, ClassNotFoundException;

    boolean delete(ItemEntity id) throws SQLException, ClassNotFoundException;

    boolean update(ItemEntity dto) throws SQLException, ClassNotFoundException;

    ArrayList<ItemEntity> getAll() throws SQLException, ClassNotFoundException;

    ArrayList<SupplierEntity> getAllSupplier() throws SQLException, ClassNotFoundException;

    boolean update(List<CartTm> cartTmList) throws SQLException;

    boolean updateQty(String code, int qty) throws SQLException;

    ItemEntity searchItemId(String id) throws SQLException;
}
