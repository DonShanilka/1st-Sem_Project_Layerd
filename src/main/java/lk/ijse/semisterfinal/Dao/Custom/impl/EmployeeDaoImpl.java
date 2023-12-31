package lk.ijse.semisterfinal.Dao.Custom.impl;


import lk.ijse.semisterfinal.Dao.Custom.EmployeeDao;
import lk.ijse.semisterfinal.Dao.SqlUtil;
import lk.ijse.semisterfinal.dto.AddEmployeeDTO;
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
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getInt(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getString(7),
                            resultSet.getString(8),
                            resultSet.getString(9),
                            resultSet.getDouble(10),
                            resultSet.getString(11),
                            resultSet.getString(12));

            dtoList.add(dto);
        }

        return dtoList;
    }


    @Override
    public boolean update(AddEmployeeDTO dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("UPDATE employee SET employee_name = ?, employee_address = ?, employee_teliphone = ?, job_start_date = ? , position =?, email =?, gender =?, education =?, basicSalary =?, experiance =?, department =?  WHERE employee_id = ?",
                dto.getEmployeeName(),dto.getEmpAddress(),dto.getEmployeePhone(),dto.getEmpDate(),dto.getEmpPosition(),
                dto.getEmail(),dto.getGender(),dto.getEducation(),dto.getBasicSalary(),dto.getExpiriance(),dto.getDe(),dto.getEmployeeId());

    }


    @Override
    public boolean delete(AddEmployeeDTO id) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("DELETE FROM employee WHERE employee_id = ?",id.getEmployeeId());

    }

}
