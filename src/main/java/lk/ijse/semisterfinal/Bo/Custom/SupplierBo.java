package lk.ijse.semisterfinal.Bo.Custom;

import lk.ijse.semisterfinal.Bo.SupperBo;
import lk.ijse.semisterfinal.dto.SupplierDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SupplierBo extends SupperBo {

    boolean add(SupplierDTO dto) throws SQLException, ClassNotFoundException;
    boolean delete(SupplierDTO id) throws SQLException, ClassNotFoundException;
    boolean update(SupplierDTO dto) throws SQLException, ClassNotFoundException;
    ArrayList<SupplierDTO> getAll() throws SQLException, ClassNotFoundException;

    SupplierDTO searchsupplier(String id) throws SQLException, ClassNotFoundException;

}
