package lk.ijse.semisterfinal.Dao.Custom;

import lk.ijse.semisterfinal.dto.AddEmployeeDTO;

import java.sql.SQLException;
import java.util.List;

public interface EmployeeDao {

    boolean addEmployee(AddEmployeeDTO dto) throws SQLException;

    List<AddEmployeeDTO> getAllEmployee() throws SQLException;

    boolean updateEmployee(AddEmployeeDTO dto) throws SQLException;

    AddEmployeeDTO searchEmployee(String id) throws SQLException;

    boolean deleteEmployee(String id) throws SQLException;

}
