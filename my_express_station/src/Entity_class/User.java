package Entity_class;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class User {
    private String username;
    private String nickname;
    private String name;
    private String password;
    private String create_at;
    private String email;
    private String phone;

    public User(){
        this.username = "0";
        this.nickname = "0";
        this.name = "0";
        this.password = "0";
        this.email = "0";
        this.phone = "0";
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.create_at = format.format(new Date(System.currentTimeMillis()));
    }

    public User(String username, String nickname, String name, String password, String email, String phone) {
        this.username = username;
        this.nickname = nickname;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.create_at = format.format(new Date(System.currentTimeMillis()));
    }

    public String getUsername() {
        return username;
    }

    public String getNickname() {
        return nickname;
    }

    public String getName() {
        return name;
    }

    public String getCreate_at() {
        return create_at;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", create_at='" + create_at + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
