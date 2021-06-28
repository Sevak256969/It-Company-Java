package com.itcompany;

import java.time.LocalDate;

public interface IHumanResource {
    // Methods
    void hire(Team team, Employee.SpecialistType specialistType,Employee.QualificationLevel qualificationLevel,
              String personalId,String firstName, String lastName, String numberPhone, String email,
              LocalDate birthDate);

    void fire(Team team, String companyId, String teamId, String departmentId,Employee.SpecialistType specialistType,
              Employee.QualificationLevel qualificationLevel, int salary, String personalId, String firstName,
              String lastName, String numberPhone, String email, LocalDate birthDate);
}
