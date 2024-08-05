package com.humanresource.employees.controller;

import com.humanresource.employees.entity.Employees;
import com.humanresource.employees.service.EmployeesService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeesController {

    @Autowired
    private EmployeesService employeesService;

    @GetMapping("/getEmployeeJobByEmployeeId/{employee-id}")
    public ResponseEntity<Map<String, Object>> getEmployeeJobByEmployeeId(@PathVariable("employee-id") Integer employeeId) {

        JSONObject json = new JSONObject();
        Map<String, Object> response = employeesService.getEmployeeJobByEmployeeId(employeeId);
        System.out.println(response.get("employee"));
        System.out.println(response.get("job"));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
