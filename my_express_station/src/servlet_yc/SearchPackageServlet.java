package servlet_yc;

import Entity_class.Package_Get;
import MySystem.System_AboutDatabase;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class SearchPackageServlet extends BaseServlet{
    System_AboutDatabase sys = new System_AboutDatabase();
    protected void FindByPhone(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        String phone = req.getParameter("Phone");
        //查询包裹信息
        ArrayList<Package_Get> list = sys.FindMyPackage(phone);
        //保存到request域
        req.setAttribute("packageList",list);
        //转到原来界面
        req.getRequestDispatcher("/pages/user/kehuxuqiu.jsp").forward(req,resp);
    }
    protected void FindByID(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数
        String number = req.getParameter("number");
        //查询包裹信息
        String place = sys.look_for_package(number);
        //保存到request域
        req.setAttribute("place",place);
        //转到原来界面
        req.getRequestDispatcher("/pages/staff/yuangongxuqiu.jsp").forward(req,resp);
    }
}
