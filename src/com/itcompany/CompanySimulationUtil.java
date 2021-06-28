package com.itcompany;

import java.time.LocalDate;
import java.util.ArrayList;

public class CompanySimulationUtil  {
    public static Employee generateFutureEmployee() {

        Employee.QualificationLevel qualificationLevel = CompanyUtil.getQualificationLevel();
        Employee.SpecialistType specialistType =  CompanyUtil.getSpecialistType();
        String firstName = CompanyUtil.getFirstName();
        String lastName = CompanyUtil.getLastName();
        LocalDate birthDate = CompanyUtil.getDateOfBirth(18, 70);
        String email = CompanyUtil.getRandomEmail(10);
        String phoneNumber = CompanyUtil.getRandomPhoneNumber();
        String personalId = CompanyUtil.getUuid();
        Employee employee = new Employee(specialistType, qualificationLevel, personalId, firstName,
                phoneNumber, email, lastName, birthDate);
        return employee;
    }
    public static ArrayList<Employee> generateFutureEmployeePool(int futureEmployeeCount) {
        ArrayList<Employee> futureEmployeeList = new ArrayList<>();
        for (int i = 0; i <= futureEmployeeCount; i++) {
            futureEmployeeList.add(generateFutureEmployee());
        }
        return futureEmployeeList;
    }

    public static Team generateTeam(String teamName) {
        Team team = new Team(teamName);
        team.manager = generateFutureEmployee();
        team.addEmployee(generateFutureEmployee());
        team.addEmployee(generateFutureEmployee());
        team.addEmployee(generateFutureEmployee());
        return team;
    }

    public static Department generateDepartment(Department.DepartmentName departmentName) {
        Department department = new Department(departmentName);
        department.director = generateFutureEmployee();
        department.addTeam(generateTeam(departmentName + "Team A"));
        department.addTeam(generateTeam(departmentName + "Team B"));
        return department;
    }
    public static Company generateCompany(String companyName) {
        // generate a company with four departments : HR, Finance, Development, QA
        Company company = new Company(companyName);
        company.chiefExecutiveOfficer= generateFutureEmployee();
        company.addDepartment(generateDepartment(Department.DepartmentName.HumanResource));
        company.addDepartment(generateDepartment(Department.DepartmentName.Development));
        company.addDepartment(generateDepartment(Department.DepartmentName.Finance));
        company.addDepartment(generateDepartment(Department.DepartmentName.QualityAssurance));
        return company;
    }
}
