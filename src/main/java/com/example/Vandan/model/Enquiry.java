package com.example.Vandan.model;

public class Enquiry {
    private String name;
    private String contact;
    private String query;

    public Enquiry() {
    }

    public Enquiry(String name, String contact, String query) {
        this.name = name;
        this.contact = contact;
        this.query = query;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
