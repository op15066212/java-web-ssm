package service.list;

import dao.bean.comment;
import dao.mapper.commentMapper;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class comments {
    static SqlSession session;
    static commentMapper mapper;
    private static List<comment> list = new ArrayList<>();

    static {
        session = sqlsess.getSession();
        mapper = session.getMapper(commentMapper.class);
        selectAll();
    }

    public static List<comment> getList() {
        return list;
    }

    public static void setList(List<comment> list) {
        comments.list = list;
    }

    public static void selectAll() {
        list = mapper.selectAll();
    }


    public static comment get(String id) throws IOException {
        return mapper.selectById(id);
    }

    public static boolean contains(String id) throws IOException {
        return mapper.selectById(id) != null;
    }

    public static void add(comment b) throws IOException {
        if (!contains(b.getBid())) {
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

    public static void update(comment b) {
        mapper.update(b);
        session.commit();
        selectAll();
    }

    public static void search(String input) {
        list = mapper.selectLike(input);
    }
}
