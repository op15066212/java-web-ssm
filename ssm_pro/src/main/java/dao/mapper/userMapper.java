package dao.mapper;

import dao.bean.user;

import java.util.List;

public interface userMapper {
    List<user> selectAll();

    user selectById(String id);

    user selectByName(String name);

    void insert(user user);

    void update(user user);

    void deleteById(String id);

    List<user> selectLike(String input);
}
