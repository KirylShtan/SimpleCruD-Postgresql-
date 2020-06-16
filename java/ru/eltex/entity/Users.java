package ru.eltex.entity;

import javax.persistence.*;

@Entity
@Table
public class Users {
    @Id
    @GeneratedValue
    @Column
    private Integer id;
    @Column
    private String name;
    @Column
    private String phone;
    public Users(String name,String phone){
        this.name = name;
        this.phone  = phone;

    }
    public Users(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
