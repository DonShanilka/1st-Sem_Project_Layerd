package lk.ijse.semisterfinal.Dao.Custom;

import lk.ijse.semisterfinal.dto.SupplierDTO;
import java.sql.SQLException;
import java.util.ArrayList;

public interface SupplierDao {

    boolean addSuppliers(SupplierDTO dto) throws SQLException, ClassNotFoundException;

    boolean deleteSupplier(SupplierDTO id) throws SQLException, ClassNotFoundException;
    boolean updateSupplier(SupplierDTO dto) throws SQLException, ClassNotFoundException;

    ArrayList<SupplierDTO> getAllSupplier() throws SQLException, ClassNotFoundException;


}
