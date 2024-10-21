package pro.sky.HW_28.service;

import org.springframework.stereotype.Service;
import pro.sky.HW_28.entity.Employee;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Service
public class DepartmentSericeImpl implements DepartmentService {

    private final EmployeeServiceImp employeeServiceImp;

    public DepartmentSericeImpl(EmployeeServiceImp employeeServiceImp) {
        this.employeeServiceImp = employeeServiceImp;
    }


    @Override
    public Employee maxSalary(int departmentId) {
        return employeeServiceImp.findAll()
                .stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .max(Comparator.comparing(Employee::getSalary))
                .orElse(null);

    }

    @Override
    public Employee minSalary(int departmentId) {
        return employeeServiceImp.findAll()
                .stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .min(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }

    @Override
    public Collection<Employee> findForDepartment(int departmentId) {
        return employeeServiceImp.findAll()
                .stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> allForDepartment() {

        return employeeServiceImp.findAll()
                .stream()
                .collect(Collectors.groupingBy(Employee ::getDepartment));
    }
}
