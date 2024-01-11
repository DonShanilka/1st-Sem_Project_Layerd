package lk.ijse.semisterfinal.Bo.Custom;

import lk.ijse.semisterfinal.Bo.SupperBo;
import lk.ijse.semisterfinal.dto.AtendanceDTO;
import lk.ijse.semisterfinal.dto.SalaryDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface SalaryBo extends SupperBo {

    boolean add(SalaryDTO dto) throws SQLException, ClassNotFoundException;

    ArrayList<SalaryDTO> getAll() throws SQLException, ClassNotFoundException;

    AtendanceDTO getABcount(String id) throws SQLException, ClassNotFoundException;

    AtendanceDTO getPRcount(String id) throws SQLException, ClassNotFoundException;

}
