package model.entity;


import javax.persistence.*;
import java.util.List;

/**
 * Created by alexandr on 25.10.15.
 */
@Entity
public class User  {

    @Id
    @Column(name = "user_id", nullable = false, unique = true)
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "PASSWORD")
    private String password;

    @OneToMany(targetEntity = Task.class)
    private List<Task> tasks;

    @ManyToMany
    @JoinTable(name = "users_groupses",
            joinColumns = @JoinColumn(name = "groups_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<Groups> groupses;

    public User(Integer id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public Integer getId() {
        return id;
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

    public List<Groups> getGroupses() {
        return groupses;
    }

    public void setGroupses(List<Groups> groupses) {
        this.groupses = groupses;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
