package lk.ijse.semisterfinal.Bo.Custom.impl;

import lk.ijse.semisterfinal.Bo.Custom.EmployeeBo;
import lk.ijse.semisterfinal.Dao.Custom.EmployeeDao;
import lk.ijse.semisterfinal.Dao.Custom.impl.EmployeeDaoImpl;
import lk.ijse.semisterfinal.Dao.DaoFactory;
import lk.ijse.semisterfinal.dto.AddEmployeeDTO;
import lk.ijse.semisterfinal.entity.AddEmployeeEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeBoImpl implements EmployeeBo {

    EmployeeDao employeeDao = (EmployeeDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DaoTyps.EMPLOYEE);


    @Override
    public boolean add(AddEmployeeDTO dto) throws SQLException, ClassNotFoundException {
        return employeeDao.add(new AddEmployeeEntity(dto.getEmployeeId(),dto.getEmployeeName(),dto.getEmpAddress(),dto.getEmployeePhone(),
                dto.getEmpDate(),dto.getEmpPosition(),
                dto.getEmail(),dto.getGender(),dto.getEducation(),
                dto.getBasicSalary(),dto.getExpiriance(),dto.getDe()));

    }


    @Override
    public ArrayList<AddEmployeeDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<AddEmployeeEntity> employees = employeeDao.getAll();
        ArrayList<AddEmployeeDTO> employeeDtos = new ArrayList<>();
        for (AddEmployeeEntity dto:employees){
            employeeDtos.add(new AddEmployeeDTO(dto.getEmployeeId(),dto.getEmployeeName(),dto.getEmpAddress(),dto.getEmployeePhone(),
                    dto.getEmpDate(),dto.getEmpPosition(),
                    dto.getEmail(),dto.getGender(),dto.getEducation(),
                    dto.getBasicSalary(),dto.getExpiriance(),dto.getDe()));
        }
        return employeeDtos;

    }


    @Override
    public boolean update(AddEmployeeDTO dto) throws SQLException, ClassNotFoundException {
        return employeeDao.update(new AddEmployeeEntity(dto.getEmployeeId(),dto.getEmployeeName(),dto.getEmpAddress(),dto.getEmployeePhone(),dto.getEmpDate(),dto.getEmpPosition(),
                dto.getEmail(),dto.getGender(),dto.getEducation(),dto.getBasicSalary(),dto.getExpiriance(),dto.getDe()));
    }


    @Override
    public boolean delete(AddEmployeeDTO id) throws SQLException, ClassNotFoundException {
        return employeeDao.delete(new AddEmployeeEntity(id.getEmployeeId()));
    }


    @Override
    public AddEmployeeDTO searchEmployee(String id) throws SQLException, ClassNotFoundException {
        AddEmployeeEntity dto = employeeDao.searchEmployee(id);
        return new AddEmployeeDTO(dto.getEmployeeId(),dto.getEmployeeName(),
                dto.getEmail(),dto.getBasicSalary());
    }
}
