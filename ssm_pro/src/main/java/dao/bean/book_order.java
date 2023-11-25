package dao.bean;

import org.springframework.stereotype.Component;

import java.util.Objects;

//oid ：订单ID
//date：订单日期
//oname：用户名称
//address：收货地址
//State：订单状态
//Uid：用户ID
@Component
public class book_order {
    private String oid;
    private String date;
    private String oname;
    private String address;
    private String state;
    private String uid;

    public book_order() {
    }

    public book_order(String oid, String date, String oname, String address, String state, String uid) {
        this.oid = oid;
        this.date = date;
        this.oname = oname;
        this.address = address;
        this.state = state;
        this.uid = uid;
    }


    public boolean isEmpty() {
        return oid == null || oid.isEmpty()
                || date == null || date.isEmpty()
                || oname == null || oname.isEmpty()
                || address == null || address.isEmpty()
                || state == null || state.isEmpty()
                || uid == null || uid.isEmpty();
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getOname() {
        return oname;
    }

    public void setOname(String oname) {
        this.oname = oname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof book_order)) return false;
        book_order bookOrder = (book_order) o;
        return Objects.equals(oid, bookOrder.oid) && Objects.equals(date, bookOrder.date) && Objects.equals(oname, bookOrder.oname) && Objects.equals(address, bookOrder.address) && Objects.equals(state, bookOrder.state) && Objects.equals(uid, bookOrder.uid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(oid, date, oname, address, state, uid);
    }

    @Override
    public String toString() {
        return "book_order{" +
                "oid='" + oid + '\'' +
                ", date=" + date +
                ", oname='" + oname + '\'' +
                ", address='" + address + '\'' +
                ", state='" + state + '\'' +
                ", uid='" + uid + '\'' +
                '}';
    }
}

