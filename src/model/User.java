package model;

import java.util.Date;

public class User {
    private int id;
    private String fName;
    private String lName;
    private String phone;
    private String address;
    private String email;
    private String psw;
    private Date signupDate;

    public User(int id, String fName, String lName, String phone, String address, String email, String psw, Date signupDate) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.psw = psw;
        this.signupDate = signupDate;
    }


    //// pour nous le user a 3 role donc
    /// 1,annonceur
    /// 2,acheteur
    /// 3,expert
    ///
    // les getters et setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    /////////////////////// /

    public String getFName() {
        return fName;
    }
    public void setFName(String fName) {
        this.fName = fName;
    }

    /////////////////////// /

    public String getLName() {
        return lName;
    }
    public void setLName(String lName) {
        this.lName = lName;
    }
    /////////////////////// /

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    /////////////////////// /

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    /////////////////////// /

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    /////////////////////// /

    public String getPsw() {
        return psw;
    } ///verry illegal lol
    public void setPsw(String psw) {
        this.psw = psw;
    }
    /////////////////////// /

    public Date getSignupDate() {
        return signupDate;
    }
    public void setSignupDate(Date signupDate) {
        this.signupDate = signupDate;
    }

    @Override
    public String toString() {
        return fName + " " + lName + " (" + email + ")";
    }
}