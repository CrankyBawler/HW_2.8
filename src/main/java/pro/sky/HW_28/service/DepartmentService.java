package pro.sky.HW_28.service;

import pro.sky.HW_28.entity.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee maxSalary(int departmentId);

    Employee minSalary(int departmentId);

    Collection<Employee> findForDepartment(int departmentId);

    Collection<Employee> findAll();
}
