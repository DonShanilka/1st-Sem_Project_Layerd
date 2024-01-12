package lk.ijse.semisterfinal.Dao.Custom;

import lk.ijse.semisterfinal.Dao.CrudDAO;
import lk.ijse.semisterfinal.dto.AtendanceDTO;
import lk.ijse.semisterfinal.dto.SalaryDTO;
import lk.ijse.semisterfinal.entity.AtendanceEntity;
import lk.ijse.semisterfinal.entity.SalaryEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SalaryDao extends CrudDAO<SalaryEntity> {

    boolean add(SalaryEntity dto) throws SQLException, ClassNotFoundException;

    ArrayList<SalaryEntity> getAll() throws SQLException, ClassNotFoundException;

    AtendanceEntity getABcount(String id) throws SQLException, ClassNotFoundException;

    AtendanceEntity getPRcount(String id) throws SQLException, ClassNotFoundException;

}
