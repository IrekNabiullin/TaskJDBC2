package jm.task.core.jdbc;

import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        Util util = new Util();
        try {
            util.connect();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                util.disconnect();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
