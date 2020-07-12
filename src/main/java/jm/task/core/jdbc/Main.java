package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        try {
            Util.connect();
            UserServiceImpl userService = new UserServiceImpl();
            userService.createUsersTable();
            userService.saveUser("Ivan", "Ivanov", (byte) 25);
            userService.saveUser("Petr", "Petrov", (byte) 30);
            userService.saveUser("Sidor", "Sidorov", (byte) 35);
            userService.saveUser("Nikifor", "Nikiforoff", (byte) 40);
            userService.getAllUsers();
            userService.cleanUsersTable();
            userService.dropUsersTable();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                Util.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
