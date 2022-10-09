<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>员工需求</title>

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
        <li><a href="#">包裹入库</a>
          <div class="p2">
            <dl>
              <dt>包裹入库
              <dd><a href="../packge.jsp " target="_blank">入库</a></dd>
              <dd>
                <form action="http://localhost:8080/my_express_station/staffServlet" method="post" autocomplete="off" class="form">
                    <input type="hidden", name="action", value="InPackage">
                    快递公司: <input type="text", name="company"><br>
                    收件人: <input type="text", name="addressee"><br>
                    收件人电话: <input type="text", name="addresseePhone"><br>
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
        <li><a href="#">包裹出库</a>
          <div class="p2">
            <dl>
              <dt>包裹出库
              <dd><form action="http://localhost:8080/my_express_station/staffServlet" method="post" autocomplete="off" class="form">
                <input type="hidden", name="action", value="OutPackage">
                  包裹编号: <input type="text", name="number"><br>
                  客户身份码: <input type="text", name="ID"><br>
                <button type="submit" >确认</button><br>
              </form>
                <table border="1" width="600px" height="300px">
                  <tr>
                    <th><%=request.getAttribute("letter")==null?"":request.getAttribute("letter")%></th>
                  </tr>
                </table></dd>
              </dt>
            </dl>
          </div>
        </li>
        <li><a href="#">查找包裹</a>
          <div class="p2">
            <dl>
              <dt>查找包裹
              <dd><form action="http://localhost:8080/my_express_station/searchPackageServlet" method="post" autocomplete="off" class="form">
              <input type="hidden", name="action", value="FindByID">
                包裹编号: <input type="text", name="number"><br>
                <button type="submit" >确定</button><br>
            </form>
                <table border="1" width="600px" height="300px">
                  <tr>
                    <th><%=request.getAttribute("place")==null?"":request.getAttribute("place")%></th>
                  </tr>
                </table></dd>
              </dt>
            </dl>
          </div>
        </li>
        <li><a href="#">寄件</a>
          <div class="p2">
            <dl>
              <dt>寄件
              <dd><form action="http://localhost:8080/my_express_station/staffServlet" method="post" autocomplete="off" class="form">
                              <input type="hidden", name="action", value="SendPackage">
                      寄件人: <input type="text", name="sender"><br>
                      寄件人电话: <input type="text", name="sender_phone"><br>
                      收件人: <input type="text", name="addressee"><br>
                      收件人电话: <input type="text", name="addressee_phone"><br>
                      目的地: <input type="text", name="destination"><br>
                      快递公司: <input type="text", name="company"><br>
                <button type="submit">确定</button><br>
            </form>
                <table border="1" width="600px" height="300px">
                  <tr>
                    <th><%=request.getAttribute("msg")==null?"":request.getAttribute("msg")%></th>
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