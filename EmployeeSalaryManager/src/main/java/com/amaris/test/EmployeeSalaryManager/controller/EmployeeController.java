package com.amaris.test.EmployeeSalaryManager.controller;

import com.amaris.test.EmployeeSalaryManager.model.Employee;
import com.amaris.test.EmployeeSalaryManager.model.EmployeeApiResponse;
import com.amaris.test.EmployeeSalaryManager.model.EmployeesApiResponse;
import com.amaris.test.EmployeeSalaryManager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping
    public EmployeesApiResponse getEmployees (){
        return employeeService.getAllEmployees();
    }

    @GetMapping(path = "{employeeId}")
    public EmployeeApiResponse getEmployee(@PathVariable int employeeId) {
        return employeeService.getEmployeById(employeeId);
    }

}
