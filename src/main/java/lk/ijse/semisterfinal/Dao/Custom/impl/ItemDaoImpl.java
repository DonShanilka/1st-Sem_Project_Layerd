package lk.ijse.semisterfinal.Dao.Custom.impl;

import javafx.scene.control.TextField;
import lk.ijse.semisterfinal.DB.DbConnetion;
import lk.ijse.semisterfinal.Dao.Custom.ItemDao;
import lk.ijse.semisterfinal.Dao.SqlUtil;
import lk.ijse.semisterfinal.Tm.CartTm;
import lk.ijse.semisterfinal.dto.ItemDTO;
import lk.ijse.semisterfinal.dto.SupplierDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDaoImpl implements ItemDao {

    @Override
    public boolean add(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("INSERT INTO item VALUES(?,?,?,?,?,?,?)",dto.getItemCode(),dto.getItemDetails(),dto.getItemPrice(),
                dto.getSupplierId(),dto.getWarrantyPeriod(),dto.getItemQty(),dto.getCato());
    }

    @Override
    public boolean delete(ItemDTO id) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("DELETE FROM item WHERE item_code = ?",id.getItemCode());
    }


    @Override
    public boolean update(ItemDTO dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("UPDATE item SET item_name = ?, item_price = ?, supplier_id = ? , warranty =?, qty =?, catogary =?  WHERE item_code = ?",
                dto.getItemDetails(),dto.getItemPrice(),dto.getSupplierId(),dto.getWarrantyPeriod(),dto.getItemQty(),dto.getCato(),dto.getItemCode());

    }


    @Override
    public ArrayList<ItemDTO> getAll() throws SQLException, ClassNotFoundException {

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

    @Override
    public boolean update(List<CartTm> cartTmList) throws SQLException {
        for(CartTm tm : cartTmList) {
            System.out.println("Item: " + tm);
            if(!updateQty(tm.getItem_code(), Integer.parseInt(tm.getQty()))) {
                return false;
            }
        }
        return true;
    }

    public boolean updateQty(String code, int qty) throws SQLException {
        Connection connection = DbConnetion.getInstance().getConnection();

        String sql = "UPDATE item SET qty = qty - ? WHERE item_code = ?";
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setInt(1, qty);
        pstm.setString(2, code);

        return pstm.executeUpdate() > 0;
    }

}
