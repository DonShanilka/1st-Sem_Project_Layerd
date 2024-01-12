package lk.ijse.semisterfinal.Bo;

import lk.ijse.semisterfinal.Bo.Custom.impl.*;

public class BoFactory {

    private static BoFactory boFactory;

    private BoFactory(){}

    public static BoFactory getBoFactory(){
        return boFactory == null ? boFactory = new BoFactory() : boFactory;
    }

    public enum BoTyps{
        ADMIN,ATTENDANCE,CASHIYER,CUSTOMER,EMPLOYEE,ITEM,SALARY,SUPPLIER
    }

    public SupperBo getBo(BoTyps boTyps){
        switch (boTyps) {
            case ADMIN:
                return new AdminLoginBoImpl();
            case ATTENDANCE:
                return new AttendanceBoImpl();
            case CASHIYER:
                return new CashiyerBoImpl();
            case CUSTOMER:
                return new CustomerBoImpl();
            case EMPLOYEE:
                return new EmployeeBoImpl();
            case ITEM:
                return new ItemBoImpl();
            case SALARY:
                return new SalaryBoImpl();
            case SUPPLIER:
                return new SupplierBoImpl();
            default:
                return null;
        }
    }

}
