package ru.sberdyshev.learn.geekbrains.java.core.professional.lesson2.homework.constants;

public class JdbcPostgresConnectionConstants {
    private static String url = "jdbc:postgresql://192.168.99.100:5432/geekbrains_java_prof_les2_hw";
    private static String user = "postgres";
    private static String password = "qwerty";

    private JdbcPostgresConnectionConstants() {
    }

    public static String getUrl() {
        return url;
    }

    public static String getUser() {
        return user;
    }

    public static String getPassword() {
        return password;
    }

    ;

}
