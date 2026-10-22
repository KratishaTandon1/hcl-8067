package in.demo.hrms.SalaryPack;

public class Salary {
    private BasicSalary basic;
    private DaSalary da;
    private HrSalary hr;

    public Salary(BasicSalary basic, HrSalary hr, DaSalary da) {
        this.basic = basic;
        this.hr = hr;
        this.da = da;
    }

    public int getSalary() {
        return basic.getBasic()+da.getDa()+hr.getHr();
    }
}