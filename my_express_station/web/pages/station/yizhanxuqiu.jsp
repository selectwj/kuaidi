<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>驿站需求</title>
    <style >

        ul,ol{
            list-style-type: none;
        }
        .p1{
            width: 1220px;
            height: 600px;

        }
        .p1 #main1{
            width: 13%;
            height: 590px;
            margin: 5px auto;
            border: red solid 1px;
            position: absolute;
            left: 149px;
        }
        .p1:after{
            content: "";
            display: block;
            clear: both;
        }
        a{
            text-decoration: none;
            color: #000000;
        }
        #main #main1{
            font-weight: bold;
            color: #FFFFFF;
            background: #DDDDDD;
            line-height: 60px;
        }
        /*#main #main1 .p2{*/
        /*    display: none;*/
        /*    width: 400px;*/
        /*    height: 360px;*/
        /*    border: #0000FF 1px solid;*/
        /*    background: royalblue;*/
        /*    color: white;*/
        /*    font-size: 16px;*/
        /*    line-height: 30px;*/
        /*}*/
        #main #main1 .p2{
            display: none;
            width: 1000px;
            height: 590px;
            border: #0000FF 1px solid;
            background: royalblue;
            color: white;
            font-size: 16px;
            line-height: 30px;

        }
        #main{
            position: relative;
        }
        #main #main1 li:hover .p2{
            display: block;
            /*right: -404px;*/
            right: -1000px;
            top: 0;
            position: absolute;
        }
        body {
            background-image: url("http://localhost:8080/my_express_station/static/pictures/Back.png ");
            background-size: 100%;
            /*背景*/
        }
    </style>
</head>
<body>
<header>
    <h1>欢迎来到快递驿站</h1>
</header>
<section>
    <div id="main" class="p1">
        <div id="main1">
            <ul>
                <li><a href="#">员工管理</a>
                    <div class="p2">
                        <dl>
                            <dt>员工管理
                            <dd>修改员工密码</dd>
                            <dd>
                                <form action="http://localhost:8080/my_express_station/staffServlet" method="post" autocomplete="off" class="form">
                                    <input type="hidden", name="action", value="changePasswordStaff">
                                    员工ID: <input type="text", name="username"><br>
                                    旧密码: <input type="text", name="password_old"><br>
                                    新密码: <input type="text", name="password_new"><br>
                                    <button type="submit" >确认</button><br>
                                </form>
                                <table border="1" width="600px" height="300px">
                                    <tr>
                                        <th><%=request.getAttribute("message")==null?"":request.getAttribute("message")%></th>
                                    </tr>
                                </table>
                            </dd>
                            </dt>
                        </dl>
                    </div>
                </li>
                <li><a href="#">客户管理</a>
                    <div class="p2">
                        <dl>
                            <dt>客户管理
                            <dd>修改客户密码</dd>
                            <dd>
                                <form action="http://localhost:8080/my_express_station/userServlet" method="post" autocomplete="off" class="form">
                                    <input type="hidden", name="action", value="changePassword">
                                    用户名: <input type="text", name="usernameUser"><br>
                                    旧密码: <input type="text", name="password_old_User"><br>
                                    新密码: <input type="text", name="password_new_User"><br>
                                    <button type="submit" >确认</button><br>
                                </form>
                                <table border="1" width="600px" height="300px">
                                    <tr>
                                        <th><%=request.getAttribute("msg")==null?"":request.getAttribute("msg")%></th>
                                    </tr>
                                </table>
                            </dd>
                            </dt>
                        </dl>
                    </div>
                </li>
                <li><a href="#">业务管理</a>
                    <div class="p2">
                        <dl>
                            <dt>业务管理
                            <dd>收快递数量</dd>
                            <dd>发快递数量</dd>
                            <dd>营业额</dd>
                            </dt>
                        </dl>
                    </div>
                </li>

            </ul>
        </div>
        <div id="main2">

        </div>


    </div>
    </div>
</section>
<footer>

</footer>
</body>
</html>
