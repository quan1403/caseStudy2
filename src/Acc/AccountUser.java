package Acc;

import java.io.Serializable;

public class AccountUser implements Serializable {
    private String name;
    private String age;
    private String gender;
    private String phone;
    private String address;
    private String email;
    private String userName;
    private String passWord;
    private String role;

    public AccountUser() {
    }

    public AccountUser(String userName, String passWord, String role) {
        this.userName = userName;
        this.passWord = passWord;
        this.role = role;
    }

    public AccountUser(String name, String age, String gender, String phone, String address, String email, String userName, String passWord, String role) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
        this.email = email;
        this.userName = userName;
        this.passWord = passWord;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Override
    public String toString() {
        return "AccountUser{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", passWord='" + passWord + '\'' +
                '}';
    }
}
