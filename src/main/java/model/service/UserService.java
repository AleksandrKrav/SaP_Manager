package model.service;

import model.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by alexandr on 26.10.15.
 */
public class UserService {
    public EntityManager em ;

    public UserService(EntityManager em) {
        this.em = em;
    }

    public void addUser(User user){
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
    }

    public void delete(long id){
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public User get(long id){
        return em.find(User.class, id);
    }

    public void update(User u){
        em.getTransaction().begin();
        em.merge(u);
        em.getTransaction().commit();
    }


//    public User createUser(int id, String name, String password) {
//        User user = new User(id, name, password);
//        em.persist(user);
//        return user;
//    }
//
//    public void removeUser(int id){
//        User user = em.find(User.class, id);
//        if (user != null){
//            em.remove(user);
//        }
//    }
//
//    public User changeUserName(int id, String name) {
//        User user = em.find(User.class, id);
//        if (user != null) {
//            user.setName(name);
//        }
//        return user;
//    }
//
//    public User changeUserPassword(int id, String password) {
//        User user = em.find(User.class, id);
//        if (user != null) {
//            user.setPassword(password);
//        }
//        return user;
//    }
//
//    public User findUser(int id) {
//        return em.find(User.class, id);
//    }

    public List<User> findAllUsers() {
        TypedQuery<User> query = em.createQuery("SELECT a FROM User a", User.class);
        return query.getResultList();
    }
}
