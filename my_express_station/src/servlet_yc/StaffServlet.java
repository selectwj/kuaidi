package servlet_yc;

import Entity_class.Package_Get;
import MySystem.System_AboutDatabase;
import MySystem.System_AboutStaff;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StaffServlet extends BaseServlet{
    System_AboutDatabase sys  = new System_AboutDatabase();
    System_AboutStaff system_aboutStaff = new System_AboutStaff();
    protected void loginStaff(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println(resp.getCharacterEncoding());
//        resp.setCharacterEncoding("UTF-8");
//        resp.setHeader("Content-Type","text/html;charset=UTF-8");
        resp.setContentType("text/html;charset=GBK");
        System.out.println(resp.getCharacterEncoding());
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println(username);
        System.out.println(password);
        if(sys.Sign_in_Staff(username,password)){
            //登陆成功 跳到成功页面
            req.getRequestDispatcher("/pages/temp/SuccessLoginStaff.jsp").forward(req,resp);
        }else{
            //把错误信息转回去
            req.setAttribute("msg","登陆失败");
            req.setAttribute("username",username);
            //跳回登录界面
            req.getRequestDispatcher("/pages/staff/wklogin.jsp").forward(req,resp);
        }
    }
    protected void registStaff(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ID = req.getParameter("ID");
        String nam = req.getParameter("name");
        String gende = req.getParameter("gender");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String password = req.getParameter("password");
        String positio = req.getParameter("position");
        String position = new String(positio.getBytes("ISO8859_1"), "UTF-8");
        String gender = new String(gende.getBytes("ISO8859_1"), "UTF-8");
        String name = new String(nam.getBytes("ISO8859_1"), "UTF-8");
        if(sys.Register_Staff(ID,name, gender,email,phone,password,position)<0){
            req.setAttribute("msg","注册失败，用户名已存在");
            req.setAttribute("ID",ID);
            req.setAttribute("email",email);
            req.setAttribute("phone",phone);
            req.setAttribute("gender",gender);
            req.setAttribute("name",name);
            req.setAttribute("position",position);
            req.getRequestDispatcher("/pages/staff/wkregister.jsp").forward(req,resp);
        }else {
            req.getRequestDispatcher("/pages/temp/SuccessRegist.jsp").forward(req, resp);
        }
    }
    //包裹入库
    protected void InPackage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String compan = req.getParameter("company");
        String addresse = req.getParameter("addressee");
        String addressee_phon = req.getParameter("addresseePhone");
        System.out.println(compan);
        System.out.println(addresse);
        String company = new String(compan.getBytes("ISO8859_1"), "UTF-8");
        String addressee= new String(addresse.getBytes("ISO8859_1"), "UTF-8");
        String  addressee_phone = new String(addressee_phon.getBytes("ISO8859_1"), "UTF-8");
        System.out.println(company);
        System.out.println(addressee);
        sys.save_package(company, addressee, addressee_phone);
        req.setAttribute("message","入库成功！");
        req.getRequestDispatcher("/pages/staff/yuangongxuqiu.jsp").forward(req, resp);
    }
    //包裹出库
    protected void OutPackage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String number = req.getParameter("number");
        String id = req.getParameter("ID");
        Package_Get temp = sys.GetPackage(number);
        if(system_aboutStaff.check(id,temp)){
            sys.DeletePackage(number);
            req.setAttribute("letter","出库成功！");
        }else{
            req.setAttribute("letter","出库失败，取件码或身份码认证无效！");
        }
        req.getRequestDispatcher("/pages/staff/yuangongxuqiu.jsp").forward(req, resp);
    }
    //发包裹
    protected void SendPackage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
        sys.Save_Package_Send( sender,sender_phone,addressee,addressee_phone,destination,company);
        req.setAttribute("msg", "包裹已加入寄件库中");
        req.getRequestDispatcher("/pages/staff/yuangongxuqiu.jsp").forward(req,resp);
    }
    protected void changePasswordStaff(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password_old = req.getParameter("password_old");
        String password_new = req.getParameter("password_new");
        if(sys.UpdateStaffPassword(username,password_old,password_new)>0){
            //修改成功
            //把信息转回去
            req.setAttribute("message","修改成功！");
        }else{
            //把错误信息转回去
            req.setAttribute("message","用户名或旧密码不正确！");
        }
        req.setAttribute("username",username);
        //跳回菜单
        req.getRequestDispatcher("/pages/station/yizhanxuqiu.jsp").forward(req,resp);
    }
}
