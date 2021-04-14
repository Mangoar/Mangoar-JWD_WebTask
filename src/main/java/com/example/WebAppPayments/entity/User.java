package com.example.WebAppPayments.entity;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable {

    private int id;
    private int id_role;
    private int id_photo;
    private String login;
    private String password;
    private String fullname;
    private String birthdate;
    private String passport;
    private String email;
    private int blocked;

    public User() {
    }

    public User(int id, int id_role, int id_photo, String login, String password, String fullname, String birthdate, String passport, String email, int blocked) {
        this.id = id;
        this.id_role = id_role;
        this.id_photo = id_photo;
        this.login = login;
        this.password = password;
        this.fullname = fullname;
        this.birthdate = birthdate;
        this.passport = passport;
        this.email = email;
        this.blocked = blocked;
    }

    public User(String login, String password, String fullname, String birthdate, String passport, String email) {
        this.login = login;
        this.password = password;
        this.fullname = fullname;
        this.birthdate = birthdate;
        this.passport = passport;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_role() {
        return id_role;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
    }

    public int getId_photo() {
        return id_photo;
    }

    public void setId_photo(int id_photo) {
        this.id_photo = id_photo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getBlocked() {
        return blocked;
    }

    public void setBlocked(int blocked) {
        this.blocked = blocked;
    }

    //TODO Refactor after adding email
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && id_role == user.id_role && id_photo == user.id_photo && login.equals(user.login) && passport.equals(user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, id_role, id_photo, login, passport);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", id_role=" + id_role +
                ", id_photo=" + id_photo +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", fullname='" + fullname + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", passport='" + passport + '\'' +
                ", email='" + email + '\'' +
                ", blocked=" + blocked +
                '}';
    }
}
