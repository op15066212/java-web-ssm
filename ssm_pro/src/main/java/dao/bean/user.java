package dao.bean;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class user {
    private String uid;
    private String uname;
    private String password;
    private String gender;
    private String phone;
    private String email;
    private String address;

    public user() {
    }

    public user(String uid, String uname, String password, String gender, String phone, String email, String address) {
        this.uid = uid;
        this.uname = uname;
        this.password = password;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public user(String username, String password) {
        this.uname = username;
        this.password = password;
    }

    public boolean isEmpty() {
        return uid == null || uid.isEmpty()
                || uname == null || uname.isEmpty()
                || password == null || password.isEmpty()
                || gender == null || gender.isEmpty()
                || phone == null || phone.isEmpty()
                || email == null || email.isEmpty()
                || address == null || address.isEmpty();
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof user)) return false;
        user userBook = (user) o;
        return Objects.equals(uid, userBook.uid) && Objects.equals(uname, userBook.uname) && Objects.equals(password, userBook.password) && Objects.equals(gender, userBook.gender) && Objects.equals(phone, userBook.phone) && Objects.equals(email, userBook.email) && Objects.equals(address, userBook.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uid, uname, password, gender, phone, email, address);
    }

    @Override
    public String toString() {
        return "user{" +
                "uid='" + uid + '\'' +
                ", uname='" + uname + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
