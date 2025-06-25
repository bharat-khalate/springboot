package com.Techbulls.MyBatis.Entities;

public class Employee {

    private int id;
    private String address;
    private String first_name;
    private String last_name;


    public Employee() {
    }

    public Employee(int id, String address, String first_name, String last_name) {
        this.id = id;
        this.address = address;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                '}';
    }
}
