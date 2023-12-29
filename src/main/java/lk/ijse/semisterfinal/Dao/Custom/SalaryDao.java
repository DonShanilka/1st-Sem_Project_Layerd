package lk.ijse.semisterfinal.Dao.Custom;

import lk.ijse.semisterfinal.dto.AtendanceDTO;
import lk.ijse.semisterfinal.dto.SalaryDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SalaryDao {

    boolean addSalary(SalaryDTO dto) throws SQLException;

    ArrayList<SalaryDTO> getAllSalary() throws SQLException;

    AtendanceDTO getABcount(String id) throws SQLException;

    AtendanceDTO getPRcount(String id) throws SQLException;

}
