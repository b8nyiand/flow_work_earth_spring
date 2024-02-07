package hu.flowacademy.user.model;

import jakarta.persistence.*;

@Entity
@Table(name = "t_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String fullName;
    private String rights;
    private Integer points;

    public User() {

    }

    public User(String name, String fullName, String right, Integer points) {
        this.name = name;
        this.fullName = fullName;
        this.rights = right;
        this.points = points;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRights() {
        return rights;
    }

    public void setRights(String right) {
        this.rights = right;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", right='" + rights + '\'' +
                ", points=" + points +
                '}';
    }
}
