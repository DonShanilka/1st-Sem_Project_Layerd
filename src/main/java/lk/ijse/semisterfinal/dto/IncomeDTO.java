package lk.ijse.semisterfinal.dto;

import lk.ijse.semisterfinal.dto.Factory.SuperDto;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class IncomeDTO implements SuperDto {
    private String order_id;
    private String item_code;
    private String qty;
    private String unit_price;
}
