package com.abesproject.hclhrms;

import com.abesproject.hclhrms.entity.Employee;
import com.abesproject.hclhrms.repository.EmpRepInf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImp {

    @Autowired
    private EmpRepInf emprepo;

    // 1. React form se aane wale dynamic data ko save karega
    public String addEmp(Employee employee) {
        return emprepo.addEmp(employee);
    }

    // 2. Hardcoded test method
    public String addEmp() {
        Employee empl = new Employee(200, "Rahul", "FSD", "java", "rahul@gmail.com");
        return emprepo.addEmp(empl);
    }

    // 3. Sabhi employees ko fetch karega
    public List<Employee> getemp() {
        return emprepo.getEmp();
    }

    // 4. ID 200 wale employee ko fetch karega
    public Employee getEmpbyid() {
        return emprepo.getEmpById(200);
    }

    // 5. Bulk insert karega
    public String addEmpBulk() {
        List<Employee> employeeList = List.of(
                new Employee(897, "sonu", "inspector", "FSD", "sonu@gmail.com"),
                new Employee(565, "ramesh", "chor", "flutter", "ramesh@gmail.com")
        );
        return emprepo.addEmpBulk(employeeList);
    }

    // 6. ID 897 ko delete karega
    public String deletebyid() {
        return emprepo.deleteById(897);
    }

    // 7. ID 897 ko update karega
    public String updatebyid() {
        return emprepo.updateById(897);
    }
}