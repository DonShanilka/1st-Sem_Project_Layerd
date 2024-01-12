package lk.ijse.semisterfinal.Dao.Custom.impl;

import lk.ijse.semisterfinal.Dao.Custom.SupplierDao;
import lk.ijse.semisterfinal.Dao.SqlUtil;
import lk.ijse.semisterfinal.dto.SupplierDTO;
import lk.ijse.semisterfinal.entity.SupplierEntity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierDaoImpl implements SupplierDao{
    @Override
    public boolean add(SupplierEntity dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("INSERT INTO supplier VALUES(?,?,?,?,?,?,?,?,?,?,?)",
                dto.getSupNic(),dto.getSupName(),dto.getMobile(),dto.getEmail(),dto.getCoName(),dto.getCoAddress(),dto.getItemcode(),
                dto.getItemName(),dto.getQty(),dto.getBNum(),dto.getCatagory());

    }

    @Override
    public boolean delete(SupplierEntity id) throws SQLException, ClassNotFoundException {
       return SqlUtil.test("DELETE FROM supplier WHERE supplier_id = ?",id.getSupNic());

    }


    @Override
    public boolean update(SupplierEntity dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("UPDATE supplier SET supplier_name = ?,mobile = ?, email = ?, company_name = ?, company_address = ?, item_code = ?, item_name = ?, qty = ?, bacth_num = ?, item_catagory = ? WHERE supplier_id = ?",
                dto.getSupName(),dto.getMobile(),dto.getEmail(),dto.getCoName(),dto.getCoAddress(),dto.getItemcode(),
                dto.getItemName(),dto.getQty(),dto.getBNum(),dto.getCatagory(),dto.getSupNic());

    }

    @Override
    public ArrayList<SupplierEntity> getAll() throws SQLException, ClassNotFoundException {

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
    public SupplierEntity searchsupplier(String id) throws SQLException, ClassNotFoundException {
        PreparedStatement pstm = SqlUtil.test("SELECT * FROM supplier WHERE supplier_id = ? ");
        pstm.setString(1, id);

        ResultSet resultSet = pstm.executeQuery();

        SupplierEntity dto = null;

        if (resultSet.next()){
            String supId = resultSet.getString(1);
            String supName = resultSet.getString(2);
            int mobile = resultSet.getInt(3);
            String email = resultSet.getString(4);
            String coName = resultSet.getString(5);
            String coAddress = resultSet.getString(6);
            int itemcode = resultSet.getInt(7);
            String itemName = resultSet.getString(8);
            int qty = resultSet.getInt(9);
            String bNum = resultSet.getString(10);
            String catagory = resultSet.getString(11);

            dto = new SupplierEntity(supId,supName,mobile,email,coName,coAddress,itemcode,itemName,qty,bNum,catagory);

        }
        return dto;
    }


}
