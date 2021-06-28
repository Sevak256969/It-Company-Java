package com.itcompany;

import java.time.LocalDate;

public class HumanResourceDepartment extends Department {

    // Constructor
    public HumanResourceDepartment(DepartmentName departmentName) { super(DepartmentName.HumanResource);}

    // Methods
    public void hire(Team team, Employee.SpecialistType specialistType,
                     Employee.QualificationLevel qualificationLevel,String personalId,String firstName,
                     String lastName,String phoneNumber,String email, LocalDate birthDate){

        Employee employee = new Employee( specialistType, qualificationLevel,phoneNumber, email, personalId,
                firstName, lastName, birthDate);
        team.addEmployee(employee);
        hire(team,employee);
    }
    public void hire(Team team, Employee employee) {

        team.addEmployee(employee);
    }
}
