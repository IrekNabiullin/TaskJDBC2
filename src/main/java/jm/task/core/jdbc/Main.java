package jm.task.core.jdbc;

import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        try {
            Util.connect();

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
