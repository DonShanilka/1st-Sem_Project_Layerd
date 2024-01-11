package lk.ijse.semisterfinal.Dao.Custom.impl;

import lk.ijse.semisterfinal.Dao.Custom.SupplierDao;
import lk.ijse.semisterfinal.Dao.SqlUtil;
import lk.ijse.semisterfinal.dto.SupplierDTO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SupplierDaoImpl implements SupplierDao{
    @Override
    public boolean add(SupplierDTO dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("INSERT INTO supplier VALUES(?,?,?,?,?,?,?,?,?,?,?)",
                dto.getSupNic(),dto.getSupName(),dto.getMobile(),dto.getEmail(),dto.getCoName(),dto.getCoAddress(),dto.getItemcode(),
                dto.getItemName(),dto.getQty(),dto.getBNum(),dto.getCatagory());

    }

    @Override
    public boolean delete(SupplierDTO id) throws SQLException, ClassNotFoundException {
       return SqlUtil.test("DELETE FROM supplier WHERE supplier_id = ?",id.getSupNic());

    }


    @Override
    public boolean update(SupplierDTO dto) throws SQLException, ClassNotFoundException {
        return SqlUtil.test("UPDATE supplier SET supplier_name = ?,mobile = ?, email = ?, company_name = ?, company_address = ?, item_code = ?, item_name = ?, qty = ?, bacth_num = ?, item_catagory = ? WHERE supplier_id = ?",
                dto.getSupName(),dto.getMobile(),dto.getEmail(),dto.getCoName(),dto.getCoAddress(),dto.getItemcode(),
                dto.getItemName(),dto.getQty(),dto.getBNum(),dto.getCatagory(),dto.getSupNic());

    }

    @Override
    public ArrayList<SupplierDTO> getAll() throws SQLException, ClassNotFoundException {

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
