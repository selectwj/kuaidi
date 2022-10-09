package MySystem;

import Entity_class.Package_Get;
import Entity_class.Staff;
import com.sun.source.tree.DoWhileLoopTree;

public class System_AboutStaff {
    private Staff staff;
    private System_AboutDatabase sys;
    public System_AboutStaff(Staff staff){
        this.staff=staff;
        sys = new System_AboutDatabase();
    }
    public System_AboutStaff(){
        sys = new System_AboutDatabase();
    }
    //根据取件码查找快递位置
    public void FindPackage(String ID){
        System.out.println(sys.look_for_package(ID));
    }
    //检查客户身份码，与包裹对比
    public boolean check(String ID, Package_Get MyPackage){
        if(MD5Util.md5(MyPackage.getAddressee(),MyPackage.getAddressee_telephone()).equals(ID)){
            return true;
        }else
            return false;
    }
    //ID代表身份码，number取件码 这个是取件函数
    public void TakePackage(String ID, String number){
        Package_Get temp = sys.GetPackage(number);
        boolean flag = false;//true代表比对成功
        if(check(ID,temp)){
            flag = true;
        }
        if(flag){//如果比对成功包裹出库，后续添加功能可以修改下面语句
            sys.DeletePackage(number);
        }
    }
    //包裹入库,外界给出快递公司和收件人信息
    public void SavePackage(String company, String addressee, String addressee_phone){
        sys.save_package(company, addressee, addressee_phone);
    }
    //通知快递公司取件   x 取几件
    public void Distribute(int x){
        int j = x;
        while(j!=0){
            sys.DeleteSendPackage(0);
            j--;
        }
    }
}
