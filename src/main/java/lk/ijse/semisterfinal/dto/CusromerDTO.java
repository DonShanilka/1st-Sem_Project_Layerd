package lk.ijse.semisterfinal.dto;


import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter

public class CusromerDTO implements Serializable {
    private String txtCustId;
    private String txtCustAddress;
    private String txtCustName;
    private String txtCustMobile;
    private String txtCustitemId;
    private String txtCustPayment;

    public CusromerDTO(String custId, String custAddress, String custName, String custMobile, String payment) {
        txtCustId = custId;
        txtCustAddress = custAddress;
        txtCustName = custName;
        txtCustMobile = custMobile;
        txtCustPayment = payment;
    }

    public CusromerDTO(String cid) {
        txtCustId = cid;
    }
}
