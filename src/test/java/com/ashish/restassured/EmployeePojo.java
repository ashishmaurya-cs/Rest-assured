package com.ashish.restassured;

public class EmployeePojo {
    private int id;
    private String name;
    private int salary;
    private Contacts contacts;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Contacts getContacts() {
        return contacts;
    }

    public void setContacts(Contacts contacts) {
        this.contacts = contacts;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    static class  Contacts {
        private int mobile1;
        private int mobile2;

        public int getMobile1() {
            return mobile1;
        }

        public void setMobile1(int mobile1) {
            this.mobile1 = mobile1;
        }

        public int getMobile2() {
            return mobile2;
        }

        public void setMobile2(int mobile2) {
            this.mobile2 = mobile2;
        }
    }
}
