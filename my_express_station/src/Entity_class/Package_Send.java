package Entity_class;

public class Package_Send {
    private int Odd_Number;
    private String Sender;
    private String Phone_Sender;
    private String addressee;
    private String addressee_telephone;
    private String Destination;//目的地
    private String Company;//快递公司
    public Package_Send(int odd_Number, String sender, String phone_Sender, String addressee, String addressee_telephone, String destination, String company) {
        Odd_Number = odd_Number;
        Sender = sender;
        Phone_Sender = phone_Sender;
        this.addressee = addressee;
        this.addressee_telephone = addressee_telephone;
        Destination = destination;
        Company = company;
    }

    public int getOdd_Number() {
        return Odd_Number;
    }

    public void setOdd_Number(int odd_Number) {
        Odd_Number = odd_Number;
    }

    public String getSender() {
        return Sender;
    }

    public void setSender(String sender) {
        Sender = sender;
    }

    public String getPhone_Sender() {
        return Phone_Sender;
    }

    public void setPhone_Sender(String phone_Sender) {
        Phone_Sender = phone_Sender;
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

    public String getDestination() {
        return Destination;
    }

    public void setDestination(String destination) {
        Destination = destination;
    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }
}
