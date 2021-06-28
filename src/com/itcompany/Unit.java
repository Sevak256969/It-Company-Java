package com.itcompany;

import java.time.LocalDate;
import java.util.ArrayList;

public class Unit <T> implements IReportable{

    public enum UnitType {
        Undefined,
        Company,
        Department,
        Team
    }

    // Fields
    String unitId = CompanyUtil.getGuid();
    UnitType unitType;
    LocalDate createDate = LocalDate.now();
    LocalDate updateDate;
    LocalDate endDate;
    int minCapacity = 1;
    int maxCapacity = 100;
    int size;
    String name;
    Employee head;
    ArrayList<T> memberList = new ArrayList<T>();

    // Constructor
    public Unit(String name, UnitType unitType, int minCapacity, int maxCapacity) {
        this.name = name;
        this.unitType = unitType;
        this.minCapacity = minCapacity;
        this.maxCapacity = maxCapacity;
    }

    public  Unit(String name, UnitType unitType) {
        this.name = name;
        this.unitType = unitType;
    }

    // Properties
    public String getUnitId() {
        return unitId;
    }

    protected UnitType getUnitType() {
        return unitType;
    }

    protected LocalDate getCreateDate() {
        return createDate;
    }

    protected LocalDate getUpdateDate() {
        return updateDate;
    }

    protected void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    protected LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
    protected int getMinCapacity() {
        return minCapacity;
    }

    protected void setMinCapacity(int minCapacity) {
        this.minCapacity = minCapacity;
    }

    protected int getMaxCapacity() {
        return maxCapacity;
    }

    protected void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getSize() {
        return size;
    }

    protected String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected Employee getHead() {
        return head;
    }

    protected void setHead(Employee head) {
        this.head = head;
    }

    public ArrayList<T> getMemberList() {
        return memberList;
    }

    protected boolean addMember(T member, boolean updateMaxCapacity){
        if (this.memberList.contains(member)) {
            return false;
        }
        if (memberList.size() == this.maxCapacity) {
            if (updateMaxCapacity) {
                this.maxCapacity = memberList.size() + 1;
            }
            else{
                return false;
            }
        }
        // add the member
        memberList.add(member);
        // update the timestamp
        updateDate = LocalDate.now();
        return true;
    }

    protected boolean removeMember(T member, boolean updateMinCapacity) {
        if (!this.memberList.contains(member)) {
            return false;
        }
        if (memberList.size() == this.minCapacity) {
            if (updateMinCapacity){
                this.minCapacity = memberList.size() - 1;
            }
            else {
                return false;
            }
        }
        // remove the member
        memberList.remove(member);
        // update the timestamp
        updateDate = LocalDate.now();
        return true;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String uType = this.unitType.toString();
        if (head != null) {
            stringBuilder.append("The Head of Unit is " + head.toString());
        }
        stringBuilder.append(uType + " name is "+ this.name).append("\n");
        stringBuilder.append(uType +" members are").append("\n");
        for(var member : this.memberList) {
            stringBuilder.append(member.toString()).append("\n");
        }
        return stringBuilder.toString().trim();
    }

    @Override
    public void generateReport() {
        System.out.println(this.toString());
    }
}
