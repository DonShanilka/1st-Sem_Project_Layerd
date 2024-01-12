package lk.ijse.semisterfinal.Dao.Custom;

import lk.ijse.semisterfinal.Dao.CrudDAO;
import lk.ijse.semisterfinal.dto.CusromerDTO;
import lk.ijse.semisterfinal.entity.CusromerEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDao extends CrudDAO <CusromerEntity> {
    boolean add(CusromerEntity dto) throws SQLException, ClassNotFoundException;
    boolean delete(CusromerEntity id) throws SQLException, ClassNotFoundException;

    boolean update(CusromerEntity dto) throws SQLException, ClassNotFoundException;

    ArrayList <CusromerEntity> getAll() throws SQLException, ClassNotFoundException;

    CusromerEntity searchCustomer(String id) throws SQLException;
}
