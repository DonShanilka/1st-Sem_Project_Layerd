package lk.ijse.semisterfinal.Dao.Custom;

import lk.ijse.semisterfinal.dto.SupplierDTO;
import java.sql.SQLException;
import java.util.ArrayList;

public interface SupplierDao {

    boolean addSuppliers(SupplierDTO dto) throws SQLException;

    boolean deleteSupplier(String id) throws SQLException;
    boolean updateSupplier(SupplierDTO dto) throws SQLException;

    ArrayList<SupplierDTO> getAllSupplier() throws SQLException;
    SupplierDTO searchsupplier(String id) throws SQLException;

}
