package lk.ijse.semisterfinal.Bo.Custom;

import lk.ijse.semisterfinal.Bo.SupperBo;
import lk.ijse.semisterfinal.dto.AddEmployeeDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface EmployeeBo extends SupperBo {

    boolean add(AddEmployeeDTO dto) throws SQLException, ClassNotFoundException;

    ArrayList<AddEmployeeDTO> getAll() throws SQLException, ClassNotFoundException;

    boolean update(AddEmployeeDTO dto) throws SQLException, ClassNotFoundException;

    boolean delete(AddEmployeeDTO id) throws SQLException, ClassNotFoundException;

    AddEmployeeDTO searchEmployee(String id) throws SQLException, ClassNotFoundException;

}
