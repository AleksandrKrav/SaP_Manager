package service;

import model.entity.User;
import model.service.UserService;
import org.junit.Test;

import java.util.List;

/**
 * Created by alexandr on 31.10.15.
 */
public class UserServiceTest {
    UserService userService = new UserService();

    @Test
    public void testSaveRecord() throws Exception{
        User u = new User();
        u.setName("Miha");
        u.setPassword("123");

        userService.addUser(u);
        System.out.println(u.toString());
    }

    @Test
    public void testDeleteRecord() throws Exception{
        userService.delete(1);
    }

    @Test
    public void testUpdate() throws Exception{
        User u = userService.get(5);
//        u.setName("Mihail");
//        u.setPassword("124");
//
//        userService.addUser(u);

        u.setPassword("12");

        userService.update(u);
        System.out.println(u.getId());

//        User u1 = userService.get(u.getId());
//        System.out.println(u1);

    }

    @Test
    public void testAll() {
        User u = new User();
        u.setName("Mihailov");
        u.setPassword("12");
        userService.addUser(u);

        User u1 = new User();
        u1.setName("Mihail");
        u1.setPassword("123");
        userService.addUser(u1);

        User u2 = new User();
        u2.setName("Mihailka");
        u2.setPassword("1234");

        userService.addUser(u2);

        List<User> list = userService.findAllUsers();

        for (User u3 : list){
            System.out.println(u3);
        }
    }



}
