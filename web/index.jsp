<%@ page import="Model.Task" %>
<%@ page import="Model.InvalidTask" %><%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel = "stylesheet" href = "resources/style.css" type = "text/css" />
    <title>String modification</title>
</head>

<body class="myclass" >
<div>
    <h1>String modification</h1>
</div>

<div>
    <div style="font-size: 20px">
        <div style="font-size: 10pt">
            <h2 >Delete some symbols from the end</h2>
        </div>
        <%! String input = "";
            String num = "";
            String err = "";
                %>
        <%
            if( request.getAttribute("error") != null) {
                //input = ((Task) request.getAttribute("task")).getInputString();
                //num = Integer.toString(((Task) request.getAttribute("task")).getNum());
                err = (String) request.getAttribute("error");
                out.println("<h1>" + err + "</h1>");
            }
            if( request.getAttribute("invalidtask") != null) {
                input = ((InvalidTask) request.getAttribute("invalidtask")).getWrongString();
                num = ((InvalidTask) request.getAttribute("invalidtask")).getWrongNum();
            }
        %>
    <div >

        <form method="post" accept-charset="UTF-8">
            <label>String:
                <input title="string" maxlength="14" class="myclass" type="text" name="string" required value= <%out.println(input); input = "";%> ><br/>
            </label>
            <label  <%   if(!err.isEmpty()){
                            out.println("class = \"errorclass\"" + "data-title = \"" + err + "\"");
                        }
                        err = "";%>
            >Number of letters to be deleted from the end:
                <input  title = "" maxlength="14" class="myclass" name="num" required value=
                    <%out.println(num); num = "";
                      %> ><br/>
            </label>
            <div style="padding-top: 7%"> <button  class="buttonclass" type="submit">Submit</button></div>

        </form>
    </div>

    </div>
</div>

<!---<div>
    <button class="buttonclass" onclick="location.href='/home'">Back to main</button>
</div>-->
</body>
</html>