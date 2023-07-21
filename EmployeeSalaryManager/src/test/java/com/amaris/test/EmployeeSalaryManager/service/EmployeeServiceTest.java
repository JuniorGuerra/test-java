package com.amaris.test.EmployeeSalaryManager.service;

import com.amaris.test.EmployeeSalaryManager.model.Employee;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class EmployeeServiceTest {
    @Test
    public void testCalculateAnnualSalary() {

        Employee employee = new Employee();
        employee.setEmployeeSalary(50000);

        EmployeeService employeeService = new EmployeeService();


        double result = employeeService.calculateAnnualSalary(employee.getEmployeeSalary());

        assertEquals(600000, result, 0.001);
    }
}
