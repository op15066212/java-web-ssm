package dao.bean;

import org.springframework.stereotype.Component;

import java.util.Objects;

//cid ：评价ID
//Bid：订单ID
//uname：用户名称
//Date：评价时间
//Content：评价内容
@Component
public class comment {
    private String cid;
    private String bid;
    private String uname;
    private String date;
    private String content;

    public comment() {
    }

    public comment(String cid, String bid, String uname, String date, String content) {
        this.cid = cid;
        this.bid = bid;
        this.uname = uname;
        this.date = date;
        this.content = content;
    }


    public boolean isEmpty() {
        return cid == null || cid.isEmpty()
                || bid == null || bid.isEmpty()
                || uname == null || uname.isEmpty()
                || date == null || date.isEmpty()
                || content == null || content.isEmpty();
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof comment)) return false;
        comment comment = (comment) o;
        return Objects.equals(getCid(), comment.getCid()) && Objects.equals(getBid(), comment.getBid()) && Objects.equals(getUname(), comment.getUname()) && Objects.equals(getDate(), comment.getDate()) && Objects.equals(getContent(), comment.getContent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCid(), getBid(), getUname(), getDate(), getContent());
    }

    @Override
    public String toString() {
        return "comment{" +
                "cid='" + cid + '\'' +
                ", bid='" + bid + '\'' +
                ", uname='" + uname + '\'' +
                ", date=" + date +
                ", content='" + content + '\'' +
                '}';
    }
}
