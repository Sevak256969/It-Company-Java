package com.itcompany;

public class Department extends Unit<Team>{
    public enum DepartmentName {
        Undefined,
        Marketing,
        Finance,
        ProjectManagement,
        HumanResource,
        Development,
        QualityAssurance
    }

    // Fields
    public Employee director;
    String companyId = "";

    // Constructor
    public Department(DepartmentName departmentName, String companyId) {

        super(departmentName.toString(),UnitType.Department);
        this.companyId = companyId;
    }
    public Department(DepartmentName departmentName) {
        super(departmentName.toString(), UnitType.Department);

    }

    // Properties
    public Employee getDirector() {
        return director;
    }

    public void setDirector(Employee director) { this.director = director; }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    // Methods
    public void addTeam(Team team) {
        team.departmentId = this.unitId;
        this.addMember(team,true);
    }

    public void removeTeam(Team team) {
        team.departmentId = this.unitId;
        this.removeMember(team, true);
    }
}
