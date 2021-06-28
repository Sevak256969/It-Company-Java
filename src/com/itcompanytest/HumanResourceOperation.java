package com.itcompanytest;

import com.itcompany.Company;
import com.itcompany.Department;
import com.itcompany.Employee;
import com.itcompany.Team;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HumanResourceOperation {

    Employee director;
    String companyId = "";
    Map<String, Employee> allEmployeeHashMap = new HashMap<>();
    Map<String, Employee> employeesPool = new HashMap<>();
    Map<String, Team> teamPool = new HashMap<>();
    Map<String, Department> departmentPool = new HashMap<>();
    Map<String, Company> companyPool = new HashMap<>();

    public HumanResourceOperation(Department.DepartmentName departmentName, String companyId) {
        this.companyId = companyId;
    }

    public boolean addTeam(Team team) {
        if (teamPool.containsKey(team.getUnitId())) {
            teamPool.put(team.getUnitId(), team);
            return true;
        }
        else {
            System.out.println("We already have a team with this Id "+ team.getUnitId());
        }
        return false;
    }

    public boolean removeTeam(Team team) {
        if (teamPool.containsKey(team.getUnitId())) {
            teamPool.remove(team.getUnitId());
            return true;
        }
        else {
            System.out.println("That team  Id " + team.getUnitId() + " is not found");
        }
        return false;
    }
    public Company createCompany(String name, String phone, String email, String address) {
        Company company = new Company(name, phone, email, address);
        companyPool.put(company.getUnitId(), company);
        return company;
    }

    public void updateCompanyPhone(Company company, String phone) {
        company.setPhone(phone)  ;
    }
    public void updateCompanyEmail(Company company, String email) {
        company.setEmail(email) ;
    }
    public void updateCompanyAddress(Company company, String address) {
        company.setAddress(address) ;
    }
    public void assignCompanyCeo(Company company, Employee ceo) {
        company.setChiefExecutiveOfficer(ceo);
    }

    public Department createDepartment(Department.DepartmentName departmentName, String companyId) {
        Department department = new Department(departmentName, companyId);
        departmentPool.put(department.getUnitId(), department);
        return department;
    }

    public void removeDepartment(Department department) {
        departmentPool.remove(department.getUnitId());
    }

    public Employee hire(String personalId, String firstName, String lastName, String numberPhone,
                         String email, LocalDate birthDate, Employee.SpecialistType specialistType,
                         Employee.QualificationLevel qualificationLevel) {

        Employee employee = new Employee(specialistType, qualificationLevel, personalId, firstName,
                            lastName, numberPhone, email, birthDate);
        employeesPool.put(employee.getEmployeeId(), employee);
        return employee;
    }

    public void hire(Team team, Employee employee) {
        allEmployeeHashMap.put(employee.getEmployeeId(), employee);
        team.addEmployee(employee);
    }

    public boolean fire(Employee employee) {
        if (employeesPool.containsKey(employee.getEmployeeId())) {
            Team team = getTeamById(employee.getTeamId());
            if (team != null) {
                team.removeEmployee(employee);
            }
            employeesPool.remove(employee.getEmployeeId());
            return true;
        }
        return false;
    }

    public void assignToTeam(Employee employee, Team team) {
        if(employee.isAssignToTeam()) {
            Team oldTeam = getTeamById(employee.getEmployeeId());
            if(oldTeam!=null) {
                oldTeam.removeEmployee(employee);
                //employeesPool.remove(employee.EmployeeId);
            }
        }
        team.addEmployee(employee);
    }
    public void updateQualification(Employee employee, Employee.QualificationLevel qualificationLevel) {
        employee.setQualificationLevel(qualificationLevel)  ;
    }

    private Team getTeamById(String teamId) {
        if(teamPool.containsKey(teamId)) {
            return teamPool.getOrDefault(teamId, null);
        }
        return null;
    }
    }

