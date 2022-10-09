<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>快递驿站</title>

    <style>
        a{text-decoration:none}

        a:hover{text-decoration:none}
        /*去下划线*/
        body {
            background-image: url("http://localhost:8080/my_express_station/static/pictures/Background.jpg");
            background-size: 100%;
            text-align: center;
            /*背景*/
        }

        h1{
            color: aqua;
            text-align: center;
        }
        .parent{


        }
        .features{

            color: black;
            padding:20px;
            display:flex;
            flex-direction: row;
            width:800px;
        }

        .features figure img{
            border-radius:50%;
            /*圆角*/
            width:350px;
        }
    </style>
    <link rel="icon" type="image/x-icon" href="static/pictures/555.jpg">
    <link rel="stylesheet" href="pages/lo.js">
</head>
<body>
<h1>欢迎来到快递驿站</h1>

<section class="features">

    <figure class="a">
        <img src="static/pictures/staff.jpg" alt="员工">
        <figcaption>
            <a href="pages/staff/wklogin.jsp " target="_blank">员工登录</a>
        </figcaption>
    </figure >
    <figure class="a">
        <img src="static/pictures/user.jpg" alt="用户">
        <figcaption>
            <a href="pages/user/Ulogin.jsp " target="_blank">用户登录</a>
        </figcaption>

    </figure>
    <figure class="a">
        <img src="static/pictures/station.jpg" alt="管理员">
        <figcaption>
            <a href="pages/station/mglogin.jsp " target="_blank">管理员登录</a>
        </figcaption>

    </figure>

</section>

</header>

</body>
</html>