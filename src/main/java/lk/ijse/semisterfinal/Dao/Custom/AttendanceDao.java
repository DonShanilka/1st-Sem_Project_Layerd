package lk.ijse.semisterfinal.Dao.Custom;

import lk.ijse.semisterfinal.Dao.CrudDAO;
import lk.ijse.semisterfinal.dto.AddEmployeeDTO;
import lk.ijse.semisterfinal.dto.AtendanceDTO;
import lk.ijse.semisterfinal.entity.AtendanceEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AttendanceDao extends CrudDAO<AtendanceEntity> {

    boolean add(AtendanceEntity dto) throws SQLException, ClassNotFoundException;

    ArrayList<AtendanceEntity> getAll() throws SQLException, ClassNotFoundException;

}
