package lk.ijse.semisterfinal.Bo.Custom.impl;

import lk.ijse.semisterfinal.Bo.Custom.AttendanceBo;
import lk.ijse.semisterfinal.Dao.Custom.AttendanceDao;
import lk.ijse.semisterfinal.Dao.Custom.impl.AttendanceDaoImpl;
import lk.ijse.semisterfinal.Dao.DaoFactory;
import lk.ijse.semisterfinal.dto.AtendanceDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class AttendanceBoImpl implements AttendanceBo {

    AttendanceDao attendanceDao = (AttendanceDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DaoTyps.ATTENDANCE);

    @Override
    public boolean add(AtendanceDTO dto) throws SQLException, ClassNotFoundException {
        return attendanceDao.add(dto);
    }

    @Override
    public ArrayList<AtendanceDTO> getAll() throws SQLException, ClassNotFoundException {
        return attendanceDao.getAll();
    }
}
