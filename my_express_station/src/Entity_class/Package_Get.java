package Entity_class;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Package_Get {

    private String Number;//编码
    private String addressee;//收件人
    private String addressee_telephone;
    private String create_at;//入库时间

    @Override
    public String toString() {
        return "您的取件码是" + Number ;
    }

    public Package_Get(String number, String addressee, String addressee_telephone) {
        Number = number;
        this.addressee = addressee;
        this.addressee_telephone = addressee_telephone;
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.create_at = format.format(new Date(System.currentTimeMillis()));
    }
    public Package_Get() {
        Number = "";
        this.addressee = "";
        this.addressee_telephone = "";
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.create_at = format.format(new Date(System.currentTimeMillis()));
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public String getAddressee() {
        return addressee;
    }

    public void setAddressee(String addressee) {
        this.addressee = addressee;
    }

    public String getAddressee_telephone() {
        return addressee_telephone;
    }

    public void setAddressee_telephone(String addressee_telephone) {
        this.addressee_telephone = addressee_telephone;
    }

    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }

}
