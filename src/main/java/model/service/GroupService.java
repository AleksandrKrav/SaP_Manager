package model.service;

import model.entity.Groups;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by alexandr on 26.10.15.
 */
public class GroupService {
    private EntityManager em = Persistence.createEntityManagerFactory("SAP").createEntityManager();

//    public Groups createGroup(int id, String name, String password) {
//        Groups task = new Groups(id, name, password);
//        em.persist(task);
//        return task;
//    }

    public void addGroup(Groups groups){
        em.getTransaction().begin();
        em.merge(groups);
        em.getTransaction().commit();
    }

    public void delete(long id){
        em.getTransaction().begin();
        em.remove(get(id));
        em.getTransaction().commit();
    }

    public Groups get(long id){
        return em.find(Groups.class, id);
    }

    public void update(Groups g){
        em.getTransaction().begin();
        em.merge(g);
        em.getTransaction().commit();
    }

//    public void removeGroup(int id){
//        Groups groups = em.find(Groups.class, id);
//        if (groups != null){
//            em.remove(groups);
//        }
//    }

//    public Groups changeGroupName(int id, String name) {
//        Groups groups = em.find(Groups.class, id);
//        if (groups != null) {
//            groups.setName(name);
//        }
//        return groups;
//    }
//
//    public Groups changeGroupPassword(int id, String password) {
//        Groups groups = em.find(Groups.class, id);
//        if (groups != null) {
//            groups.setPassword(password);
//        }
//        return groups;
//    }

//    public Groups findGroup(int id) {
//        return em.find(Groups.class, id);
//    }

    public List<Groups> findAllGroups() {
        TypedQuery<Groups> query = em.createQuery("SELECT a FROM Groups a", Groups.class);
        return query.getResultList();
    }
}
