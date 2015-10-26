package model.service;

import model.entity.Task;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by alexandr on 26.10.15.
 */
public class TaskService {

    private EntityManager em;

    public TaskService(EntityManager em) {
        this.em = em;
    }

    public Task createTask(int id, String title, String description) {
        Task task = new Task(id, title, description);
        em.persist(task);
        return task;
    }

    public void removeTask(int id){
        Task task = em.find(Task.class, id);
        if (task != null){
            em.remove(task);
        }
    }

    public Task changeTaskName(int id, String title) {
        Task task = em.find(Task.class, id);
        if (task != null) {
            task.setTitle(title);
        }
        return task;
    }

    public Task changeTaskDescription(int id, String description) {
        Task task = em.find(Task.class, id);
        if (task != null) {
            task.setDescription(description);
        }
        return task;
    }

    public Task findTask(int id) {
        return em.find(Task.class, id);
    }

    public List<Task> findAllTasks() {
        TypedQuery<Task> query = em.createQuery("SELECT a FROM Task a", Task.class);
        return query.getResultList();
    }
}
