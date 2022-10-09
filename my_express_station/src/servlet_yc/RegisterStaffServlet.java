package servlet_yc;

import MySystem.System_AboutStation;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterStaffServlet extends HttpServlet {
    System_AboutStation system_aboutStation = new System_AboutStation();
    //获取参数
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        String ID = req.getParameter("ID");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String gender = req.getParameter("gender");
        String password = req.getParameter("password");
        String position = req.getParameter("position");
        String phone = req.getParameter("phone");
        //如果合法 跳转到登录成功页面 不合法跳回本身
        if(system_aboutStation.New_Staff(ID,name,gender,email,phone,password,position)<0){
            System.out.println("注册失败");
            req.getRequestDispatcher("/pages/wkregister.jsp").forward(req,resp);
        }else{
            req.getRequestDispatcher("/pages/temp/SuccessRegist.jsp").forward(req,resp);
        }
    }
}
