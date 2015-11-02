package model;

import model.entity.Groups;
import model.entity.Task;
import model.entity.User;
import model.service.GroupService;
import model.service.TaskService;
import model.service.UserService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by alexandr on 26.10.15.
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        EntityManager em = Persistence.createEntityManagerFactory("SAP").createEntityManager();
        UserService userService = new UserService(em);

        User u = new User();
        u.setName("Miha");
        u.setPassword("123");


        TaskService ts = new TaskService(em);
        Task t = new Task();
        t.setTitle("lol");
        t.setDescription("lauch");

        GroupService gs = new GroupService();
        Groups g = new Groups();
        g.setName("family");
        g.setPassword("123");

        Set<Task> tasks = new HashSet<Task>();
        Set<User> users = new HashSet<User>();
        Set<Groups> groupses = new HashSet<Groups>();
        tasks.add(t);
        users.add(u);
        groupses.add(g);

        u.setTasks(tasks);
        u.setGroupses(groupses);

        t.setUser(u);
        t.setGroups(g);

        g.setUsers(users);
        g.setTasks(tasks);

//        userService.addUser(u);
        gs.addGroup(g);
//        ts.addGroup(t);

        em.close();


    }
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SaP_manager");
//        EntityManager em = emf.createEntityManager();
//
//        GroupService groupService = new GroupService(em);
//        TaskService taskService = new TaskService(em);
//        UserService userService = new UserService(em);
//
//        System.out.println("Creation Groups");
//        groupService.createGroup(1, "family", "qwert");
//
//        System.out.println("Creation Users");
//        userService.createUser(1, "Alex", "qwe");
//        userService.createUser(2, "Petr", "qwer");
//        userService.createUser(3, "Ivon", "qwertyu");
//
//        System.out.println("Creation Tasks");
//        taskService.createTask(1, "homework1", "do your homework");
//        taskService.createTask(2, "homework2", "do your homework from english");
//        taskService.createTask(3, "homework3", "do your homework from math");
//        taskService.createTask(4, "homework4", "do your homework from geometry");
//
//        Thread.sleep(2000);
//        System.out.println("--Finding tasks from user--");
//        User user = userService.findUser(1);
//        System.out.println("User: "+ user);
//        for (Task task : user.getTasks()){
//            System.out.println(String.format("User tasks: %s", task));
//        }
//
//
//
//
//    }
}
