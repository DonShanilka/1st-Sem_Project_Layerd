package lk.ijse.semisterfinal.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class IncomeEntity {
    private String order_id;
    private String item_code;
    private String qty;
    private String unit_price;
}
