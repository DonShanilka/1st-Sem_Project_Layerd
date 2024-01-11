package lk.ijse.semisterfinal.Bo;

import lk.ijse.semisterfinal.Dao.Custom.impl.*;
import lk.ijse.semisterfinal.Dao.DaoFactory;
import lk.ijse.semisterfinal.Dao.SupperDAO;

public class BoFactory {

    private static BoFactory boFactory;

    private BoFactory(){}

    public static BoFactory getDaoFactory(){
        return boFactory == null ? boFactory = new BoFactory() : boFactory;
    }

    public enum BoTyps{
        ADMIN,ATTENDANCE,CASHIYER,CUSTOMER,EMPLOYEE,ITEM,ORDERS,ORDERDETAIL,SALARY,SUPPLIER
    }

    public SupperDAO getDAO(BoTyps boTyps){
        switch (boTyps) {
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
                return (SupperDAO) new OrderDetailsDaoImpl();
            case SALARY:
                return new SalaryDaoImpl();
            case SUPPLIER:
                return new SupplierDaoImpl();
            default:
                return null;
        }
    }

}
