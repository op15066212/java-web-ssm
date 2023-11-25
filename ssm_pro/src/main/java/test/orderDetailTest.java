package test;

import dao.bean.order_detail;
import service.list.order_details;

import java.io.IOException;
import java.util.List;

public class orderDetailTest {

    public static void main(String[] args) throws IOException {
        selectAll();
    }


    public static void selectAll() throws IOException {
        List<order_detail> u = order_details.getList();
        print(u);
    }

    public static void print(List<order_detail> order_details) {
        for (order_detail order_detail : order_details) {
            System.out.println(order_detail);
        }
    }
}
