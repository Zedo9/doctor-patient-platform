package entity;


import javax.persistence.*;

@Entity
@Table(name="patient")
public class Patient {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;


    @Column(name="first_name")
    private String firstNname;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String Email;

    @Column(name = "password")
    private String Password;

    @Column(name="age")
    private String Age;

    @Column (name="gender")
    private String Gender;

    public Patient(int id, String firstName, String lastName, String email, String password, String age, String gender) {
        this.id = id;
        this.firstNname = firstName;
        this.lastName = lastName;
        Email = email;
        Password = password;
        Age = age;
        Gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstNname() {
        return firstNname;
    }

    public void setFirstNname(String firstNname) {
        this.firstNname = firstNname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }
}
