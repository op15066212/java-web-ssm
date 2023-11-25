package service.list;

import dao.bean.book;
import dao.mapper.bookMapper;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class books {
    static SqlSession session;
    static bookMapper mapper;
    private static List<book> list = new ArrayList<book>();

    static {
        session = sqlsess.getSession();
        mapper = session.getMapper(bookMapper.class);
        selectAll();
    }

    public static List<book> getList() {
        return list;
    }

    public static void setList(List<book> list) {
        books.list = list;
    }

    public static void selectAll() {
        list = mapper.selectAll();
    }

    public static book get(String id) throws IOException {
        return mapper.selectByBid(id);
    }

    public static boolean contains(String id) throws IOException {
        return mapper.selectByBid(id) != null;
    }

    public static void add(book book) throws IOException {
        if (!contains(book.getBid())) {
            mapper.insert(book);
            session.commit();
            selectAll();
        }
    }

    public static void remove(String id) throws IOException {
        mapper.deleteByBid(id);
        session.commit();
        selectAll();
    }

    public static void update(book book) {
        mapper.update(book);
        session.commit();
        selectAll();
    }

    public static void search(String input) {
        list = mapper.selectLike(input);
    }
}
