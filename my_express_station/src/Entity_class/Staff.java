package Entity_class;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Staff {
    private String ID;
    private String name;
    private String password;
    private String create_at;
    private String email;
    private String phone;
    private String gender;
    private String position;


    public Staff( ) {
        ID = "0";
        this.name = "0";
        this.password = "0";
        this.email = "0";
        this.phone = "0";
        this.gender = "0";
        this.position = "0";
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.create_at = format.format(new Date(System.currentTimeMillis()));
    }

    public Staff(String id, String name, String password, String email, String phone,String position,String gender) {
        this.ID = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.gender= gender;
        this.position = position;
        this.phone = phone;
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.create_at = format.format(new Date(System.currentTimeMillis()));
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", create_at='" + create_at + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
