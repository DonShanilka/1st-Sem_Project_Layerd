package lk.ijse.semisterfinal.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;


@NoArgsConstructor
@Getter
@Setter
@ToString

public class AddEmployeeEntity {
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

    public AddEmployeeEntity(String id, String name, String address, int tele, String date, String email, String position) {
        this.employeeId = id;
        this.EmployeeName = name;
        this.EmpAddress = address;
        this.EmployeePhone = tele;
        this.empDate = date;
        this.email = email;
        this.empPosition = position;
    }


    public AddEmployeeEntity(String id, String name, String address, int tele, String date, String email, String position, String gende, String education, double basic, String experiance, String de) {
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

    public AddEmployeeEntity(String eid) {
        employeeId = eid;
    }

    public AddEmployeeEntity(String eid, String name, String address, int mobile, String date, String email, String position, double bSalary) {
        this.employeeId = eid;
        this.EmployeeName = name;
        this.EmpAddress = address;
        this.EmployeePhone = mobile;
        this.empDate = date;
        this.empPosition = position;
        this.email = email;
        this.BasicSalary = bSalary;

    }


}
