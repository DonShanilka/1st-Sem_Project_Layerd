package lk.ijse.semisterfinal.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class AtendanceEntity {
    private String date;
    private String employeeId;
    private String employeeName;
    private String pOra;
    private String anInt;
    private String abInt;

    public AtendanceEntity(String date, String id, String name, String pOra) {
        this.date = String.valueOf(date);
        employeeId = id;
        employeeName = name;
        this.pOra = pOra;
    }

    public AtendanceEntity(String anInt) {
        this.abInt = anInt;
    }


    public AtendanceEntity(String date, String employeeId, String employeeName, String date1, String pOra) {
        this.date = String.valueOf(date);
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.pOra = pOra;
    }

    public AtendanceEntity(String employeeId, String employeeName, String date, String pOra, String abInt, String anInt) {
        this.date = String.valueOf(date);
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.pOra = pOra;
    }
}
