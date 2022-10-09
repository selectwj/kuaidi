package servlet_yc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StationServlet extends BaseServlet{
    protected void loginStation(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(username.equals("root") && password.equals("123456")){
            //登陆成功 跳到成功页面
            req.getRequestDispatcher("/pages/temp/SuccessLoginStation.jsp").forward(req,resp);
        }else{
            //把错误信息转回去
            req.setAttribute("msg","登陆失败");
            req.setAttribute("username",username);
            //跳回登录界面
            req.getRequestDispatcher("/pages/station/mglogin.jsp").forward(req,resp);
        }
    }
}
