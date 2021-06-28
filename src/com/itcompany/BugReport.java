package com.itcompany;

import java.time.LocalDate;

public class BugReport {
    public enum BugStatus {
        New,
        Assigned,
        Fixed,
        Verified,
        ClosedAsDuplicate,
        ClosedAsReproducible,
        ClosedObsolete
    }
    // Fields
    String bugId = CompanyUtil.getUuid();
    LocalDate timeStamp = LocalDate.now();
    String title;
    String description;
    String createdById;
    String assignedToId = " ";
    BugStatus status=BugStatus.New;

    // Constructor
    public BugReport(String createdById, String title, String description) {
        this.createdById = createdById;
        this.title = title;
        this.description = description;
    }

    // Properties
    public String getBugId() {
        return bugId;
    }

    public void setBugId(String bugId) {
        this.bugId = bugId;
    }

    public LocalDate getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDate timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedById() {
        return createdById;
    }

    public void setCreatedById(String createdById) {
        this.createdById = createdById;
    }

    public String getAssignedToId() {
        return assignedToId;
    }

    public void setAssignedToId(String assignedToId) {
        this.assignedToId = assignedToId;
    }

    public BugStatus getStatus() {
        return status;
    }

    public void setStatus(BugStatus status) {
        this.status = status;
    }
}
