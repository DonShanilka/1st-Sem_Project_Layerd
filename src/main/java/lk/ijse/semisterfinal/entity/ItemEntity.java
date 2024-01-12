package lk.ijse.semisterfinal.entity;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor


public class ItemEntity {
    private String ItemCode;
    private String itemDetails;
    private double ItemPrice;
    private String SupplierId;
    private String WarrantyPeriod;
    private int ItemQty;
    private String cato;


    public ItemEntity(String itemCode, String itemName, double itemPrice, String supId, String warranty, String qty, String cato) {
        ItemCode = itemCode;
        itemDetails = itemName;
        ItemPrice = itemPrice;
        SupplierId = supId;
        WarrantyPeriod = warranty;
        ItemQty = Integer.parseInt(qty);
        this.cato = cato;
    }

    public ItemEntity(String iId) {
        ItemCode = iId;
    }
}
