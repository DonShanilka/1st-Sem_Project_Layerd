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


}
