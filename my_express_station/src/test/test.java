package test;

import Entity_class.Package_Get;
import MySystem.System_AboutDatabase;
import MySystem.System_AboutStation;

import java.util.ArrayList;
import java.util.Iterator;

public class test {
    public static void main(String[] args) {
        System_AboutDatabase s = new System_AboutDatabase();
        System_AboutStation a = new System_AboutStation();
//        System.out.println(s.Sign_in_User("root","0"));
//        s.Register_User("11","110","112","oo","151222222222","yc");
//        s.Register_Staff("01","02","02","02","02","02","02");
//        s.DeleteUser("11");
//        s.DeleteStaff("01");
//        s.save_package("顺丰","王","18422222222");
//        s.save_package("中通","王","18422222222");
//        s.save_package("韵达","王","18422222222");
//        s.save_package("邮政","王","18422222222");
//        s.save_package("京东","王","18422222222");
//        s.save_package("德邦","王","18422222222");
//        ArrayList<Package_Get> list = s.FindMyPackage("18422222222");
//        for(int i = 0;i < list.size(); i ++){
//            System.out.println(list.get(i));
//        }
//        s.Save_Package_Send("Zhan","6588845","Wang","7777777","辽宁省沈阳市","1");
//        s.Save_Package_Send("Zhan","6588845","Wang","7777777","辽宁省沈阳市","2");
//        s.Save_Package_Send("Zhan","6588845","Wang","7777777","辽宁省沈阳市","3");
//        s.Save_Package_Send("Zhan","6588845","Wang","7777777","辽宁省沈阳市","4");
//        s.Save_Package_Send("Zhan","6588845","Wang","7777777","辽宁省沈阳市","5");
//        s.DeleteSendPackage(7);
//        a.New_Customer("5","5","5","5","5","5");
        System.out.println(s.GetPackage("SF100002"));


    }
}
