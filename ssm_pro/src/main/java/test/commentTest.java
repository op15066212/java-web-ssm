package test;

import dao.bean.comment;
import service.list.comments;

import java.io.IOException;
import java.util.List;

public class commentTest {

    public static void main(String[] args) throws IOException {
        selectAll();
    }

    public static void selectAll() throws IOException {
        List<comment> u = comments.getList();
        print(u);
    }


    public static void print(List<comment> comments) {
        for (comment comment : comments) {
            System.out.println(comment);
        }
    }
}
