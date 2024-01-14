package lk.ijse.semisterfinal.dto;

import lk.ijse.semisterfinal.dto.Factory.SuperDto;
import lombok.*;


@NoArgsConstructor
@Getter
@Setter
@ToString

public class AddEmployeeDTO implements SuperDto {
    private String employeeId;
    private String EmployeeName;
    private String EmpAddress;
    private int EmployeePhone;
    private String empDate;
    private String empPosition;
    private String email;
    private String Gender;
    private String Education;
    private double BasicSalary;
    private String Expiriance;
    private String de;

    public AddEmployeeDTO(String id, String name, String address, int tele, String date, String email, String position) {
        this.employeeId = id;
        this.EmployeeName = name;
        this.EmpAddress = address;
        this.EmployeePhone = tele;
        this.empDate = date;
        this.email = email;
        this.empPosition = position;
    }


    public AddEmployeeDTO(String id, String name, String address, int tele, String date, String email, String position, String gende, String education, double basic, String experiance, String de) {
        this.employeeId = id;
        this.EmployeeName = name;
        this.EmpAddress = address;
        this.EmployeePhone = tele;
        this.empDate = date;
        this.empPosition = position;
        this.email = email;
        this.Gender = gende;
        this.Education = education;
        this.BasicSalary = basic;
        this.Expiriance = experiance;
        this.de = de;
    }

    public AddEmployeeDTO(String eid) {
        employeeId = eid;
    }

    public AddEmployeeDTO(String eid, String name, String address, int mobile, String date, String email, String position, double bSalary) {
        this.employeeId = eid;
        this.EmployeeName = name;
        this.EmpAddress = address;
        this.EmployeePhone = mobile;
        this.empDate = date;
        this.empPosition = position;
        this.email = email;
        this.BasicSalary = bSalary;

    }

    public AddEmployeeDTO(String employeeId, String employeeName,String email,double bSalary) {
        this.employeeId = employeeId;
        this.EmployeeName = employeeName;
        this.email = email;
        this.BasicSalary = bSalary;
    }

    public AddEmployeeDTO(String employeeName, String empAddress, int employeePhone, String empDate, String empPosition, String email, String gender, String education, double basicSalary, String expiriance, String de, String employeeId) {

        this.employeeId = employeeId;
        this.EmployeeName = employeeName;
        this.EmpAddress = empAddress;
        this.EmployeePhone = employeePhone;
        this.empDate = empDate;
        this.empPosition = empPosition;
        this.email = email;
        this.Gender = gender;
        this.Education = education;
        this.BasicSalary = basicSalary;
        this.Expiriance = expiriance;
        this.de = de;

    }


}
