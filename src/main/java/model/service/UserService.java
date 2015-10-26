package model.service;

import model.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by alexandr on 26.10.15.
 */
public class UserService {
    private EntityManager em;

    public UserService(EntityManager em) {
        this.em = em;
    }

    public User createUser(int id, String name, String password) {
        User user = new User(id, name, password);
        em.persist(user);
        return user;
    }

    public void removeUser(int id){
        User user = em.find(User.class, id);
        if (user != null){
            em.remove(user);
        }
    }

    public User changeUserName(int id, String name) {
        User user = em.find(User.class, id);
        if (user != null) {
            user.setName(name);
        }
        return user;
    }

    public User changeUserPassword(int id, String password) {
        User user = em.find(User.class, id);
        if (user != null) {
            user.setPassword(password);
        }
        return user;
    }

    public User findUser(int id) {
        return em.find(User.class, id);
    }

    public List<User> findAllGroups() {
        TypedQuery<User> query = em.createQuery("SELECT a FROM User a", User.class);
        return query.getResultList();
    }
}
