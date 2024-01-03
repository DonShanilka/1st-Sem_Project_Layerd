package lk.ijse.semisterfinal.Bo.Custom;

import lk.ijse.semisterfinal.Bo.SupperBo;
import lk.ijse.semisterfinal.dto.SupplierDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SupplierBo extends SupperBo {

    boolean addSuppliers(SupplierDTO dto) throws SQLException, ClassNotFoundException;
    boolean deleteSupplier(SupplierDTO id) throws SQLException, ClassNotFoundException;
    boolean updateSupplier(SupplierDTO dto) throws SQLException, ClassNotFoundException;
    ArrayList<SupplierDTO> getAllSupplier() throws SQLException, ClassNotFoundException;

}
