package test;

import dao.bean.book_order;
import service.list.book_orders;

import java.io.IOException;
import java.util.List;

public class bookOrderTest {

    public static void main(String[] args) throws IOException {
        selectAll();
    }


    public static void selectAll() throws IOException {
        List<book_order> b = book_orders.getOrders();
        print(b);
    }

    public static void print(List<book_order> books) {
        for (book_order book : books) {
            System.out.println(book);
        }
    }
}
