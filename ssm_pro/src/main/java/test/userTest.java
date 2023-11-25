package test;

import dao.bean.user;
import service.list.users;

import java.io.IOException;
import java.util.List;

public class userTest {
    public static void main(String[] args) throws IOException {
        selectAll();
    }


    public static void selectAll() throws IOException {
        List<user> u = users.getList();
        print(u);
    }

    public static void search(String in) throws IOException {
        users.search(in);
        List<user> u = users.getList();
        print(u);
    }

    public static void print(List<user> users) {
        for (user user : users) {
            System.out.println(user);
        }
    }
}