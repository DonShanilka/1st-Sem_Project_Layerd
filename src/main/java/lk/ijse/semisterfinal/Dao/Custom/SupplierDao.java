package lk.ijse.semisterfinal.Dao.Custom;

import lk.ijse.semisterfinal.Dao.CrudDAO;
import lk.ijse.semisterfinal.dto.SupplierDTO;
import lk.ijse.semisterfinal.entity.SupplierEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SupplierDao extends CrudDAO<SupplierEntity> {

    boolean add(SupplierEntity dto) throws SQLException, ClassNotFoundException;
    boolean delete(SupplierEntity id) throws SQLException, ClassNotFoundException;
    boolean update(SupplierEntity dto) throws SQLException, ClassNotFoundException;
    ArrayList<SupplierEntity> getAll() throws SQLException, ClassNotFoundException;

    SupplierEntity searchsupplier(String id) throws SQLException, ClassNotFoundException;

}
