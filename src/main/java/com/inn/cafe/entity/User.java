package com.inn.cafe.entity;

import lombok.Data;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

@NamedQuery(name="User.findByEmailId", query = "select u from User as u where u.email=:email")

@NamedQuery(name="User.getAllUser", query = "select new com.inn.cafe.wrapper.UserWrapper(u.id, u.name, u.email, u.contactNumber, u.status) from User as u where u.role='user'")

@NamedQuery(name="User.updateStatus", query = "update User u set u.status=:status where u.id=:id")

@NamedQuery(name="User.getAllAdmin", query = "select u.email from User as u where u.role='admin'")

@Data
@Entity
@Table(name = "user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="contactNumber")
    private String contactNumber;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="status")
    private String status;

    @Column(name="role")
    private String role;

}
