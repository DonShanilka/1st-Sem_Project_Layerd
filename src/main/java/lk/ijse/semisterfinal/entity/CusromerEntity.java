package lk.ijse.semisterfinal.entity;


import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter

public class CusromerEntity implements Serializable {
    private String txtCustId;
    private String txtCustAddress;
    private String txtCustName;
    private String txtCustMobile;
    private String txtCustitemId;
    private String txtCustPayment;

    public CusromerEntity(String custId, String custAddress, String custName, String custMobile, String payment) {
        txtCustId = custId;
        txtCustAddress = custAddress;
        txtCustName = custName;
        txtCustMobile = custMobile;
        txtCustPayment = payment;
    }

    public CusromerEntity(String cid) {
        txtCustId = cid;
    }
}
