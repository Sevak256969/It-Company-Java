package com.itcompany;

public class Company extends Unit<Department>{
    // Fields
    public Employee chiefExecutiveOfficer;
    String phone;
    String email;
    String address;

    // Constructor
    public Company(String name) { super(name, UnitType.Company); }

    public Company(String name, String phone, String email, String address) {
        super(name, UnitType.Company);
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    // Properties
    public Employee getChiefExecutiveOfficer() {
        return chiefExecutiveOfficer;
    }

    public void setChiefExecutiveOfficer(Employee chiefExecutiveOfficer) {
        this.chiefExecutiveOfficer = chiefExecutiveOfficer;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Methods
    public void addDepartment(Department department) {
        department.companyId = this.unitId;
        this.addMember(department, true);
    }

    public void removeDepartment(Department department) {
        department.companyId = this.unitId;
        this.removeMember(department, true);
    }
}
