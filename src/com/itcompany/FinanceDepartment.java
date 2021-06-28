package com.itcompany;

import java.util.ArrayList;

public class FinanceDepartment extends Department  implements IFinance {

    // Fields
    ArrayList<Employee> employeeList = new ArrayList<>();

    // Constructor
    public FinanceDepartment(){ super(DepartmentName.Finance); }

    // Properties
    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(ArrayList<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    // Methods
    @Override
    public void raiseSalary(int amount) {

    }
}
