package lk.ijse.semisterfinal.Bo.Custom.impl;

import lk.ijse.semisterfinal.Bo.Custom.SalaryBo;
import lk.ijse.semisterfinal.Dao.Custom.SalaryDao;
import lk.ijse.semisterfinal.Dao.DaoFactory;
import lk.ijse.semisterfinal.dto.AddEmployeeDTO;
import lk.ijse.semisterfinal.dto.AtendanceDTO;
import lk.ijse.semisterfinal.dto.SalaryDTO;
import lk.ijse.semisterfinal.entity.AddEmployeeEntity;
import lk.ijse.semisterfinal.entity.AtendanceEntity;
import lk.ijse.semisterfinal.entity.SalaryEntity;

import java.sql.SQLException;
import java.util.ArrayList;

public class SalaryBoImpl implements SalaryBo {

    SalaryDao salaryDao = (SalaryDao) DaoFactory.getDaoFactory().getDAO(DaoFactory.DaoTyps.SALARY);

    @Override
    public boolean add(SalaryDTO dto) throws SQLException, ClassNotFoundException {
        return salaryDao.add(new SalaryEntity(dto.getDate(), dto.getEmployeeId(), dto.getEmployeeName(),
                dto.getSalary(), dto.getOtcount(), dto.getPay1h(), dto.getBonase(),
                dto.getEpf(), dto.getEtf(), dto.getPrCount(), dto.getAbcount(), dto.getTotalsalary()));
    }

    @Override
    public ArrayList<SalaryDTO> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<SalaryEntity> entities = salaryDao.getAll();
        ArrayList<SalaryDTO> dtos = new ArrayList<>();
        for (SalaryEntity dto : entities) {
            dtos.add(new SalaryDTO(dto.getDate(), dto.getEmployeeId(), dto.getEmployeeName(),
                    dto.getSalary(), dto.getOtcount(), dto.getPay1h(), dto.getBonase(),
                    dto.getEpf(), dto.getEtf(), dto.getPrCount(), dto.getAbcount(), dto.getTotalsalary()));
        }
        return dtos;

    }

    @Override
    public AtendanceDTO getABcount(String id) throws SQLException, ClassNotFoundException {
        AtendanceEntity dto = salaryDao.getABcount(id);
        return new AtendanceDTO(dto.getEmployeeId(), dto.getEmployeeName(), dto.getDate(),dto.getPOra());
    }

    @Override
    public AtendanceDTO getPRcount(String id) throws SQLException, ClassNotFoundException {
        AtendanceEntity dto = salaryDao.getPRcount(id);
        return new AtendanceDTO(dto.getEmployeeId(), dto.getEmployeeName(), dto.getDate(),dto.getPOra());
    }
}
