package lk.ijse.semisterfinal.Bo.Custom.impl;

import lk.ijse.semisterfinal.Bo.Custom.AttendanceBo;
import lk.ijse.semisterfinal.Dao.Custom.AttendanceDao;
import lk.ijse.semisterfinal.Dao.Custom.EmployeeDao;
import lk.ijse.semisterfinal.Dao.Custom.impl.AttendanceDaoImpl;
import lk.ijse.semisterfinal.Dao.Custom.impl.EmployeeDaoImpl;
import lk.ijse.semisterfinal.Dao.DaoFactory;
import lk.ijse.semisterfinal.dto.AddEmployeeDTO;
import lk.ijse.semisterfinal.dto.AtendanceDTO;
import lk.ijse.semisterfinal.entity.AddEmployeeEntity;
import lk.ijse.semisterfinal.entity.AtendanceEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public class AttendanceBoImpl implements AttendanceBo {

    AttendanceDao attendanceDao = (AttendanceDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DaoTyps.ATTENDANCE);

    @Override
    public boolean add(AtendanceDTO dto) throws SQLException, ClassNotFoundException {
        return attendanceDao.add(new AtendanceEntity(dto.getDate(),dto.getEmployeeId(),dto.getEmployeeName(),dto.getDate(),dto.getPOra()));
    }

    @Override
    public ArrayList<AtendanceDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<AtendanceEntity>employees = attendanceDao.getAll();
        ArrayList<AtendanceDTO>employeeDtos = new ArrayList<>();

        for (AtendanceEntity employee:employees) {
            employeeDtos.add(new AtendanceDTO(
                    employee.getDate(),
                    employee.getEmployeeId(),
                    employee.getEmployeeName(),
                    employee.getPOra()

            ));
        }
        return employeeDtos;
    }
}
