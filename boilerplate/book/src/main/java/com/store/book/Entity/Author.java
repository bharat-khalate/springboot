package com.store.book.Entity;

import jakarta.persistence.*;



@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id")
    private Integer auth_id;
    private String name;
    private String s_name;

    public Author() {
    }

    public Author(Integer auth_id, String name, String s_name) {
        this.auth_id = auth_id;
        this.name = name;
        this.s_name = s_name;
    }

    public Integer getAuth_id() {
        return auth_id;
    }

    public void setAuth_id(Integer auth_id) {
        this.auth_id = auth_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    @Override
    public String toString() {
        return "Author{" +
                "auth_id=" + auth_id +
                ", name='" + name + '\'' +
                ", s_name='" + s_name + '\'' +
                '}';
    }
}
