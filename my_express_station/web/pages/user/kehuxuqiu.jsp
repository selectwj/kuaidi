<%@ page import="Entity_class.Package_Get" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>客户需求</title>
    <style>

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
            right: -1000px;
            top: 0;
            position: absolute;
        }
        body {
            background-image: url("http://localhost:8080/my_express_station/static/pictures/Back.png");
            background-size: 100%;

            /*背景*/
        }
        table{
            border: 1px black solid;
            width: 600px;
            border-collapse: collapse;
        }
        td,th{
            border: 1px black solid;
        }
    </style>
</head>
<body>
<header>
</header>
<section>
    <div id="main" class="p1">
        <div id="main1">
            <ul>
                <li><a href="#">查看包裹信息</a>
                    <div class="p2">
                        <dl>
                            <dt>查看包裹信息
                            <dd><a href="../num.jsp " target="_blank">包裹信息</a></dd>
                            <dd>

                                <form action="http://localhost:8080/my_express_station/searchPackageServlet" method="post"  autocomplete="off" class="form">
                                    <input type="hidden", name="action", value="FindByPhone">
                                    你的手机号: <input type="text", name="Phone"><br>
                                    <button type="submit">确定</button>
                                </form>
                                <%
                                    List<Package_Get> packageGetList  =  new ArrayList<Package_Get>();
                                    if(request.getAttribute("packageList")==null){
                                    }else{
                                    packageGetList  =  (List<Package_Get>) request.getAttribute("packageList");
                                    }
                                %>
                                <table border="1" width="600px" height="300px">
                                    <tr>
                                        <td>取件码</td>
                                        <td>收件人</td>
                                        <td>收件人电话</td>
                                        <td>入库时间</td>
                                    </tr>
                                    <%for (Package_Get package_get : packageGetList) { %>
                                    <tr>
                                        <td><%=package_get.getNumber()%></td>
                                        <td><%=package_get.getAddressee()%></td>
                                        <td><%=package_get.getAddressee_telephone()%></td>
                                        <td><%=package_get.getCreate_at()%></td>
                                    </tr>
                                    <%}%>
                                </table>
                            </dd>
                            </dt>
                        </dl>
                    </div>
                </li>
                <li><a href="#">提供身份码</a>
                    <div class="p2">
                        <dl>
                            <dt>提供身份码
                                <div class="msg_cont">
                                    <b></b>
                                    <span class="errorMsg"><%=request.getAttribute("msg")==null?"":request.getAttribute("msg")%></span>
                                </div>
                            <dd>
                            <form action="http://localhost:8080/my_express_station/userServlet" method="post" autocomplete="off" class="form">
                                <input type="hidden", name="action", value="showID">

                                确认你的用户名: <input type="text", name="username"><br>
                                确认你的手机号: <input type="text", name="phone"><br>
                                <button type="submit" >查看身份码</button>
                            </form>
<%--                            <div>--%>
<%--                                <b></b>--%>
<%--                                <span><%=request.getAttribute("id")==null?"":request.getAttribute("id")%></span>--%>
<%--                            </div>--%>
                                <table border="1" width="600px" height="300px">
                                    <tr>
                                        <td><%=request.getAttribute("id")==null?"":request.getAttribute("id")%></td>
                                    </tr>
                                </table></dd>
                            </dt>
                        </dl>
                    </div>
                </li>
                <li><a href="#">预约取件</a>
                    <div class="p2">
                        <dl>
                            <dt>预约取件
                            <dd><form action="" method="post" autocomplete="off" class="form">
                                快递公司: <input type="text", name="ID"><br></form>
                                <button onclick="a()">注册</button><br>
                                <script>
                                    function a(){
                                        alert("入库成功")
                                    }
                                </script>
                                <table border="1" width="600px" height="300px">
                                    <tr>
                                        <th></th>

                                    </tr>
                                </table></dd>
                            </dt>
                        </dl>
                    </div>
                </li>
                <li><a href="#">预约寄件</a>
                    <div class="p2">
                        <dl>
                            <dt>预约寄件
                            <dd><form action="" method="post" autocomplete="off" class="form">
                                快递公司: <input type="text", name="ID"><br></form>
                                <button onclick="a()">注册</button><br>
                                <script>
                                    function a(){
                                        alert("入库成功")
                                    }
                                </script>
                                <table border="1" width="600px" height="300px">
                                    <tr>
                                        <th></th>

                                    </tr>
                                </table></dd>
                            </dt>
                        </dl>
                    </div>
                </li>
                <li><a href="#">申请退货</a>
                    <div class="p2">
                        <dl>
                            <dt>申请退货
                            <dd>
                            <form action="http://localhost:8080/my_express_station/userServlet" method="post" autocomplete="off" class="form">
                                <input type="hidden", name="action", value="tuihuo">
                                你的快递取件码: <input type="text", name="package_number"><br>
                                      寄件人: <input type="text", name="sender"><br>
                                   寄件人电话: <input type="text", name="sender_phone"><br>
                                      收件人: <input type="text", name="addressee"><br>
                                   收件人电话: <input type="text", name="addressee_phone"><br>
                                      目的地: <input type="text", name="destination"><br>
                                    快递公司: <input type="text", name="company"><br>
                                <button type="submit" >注册</button><br>
                            </form>

                                <table border="1" width="600px" height="300px">
                                    <tr>
                                        <th><%=request.getAttribute("msg2")==null?"":request.getAttribute("msg")%></th>
                                    </tr>
                                </table></dd>
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