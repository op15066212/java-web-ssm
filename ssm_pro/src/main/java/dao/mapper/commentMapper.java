package dao.mapper;

import dao.bean.comment;

import java.util.List;

public interface commentMapper {
    List<comment> selectAll();

    comment selectById(String id);

    void insert(comment comment);

    void update(comment comment);

    void deleteById(String id);

    List<comment> selectLike(String input);
}
