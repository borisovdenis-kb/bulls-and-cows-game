package ru.intodayer.servlets.entity;

import javax.persistence.*;
import java.io.Serializable;


/**
 * This table is not redundant,
 * but introduced in order to avoid re-counting the user's rating
 * every time the page /rating is uploaded.
 **/
@Entity
@Table(name = "user_rating")
@NamedQueries({
    @NamedQuery(
        name= "UserRating.getAllUserRatings",
        query="SELECT ur FROM UserRating ur WHERE ur.avgAttemptAmount != null ORDER BY ur.avgAttemptAmount ASC"
    ),
    @NamedQuery(
        name= "UserRating.getUserRatingByUser",
        query="SELECT ur FROM UserRating ur WHERE ur.user = :user"
    )
})

public class UserRating implements Serializable {

    private static final long serialVersionUID = -159741789348463619L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "avg_attempt_amount")
    private Integer avgAttemptAmount;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public UserRating() {}

    public UserRating(Integer avgAttemptAmount, User user) {
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
            "user_rating[id=%s,avg_attempt_amount=%s,user_id=%s]",
            this.id,
            this.avgAttemptAmount,
            this.user.getId()
        );
    }
}
