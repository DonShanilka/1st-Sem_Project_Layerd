package lk.ijse.semisterfinal.dto;

import lk.ijse.semisterfinal.dto.Factory.SuperDto;
import lombok.*;

@Getter
@Setter
@ToString

public class AtendanceDTO implements SuperDto {
    private String date;
    private String employeeId;
    private String employeeName;
    private String pOra;
    private String anInt;
    private String abInt;

    public AtendanceDTO(String date, String id, String name, String pOra) {
        this.date = String.valueOf(date);
        employeeId = id;
        employeeName = name;
        this.pOra = pOra;
    }

    public AtendanceDTO(String anInt) {
        this.abInt = anInt;
    }



}
