<%@ page import="Model.Task" %>
<%@ page import="java.io.ByteArrayInputStream" %><%--
  Created by IntelliJ IDEA.
  User: Opsymonroe
  Date: 01.04.2018
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel = "stylesheet" href = "resources/style.css" type = "text/css" />
    <title>Title</title>
</head>
<body class="myclass">

<div>
    <div>
        <div class="myclass">
            <h2>Modify string</h2>
        </div>
        <div class="mysecondclass" style="font-size: 48px">
            <%if(request.getSession().getAttribute("task") == null){
                out.println("<h1>" + "Something went wrong" + "</h1>");
                out.println("<h2>" + "You will be redirected to the home page or you can instantly go there by clicking button below " + "</h2>");
                response.setHeader("Refresh", "5; /web_war_exploded/home");
            }
            else {
                Task task = (Task) request.getSession().getAttribute("task");
                out.println("<li> Input string: " + task.getInputString() + "</li>");
                out.println("<li> Number of chars to be deleted: " + task.getNum() + "</li>");
                out.println("<li> Result: " + task.getResult() + "</li>");
                out.println("<button class=\"buttonclass\" onclick=\"location.href='/result.xml'\">Download</button>");


            }
            %>

        </div>

    </div>
</div>

<div style="padding-top: 10%">

    <button class="buttonclass" onclick="location.href='/web_war_exploded/home'">Back to main</button>

</div>
</body>
</html>
