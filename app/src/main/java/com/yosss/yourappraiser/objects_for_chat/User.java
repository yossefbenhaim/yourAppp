package com.yosss.yourappraiser.objects_for_chat;

public class User {
    private String name,password,phone,gender;

    public User() {
    }

    public User(String name, String password, String phone,  String gender) {
        this.name = name;
        this.password = password;
        this.phone = phone;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
    public boolean equals (Object object) {
        boolean result = false;
        if (object == null || object.getClass() != getClass()) {
            result = false;
        } else {
            User employee = (User) object;
            result = this.name.equals(employee.getName()) && this.password.equals(employee.getPassword());
        }
        return result;
    }
}

