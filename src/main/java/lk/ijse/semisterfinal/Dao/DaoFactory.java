package lk.ijse.semisterfinal.Dao;

import lk.ijse.semisterfinal.Dao.Custom.impl.*;

public class DaoFactory {

    private static DaoFactory daoFactory;

    private DaoFactory(){}

    public static DaoFactory getDaoFactory(){
        return daoFactory == null ? daoFactory = new DaoFactory() : daoFactory;
    }

    public enum DaoTyps{
        ADMIN,ATTENDANCE,CASHIYER,CUSTOMER,EMPLOYEE,ITEM,ORDERS,ORDERDETAIL,SALARY,SUPPLIER
    }

    public SupperDAO getDAO(DaoTyps daoTypes){
        switch (daoTypes) {
            case ADMIN:
                return new AdminLoginImpl();
            case ATTENDANCE:
                return new AttendanceDaoImpl();
            case CASHIYER:
                return new CashiyerDaoImpl();
            case CUSTOMER:
                return new CustomerDaoImpl();
            case EMPLOYEE:
                return new EmployeeDaoImpl();
            case ITEM:
                return new ItemDaoImpl();
            case ORDERS:
                return new OrderDaoImpl();
            case ORDERDETAIL:
                return new OrderDetailsDaoImpl();
            case SALARY:
                return new SalaryDaoImpl();
            case SUPPLIER:
                return new SupplierDaoImpl();
            default:
                return null;
        }
    }

}
