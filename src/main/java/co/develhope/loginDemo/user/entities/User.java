package co.develhope.loginDemo.user.entities;

import co.develhope.loginDemo.salary.entities.Salary;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;


@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    private String surname;

    private boolean isActive = false;

    @Column(length = 36)
    private String activationCode;

    @Column(length = 36)
    private String passwordResetCode;

    @Column(unique = true)
    private String email;
    private String password;

    private LocalDateTime jwtCreatedOn;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "USER_ROLES",
            joinColumns = {
                    @JoinColumn(name = "USER_ID")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "ROLE_ID") })
    private Set<Role> roles;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Salary salary;

    public User(long id, String name, String surname, boolean isActive, String activationCode, String passwordResetCode, String email, String password, LocalDateTime jwtCreatedOn, Set<Role> roles, Salary salary) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.isActive = isActive;
        this.activationCode = activationCode;
        this.passwordResetCode = passwordResetCode;
        this.email = email;
        this.password = password;
        this.jwtCreatedOn = jwtCreatedOn;
        this.roles = roles;
        this.salary = salary;
    }

    public User(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getActivationCode() {
        return activationCode;
    }

    public void setActivationCode(String activationCode) {
        this.activationCode = activationCode;
    }

    public String getPasswordResetCode() {
        return passwordResetCode;
    }

    public void setPasswordResetCode(String passwordResetCode) {
        this.passwordResetCode = passwordResetCode;
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

    public LocalDateTime getJwtCreatedOn() {
        return jwtCreatedOn;
    }

    public void setJwtCreatedOn(LocalDateTime jwtCreatedOn) {
        this.jwtCreatedOn = jwtCreatedOn;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", isActive=" + isActive +
                ", activationCode='" + activationCode + '\'' +
                ", passwordResetCode='" + passwordResetCode + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", jwtCreatedOn=" + jwtCreatedOn +
                ", roles=" + roles +
                '}';
    }
}