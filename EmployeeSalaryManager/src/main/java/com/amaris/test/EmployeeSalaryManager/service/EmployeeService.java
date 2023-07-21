package com.amaris.test.EmployeeSalaryManager.service;

import com.amaris.test.EmployeeSalaryManager.model.Employee;
import com.amaris.test.EmployeeSalaryManager.model.EmployeeApiResponse;
import com.amaris.test.EmployeeSalaryManager.model.EmployeesApiResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class EmployeeService {
    private static final String EMPLOYEES_API_URL = "https://dummy.restapiexample.com/api/v1/employees";
    private static final String EMPLOYEE_API_URL = "https://dummy.restapiexample.com/api/v1/employee/";

    public EmployeesApiResponse getAllEmployees() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<EmployeesApiResponse> responseEntity = restTemplate.exchange(
                EMPLOYEES_API_URL,
                HttpMethod.GET,
                null,
                EmployeesApiResponse.class
        );

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            EmployeesApiResponse apiResponse = responseEntity.getBody();
            if (apiResponse != null) {
                apiResponse.setData(calculateAnnualSalaries(apiResponse.getData()));
                return apiResponse;
            }
        }
        return new EmployeesApiResponse();
    }

    public EmployeeApiResponse getEmployeById(int employeeId) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(EMPLOYEE_API_URL + employeeId, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            String jsonResponse = responseEntity.getBody();
            ObjectMapper objectMapper = new ObjectMapper();
            try {

                EmployeeApiResponse employee = objectMapper.readValue(jsonResponse, EmployeeApiResponse.class);
                double salary =  employee.getData().getEmployeeSalary();
                employee.getData().setEmployeeAnnualSalary(calculateAnnualSalary(salary));
                return employee;

            } catch (Exception e) {
                throw new IllegalStateException("Too many Request: Server dummy.restapiexample.com");
            }
        }

        return new EmployeeApiResponse();
    }

    public double calculateAnnualSalary(double monthlySalary) {
        return monthlySalary * 12;
    }

    public List<Employee> calculateAnnualSalaries(List<Employee> employees) {
        for (Employee employee : employees) {
            double annualSalary = calculateAnnualSalary(employee.getEmployeeSalary());
            employee.setEmployeeAnnualSalary(annualSalary);
        }
        return employees;
    }
}
