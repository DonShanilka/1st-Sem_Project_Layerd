package lk.ijse.semisterfinal.Dao.Custom;

import lk.ijse.semisterfinal.Dao.CrudDAO;
import lk.ijse.semisterfinal.dto.CusromerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CustomerDao extends CrudDAO <CusromerDTO> {
    boolean add(CusromerDTO dto) throws SQLException, ClassNotFoundException;
    boolean delete(CusromerDTO id) throws SQLException, ClassNotFoundException;

    boolean update(CusromerDTO dto) throws SQLException, ClassNotFoundException;

    ArrayList <CusromerDTO> getAll() throws SQLException, ClassNotFoundException;

    CusromerDTO searchCustomer(String id) throws SQLException;
}
