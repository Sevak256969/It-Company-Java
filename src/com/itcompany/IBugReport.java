package com.itcompany;

public interface IBugReport {
    // Methods
    void create(String createdById, String title, String description);
    void update(String createdById, String title, String description);
}
