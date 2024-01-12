package lk.ijse.semisterfinal.Dao.Custom.impl;

import lk.ijse.semisterfinal.Dao.Custom.AttendanceDao;
import lk.ijse.semisterfinal.Dao.SqlUtil;
import lk.ijse.semisterfinal.dto.AtendanceDTO;
import lk.ijse.semisterfinal.entity.AtendanceEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AttendanceDaoImpl implements AttendanceDao {

    @Override
    public boolean add(AtendanceEntity dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("INSERT INTO attendance VALUES (?,?,?,?)",dto.getDate(),dto.getEmployeeId(),dto.getEmployeeName(),dto.getPOra());

    }

    @Override
    public ArrayList<AtendanceEntity> getAll() throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SqlUtil.test("SELECT * FROM attendance");
        ArrayList<AtendanceEntity> dtoList = new ArrayList<>();

        while (resultSet.next()){
            dtoList.add(
                    new AtendanceEntity(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4)
                    )
            );
        }
        return dtoList;
    }


    @Override
    public boolean update(AtendanceEntity atendanceDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(AtendanceEntity atendanceDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

}
