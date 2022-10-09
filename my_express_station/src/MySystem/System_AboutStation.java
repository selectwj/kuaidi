package MySystem;

import Entity_class.*;

public class System_AboutStation {
    private final System_AboutDatabase sys;
    public System_AboutStation(){
        sys = new System_AboutDatabase();
    }
    //员工注册 postion职位暂时没啥用
    public int New_Staff(String ID,String name, String gender,String email,String phone,String pw,String position){
        return sys.Register_Staff(ID,name, gender,email,phone,pw,position);
    }
    //客户注册
    public int New_Customer(String na,String password, String ema,String nickname,String phone,String truename){
        return sys.Register_User(na,password, ema,nickname,phone,truename);
    }
    //删除职工
    public void DelStaff(String id){
        sys.DeleteStaff(id);
    }
    //删除用户
    public void DelUser(String id){
        sys.DeleteUser(id);
    }
    //查找员工，返回员工对象
    public Staff lookForStaff(String id){
        return sys.FindStaff(id);
    }
    //查找用户返回用户对象
    public User lookForUser(String username){
        return sys.FindUser(username);
    }
    //修改用户密码
    public void ModifyUserPassword(User a, String oldPassword, String newPassword){
        sys.UpdateUserPassword(a,oldPassword,newPassword);
    }
    //修改职工密码
    public void ModifyStaffPassword(Staff a, String oldPassword, String newPassword){
        sys.UpdateStaffPassword(a,oldPassword,newPassword);
    }

}
