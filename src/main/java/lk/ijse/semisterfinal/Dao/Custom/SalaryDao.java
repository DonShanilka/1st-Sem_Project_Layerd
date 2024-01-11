package lk.ijse.semisterfinal.Dao.Custom;

import lk.ijse.semisterfinal.Dao.CrudDAO;
import lk.ijse.semisterfinal.dto.AtendanceDTO;
import lk.ijse.semisterfinal.dto.SalaryDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SalaryDao extends CrudDAO<SalaryDTO> {

    boolean add(SalaryDTO dto) throws SQLException, ClassNotFoundException;

    ArrayList<SalaryDTO> getAll() throws SQLException, ClassNotFoundException;

    AtendanceDTO getABcount(String id) throws SQLException, ClassNotFoundException;

    AtendanceDTO getPRcount(String id) throws SQLException, ClassNotFoundException;

}
