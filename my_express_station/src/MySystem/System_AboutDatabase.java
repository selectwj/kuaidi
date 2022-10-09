package MySystem;

import Entity_class.*;

import javax.swing.*;
import java.sql.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class System_AboutDatabase {
    //    private User user = new User();
    //    private Staff staff = new Staff();
        private Connection connection;
        private Statement statement;
        public System_AboutDatabase() {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");       //加载驱动
                String url = "jdbc:mysql://localhost:3306/express station management system";
                String user = "root";
                String pwd ="254789";
                connection = DriverManager.getConnection(url,user,pwd);
            } catch (ClassNotFoundException | SQLException e ) {
                e.printStackTrace();
            }
            if(connection == null){
                System.out.println("连接失败");
            }else{
                System.out.println("连接成功");
                try {
                    statement = connection.createStatement();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //用户登录功能____________测试成功
        public boolean Sign_in_User(String na,String password){
            String temp = "SELECT COUNT(1) FROM `user` WHERE username = '%s' AND `password` = '%s'";
            String temp2 = "SELECT * FROM `user` WHERE username = '%s' AND `password` = '%s'";
            String pw = MD5Util.md5(password);
            String sql1 = String.format(temp, na, pw);
            String sql2 = String.format(temp2, na, pw);
            try {
                ResultSet resultSet = statement.executeQuery(sql1);
                resultSet.next();//游标为空，需要下移一格
                if(resultSet.getInt("COUNT(1)" )==1){
                    resultSet = statement.executeQuery(sql2);
                    resultSet.next();
    //                user = new User(resultSet.getString("user"),resultSet.getString("email"),resultSet.getString("password"),resultSet.getInt("power"));
    //                log l1 = new log(user.getUsername(), "登录日志",user.getUsername()+"已成功登录");
    //                WriteLog(l1);
                    return true;
                }else{
    //                log l2 = new log("", "登录日志", "登录失败");
    //                WriteLog(l2);
                    return false;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        //用户注册功能____________测试成功
        public int Register_User(String na,String password, String ema,String nickname,String phone,String truename){
            String temp = "SELECT COUNT(1) FROM `user` WHERE username = '%s'";
            String sql1 = String.format(temp, na);
            ResultSet resultSet;
            try {
                resultSet = statement.executeQuery(sql1);
                resultSet.next();
                if(resultSet.getInt("COUNT(1)" )==1){
//                    JOptionPane.showMessageDialog(null, "用户名已注册！");
                    return -1;
                }else{
                    SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String pw = MD5Util.md5(password);
                    String MyID = MD5Util.md5(na,phone);
                    String Time = format.format(new Date(System.currentTimeMillis()));
                    String sql = "INSERT INTO `express station management system`.`user` (`username`, `nickname`, `name`, `email`, `phone`, `password`, `create_at`, `MyID`) VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s');";
                    String sql2 = String.format(sql, na,nickname,truename, ema,phone,pw, Time,MyID);
                    statement.executeUpdate(sql2);
    //                log l1 = new log(na, "注册日志", na +"已成功注册");
    //                WriteLog(l1);
                    return 1;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return -1;
            }
        }
        //职工登录功能__测试成功
        public boolean Sign_in_Staff(String ID,String password){
            String temp = "SELECT COUNT(1) FROM `staff` WHERE ID = '%s' AND `password` = '%s'";
    //        String temp2 = "SELECT * FROM `staff` WHERE ID = '%s' AND `password` = '%s'";
            String pw = MD5Util.md5(password);
            String sql1 = String.format(temp, ID, pw);
    //        String sql2 = String.format(temp2, ID, pw);
            try {
                ResultSet resultSet = statement.executeQuery(sql1);
                resultSet.next();//游标为空，需要下移一格
                if(resultSet.getInt("COUNT(1)" )==1){
    //                resultSet = statement.executeQuery(sql2);
    //                resultSet.next();
    //                user = new User(resultSet.getString("user"),resultSet.getString("email"),resultSet.getString("password"),resultSet.getInt("power"));
    //                log l1 = new log(user.getUsername(), "登录日志",user.getUsername()+"已成功登录");
    //                WriteLog(l1);
                    return true;
                }else{
    //                log l2 = new log("", "登录日志", "登录失败");
    //                WriteLog(l2);
                    return false;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        //职工注册功能____________测试成功
        public int Register_Staff(String ID,String name, String gender,String email,String phone,String pw,String position){
            String temp = "SELECT COUNT(1) FROM `staff` WHERE ID = '%s'";
            String sql1 = String.format(temp, ID);
            ResultSet resultSet;
            try {
                resultSet = statement.executeQuery(sql1);
                resultSet.next();
                if(resultSet.getInt("COUNT(1)" )==1){
//                    JOptionPane.showMessageDialog(null, "用户名已注册！");
                    return -1;
                }else{
                    SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String Time = format.format(new Date(System.currentTimeMillis()));
                    String password = MD5Util.md5(pw);
                    String sql = "INSERT INTO `express station management system`.`staff`  VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s');";
                    String sql2 = String.format(sql, ID,name,gender, email,phone,password,position, Time);
                    statement.executeUpdate(sql2);
    //                log l1 = new log(na, "注册日志", na +"已成功注册");
    //                WriteLog(l1);
                    return 1;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return -1;
            }
        }
        //删除用户______________测试成功
        public void DeleteUser(String username){
            try {
                String s = "DELETE FROM `user` WHERE username = '%s'";
                String sql = String.format(s,username);
                statement.executeUpdate(sql);
    //            log l1 = new log("系统管理员", "删除用户","已成功删除，用户为"+x);
    //            WriteLog(l1);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //删除职工______________测试成功
        public void DeleteStaff(String ID){
            try {
                String s = "DELETE FROM `staff` WHERE ID = '%s'";
                String sql = String.format(s,ID);
                statement.executeUpdate(sql);
    //            log l1 = new log("系统管理员", "删除用户","已成功删除，用户为"+x);
    //            WriteLog(l1);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        //根据用户名查找用户
    public User FindUser(String username){
        try {
            String s = "SELECT * FROM `user` WHERE username = '%s'";
            String sql = String.format(s,username);
            ResultSet resultSet ;
            resultSet = statement.executeQuery(sql);
            resultSet.next();
            return  new User(resultSet.getString("username"),resultSet.getString("nickname"),resultSet.getString("name"),resultSet.getString("password"),resultSet.getString("email"),resultSet.getString("phone"));
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    //根据id查找员工
    public void test(String ID){
        String s = "SELECT * FROM `staff` WHERE ID = '%s'";
        String sql = String.format(s,ID);
        ResultSet resultSet ;
        try {
            resultSet = statement.executeQuery(sql);
            resultSet.next();
            System.out.println(resultSet.getString("ID"));
            System.out.println(resultSet.getString("position"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public Staff FindStaff(String ID){
        try {
            String s = "SELECT * FROM `staff` WHERE ID = '%s'";
            String sql = String.format(s,ID);
            ResultSet resultSet ;
            resultSet = statement.executeQuery(sql);
            resultSet.next();
            return  new Staff(resultSet.getString("ID"),resultSet.getString("name"),
                    resultSet.getString("password"),resultSet.getString("email"),
                    resultSet.getString("phone"),resultSet.getString("position"),resultSet.getString("gender")
            );
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    //修改用户密码
    public int UpdateUserPassword(User a,String oldPassword,String newPassword){
            String temp = MD5Util.md5(oldPassword);
            boolean flag = false;
            if(temp.equals(a.getPassword())){
                flag = true;
            }
            if (flag){
                String s1 = "UPDATE user SET `password`='%s' WHERE username = '%s'";
                String sql = String.format(s1,MD5Util.md5(newPassword),a.getUsername());
                try {
                    statement.executeUpdate(sql);
                    return 1;
                } catch (SQLException e) {
                    e.printStackTrace();
                    return -1;
                }
            }
            return 0;
    }
    public int UpdateUserPassword(String username,String oldPassword,String newPassword){
        String temp = MD5Util.md5(oldPassword);
        User a = FindUser(username);
        boolean flag = false;
        if(temp.equals(a.getPassword())){
            flag = true;
        }
        if (flag){

            String s1 = "UPDATE user SET `password`='%s' WHERE username = '%s'";
            String sql = String.format(s1,MD5Util.md5(newPassword),a.getUsername());
            try {
                statement.executeUpdate(sql);
                return 1;
            } catch (SQLException e) {
                e.printStackTrace();
                return -1;
            }
        }
        return 0;
    }
    //修改职工密码
    public void UpdateStaffPassword(Staff a,String oldPassword,String newPassword){
        String temp = MD5Util.md5(oldPassword);
        boolean flag = false;
        if(temp.equals(a.getPassword())){
            flag = true;
        }
        if (flag){
            String s1 = "UPDATE staff SET `password`='%s' WHERE ID = '%s'";
            String sql = String.format(s1,MD5Util.md5(newPassword),a.getID());
            try {
                statement.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public int UpdateStaffPassword(String id,String oldPassword,String newPassword){
        String temp = MD5Util.md5(oldPassword);
        Staff a = FindStaff(id);
        boolean flag = false;
        if(temp.equals(a.getPassword())){
            flag = true;
        }
        if (flag){
            String s1 = "UPDATE staff SET `password`='%s' WHERE ID = '%s'";
            String sql = String.format(s1,MD5Util.md5(newPassword),a.getID());

            try {
                statement.executeUpdate(sql);
                return  1;
            } catch (SQLException e) {
                e.printStackTrace();
                return -1;
            }
        }
        return  0;
    }
//        public void save_package(String company, String addressee, String addressee_phone){
//            product_ID(company,addressee,addressee_phone);
//        }
    //存包裹到数据库---------测试成功
        public void save_package(String company, String addressee, String addressee_phone){
            //xx000000
            //xx（公司）0(几号库)000（几号货架）0（第几层）（0）第几个
            switch (company){
                case "顺丰"://1号库
                    get_locate("SF1",1,addressee,addressee_phone);
                    break;
                case "京东"://2号库
                    get_locate("JD2",2,addressee,addressee_phone);
                    break;
                case "圆通"://3号库依次往下
                    get_locate("YT3",3,addressee,addressee_phone);
                    break;
                case "中通":
                    get_locate("ZT4",4,addressee,addressee_phone);
                    break;
                case "申通":
                    get_locate("ST5",5,addressee,addressee_phone);
                    break;
                case "韵达":
                    get_locate("YD6",6,addressee,addressee_phone);
                    break;
                case "德邦":
                    get_locate("DB7",7,addressee,addressee_phone);
                    break;
                default://8号库
                    get_locate("QT8",8,addressee,addressee_phone);
            }
        }
        public void get_locate(String company , int j , String addressee, String addressee_phone ){
            String x = "SELECT COUNT(1) FROM `package_0%d` WHERE number = '%s'";
            ResultSet resultSet;
            for (int i = 0; i < 99999; i++) {
                String str = company + String.format("%05d",i);
                String sql = String.format(x, j,str);
                try {
                    resultSet = statement.executeQuery(sql);
                    resultSet.next();
                    if(resultSet.getInt("COUNT(1)" )==1){
                        continue;
                    }else{
                        //入库
                        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String Time = format.format(new Date(System.currentTimeMillis()));
                        String sql1 = "INSERT INTO `express station management system`.`package_0%d`  VALUES  ('%s', '%s', '%s', '%s');";
                        String sql2 = String.format(sql1,j,str,addressee,addressee_phone,Time);
                        statement.executeUpdate(sql2);
                        break;
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //根据编号查找包裹位置-------------测试成功
    public String look_for_package(String ID){
        String house = ID.substring(2,3);
        String shelves = ID.substring(3,6);
        int floor = Integer.parseInt(ID.substring(6,7))+1;
        int num = Integer.parseInt(ID.substring(7))+1;
        return "您查找的包裹在"+house+"仓库"+ shelves+"号货架"+floor+"层，第"+num+"个";
    }
    public Package_Get GetPackage(String ID){
//        "SF100002"
        String house = ID.substring(2,3);//1
        String temp = "SELECT * FROM `package_0%s` WHERE number = '%s' ";
        String sql = String.format(temp,house,ID);
        Package_Get pp = new Package_Get();
        try {
            ResultSet resultSet = statement.executeQuery(sql);
            resultSet.next();//游标为空，需要下移一格
            pp = new Package_Get(resultSet.getString("number"),resultSet.getString("addressee"),resultSet.getString("addressee_telephone"));
            return pp;
        } catch (SQLException e) {
            e.printStackTrace();
            return pp;

        }
    }
    //删除包裹
    public void DeletePackage(String id){
            int i = Integer.parseInt(id.substring(2,3));
            try {
                String s = "DELETE FROM `package_0%d` WHERE number = '%s'";
                String sql = String.format(s,i,id);
                statement.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
    }
    //查找包裹 根据手机号查找该手机号所有包裹___测试成功
    public  ArrayList<Package_Get> FindMyPackage(String phone){
        ArrayList<Package_Get> list = new ArrayList<>();
        for (int i = 1; i <= 8; i++) {
            ArrayList<Package_Get> temp = Find_IN(i,phone);
            list.addAll(temp);
        }
        return list;
    }
    public ArrayList<Package_Get> Find_IN(int i,String phone){
        String temp = "SELECT COUNT(1) FROM `package_0%d` WHERE addressee_telephone = '%s' ";
        String temp2 = "SELECT * FROM `package_0%d` WHERE addressee_telephone = '%s' ";
        String sql1 = String.format(temp, i, phone);
        String sql2 = String.format(temp2, i, phone);
        ArrayList<Package_Get> list = new ArrayList<>();
        try {
            ResultSet resultSet = statement.executeQuery(sql1);
            resultSet.next();//游标为空，需要下移一格
            if(resultSet.getInt("COUNT(1)" )==0){
                System.out.println("无");
            }else{
                resultSet = statement.executeQuery(sql2);
                while(resultSet.next()){
                    Package_Get temp3 = new Package_Get(resultSet.getString("number"),resultSet.getString("addressee"),resultSet.getString("addressee_telephone"));
                    list.add(temp3);
                }
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return list;
        }
    }
    //写入寄件库______测试成功
    public void Save_Package_Send(String sender,String sender_phone,String addressee,String addressee_phone,String destination,String company){
        try {
            ResultSet resultSet;
            resultSet = statement.executeQuery("SELECT COUNT(1) FROM `package_send` ");
            resultSet.next();//游标为空，需要下移一格
            int num = resultSet.getInt("COUNT(1)" );
            String sql1 = "INSERT INTO `express station management system`.`package_send`  VALUES ('%d', '%s', '%s', '%s', '%s', '%s', '%s');";
            String sql2 = String.format(sql1, num, sender,sender_phone,addressee,addressee_phone,destination,company);
            statement.executeUpdate(sql2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //删除寄件中任意编号的快递，后面编号的依次向上顺延——————————————测试成功
    public void DeleteSendPackage(int x){
        try {
            String all = "SELECT COUNT(1) FROM `package_send`";
            ResultSet resultSet = statement.executeQuery(all);
            resultSet.next();//游标为空，需要下移一格
            if(resultSet.getInt("COUNT(1)" )>=x){
                String s = "DELETE FROM package_send WHERE odd_number = '%d'";
                String s1 = "UPDATE package_send SET odd_number=odd_number-1 WHERE odd_number>%d";
                String sql = String.format(s,x);
                String sql2 = String.format(s1,x);
                statement.executeUpdate(sql);
                statement.executeUpdate(sql2);
//                JOptionPane.showMessageDialog(null, "删除成功");
            }else{
//                JOptionPane.showMessageDialog(null, "删除失败，编号不存在！");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    //共有多少待寄件
    public int countOfSend(){
        String all = "SELECT COUNT(1) FROM `package_send`";
        try {
            ResultSet resultSet = statement.executeQuery(all);
            resultSet.next();//游标为空，需要下移一格
            return resultSet.getInt("COUNT(1)");
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
    //返回用户身份码
    public String Myid(User a){
        String temp = "SELECT * FROM `user` WHERE username = '%s' AND phone = '%s' ";
        String sql1 = String.format(temp, a.getUsername(), a.getPhone());
        try {
            ResultSet resultSet = statement.executeQuery(sql1);
            resultSet.next();
            return resultSet.getString("MyID");
        } catch (SQLException e) {
            e.printStackTrace();
            return "";
        }
    }
    public String Myid(String username,String phone){
        String temp = "SELECT * FROM `user` WHERE username = '%s' AND phone = '%s' ";
        String sql1 = String.format(temp, username, phone);
        try {
            ResultSet resultSet = statement.executeQuery(sql1);
            resultSet.next();
            return resultSet.getString("MyID");
        } catch (SQLException e) {
            e.printStackTrace();
            return "";
        }
    }

}
