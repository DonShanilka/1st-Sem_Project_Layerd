package lk.ijse.semisterfinal.Dao.Custom.impl;

import lk.ijse.semisterfinal.DB.DbConnetion;
import lk.ijse.semisterfinal.Dao.Custom.EmployeeDao;
import lk.ijse.semisterfinal.Dao.SqlUtil;
import lk.ijse.semisterfinal.dto.AddEmployeeDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public boolean Add(AddEmployeeDTO e) throws SQLException, ClassNotFoundException {
       return SqlUtil.test("INSERT INTO employee VALUES(?,?,?,?,?,?,?,?,?,?,?,?)",e.getEmployeeId(),e.getEmployeeName(),e.getEmpAddress(),e.getEmployeePhone(),e.getEmpDate(),e.getEmpPosition(),
               e.getEmail(),e.getGender(),e.getEducation(),e.getBasicSalary(),e.getExpiriance(),e.getDe());

    }

    @Override
    public ArrayList<AddEmployeeDTO> getAll() throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SqlUtil.test("SELECT * FROM employee");

        ArrayList <AddEmployeeDTO> dtoList = new ArrayList<>();

        while (resultSet.next()) {
                    AddEmployeeDTO dto = new AddEmployeeDTO(
                            resultSet.getString("employeeId"),
                            resultSet.getString("EmployeeName"),
                            resultSet.getString("EmpAddress"),
                            resultSet.getInt("EmployeePhone"),
                            resultSet.getString("empDate"),
                            resultSet.getString("empPosition"),
                            resultSet.getString("email"),
                            resultSet.getString("Gender"),
                            resultSet.getString("Education"),
                            resultSet.getDouble("BasicSalary"),
                            resultSet.getString("Expiriance"),
                            resultSet.getString("de"));

            dtoList.add(dto);
        }

        return dtoList;
    }

    @Override
    public boolean update(AddEmployeeDTO dto) throws SQLException {
        Connection connection = DbConnetion.getInstance().getConnection();

        String sql = "UPDATE employee SET employee_name = ?, employee_address = ?, employee_teliphone = ?, job_start_date = ? , position =?, email =?, gender =?, education =?, basicSalary =?, experiance =?, department =?  WHERE employee_id = ?";

        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1,dto.getEmployeeName());
        pstm.setString(2,dto.getEmpAddress());
        pstm.setInt(3,dto.getEmployeePhone());
        pstm.setString(4, dto.getEmpDate());
        pstm.setString(5, dto.getEmpPosition());
        pstm.setString(6, dto.getEmail());
        pstm.setString(7, dto.getGender());
        pstm.setString(8, dto.getEducation());
        pstm.setDouble(9, dto.getBasicSalary());
        pstm.setString(10, dto.getExpiriance());
        pstm.setString(11, dto.getDe());
        pstm.setString(12, dto.getEmployeeId());

        return pstm.executeUpdate() >0;

    }

    @Override
    public AddEmployeeDTO search(String id) throws SQLException {
        Connection connection = DbConnetion.getInstance().getConnection();

        String sql = "SELECT * FROM employee WHERE employee_id = ? ";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, id);

        ResultSet resultSet = pstm.executeQuery();

        AddEmployeeDTO dto = null;

        if (resultSet.next()){
            String eid = resultSet.getString(1);
            String name = resultSet.getString(2);
            String address = resultSet.getString(3);
            int mobile = Integer.parseInt(String.valueOf(resultSet.getInt(4)));
            String date = resultSet.getString(5);
            String email = resultSet.getString(5);
            String position = resultSet.getString(6);

            dto = new AddEmployeeDTO(eid,name,address,mobile,date,email,position);
        }
        return dto;
    }


    @Override
    public boolean delete(String id) throws SQLException {
        Connection connection = DbConnetion.getInstance().getConnection();

        String sql = "DELETE FROM employee WHERE employee_id = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, id);

        return pstm.executeUpdate() > 0;
    }

}
