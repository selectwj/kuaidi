<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>取件码</title>
    <style>
        body {
            background-image: url("../static/pictures/222.png");
            background-repeat: no-repeat;
            background-size: 100% 100%;
            background-attachment: fixed;      /*图片铺满整个页面*/
        }
        .main {
            width: 500px;
            height: 300px;
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
    </style>
    <link rel="icon" type="image/x-icon" href="../static/pictures/333.jpg">
</head>
<body>
<div class="main">
    <h2>获取验证码</h2>
    <form action="" method="post" class="form">
        用户名: <input type="text", name="username"><br>    <!--输入的用户名保存到username变量，传回后端-->

        <button onclick="a()">获取</button><br>
        <script>
            function a(){
                alert("取件码")
            }
        </script>

    </form>
</div>


</body>
</html>