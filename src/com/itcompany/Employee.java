package com.itcompany;

import java.time.LocalDate;

public class Employee extends Person implements IReportable {

    public enum QualificationLevel {
        Undefined,
        Intern,
        EntryLevel,
        Junior,
        Intermediate,
        Senior,
        Director,
        ChiefExecutiveOfficer
    }
    public enum SpecialistType {
        Undefined,
        HumanResourceSpecialist,
        FinancialSpecialist,
        SoftwareEngineer,
        QualityAssuranceEngineer,
        ProjectManagementSpecialist,
        MarketingSpecialist
    }
    // Fields
    String  employeeId = CompanyUtil.getUuid();
    String companyId = "";
    String departmentId = "";
    String teamId = "";
    QualificationLevel qualificationLevel;
    SpecialistType specialistType;
    LocalDate statDate = LocalDate.now();
    LocalDate updateDate;
    LocalDate endDate;
    int salary;

    // Constructor
    public Employee(String companyId, String teamId, String departmentId, SpecialistType specialistType,
                    QualificationLevel qualificationLevel, int salary, String personalId, String firstName,
                    String lastName, String phoneNumber, String email, LocalDate birthDate) {

        super( personalId, firstName, lastName, phoneNumber, email, birthDate);
        this.companyId = companyId;
        this.departmentId = departmentId;
        this.teamId = teamId;
        this.qualificationLevel = qualificationLevel;
        this.specialistType = specialistType;
        this.salary = salary;
    }
    // Prospective (candidate) employee
    public Employee(SpecialistType specialistType, QualificationLevel qualificationLevel,String personalId,
                    String firstName, String lastName, String phoneNumber, String email, LocalDate birthDate) {

        super( personalId, firstName, lastName, phoneNumber, email, birthDate);
        this.specialistType = specialistType;
        this.qualificationLevel = qualificationLevel;
    }

    // Properties
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
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

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public QualificationLevel getQualificationLevel() {
        return qualificationLevel;
    }

    public void setQualificationLevel(QualificationLevel qualificationLevel) {
        this.qualificationLevel = qualificationLevel;
    }

    public SpecialistType getSpecialistType() {
        return specialistType;
    }

    public void setSpecialistType(SpecialistType specialistType) {
        this.specialistType = specialistType;
    }

    public LocalDate getStatDate() {
        return statDate;
    }

    public void setStatDate(LocalDate statDate) {
        this.statDate = statDate;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    // Methods
    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("first name = " + this.firstName +" last name =  " + this.lastName +
                        "birthdate = " +this.birthDate + " personal id = " + this.personalId +
                        " qualification = " + this.qualificationLevel+ " specialistType = " + this.specialistType);
        return stringBuilder.toString();
    }
    @Override
    public void generateReport()
    {
        System.out.println(this.toString());
    }

    public boolean isAssignToTeam()
    {
        return this.teamId != null && this.teamId.length() > 0;
    }
}
