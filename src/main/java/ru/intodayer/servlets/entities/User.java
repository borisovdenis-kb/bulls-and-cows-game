package ru.intodayer.servlets.entities;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "user")
@NamedQuery(
    name="User.findOneByUsernameAndPassword",
    query="SELECT u FROM User u WHERE u.username = :username and u.password = :password"
)

public class User implements Serializable {

    private static final long serialVersionUID = 3574701645481018325L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("user[id=%s,username=%s]", this.id, this.username);
    }
}
