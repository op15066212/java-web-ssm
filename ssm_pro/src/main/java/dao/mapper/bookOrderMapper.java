package dao.mapper;

import dao.bean.book_order;

import java.util.List;

public interface bookOrderMapper {
    List<book_order> selectAll();

    book_order selectByNo(String no);

    void insert(book_order book_order);

    void update(book_order book_order);

    void deleteByNo(String no);

    List<book_order> selectLike(String input);
}
