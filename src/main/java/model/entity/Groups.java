package model.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Created by alexandr on 25.10.15.
 */
@Entity
public class Groups {
    @Id
    @Column(name = "groups_id", nullable = false, unique = true)
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "PASSWORD")
    private String password;

    @OneToMany(targetEntity = Task.class)
    private List<Task> tasks;

    @ManyToMany(mappedBy = "groups")
    private List<User> users;
    public Integer getId() {
        return id;
    }

    public Groups(Integer id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    //    public void setId(Integer id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Groups{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}