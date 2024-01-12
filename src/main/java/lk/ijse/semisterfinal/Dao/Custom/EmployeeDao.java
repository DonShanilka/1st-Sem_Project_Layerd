package lk.ijse.semisterfinal.Dao.Custom;

import lk.ijse.semisterfinal.Dao.CrudDAO;
import lk.ijse.semisterfinal.dto.AddEmployeeDTO;
import lk.ijse.semisterfinal.entity.AddEmployeeEntity;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface EmployeeDao extends CrudDAO <AddEmployeeEntity> {

    boolean add(AddEmployeeEntity dto) throws SQLException, ClassNotFoundException;

   ArrayList <AddEmployeeEntity> getAll() throws SQLException, ClassNotFoundException;

    boolean update(AddEmployeeEntity dto) throws SQLException, ClassNotFoundException;

    boolean delete(AddEmployeeEntity id) throws SQLException, ClassNotFoundException;

    AddEmployeeEntity searchEmployee(String id) throws SQLException, ClassNotFoundException;

}
