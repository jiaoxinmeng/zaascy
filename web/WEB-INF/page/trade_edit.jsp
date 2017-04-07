<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/3/16
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>trade edit jsp</title>
    <script type="application/javascript" src="/resources/js/jquery.js">

    </script>
</head>
<body>
    <div>
        <form action="/tradeController/save.do" method="post" >
            <table>
                <tr>
                    <td>项目名称</td>
                    <td>
                        <input type="text" name="projectName" />
                    </td>
                </tr>
                <tr>
                    <td>院成果编码</td>
                    <td>
                        <input type="text" name="zaasCode" />
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="submit">
                    </td>
                </tr>
            </table>
        </form>
    </div>
</body>
<script type="application/javascript">
    $("#editBt").click(function (){
        window.location.href = "edit.do";
    });
</script>
</html>
