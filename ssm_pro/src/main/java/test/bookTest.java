package test;


import dao.bean.book;
import service.list.books;

import java.io.IOException;
import java.util.List;

public class bookTest {

    public static void main(String[] args) throws IOException {
        selectAll();
    }


    public static void selectAll() throws IOException {
        List<book> b = books.getList();
        print(b);
    }

    public static void print(List<book> books) {
        for (book book : books) {
            System.out.println(book);
        }
    }
}
