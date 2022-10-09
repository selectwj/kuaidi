<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>用户登录页面</title>
    <style>
        body {
            background-image: url("http://localhost:8080/my_express_station/static/pictures/222.png");
            background-repeat: no-repeat;
            background-size: 100% 100%;
            background-attachment: fixed;      /*图片铺满整个页面*/
        }
        .main {
            width: 500px;
            height: 400px;
            box-shadow: 0 5px 20px 0 #e8e8e8;
            background-color: white;
            border-radius: 10px;
            position: absolute;
            top: 0;
            right: 0;
            bottom: 0;
            left: 0;
            margin: auto;
        }
        .main h2 {
            color: lightseagreen;
            margin-left: 150px;
        }
        .form {
            margin-top: 30px;
            margin-left: 60px;
        }
        .form input {
            width: 300px;
            height: 25px;
            border: 1px solid lightgray;
            outline: none;      /*输入内容时不显示边框*/
        }
        .form button {
            width: 150px;
            height: 30px;
            color: white;
            background-color: lightseagreen;
            border-style: none;
            border-radius: 5px;
            font-size: 15px;
            margin-top: 15px;
            margin-left: 130px;
            outline: none;
            cursor: pointer;    /*光标放到上面有小手*/
        }
        .msg_cont{

            background: none repeat scroll 0 0 #fff6d2;
            border: 1px solid #ffe57d;
            color: #666;
            height: 18px;
            line-height: 18px;
            padding: 3px 10px 3px 40px;
            position: relative;
            border: none;
        }
    </style>
    <link rel="icon" type="image/x-icon" href="../../static/pictures/333.jpg">
</head>
<body>
<div class="main">
    <h2>员工注册</h2>
    <div class="msg_cont">
        <b></b>
        <span class="errorMsg">
            <%=request.getAttribute("msg")==null?"请输入信息":request.getAttribute("msg")%>
        </span>
    </div>
    <form action="http://localhost:8080/my_express_station/staffServlet" method="post" class="form">
        <input type="hidden", name="action", value="registStaff">
        ID: <input type="text", name="ID" value="<%=request.getAttribute("ID")==null?"":request.getAttribute("ID")%>"> <br>    <!--输入的用户名保存到username变量，传回后端-->
        姓名 : <input type="text", name="name" value="<%=request.getAttribute("name")==null?"":request.getAttribute("name")%>"><br>
        性别 <input type="text", name="gender" value="<%=request.getAttribute("gender")==null?"":request.getAttribute("gender")%>"><br>
        邮箱: <input type="text", name="email" value="<%=request.getAttribute("email")==null?"":request.getAttribute("email")%>"><br>
        手机号: <input type="text", name="phone" value="<%=request.getAttribute("phone")==null?"":request.getAttribute("phone")%>"><br>
        密码: <input type="password", name="password"><br>
        职务: <input type="text", name="position" value="<%=request.getAttribute("position")==null?"":request.getAttribute("position")%>"><br>
        <button type="submit">注册</button><br>
    </form>
</div>


</body>
</html>