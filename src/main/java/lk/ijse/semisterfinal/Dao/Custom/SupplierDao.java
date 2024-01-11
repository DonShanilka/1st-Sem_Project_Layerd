package lk.ijse.semisterfinal.Dao.Custom;

import lk.ijse.semisterfinal.Dao.CrudDAO;
import lk.ijse.semisterfinal.dto.SupplierDTO;
import java.sql.SQLException;
import java.util.ArrayList;

public interface SupplierDao extends CrudDAO<SupplierDTO> {

    boolean add(SupplierDTO dto) throws SQLException, ClassNotFoundException;
    boolean delete(SupplierDTO id) throws SQLException, ClassNotFoundException;
    boolean update(SupplierDTO dto) throws SQLException, ClassNotFoundException;
    ArrayList<SupplierDTO> getAll() throws SQLException, ClassNotFoundException;


}
