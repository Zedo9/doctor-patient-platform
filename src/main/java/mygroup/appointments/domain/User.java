package mygroup.appointments.domain;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {
    public User(){}
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long userId;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    // DOCTOR - PATIENT
    @Column (name="type")
    @Enumerated(EnumType.STRING)
    private UserType type;

    @Column (name="account_confirmed")
    private Boolean confirmed;

    @Column (name="referral_id", nullable = true)
    private Long referralId;

    public User(String email, String password)
    {
        this.email = email;
        this.password = password;
    }
    public User(String email, String password, UserType type, Boolean confirmed, Long referralId) {
        this.email = email;
        this.password = password;
        this.type = type;
        this.confirmed = confirmed;
        this.referralId = referralId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public Boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    public Long getReferralId() {
        return referralId;
    }

    public void setReferralId(Long referralId) {
        this.referralId = referralId;
    }
}
