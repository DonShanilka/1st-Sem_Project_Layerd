package lk.ijse.semisterfinal.Bo.Custom;

import lk.ijse.semisterfinal.Bo.SupperBo;
import lk.ijse.semisterfinal.dto.AtendanceDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface AttendanceBo extends SupperBo {

    boolean add(AtendanceDTO dto) throws SQLException, ClassNotFoundException;

    ArrayList<AtendanceDTO> getAll() throws SQLException, ClassNotFoundException;

}
