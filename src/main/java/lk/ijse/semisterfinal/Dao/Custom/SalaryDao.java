package lk.ijse.semisterfinal.Dao.Custom;

import lk.ijse.semisterfinal.dto.AtendanceDTO;
import lk.ijse.semisterfinal.dto.SalaryDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SalaryDao {

    boolean addSalary(SalaryDTO dto) throws SQLException, ClassNotFoundException;

    ArrayList<SalaryDTO> getAllSalary() throws SQLException, ClassNotFoundException;

    AtendanceDTO getABcount(SalaryDTO id) throws SQLException, ClassNotFoundException;

    AtendanceDTO getPRcount(SalaryDTO id) throws SQLException, ClassNotFoundException;

}
