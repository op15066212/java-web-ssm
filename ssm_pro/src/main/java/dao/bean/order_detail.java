package dao.bean;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class order_detail {
    private String id;
    private String order_id;
    private String book_id;
    private String book_num;
    private String status;

    public order_detail() {
    }

    public order_detail(String id, String order_id, String book_id, String book_num, String status) {
        this.id = id;
        this.order_id = order_id;
        this.book_id = book_id;
        this.book_num = book_num;
        this.status = status;
    }

    public boolean isEmpty() {

        return id == null || id.isEmpty()
                || order_id == null || order_id.isEmpty()
                || book_id == null || book_id.isEmpty()
                || book_num == null || book_num.isEmpty()
                || status == null || status.isEmpty();
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getBook_num() {
        return book_num;
    }

    public void setBook_num(String book_num) {
        this.book_num = book_num;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof order_detail)) return false;
        order_detail that = (order_detail) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getBook_num(), that.getBook_num()) && Objects.equals(getOrder_id(), that.getOrder_id()) && Objects.equals(getBook_id(), that.getBook_id()) && Objects.equals(getStatus(), that.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getOrder_id(), getBook_id(), getBook_num(), getStatus());
    }

    @Override
    public String toString() {
        return "order_detail{" +
                "id=" + id +
                ", order_id='" + order_id + '\'' +
                ", book_id='" + book_id + '\'' +
                ", book_num=" + book_num +
                ", status='" + status + '\'' +
                '}';
    }
}
