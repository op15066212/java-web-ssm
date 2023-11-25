package service.list;

import dao.bean.user;
import dao.mapper.userMapper;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class users {
    static SqlSession session;
    static userMapper mapper;
    private static List<user> list = new ArrayList<>();

    static {
        session = sqlsess.getSession();
        mapper = session.getMapper(userMapper.class);
        try {
            selectAll();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<user> getList() {
        return list;
    }

    public static void setList(List<user> list) {
        users.list = list;
    }

    public static void selectAll() throws IOException {
        list = mapper.selectAll();
    }

    public static user getUser(String name) throws IOException {
        return mapper.selectByName(name);
    }

    public static boolean containsName(String name) throws IOException {
        return mapper.selectByName(name) != null;
    }

    public static boolean containsId(String id) throws IOException {
        return mapper.selectById(id) != null;
    }

    public static void addUser(user user) throws IOException {
        if (!containsName(user.getUname()) && !containsId(user.getUid())) {
            mapper.insert(user);
            session.commit();
            selectAll();
        }
    }

    public static user get(String id) throws IOException {
        return mapper.selectById(id);
    }

    public static void remove(String id) throws IOException {
        mapper.deleteById(id);
        session.commit();
        selectAll();
    }

    public static void update(user b) throws IOException {
        mapper.update(b);
        session.commit();
        selectAll();
    }

    public static void search(String input) throws IOException {
        list = mapper.selectLike(input);
    }
}
