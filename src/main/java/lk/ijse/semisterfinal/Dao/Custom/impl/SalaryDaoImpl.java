package lk.ijse.semisterfinal.Dao.Custom.impl;

import lk.ijse.semisterfinal.Dao.Custom.SalaryDao;
import lk.ijse.semisterfinal.Dao.SqlUtil;
import lk.ijse.semisterfinal.dto.AtendanceDTO;
import lk.ijse.semisterfinal.dto.SalaryDTO;
import lk.ijse.semisterfinal.entity.AtendanceEntity;
import lk.ijse.semisterfinal.entity.SalaryEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SalaryDaoImpl implements SalaryDao {

    @Override
    public boolean add(SalaryEntity dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("INSERT INTO salary VALUES(?,?,?,?,?,?,?,?,?,?,?,?)",
                dto.getDate(),dto.getEmployeeId(),dto.getEmployeeName(),
                dto.getSalary(),dto.getOtcount(),dto.getPay1h(),dto.getBonase(),
                dto.getEpf(),dto.getEtf(),dto.getPrCount(),dto.getAbcount(),dto.getTotalsalary());

    }

    @Override
    public boolean update(SalaryEntity salaryDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(SalaryEntity salaryDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public ArrayList<SalaryEntity> getAll() throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SqlUtil.test("SELECT * FROM salary");
        ArrayList<SalaryEntity> dtoList = new ArrayList<>();

        while(resultSet.next()) {
            dtoList.add(
                    new SalaryEntity(
                            String.valueOf(resultSet.getDate(1)),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getDouble(4),
                            resultSet.getInt(5),
                            resultSet.getDouble(6),
                            resultSet.getDouble(7),
                            resultSet.getInt(8),
                            resultSet.getInt(9),
                            resultSet.getInt(10),
                            resultSet.getInt(11),
                            resultSet.getDouble(12)
                    )
            );
        }
        return dtoList;
    }

    @Override
    public AtendanceEntity getABcount(String id) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("SELECT COUNT(*) FROM attendance WHERE employee_id = ? AND presentAbsent = 'Present'",id);
    }

    @Override
    public AtendanceEntity getPRcount(String id) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("SELECT COUNT(*) FROM attendance WHERE employee_id = ? AND presentAbsent = 'Absent'",id);
    }


}
