package MySystem;

import Entity_class.*;

import java.util.ArrayList;

public class System_AboutCustomer {
    private final System_AboutDatabase sys;
    private final User me;
    public System_AboutCustomer(User m){
        sys = new System_AboutDatabase();
        this.me = m;
    }
    //查找自己待取包裹，逐行输出字符串,这里再函数直接输出了，可以返回String 需要改一下函数————————————测试成功
    public void MyPackage(){
        ArrayList<Package_Get> list = sys.FindMyPackage(me.getPhone());
        for (Package_Get package_get : list) {
            System.out.println(package_get);
        }
    }
    //重载 可以查别人的
    public void MyPackage(String x){
        ArrayList<Package_Get> list = sys.FindMyPackage(x);
        for (Package_Get package_get : list) {
            System.out.println(package_get);
        }
    }
    //出示身份码
    public String GiveID(){return sys.Myid(me);}
    //根据取件码退货
    public void Take_Back(String number,String sender,String sender_phone,String addressee,String addressee_phone,String destination,String company){
        sys.DeletePackage(number);
        sys.Save_Package_Send( sender,sender_phone,addressee,addressee_phone,destination,company);
    }
    //寄件
    public void SendPackage(String addressee,String addressee_phone,String destination,String company){
        sys.Save_Package_Send(me.getName(),me.getPhone(),addressee,addressee_phone,destination,company);
    }
}
