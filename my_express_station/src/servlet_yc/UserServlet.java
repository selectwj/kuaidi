package servlet_yc;

import MySystem.System_AboutDatabase;
import MySystem.System_AboutStation;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class UserServlet extends BaseServlet {
    System_AboutStation system_aboutStation =new System_AboutStation();
    System_AboutDatabase sys = new System_AboutDatabase();
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("na");
        String password = req.getParameter("pw");
        String email = req.getParameter("ema");
        String nicknam = req.getParameter("nickname");
        String phone = req.getParameter("phone");
        String truenam = req.getParameter("truename");
        String nickname = new String(nicknam.getBytes("ISO8859_1"), "UTF-8");
        String truename = new String(truenam.getBytes("ISO8859_1"), "UTF-8");
        if(system_aboutStation.New_Customer(name,password,email,nickname,phone,truename)<0){
            req.setAttribute("msg","注册失败，用户名已存在");
            req.setAttribute("username",name);
            req.setAttribute("email",email);
            req.setAttribute("phone",phone);
            req.setAttribute("nickname",nickname);
            req.setAttribute("truename",truename);
            req.getRequestDispatcher("/pages/user/Uregister.jsp").forward(req,resp);
        }else {
            req.getRequestDispatcher("/pages/temp/SuccessRegist.jsp").forward(req, resp);
        }
    }
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(sys.Sign_in_User(username,password)){
            //登陆成功 跳到成功页面
            req.getRequestDispatcher("/pages/temp/SuccessLogin.jsp").forward(req,resp);
        }else{
            //把错误信息转回去
            req.setAttribute("msg","登陆失败");
            req.setAttribute("username",username);
            //跳回登录界面
            req.getRequestDispatcher("/pages/user/Ulogin.jsp").forward(req,resp);
        }
    }
    protected void showID(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String phone = req.getParameter("phone");
        String ss = sys.Myid(username, phone);
        if (ss.equals("")) {
            //把错误信息转回去
            req.setAttribute("msg", "身份确认失败");
            req.setAttribute("username", username);
            //跳回界面
        }
        System.out.println("ss");
        req.setAttribute("id", ss);
        req.getRequestDispatcher("/pages/user/kehuxuqiu.jsp").forward(req,resp);
    }
    protected void tuihuo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String number = req.getParameter("package_number");
        String sende = req.getParameter("sender");
        String sender_phone = req.getParameter("sender_phone");
        String addresse = req.getParameter("addressee");
        String addressee_phon = req.getParameter("addressee_phone");
        String destinatio = req.getParameter("destination");
        String compan = req.getParameter("company");
        String company = new String(compan.getBytes("ISO8859_1"), "UTF-8");
        String addressee= new String(addresse.getBytes("ISO8859_1"), "UTF-8");
        String  addressee_phone = new String(addressee_phon.getBytes("ISO8859_1"), "UTF-8");
        String  destination = new String(destinatio.getBytes("ISO8859_1"), "UTF-8");
        String  sender = new String(sende.getBytes("ISO8859_1"), "UTF-8");
        sys.DeletePackage(number);
        sys.Save_Package_Send( sender,sender_phone,addressee,addressee_phone,destination,company);
        req.setAttribute("msg2", "删除成功");
        req.getRequestDispatcher("/pages/user/kehuxuqiu.jsp").forward(req,resp);
    }
    protected void changePassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("usernameUser");
        String password_old = req.getParameter("password_old_User");
        String password_new = req.getParameter("password_new_User");
        if(sys.UpdateUserPassword(username,password_old,password_new)>0){
            //传回信息
            req.setAttribute("msg","更新成功！");
        }else{
            //把错误信息转回去
            req.setAttribute("msg","用户名或旧密码不正确！");
        }
        //跳回菜单
        req.getRequestDispatcher("/pages/station/yizhanxuqiu.jsp").forward(req,resp);
    }

}
