package ru.intodayer.servlets.entity;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "user_attempt")
public class UserAttempt implements Serializable {

    private static final long serialVersionUID = 6876119858685358829L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "attempt_amount")
    private Integer attemptAmount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public UserAttempt() {}

    public UserAttempt(Integer attemptAmount, User user) {
        this.attemptAmount = attemptAmount;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public Integer getAttemptAmount() {
        return attemptAmount;
    }

    public void setAttemptAmount(Integer attemptAmount) {
        this.attemptAmount = attemptAmount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return String.format(
            "user_attempt[id=%s,attempt_amount=%s,user_id=%s",
            this.id,
            this.attemptAmount,
            this.user.getId()
        );
    }
}
