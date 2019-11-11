package com.lhb.demojpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

/**
 * @Author: Created By haibo.li01@hand-china.com
 * @Time: 2019/8/26  17:23;
 * @Description:
 */
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@Table(name = "DEMO_USER")
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank
    @Column
    private String name;
    @NotBlank
    @Column
    private String account;
    @Column
    @JsonIgnore
    private String pwd;
    @Range(min = 1, max = 100)
    private Integer age;

    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public String getAccount() {
        return account;
    }

    public User setAccount(String account) {
        this.account = account;
        return this;
    }

    public String getPwd() {
        return pwd;
    }

    public User setPwd(String pwd) {
        this.pwd = pwd;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public User setAge(Integer age) {
        this.age = age;
        return this;
    }
}

