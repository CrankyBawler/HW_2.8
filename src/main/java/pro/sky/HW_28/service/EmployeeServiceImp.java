package pro.sky.HW_28.service;

import org.springframework.stereotype.Service;
import pro.sky.HW_28.entity.Employee;
import pro.sky.HW_28.exception.EmployeeAlreadyAddedException;
import pro.sky.HW_28.exception.EmployeeNotFoundExection;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeServiceImp  implements EmployeeService{
    private static final int MAX_SIZE = 100;
    Map<String, Employee> employees = new HashMap<>(Map.of(
            "Ефим Бобров", new Employee("Ефим", "Бобров"),
            "Тихон Гуляев", new Employee("Тихон", "Гуляев"),
            "Савели Шашков", new Employee("Савели", "Шашков"),
            "Остап Николаев", new Employee("Остап", "Николаев"),
            "Алексей Шаров", new Employee("Алексей", "Шаров"),
            "Дарья Вишнякова", new Employee("Дарья", "Вишнякова"),
            "Астра Калашникова", new Employee("Астра", "Калашникова"),
            "Роксана Беспалова", new Employee("Роксана", "Беспалова"),
            "Хильда Лазарева", new Employee("Хильда", "Лазарева"),
            "Дана Уварова", new Employee("Дана", "Уварова")
    ));

    @Override
    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }



    @Override
    public Employee remove(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            return employees.remove(employee.getFullName());
        }
        throw new EmployeeNotFoundExection();
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (employees.containsKey(employee.getFullName())) {
            return employees.get(employee.getFullName());
        }
        throw new EmployeeNotFoundExection();
    }

    @Override
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }

}

