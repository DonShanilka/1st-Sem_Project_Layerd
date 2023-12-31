package lk.ijse.semisterfinal.Dao.Custom.impl;

import lk.ijse.semisterfinal.Dao.Custom.ItemDao;
import lk.ijse.semisterfinal.Dao.SqlUtil;
import lk.ijse.semisterfinal.dto.ItemDTO;
import lk.ijse.semisterfinal.dto.SupplierDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ItemDaoImpl implements ItemDao {

    @Override
    public boolean addItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("INSERT INTO item VALUES(?,?,?,?,?,?,?)",dto.getItemCode(),dto.getItemDetails(),dto.getItemPrice(),
                dto.getSupplierId(),dto.getWarrantyPeriod(),dto.getItemQty(),dto.getCato());
    }


    @Override
    public boolean deleteItem(ItemDTO id) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("DELETE FROM item WHERE item_code = ?",id.getItemCode());
    }


    @Override
    public boolean updateItem(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("UPDATE item SET item_name = ?, item_price = ?, supplier_id = ? , warranty =?, qty =?, catogary =?  WHERE item_code = ?",
                dto.getItemDetails(),dto.getItemPrice(),dto.getSupplierId(),dto.getWarrantyPeriod(),dto.getItemQty(),dto.getCato(),dto.getItemCode());

    }


    @Override
    public ArrayList<ItemDTO> getAllItem() throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SqlUtil.test("SELECT * FROM Item");
        ArrayList <ItemDTO> dtoList = new ArrayList<>();

        while(resultSet.next()) {
            dtoList.add(
                    new ItemDTO(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getDouble(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getInt(6),
                            resultSet.getString(7)
                    )
            );
        }
        return dtoList;

    }


    public ArrayList<SupplierDTO> getAllSupplier() throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SqlUtil.test("SELECT * FROM supplier");
        ArrayList<SupplierDTO> dtoList = new ArrayList<>();

        while(resultSet.next()) {
            dtoList.add(
                    new SupplierDTO(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getInt(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getString(6),
                            resultSet.getInt(7),
                            resultSet.getString(8),
                            resultSet.getInt(9),
                            resultSet.getString(10),
                            resultSet.getString(11)
                    )
            );
        }
        return dtoList;

    }

}
