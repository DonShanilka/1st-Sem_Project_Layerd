package lk.ijse.semisterfinal.Dao.Custom;

import lk.ijse.semisterfinal.dto.AddEmployeeDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface EmployeeDao {

    boolean Add(AddEmployeeDTO dto) throws SQLException, ClassNotFoundException;

   ArrayList <AddEmployeeDTO> getAll() throws SQLException, ClassNotFoundException;

    boolean update(AddEmployeeDTO dto) throws SQLException;

    AddEmployeeDTO search(String id) throws SQLException;

    boolean delete(String id) throws SQLException;

}
