package dao.mapper;

import dao.bean.order_detail;

import java.util.List;

public interface orderDetailMapper {
    List<order_detail> selectAll();

    order_detail selectById(String id);

    void insert(order_detail order_detail);

    void update(order_detail order_detail);

    void deleteById(String id);

    List<order_detail> selectLike(String input);
}
