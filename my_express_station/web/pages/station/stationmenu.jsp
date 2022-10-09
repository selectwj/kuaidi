<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>驿站管理</title>

    <style>
        a{text-decoration:none}

        a:hover{text-decoration:none}
        /*去下划线*/
        body {
            background-image: url("http://localhost:8080/my_express_station/static/pictures/Back.png");
            background-size: 100%;

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
    <link rel="icon" type="image/x-icon" href="../../static/pictures/555.jpg">
    <link rel="stylesheet" href="../lo.js">
</head>
<body>
<h1>欢迎来到管理系统</h1>

<section class="features">

    <figure class="a">
        <img src="777.jpg" alt="员工">
        <figcaption>
            <a href="mglogin.jsp " target="_blank">员工管理</a>
        </figcaption>
    </figure >
    <figure class="a">
        <img src="888.jpg" alt="用户">
        <figcaption>
            <a href="../user/Ulogin.jsp " target="_blank">用户管理</a>
        </figcaption>

    </figure>
    <figure class="a">
        <img src="999.jpg" alt="管理员">
        <figcaption>
            <a href="mglogin.jsp " target="_blank">业务管理</a>
        </figcaption>

    </figure>

</section>

</header>

</body>
</html>