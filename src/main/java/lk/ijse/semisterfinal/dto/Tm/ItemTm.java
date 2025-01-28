package lk.ijse.semisterfinal.dto.Tm;

import lombok.*;

@Getter
@Setter
@ToString

public class ItemTm {

        private String ItemCode;
        private String itemDetails;
        private double ItemPrice;
        private String SupplierId;
        private String WarrantyPeriod;
        private int ItemQty;
        private String cato;

    public ItemTm(String itemCode, String itemDetails, double itemPrice, String supplierId, String warrantyPeriod,int ItemQty,String cato) {
        ItemCode = itemCode;
        this.itemDetails = itemDetails;
        ItemPrice = itemPrice;
        SupplierId = supplierId;
        WarrantyPeriod = warrantyPeriod;
        this.ItemQty = ItemQty;
        this.cato = cato;
    }

    public ItemTm(String supId) {
        SupplierId = supId;
    }

}


