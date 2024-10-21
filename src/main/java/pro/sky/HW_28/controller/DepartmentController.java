package pro.sky.HW_28.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.HW_28.entity.Employee;
import pro.sky.HW_28.service.DepartmentService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee maxSalary(@RequestParam int departmentId) {
        return departmentService.maxSalary(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee minSalary(@RequestParam int departmentId) {
        return departmentService.minSalary(departmentId);
    }

    @GetMapping("/all")
    public List <Employee> findForDepartment(@RequestParam int departmentId) {
        return (List<Employee>) departmentService.findForDepartment(departmentId);
    }

    @GetMapping("/all-departments")
    public Map <Integer, List<Employee>> findAllForDepartment (){
        return departmentService.allForDepartment ();
    }
}
