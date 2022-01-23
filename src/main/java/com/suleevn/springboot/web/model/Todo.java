package com.suleevn.springboot.web.model;

import javax.validation.constraints.Size;



public class Todo {
    public int id;

    private String user;
    
    @Size(min=1, message="Enter at least 1 Characters...")
    private String fullName;

    private Integer iin;

    private String passport;

    private String date;

    private String disc;

    private String add_inf;

    private String address;

    private Integer phoneNumber;

    private String prop;

    public String getDisc() {return disc;}

    public void setDisc(String disc) {this.disc = disc;}

    public Todo() {}

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Integer getIin() {
        return iin;
    }

    public void setIin(Integer iin) {
        this.iin = iin;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getAdd_inf() {
        return add_inf;
    }

    public void setAdd_inf(String add_inf) {
        this.add_inf = add_inf;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(Integer phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getProp() {
        return prop;
    }

    public void setProp(String prop) {
        this.prop = prop;
    }

    public String getDate() {
        return String.valueOf(date);
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Todo(int id, String user, String fullName, Integer iin, String passport, String date,  String disc, String add_inf, String address, Integer phoneNumber, String prop) {
        this.id = id;
        this.user = user;
        this.fullName = fullName;
        this.iin = iin;
        this.passport = passport;
        this.date = date;
        this.disc = disc;
        this.add_inf = add_inf;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.prop = prop;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Todo other = (Todo) obj;
        if (id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format(
                "Todo [id=%s, user=%s, fullName=%s, iin=%s, passport=%s, date=%s, disc=%s, add_inf=%s,  address=%s, phoneNumber=%s, prop=%s]",
                id, user, fullName, iin, passport, date, disc, add_inf, address, phoneNumber, prop);
    }


}
