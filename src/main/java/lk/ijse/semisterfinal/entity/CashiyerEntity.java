package lk.ijse.semisterfinal.entity;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class CashiyerEntity {
    private String billId;
    private String itemId;
    private String itemName;
    private int qty;
    private double itemPrice;
    private double total;
    private LocalDate date;
    private double discount;
    private double payment;
    private double balance;
}
