package service.list;


import dao.bean.order_detail;
import dao.mapper.orderDetailMapper;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class order_details {
    static SqlSession session;
    static orderDetailMapper mapper;
    private static List<order_detail> list = new ArrayList<>();

    static {
        session = sqlsess.getSession();
        mapper = session.getMapper(orderDetailMapper.class);
        selectAll();
    }

    public static List<order_detail> getList() {
        return list;
    }

    public static void setList(List<order_detail> list) {
        order_details.list = list;
    }

    public static void selectAll() {
        list = mapper.selectAll();
    }

    public static order_detail get(String id) throws IOException {
        return mapper.selectById(id);
    }

    public static boolean contains(String id) throws IOException {
        return mapper.selectById(id) != null;
    }

    public static void add(order_detail b) throws IOException {
        if (!contains(b.getOrder_id())) {
            mapper.insert(b);
            session.commit();
            selectAll();
        }
    }

    public static void remove(String id) throws IOException {
        mapper.deleteById(id);
        session.commit();
        selectAll();
    }

    public static void update(order_detail b) {
        mapper.update(b);
        session.commit();
        selectAll();
    }

    public static void search(String input) {
        list = mapper.selectLike(input);
    }
}
