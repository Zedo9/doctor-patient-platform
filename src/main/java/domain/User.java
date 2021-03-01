package domain;

import javax.persistence.*;

@Entity
@Table(name="user")
public class User {
    public User(){}
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="user_id")
    private int userId;

    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    // DOCTOR - PATIENT
    @Column (name="type")
    private String type;

    @Column (name="account_confirmed")
    private boolean confirmed;

    @Column (name="referral_id", nullable = true)
    private int referralId;

    public User(int userId, String email, String password, String type, boolean confirmed, int referralId) {
        this.userId = userId;
        this.email = email;
        this.password = password;
        this.type = type;
        this.confirmed = confirmed;
        this.referralId = referralId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public int getReferralId() {
        return referralId;
    }

    public void setReferralId(int referralId) {
        this.referralId = referralId;
    }
}
