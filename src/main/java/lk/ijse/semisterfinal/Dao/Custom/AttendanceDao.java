package lk.ijse.semisterfinal.Dao.Custom;

import lk.ijse.semisterfinal.Dao.CrudDAO;
import lk.ijse.semisterfinal.dto.AddEmployeeDTO;
import lk.ijse.semisterfinal.dto.AtendanceDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AttendanceDao extends CrudDAO<AtendanceDTO> {

    boolean add(AtendanceDTO dto) throws SQLException, ClassNotFoundException;

    ArrayList<AtendanceDTO> getAll() throws SQLException, ClassNotFoundException;

}
