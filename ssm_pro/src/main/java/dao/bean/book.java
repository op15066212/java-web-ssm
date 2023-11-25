package dao.bean;

import org.springframework.stereotype.Component;

import java.util.Objects;

//bid ：图书ID
//bname：图书名称
//detail：图书简介
//Price：图书价格
//Writer：作者
//Printer：出版社
//Date：出版日期
//Type：图书类别
//Image：图书预览图片
//Store：图书库存
@Component
public class book {
    private String bid;
    private String bname;
    private String detail;
    private String price;
    private String writer;
    private String printer;
    private String date;
    private String type;
    private String image;
    private String store;

    public book() {
    }

    public book(String bid, String bname, String detail, String price, String writer, String printer, String date, String type, String image, String store) {
        this.bid = bid;
        this.bname = bname;
        this.detail = detail;
        this.price = price;
        this.writer = writer;
        this.printer = printer;
        this.date = date;
        this.type = type;
        this.image = image;
        this.store = store;
    }

    public boolean isEmpty() {
        return bid == null || bid.isEmpty()
                || bname == null || bname.isEmpty()
                || detail == null || detail.isEmpty()
                || price == null || price.isEmpty()
                || writer == null || writer.isEmpty()
                || printer == null || printer.isEmpty()
                || date == null || date.isEmpty()
                || type == null || type.isEmpty()
                || store == null || store.isEmpty();
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getPrinter() {
        return printer;
    }

    public void setPrinter(String printer) {
        this.printer = printer;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof book)) return false;
        book book = (book) o;
        return Objects.equals(getBid(), book.getBid()) && Objects.equals(getBname(), book.getBname()) && Objects.equals(getDetail(), book.getDetail()) && Objects.equals(getPrice(), book.getPrice()) && Objects.equals(getWriter(), book.getWriter()) && Objects.equals(getPrinter(), book.getPrinter()) && Objects.equals(getDate(), book.getDate()) && Objects.equals(getType(), book.getType()) && Objects.equals(getImage(), book.getImage()) && Objects.equals(getStore(), book.getStore());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBid(), getBname(), getDetail(), getPrice(), getWriter(), getPrinter(), getDate(), getType(), getImage(), getStore());
    }

    @Override
    public String toString() {
        return "book{" +
                "bid='" + bid + '\'' +
                ", bname='" + bname + '\'' +
                ", detail='" + detail + '\'' +
                ", price=" + price +
                ", writer='" + writer + '\'' +
                ", printer='" + printer + '\'' +
                ", date='" + date + '\'' +
                ", type='" + type + '\'' +
                ", image='" + image + '\'' +
                ", store=" + store +
                '}';
    }
}
