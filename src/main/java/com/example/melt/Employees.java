package com.example.melt;

public class Employees  {
    private int Id;
    private String employeeName;
    private String email;
    private double dept;
    private int phoneNumber;
    private int userId;

    public Employees(int id, String name, String email, double dept, int phoneNumber, int userId) {
        this.Id = id;
        this.employeeName = name;
        this.email = email;
        this.dept = dept;
        this.phoneNumber = phoneNumber;
        this.userId = userId;
    }

    public Employees(String name, String email, double dept, int phoneNumber, int userId) {
        this.employeeName = name;
        this.email = email;
        this.dept = dept;
        this.phoneNumber = phoneNumber;
        this.userId = userId;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getName() {
        return employeeName;
    }

    public void setName(String name) {
        this.employeeName= name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getDept() {
        return dept;
    }

    public void setDept(double dept) {
        this.dept = dept;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "id=" + Id+
                ", name='" + employeeName + '\'' +
                ", email='" + email + '\'' +
                ", dept=" + dept +
                ", phoneNumber=" + phoneNumber +
                ", userId=" + userId +
                '}';
    }
}
