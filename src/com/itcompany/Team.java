package com.itcompany;


public class Team extends Unit<Employee> {

    // Fields
    public Employee manager;
    String companyId = "";
    String departmentId = "";

    // Constructor
    public Team(String name, String departmentId, String companyId) {
        super(name, UnitType.Team);
        this.companyId = companyId;
        this.departmentId = departmentId;
    }

    public Team(String name){
        super(name, UnitType.Team);
    }

    // Properties
    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    // Methods
    public void addEmployee(Employee employee) {
        employee.companyId = this.companyId;
        employee.departmentId = this.departmentId;
        employee.teamId = this.unitId;
        this.addMember(employee, true);
    }

    public void removeEmployee(Employee employee) {
        employee.companyId = this.companyId;
        employee.departmentId = this.departmentId;
        employee.teamId = this.unitId;
        this.removeMember(employee, true);
    }
}
