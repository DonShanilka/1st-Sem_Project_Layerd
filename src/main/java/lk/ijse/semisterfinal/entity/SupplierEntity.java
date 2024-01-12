package lk.ijse.semisterfinal.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Setter
@Getter
@ToString

public class SupplierEntity {
    private String supNic;
    private String supName;
    private int mobile;
    private String email;
    private String coName;
    private String coAddress;
    private int itemcode;
    private String itemName;
    private int qty;
    private String bNum;
    private String catagory;

    public SupplierEntity(String supId, String supName, int mobile, String email, String coName, String coAddress, int itemcode, String itemName, int qty, String bNum, String catagory) {
        this.supNic = supId;
        this.supName = supName;
        this.mobile = mobile;
        this.email = email;
        this.coName = coName;
        this.coAddress = coAddress;
        this.itemcode = itemcode;
        this.itemName = itemName;
        this.qty = qty;
        this.bNum = bNum;
        this.catagory = catagory;

    }


    public SupplierEntity(String supName, int mobile, String email, String coName, String coAddress, int itemcode, String itemName, int qty, String bNum, String catagory, String supId) {
        this.supName = supName;
        this.mobile = mobile;
        this.email = email;
        this.coName = coName;
        this.coAddress = coAddress;
        this.itemcode = itemcode;
        this.itemName = itemName;
        this.qty = qty;
        this.bNum = bNum;
        this.catagory = catagory;
        this.supNic = supId;
    }

    public SupplierEntity(String sid) {
        supNic = sid;
    }
}
