package service;

import Entity_class.Package_Get;
import Entity_class.User;

import java.util.ArrayList;

public interface UserService {
    /**
     * 返回 包裹列表
     * @param me 谁的包裹
     * @return
     */
    public ArrayList<Package_Get> MyPackage(User me);

    /**
     *
     * @param me 谁的
     * @return 返回用户编码
     */
    public String GiveID(User me);

    /**
     * 寄件
     * @param me                寄件人对象
     * @param addressee         收件人
     * @param addressee_phone   收件人电话
     * @param destination       目的地
     * @param company           快递公司
     * @return  -1代表失败
     */
    public int SendPackage(User me,String addressee,String addressee_phone,String destination,String company);

    /**
     *
     * @param number            取件码
     * @param me                寄件人对象
     * @param addressee         收件人
     * @param addressee_phone   收件人电话
     * @param destination       目的地
     * @param company           快递公司
     * @return  -1代表失败
     */
    public int Take_Back(String number,User me,String addressee,String addressee_phone,String destination,String company);
}
