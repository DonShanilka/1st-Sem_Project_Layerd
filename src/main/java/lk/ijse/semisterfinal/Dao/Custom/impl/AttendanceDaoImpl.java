package lk.ijse.semisterfinal.Dao.Custom.impl;

import lk.ijse.semisterfinal.Dao.Custom.AttendanceDao;
import lk.ijse.semisterfinal.Dao.SqlUtil;
import lk.ijse.semisterfinal.dto.AtendanceDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AttendanceDaoImpl implements AttendanceDao {

    @Override
    public boolean add(AtendanceDTO dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("INSERT INTO attendance VALUES (?,?,?,?)",dto.getDate(),dto.getEmployeeId(),dto.getEmployeeName(),dto.getPOra());

    }

    @Override
    public ArrayList<AtendanceDTO> getAll() throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SqlUtil.test("SELECT * FROM attendance");
        ArrayList<AtendanceDTO> dtoList = new ArrayList<>();

        while (resultSet.next()){
            dtoList.add(
                    new AtendanceDTO(
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
    public boolean Add(AtendanceDTO atendanceDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(AtendanceDTO atendanceDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean delete(AtendanceDTO atendanceDTO) throws SQLException, ClassNotFoundException {
        return false;
    }

}
