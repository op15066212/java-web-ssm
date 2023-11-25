package service.list;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class sqlsess {

    private static final SqlSession session;

    static {
        String resource = "mybatis-bookstore.xml";
        // 加载 Mybatis 配置文件并构建 SqlSessionFactory
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        session = sqlSessionFactory.openSession();
    }

    public static SqlSession getSession() {
        return session;
    }

    public static void searchAll() throws IOException {
        books.selectAll();
        book_orders.selectAll();
        comments.selectAll();
        order_details.selectAll();
        users.selectAll();
    }

}

