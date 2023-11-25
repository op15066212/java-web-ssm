package service.list;

import dao.bean.book_order;
import dao.mapper.bookOrderMapper;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class book_orders {
    static SqlSession session;
    static bookOrderMapper mapper;
    private static List<book_order> orders = new ArrayList<>();

    static {
        session = sqlsess.getSession();
        mapper = session.getMapper(bookOrderMapper.class);
        selectAll();
    }

    public static List<book_order> getOrders() {
        return orders;
    }

    public static void setOrders(List<book_order> orders) {
        book_orders.orders = orders;
    }

    public static void selectAll() {
        orders = mapper.selectAll();
    }

    public static book_order get(String id) throws IOException {
        return mapper.selectByNo(id);
    }

    public static boolean contains(String id) throws IOException {
        return mapper.selectByNo(id) != null;
    }

    public static void add(book_order book_order) throws IOException {
        if (!contains(book_order.getOid())) {
            mapper.insert(book_order);
            session.commit();
            selectAll();
        }
    }

    public static void remove(String id) throws IOException {
        mapper.deleteByNo(id);
        session.commit();
        selectAll();
    }

    public static void update(book_order book_order) {
        mapper.update(book_order);
        session.commit();
        selectAll();
    }

    public static void search(String input) {
        orders = mapper.selectLike(input);
    }
}
