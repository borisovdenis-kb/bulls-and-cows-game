package ru.intodayer.servlets.entity;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_record")
public class UserRecord implements Serializable {

    private static final long serialVersionUID = -159741789348463619L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "avg_attempt_amount")
    private Integer avgAttemptAmount;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    public UserRecord() {}

    public UserRecord(Integer avgAttemptAmount, User user) {
        this.avgAttemptAmount = avgAttemptAmount;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public Integer getAvgAttemptAmount() {
        return avgAttemptAmount;
    }

    public void setAvgAttemptAmount(Integer avgAttemptAmount) {
        this.avgAttemptAmount = avgAttemptAmount;
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
            "user_record[id=%s,avg_attempt_amount=%s,user_id=%s]",
            this.id,
            this.avgAttemptAmount,
            this.user.getId()
        );
    }
}
