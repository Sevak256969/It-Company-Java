package com.itcompanytest;

import com.itcompany.Company;
import com.itcompany.Department;
import com.itcompany.Employee;
import com.itcompany.Team;
import java.time.LocalDate;
import java.util.ArrayList;

public class TestSimulationUtil {
    public static Employee generateFutureEmployee(){

        Employee.QualificationLevel qualificationLevel = TestUtil.getQualificationLevel();
        Employee.SpecialistType specialistType = TestUtil.getSpecialistType();
        String firstName = TestUtil.getFirstName();
        String lastName = TestUtil.getLastName();
        LocalDate birthDate = TestUtil.getDateOfBirth(18, 70);
        String email = TestUtil.getRandomEmail(10);
        String phoneNumber = TestUtil.getRandomPhoneNumber();
        String personalId = TestUtil.getUuid();
        Employee employee = new Employee(specialistType, qualificationLevel, personalId, firstName,
                            phoneNumber, email, lastName, birthDate);
        return employee;
    }
    public static ArrayList<Employee> GenerateFutureEmployeePool(int futureEmployeeCount){
        ArrayList<Employee> futureEmployeeList = new ArrayList<>();
        for (int i = 0; i <= futureEmployeeCount; i++) {
            futureEmployeeList.add(generateFutureEmployee());
        }
        return futureEmployeeList;
    }
    public static Team generateTeam(String teamName){
        Team team = new Team(teamName);
        team.manager = generateFutureEmployee();
        team.addEmployee(generateFutureEmployee());
        team.addEmployee(generateFutureEmployee());
        team.addEmployee(generateFutureEmployee());
        return team;
    }
    public static Department generateDepartment(Department.DepartmentName departmentName){
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
