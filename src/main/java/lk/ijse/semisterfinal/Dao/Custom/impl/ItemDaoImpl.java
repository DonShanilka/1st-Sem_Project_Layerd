package lk.ijse.semisterfinal.Dao.Custom.impl;

import lk.ijse.semisterfinal.DB.DbConnetion;
import lk.ijse.semisterfinal.Dao.Custom.ItemDao;
import lk.ijse.semisterfinal.Dao.SqlUtil;
import lk.ijse.semisterfinal.dto.Tm.CartTm;
import lk.ijse.semisterfinal.dto.ItemDTO;
import lk.ijse.semisterfinal.dto.SupplierDTO;
import lk.ijse.semisterfinal.entity.ItemEntity;
import lk.ijse.semisterfinal.entity.SupplierEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDaoImpl implements ItemDao {

    @Override
    public boolean add(ItemEntity dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("INSERT INTO item VALUES(?,?,?,?,?,?,?)",dto.getItemCode(),dto.getItemDetails(),dto.getItemPrice(),
                dto.getSupplierId(),dto.getWarrantyPeriod(),dto.getItemQty(),dto.getCato());
    }

    @Override
    public boolean delete(ItemEntity id) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("DELETE FROM item WHERE item_code = ?",id.getItemCode());
    }


    @Override
    public boolean update(ItemEntity dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("UPDATE item SET item_name = ?, item_price = ?, supplier_id = ? , warranty =?, qty =?, catogary =?  WHERE item_code = ?",
                dto.getItemDetails(),dto.getItemPrice(),dto.getSupplierId(),dto.getWarrantyPeriod(),dto.getItemQty(),dto.getCato(),dto.getItemCode());

    }


    @Override
    public ArrayList<ItemEntity> getAll() throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SqlUtil.test("SELECT * FROM Item");
        ArrayList <ItemEntity> dtoList = new ArrayList<>();

        while(resultSet.next()) {
            dtoList.add(
                    new ItemEntity(
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


    public ArrayList<SupplierEntity> getAllSupplier() throws SQLException, ClassNotFoundException {

        ResultSet resultSet = SqlUtil.test("SELECT * FROM supplier");
        ArrayList<SupplierEntity> dtoList = new ArrayList<>();

        while(resultSet.next()) {
            dtoList.add(
                    new SupplierEntity(
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

    public ItemEntity searchItemId(String id) throws SQLException {
        Connection connection = DbConnetion.getInstance().getConnection();

        String sql = "SELECT * FROM item WHERE item_code = ? ";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, id);

        ResultSet resultSet = pstm.executeQuery();

        ItemEntity dto = null;

        if (resultSet.next()){
            String item_code = resultSet.getString(1);
            String item_name = resultSet.getString(2);
            double item_price = Double.parseDouble(resultSet.getString(3));
            String sup_id = resultSet.getString(4);
            String warranty = resultSet.getString(5);
            String qty = String.valueOf(resultSet.getInt(6));
            String cat = resultSet.getString(7);

            dto = new ItemEntity(item_code,item_name,item_price,sup_id,warranty,qty,cat);
        }
        return dto;
    }

}
