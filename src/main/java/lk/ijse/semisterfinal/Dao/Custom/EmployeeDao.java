package lk.ijse.semisterfinal.Dao.Custom;

import lk.ijse.semisterfinal.Dao.CrudDAO;
import lk.ijse.semisterfinal.dto.AddEmployeeDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface EmployeeDao extends CrudDAO <AddEmployeeDTO> {

    boolean Add(AddEmployeeDTO dto) throws SQLException, ClassNotFoundException;

   ArrayList <AddEmployeeDTO> getAll() throws SQLException, ClassNotFoundException;

    boolean update(AddEmployeeDTO dto) throws SQLException, ClassNotFoundException;

    boolean delete(AddEmployeeDTO id) throws SQLException, ClassNotFoundException;

}
