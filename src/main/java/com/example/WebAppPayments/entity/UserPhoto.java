package com.example.WebAppPayments.entity;

import java.io.Serializable;
import java.util.Objects;

public class UserPhoto implements Serializable {

    private int id;
    private String path;

    public UserPhoto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPhoto userPhoto = (UserPhoto) o;
        return id == userPhoto.id && path.equals(userPhoto.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, path);
    }

    @Override
    public String toString() {
        return "UserPhoto{" +
                "id=" + id +
                ", path='" + path + '\'' +
                '}';
    }
}
