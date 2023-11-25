package dao.mapper;


import dao.bean.book;

import java.util.List;

public interface bookMapper {
    List<book> selectAll();

    book selectByBid(String Bid);

    void insert(book book);

    void update(book book);

    void deleteByBid(String Bid);

    List<book> selectLike(String input);
}
