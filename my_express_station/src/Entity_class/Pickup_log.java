package Entity_class;

public class Pickup_log {



    private String Number;
    private String addressee;//应取人
    private String addressee_telephone;
    private String addressee_true;//实际取件人
    private String addressee_telephone_true;

    public Pickup_log(String number, String addressee, String addressee_telephone, String addressee_true, String addressee_telephone_true) {
        Number = number;
        this.addressee = addressee;
        this.addressee_telephone = addressee_telephone;
        this.addressee_true = addressee_true;
        this.addressee_telephone_true = addressee_telephone_true;
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

    public String getAddressee_true() {
        return addressee_true;
    }

    public void setAddressee_true(String addressee_true) {
        this.addressee_true = addressee_true;
    }

    public String getAddressee_telephone_true() {
        return addressee_telephone_true;
    }

    public void setAddressee_telephone_true(String addressee_telephone_true) {
        this.addressee_telephone_true = addressee_telephone_true;
    }

}
