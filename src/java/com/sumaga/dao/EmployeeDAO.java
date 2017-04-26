/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.sumaga.dao;

import com.sumaga.hibe.model.Department;
import com.sumaga.hibe.model.Designation;
import com.sumaga.hibe.model.Employee;
import java.util.List;

/**
 *
 * @author Rohan Madusanka
 * @e-mail rohanmadusanka72@gmail.com
 * @contact 071-9085504
 */
public interface EmployeeDAO {
    public List<Department> getDepartments();
    public String deleteDepartment(int depid);
    public List<Designation> getDesignations();
    public String deleteDesignation(int desid);
    public List<Employee> getEmployees();
    public String updateEmployee(Employee employee);
}
