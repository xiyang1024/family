package com.ycj.family.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * 持久化属性的对象/关系映射注解必须应用于getter方法
 * @author chuanjieyang
 * @since Feb 12, 2019 11:54:16 AM
 */
/*
    一个实体类要映射到数据库必须有@Entity和@Id
    @Entity:说明这个class是实体类，并且使用默认的orm规则，即class名即数据库中的表名，class字段名即表中的字段名
    而@Table和@Column用于改变这个默认的orm规则
 */
@Entity
/*
    name:用来命名，当前实体类对应的表的名字
    catalog:用来指定数据库名
    schema:自定数据库的用户名
    uniqueConstraints:批量指定唯一字段
 */
@Table(name = "user",catalog = "family",schema = "ycj" )
/*
    appliesTo:映射的表名
    comment:创建表时对表的注释
 */
@org.hibernate.annotations.Table(appliesTo = "user",comment = "用户表")
public class User implements Serializable {

    private static final long serialVersionUID = 8314201989378312164L;

    private Integer id;
    private String username;
    private String password;

    public User(){}

    public User(Integer id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    @Id
    /*
        TABLE 借助数据库表，生成存标识符属性值，表中保存当前的标识符属性的最大值
        IDENTITY 使用数据库表中的自动增长字段生成标识符属性值
        SEQUENCE 使用数据库的序列生成标识符属性值
        AUTO 可以时上面三种任意一种类型，取决于底层数据库的类型
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "username",columnDefinition = "varchar(20) unique comment '用户账号' ")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "password",columnDefinition = "varchar(100) comment '用户密码' ")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
