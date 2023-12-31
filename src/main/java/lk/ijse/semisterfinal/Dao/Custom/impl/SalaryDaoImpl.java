package lk.ijse.semisterfinal.Dao.Custom.impl;

import lk.ijse.semisterfinal.DB.DbConnetion;
import lk.ijse.semisterfinal.Dao.Custom.SalaryDao;
import lk.ijse.semisterfinal.Dao.SqlUtil;
import lk.ijse.semisterfinal.dto.AtendanceDTO;
import lk.ijse.semisterfinal.dto.SalaryDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SalaryDaoImpl implements SalaryDao {

    @Override
    public boolean addSalary(SalaryDTO dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("INSERT INTO salary VALUES(?,?,?,?,?,?,?,?,?,?,?,?)",dto.getDate(),dto.getEmployeeId(),dto.getEmployeeName(),
                dto.getSalary(),dto.getOtcount(),dto.getPay1h(),dto.getBonase(),dto.getEpf(),dto.getEtf(),dto.getPrCount(),dto.getAbcount(),dto.getTotalsalary());

    }

    @Override
    public ArrayList<SalaryDTO> getAllSalary() throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SqlUtil.test("SELECT * FROM salary");
        ArrayList<SalaryDTO> dtoList = new ArrayList<>();

        while(resultSet.next()) {
            dtoList.add(
                    new SalaryDTO(
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
    public AtendanceDTO getABcount(SalaryDTO id) throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SqlUtil.test("SELECT COUNT(*) FROM attendance WHERE employee_id = ? AND presentAbsent = 'Absent'",id.getAbcount());
        AtendanceDTO dto = null;

        if (resultSet.next()) {
            String ab = resultSet.getString(1);

            dto = new AtendanceDTO(ab);
        }
        return dto;
    }


    @Override
    public AtendanceDTO getPRcount(SalaryDTO id) throws SQLException, ClassNotFoundException {

        PreparedStatement pstm = SqlUtil.test("SELECT COUNT(*) FROM attendance WHERE employee_id = ? AND presentAbsent = 'Present'",id.getPrCount());
        ResultSet resultSet = pstm.executeQuery();

        AtendanceDTO dto = null;

        if (resultSet.next()) {
            String pr = resultSet.getString(1);

            dto = new AtendanceDTO(pr);
        }
        return dto;
    }

}
